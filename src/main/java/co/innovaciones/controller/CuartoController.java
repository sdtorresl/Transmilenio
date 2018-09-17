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
import co.innovaciones.model.Cuarto;
import co.innovaciones.service.CuartoService;

@Controller
@RequestMapping("/cuartos")
public class CuartoController {

	private static final String MSG_SUCESS_INSERT = "Cuarto inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Cuarto successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Cuarto successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CuartoService cuartoService;

	@GetMapping
	public String index(Model model) {
		List<Cuarto> all = cuartoService.findAll();
		model.addAttribute("listCuarto", all);
		return "cuarto/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Cuarto> cuarto = cuartoService.findById(id);
			
			if (cuarto.isPresent())
				model.addAttribute("cuarto", cuarto.get());
		}
		return "cuarto/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Cuarto entity) {
		model.addAttribute("cuarto", entity);
		return "cuarto/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Cuarto entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cuarto cuarto = null;
		try {
			cuarto = cuartoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cuartos/" + cuarto.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Cuarto> entity = cuartoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("cuarto", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "cuarto/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Cuarto entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Cuarto cuarto = null;
		try {
			cuarto = cuartoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/cuartos/" + cuarto.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Cuarto> entity = cuartoService.findById(id);
				
				if (entity.isPresent()) {
					cuartoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/cuartos";
	}

}
