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
import co.innovaciones.model.Plazoleta;
import co.innovaciones.service.PlazoletaService;

@Controller
@RequestMapping("/plazoletas")
public class PlazoletaController {

	private static final String MSG_SUCESS_INSERT = "Plazoleta inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Plazoleta successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Plazoleta successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PlazoletaService plazoletaService;

	@GetMapping
	public String index(Model model) {
		List<Plazoleta> all = plazoletaService.findAll();
		model.addAttribute("listPlazoleta", all);
		return "plazoleta/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Plazoleta> plazoleta = plazoletaService.findById(id);
			
			if (plazoleta.isPresent())
				model.addAttribute("plazoleta", plazoleta.get());
		}
		return "plazoleta/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Plazoleta entity) {
		model.addAttribute("plazoleta", entity);
		return "plazoleta/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Plazoleta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Plazoleta plazoleta = null;
		try {
			plazoleta = plazoletaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/plazoletas/" + plazoleta.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Plazoleta> entity = plazoletaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("plazoleta", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "plazoleta/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Plazoleta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Plazoleta plazoleta = null;
		try {
			plazoleta = plazoletaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/plazoletas/" + plazoleta.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Plazoleta> entity = plazoletaService.findById(id);
				
				if (entity.isPresent()) {
					plazoletaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/plazoletas";
	}

}
