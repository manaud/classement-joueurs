package fr.mable.classement.joueurs.services.WS;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * CORS Filter nécessaire pour AngularJS
 * @author mable
 */
public class ResponseCorsFilter implements Filter {

    private final static Logger log = Logger.getLogger(ResponseCorsFilter.class.getName());

    /**
     *
     * @param fc
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
          log.info("Executing REST response filter");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");

        chain.doFilter(request, response);

    }

    /**
     *
     */
    @Override
    public void destroy() {
    }
}
