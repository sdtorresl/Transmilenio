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
import co.innovaciones.model.Celosia;
import co.innovaciones.service.CelosiaService;

@Controller
@RequestMapping("/celosias")
public class CelosiaController {

	private static final String MSG_SUCESS_INSERT = "Celosia inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Celosia successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Celosia successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CelosiaService celosiaService;

	@GetMapping
	public String index(Model model) {
		List<Celosia> all = celosiaService.findAll();
		model.addAttribute("listCelosia", all);
		return "celosia/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Celosia> celosia = celosiaService.findById(id);
			
			if (celosia.isPresent())
				model.addAttribute("celosia", celosia.get());
		}
		return "celosia/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Celosia entity) {
		model.addAttribute("celosia", entity);
		return "celosia/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Celosia entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Celosia celosia = null;
		try {
			celosia = celosiaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/celosias/" + celosia.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Celosia> entity = celosiaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("celosia", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "celosia/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Celosia entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Celosia celosia = null;
		try {
			celosia = celosiaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/celosias/" + celosia.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Celosia> entity = celosiaService.findById(id);
				
				if (entity.isPresent()) {
					celosiaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/celosias";
	}

}
