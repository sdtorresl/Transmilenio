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
import co.innovaciones.model.Compensacion;
import co.innovaciones.service.CompensacionService;

@Controller
@RequestMapping("/compensacions")
public class CompensacionController {

	private static final String MSG_SUCESS_INSERT = "Compensacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Compensacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Compensacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CompensacionService compensacionService;

	@GetMapping
	public String index(Model model) {
		List<Compensacion> all = compensacionService.findAll();
		model.addAttribute("listCompensacion", all);
		return "compensacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Compensacion> compensacion = compensacionService.findById(id);
			
			if (compensacion.isPresent())
				model.addAttribute("compensacion", compensacion.get());
		}
		return "compensacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Compensacion entity) {
		model.addAttribute("compensacion", entity);
		return "compensacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Compensacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Compensacion compensacion = null;
		try {
			compensacion = compensacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/compensacions/" + compensacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Compensacion> entity = compensacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("compensacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "compensacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Compensacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Compensacion compensacion = null;
		try {
			compensacion = compensacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/compensacions/" + compensacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Compensacion> entity = compensacionService.findById(id);
				
				if (entity.isPresent()) {
					compensacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/compensacions";
	}

}
