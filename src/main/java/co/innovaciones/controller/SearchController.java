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
	
	private static final String INFO = "info";
	private static final String ERROR = "error";
	private static final String SUCCESS = "success";
	private static final String ALREADY_LOGGED_IN = "Ya ha inciado sesión.";
	private static final String LOGIN_ERROR = "Error en al iniciar sesión, credenciales incorrectas.";
	private static final String LOGOUT_SUCCESSFUL = "Ha cerrado sesión con éxito.";
	
	@GetMapping("/")
	public String search(Model model, RedirectAttributes flash) {	
		List<Estacion> estaciones = estacionService.findAll();
		model.addAttribute("estaciones", estaciones);

		return "search/index";
	}
}
