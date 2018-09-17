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
import co.innovaciones.model.Taquilla;
import co.innovaciones.service.TaquillaService;

@Controller
@RequestMapping("/taquillas")
public class TaquillaController {

	private static final String MSG_SUCESS_INSERT = "Taquilla inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Taquilla successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Taquilla successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TaquillaService taquillaService;

	@GetMapping
	public String index(Model model) {
		List<Taquilla> all = taquillaService.findAll();
		model.addAttribute("listTaquilla", all);
		return "taquilla/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Taquilla> taquilla = taquillaService.findById(id);
			
			if (taquilla.isPresent())
				model.addAttribute("taquilla", taquilla.get());
		}
		return "taquilla/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Taquilla entity) {
		model.addAttribute("taquilla", entity);
		return "taquilla/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Taquilla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Taquilla taquilla = null;
		try {
			taquilla = taquillaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/taquillas/" + taquilla.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Taquilla> entity = taquillaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("taquilla", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "taquilla/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Taquilla entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Taquilla taquilla = null;
		try {
			taquilla = taquillaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/taquillas/" + taquilla.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Taquilla> entity = taquillaService.findById(id);
				
				if (entity.isPresent()) {
					taquillaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/taquillas";
	}

}
