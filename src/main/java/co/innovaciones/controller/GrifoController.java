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
import co.innovaciones.model.Grifo;
import co.innovaciones.service.GrifoService;

@Controller
@RequestMapping("/grifos")
public class GrifoController {

	private static final String MSG_SUCESS_INSERT = "Grifo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Grifo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Grifo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private GrifoService grifoService;

	@GetMapping
	public String index(Model model) {
		List<Grifo> all = grifoService.findAll();
		model.addAttribute("listGrifo", all);
		return "grifo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Grifo> grifo = grifoService.findById(id);
			
			if (grifo.isPresent())
				model.addAttribute("grifo", grifo.get());
		}
		return "grifo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Grifo entity) {
		model.addAttribute("grifo", entity);
		return "grifo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Grifo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Grifo grifo = null;
		try {
			grifo = grifoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/grifos/" + grifo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Grifo> entity = grifoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("grifo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "grifo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Grifo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Grifo grifo = null;
		try {
			grifo = grifoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/grifos/" + grifo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Grifo> entity = grifoService.findById(id);
				
				if (entity.isPresent()) {
					grifoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/grifos";
	}

}
