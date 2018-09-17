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
import co.innovaciones.model.Camara;
import co.innovaciones.service.CamaraService;

@Controller
@RequestMapping("/camaras")
public class CamaraController {

	private static final String MSG_SUCESS_INSERT = "Camara inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Camara successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Camara successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CamaraService camaraService;

	@GetMapping
	public String index(Model model) {
		List<Camara> all = camaraService.findAll();
		model.addAttribute("listCamara", all);
		return "camara/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Camara> camara = camaraService.findById(id);
			
			if (camara.isPresent())
				model.addAttribute("camara", camara.get());
		}
		return "camara/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Camara entity) {
		model.addAttribute("camara", entity);
		return "camara/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Camara entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Camara camara = null;
		try {
			camara = camaraService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/camaras/" + camara.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Camara> entity = camaraService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("camara", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "camara/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Camara entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Camara camara = null;
		try {
			camara = camaraService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/camaras/" + camara.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Camara> entity = camaraService.findById(id);
				
				if (entity.isPresent()) {
					camaraService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/camaras";
	}

}
