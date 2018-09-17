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
import co.innovaciones.model.Estacion;
import co.innovaciones.service.EstacionService;

@Controller
@RequestMapping("/estaciones")
public class EstacionController {

	private static final String MSG_SUCESS_INSERT = "Estacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Estacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Estacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EstacionService estacionService;

	@GetMapping
	public String index(Model model) {
		List<Estacion> all = estacionService.findAll();
		model.addAttribute("listEstacion", all);
		return "estacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Estacion> estacion = estacionService.findById(id);
			
			if (estacion.isPresent())
				model.addAttribute("estacion", estacion.get());
		}
		return "estacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Estacion entity) {
		model.addAttribute("estacion", entity);
		return "estacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Estacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Estacion estacion = null;
		try {
			estacion = estacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/estacions/" + estacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Estacion> entity = estacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("estacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "estacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Estacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Estacion estacion = null;
		try {
			estacion = estacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/estacions/" + estacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Estacion> entity = estacionService.findById(id);
				
				if (entity.isPresent()) {
					estacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/estacions";
	}

}
