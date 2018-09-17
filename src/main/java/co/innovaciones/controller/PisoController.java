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
import co.innovaciones.model.Piso;
import co.innovaciones.service.PisoService;

@Controller
@RequestMapping("/pisos")
public class PisoController {

	private static final String MSG_SUCESS_INSERT = "Piso inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Piso successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Piso successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PisoService pisoService;

	@GetMapping
	public String index(Model model) {
		List<Piso> all = pisoService.findAll();
		model.addAttribute("listPiso", all);
		return "piso/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Piso> piso = pisoService.findById(id);
			
			if (piso.isPresent())
				model.addAttribute("piso", piso.get());
		}
		return "piso/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Piso entity) {
		model.addAttribute("piso", entity);
		return "piso/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Piso entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Piso piso = null;
		try {
			piso = pisoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pisos/" + piso.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Piso> entity = pisoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("piso", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "piso/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Piso entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Piso piso = null;
		try {
			piso = pisoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pisos/" + piso.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Piso> entity = pisoService.findById(id);
				
				if (entity.isPresent()) {
					pisoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/pisos";
	}

}
