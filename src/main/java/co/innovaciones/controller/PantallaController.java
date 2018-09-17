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
import co.innovaciones.model.Pantalla;
import co.innovaciones.service.PantallaService;

@Controller
@RequestMapping("/pantallas")
public class PantallaController {

	private static final String MSG_SUCESS_INSERT = "Pantalla inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Pantalla successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Pantalla successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PantallaService pantallaService;

	@GetMapping
	public String index(Model model) {
		List<Pantalla> all = pantallaService.findAll();
		model.addAttribute("listPantalla", all);
		return "pantalla/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Pantalla> pantalla = pantallaService.findById(id);
			
			if (pantalla.isPresent())
				model.addAttribute("pantalla", pantalla.get());
		}
		return "pantalla/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Pantalla entity) {
		model.addAttribute("pantalla", entity);
		return "pantalla/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Pantalla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pantalla pantalla = null;
		try {
			pantalla = pantallaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pantallas/" + pantalla.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Pantalla> entity = pantallaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("pantalla", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "pantalla/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Pantalla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pantalla pantalla = null;
		try {
			pantalla = pantallaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pantallas/" + pantalla.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Pantalla> entity = pantallaService.findById(id);
				
				if (entity.isPresent()) {
					pantallaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/pantallas";
	}

}
