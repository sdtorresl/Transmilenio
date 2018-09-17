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
import co.innovaciones.model.Bombaagua;
import co.innovaciones.service.BombaaguaService;

@Controller
@RequestMapping("/bombaaguas")
public class BombaaguaController {

	private static final String MSG_SUCESS_INSERT = "Bombaagua inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Bombaagua successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Bombaagua successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private BombaaguaService bombaaguaService;

	@GetMapping
	public String index(Model model) {
		List<Bombaagua> all = bombaaguaService.findAll();
		model.addAttribute("listBombaagua", all);
		return "bombaagua/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Bombaagua> bombaagua = bombaaguaService.findById(id);
			
			if (bombaagua.isPresent())
				model.addAttribute("bombaagua", bombaagua.get());
		}
		return "bombaagua/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Bombaagua entity) {
		model.addAttribute("bombaagua", entity);
		return "bombaagua/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Bombaagua entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Bombaagua bombaagua = null;
		try {
			bombaagua = bombaaguaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/bombaaguas/" + bombaagua.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Bombaagua> entity = bombaaguaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("bombaagua", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "bombaagua/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Bombaagua entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Bombaagua bombaagua = null;
		try {
			bombaagua = bombaaguaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/bombaaguas/" + bombaagua.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Bombaagua> entity = bombaaguaService.findById(id);
				
				if (entity.isPresent()) {
					bombaaguaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/bombaaguas";
	}

}
