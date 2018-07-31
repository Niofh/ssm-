package com.oufuhua.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * URL www.xxx.com?jsessionidFilter=xxx，把jsessionidFilter的参数去掉，不在网页显示
 */
public class DisableUrlSessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);  
            return;  
        }  
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
  
        if (httpRequest.isRequestedSessionIdFromURL()) {  
            HttpSession session = httpRequest.getSession();
            if (session != null)  
                session.invalidate();  
        }  
        
        // wrap response to remove URL encoding  
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
            @Override  
            public String encodeRedirectUrl(String url) {  
                return url;  
            }
            @Override
            public String encodeRedirectURL(String url) {  
                return url;  
            }
            @Override
            public String encodeUrl(String url) {  
                return url;  
            }
            @Override
            public String encodeURL(String url) {  
                return url;  
            }  
        };  
        chain.doFilter(request, wrappedResponse);  
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
    }
    @Override
    public void destroy() {  
    }  
}  