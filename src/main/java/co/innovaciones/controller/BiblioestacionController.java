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
import co.innovaciones.model.Biblioestacion;
import co.innovaciones.service.BiblioestacionService;

@Controller
@RequestMapping("/biblioestacions")
public class BiblioestacionController {

	private static final String MSG_SUCESS_INSERT = "Biblioestacion inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Biblioestacion successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Biblioestacion successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BiblioestacionService biblioestacionService;

	@GetMapping
	public String index(Model model) {
		List<Biblioestacion> all = biblioestacionService.findAll();
		model.addAttribute("listBiblioestacion", all);
		return "biblioestacion/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Biblioestacion> biblioestacion = biblioestacionService.findById(id);
			
			if (biblioestacion.isPresent())
				model.addAttribute("biblioestacion", biblioestacion.get());
		}
		return "biblioestacion/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Biblioestacion entity) {
		model.addAttribute("biblioestacion", entity);
		return "biblioestacion/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Biblioestacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Biblioestacion biblioestacion = null;
		try {
			biblioestacion = biblioestacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/biblioestacions/" + biblioestacion.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Biblioestacion> entity = biblioestacionService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("biblioestacion", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "biblioestacion/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Biblioestacion entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Biblioestacion biblioestacion = null;
		try {
			biblioestacion = biblioestacionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/biblioestacions/" + biblioestacion.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Biblioestacion> entity = biblioestacionService.findById(id);
				
				if (entity.isPresent()) {
					biblioestacionService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/biblioestacions";
	}

}
