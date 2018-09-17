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
import co.innovaciones.model.Puenteexterno;
import co.innovaciones.service.PuenteexternoService;

@Controller
@RequestMapping("/puenteexternos")
public class PuenteexternoController {

	private static final String MSG_SUCESS_INSERT = "Puenteexterno inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Puenteexterno successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Puenteexterno successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PuenteexternoService puenteexternoService;

	@GetMapping
	public String index(Model model) {
		List<Puenteexterno> all = puenteexternoService.findAll();
		model.addAttribute("listPuenteexterno", all);
		return "puenteexterno/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Puenteexterno> puenteexterno = puenteexternoService.findById(id);
			
			if (puenteexterno.isPresent())
				model.addAttribute("puenteexterno", puenteexterno.get());
		}
		return "puenteexterno/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Puenteexterno entity) {
		model.addAttribute("puenteexterno", entity);
		return "puenteexterno/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Puenteexterno entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puenteexterno puenteexterno = null;
		try {
			puenteexterno = puenteexternoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puenteexternos/" + puenteexterno.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Puenteexterno> entity = puenteexternoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("puenteexterno", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "puenteexterno/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Puenteexterno entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Puenteexterno puenteexterno = null;
		try {
			puenteexterno = puenteexternoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/puenteexternos/" + puenteexterno.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Puenteexterno> entity = puenteexternoService.findById(id);
				
				if (entity.isPresent()) {
					puenteexternoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/puenteexternos";
	}

}
