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
import co.innovaciones.model.Entrada;
import co.innovaciones.service.EntradaService;

@Controller
@RequestMapping("/entradas")
public class EntradaController {

	private static final String MSG_SUCESS_INSERT = "Entrada inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Entrada successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Entrada successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EntradaService entradaService;

	@GetMapping
	public String index(Model model) {
		List<Entrada> all = entradaService.findAll();
		model.addAttribute("listEntrada", all);
		return "entrada/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Entrada> entrada = entradaService.findById(id);
			
			if (entrada.isPresent())
				model.addAttribute("entrada", entrada.get());
		}
		return "entrada/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Entrada entity) {
		model.addAttribute("entrada", entity);
		return "entrada/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Entrada entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Entrada entrada = null;
		try {
			entrada = entradaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/entradas/" + entrada.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Entrada> entity = entradaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("entrada", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "entrada/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Entrada entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Entrada entrada = null;
		try {
			entrada = entradaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/entradas/" + entrada.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Entrada> entity = entradaService.findById(id);
				
				if (entity.isPresent()) {
					entradaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/entradas";
	}

}
