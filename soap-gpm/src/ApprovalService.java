import java.sql.ResultSet;
import java.sql.SQLException;


public class ApprovalService {

    GPMServer conn = GPMServer.getDbCon();

    public boolean isApproved(long studentId) {
        System.out.println("isApproved started with studentID= " + studentId);

        int passed_exams = countPassedExams(studentId);

        if(passed_exams < 19) {
            System.out.println("isApproved ended with false");
            return false;
        } else {
            System.out.println("isApproved ended with true");
            return true;
        }
    }

    private int countPassedExams(long studentId) {
        try {
            ResultSet res = conn.query("select count(subject.ects) as passed_exams, student.name, student.id  from written_exam\n" +
                    "join subject on subject.id = written_exam.subject_id\n" +
                    "join student on student.id = written_exam.student_id\n" +
                    "where student_id = " + studentId + "&& grade != 5.0\n" +
                    "group by student_id");
           if(res.next()) {
               return res.getInt("passed_exams");
           }
            return -1;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }
}
