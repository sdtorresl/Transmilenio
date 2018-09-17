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
import co.innovaciones.model.Puertatroncal;
import co.innovaciones.service.PuertatroncalService;

@Controller
@RequestMapping("/puertatroncals")
public class PuertatroncalController {

	private static final String MSG_SUCESS_INSERT = "Puertatroncal inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Puertatroncal successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Puertatroncal successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PuertatroncalService puertatroncalService;

	@GetMapping
	public String index(Model model) {
		List<Puertatroncal> all = puertatroncalService.findAll();
		model.addAttribute("listPuertatroncal", all);
		return "puertatroncal/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Puertatroncal> puertatroncal = puertatroncalService.findById(id);
			
			if (puertatroncal.isPresent())
				model.addAttribute("puertatroncal", puertatroncal.get());
		}
		return "puertatroncal/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Puertatroncal entity) {
		model.addAttribute("puertatroncal", entity);
		return "puertatroncal/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Puertatroncal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puertatroncal puertatroncal = null;
		try {
			puertatroncal = puertatroncalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puertatroncals/" + puertatroncal.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Puertatroncal> entity = puertatroncalService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("puertatroncal", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "puertatroncal/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Puertatroncal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puertatroncal puertatroncal = null;
		try {
			puertatroncal = puertatroncalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puertatroncals/" + puertatroncal.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Puertatroncal> entity = puertatroncalService.findById(id);
				
				if (entity.isPresent()) {
					puertatroncalService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/puertatroncals";
	}

}
