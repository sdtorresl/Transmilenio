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
import co.innovaciones.model.Casetacomercial;
import co.innovaciones.service.CasetacomercialService;

@Controller
@RequestMapping("/casetacomercials")
public class CasetacomercialController {

	private static final String MSG_SUCESS_INSERT = "Casetacomercial inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Casetacomercial successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Casetacomercial successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CasetacomercialService casetacomercialService;

	@GetMapping
	public String index(Model model) {
		List<Casetacomercial> all = casetacomercialService.findAll();
		model.addAttribute("listCasetacomercial", all);
		return "casetacomercial/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Casetacomercial> casetacomercial = casetacomercialService.findById(id);
			
			if (casetacomercial.isPresent())
				model.addAttribute("casetacomercial", casetacomercial.get());
		}
		return "casetacomercial/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Casetacomercial entity) {
		model.addAttribute("casetacomercial", entity);
		return "casetacomercial/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Casetacomercial entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Casetacomercial casetacomercial = null;
		try {
			casetacomercial = casetacomercialService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/casetacomercials/" + casetacomercial.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Casetacomercial> entity = casetacomercialService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("casetacomercial", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "casetacomercial/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Casetacomercial entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Casetacomercial casetacomercial = null;
		try {
			casetacomercial = casetacomercialService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/casetacomercials/" + casetacomercial.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Casetacomercial> entity = casetacomercialService.findById(id);
				
				if (entity.isPresent()) {
					casetacomercialService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/casetacomercials";
	}

}
