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
import co.innovaciones.model.Noopera;
import co.innovaciones.service.NooperaService;

@Controller
@RequestMapping("/nooperas")
public class NooperaController {

	private static final String MSG_SUCESS_INSERT = "Noopera inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Noopera successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Noopera successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private NooperaService nooperaService;

	@GetMapping
	public String index(Model model) {
		List<Noopera> all = nooperaService.findAll();
		model.addAttribute("listNoopera", all);
		return "noopera/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Noopera> noopera = nooperaService.findById(id);
			
			if (noopera.isPresent())
				model.addAttribute("noopera", noopera.get());
		}
		return "noopera/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Noopera entity) {
		model.addAttribute("noopera", entity);
		return "noopera/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Noopera entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Noopera noopera = null;
		try {
			noopera = nooperaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nooperas/" + noopera.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Noopera> entity = nooperaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("noopera", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "noopera/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Noopera entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Noopera noopera = null;
		try {
			noopera = nooperaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nooperas/" + noopera.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Noopera> entity = nooperaService.findById(id);
				
				if (entity.isPresent()) {
					nooperaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/nooperas";
	}

}
