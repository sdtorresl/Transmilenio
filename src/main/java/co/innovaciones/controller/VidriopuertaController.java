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
import co.innovaciones.model.Vidriopuerta;
import co.innovaciones.service.VidriopuertaService;

@Controller
@RequestMapping("/vidriopuertas")
public class VidriopuertaController {

	private static final String MSG_SUCESS_INSERT = "Vidriopuerta inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Vidriopuerta successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Vidriopuerta successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private VidriopuertaService vidriopuertaService;

	@GetMapping
	public String index(Model model) {
		List<Vidriopuerta> all = vidriopuertaService.findAll();
		model.addAttribute("listVidriopuerta", all);
		return "vidriopuerta/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Vidriopuerta> vidriopuerta = vidriopuertaService.findById(id);
			
			if (vidriopuerta.isPresent())
				model.addAttribute("vidriopuerta", vidriopuerta.get());
		}
		return "vidriopuerta/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Vidriopuerta entity) {
		model.addAttribute("vidriopuerta", entity);
		return "vidriopuerta/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Vidriopuerta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vidriopuerta vidriopuerta = null;
		try {
			vidriopuerta = vidriopuertaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vidriopuertas/" + vidriopuerta.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Vidriopuerta> entity = vidriopuertaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("vidriopuerta", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "vidriopuerta/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Vidriopuerta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vidriopuerta vidriopuerta = null;
		try {
			vidriopuerta = vidriopuertaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vidriopuertas/" + vidriopuerta.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Vidriopuerta> entity = vidriopuertaService.findById(id);
				
				if (entity.isPresent()) {
					vidriopuertaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/vidriopuertas";
	}

}
