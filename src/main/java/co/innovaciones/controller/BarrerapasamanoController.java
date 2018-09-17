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
import co.innovaciones.model.Barrerapasamano;
import co.innovaciones.service.BarrerapasamanoService;

@Controller
@RequestMapping("/barrerapasamanos")
public class BarrerapasamanoController {

	private static final String MSG_SUCESS_INSERT = "Barrerapasamano inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Barrerapasamano successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Barrerapasamano successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BarrerapasamanoService barrerapasamanoService;

	@GetMapping
	public String index(Model model) {
		List<Barrerapasamano> all = barrerapasamanoService.findAll();
		model.addAttribute("listBarrerapasamano", all);
		return "barrerapasamano/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Barrerapasamano> barrerapasamano = barrerapasamanoService.findById(id);
			
			if (barrerapasamano.isPresent())
				model.addAttribute("barrerapasamano", barrerapasamano.get());
		}
		return "barrerapasamano/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Barrerapasamano entity) {
		model.addAttribute("barrerapasamano", entity);
		return "barrerapasamano/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Barrerapasamano entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Barrerapasamano barrerapasamano = null;
		try {
			barrerapasamano = barrerapasamanoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/barrerapasamanos/" + barrerapasamano.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Barrerapasamano> entity = barrerapasamanoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("barrerapasamano", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "barrerapasamano/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Barrerapasamano entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Barrerapasamano barrerapasamano = null;
		try {
			barrerapasamano = barrerapasamanoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/barrerapasamanos/" + barrerapasamano.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Barrerapasamano> entity = barrerapasamanoService.findById(id);
				
				if (entity.isPresent()) {
					barrerapasamanoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/barrerapasamanos";
	}

}
