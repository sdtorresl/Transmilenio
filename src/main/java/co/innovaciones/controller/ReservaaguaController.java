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
import co.innovaciones.model.Reservaagua;
import co.innovaciones.service.ReservaaguaService;

@Controller
@RequestMapping("/reservaaguas")
public class ReservaaguaController {

	private static final String MSG_SUCESS_INSERT = "Reservaagua inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Reservaagua successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Reservaagua successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ReservaaguaService reservaaguaService;

	@GetMapping
	public String index(Model model) {
		List<Reservaagua> all = reservaaguaService.findAll();
		model.addAttribute("listReservaagua", all);
		return "reservaagua/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Reservaagua> reservaagua = reservaaguaService.findById(id);
			
			if (reservaagua.isPresent())
				model.addAttribute("reservaagua", reservaagua.get());
		}
		return "reservaagua/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Reservaagua entity) {
		model.addAttribute("reservaagua", entity);
		return "reservaagua/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Reservaagua entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Reservaagua reservaagua = null;
		try {
			reservaagua = reservaaguaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/reservaaguas/" + reservaagua.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Reservaagua> entity = reservaaguaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("reservaagua", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "reservaagua/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Reservaagua entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Reservaagua reservaagua = null;
		try {
			reservaagua = reservaaguaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/reservaaguas/" + reservaagua.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Reservaagua> entity = reservaaguaService.findById(id);
				
				if (entity.isPresent()) {
					reservaaguaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/reservaaguas";
	}

}
