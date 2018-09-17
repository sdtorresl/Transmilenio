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
import co.innovaciones.model.Logo;
import co.innovaciones.service.LogoService;

@Controller
@RequestMapping("/logos")
public class LogoController {

	private static final String MSG_SUCESS_INSERT = "Logo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Logo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Logo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private LogoService logoService;

	@GetMapping
	public String index(Model model) {
		List<Logo> all = logoService.findAll();
		model.addAttribute("listLogo", all);
		return "logo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Logo> logo = logoService.findById(id);
			
			if (logo.isPresent())
				model.addAttribute("logo", logo.get());
		}
		return "logo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Logo entity) {
		model.addAttribute("logo", entity);
		return "logo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Logo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Logo logo = null;
		try {
			logo = logoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/logos/" + logo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Logo> entity = logoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("logo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "logo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Logo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Logo logo = null;
		try {
			logo = logoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/logos/" + logo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Logo> entity = logoService.findById(id);
				
				if (entity.isPresent()) {
					logoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/logos";
	}

}
