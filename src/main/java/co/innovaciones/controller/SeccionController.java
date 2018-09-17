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
import co.innovaciones.model.Seccion;
import co.innovaciones.service.SeccionService;

@Controller
@RequestMapping("/seccions")
public class SeccionController {

	private static final String MSG_SUCESS_INSERT = "Seccion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Seccion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Seccion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SeccionService seccionService;

	@GetMapping
	public String index(Model model) {
		List<Seccion> all = seccionService.findAll();
		model.addAttribute("listSeccion", all);
		return "seccion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Seccion> seccion = seccionService.findById(id);
			
			if (seccion.isPresent())
				model.addAttribute("seccion", seccion.get());
		}
		return "seccion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Seccion entity) {
		model.addAttribute("seccion", entity);
		return "seccion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Seccion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Seccion seccion = null;
		try {
			seccion = seccionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/seccions/" + seccion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Seccion> entity = seccionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("seccion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "seccion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Seccion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Seccion seccion = null;
		try {
			seccion = seccionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/seccions/" + seccion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Seccion> entity = seccionService.findById(id);
				
				if (entity.isPresent()) {
					seccionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/seccions";
	}

}
