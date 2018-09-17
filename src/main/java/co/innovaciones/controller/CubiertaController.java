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
import co.innovaciones.model.Cubierta;
import co.innovaciones.service.CubiertaService;

@Controller
@RequestMapping("/cubiertas")
public class CubiertaController {

	private static final String MSG_SUCESS_INSERT = "Cubierta inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Cubierta successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Cubierta successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CubiertaService cubiertaService;

	@GetMapping
	public String index(Model model) {
		List<Cubierta> all = cubiertaService.findAll();
		model.addAttribute("listCubierta", all);
		return "cubierta/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Cubierta> cubierta = cubiertaService.findById(id);
			
			if (cubierta.isPresent())
				model.addAttribute("cubierta", cubierta.get());
		}
		return "cubierta/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Cubierta entity) {
		model.addAttribute("cubierta", entity);
		return "cubierta/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Cubierta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cubierta cubierta = null;
		try {
			cubierta = cubiertaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cubiertas/" + cubierta.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Cubierta> entity = cubiertaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("cubierta", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "cubierta/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Cubierta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cubierta cubierta = null;
		try {
			cubierta = cubiertaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cubiertas/" + cubierta.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Cubierta> entity = cubiertaService.findById(id);
				
				if (entity.isPresent()) {
					cubiertaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/cubiertas";
	}

}
