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
import co.innovaciones.model.Puente;
import co.innovaciones.service.PuenteService;

@Controller
@RequestMapping("/puentes")
public class PuenteController {

	private static final String MSG_SUCESS_INSERT = "Puente inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Puente successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Puente successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PuenteService puenteService;

	@GetMapping
	public String index(Model model) {
		List<Puente> all = puenteService.findAll();
		model.addAttribute("listPuente", all);
		return "puente/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Puente> puente = puenteService.findById(id);
			
			if (puente.isPresent())
				model.addAttribute("puente", puente.get());
		}
		return "puente/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Puente entity) {
		model.addAttribute("puente", entity);
		return "puente/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Puente entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puente puente = null;
		try {
			puente = puenteService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puentes/" + puente.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Puente> entity = puenteService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("puente", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "puente/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Puente entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puente puente = null;
		try {
			puente = puenteService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puentes/" + puente.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Puente> entity = puenteService.findById(id);
				
				if (entity.isPresent()) {
					puenteService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/puentes";
	}

}
