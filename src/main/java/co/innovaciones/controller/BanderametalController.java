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
import co.innovaciones.model.Banderametal;
import co.innovaciones.service.BanderametalService;

@Controller
@RequestMapping("/banderametals")
public class BanderametalController {

	private static final String MSG_SUCESS_INSERT = "Banderametal inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Banderametal successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Banderametal successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BanderametalService banderametalService;

	@GetMapping
	public String index(Model model) {
		List<Banderametal> all = banderametalService.findAll();
		model.addAttribute("listBanderametal", all);
		return "banderametal/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Banderametal> banderametal = banderametalService.findById(id);
			
			if (banderametal.isPresent())
				model.addAttribute("banderametal", banderametal.get());
		}
		return "banderametal/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Banderametal entity) {
		model.addAttribute("banderametal", entity);
		return "banderametal/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Banderametal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Banderametal banderametal = null;
		try {
			banderametal = banderametalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/banderametals/" + banderametal.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Banderametal> entity = banderametalService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("banderametal", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "banderametal/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Banderametal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Banderametal banderametal = null;
		try {
			banderametal = banderametalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/banderametals/" + banderametal.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Banderametal> entity = banderametalService.findById(id);
				
				if (entity.isPresent()) {
					banderametalService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/banderametals";
	}

}
