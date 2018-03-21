package ca.boss.matching.servlet;

import static ca.boss.config.DaoFactoryInitializer.DAOFACTORY_KEY;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static  ca.boss.config.DaoFactoryInitializer.DAOFACTORY_ERROR_KEY;
import ca.boss.matching.control.CreateReferenceHandler;
import ca.boss.matching.model.dao.DaoFactory;;
public class CreateReferenceServlet extends HttpServlet {

	private static final String CREATE_REFERENCE_VIEW = "/WEB-INF/matching/CreateReferenceView.jsp";
	private static final String ERRORS_KEY = "errors";
	private static final String REFERENCE_KEY = "reference";
	private static final String MESSAGE_KEY = "message";
	
	private DaoFactory daoFactory =null;
	
	public void init(){
		daoFactory = (DaoFactory) this.getServletContext().getAttribute(DAOFACTORY_KEY);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(CREATE_REFERENCE_VIEW).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CreateReferenceHandler createReferenceHandler = CreateReferenceHandler.getDefault(daoFactory);
		createReferenceHandler.validateForm(request);
		request.setAttribute(ERRORS_KEY, createReferenceHandler.getErrors());
		request.setAttribute(REFERENCE_KEY, createReferenceHandler.getReference());
		request.setAttribute(MESSAGE_KEY, createReferenceHandler.getMessage());
		request.setAttribute(DAOFACTORY_ERROR_KEY, this.getServletContext().getAttribute(DAOFACTORY_ERROR_KEY));
		
		doGet(request, response);
	}
}
