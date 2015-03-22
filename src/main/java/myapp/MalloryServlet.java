package myapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;
import javax.servlet.http.*;

public class MalloryServlet extends HttpServlet {
    Logger log = Logger.getAnonymousLogger();
    byte[] stevePng = new byte[1350];

    public MalloryServlet() throws IOException {
	FileInputStream file = new FileInputStream("steve.png");
	file.read(stevePng);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
	log.warning(String.format("IP: %s", req.getRemoteAddr()));
	log.warning(String.format("Port: %d", req.getRemotePort()));
	Enumeration<String> headers = req.getHeaderNames();
	while(headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            log.warning(String.format("%s: %s", headerName, req.getHeader(headerName)));
        }
        resp.setContentType("image/png");
        resp.getOutputStream().write(stevePng);
    }
}
