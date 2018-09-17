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
import co.innovaciones.model.Seccionestacion;
import co.innovaciones.service.SeccionestacionService;

@Controller
@RequestMapping("/seccionestacions")
public class SeccionestacionController {

	private static final String MSG_SUCESS_INSERT = "Seccionestacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Seccionestacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Seccionestacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SeccionestacionService seccionestacionService;

	@GetMapping
	public String index(Model model) {
		List<Seccionestacion> all = seccionestacionService.findAll();
		model.addAttribute("listSeccionestacion", all);
		return "seccionestacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Seccionestacion> seccionestacion = seccionestacionService.findById(id);
			
			if (seccionestacion.isPresent())
				model.addAttribute("seccionestacion", seccionestacion.get());
		}
		return "seccionestacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Seccionestacion entity) {
		model.addAttribute("seccionestacion", entity);
		return "seccionestacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Seccionestacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Seccionestacion seccionestacion = null;
		try {
			seccionestacion = seccionestacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/seccionestacions/" + seccionestacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Seccionestacion> entity = seccionestacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("seccionestacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "seccionestacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Seccionestacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Seccionestacion seccionestacion = null;
		try {
			seccionestacion = seccionestacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/seccionestacions/" + seccionestacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Seccionestacion> entity = seccionestacionService.findById(id);
				
				if (entity.isPresent()) {
					seccionestacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/seccionestacions";
	}

}
