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
import co.innovaciones.model.Altavoz;
import co.innovaciones.service.AltavozService;

@Controller
@RequestMapping("/altavozs")
public class AltavozController {

	private static final String MSG_SUCESS_INSERT = "Altavoz inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Altavoz successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Altavoz successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private AltavozService altavozService;

	@GetMapping
	public String index(Model model) {
		List<Altavoz> all = altavozService.findAll();
		model.addAttribute("listAltavoz", all);
		return "altavoz/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Altavoz> altavoz = altavozService.findById(id);
			
			if (altavoz.isPresent())
				model.addAttribute("altavoz", altavoz.get());
		}
		return "altavoz/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Altavoz entity) {
		model.addAttribute("altavoz", entity);
		return "altavoz/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Altavoz entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Altavoz altavoz = null;
		try {
			altavoz = altavozService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/altavozs/" + altavoz.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Altavoz> entity = altavozService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("altavoz", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "altavoz/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Altavoz entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Altavoz altavoz = null;
		try {
			altavoz = altavozService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/altavozs/" + altavoz.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Altavoz> entity = altavozService.findById(id);
				
				if (entity.isPresent()) {
					altavozService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/altavozs";
	}

}
