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
import co.innovaciones.model.Armada;
import co.innovaciones.service.ArmadaService;

@Controller
@RequestMapping("/armadas")
public class ArmadaController {

	private static final String MSG_SUCESS_INSERT = "Armada inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Armada successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Armada successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ArmadaService armadaService;

	@GetMapping
	public String index(Model model) {
		List<Armada> all = armadaService.findAll();
		model.addAttribute("listArmada", all);
		return "armada/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Armada> armada = armadaService.findById(id);
			
			if (armada.isPresent())
				model.addAttribute("armada", armada.get());
		}
		return "armada/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Armada entity) {
		model.addAttribute("armada", entity);
		return "armada/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Armada entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Armada armada = null;
		try {
			armada = armadaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/armadas/" + armada.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Armada> entity = armadaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("armada", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "armada/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Armada entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Armada armada = null;
		try {
			armada = armadaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/armadas/" + armada.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Armada> entity = armadaService.findById(id);
				
				if (entity.isPresent()) {
					armadaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/armadas";
	}

}
