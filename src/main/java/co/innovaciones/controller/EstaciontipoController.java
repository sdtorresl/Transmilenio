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
import co.innovaciones.model.Estaciontipo;
import co.innovaciones.service.EstaciontipoService;

@Controller
@RequestMapping("/estaciontipos")
public class EstaciontipoController {

	private static final String MSG_SUCESS_INSERT = "Estaciontipo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Estaciontipo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Estaciontipo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EstaciontipoService estaciontipoService;

	@GetMapping
	public String index(Model model) {
		List<Estaciontipo> all = estaciontipoService.findAll();
		model.addAttribute("listEstaciontipo", all);
		return "estaciontipo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Estaciontipo> estaciontipo = estaciontipoService.findById(id);
			
			if (estaciontipo.isPresent())
				model.addAttribute("estaciontipo", estaciontipo.get());
		}
		return "estaciontipo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Estaciontipo entity) {
		model.addAttribute("estaciontipo", entity);
		return "estaciontipo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Estaciontipo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Estaciontipo estaciontipo = null;
		try {
			estaciontipo = estaciontipoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/estaciontipos/" + estaciontipo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Estaciontipo> entity = estaciontipoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("estaciontipo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "estaciontipo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Estaciontipo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Estaciontipo estaciontipo = null;
		try {
			estaciontipo = estaciontipoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/estaciontipos/" + estaciontipo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Estaciontipo> entity = estaciontipoService.findById(id);
				
				if (entity.isPresent()) {
					estaciontipoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/estaciontipos";
	}

}
