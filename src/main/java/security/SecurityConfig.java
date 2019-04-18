package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*@Autowired
    private DataSource dataSource;*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin1234")).roles("ADMIN")
        .and().withUser("username").password(passwordEncoder().encode("user1234")).roles("USER");
       // auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as username,password ,true from users where username=?")
               // .authoritiesByUsernameQuery("select username as username,role as role from users_role where username=?").rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //definir les stratégies des securité
      /* http.formLogin().loginPage("/login");
        http.authorizeRequests().antMatchers("/consultercompte","/operations").hasRole("USER").and().httpBasic();
        http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN").and().httpBasic();*/
      //http.csrf().disable();
     http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        //http.authorizeRequests().antMatchers("/rest/*").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
}
@Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
