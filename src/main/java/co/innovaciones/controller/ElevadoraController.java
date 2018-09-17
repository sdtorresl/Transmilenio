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
import co.innovaciones.model.Elevadora;
import co.innovaciones.service.ElevadoraService;

@Controller
@RequestMapping("/elevadoras")
public class ElevadoraController {

	private static final String MSG_SUCESS_INSERT = "Elevadora inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Elevadora successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Elevadora successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ElevadoraService elevadoraService;

	@GetMapping
	public String index(Model model) {
		List<Elevadora> all = elevadoraService.findAll();
		model.addAttribute("listElevadora", all);
		return "elevadora/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Elevadora> elevadora = elevadoraService.findById(id);
			
			if (elevadora.isPresent())
				model.addAttribute("elevadora", elevadora.get());
		}
		return "elevadora/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Elevadora entity) {
		model.addAttribute("elevadora", entity);
		return "elevadora/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Elevadora entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Elevadora elevadora = null;
		try {
			elevadora = elevadoraService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/elevadoras/" + elevadora.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Elevadora> entity = elevadoraService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("elevadora", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "elevadora/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Elevadora entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Elevadora elevadora = null;
		try {
			elevadora = elevadoraService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/elevadoras/" + elevadora.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Elevadora> entity = elevadoraService.findById(id);
				
				if (entity.isPresent()) {
					elevadoraService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/elevadoras";
	}

}
