package com.subho;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.subho.util.SpringUtils;

import lombok.extern.slf4j.Slf4j;

@WebServlet(urlPatterns = { "/subhoodata.svc/*" })
/*
, initParams = {
		@WebInitParam(name = "javax.ws.rs.Application", value = "org.apache.olingo.odata2.core.rest.app.ODataApplication"),
		@WebInitParam(name = "org.apache.olingo.odata2.service.factory", value = "com.sap.dbs.dbx.i068191.annotation.processor.MyODataProcessor") 
		}
*/
//)
@Slf4j
public class BuilderODataServlet extends ODataServlet {
 
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BuilderODataServlet.class);
	private static final long serialVersionUID = -4563879895896080797L;

	private String oDataServiceFactoryBeanName = "com.subho.processor.MyODataServiceFactory";

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		ApplicationContext applicationContext = SpringUtils.getApplicationContext();

		if (applicationContext == null) {
			log.error("applicationContext is null, error!");
			return;
		}

		ODataServiceFactory oDataServiceFactory = (ODataServiceFactory) applicationContext
				.getBean(this.oDataServiceFactoryBeanName);
		req.setAttribute("org.apache.olingo.odata2.service.factory.instance", oDataServiceFactory);
		super.service(req, resp);
	}

	public String getoDataServiceFactoryBeanName() {
		return oDataServiceFactoryBeanName;
	}

	public void setoDataServiceFactoryBeanName(String oDataServiceFactoryBeanName) {
		this.oDataServiceFactoryBeanName = oDataServiceFactoryBeanName;
	}
}
