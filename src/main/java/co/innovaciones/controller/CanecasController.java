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
import co.innovaciones.model.Canecas;
import co.innovaciones.service.CanecasService;

@Controller
@RequestMapping("/canecass")
public class CanecasController {

	private static final String MSG_SUCESS_INSERT = "Canecas inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Canecas successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Canecas successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CanecasService canecasService;

	@GetMapping
	public String index(Model model) {
		List<Canecas> all = canecasService.findAll();
		model.addAttribute("listCanecas", all);
		return "canecas/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Canecas> canecas = canecasService.findById(id);
			
			if (canecas.isPresent())
				model.addAttribute("canecas", canecas.get());
		}
		return "canecas/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Canecas entity) {
		model.addAttribute("canecas", entity);
		return "canecas/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Canecas entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Canecas canecas = null;
		try {
			canecas = canecasService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/canecass/" + canecas.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Canecas> entity = canecasService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("canecas", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "canecas/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Canecas entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Canecas canecas = null;
		try {
			canecas = canecasService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/canecass/" + canecas.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Canecas> entity = canecasService.findById(id);
				
				if (entity.isPresent()) {
					canecasService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/canecass";
	}

}
