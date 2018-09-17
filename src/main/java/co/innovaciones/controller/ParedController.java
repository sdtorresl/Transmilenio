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
import co.innovaciones.model.Pared;
import co.innovaciones.service.ParedService;

@Controller
@RequestMapping("/pareds")
public class ParedController {

	private static final String MSG_SUCESS_INSERT = "Pared inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Pared successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Pared successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ParedService paredService;

	@GetMapping
	public String index(Model model) {
		List<Pared> all = paredService.findAll();
		model.addAttribute("listPared", all);
		return "pared/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Pared> pared = paredService.findById(id);
			
			if (pared.isPresent())
				model.addAttribute("pared", pared.get());
		}
		return "pared/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Pared entity) {
		model.addAttribute("pared", entity);
		return "pared/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Pared entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pared pared = null;
		try {
			pared = paredService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pareds/" + pared.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Pared> entity = paredService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("pared", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "pared/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Pared entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pared pared = null;
		try {
			pared = paredService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pareds/" + pared.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Pared> entity = paredService.findById(id);
				
				if (entity.isPresent()) {
					paredService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/pareds";
	}

}
