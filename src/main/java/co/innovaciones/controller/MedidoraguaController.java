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
import co.innovaciones.model.Medidoragua;
import co.innovaciones.service.MedidoraguaService;

@Controller
@RequestMapping("/medidoraguas")
public class MedidoraguaController {

	private static final String MSG_SUCESS_INSERT = "Medidoragua inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Medidoragua successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Medidoragua successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private MedidoraguaService medidoraguaService;

	@GetMapping
	public String index(Model model) {
		List<Medidoragua> all = medidoraguaService.findAll();
		model.addAttribute("listMedidoragua", all);
		return "medidoragua/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Medidoragua> medidoragua = medidoraguaService.findById(id);
			
			if (medidoragua.isPresent())
				model.addAttribute("medidoragua", medidoragua.get());
		}
		return "medidoragua/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Medidoragua entity) {
		model.addAttribute("medidoragua", entity);
		return "medidoragua/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Medidoragua entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Medidoragua medidoragua = null;
		try {
			medidoragua = medidoraguaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/medidoraguas/" + medidoragua.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Medidoragua> entity = medidoraguaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("medidoragua", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "medidoragua/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Medidoragua entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Medidoragua medidoragua = null;
		try {
			medidoragua = medidoraguaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/medidoraguas/" + medidoragua.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Medidoragua> entity = medidoraguaService.findById(id);
				
				if (entity.isPresent()) {
					medidoraguaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/medidoraguas";
	}

}
