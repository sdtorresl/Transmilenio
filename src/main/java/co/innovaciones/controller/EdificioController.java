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
import co.innovaciones.model.Edificio;
import co.innovaciones.service.EdificioService;

@Controller
@RequestMapping("/edificios")
public class EdificioController {

	private static final String MSG_SUCESS_INSERT = "Edificio inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Edificio successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Edificio successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EdificioService edificioService;

	@GetMapping
	public String index(Model model) {
		List<Edificio> all = edificioService.findAll();
		model.addAttribute("listEdificio", all);
		return "edificio/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Edificio> edificio = edificioService.findById(id);
			
			if (edificio.isPresent())
				model.addAttribute("edificio", edificio.get());
		}
		return "edificio/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Edificio entity) {
		model.addAttribute("edificio", entity);
		return "edificio/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Edificio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Edificio edificio = null;
		try {
			edificio = edificioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/edificios/" + edificio.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Edificio> entity = edificioService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("edificio", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "edificio/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Edificio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Edificio edificio = null;
		try {
			edificio = edificioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/edificios/" + edificio.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Edificio> entity = edificioService.findById(id);
				
				if (entity.isPresent()) {
					edificioService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/edificios";
	}

}
