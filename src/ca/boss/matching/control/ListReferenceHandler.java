//package ca.boss.matching.control;
//
//import java.util.List;
//
//import ca.boss.matching.model.bean.Reference;
//import ca.boss.matching.model.dao.DaoException;
//import ca.boss.matching.model.dao.DaoFactory;
//import ca.boss.matching.model.dao.ReferenceDao;
//
//public class ListReferenceHandler {
//	
//	private DaoFactory daoFactory;
//	private String listReferencesMessageError ;
//	
//	public String getListReferencesMessageError() {
//		return listReferencesMessageError;
//	}
////	public void setListReferenceError(String listReferenceError) {
////		this.listReferencesMessageError = listReferenceError;
////	}
//	private ListReferenceHandler(DaoFactory daoFactory){
//		this.daoFactory  = daoFactory;
//	}
//	public static ListReferenceHandler getDefault(DaoFactory daoFactory){
//		return new ListReferenceHandler(daoFactory);
//	}
//	
//	public List<Reference> listReferences (){
//		List<Reference> references = null;
//		try {
//			ReferenceDao referenceDao = daoFactory.getReferenceDao();
//			references = referenceDao.listReferences();
//		} catch (Exception e) {
//			listReferencesMessageError = ""+e.getMessage();
//		}
//		return references;
//	}
//
//}
