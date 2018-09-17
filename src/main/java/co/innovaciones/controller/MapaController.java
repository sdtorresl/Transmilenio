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
import co.innovaciones.model.Mapa;
import co.innovaciones.service.MapaService;

@Controller
@RequestMapping("/mapas")
public class MapaController {

	private static final String MSG_SUCESS_INSERT = "Mapa inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Mapa successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Mapa successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private MapaService mapaService;

	@GetMapping
	public String index(Model model) {
		List<Mapa> all = mapaService.findAll();
		model.addAttribute("listMapa", all);
		return "mapa/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Mapa> mapa = mapaService.findById(id);
			
			if (mapa.isPresent())
				model.addAttribute("mapa", mapa.get());
		}
		return "mapa/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Mapa entity) {
		model.addAttribute("mapa", entity);
		return "mapa/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Mapa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Mapa mapa = null;
		try {
			mapa = mapaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/mapas/" + mapa.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Mapa> entity = mapaService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("mapa", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "mapa/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Mapa entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Mapa mapa = null;
		try {
			mapa = mapaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/mapas/" + mapa.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Mapa> entity = mapaService.findById(id);
				
				if (entity.isPresent()) {
					mapaService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/mapas";
	}

}
