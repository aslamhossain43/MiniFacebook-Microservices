package com.renu.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ErrorFilter extends ZuulFilter{
private  static final Logger LOGGER=LoggerFactory.getLogger(ErrorFilter.class);
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext=RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest=requestContext.getRequest();
		LOGGER.info("Request Method : " + httpServletRequest.getMethod() + " Request URL : " + httpServletRequest.getRequestURL().toString());
	    
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
