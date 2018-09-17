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
import co.innovaciones.model.Barandaentrada;
import co.innovaciones.service.BarandaentradaService;

@Controller
@RequestMapping("/barandaentradas")
public class BarandaentradaController {

	private static final String MSG_SUCESS_INSERT = "Barandaentrada inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Barandaentrada successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Barandaentrada successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BarandaentradaService barandaentradaService;

	@GetMapping
	public String index(Model model) {
		List<Barandaentrada> all = barandaentradaService.findAll();
		model.addAttribute("listBarandaentrada", all);
		return "barandaentrada/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Barandaentrada> barandaentrada = barandaentradaService.findById(id);
			
			if (barandaentrada.isPresent())
				model.addAttribute("barandaentrada", barandaentrada.get());
		}
		return "barandaentrada/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Barandaentrada entity) {
		model.addAttribute("barandaentrada", entity);
		return "barandaentrada/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Barandaentrada entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Barandaentrada barandaentrada = null;
		try {
			barandaentrada = barandaentradaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/barandaentradas/" + barandaentrada.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Barandaentrada> entity = barandaentradaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("barandaentrada", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "barandaentrada/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Barandaentrada entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Barandaentrada barandaentrada = null;
		try {
			barandaentrada = barandaentradaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/barandaentradas/" + barandaentrada.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Barandaentrada> entity = barandaentradaService.findById(id);
				
				if (entity.isPresent()) {
					barandaentradaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/barandaentradas";
	}

}
