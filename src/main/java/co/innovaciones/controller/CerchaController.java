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
import co.innovaciones.model.Cercha;
import co.innovaciones.service.CerchaService;

@Controller
@RequestMapping("/cerchas")
public class CerchaController {

	private static final String MSG_SUCESS_INSERT = "Cercha inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Cercha successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Cercha successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CerchaService cerchaService;

	@GetMapping
	public String index(Model model) {
		List<Cercha> all = cerchaService.findAll();
		model.addAttribute("listCercha", all);
		return "cercha/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Cercha> cercha = cerchaService.findById(id);
			
			if (cercha.isPresent())
				model.addAttribute("cercha", cercha.get());
		}
		return "cercha/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Cercha entity) {
		model.addAttribute("cercha", entity);
		return "cercha/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Cercha entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cercha cercha = null;
		try {
			cercha = cerchaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cerchas/" + cercha.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Cercha> entity = cerchaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("cercha", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "cercha/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Cercha entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cercha cercha = null;
		try {
			cercha = cerchaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cerchas/" + cercha.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Cercha> entity = cerchaService.findById(id);
				
				if (entity.isPresent()) {
					cerchaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/cerchas";
	}

}
