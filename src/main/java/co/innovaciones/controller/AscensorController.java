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
import co.innovaciones.model.Ascensor;
import co.innovaciones.service.AscensorService;

@Controller
@RequestMapping("/ascensors")
public class AscensorController {

	private static final String MSG_SUCESS_INSERT = "Ascensor inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Ascensor successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Ascensor successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private AscensorService ascensorService;

	@GetMapping
	public String index(Model model) {
		List<Ascensor> all = ascensorService.findAll();
		model.addAttribute("listAscensor", all);
		return "ascensor/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Ascensor> ascensor = ascensorService.findById(id);
			
			if (ascensor.isPresent())
				model.addAttribute("ascensor", ascensor.get());
		}
		return "ascensor/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Ascensor entity) {
		model.addAttribute("ascensor", entity);
		return "ascensor/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Ascensor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ascensor ascensor = null;
		try {
			ascensor = ascensorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ascensors/" + ascensor.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Ascensor> entity = ascensorService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("ascensor", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "ascensor/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Ascensor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ascensor ascensor = null;
		try {
			ascensor = ascensorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ascensors/" + ascensor.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Ascensor> entity = ascensorService.findById(id);
				
				if (entity.isPresent()) {
					ascensorService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/ascensors";
	}

}
