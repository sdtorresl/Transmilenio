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
import co.innovaciones.model.Pisomaterial;
import co.innovaciones.service.PisomaterialService;

@Controller
@RequestMapping("/pisomaterials")
public class PisomaterialController {

	private static final String MSG_SUCESS_INSERT = "Pisomaterial inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Pisomaterial successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Pisomaterial successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PisomaterialService pisomaterialService;

	@GetMapping
	public String index(Model model) {
		List<Pisomaterial> all = pisomaterialService.findAll();
		model.addAttribute("listPisomaterial", all);
		return "pisomaterial/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Pisomaterial> pisomaterial = pisomaterialService.findById(id);
			
			if (pisomaterial.isPresent())
				model.addAttribute("pisomaterial", pisomaterial.get());
		}
		return "pisomaterial/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Pisomaterial entity) {
		model.addAttribute("pisomaterial", entity);
		return "pisomaterial/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Pisomaterial entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pisomaterial pisomaterial = null;
		try {
			pisomaterial = pisomaterialService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pisomaterials/" + pisomaterial.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Pisomaterial> entity = pisomaterialService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("pisomaterial", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "pisomaterial/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Pisomaterial entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pisomaterial pisomaterial = null;
		try {
			pisomaterial = pisomaterialService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pisomaterials/" + pisomaterial.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Pisomaterial> entity = pisomaterialService.findById(id);
				
				if (entity.isPresent()) {
					pisomaterialService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/pisomaterials";
	}

}
