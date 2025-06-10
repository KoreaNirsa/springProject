//package kr.co.green.global.filter;
//
//import java.io.IOException;
//import java.util.Enumeration;
//
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@Component
//@WebFilter("/*")
//public class RequestLoggingFilter implements Filter {
//	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
//		throws IOException, ServletException {
////		requestDetails((HttpServletRequest)request);
//		
//		HttpServletRequest httpRequest = (HttpServletRequest)request;
//		HttpServletResponse httpResponse = (HttpServletResponse)response;
//		
//		HttpSession session = httpRequest.getSession();
//		
//		Object id = session.getAttribute("id");
//		
//		String path = httpRequest.getServletPath();
//		
//		if(id == null && !isExcludePath(path)) {
//			httpResponse.sendRedirect("/member/login/form");
//			return;
//		}
//		
//		
//		chain.doFilter(request, response);
//	}
//	
//	private boolean isExcludePath(String path) {
//		return path.startsWith("/css") ||
//				path.startsWith("/js") ||
//				path.equals("/member/login") ||
//				path.equals("/member/login/form") ||
//				path.equals("/member/register") ||
//				path.equals("/member/register/form");
//	}
//	
//	private void requestDetails(HttpServletRequest request) {
//		StringBuilder sb = new StringBuilder();
//		
//		// "요청 정보 : " + "ip=" + request.getRemoteAddr() + ", "
//		
//		sb.append("요청 정보 : ");
//		sb.append("ip=").append(request.getRemoteAddr()).append(", ");
//		sb.append("method=").append(request.getMethod()).append(", ");
//		sb.append("url=").append(request.getRequestURL()).append(", ");
//		
//		Enumeration<String> headerNames = request.getHeaderNames();
//		
//		sb.append("headers=[");
//		while(headerNames.hasMoreElements()) {
//			String headerName = headerNames.nextElement();
//			String headerValue = request.getHeader(headerName);
//			sb.append(headerName).append("=").append(headerValue).append(", ");
//		}
//		sb.append("]");
//		
//		System.out.println(sb);
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
