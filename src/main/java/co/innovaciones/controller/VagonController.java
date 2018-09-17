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
import co.innovaciones.model.Vagon;
import co.innovaciones.service.VagonService;

@Controller
@RequestMapping("/vagons")
public class VagonController {

	private static final String MSG_SUCESS_INSERT = "Vagon inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Vagon successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Vagon successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private VagonService vagonService;

	@GetMapping
	public String index(Model model) {
		List<Vagon> all = vagonService.findAll();
		model.addAttribute("listVagon", all);
		return "vagon/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Vagon> vagon = vagonService.findById(id);
			
			if (vagon.isPresent())
				model.addAttribute("vagon", vagon.get());
		}
		return "vagon/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Vagon entity) {
		model.addAttribute("vagon", entity);
		return "vagon/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Vagon entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vagon vagon = null;
		try {
			vagon = vagonService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vagons/" + vagon.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Vagon> entity = vagonService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("vagon", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "vagon/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Vagon entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Vagon vagon = null;
		try {
			vagon = vagonService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/vagons/" + vagon.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Vagon> entity = vagonService.findById(id);
				
				if (entity.isPresent()) {
					vagonService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/vagons";
	}

}
