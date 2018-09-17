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
import co.innovaciones.model.Iluminacion;
import co.innovaciones.service.IluminacionService;

@Controller
@RequestMapping("/iluminacions")
public class IluminacionController {

	private static final String MSG_SUCESS_INSERT = "Iluminacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Iluminacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Iluminacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private IluminacionService iluminacionService;

	@GetMapping
	public String index(Model model) {
		List<Iluminacion> all = iluminacionService.findAll();
		model.addAttribute("listIluminacion", all);
		return "iluminacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Iluminacion> iluminacion = iluminacionService.findById(id);
			
			if (iluminacion.isPresent())
				model.addAttribute("iluminacion", iluminacion.get());
		}
		return "iluminacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Iluminacion entity) {
		model.addAttribute("iluminacion", entity);
		return "iluminacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Iluminacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Iluminacion iluminacion = null;
		try {
			iluminacion = iluminacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/iluminacions/" + iluminacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Iluminacion> entity = iluminacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("iluminacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "iluminacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Iluminacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Iluminacion iluminacion = null;
		try {
			iluminacion = iluminacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/iluminacions/" + iluminacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Iluminacion> entity = iluminacionService.findById(id);
				
				if (entity.isPresent()) {
					iluminacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/iluminacions";
	}

}
