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
import co.innovaciones.model.Semaforo;
import co.innovaciones.service.SemaforoService;

@Controller
@RequestMapping("/semaforos")
public class SemaforoController {

	private static final String MSG_SUCESS_INSERT = "Semaforo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Semaforo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Semaforo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SemaforoService semaforoService;

	@GetMapping
	public String index(Model model) {
		List<Semaforo> all = semaforoService.findAll();
		model.addAttribute("listSemaforo", all);
		return "semaforo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Semaforo> semaforo = semaforoService.findById(id);
			
			if (semaforo.isPresent())
				model.addAttribute("semaforo", semaforo.get());
		}
		return "semaforo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Semaforo entity) {
		model.addAttribute("semaforo", entity);
		return "semaforo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Semaforo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Semaforo semaforo = null;
		try {
			semaforo = semaforoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/semaforos/" + semaforo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Semaforo> entity = semaforoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("semaforo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "semaforo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Semaforo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Semaforo semaforo = null;
		try {
			semaforo = semaforoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/semaforos/" + semaforo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Semaforo> entity = semaforoService.findById(id);
				
				if (entity.isPresent()) {
					semaforoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/semaforos";
	}

}
