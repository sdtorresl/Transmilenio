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
import co.innovaciones.model.Caniles;
import co.innovaciones.service.CanilesService;

@Controller
@RequestMapping("/caniless")
public class CanilesController {

	private static final String MSG_SUCESS_INSERT = "Caniles inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Caniles successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Caniles successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CanilesService canilesService;

	@GetMapping
	public String index(Model model) {
		List<Caniles> all = canilesService.findAll();
		model.addAttribute("listCaniles", all);
		return "caniles/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Caniles> caniles = canilesService.findById(id);
			
			if (caniles.isPresent())
				model.addAttribute("caniles", caniles.get());
		}
		return "caniles/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Caniles entity) {
		model.addAttribute("caniles", entity);
		return "caniles/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Caniles entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Caniles caniles = null;
		try {
			caniles = canilesService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/caniless/" + caniles.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Caniles> entity = canilesService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("caniles", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "caniles/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Caniles entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Caniles caniles = null;
		try {
			caniles = canilesService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/caniless/" + caniles.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Caniles> entity = canilesService.findById(id);
				
				if (entity.isPresent()) {
					canilesService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/caniless";
	}

}
