package com.hjpatel16.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/*http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/IND
 * 
 * http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR*/

/*can implement rate limits, authorization, authentication, service aggregation*/
@Component
public class ZuulLoggingFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("request -> {}, request api -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// To check whether to execute the filter
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		// what type of filtering to use - pre, post, error
		return "pre";
	}

	
}
