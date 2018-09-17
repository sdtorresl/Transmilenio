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
import co.innovaciones.model.Evacuacion;
import co.innovaciones.service.EvacuacionService;

@Controller
@RequestMapping("/evacuacions")
public class EvacuacionController {

	private static final String MSG_SUCESS_INSERT = "Evacuacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Evacuacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Evacuacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EvacuacionService evacuacionService;

	@GetMapping
	public String index(Model model) {
		List<Evacuacion> all = evacuacionService.findAll();
		model.addAttribute("listEvacuacion", all);
		return "evacuacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Evacuacion> evacuacion = evacuacionService.findById(id);
			
			if (evacuacion.isPresent())
				model.addAttribute("evacuacion", evacuacion.get());
		}
		return "evacuacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Evacuacion entity) {
		model.addAttribute("evacuacion", entity);
		return "evacuacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Evacuacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Evacuacion evacuacion = null;
		try {
			evacuacion = evacuacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/evacuacions/" + evacuacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Evacuacion> entity = evacuacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("evacuacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "evacuacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Evacuacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Evacuacion evacuacion = null;
		try {
			evacuacion = evacuacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/evacuacions/" + evacuacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Evacuacion> entity = evacuacionService.findById(id);
				
				if (entity.isPresent()) {
					evacuacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/evacuacions";
	}

}
