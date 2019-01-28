package com.renu.zuul.cross_origin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.renu.zuul.filter.ErrorFilter;
import com.renu.zuul.filter.PostFilter;
import com.renu.zuul.filter.PreFilter;
import com.renu.zuul.filter.RouteFilter;



@Configuration
public class ZuulFilterConfig {
	@Bean
	public PreFilter preFilter() {
	    return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
	    return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	    return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
	    return new RouteFilter();
	}
}
