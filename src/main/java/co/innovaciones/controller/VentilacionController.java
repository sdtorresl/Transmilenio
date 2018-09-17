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
import co.innovaciones.model.Ventilacion;
import co.innovaciones.service.VentilacionService;

@Controller
@RequestMapping("/ventilacions")
public class VentilacionController {

	private static final String MSG_SUCESS_INSERT = "Ventilacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Ventilacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Ventilacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private VentilacionService ventilacionService;

	@GetMapping
	public String index(Model model) {
		List<Ventilacion> all = ventilacionService.findAll();
		model.addAttribute("listVentilacion", all);
		return "ventilacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Ventilacion> ventilacion = ventilacionService.findById(id);
			
			if (ventilacion.isPresent())
				model.addAttribute("ventilacion", ventilacion.get());
		}
		return "ventilacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Ventilacion entity) {
		model.addAttribute("ventilacion", entity);
		return "ventilacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Ventilacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ventilacion ventilacion = null;
		try {
			ventilacion = ventilacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ventilacions/" + ventilacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Ventilacion> entity = ventilacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("ventilacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "ventilacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Ventilacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ventilacion ventilacion = null;
		try {
			ventilacion = ventilacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ventilacions/" + ventilacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Ventilacion> entity = ventilacionService.findById(id);
				
				if (entity.isPresent()) {
					ventilacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/ventilacions";
	}

}
