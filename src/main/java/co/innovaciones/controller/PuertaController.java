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
import co.innovaciones.model.Puerta;
import co.innovaciones.service.PuertaService;

@Controller
@RequestMapping("/puertas")
public class PuertaController {

	private static final String MSG_SUCESS_INSERT = "Puerta inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Puerta successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Puerta successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PuertaService puertaService;

	@GetMapping
	public String index(Model model) {
		List<Puerta> all = puertaService.findAll();
		model.addAttribute("listPuerta", all);
		return "puerta/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Puerta> puerta = puertaService.findById(id);
			
			if (puerta.isPresent())
				model.addAttribute("puerta", puerta.get());
		}
		return "puerta/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Puerta entity) {
		model.addAttribute("puerta", entity);
		return "puerta/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Puerta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puerta puerta = null;
		try {
			puerta = puertaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puertas/" + puerta.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Puerta> entity = puertaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("puerta", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "puerta/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Puerta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puerta puerta = null;
		try {
			puerta = puertaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puertas/" + puerta.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Puerta> entity = puertaService.findById(id);
				
				if (entity.isPresent()) {
					puertaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/puertas";
	}

}
