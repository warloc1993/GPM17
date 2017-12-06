package de.fhaachen.bachelor.model.entitys;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class StudentController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public StudentController(EntityManager em) {
		this.em = em;
		
	}
	
	public Student getStudentId(String prename, String name) {
		Query query = em.createQuery("SELECT s FROM Student s WHERE s.prename LIKE '" + prename + "' AND s.name LIKE '" + name + "'");
		
		Object o = query.getSingleResult();
		
		if(o == null) {
			Student st = new Student();
			st.setId("-1");
			
			return st;
		}
		
		return (Student)o;
	}

}
