package de.fhaachen.bachelor.control;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import de.fhaachen.bachelor.model.entitys.*;;

/**
 * 
 * @author gpm17
 * 
 *         DISE KLASSE WURDE NUR FUR TESTZWECKE GENUZT. FUR PROGRAMMLOGIK SPIELT
 *         KEINE ROLLE
 *
 */

public class ApprovalControl {
	public String checkApproval(String prename, String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOAP_Service");
		EntityManager em = emf.createEntityManager();

		StudentController sc = new StudentController(em);
		WrittenExamController wec = new WrittenExamController(em);

		Student st = sc.getStudentId(prename, name);

		if (st.getId().equals("-1")) {
			return st.getId();
		}

		if (st.getPassedPracticeProject()) {
			String ects = wec.getECTSByStudentId(st.getId());

			if (ects.equals("")) {
				return "etcs=''";
			}

			int iECTS = Integer.parseInt(ects);

			if (iECTS >= 120) {
				return "ects>120";
			}
		}

		return "end of method " + st.getPassedPracticeProject();

	}

}
