package webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
}
