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
import co.innovaciones.model.Rampa;
import co.innovaciones.service.RampaService;

@Controller
@RequestMapping("/rampas")
public class RampaController {

	private static final String MSG_SUCESS_INSERT = "Rampa inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Rampa successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Rampa successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private RampaService rampaService;

	@GetMapping
	public String index(Model model) {
		List<Rampa> all = rampaService.findAll();
		model.addAttribute("listRampa", all);
		return "rampa/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Rampa> rampa = rampaService.findById(id);
			
			if (rampa.isPresent())
				model.addAttribute("rampa", rampa.get());
		}
		return "rampa/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Rampa entity) {
		model.addAttribute("rampa", entity);
		return "rampa/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Rampa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Rampa rampa = null;
		try {
			rampa = rampaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/rampas/" + rampa.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Rampa> entity = rampaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("rampa", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "rampa/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Rampa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Rampa rampa = null;
		try {
			rampa = rampaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/rampas/" + rampa.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Rampa> entity = rampaService.findById(id);
				
				if (entity.isPresent()) {
					rampaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/rampas";
	}

}
