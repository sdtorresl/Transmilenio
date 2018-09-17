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
import co.innovaciones.model.Conexa;
import co.innovaciones.service.ConexaService;

@Controller
@RequestMapping("/conexas")
public class ConexaController {

	private static final String MSG_SUCESS_INSERT = "Conexa inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Conexa successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Conexa successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ConexaService conexaService;

	@GetMapping
	public String index(Model model) {
		List<Conexa> all = conexaService.findAll();
		model.addAttribute("listConexa", all);
		return "conexa/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Conexa> conexa = conexaService.findById(id);
			
			if (conexa.isPresent())
				model.addAttribute("conexa", conexa.get());
		}
		return "conexa/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Conexa entity) {
		model.addAttribute("conexa", entity);
		return "conexa/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Conexa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Conexa conexa = null;
		try {
			conexa = conexaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/conexas/" + conexa.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Conexa> entity = conexaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("conexa", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "conexa/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Conexa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Conexa conexa = null;
		try {
			conexa = conexaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/conexas/" + conexa.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Conexa> entity = conexaService.findById(id);
				
				if (entity.isPresent()) {
					conexaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/conexas";
	}

}
