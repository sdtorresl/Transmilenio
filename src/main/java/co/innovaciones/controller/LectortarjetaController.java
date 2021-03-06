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
import co.innovaciones.model.Lectortarjeta;
import co.innovaciones.service.LectortarjetaService;

@Controller
@RequestMapping("/lectortarjetas")
public class LectortarjetaController {

	private static final String MSG_SUCESS_INSERT = "Lectortarjeta inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Lectortarjeta successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Lectortarjeta successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private LectortarjetaService lectortarjetaService;

	@GetMapping
	public String index(Model model) {
		List<Lectortarjeta> all = lectortarjetaService.findAll();
		model.addAttribute("listLectortarjeta", all);
		return "lectortarjeta/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Lectortarjeta> lectortarjeta = lectortarjetaService.findById(id);
			
			if (lectortarjeta.isPresent())
				model.addAttribute("lectortarjeta", lectortarjeta.get());
		}
		return "lectortarjeta/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Lectortarjeta entity) {
		model.addAttribute("lectortarjeta", entity);
		return "lectortarjeta/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Lectortarjeta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Lectortarjeta lectortarjeta = null;
		try {
			lectortarjeta = lectortarjetaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/lectortarjetas/" + lectortarjeta.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Lectortarjeta> entity = lectortarjetaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("lectortarjeta", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "lectortarjeta/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Lectortarjeta entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Lectortarjeta lectortarjeta = null;
		try {
			lectortarjeta = lectortarjetaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/lectortarjetas/" + lectortarjeta.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Lectortarjeta> entity = lectortarjetaService.findById(id);
				
				if (entity.isPresent()) {
					lectortarjetaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/lectortarjetas";
	}

}
