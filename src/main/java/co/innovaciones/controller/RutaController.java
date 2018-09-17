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
import co.innovaciones.model.Ruta;
import co.innovaciones.service.RutaService;

@Controller
@RequestMapping("/rutas")
public class RutaController {

	private static final String MSG_SUCESS_INSERT = "Ruta inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Ruta successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Ruta successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private RutaService rutaService;

	@GetMapping
	public String index(Model model) {
		List<Ruta> all = rutaService.findAll();
		model.addAttribute("listRuta", all);
		return "ruta/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Ruta> ruta = rutaService.findById(id);
			
			if (ruta.isPresent())
				model.addAttribute("ruta", ruta.get());
		}
		return "ruta/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Ruta entity) {
		model.addAttribute("ruta", entity);
		return "ruta/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Ruta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ruta ruta = null;
		try {
			ruta = rutaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/rutas/" + ruta.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Ruta> entity = rutaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("ruta", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "ruta/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Ruta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Ruta ruta = null;
		try {
			ruta = rutaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/rutas/" + ruta.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Ruta> entity = rutaService.findById(id);
				
				if (entity.isPresent()) {
					rutaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/rutas";
	}

}
