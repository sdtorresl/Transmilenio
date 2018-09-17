package co.innovaciones.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import co.innovaciones.model.Bandera;
import co.innovaciones.service.BanderaService;

@Controller
@RequestMapping("/banderas")
public class BanderaController {

	private static final String MSG_SUCESS_INSERT = "Bandera inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Bandera successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Bandera successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BanderaService banderaService;

	@GetMapping
	public String index(Model model) {
		List<Bandera> all = banderaService.findAll();
		model.addAttribute("listBandera", all);
		return "bandera/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Bandera> bandera = banderaService.findById(id);
			
			if (bandera.isPresent())
				model.addAttribute("bandera", bandera.get());
		}
		return "bandera/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Bandera entity) {
		model.addAttribute("bandera", entity);
		return "bandera/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Bandera entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Bandera bandera = null;
		try {
			bandera = banderaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/banderas/" + bandera.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Bandera> entity = banderaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("bandera", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "bandera/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Bandera entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Bandera bandera = null;
		try {
			bandera = banderaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/banderas/" + bandera.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Bandera> entity = banderaService.findById(id);
				
				if (entity.isPresent()) {
					banderaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/banderas";
	}

}
