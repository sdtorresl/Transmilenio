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
import co.innovaciones.model.Recarga;
import co.innovaciones.service.RecargaService;

@Controller
@RequestMapping("/recargas")
public class RecargaController {

	private static final String MSG_SUCESS_INSERT = "Recarga inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Recarga successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Recarga successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private RecargaService recargaService;

	@GetMapping
	public String index(Model model) {
		List<Recarga> all = recargaService.findAll();
		model.addAttribute("listRecarga", all);
		return "recarga/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Recarga> recarga = recargaService.findById(id);
			
			if (recarga.isPresent())
				model.addAttribute("recarga", recarga.get());
		}
		return "recarga/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Recarga entity) {
		model.addAttribute("recarga", entity);
		return "recarga/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Recarga entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Recarga recarga = null;
		try {
			recarga = recargaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/recargas/" + recarga.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Recarga> entity = recargaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("recarga", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "recarga/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Recarga entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Recarga recarga = null;
		try {
			recarga = recargaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/recargas/" + recarga.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Recarga> entity = recargaService.findById(id);
				
				if (entity.isPresent()) {
					recargaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/recargas";
	}

}
