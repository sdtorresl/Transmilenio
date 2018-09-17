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
import co.innovaciones.model.Vagonoperacional;
import co.innovaciones.service.VagonoperacionalService;

@Controller
@RequestMapping("/vagonoperacionals")
public class VagonoperacionalController {

	private static final String MSG_SUCESS_INSERT = "Vagonoperacional inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Vagonoperacional successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Vagonoperacional successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private VagonoperacionalService vagonoperacionalService;

	@GetMapping
	public String index(Model model) {
		List<Vagonoperacional> all = vagonoperacionalService.findAll();
		model.addAttribute("listVagonoperacional", all);
		return "vagonoperacional/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Vagonoperacional> vagonoperacional = vagonoperacionalService.findById(id);
			
			if (vagonoperacional.isPresent())
				model.addAttribute("vagonoperacional", vagonoperacional.get());
		}
		return "vagonoperacional/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Vagonoperacional entity) {
		model.addAttribute("vagonoperacional", entity);
		return "vagonoperacional/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Vagonoperacional entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vagonoperacional vagonoperacional = null;
		try {
			vagonoperacional = vagonoperacionalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vagonoperacionals/" + vagonoperacional.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Vagonoperacional> entity = vagonoperacionalService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("vagonoperacional", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "vagonoperacional/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Vagonoperacional entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vagonoperacional vagonoperacional = null;
		try {
			vagonoperacional = vagonoperacionalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vagonoperacionals/" + vagonoperacional.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Vagonoperacional> entity = vagonoperacionalService.findById(id);
				
				if (entity.isPresent()) {
					vagonoperacionalService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/vagonoperacionals";
	}

}
