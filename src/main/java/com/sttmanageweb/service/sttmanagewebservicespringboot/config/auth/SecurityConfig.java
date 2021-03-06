
package com.sttmanageweb.service.sttmanagewebservicespringboot.config.auth;


import com.sttmanageweb.service.sttmanagewebservicespringboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() //(2)
                .and()
                .authorizeRequests() //(3)
                .antMatchers("/loginpage","/css/**","/images/**","/js/**","/h2-console/**","/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //(4)
                .anyRequest().authenticated() //(5)
                .and()
                .formLogin()
                .loginPage("/loginpage")
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutSuccessUrl("/loginpage") //(6)
                .and()
                .oauth2Login() //(7)
                .userInfoEndpoint() //(8)
                .userService(customOAuth2UserService); //(9)

    }
}


//package com.sttmanageweb.service.sttmanagewebservicespringboot.config.auth;
//
//
//        import com.sttmanageweb.service.sttmanagewebservicespringboot.domain.user.Role;
//        import lombok.RequiredArgsConstructor;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Autowired
//    private final CustomOAuth2UserService customOAuth2UserService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .headers().frameOptions().disable() //(2)
//                .and()
//                .authorizeRequests() //(3)
//                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**","/profile").permitAll()
//                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //(4)
//                .anyRequest().authenticated() //(5)
//                .and()
//                .logout()
//                .logoutSuccessUrl("/") //(6)
//                .and()
//                .oauth2Login() //(7)
//                .userInfoEndpoint() //(8)
//                .userService(customOAuth2UserService); //(9)
//
//    }
//}
//
//
