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
import co.innovaciones.model.Corredor;
import co.innovaciones.service.CorredorService;

@Controller
@RequestMapping("/corredors")
public class CorredorController {

	private static final String MSG_SUCESS_INSERT = "Corredor inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Corredor successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Corredor successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CorredorService corredorService;

	@GetMapping
	public String index(Model model) {
		List<Corredor> all = corredorService.findAll();
		model.addAttribute("listCorredor", all);
		return "corredor/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Corredor> corredor = corredorService.findById(id);
			
			if (corredor.isPresent())
				model.addAttribute("corredor", corredor.get());
		}
		return "corredor/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Corredor entity) {
		model.addAttribute("corredor", entity);
		return "corredor/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Corredor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Corredor corredor = null;
		try {
			corredor = corredorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/corredors/" + corredor.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Corredor> entity = corredorService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("corredor", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "corredor/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Corredor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Corredor corredor = null;
		try {
			corredor = corredorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/corredors/" + corredor.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Corredor> entity = corredorService.findById(id);
				
				if (entity.isPresent()) {
					corredorService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/corredors";
	}

}
