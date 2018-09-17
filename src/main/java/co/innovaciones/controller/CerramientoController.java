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
import co.innovaciones.model.Cerramiento;
import co.innovaciones.service.CerramientoService;

@Controller
@RequestMapping("/cerramientos")
public class CerramientoController {

	private static final String MSG_SUCESS_INSERT = "Cerramiento inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Cerramiento successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Cerramiento successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CerramientoService cerramientoService;

	@GetMapping
	public String index(Model model) {
		List<Cerramiento> all = cerramientoService.findAll();
		model.addAttribute("listCerramiento", all);
		return "cerramiento/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Cerramiento> cerramiento = cerramientoService.findById(id);
			
			if (cerramiento.isPresent())
				model.addAttribute("cerramiento", cerramiento.get());
		}
		return "cerramiento/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Cerramiento entity) {
		model.addAttribute("cerramiento", entity);
		return "cerramiento/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Cerramiento entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cerramiento cerramiento = null;
		try {
			cerramiento = cerramientoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cerramientos/" + cerramiento.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Cerramiento> entity = cerramientoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("cerramiento", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "cerramiento/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Cerramiento entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cerramiento cerramiento = null;
		try {
			cerramiento = cerramientoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cerramientos/" + cerramiento.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Cerramiento> entity = cerramientoService.findById(id);
				
				if (entity.isPresent()) {
					cerramientoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/cerramientos";
	}

}
