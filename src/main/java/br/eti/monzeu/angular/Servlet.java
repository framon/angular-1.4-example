package br.eti.monzeu.angular;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.jsonrpc4j.JsonRpcServer;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JsonRpcServer jsonRpcServer;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        jsonRpcServer.handle(request, response);
    }

    @Override
    public void init(ServletConfig config) {
        final String name = "jsonRpcServer";
        final ServletContext servletContext = config.getServletContext();

        jsonRpcServer = (JsonRpcServer) servletContext.getAttribute(name);
        if (jsonRpcServer == null) {
            jsonRpcServer = new JsonRpcServer(new ServiceImpl(), Service.class);
            servletContext.setAttribute(name, jsonRpcServer);
        }
    }

}
