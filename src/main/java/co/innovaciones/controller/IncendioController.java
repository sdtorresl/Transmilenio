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
import co.innovaciones.model.Incendio;
import co.innovaciones.service.IncendioService;

@Controller
@RequestMapping("/incendios")
public class IncendioController {

	private static final String MSG_SUCESS_INSERT = "Incendio inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Incendio successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Incendio successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private IncendioService incendioService;

	@GetMapping
	public String index(Model model) {
		List<Incendio> all = incendioService.findAll();
		model.addAttribute("listIncendio", all);
		return "incendio/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Incendio> incendio = incendioService.findById(id);
			
			if (incendio.isPresent())
				model.addAttribute("incendio", incendio.get());
		}
		return "incendio/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Incendio entity) {
		model.addAttribute("incendio", entity);
		return "incendio/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Incendio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Incendio incendio = null;
		try {
			incendio = incendioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/incendios/" + incendio.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Incendio> entity = incendioService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("incendio", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "incendio/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Incendio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Incendio incendio = null;
		try {
			incendio = incendioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/incendios/" + incendio.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Incendio> entity = incendioService.findById(id);
				
				if (entity.isPresent()) {
					incendioService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/incendios";
	}

}
