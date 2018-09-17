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
import co.innovaciones.model.Cubiertatipo;
import co.innovaciones.service.CubiertatipoService;

@Controller
@RequestMapping("/cubiertatipos")
public class CubiertatipoController {

	private static final String MSG_SUCESS_INSERT = "Cubiertatipo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Cubiertatipo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Cubiertatipo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CubiertatipoService cubiertatipoService;

	@GetMapping
	public String index(Model model) {
		List<Cubiertatipo> all = cubiertatipoService.findAll();
		model.addAttribute("listCubiertatipo", all);
		return "cubiertatipo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Cubiertatipo> cubiertatipo = cubiertatipoService.findById(id);
			
			if (cubiertatipo.isPresent())
				model.addAttribute("cubiertatipo", cubiertatipo.get());
		}
		return "cubiertatipo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Cubiertatipo entity) {
		model.addAttribute("cubiertatipo", entity);
		return "cubiertatipo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Cubiertatipo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cubiertatipo cubiertatipo = null;
		try {
			cubiertatipo = cubiertatipoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cubiertatipos/" + cubiertatipo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Cubiertatipo> entity = cubiertatipoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("cubiertatipo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "cubiertatipo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Cubiertatipo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cubiertatipo cubiertatipo = null;
		try {
			cubiertatipo = cubiertatipoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cubiertatipos/" + cubiertatipo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Cubiertatipo> entity = cubiertatipoService.findById(id);
				
				if (entity.isPresent()) {
					cubiertatipoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/cubiertatipos";
	}

}
