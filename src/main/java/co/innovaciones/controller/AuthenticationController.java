package co.innovaciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * Controller class to handle user authentication
 *
 * @author sdtorresl
 * @author ndariass
 */
@Controller
public class AuthenticationController {
	
	private static final String INFO = "info";
	private static final String ERROR = "error";
	private static final String SUCCESS = "success";
	private static final String ALREADY_LOGGED_IN = "Ya ha inciado sesión.";
	private static final String LOGIN_ERROR = "Error en al iniciar sesión, credenciales incorrectas.";
	private static final String LOGOUT_SUCCESSFUL = "Ha cerrado sesión con éxito.";
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout,
						Model model, Principal principal, RedirectAttributes flash) {
		
		if (principal != null) {
			flash.addFlashAttribute(INFO, ALREADY_LOGGED_IN);
			return "redirect:/";
		}
		
		if (error != null) {
			model.addAttribute(ERROR, LOGIN_ERROR);
		}
		
		if (logout != null) {
			model.addAttribute(SUCCESS, LOGOUT_SUCCESSFUL);
		}
		
		return "authentication/login";
	}
}
