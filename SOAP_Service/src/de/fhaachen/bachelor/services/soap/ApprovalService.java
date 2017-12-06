package de.fhaachen.bachelor.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.fhaachen.bachelor.model.entitys.Student;
import de.fhaachen.bachelor.model.entitys.StudentController;
import de.fhaachen.bachelor.model.entitys.WrittenExamController;

@WebService
public class ApprovalService {
	
	@WebMethod
	public boolean isApproved(String prename, String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOAP_Service");
		EntityManager em = emf.createEntityManager();
		
		StudentController sc = new StudentController(em);
		WrittenExamController wec = new WrittenExamController(em);
		
		Student st = sc.getStudentId(prename, name);
		
		if(st.getId().equals("-1")) {
			return false;
		}
		
		if(st.getPassedPracticeProject()) {
			String ects = wec.getECTSByStudentId(st.getId());
			
			if(ects.equals("")) {
				return false;
			}
			
			int iECTS = Integer.parseInt(ects);
			
			if(iECTS >= 120) {
				return true;
			}
		}

		return false;
		
	}

}
