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
import co.innovaciones.model.Vidrio;
import co.innovaciones.service.VidrioService;

@Controller
@RequestMapping("/vidrios")
public class VidrioController {

	private static final String MSG_SUCESS_INSERT = "Vidrio inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Vidrio successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Vidrio successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private VidrioService vidrioService;

	@GetMapping
	public String index(Model model) {
		List<Vidrio> all = vidrioService.findAll();
		model.addAttribute("listVidrio", all);
		return "vidrio/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Vidrio> vidrio = vidrioService.findById(id);
			
			if (vidrio.isPresent())
				model.addAttribute("vidrio", vidrio.get());
		}
		return "vidrio/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Vidrio entity) {
		model.addAttribute("vidrio", entity);
		return "vidrio/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Vidrio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vidrio vidrio = null;
		try {
			vidrio = vidrioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vidrios/" + vidrio.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Vidrio> entity = vidrioService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("vidrio", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "vidrio/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Vidrio entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vidrio vidrio = null;
		try {
			vidrio = vidrioService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vidrios/" + vidrio.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Vidrio> entity = vidrioService.findById(id);
				
				if (entity.isPresent()) {
					vidrioService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/vidrios";
	}

}
