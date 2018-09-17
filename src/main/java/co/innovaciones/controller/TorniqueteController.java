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
import co.innovaciones.model.Torniquete;
import co.innovaciones.service.TorniqueteService;

@Controller
@RequestMapping("/torniquetes")
public class TorniqueteController {

	private static final String MSG_SUCESS_INSERT = "Torniquete inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Torniquete successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Torniquete successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TorniqueteService torniqueteService;

	@GetMapping
	public String index(Model model) {
		List<Torniquete> all = torniqueteService.findAll();
		model.addAttribute("listTorniquete", all);
		return "torniquete/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Torniquete> torniquete = torniqueteService.findById(id);
			
			if (torniquete.isPresent())
				model.addAttribute("torniquete", torniquete.get());
		}
		return "torniquete/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Torniquete entity) {
		model.addAttribute("torniquete", entity);
		return "torniquete/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Torniquete entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Torniquete torniquete = null;
		try {
			torniquete = torniqueteService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/torniquetes/" + torniquete.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Torniquete> entity = torniqueteService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("torniquete", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "torniquete/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Torniquete entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Torniquete torniquete = null;
		try {
			torniquete = torniqueteService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/torniquetes/" + torniquete.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Torniquete> entity = torniqueteService.findById(id);
				
				if (entity.isPresent()) {
					torniqueteService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/torniquetes";
	}

}
