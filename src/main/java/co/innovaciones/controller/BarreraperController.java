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
import co.innovaciones.model.Barreraper;
import co.innovaciones.service.BarreraperService;

@Controller
@RequestMapping("/barrerapers")
public class BarreraperController {

	private static final String MSG_SUCESS_INSERT = "Barreraper inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Barreraper successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Barreraper successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BarreraperService barreraperService;

	@GetMapping
	public String index(Model model) {
		List<Barreraper> all = barreraperService.findAll();
		model.addAttribute("listBarreraper", all);
		return "barreraper/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Barreraper> barreraper = barreraperService.findById(id);
			
			if (barreraper.isPresent())
				model.addAttribute("barreraper", barreraper.get());
		}
		return "barreraper/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Barreraper entity) {
		model.addAttribute("barreraper", entity);
		return "barreraper/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Barreraper entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Barreraper barreraper = null;
		try {
			barreraper = barreraperService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/barrerapers/" + barreraper.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Barreraper> entity = barreraperService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("barreraper", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "barreraper/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Barreraper entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Barreraper barreraper = null;
		try {
			barreraper = barreraperService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/barrerapers/" + barreraper.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Barreraper> entity = barreraperService.findById(id);
				
				if (entity.isPresent()) {
					barreraperService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/barrerapers";
	}

}
