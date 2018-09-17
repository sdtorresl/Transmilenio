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
import co.innovaciones.model.Ciclopar;
import co.innovaciones.service.CicloparService;

@Controller
@RequestMapping("/ciclopars")
public class CicloparController {

	private static final String MSG_SUCESS_INSERT = "Ciclopar inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Ciclopar successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Ciclopar successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CicloparService cicloparService;

	@GetMapping
	public String index(Model model) {
		List<Ciclopar> all = cicloparService.findAll();
		model.addAttribute("listCiclopar", all);
		return "ciclopar/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Ciclopar> ciclopar = cicloparService.findById(id);
			
			if (ciclopar.isPresent())
				model.addAttribute("ciclopar", ciclopar.get());
		}
		return "ciclopar/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Ciclopar entity) {
		model.addAttribute("ciclopar", entity);
		return "ciclopar/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Ciclopar entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ciclopar ciclopar = null;
		try {
			ciclopar = cicloparService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ciclopars/" + ciclopar.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Ciclopar> entity = cicloparService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("ciclopar", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "ciclopar/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Ciclopar entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ciclopar ciclopar = null;
		try {
			ciclopar = cicloparService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/ciclopars/" + ciclopar.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Ciclopar> entity = cicloparService.findById(id);
				
				if (entity.isPresent()) {
					cicloparService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/ciclopars";
	}

}
