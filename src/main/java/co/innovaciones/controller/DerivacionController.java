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
import co.innovaciones.model.Derivacion;
import co.innovaciones.service.DerivacionService;

@Controller
@RequestMapping("/derivacions")
public class DerivacionController {

	private static final String MSG_SUCESS_INSERT = "Derivacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Derivacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Derivacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private DerivacionService derivacionService;

	@GetMapping
	public String index(Model model) {
		List<Derivacion> all = derivacionService.findAll();
		model.addAttribute("listDerivacion", all);
		return "derivacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Derivacion> derivacion = derivacionService.findById(id);
			
			if (derivacion.isPresent())
				model.addAttribute("derivacion", derivacion.get());
		}
		return "derivacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Derivacion entity) {
		model.addAttribute("derivacion", entity);
		return "derivacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Derivacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Derivacion derivacion = null;
		try {
			derivacion = derivacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/derivacions/" + derivacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Derivacion> entity = derivacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("derivacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "derivacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Derivacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Derivacion derivacion = null;
		try {
			derivacion = derivacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/derivacions/" + derivacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Derivacion> entity = derivacionService.findById(id);
				
				if (entity.isPresent()) {
					derivacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/derivacions";
	}

}
