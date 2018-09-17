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
import co.innovaciones.model.Neopreno;
import co.innovaciones.service.NeoprenoService;

@Controller
@RequestMapping("/neoprenos")
public class NeoprenoController {

	private static final String MSG_SUCESS_INSERT = "Neopreno inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Neopreno successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Neopreno successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private NeoprenoService neoprenoService;

	@GetMapping
	public String index(Model model) {
		List<Neopreno> all = neoprenoService.findAll();
		model.addAttribute("listNeopreno", all);
		return "neopreno/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Neopreno> neopreno = neoprenoService.findById(id);
			
			if (neopreno.isPresent())
				model.addAttribute("neopreno", neopreno.get());
		}
		return "neopreno/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Neopreno entity) {
		model.addAttribute("neopreno", entity);
		return "neopreno/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Neopreno entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Neopreno neopreno = null;
		try {
			neopreno = neoprenoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/neoprenos/" + neopreno.getId();
	}
	
	@GetMapping("/edit/{id}")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Neopreno> entity = neoprenoService.findById(id);
				
				if (entity.isPresent())
					model.addAttribute("neopreno", entity.get());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "neopreno/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Neopreno entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Neopreno neopreno = null;
		try {
			neopreno = neoprenoService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/neoprenos/" + neopreno.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Neopreno> entity = neoprenoService.findById(id);
				
				if (entity.isPresent()) {
					neoprenoService.delete(entity.get());
					redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
				} else {
					redirectAttributes.addFlashAttribute("error", MSG_ERROR);
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/neoprenos";
	}

}
