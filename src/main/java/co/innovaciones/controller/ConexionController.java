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
import co.innovaciones.model.Conexion;
import co.innovaciones.service.ConexionService;

@Controller
@RequestMapping("/conexions")
public class ConexionController {

	private static final String MSG_SUCESS_INSERT = "Conexion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Conexion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Conexion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ConexionService conexionService;

	@GetMapping
	public String index(Model model) {
		List<Conexion> all = conexionService.findAll();
		model.addAttribute("listConexion", all);
		return "conexion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Conexion> conexion = conexionService.findById(id);
			
			if (conexion.isPresent())
				model.addAttribute("conexion", conexion.get());
		}
		return "conexion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Conexion entity) {
		model.addAttribute("conexion", entity);
		return "conexion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Conexion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Conexion conexion = null;
		try {
			conexion = conexionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/conexions/" + conexion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Conexion> entity = conexionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("conexion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "conexion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Conexion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Conexion conexion = null;
		try {
			conexion = conexionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/conexions/" + conexion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Conexion> entity = conexionService.findById(id);
				
				if (entity.isPresent()) {
					conexionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/conexions";
	}

}
