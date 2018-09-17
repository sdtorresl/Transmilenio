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
import co.innovaciones.model.Planta;
import co.innovaciones.service.PlantaService;

@Controller
@RequestMapping("/plantas")
public class PlantaController {

	private static final String MSG_SUCESS_INSERT = "Planta inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Planta successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Planta successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PlantaService plantaService;

	@GetMapping
	public String index(Model model) {
		List<Planta> all = plantaService.findAll();
		model.addAttribute("listPlanta", all);
		return "planta/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Planta> planta = plantaService.findById(id);
			
			if (planta.isPresent())
				model.addAttribute("planta", planta.get());
		}
		return "planta/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Planta entity) {
		model.addAttribute("planta", entity);
		return "planta/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Planta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Planta planta = null;
		try {
			planta = plantaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/plantas/" + planta.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Planta> entity = plantaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("planta", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "planta/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Planta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Planta planta = null;
		try {
			planta = plantaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/plantas/" + planta.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Planta> entity = plantaService.findById(id);
				
				if (entity.isPresent()) {
					plantaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/plantas";
	}

}
