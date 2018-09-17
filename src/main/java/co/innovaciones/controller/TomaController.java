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
import co.innovaciones.model.Toma;
import co.innovaciones.service.TomaService;

@Controller
@RequestMapping("/tomas")
public class TomaController {

	private static final String MSG_SUCESS_INSERT = "Toma inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Toma successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Toma successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TomaService tomaService;

	@GetMapping
	public String index(Model model) {
		List<Toma> all = tomaService.findAll();
		model.addAttribute("listToma", all);
		return "toma/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Toma> toma = tomaService.findById(id);
			
			if (toma.isPresent())
				model.addAttribute("toma", toma.get());
		}
		return "toma/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Toma entity) {
		model.addAttribute("toma", entity);
		return "toma/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Toma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Toma toma = null;
		try {
			toma = tomaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/tomas/" + toma.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Toma> entity = tomaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("toma", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "toma/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Toma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Toma toma = null;
		try {
			toma = tomaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/tomas/" + toma.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Toma> entity = tomaService.findById(id);
				
				if (entity.isPresent()) {
					tomaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/tomas";
	}

}
