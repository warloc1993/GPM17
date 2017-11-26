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


@Path("/thesisApprove")
public class ApproveThesisApi {

    private EntityManagerFactory GPMServer1 = Persistence.createEntityManagerFactory("GPM_Server1");
    private EntityManagerFactory GPMServer2 = Persistence.createEntityManagerFactory("GPM_Server2");

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/appThesis")
    public String appThesis(ThesisDTO input) {

        // EntityManager for thesis table
        EntityManager gpmserver2 = GPMServer2.createEntityManager();

        // Initialize transaction
        EntityTransaction transaction = null;


        Thesis thesis = new Thesis();

        // Put thesis object to gpmserver2

        try {
            final QThesis qThesis = QThesis.thesis;
            // Get a transaction
            transaction = gpmserver2.getTransaction();
            // Begin the transaction
            transaction.begin();
            //fetch thesis
            thesis = new JPAQuery<Thesis>(gpmserver2)
                    .select(qThesis)
                    .from(qThesis)
                    .where(qThesis.id.eq(input.getId())).fetchOne();

            thesis.setApproved(input.getApproved());

            // Save the thesis object
            gpmserver2.persist(thesis);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // If there are any exceptions, roll back the changes
            // Print the Exception
            e.printStackTrace();
            return "{\" success \": \" false \"}";
        } finally {
            // Close the EntityManager
            gpmserver2.close();
            return "{\" success \": \" true \", \" id \": \""  + thesis.getId() + "\"}";
        }
    }
}
