package ca.boss.matching.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.boss.matching.control.DeleteReferenceHandler;
import ca.boss.matching.model.dao.DaoFactory;
import static ca.boss.config.DaoFactoryInitializer.DAOFACTORY_ERROR_KEY;
import static ca.boss.config.DaoFactoryInitializer.DAOFACTORY_KEY;
public class DeleteReferenceServlet extends HttpServlet {

	
	private static final String LIST_REFERENCE_VIEW = "/matching/listreference";

	
	private DaoFactory daoFactory;
	public void init(){
		daoFactory = (DaoFactory) this.getServletContext().getAttribute(DAOFACTORY_KEY);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DeleteReferenceHandler deleteReferenceHandler = DeleteReferenceHandler.getDefault(daoFactory);
		deleteReferenceHandler.doAction(request);
		// TODO
		// do delete here
		// redirect to list
		response.sendRedirect(request.getContextPath() +  LIST_REFERENCE_VIEW);

	}

}
