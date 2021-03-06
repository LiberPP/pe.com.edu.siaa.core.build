package pe.com.edu.siaa.core.ejb.dao.generic.local;

import javax.persistence.EntityManager;


/**
 * La Interface GenericDAOLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal-
 * mapfre. Todos los derechos reservados.</li>
 * </ul>
 * 
 * @param <K> el tipo de clave
 * @param <T> el tipo generico
 * @author ndavilal
 * @version 1.0, Fri Apr 25 17:57:10 COT 2017
 * @since SIAA-CORE 2.1
 */
public interface GenericAutomaticoDAOLocal<K,T> {

	T saveNative(T entity,EntityManager sessionHibernate) throws Exception;
	
    /**
     * Save.
     *
     * @param entity el entity
     * @return the t
     */
    T save(T entity,EntityManager sessionHibernate);

    /**
     * Update.
     *
     * @param entity el entity
     * @return the t
     */
    T update(T entity,EntityManager sessionHibernate);

    /**
     * Delete.
     *
     * @param entity el entity
     * @return the t
     */
    T delete(T entity,EntityManager sessionHibernate);

    
    /**
     * Find.
     *
     * @param classs el classs
     * @param id el id
     * @return the t
     */
    T find(Class<T> classs, K id,EntityManager sessionHibernate);
}
