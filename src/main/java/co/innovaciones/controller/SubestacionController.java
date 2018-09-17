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
import co.innovaciones.model.Subestacion;
import co.innovaciones.service.SubestacionService;

@Controller
@RequestMapping("/subestacions")
public class SubestacionController {

	private static final String MSG_SUCESS_INSERT = "Subestacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Subestacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Subestacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SubestacionService subestacionService;

	@GetMapping
	public String index(Model model) {
		List<Subestacion> all = subestacionService.findAll();
		model.addAttribute("listSubestacion", all);
		return "subestacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Subestacion> subestacion = subestacionService.findById(id);
			
			if (subestacion.isPresent())
				model.addAttribute("subestacion", subestacion.get());
		}
		return "subestacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Subestacion entity) {
		model.addAttribute("subestacion", entity);
		return "subestacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Subestacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Subestacion subestacion = null;
		try {
			subestacion = subestacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/subestacions/" + subestacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Subestacion> entity = subestacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("subestacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "subestacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Subestacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Subestacion subestacion = null;
		try {
			subestacion = subestacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/subestacions/" + subestacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Subestacion> entity = subestacionService.findById(id);
				
				if (entity.isPresent()) {
					subestacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/subestacions";
	}

}
