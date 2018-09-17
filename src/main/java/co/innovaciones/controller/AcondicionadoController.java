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
import co.innovaciones.model.Acondicionado;
import co.innovaciones.service.AcondicionadoService;

@Controller
@RequestMapping("/acondicionados")
public class AcondicionadoController {

	private static final String MSG_SUCESS_INSERT = "Acondicionado inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Acondicionado successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Acondicionado successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private AcondicionadoService acondicionadoService;

	@GetMapping
	public String index(Model model) {
		List<Acondicionado> all = acondicionadoService.findAll();
		model.addAttribute("listAcondicionado", all);
		return "acondicionado/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Acondicionado> acondicionado = acondicionadoService.findById(id);
			
			if (acondicionado.isPresent())
				model.addAttribute("acondicionado", acondicionado.get());
		}
		return "acondicionado/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Acondicionado entity) {
		model.addAttribute("acondicionado", entity);
		return "acondicionado/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Acondicionado entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Acondicionado acondicionado = null;
		try {
			acondicionado = acondicionadoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/acondicionados/" + acondicionado.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Acondicionado> entity = acondicionadoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("acondicionado", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "acondicionado/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Acondicionado entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Acondicionado acondicionado = null;
		try {
			acondicionado = acondicionadoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/acondicionados/" + acondicionado.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Acondicionado> entity = acondicionadoService.findById(id);
				
				if (entity.isPresent()) {
					acondicionadoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/acondicionados";
	}

}
