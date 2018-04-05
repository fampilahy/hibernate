package ca.boss.matching.servlet;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.boss.matching.control.CreateReferenceHandler;
import ca.boss.matching.model.dao.ReferenceDaoImplementation;;
public class CreateReferenceServlet extends HttpServlet {

	private static final String CREATE_REFERENCE_VIEW = "/WEB-INF/matching/CreateReferenceView.jsp";
	private static final String ERRORS_KEY = "errors";
	private static final String REFERENCE_KEY = "reference";
	private static final String MESSAGE_KEY = "message";
	
	@EJB
	private ReferenceDaoImplementation refenceDaoImplementation;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(CREATE_REFERENCE_VIEW).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CreateReferenceHandler createReferenceHandler = CreateReferenceHandler.getDefault(refenceDaoImplementation);
		createReferenceHandler.validateForm(request);
		request.setAttribute(ERRORS_KEY, createReferenceHandler.getErrors());
		request.setAttribute(REFERENCE_KEY, createReferenceHandler.getReference());
		request.setAttribute(MESSAGE_KEY, createReferenceHandler.getMessage());
//		request.setAttribute(DAOFACTORY_ERROR_KEY, this.getServletContext().getAttribute(DAOFACTORY_ERROR_KEY));
		
		doGet(request, response);
	}
}
