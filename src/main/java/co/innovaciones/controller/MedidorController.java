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
import co.innovaciones.model.Medidor;
import co.innovaciones.service.MedidorService;

@Controller
@RequestMapping("/medidors")
public class MedidorController {

	private static final String MSG_SUCESS_INSERT = "Medidor inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Medidor successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Medidor successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private MedidorService medidorService;

	@GetMapping
	public String index(Model model) {
		List<Medidor> all = medidorService.findAll();
		model.addAttribute("listMedidor", all);
		return "medidor/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Medidor> medidor = medidorService.findById(id);
			
			if (medidor.isPresent())
				model.addAttribute("medidor", medidor.get());
		}
		return "medidor/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Medidor entity) {
		model.addAttribute("medidor", entity);
		return "medidor/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Medidor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Medidor medidor = null;
		try {
			medidor = medidorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/medidors/" + medidor.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Medidor> entity = medidorService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("medidor", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "medidor/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Medidor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Medidor medidor = null;
		try {
			medidor = medidorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/medidors/" + medidor.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Medidor> entity = medidorService.findById(id);
				
				if (entity.isPresent()) {
					medidorService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/medidors";
	}

}
