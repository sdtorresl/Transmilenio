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
import co.innovaciones.model.Extractor;
import co.innovaciones.service.ExtractorService;

@Controller
@RequestMapping("/extractors")
public class ExtractorController {

	private static final String MSG_SUCESS_INSERT = "Extractor inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Extractor successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Extractor successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ExtractorService extractorService;

	@GetMapping
	public String index(Model model) {
		List<Extractor> all = extractorService.findAll();
		model.addAttribute("listExtractor", all);
		return "extractor/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Extractor> extractor = extractorService.findById(id);
			
			if (extractor.isPresent())
				model.addAttribute("extractor", extractor.get());
		}
		return "extractor/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Extractor entity) {
		model.addAttribute("extractor", entity);
		return "extractor/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Extractor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Extractor extractor = null;
		try {
			extractor = extractorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/extractors/" + extractor.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Extractor> entity = extractorService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("extractor", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "extractor/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Extractor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Extractor extractor = null;
		try {
			extractor = extractorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/extractors/" + extractor.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Extractor> entity = extractorService.findById(id);
				
				if (entity.isPresent()) {
					extractorService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/extractors";
	}

}
