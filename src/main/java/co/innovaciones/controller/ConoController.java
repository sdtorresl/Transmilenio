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
import co.innovaciones.model.Cono;
import co.innovaciones.service.ConoService;

@Controller
@RequestMapping("/conos")
public class ConoController {

	private static final String MSG_SUCESS_INSERT = "Cono inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Cono successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Cono successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ConoService conoService;

	@GetMapping
	public String index(Model model) {
		List<Cono> all = conoService.findAll();
		model.addAttribute("listCono", all);
		return "cono/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Cono> cono = conoService.findById(id);
			
			if (cono.isPresent())
				model.addAttribute("cono", cono.get());
		}
		return "cono/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Cono entity) {
		model.addAttribute("cono", entity);
		return "cono/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Cono entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cono cono = null;
		try {
			cono = conoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/conos/" + cono.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Cono> entity = conoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("cono", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "cono/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Cono entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cono cono = null;
		try {
			cono = conoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/conos/" + cono.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Cono> entity = conoService.findById(id);
				
				if (entity.isPresent()) {
					conoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/conos";
	}

}
