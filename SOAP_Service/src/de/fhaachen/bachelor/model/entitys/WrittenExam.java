package de.fhaachen.bachelor.model.entitys;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="written_exam")
@NamedQuery(name="WrittenExam.findAll", query="SELECT w FROM WrittenExam w")
public class WrittenExam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Column(name="grade")
	private String grade;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject fach;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	public WrittenExam() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Subject getFach() {
		return fach;
	}

	public void setFach(Subject fach) {
		this.fach = fach;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "WrittenExam [id=" + id + ", grade=" + grade + ", fach=" + fach + ", student=" + student + "]";
	}
	

}
