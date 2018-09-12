package co.innovaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * {@link WebSecurityConfigurerAdapter} implementation to define the application access rules.
 *
 * @author ndariass
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] ANT_MATCHERS = {"/css/**", "/js/**", "/img/**", "/fonts/**", "/sass/**"};
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers(ANT_MATCHERS).permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout().permitAll();
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		User.UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		build.inMemoryAuthentication()
				.withUser(users.username("admin").password("admin").roles("ROLE_ADMIN"));
	}
}
