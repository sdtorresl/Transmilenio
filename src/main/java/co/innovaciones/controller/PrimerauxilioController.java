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
import co.innovaciones.model.Primerauxilio;
import co.innovaciones.service.PrimerauxilioService;

@Controller
@RequestMapping("/primerauxilios")
public class PrimerauxilioController {

	private static final String MSG_SUCESS_INSERT = "Primerauxilio inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Primerauxilio successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Primerauxilio successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PrimerauxilioService primerauxilioService;

	@GetMapping
	public String index(Model model) {
		List<Primerauxilio> all = primerauxilioService.findAll();
		model.addAttribute("listPrimerauxilio", all);
		return "primerauxilio/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Primerauxilio> primerauxilio = primerauxilioService.findById(id);
			
			if (primerauxilio.isPresent())
				model.addAttribute("primerauxilio", primerauxilio.get());
		}
		return "primerauxilio/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Primerauxilio entity) {
		model.addAttribute("primerauxilio", entity);
		return "primerauxilio/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Primerauxilio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Primerauxilio primerauxilio = null;
		try {
			primerauxilio = primerauxilioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/primerauxilios/" + primerauxilio.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Primerauxilio> entity = primerauxilioService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("primerauxilio", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "primerauxilio/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Primerauxilio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Primerauxilio primerauxilio = null;
		try {
			primerauxilio = primerauxilioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/primerauxilios/" + primerauxilio.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Primerauxilio> entity = primerauxilioService.findById(id);
				
				if (entity.isPresent()) {
					primerauxilioService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/primerauxilios";
	}

}
