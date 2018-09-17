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
import co.innovaciones.model.Pasamano;
import co.innovaciones.service.PasamanoService;

@Controller
@RequestMapping("/pasamanos")
public class PasamanoController {

	private static final String MSG_SUCESS_INSERT = "Pasamano inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Pasamano successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Pasamano successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PasamanoService pasamanoService;

	@GetMapping
	public String index(Model model) {
		List<Pasamano> all = pasamanoService.findAll();
		model.addAttribute("listPasamano", all);
		return "pasamano/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Pasamano> pasamano = pasamanoService.findById(id);
			
			if (pasamano.isPresent())
				model.addAttribute("pasamano", pasamano.get());
		}
		return "pasamano/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Pasamano entity) {
		model.addAttribute("pasamano", entity);
		return "pasamano/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Pasamano entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pasamano pasamano = null;
		try {
			pasamano = pasamanoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pasamanos/" + pasamano.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Pasamano> entity = pasamanoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("pasamano", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "pasamano/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Pasamano entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Pasamano pasamano = null;
		try {
			pasamano = pasamanoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pasamanos/" + pasamano.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Pasamano> entity = pasamanoService.findById(id);
				
				if (entity.isPresent()) {
					pasamanoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/pasamanos";
	}

}
