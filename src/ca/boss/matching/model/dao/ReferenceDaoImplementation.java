package ca.boss.matching.model.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ca.boss.matching.model.bean.Reference;

@Stateless
public class ReferenceDaoImplementation {
	
	
	public ReferenceDaoImplementation(){
		
	}
	
	
    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM reference u WHERE u.title=:title";
    private static final String PARAM_EMAIL           = "title";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "boss_PU" )
    private EntityManager       em;

    // Enregistrement d'une nouvelle reference
    public void creer( Reference reference ) throws DaoException {
        try {
            em.persist( reference );
        } catch ( Exception e ) {
            throw new DaoException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Reference trouver( String title ) throws DaoException {
        Reference reference = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, title );
        try {
        	reference = (Reference) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DaoException( e );
        }
        return reference;
    }
}