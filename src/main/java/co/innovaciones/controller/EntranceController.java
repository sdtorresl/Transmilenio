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
import co.innovaciones.model.Entrance;
import co.innovaciones.service.EntranceService;

@Controller
@RequestMapping("/entrances")
public class EntranceController {

	private static final String MSG_SUCESS_INSERT = "Entrance inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Entrance successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Entrance successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private EntranceService entranceService;

	@GetMapping
	public String index(Model model) {
		List<Entrance> all = entranceService.findAll();
		model.addAttribute("listEntrance", all);
		return "entrance/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Entrance> entrance = entranceService.findById(id);
			
			if (entrance.isPresent())
				model.addAttribute("entrance", entrance.get());
		}
		return "entrance/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Entrance entity) {
		model.addAttribute("entrance", entity);
		return "entrance/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Entrance entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Entrance entrance = null;
		try {
			entrance = entranceService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/entrances/" + entrance.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Entrance> entity = entranceService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("entrance", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "entrance/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Entrance entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Entrance entrance = null;
		try {
			entrance = entranceService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/entrances/" + entrance.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Entrance> entity = entranceService.findById(id);
				
				if (entity.isPresent()) {
					entranceService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/entrances";
	}

}
