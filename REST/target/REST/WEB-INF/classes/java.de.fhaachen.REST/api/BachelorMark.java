package main.resources.java.de.fhaachen.REST.api;
import com.querydsl.jpa.impl.JPAQuery;
import main.resources.java.de.fhaachen.REST.dto.ThesisDTO;
import main.resources.java.de.fhaachen.REST.entities.QStudent;
import main.resources.java.de.fhaachen.REST.dto.StudentDTO;
import main.resources.java.de.fhaachen.REST.entities.Student;
import main.resources.java.de.fhaachen.REST.entities.Thesis;

import javax.persistence.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/bach")
public class BachelorMark {

    private EntityManagerFactory GPMServer1 = Persistence.createEntityManagerFactory("GPM_Server1");


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addBach")
    public String addBach(StudentDTO input) {

        // EntityManager for student table
        EntityManager gpmserver1 = GPMServer1.createEntityManager();


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

            student.setPassed_bachelor_thesis(input.getPassed_bachelor_thesis());

            // Commit transaction
            transaction.commit();



        } catch (Exception e) {
            // Print the Exception
            e.printStackTrace();
            return "{\" success \": \" false \"}";
        } finally {
            // Close the EntityManager gpmserver1
            gpmserver1.close();
            return "{\" success \": \" true \", \" id \": \""  + student.getId() + "\"}";
        }

        }

    }

