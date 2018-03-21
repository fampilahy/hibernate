//package ca.boss.config;
//
//import javax.servlet.ServletRequestEvent;
//import javax.servlet.ServletRequestListener;
//
//import ca.boss.matching.model.dao.DaoConfigurationException;
//import ca.boss.matching.model.dao.DaoFactory;
//
//public class DaoFactoryInitializer implements ServletRequestListener {
//
//	public static final String DAOFACTORY_KEY = "daofactory";
//	public static final String DAOFACTORY_ERROR_KEY = "initializedaoerror";
//	
//	@Override
//	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
//		}
//
//	@Override
//	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
//		DaoFactory daoFactory = null;
//		try {
//			daoFactory = DaoFactory.getInstance();
//		} catch (DaoConfigurationException e) {
//			servletRequestEvent.getServletContext().setAttribute(DAOFACTORY_ERROR_KEY, ""+e.getMessage());
//		}
//		servletRequestEvent.getServletContext().setAttribute(DAOFACTORY_KEY, daoFactory);
//	}
//		
//
//}
