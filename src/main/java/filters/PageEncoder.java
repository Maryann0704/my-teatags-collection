package filters;

import javax.servlet.*;
import java.io.IOException;

public class PageEncoder implements Filter {
    private String encode;

    @Override
    public void init(FilterConfig filterConfig) {
        this.encode = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String responseEncoding = response.getCharacterEncoding();
        if (encode != null && !encode.equalsIgnoreCase(responseEncoding))
            response.setCharacterEncoding(encode);

        String requestEncoding = request.getCharacterEncoding();
        if (encode != null && !encode.equalsIgnoreCase(requestEncoding))
            request.setCharacterEncoding(encode);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        this.encode = null;
    }
}
