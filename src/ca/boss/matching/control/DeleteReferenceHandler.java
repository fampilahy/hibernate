package ca.boss.matching.control;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import ca.boss.matching.model.bean.Reference;
import ca.boss.matching.model.dao.DaoException;
import ca.boss.matching.model.dao.DaoFactory;
import ca.boss.matching.model.dao.ReferenceDao;

public class DeleteReferenceHandler {
	
	private DaoFactory daoFactory  ;
	private String deleteReferenceErrorMessage;
	
	
	public String getDeleteReferenceErrorMessage() {
		return deleteReferenceErrorMessage;
	}

	private DeleteReferenceHandler(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	public static final DeleteReferenceHandler getDefault(DaoFactory daoFactory){
		return new DeleteReferenceHandler(daoFactory);
	}
	
	private static String ID_KEY = "referenceid";
	
	public void doAction(HttpServletRequest request){
		String idRaw;
		Integer integer = null ;
		try {
			 idRaw = getValue(request,ID_KEY, true);
			 integer = Integer.parseInt(idRaw);
		} catch (Exception e) {
			deleteReferenceErrorMessage = "deleteReference - "+e.getMessage();
		}
		
		ReferenceDao referenceDao = daoFactory.getReferenceDao();
		try {
			referenceDao.deleteReference(integer);
		} catch (DaoException e) {
			deleteReferenceErrorMessage = "deleteReference - "+e.getMessage();
		}
		
	}
	
	public Integer deleteReference(Reference reference){
		return deleteReference(reference.getId());
	}
	
	public Integer deleteReference(int id){
		return null;
	}
	
	
	private String getValue(HttpServletRequest request, String key, boolean required) throws Exception {
		String value = null;

		try {
			value = request.getParameter(key);
		} catch (Exception e) {
			if (required == true)
				throw new DeleteReferenceException("missing required field " + key);
		}

		if (StringUtils.isBlank(value)) {
			if (required == true)
				throw new DeleteReferenceException("blank required field " + key);
		}
		return value;
	}
	

}
