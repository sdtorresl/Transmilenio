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
import co.innovaciones.model.Poste;
import co.innovaciones.service.PosteService;

@Controller
@RequestMapping("/postes")
public class PosteController {

	private static final String MSG_SUCESS_INSERT = "Poste inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Poste successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Poste successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PosteService posteService;

	@GetMapping
	public String index(Model model) {
		List<Poste> all = posteService.findAll();
		model.addAttribute("listPoste", all);
		return "poste/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Poste> poste = posteService.findById(id);
			
			if (poste.isPresent())
				model.addAttribute("poste", poste.get());
		}
		return "poste/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Poste entity) {
		model.addAttribute("poste", entity);
		return "poste/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Poste entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Poste poste = null;
		try {
			poste = posteService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/postes/" + poste.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Poste> entity = posteService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("poste", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "poste/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Poste entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Poste poste = null;
		try {
			poste = posteService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/postes/" + poste.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Poste> entity = posteService.findById(id);
				
				if (entity.isPresent()) {
					posteService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/postes";
	}

}
