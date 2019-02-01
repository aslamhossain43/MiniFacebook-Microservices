package com.renu.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {
	private static final Logger LOGGER=LoggerFactory.getLogger(RouteFilter.class);

	@Override
	public boolean shouldFilter() {
		/*RequestContext requestContext=RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest=requestContext.getRequest();
		String requestURL=httpServletRequest.getRequestURL().toString();
		return requestURL.contains("/getprofilephotoinformation/*")||requestURL.contains("/profileimageadd")||
				requestURL.contains("/getprofilephoto");*/
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		/*RequestContext requestContext=RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest=requestContext.getRequest();
		String requestURL=httpServletRequest.getRequestURL().toString();
		   if (!requestURL.contains("http://192.168.1.105:8082/photo/uid/")) {
			requestContext.put(requestURL, "http://192.168.1.105:8083/photo/uid/");
		}
		   if (!requestURL.contains("http://192.168.1.105:8082/image/addImage")) {
				requestContext.put(requestURL, "http://192.168.1.105:8083/image/addImage");
			}
		   if (!requestURL.contains("http://192.168.1.105:8082/image/getProfilePhoto")) {
				requestContext.put(requestURL, "http://192.168.1.105:8083/image/getProfilePhoto");
			}*/
		
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "route";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
