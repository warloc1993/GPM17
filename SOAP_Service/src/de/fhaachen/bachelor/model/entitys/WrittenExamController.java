package de.fhaachen.bachelor.model.entitys;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class WrittenExamController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public WrittenExamController(EntityManager em) {
		this.em = em;
	}

	public String getECTSByStudentId(String id) {
		Query query = em.createQuery(
				"SELECT SUM(we.fach.ects) FROM WrittenExam we JOIN Subject s ON we.fach.id=s.id WHERE we.student.id=" + id);
		
		Object o = query.getSingleResult();
		
		if(o == null) {
			return "";
		}

		return o.toString();

	}

}
