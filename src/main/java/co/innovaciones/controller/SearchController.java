package co.innovaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.innovaciones.model.Estacion;
import co.innovaciones.service.EstacionService;
import co.innovaciones.model.Troncal;
import co.innovaciones.service.TroncalService;
import co.innovaciones.model.Estado;
import co.innovaciones.service.EstadoService;

/**
 * Controller class to handle user authentication
 *
 * @author sdtorresl
 * @author ndariass
 */
@Controller
@RequestMapping({"/"})
public class SearchController {

	@Autowired
	private EstacionService estacionService;

	@Autowired
	private TroncalService troncalService;

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/")
	public String search(Model model, RedirectAttributes flash) {	
		List<Estacion> estaciones = estacionService.findAll();
		model.addAttribute("estaciones", estaciones);

		List<Troncal> troncales = troncalService.findAll();
		model.addAttribute("troncales", troncales);

		List<Estado> estados = estadoService.findAll();
		model.addAttribute("estados", estados);

		return "search/index";
	}
}
