package de.fhaachen.bachelor.model.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="name")
	private String name;

	@Column(name="passed_bachelor_thesis")
	private Boolean passedBachelorThesis;

	@Column(name="passed_colloquium")
	private Boolean passedColloquium;

	@Column(name="passed_practice_project")
	private Boolean passedPracticeProject;

	private String prename;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="student")
	private List<WrittenExam> writtenExams;

	public Student() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPassedBachelorThesis() {
		return this.passedBachelorThesis;
	}

	public void setPassedBachelorThesis(Boolean passedBachelorThesis) {
		this.passedBachelorThesis = passedBachelorThesis;
	}

	public Boolean getPassedColloquium() {
		return this.passedColloquium;
	}

	public void setPassedColloquium(Boolean passedColloquium) {
		this.passedColloquium = passedColloquium;
	}

	public Boolean getPassedPracticeProject() {
		return this.passedPracticeProject;
	}

	public void setPassedPracticeProject(Boolean passedPracticeProject) {
		this.passedPracticeProject = passedPracticeProject;
	}

	public String getPrename() {
		return this.prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public List<WrittenExam> getWrittenExams() {
		return this.writtenExams;
	}

	public void setFacher(List<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}
	
	public WrittenExam addWrittenExam(WrittenExam writtenExam) {
		getWrittenExams().add(writtenExam);
		writtenExam.setStudent(this);

		return writtenExam;
	}

	public WrittenExam removeWrittenExam(WrittenExam writtenExam) {
		getWrittenExams().remove(writtenExam);
		writtenExam.setStudent(null);

		return writtenExam;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", prename=" + prename + "]";
	}
	
	

}