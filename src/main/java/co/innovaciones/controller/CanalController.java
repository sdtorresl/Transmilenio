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
import co.innovaciones.model.Canal;
import co.innovaciones.service.CanalService;

@Controller
@RequestMapping("/canals")
public class CanalController {

	private static final String MSG_SUCESS_INSERT = "Canal inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Canal successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Canal successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CanalService canalService;

	@GetMapping
	public String index(Model model) {
		List<Canal> all = canalService.findAll();
		model.addAttribute("listCanal", all);
		return "canal/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Canal> canal = canalService.findById(id);
			
			if (canal.isPresent())
				model.addAttribute("canal", canal.get());
		}
		return "canal/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Canal entity) {
		model.addAttribute("canal", entity);
		return "canal/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Canal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Canal canal = null;
		try {
			canal = canalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/canals/" + canal.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Canal> entity = canalService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("canal", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "canal/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Canal entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Canal canal = null;
		try {
			canal = canalService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/canals/" + canal.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Canal> entity = canalService.findById(id);
				
				if (entity.isPresent()) {
					canalService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/canals";
	}

}
