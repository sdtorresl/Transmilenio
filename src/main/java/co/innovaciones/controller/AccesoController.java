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
import co.innovaciones.model.Acceso;
import co.innovaciones.service.AccesoService;

@Controller
@RequestMapping("/accesos")
public class AccesoController {

	private static final String MSG_SUCESS_INSERT = "Acceso inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Acceso successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Acceso successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private AccesoService accesoService;

	@GetMapping
	public String index(Model model) {
		List<Acceso> all = accesoService.findAll();
		model.addAttribute("listAcceso", all);
		return "acceso/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Acceso> acceso = accesoService.findById(id);
			
			if (acceso.isPresent())
				model.addAttribute("acceso", acceso.get());
		}
		return "acceso/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Acceso entity) {
		model.addAttribute("acceso", entity);
		return "acceso/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Acceso entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Acceso acceso = null;
		try {
			acceso = accesoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/accesos/" + acceso.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Acceso> entity = accesoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("acceso", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "acceso/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Acceso entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Acceso acceso = null;
		try {
			acceso = accesoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/accesos/" + acceso.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Acceso> entity = accesoService.findById(id);
				
				if (entity.isPresent()) {
					accesoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/accesos";
	}

}
