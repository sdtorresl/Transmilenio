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
import co.innovaciones.model.ReStringida;
import co.innovaciones.service.ReStringidaService;

@Controller
@RequestMapping("/restringidas")
public class ReStringidaController {

	private static final String MSG_SUCESS_INSERT = "ReStringida inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "ReStringida successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted ReStringida successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ReStringidaService restringidaService;

	@GetMapping
	public String index(Model model) {
		List<ReStringida> all = restringidaService.findAll();
		model.addAttribute("listReStringida", all);
		return "restringida/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<ReStringida> restringida = restringidaService.findById(id);
			
			if (restringida.isPresent())
				model.addAttribute("restringida", restringida.get());
		}
		return "restringida/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute ReStringida entity) {
		model.addAttribute("restringida", entity);
		return "restringida/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute ReStringida entity, BindingResult result, RedirectAttributes redirectAttributes) {
		ReStringida restringida = null;
		try {
			restringida = restringidaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/restringidas/" + restringida.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<ReStringida> entity = restringidaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("restringida", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "restringida/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute ReStringida entity, BindingResult result, RedirectAttributes redirectAttributes) {
		ReStringida restringida = null;
		try {
			restringida = restringidaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/restringidas/" + restringida.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<ReStringida> entity = restringidaService.findById(id);
				
				if (entity.isPresent()) {
					restringidaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/restringidas";
	}

}
