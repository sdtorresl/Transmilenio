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
import co.innovaciones.model.Ventanillavagon;
import co.innovaciones.service.VentanillavagonService;

@Controller
@RequestMapping("/ventanillavagons")
public class VentanillavagonController {

	private static final String MSG_SUCESS_INSERT = "Ventanillavagon inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Ventanillavagon successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Ventanillavagon successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private VentanillavagonService ventanillavagonService;

	@GetMapping
	public String index(Model model) {
		List<Ventanillavagon> all = ventanillavagonService.findAll();
		model.addAttribute("listVentanillavagon", all);
		return "ventanillavagon/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Ventanillavagon> ventanillavagon = ventanillavagonService.findById(id);
			
			if (ventanillavagon.isPresent())
				model.addAttribute("ventanillavagon", ventanillavagon.get());
		}
		return "ventanillavagon/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Ventanillavagon entity) {
		model.addAttribute("ventanillavagon", entity);
		return "ventanillavagon/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Ventanillavagon entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ventanillavagon ventanillavagon = null;
		try {
			ventanillavagon = ventanillavagonService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ventanillavagons/" + ventanillavagon.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Ventanillavagon> entity = ventanillavagonService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("ventanillavagon", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "ventanillavagon/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Ventanillavagon entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ventanillavagon ventanillavagon = null;
		try {
			ventanillavagon = ventanillavagonService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ventanillavagons/" + ventanillavagon.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Ventanillavagon> entity = ventanillavagonService.findById(id);
				
				if (entity.isPresent()) {
					ventanillavagonService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/ventanillavagons";
	}

}
