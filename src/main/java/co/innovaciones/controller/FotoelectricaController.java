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
import co.innovaciones.model.Fotoelectrica;
import co.innovaciones.service.FotoelectricaService;

@Controller
@RequestMapping("/fotoelectricas")
public class FotoelectricaController {

	private static final String MSG_SUCESS_INSERT = "Fotoelectrica inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Fotoelectrica successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Fotoelectrica successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private FotoelectricaService fotoelectricaService;

	@GetMapping
	public String index(Model model) {
		List<Fotoelectrica> all = fotoelectricaService.findAll();
		model.addAttribute("listFotoelectrica", all);
		return "fotoelectrica/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Fotoelectrica> fotoelectrica = fotoelectricaService.findById(id);
			
			if (fotoelectrica.isPresent())
				model.addAttribute("fotoelectrica", fotoelectrica.get());
		}
		return "fotoelectrica/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Fotoelectrica entity) {
		model.addAttribute("fotoelectrica", entity);
		return "fotoelectrica/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Fotoelectrica entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Fotoelectrica fotoelectrica = null;
		try {
			fotoelectrica = fotoelectricaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/fotoelectricas/" + fotoelectrica.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Fotoelectrica> entity = fotoelectricaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("fotoelectrica", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "fotoelectrica/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Fotoelectrica entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Fotoelectrica fotoelectrica = null;
		try {
			fotoelectrica = fotoelectricaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/fotoelectricas/" + fotoelectrica.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Fotoelectrica> entity = fotoelectricaService.findById(id);
				
				if (entity.isPresent()) {
					fotoelectricaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/fotoelectricas";
	}

}
