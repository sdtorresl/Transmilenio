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
import co.innovaciones.model.Garita;
import co.innovaciones.service.GaritaService;

@Controller
@RequestMapping("/garitas")
public class GaritaController {

	private static final String MSG_SUCESS_INSERT = "Garita inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Garita successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Garita successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private GaritaService garitaService;

	@GetMapping
	public String index(Model model) {
		List<Garita> all = garitaService.findAll();
		model.addAttribute("listGarita", all);
		return "garita/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Garita> garita = garitaService.findById(id);
			
			if (garita.isPresent())
				model.addAttribute("garita", garita.get());
		}
		return "garita/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Garita entity) {
		model.addAttribute("garita", entity);
		return "garita/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Garita entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Garita garita = null;
		try {
			garita = garitaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/garitas/" + garita.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Garita> entity = garitaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("garita", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "garita/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Garita entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Garita garita = null;
		try {
			garita = garitaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/garitas/" + garita.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Garita> entity = garitaService.findById(id);
				
				if (entity.isPresent()) {
					garitaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/garitas";
	}

}
