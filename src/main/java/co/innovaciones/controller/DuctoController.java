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
import co.innovaciones.model.Ducto;
import co.innovaciones.service.DuctoService;

@Controller
@RequestMapping("/ductos")
public class DuctoController {

	private static final String MSG_SUCESS_INSERT = "Ducto inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Ducto successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Ducto successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private DuctoService ductoService;

	@GetMapping
	public String index(Model model) {
		List<Ducto> all = ductoService.findAll();
		model.addAttribute("listDucto", all);
		return "ducto/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Ducto> ducto = ductoService.findById(id);
			
			if (ducto.isPresent())
				model.addAttribute("ducto", ducto.get());
		}
		return "ducto/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Ducto entity) {
		model.addAttribute("ducto", entity);
		return "ducto/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Ducto entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ducto ducto = null;
		try {
			ducto = ductoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ductos/" + ducto.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Ducto> entity = ductoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("ducto", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "ducto/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Ducto entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ducto ducto = null;
		try {
			ducto = ductoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ductos/" + ducto.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Ducto> entity = ductoService.findById(id);
				
				if (entity.isPresent()) {
					ductoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/ductos";
	}

}
