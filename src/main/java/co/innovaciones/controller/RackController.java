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
import co.innovaciones.model.Rack;
import co.innovaciones.service.RackService;

@Controller
@RequestMapping("/racks")
public class RackController {

	private static final String MSG_SUCESS_INSERT = "Rack inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Rack successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Rack successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private RackService rackService;

	@GetMapping
	public String index(Model model) {
		List<Rack> all = rackService.findAll();
		model.addAttribute("listRack", all);
		return "rack/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Rack> rack = rackService.findById(id);
			
			if (rack.isPresent())
				model.addAttribute("rack", rack.get());
		}
		return "rack/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Rack entity) {
		model.addAttribute("rack", entity);
		return "rack/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Rack entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Rack rack = null;
		try {
			rack = rackService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/racks/" + rack.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Rack> entity = rackService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("rack", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "rack/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Rack entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Rack rack = null;
		try {
			rack = rackService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/racks/" + rack.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Rack> entity = rackService.findById(id);
				
				if (entity.isPresent()) {
					rackService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/racks";
	}

}
