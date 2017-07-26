package com.kids;

import static com.kids.util.KidsConstant.URL_WEB_DEV;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String URL_AUTORIZADA = URL_WEB_DEV;





    @Override
    protected void configure(final HttpSecurity http) throws Exception {
	http.headers()//
	        .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", URL_AUTORIZADA));

    }
}