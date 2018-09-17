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
import co.innovaciones.model.Parque;
import co.innovaciones.service.ParqueService;

@Controller
@RequestMapping("/parques")
public class ParqueController {

	private static final String MSG_SUCESS_INSERT = "Parque inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Parque successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Parque successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ParqueService parqueService;

	@GetMapping
	public String index(Model model) {
		List<Parque> all = parqueService.findAll();
		model.addAttribute("listParque", all);
		return "parque/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Parque> parque = parqueService.findById(id);
			
			if (parque.isPresent())
				model.addAttribute("parque", parque.get());
		}
		return "parque/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Parque entity) {
		model.addAttribute("parque", entity);
		return "parque/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Parque entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Parque parque = null;
		try {
			parque = parqueService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/parques/" + parque.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Parque> entity = parqueService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("parque", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "parque/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Parque entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Parque parque = null;
		try {
			parque = parqueService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/parques/" + parque.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Parque> entity = parqueService.findById(id);
				
				if (entity.isPresent()) {
					parqueService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/parques";
	}

}
