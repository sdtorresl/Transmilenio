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
import co.innovaciones.model.Bano;
import co.innovaciones.service.BanoService;

@Controller
@RequestMapping("/banos")
public class BanoController {

	private static final String MSG_SUCESS_INSERT = "Bano inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Bano successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Bano successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BanoService banoService;

	@GetMapping
	public String index(Model model) {
		List<Bano> all = banoService.findAll();
		model.addAttribute("listBano", all);
		return "bano/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Bano> bano = banoService.findById(id);
			
			if (bano.isPresent())
				model.addAttribute("bano", bano.get());
		}
		return "bano/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Bano entity) {
		model.addAttribute("bano", entity);
		return "bano/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Bano entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Bano bano = null;
		try {
			bano = banoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/banos/" + bano.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Bano> entity = banoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("bano", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "bano/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Bano entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Bano bano = null;
		try {
			bano = banoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/banos/" + bano.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Bano> entity = banoService.findById(id);
				
				if (entity.isPresent()) {
					banoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/banos";
	}

}
