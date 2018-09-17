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
import co.innovaciones.model.Techo;
import co.innovaciones.service.TechoService;

@Controller
@RequestMapping("/techos")
public class TechoController {

	private static final String MSG_SUCESS_INSERT = "Techo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Techo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Techo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TechoService techoService;

	@GetMapping
	public String index(Model model) {
		List<Techo> all = techoService.findAll();
		model.addAttribute("listTecho", all);
		return "techo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Techo> techo = techoService.findById(id);
			
			if (techo.isPresent())
				model.addAttribute("techo", techo.get());
		}
		return "techo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Techo entity) {
		model.addAttribute("techo", entity);
		return "techo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Techo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Techo techo = null;
		try {
			techo = techoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/techos/" + techo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Techo> entity = techoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("techo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "techo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Techo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Techo techo = null;
		try {
			techo = techoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/techos/" + techo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Techo> entity = techoService.findById(id);
				
				if (entity.isPresent()) {
					techoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/techos";
	}

}
