package ding.personal

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity


@Configuration
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    fun configure(http: HttpSecurity) {
        http.requestMatchers().antMatchers("/users/all").permitAll()
    }
}