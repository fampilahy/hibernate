package ca.boss.matching.model.dao;

import java.util.List;

import ca.boss.matching.model.bean.Reference;



public interface ReferenceDao {

	public Integer createReference(Reference reference) throws DaoException;

	public List<Reference> searchReference(Reference reference);
	
	public List<Reference> listReferences() throws DaoException;

	public Reference getReference(String id);
	
	public Integer deleteReference(Integer id) throws DaoException;

}
