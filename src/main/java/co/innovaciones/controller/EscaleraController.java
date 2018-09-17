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
import co.innovaciones.model.Escalera;
import co.innovaciones.service.EscaleraService;

@Controller
@RequestMapping("/escaleras")
public class EscaleraController {

	private static final String MSG_SUCESS_INSERT = "Escalera inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Escalera successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Escalera successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EscaleraService escaleraService;

	@GetMapping
	public String index(Model model) {
		List<Escalera> all = escaleraService.findAll();
		model.addAttribute("listEscalera", all);
		return "escalera/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Escalera> escalera = escaleraService.findById(id);
			
			if (escalera.isPresent())
				model.addAttribute("escalera", escalera.get());
		}
		return "escalera/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Escalera entity) {
		model.addAttribute("escalera", entity);
		return "escalera/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Escalera entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Escalera escalera = null;
		try {
			escalera = escaleraService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/escaleras/" + escalera.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Escalera> entity = escaleraService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("escalera", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "escalera/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Escalera entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Escalera escalera = null;
		try {
			escalera = escaleraService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/escaleras/" + escalera.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Escalera> entity = escaleraService.findById(id);
				
				if (entity.isPresent()) {
					escaleraService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/escaleras";
	}

}
