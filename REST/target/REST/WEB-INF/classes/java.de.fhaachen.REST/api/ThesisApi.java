package main.resources.java.de.fhaachen.REST.api;
import com.querydsl.jpa.impl.JPAQuery;
import main.resources.java.de.fhaachen.REST.entities.QStudent;
import main.resources.java.de.fhaachen.REST.entities.QThesis;
import main.resources.java.de.fhaachen.REST.dto.ThesisDTO;
import main.resources.java.de.fhaachen.REST.entities.Student;
import main.resources.java.de.fhaachen.REST.entities.Thesis;

import javax.persistence.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/thesis")
public class ThesisApi {

    private EntityManagerFactory GPMServer1 = Persistence.createEntityManagerFactory("GPM_Server1");
    private EntityManagerFactory GPMServer2 = Persistence.createEntityManagerFactory("GPM_Server2");

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addThesis")
    public String addThesis(ThesisDTO input) {

        // EntityManager for student table
        EntityManager gpmserver1 = GPMServer1.createEntityManager();
        // EntityManager for thesis table
        EntityManager gpmserver2 = GPMServer2.createEntityManager();

        // Initialize transaction
        EntityTransaction transaction = null;
// Create new student object to store the object fetched from gpmserver1
        Student student = new Student();

        // Get Student ID
        try {

            final QStudent qStudent = QStudent.student;

            // Get a transaction
            transaction = gpmserver1.getTransaction();

            // Begin the transaction
            transaction.begin();

            // Fetch student object
            student = new JPAQuery<Student>(gpmserver1)
                    .select(qStudent)
                    .from(qStudent)
                    .where(qStudent.name.eq(input.getName()).and(qStudent.prename.eq(input.getPrename()))).fetchOne();

            // Commit transaction
            transaction.commit();

            System.out.println(student.toString());

        } catch (Exception e) {
            // Print the Exception
            e.printStackTrace();
            return "{\"success\": \"false\"}";
        } finally {
            // Close the EntityManager gpmserver1
            gpmserver1.close();
        }

        // Set student_id to Camunda-Engine
// Create new thesis object

        Thesis thesis = new Thesis();
        thesis.setStudent_id(student.getId());
        thesis.setTitle(input.getThesis_title());
        thesis.setSupervisor(input.getSupervisor());
        thesis.setApproved(-1);

        // Put thesis object to gpmserver2

        try {
            // Get a transaction
            transaction = gpmserver2.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Save the thesis object
            gpmserver2.persist(thesis);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // If there are any exceptions, roll back the changes
            // Print the Exception
            e.printStackTrace();
            return "{\"success\": \"false\"}";
        } finally {
            // Close the EntityManager
            gpmserver2.close();

        }
        return "{\"success\": \"true\", \"student_id\": \""  + student.getId() + "\", \"thesis_id\": \"" + thesis.getId() + "\"}";
    }

}