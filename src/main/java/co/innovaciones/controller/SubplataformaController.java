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
import co.innovaciones.model.Subplataforma;
import co.innovaciones.service.SubplataformaService;

@Controller
@RequestMapping("/subplataformas")
public class SubplataformaController {

	private static final String MSG_SUCESS_INSERT = "Subplataforma inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Subplataforma successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Subplataforma successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SubplataformaService subplataformaService;

	@GetMapping
	public String index(Model model) {
		List<Subplataforma> all = subplataformaService.findAll();
		model.addAttribute("listSubplataforma", all);
		return "subplataforma/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Subplataforma> subplataforma = subplataformaService.findById(id);
			
			if (subplataforma.isPresent())
				model.addAttribute("subplataforma", subplataforma.get());
		}
		return "subplataforma/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Subplataforma entity) {
		model.addAttribute("subplataforma", entity);
		return "subplataforma/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Subplataforma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Subplataforma subplataforma = null;
		try {
			subplataforma = subplataformaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/subplataformas/" + subplataforma.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Subplataforma> entity = subplataformaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("subplataforma", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "subplataforma/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Subplataforma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Subplataforma subplataforma = null;
		try {
			subplataforma = subplataformaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/subplataformas/" + subplataforma.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Subplataforma> entity = subplataformaService.findById(id);
				
				if (entity.isPresent()) {
					subplataformaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/subplataformas";
	}

}
