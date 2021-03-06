package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@SpringBootApplication
@EnableWebSecurity
@Configuration
public class WebshopApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/", "/register.html",
						"product.html**", "/js/**", "/css/**", "/img/**", "/fonts/**", "/userdata", "/basket", "/users", "/api" +
								"/categories", "/api/category/**", "/api/product/recommend").permitAll()
				.antMatchers("/basket.html", "/orders", "/myorders", "/myorders/storedaddresses", "/orders/shippingaddresses",
						"/basket", "/basket/update", "/basketitem/**").authenticated()
				.antMatchers("/myorders.html", "/profile.html", "/api/user/**").hasRole("USER")
				.antMatchers("order.html", "/orders.html", "/dashboard.html", "/users.html", "/adminproducts.html", "/dashboard",
						"/reports/**", "/api/users", "/api/users/**", "api/products", "api/product/**",
						"/orders/**", "orders/**/**", "/orders/filtered/**", "/basket/**", "/categories.html", "api/categories/update").hasRole(
						"ADMIN")
				.and()
				.formLogin().loginPage("/login.html")
				.loginProcessingUrl("/login")
				.and()
				.logout()
				.logoutSuccessUrl("/");
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource, PasswordEncoder passwordEncoder) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username = ?");

	}

}
