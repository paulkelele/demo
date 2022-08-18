package root;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames = "inscription")
public class InscriptionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
 
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                HttpServletRequest req = (HttpServletRequest) request;
                HttpServletResponse resp = (HttpServletResponse) response;
                String password =  req.getParameter("password");
                if(password.length()<4){
                    Map<String, String> messages = new HashMap<String, String>();
                    req.setAttribute("messages", messages);
                    messages.put("error", "message trop court");
                    resp.sendRedirect("inscription");
                    return;
                }else{
                    chain.doFilter(req, resp); 
                }
        
    }
}
