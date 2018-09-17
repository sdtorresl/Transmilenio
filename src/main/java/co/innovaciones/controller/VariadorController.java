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
import co.innovaciones.model.Variador;
import co.innovaciones.service.VariadorService;

@Controller
@RequestMapping("/variadors")
public class VariadorController {

	private static final String MSG_SUCESS_INSERT = "Variador inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Variador successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Variador successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private VariadorService variadorService;

	@GetMapping
	public String index(Model model) {
		List<Variador> all = variadorService.findAll();
		model.addAttribute("listVariador", all);
		return "variador/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Variador> variador = variadorService.findById(id);
			
			if (variador.isPresent())
				model.addAttribute("variador", variador.get());
		}
		return "variador/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Variador entity) {
		model.addAttribute("variador", entity);
		return "variador/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Variador entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Variador variador = null;
		try {
			variador = variadorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/variadors/" + variador.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Variador> entity = variadorService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("variador", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "variador/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Variador entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Variador variador = null;
		try {
			variador = variadorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/variadors/" + variador.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Variador> entity = variadorService.findById(id);
				
				if (entity.isPresent()) {
					variadorService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/variadors";
	}

}
