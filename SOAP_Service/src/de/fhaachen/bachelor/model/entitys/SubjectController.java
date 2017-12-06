package de.fhaachen.bachelor.model.entitys;

import java.io.Serializable;

import javax.persistence.EntityManager;

public class SubjectController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private EntityManager em;
	
	
	public SubjectController(EntityManager em) {
		this.em = em;
	}
	
	
	public Subject getSubjectById(String id) {
		Subject sub = em.find(Subject.class, id);
		
		return sub;
	}

}
