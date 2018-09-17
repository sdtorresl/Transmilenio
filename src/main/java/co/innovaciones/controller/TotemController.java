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
import co.innovaciones.model.Totem;
import co.innovaciones.service.TotemService;

@Controller
@RequestMapping("/totems")
public class TotemController {

	private static final String MSG_SUCESS_INSERT = "Totem inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Totem successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Totem successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TotemService totemService;

	@GetMapping
	public String index(Model model) {
		List<Totem> all = totemService.findAll();
		model.addAttribute("listTotem", all);
		return "totem/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Totem> totem = totemService.findById(id);
			
			if (totem.isPresent())
				model.addAttribute("totem", totem.get());
		}
		return "totem/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Totem entity) {
		model.addAttribute("totem", entity);
		return "totem/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Totem entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Totem totem = null;
		try {
			totem = totemService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/totems/" + totem.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Totem> entity = totemService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("totem", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "totem/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Totem entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Totem totem = null;
		try {
			totem = totemService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/totems/" + totem.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Totem> entity = totemService.findById(id);
				
				if (entity.isPresent()) {
					totemService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/totems";
	}

}
