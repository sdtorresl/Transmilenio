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
import co.innovaciones.model.Celosiaestribo;
import co.innovaciones.service.CelosiaestriboService;

@Controller
@RequestMapping("/celosiaestribos")
public class CelosiaestriboController {

	private static final String MSG_SUCESS_INSERT = "Celosiaestribo inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Celosiaestribo successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Celosiaestribo successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CelosiaestriboService celosiaestriboService;

	@GetMapping
	public String index(Model model) {
		List<Celosiaestribo> all = celosiaestriboService.findAll();
		model.addAttribute("listCelosiaestribo", all);
		return "celosiaestribo/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Celosiaestribo> celosiaestribo = celosiaestriboService.findById(id);
			
			if (celosiaestribo.isPresent())
				model.addAttribute("celosiaestribo", celosiaestribo.get());
		}
		return "celosiaestribo/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Celosiaestribo entity) {
		model.addAttribute("celosiaestribo", entity);
		return "celosiaestribo/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Celosiaestribo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Celosiaestribo celosiaestribo = null;
		try {
			celosiaestribo = celosiaestriboService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/celosiaestribos/" + celosiaestribo.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Celosiaestribo> entity = celosiaestriboService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("celosiaestribo", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "celosiaestribo/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Celosiaestribo entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Celosiaestribo celosiaestribo = null;
		try {
			celosiaestribo = celosiaestriboService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/celosiaestribos/" + celosiaestribo.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Celosiaestribo> entity = celosiaestriboService.findById(id);
				
				if (entity.isPresent()) {
					celosiaestriboService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/celosiaestribos";
	}

}
