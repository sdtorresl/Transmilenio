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
import co.innovaciones.model.Portamapa;
import co.innovaciones.service.PortamapaService;

@Controller
@RequestMapping("/portamapas")
public class PortamapaController {

	private static final String MSG_SUCESS_INSERT = "Portamapa inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Portamapa successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Portamapa successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PortamapaService portamapaService;

	@GetMapping
	public String index(Model model) {
		List<Portamapa> all = portamapaService.findAll();
		model.addAttribute("listPortamapa", all);
		return "portamapa/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Portamapa> portamapa = portamapaService.findById(id);
			
			if (portamapa.isPresent())
				model.addAttribute("portamapa", portamapa.get());
		}
		return "portamapa/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Portamapa entity) {
		model.addAttribute("portamapa", entity);
		return "portamapa/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Portamapa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Portamapa portamapa = null;
		try {
			portamapa = portamapaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/portamapas/" + portamapa.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Portamapa> entity = portamapaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("portamapa", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "portamapa/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Portamapa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Portamapa portamapa = null;
		try {
			portamapa = portamapaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/portamapas/" + portamapa.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Portamapa> entity = portamapaService.findById(id);
				
				if (entity.isPresent()) {
					portamapaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/portamapas";
	}

}
