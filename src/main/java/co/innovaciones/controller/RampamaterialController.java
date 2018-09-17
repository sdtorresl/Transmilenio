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
import co.innovaciones.model.Rampamaterial;
import co.innovaciones.service.RampamaterialService;

@Controller
@RequestMapping("/rampamaterials")
public class RampamaterialController {

	private static final String MSG_SUCESS_INSERT = "Rampamaterial inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Rampamaterial successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Rampamaterial successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private RampamaterialService rampamaterialService;

	@GetMapping
	public String index(Model model) {
		List<Rampamaterial> all = rampamaterialService.findAll();
		model.addAttribute("listRampamaterial", all);
		return "rampamaterial/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Rampamaterial> rampamaterial = rampamaterialService.findById(id);
			
			if (rampamaterial.isPresent())
				model.addAttribute("rampamaterial", rampamaterial.get());
		}
		return "rampamaterial/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Rampamaterial entity) {
		model.addAttribute("rampamaterial", entity);
		return "rampamaterial/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Rampamaterial entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Rampamaterial rampamaterial = null;
		try {
			rampamaterial = rampamaterialService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/rampamaterials/" + rampamaterial.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Rampamaterial> entity = rampamaterialService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("rampamaterial", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "rampamaterial/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Rampamaterial entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Rampamaterial rampamaterial = null;
		try {
			rampamaterial = rampamaterialService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/rampamaterials/" + rampamaterial.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Rampamaterial> entity = rampamaterialService.findById(id);
				
				if (entity.isPresent()) {
					rampamaterialService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/rampamaterials";
	}

}
