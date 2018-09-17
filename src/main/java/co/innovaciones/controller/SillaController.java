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
import co.innovaciones.model.Silla;
import co.innovaciones.service.SillaService;

@Controller
@RequestMapping("/sillas")
public class SillaController {

	private static final String MSG_SUCESS_INSERT = "Silla inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Silla successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Silla successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SillaService sillaService;

	@GetMapping
	public String index(Model model) {
		List<Silla> all = sillaService.findAll();
		model.addAttribute("listSilla", all);
		return "silla/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Silla> silla = sillaService.findById(id);
			
			if (silla.isPresent())
				model.addAttribute("silla", silla.get());
		}
		return "silla/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Silla entity) {
		model.addAttribute("silla", entity);
		return "silla/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Silla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Silla silla = null;
		try {
			silla = sillaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/sillas/" + silla.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Silla> entity = sillaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("silla", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "silla/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Silla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Silla silla = null;
		try {
			silla = sillaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/sillas/" + silla.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Silla> entity = sillaService.findById(id);
				
				if (entity.isPresent()) {
					sillaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/sillas";
	}

}
