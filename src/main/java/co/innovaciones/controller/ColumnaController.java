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
import co.innovaciones.model.Columna;
import co.innovaciones.service.ColumnaService;

@Controller
@RequestMapping("/columnas")
public class ColumnaController {

	private static final String MSG_SUCESS_INSERT = "Columna inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Columna successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Columna successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ColumnaService columnaService;

	@GetMapping
	public String index(Model model) {
		List<Columna> all = columnaService.findAll();
		model.addAttribute("listColumna", all);
		return "columna/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Columna> columna = columnaService.findById(id);
			
			if (columna.isPresent())
				model.addAttribute("columna", columna.get());
		}
		return "columna/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Columna entity) {
		model.addAttribute("columna", entity);
		return "columna/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Columna entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Columna columna = null;
		try {
			columna = columnaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/columnas/" + columna.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Columna> entity = columnaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("columna", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "columna/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Columna entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Columna columna = null;
		try {
			columna = columnaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/columnas/" + columna.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Columna> entity = columnaService.findById(id);
				
				if (entity.isPresent()) {
					columnaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/columnas";
	}

}
