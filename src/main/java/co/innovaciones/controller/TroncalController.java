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
import co.innovaciones.model.Troncal;
import co.innovaciones.service.TroncalService;

@Controller
@RequestMapping("/troncals")
public class TroncalController {

	private static final String MSG_SUCESS_INSERT = "Troncal inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Troncal successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Troncal successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TroncalService troncalService;

	@GetMapping
	public String index(Model model) {
		List<Troncal> all = troncalService.findAll();
		model.addAttribute("listTroncal", all);
		return "troncal/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Troncal> troncal = troncalService.findById(id);
			
			if (troncal.isPresent())
				model.addAttribute("troncal", troncal.get());
		}
		return "troncal/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Troncal entity) {
		model.addAttribute("troncal", entity);
		return "troncal/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Troncal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Troncal troncal = null;
		try {
			troncal = troncalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/troncals/" + troncal.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Troncal> entity = troncalService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("troncal", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "troncal/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Troncal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Troncal troncal = null;
		try {
			troncal = troncalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/troncals/" + troncal.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Troncal> entity = troncalService.findById(id);
				
				if (entity.isPresent()) {
					troncalService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/troncals";
	}

}
