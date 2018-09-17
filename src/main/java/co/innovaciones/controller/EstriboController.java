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
import co.innovaciones.model.Estribo;
import co.innovaciones.service.EstriboService;

@Controller
@RequestMapping("/estribos")
public class EstriboController {

	private static final String MSG_SUCESS_INSERT = "Estribo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Estribo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Estribo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EstriboService estriboService;

	@GetMapping
	public String index(Model model) {
		List<Estribo> all = estriboService.findAll();
		model.addAttribute("listEstribo", all);
		return "estribo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Estribo> estribo = estriboService.findById(id);
			
			if (estribo.isPresent())
				model.addAttribute("estribo", estribo.get());
		}
		return "estribo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Estribo entity) {
		model.addAttribute("estribo", entity);
		return "estribo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Estribo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Estribo estribo = null;
		try {
			estribo = estriboService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/estribos/" + estribo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Estribo> entity = estriboService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("estribo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "estribo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Estribo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Estribo estribo = null;
		try {
			estribo = estriboService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/estribos/" + estribo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Estribo> entity = estriboService.findById(id);
				
				if (entity.isPresent()) {
					estriboService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/estribos";
	}

}
