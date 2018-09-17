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
import co.innovaciones.model.Transformador;
import co.innovaciones.service.TransformadorService;

@Controller
@RequestMapping("/transformadors")
public class TransformadorController {

	private static final String MSG_SUCESS_INSERT = "Transformador inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Transformador successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Transformador successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TransformadorService transformadorService;

	@GetMapping
	public String index(Model model) {
		List<Transformador> all = transformadorService.findAll();
		model.addAttribute("listTransformador", all);
		return "transformador/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Transformador> transformador = transformadorService.findById(id);
			
			if (transformador.isPresent())
				model.addAttribute("transformador", transformador.get());
		}
		return "transformador/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Transformador entity) {
		model.addAttribute("transformador", entity);
		return "transformador/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Transformador entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Transformador transformador = null;
		try {
			transformador = transformadorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/transformadors/" + transformador.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Transformador> entity = transformadorService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("transformador", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "transformador/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Transformador entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Transformador transformador = null;
		try {
			transformador = transformadorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/transformadors/" + transformador.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Transformador> entity = transformadorService.findById(id);
				
				if (entity.isPresent()) {
					transformadorService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/transformadors";
	}

}
