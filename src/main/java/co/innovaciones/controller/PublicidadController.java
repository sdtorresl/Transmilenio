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
import co.innovaciones.model.Publicidad;
import co.innovaciones.service.PublicidadService;

@Controller
@RequestMapping("/publicidads")
public class PublicidadController {

	private static final String MSG_SUCESS_INSERT = "Publicidad inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Publicidad successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Publicidad successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PublicidadService publicidadService;

	@GetMapping
	public String index(Model model) {
		List<Publicidad> all = publicidadService.findAll();
		model.addAttribute("listPublicidad", all);
		return "publicidad/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Publicidad> publicidad = publicidadService.findById(id);
			
			if (publicidad.isPresent())
				model.addAttribute("publicidad", publicidad.get());
		}
		return "publicidad/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Publicidad entity) {
		model.addAttribute("publicidad", entity);
		return "publicidad/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Publicidad entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Publicidad publicidad = null;
		try {
			publicidad = publicidadService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/publicidads/" + publicidad.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Publicidad> entity = publicidadService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("publicidad", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "publicidad/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Publicidad entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Publicidad publicidad = null;
		try {
			publicidad = publicidadService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/publicidads/" + publicidad.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Publicidad> entity = publicidadService.findById(id);
				
				if (entity.isPresent()) {
					publicidadService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/publicidads";
	}

}
