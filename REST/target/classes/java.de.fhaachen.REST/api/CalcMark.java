package main.resources.java.de.fhaachen.REST.api;

import com.querydsl.jpa.impl.JPAQuery;
import main.resources.java.de.fhaachen.REST.entities.QSubjects;
import main.resources.java.de.fhaachen.REST.entities.QWrittenExams;
import main.resources.java.de.fhaachen.REST.entities.Subjects;
import main.resources.java.de.fhaachen.REST.entities.WrittenExams;

import javax.ws.rs.*;
import javax.persistence.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/calc")
public class CalcMark {

    private EntityManagerFactory GPMServer1 = Persistence.createEntityManagerFactory("GPM_Server1");
    private EntityManagerFactory GPMServer2 = Persistence.createEntityManagerFactory("GPM_Server2");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getExams/{id}")
    public String updateThesis(@PathParam("id") int id) {

        EntityManager gpmserver1 = GPMServer1.createEntityManager();

        // Initialize transaction
        EntityTransaction transaction;

        List<WrittenExams> writtenExams;
        List<Subjects> subjects;
        double ects_sum = 0;
        double grade_sum = 0;
        double average = 0;

        try {

            transaction = gpmserver1.getTransaction();

            transaction.begin();

            final QWrittenExams qWrittenExams = QWrittenExams.writtenExams;
            final QSubjects qSubjects = QSubjects.subjects;

            writtenExams = new JPAQuery<WrittenExams>(gpmserver1)
                    .select(qWrittenExams)
                    .from(qWrittenExams)
                    .where(qWrittenExams.student_id.eq(id)).fetch();

            subjects = new JPAQuery<Subjects>(gpmserver1)
                    .select(qSubjects)
                    .from(qSubjects).fetch();

            for(int i = 0; i<writtenExams.size(); i++) {
                grade_sum += writtenExams.get(i).getGrade() * subjects.get(i).getEcts();
                ects_sum += subjects.get(i).getEcts();
            }

            average = grade_sum / ects_sum;

            // Commit transaction
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            return "{\"success\": \"false\"}";
        }
        finally {
            // Close the EntityManager gpmserver1
            gpmserver1.close();
        }

        return "{\"success\": \"true\", \"average\": \"" + average + "\"}";
    }
}
