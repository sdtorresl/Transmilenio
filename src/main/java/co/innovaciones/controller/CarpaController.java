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
import co.innovaciones.model.Carpa;
import co.innovaciones.service.CarpaService;

@Controller
@RequestMapping("/carpas")
public class CarpaController {

	private static final String MSG_SUCESS_INSERT = "Carpa inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Carpa successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Carpa successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CarpaService carpaService;

	@GetMapping
	public String index(Model model) {
		List<Carpa> all = carpaService.findAll();
		model.addAttribute("listCarpa", all);
		return "carpa/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Carpa> carpa = carpaService.findById(id);
			
			if (carpa.isPresent())
				model.addAttribute("carpa", carpa.get());
		}
		return "carpa/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Carpa entity) {
		model.addAttribute("carpa", entity);
		return "carpa/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Carpa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Carpa carpa = null;
		try {
			carpa = carpaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/carpas/" + carpa.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Carpa> entity = carpaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("carpa", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "carpa/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Carpa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Carpa carpa = null;
		try {
			carpa = carpaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/carpas/" + carpa.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Carpa> entity = carpaService.findById(id);
				
				if (entity.isPresent()) {
					carpaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/carpas";
	}

}
