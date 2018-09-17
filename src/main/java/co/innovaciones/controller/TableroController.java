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
import co.innovaciones.model.Tablero;
import co.innovaciones.service.TableroService;

@Controller
@RequestMapping("/tableros")
public class TableroController {

	private static final String MSG_SUCESS_INSERT = "Tablero inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Tablero successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Tablero successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TableroService tableroService;

	@GetMapping
	public String index(Model model) {
		List<Tablero> all = tableroService.findAll();
		model.addAttribute("listTablero", all);
		return "tablero/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Tablero> tablero = tableroService.findById(id);
			
			if (tablero.isPresent())
				model.addAttribute("tablero", tablero.get());
		}
		return "tablero/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Tablero entity) {
		model.addAttribute("tablero", entity);
		return "tablero/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Tablero entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Tablero tablero = null;
		try {
			tablero = tableroService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/tableros/" + tablero.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Tablero> entity = tableroService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("tablero", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "tablero/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Tablero entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Tablero tablero = null;
		try {
			tablero = tableroService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/tableros/" + tablero.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Tablero> entity = tableroService.findById(id);
				
				if (entity.isPresent()) {
					tableroService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/tableros";
	}

}
