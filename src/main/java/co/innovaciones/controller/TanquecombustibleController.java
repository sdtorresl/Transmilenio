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
import co.innovaciones.model.Tanquecombustible;
import co.innovaciones.service.TanquecombustibleService;

@Controller
@RequestMapping("/tanquecombustibles")
public class TanquecombustibleController {

	private static final String MSG_SUCESS_INSERT = "Tanquecombustible inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Tanquecombustible successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Tanquecombustible successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private TanquecombustibleService tanquecombustibleService;

	@GetMapping
	public String index(Model model) {
		List<Tanquecombustible> all = tanquecombustibleService.findAll();
		model.addAttribute("listTanquecombustible", all);
		return "tanquecombustible/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Tanquecombustible> tanquecombustible = tanquecombustibleService.findById(id);
			
			if (tanquecombustible.isPresent())
				model.addAttribute("tanquecombustible", tanquecombustible.get());
		}
		return "tanquecombustible/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Tanquecombustible entity) {
		model.addAttribute("tanquecombustible", entity);
		return "tanquecombustible/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Tanquecombustible entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Tanquecombustible tanquecombustible = null;
		try {
			tanquecombustible = tanquecombustibleService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/tanquecombustibles/" + tanquecombustible.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Tanquecombustible> entity = tanquecombustibleService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("tanquecombustible", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "tanquecombustible/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Tanquecombustible entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Tanquecombustible tanquecombustible = null;
		try {
			tanquecombustible = tanquecombustibleService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/tanquecombustibles/" + tanquecombustible.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Tanquecombustible> entity = tanquecombustibleService.findById(id);
				
				if (entity.isPresent()) {
					tanquecombustibleService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/tanquecombustibles";
	}

}
