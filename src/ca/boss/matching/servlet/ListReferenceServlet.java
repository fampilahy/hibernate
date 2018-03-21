//package ca.boss.matching.servlet;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import ca.boss.matching.control.ListReferenceHandler;
//import ca.boss.matching.model.bean.Reference;
//import ca.boss.matching.model.dao.DaoFactory;
//import static ca.boss.config.DaoFactoryInitializer.DAOFACTORY_KEY;
//import static ca.boss.config.DaoFactoryInitializer.DAOFACTORY_ERROR_KEY;
//public class ListReferenceServlet extends HttpServlet{
//	
//	private static final String LIST_REFERENCE_VIEW = "/WEB-INF/matching/ListReferenceView.jsp";
//	private static final String LIST_REFERENCE_ERROR = "listReferenceError";
//	private static final String REFERENCES = "references";
//	private DaoFactory daoFactory;
//	public void init(){
//		this.daoFactory = (DaoFactory) this.getServletContext().getAttribute(DAOFACTORY_KEY);
//	}
//	
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		ListReferenceHandler  listReferenceHandler = ListReferenceHandler.getDefault(daoFactory);
//		List<Reference> references = listReferenceHandler.listReferences();
//		request.setAttribute(REFERENCES, references);
//		request.setAttribute(LIST_REFERENCE_ERROR, listReferenceHandler.getListReferencesMessageError());
//		request.setAttribute(DAOFACTORY_ERROR_KEY, request.getServletContext().getAttribute(DAOFACTORY_ERROR_KEY));
//		this.getServletContext().getRequestDispatcher(LIST_REFERENCE_VIEW).forward(request, response);
//	}
//
//}
