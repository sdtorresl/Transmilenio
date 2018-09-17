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
import co.innovaciones.model.Plataforma;
import co.innovaciones.service.PlataformaService;

@Controller
@RequestMapping("/plataformas")
public class PlataformaController {

	private static final String MSG_SUCESS_INSERT = "Plataforma inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Plataforma successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Plataforma successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PlataformaService plataformaService;

	@GetMapping
	public String index(Model model) {
		List<Plataforma> all = plataformaService.findAll();
		model.addAttribute("listPlataforma", all);
		return "plataforma/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Plataforma> plataforma = plataformaService.findById(id);
			
			if (plataforma.isPresent())
				model.addAttribute("plataforma", plataforma.get());
		}
		return "plataforma/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Plataforma entity) {
		model.addAttribute("plataforma", entity);
		return "plataforma/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Plataforma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Plataforma plataforma = null;
		try {
			plataforma = plataformaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/plataformas/" + plataforma.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Plataforma> entity = plataformaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("plataforma", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "plataforma/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Plataforma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Plataforma plataforma = null;
		try {
			plataforma = plataformaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/plataformas/" + plataforma.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Plataforma> entity = plataformaService.findById(id);
				
				if (entity.isPresent()) {
					plataformaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/plataformas";
	}

}
