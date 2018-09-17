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
import co.innovaciones.model.Gamin;
import co.innovaciones.service.GaminService;

@Controller
@RequestMapping("/gamins")
public class GaminController {

	private static final String MSG_SUCESS_INSERT = "Gamin inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Gamin successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Gamin successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private GaminService gaminService;

	@GetMapping
	public String index(Model model) {
		List<Gamin> all = gaminService.findAll();
		model.addAttribute("listGamin", all);
		return "gamin/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Gamin> gamin = gaminService.findById(id);
			
			if (gamin.isPresent())
				model.addAttribute("gamin", gamin.get());
		}
		return "gamin/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Gamin entity) {
		model.addAttribute("gamin", entity);
		return "gamin/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Gamin entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Gamin gamin = null;
		try {
			gamin = gaminService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/gamins/" + gamin.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Gamin> entity = gaminService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("gamin", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "gamin/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Gamin entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Gamin gamin = null;
		try {
			gamin = gaminService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/gamins/" + gamin.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Gamin> entity = gaminService.findById(id);
				
				if (entity.isPresent()) {
					gaminService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/gamins";
	}

}
