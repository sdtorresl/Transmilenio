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
import co.innovaciones.model.Transicion;
import co.innovaciones.service.TransicionService;

@Controller
@RequestMapping("/transicions")
public class TransicionController {

	private static final String MSG_SUCESS_INSERT = "Transicion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Transicion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Transicion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TransicionService transicionService;

	@GetMapping
	public String index(Model model) {
		List<Transicion> all = transicionService.findAll();
		model.addAttribute("listTransicion", all);
		return "transicion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Transicion> transicion = transicionService.findById(id);
			
			if (transicion.isPresent())
				model.addAttribute("transicion", transicion.get());
		}
		return "transicion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Transicion entity) {
		model.addAttribute("transicion", entity);
		return "transicion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Transicion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Transicion transicion = null;
		try {
			transicion = transicionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/transicions/" + transicion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Transicion> entity = transicionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("transicion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "transicion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Transicion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Transicion transicion = null;
		try {
			transicion = transicionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/transicions/" + transicion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Transicion> entity = transicionService.findById(id);
				
				if (entity.isPresent()) {
					transicionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/transicions";
	}

}
