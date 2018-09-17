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
import co.innovaciones.model.Cajeroelec;
import co.innovaciones.service.CajeroelecService;

@Controller
@RequestMapping("/cajeroelecs")
public class CajeroelecController {

	private static final String MSG_SUCESS_INSERT = "Cajeroelec inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Cajeroelec successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Cajeroelec successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CajeroelecService cajeroelecService;

	@GetMapping
	public String index(Model model) {
		List<Cajeroelec> all = cajeroelecService.findAll();
		model.addAttribute("listCajeroelec", all);
		return "cajeroelec/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Cajeroelec> cajeroelec = cajeroelecService.findById(id);
			
			if (cajeroelec.isPresent())
				model.addAttribute("cajeroelec", cajeroelec.get());
		}
		return "cajeroelec/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Cajeroelec entity) {
		model.addAttribute("cajeroelec", entity);
		return "cajeroelec/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Cajeroelec entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cajeroelec cajeroelec = null;
		try {
			cajeroelec = cajeroelecService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cajeroelecs/" + cajeroelec.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Cajeroelec> entity = cajeroelecService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("cajeroelec", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "cajeroelec/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Cajeroelec entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cajeroelec cajeroelec = null;
		try {
			cajeroelec = cajeroelecService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cajeroelecs/" + cajeroelec.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Cajeroelec> entity = cajeroelecService.findById(id);
				
				if (entity.isPresent()) {
					cajeroelecService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/cajeroelecs";
	}

}
