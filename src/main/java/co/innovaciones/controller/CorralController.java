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
import co.innovaciones.model.Corral;
import co.innovaciones.service.CorralService;

@Controller
@RequestMapping("/corrals")
public class CorralController {

	private static final String MSG_SUCESS_INSERT = "Corral inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Corral successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Corral successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CorralService corralService;

	@GetMapping
	public String index(Model model) {
		List<Corral> all = corralService.findAll();
		model.addAttribute("listCorral", all);
		return "corral/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Corral> corral = corralService.findById(id);
			
			if (corral.isPresent())
				model.addAttribute("corral", corral.get());
		}
		return "corral/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Corral entity) {
		model.addAttribute("corral", entity);
		return "corral/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Corral entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Corral corral = null;
		try {
			corral = corralService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/corrals/" + corral.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Corral> entity = corralService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("corral", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "corral/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Corral entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Corral corral = null;
		try {
			corral = corralService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/corrals/" + corral.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Corral> entity = corralService.findById(id);
				
				if (entity.isPresent()) {
					corralService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/corrals";
	}

}
