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
import co.innovaciones.model.Informador;
import co.innovaciones.service.InformadorService;

@Controller
@RequestMapping("/informadors")
public class InformadorController {

	private static final String MSG_SUCESS_INSERT = "Informador inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Informador successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Informador successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private InformadorService informadorService;

	@GetMapping
	public String index(Model model) {
		List<Informador> all = informadorService.findAll();
		model.addAttribute("listInformador", all);
		return "informador/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Informador> informador = informadorService.findById(id);
			
			if (informador.isPresent())
				model.addAttribute("informador", informador.get());
		}
		return "informador/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Informador entity) {
		model.addAttribute("informador", entity);
		return "informador/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Informador entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Informador informador = null;
		try {
			informador = informadorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/informadors/" + informador.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Informador> entity = informadorService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("informador", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "informador/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Informador entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Informador informador = null;
		try {
			informador = informadorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/informadors/" + informador.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Informador> entity = informadorService.findById(id);
				
				if (entity.isPresent()) {
					informadorService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/informadors";
	}

}
