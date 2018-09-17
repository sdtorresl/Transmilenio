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
import co.innovaciones.model.Toteminfor;
import co.innovaciones.service.ToteminforService;

@Controller
@RequestMapping("/toteminfors")
public class ToteminforController {

	private static final String MSG_SUCESS_INSERT = "Toteminfor inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Toteminfor successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Toteminfor successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ToteminforService toteminforService;

	@GetMapping
	public String index(Model model) {
		List<Toteminfor> all = toteminforService.findAll();
		model.addAttribute("listToteminfor", all);
		return "toteminfor/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Toteminfor> toteminfor = toteminforService.findById(id);
			
			if (toteminfor.isPresent())
				model.addAttribute("toteminfor", toteminfor.get());
		}
		return "toteminfor/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Toteminfor entity) {
		model.addAttribute("toteminfor", entity);
		return "toteminfor/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Toteminfor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Toteminfor toteminfor = null;
		try {
			toteminfor = toteminforService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/toteminfors/" + toteminfor.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Toteminfor> entity = toteminforService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("toteminfor", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "toteminfor/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Toteminfor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Toteminfor toteminfor = null;
		try {
			toteminfor = toteminforService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/toteminfors/" + toteminfor.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Toteminfor> entity = toteminforService.findById(id);
				
				if (entity.isPresent()) {
					toteminforService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/toteminfors";
	}

}
