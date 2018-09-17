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
import co.innovaciones.model.Escotilla;
import co.innovaciones.service.EscotillaService;

@Controller
@RequestMapping("/escotillas")
public class EscotillaController {

	private static final String MSG_SUCESS_INSERT = "Escotilla inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Escotilla successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Escotilla successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EscotillaService escotillaService;

	@GetMapping
	public String index(Model model) {
		List<Escotilla> all = escotillaService.findAll();
		model.addAttribute("listEscotilla", all);
		return "escotilla/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Escotilla> escotilla = escotillaService.findById(id);
			
			if (escotilla.isPresent())
				model.addAttribute("escotilla", escotilla.get());
		}
		return "escotilla/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Escotilla entity) {
		model.addAttribute("escotilla", entity);
		return "escotilla/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Escotilla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Escotilla escotilla = null;
		try {
			escotilla = escotillaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/escotillas/" + escotilla.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Escotilla> entity = escotillaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("escotilla", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "escotilla/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Escotilla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Escotilla escotilla = null;
		try {
			escotilla = escotillaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/escotillas/" + escotilla.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Escotilla> entity = escotillaService.findById(id);
				
				if (entity.isPresent()) {
					escotillaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/escotillas";
	}

}
