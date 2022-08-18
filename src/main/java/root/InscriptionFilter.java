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

@WebFilter("/inscriptionFilter")
public class InscriptionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                String password =  request.getParameter("password");
                if(password.length()<4){
                    Map<String, String> messages = new HashMap<String, String>();
                    request.setAttribute("messages", messages);
                    messages.put("error", "message trop court");
                    request.getRequestDispatcher("inscription.jsp").forward(request, response);
                     
                }else{
                    chain.doFilter(request, response); 
                }
        
    }
}
