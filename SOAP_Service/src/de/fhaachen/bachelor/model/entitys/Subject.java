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
 * The persistent class for the subject database table.
 * 
 */
@Entity
@Table(name="subject")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="ects")
	private Integer ects;

	@Column(name="name")
	private String name;

	//bi-directional many-to-many association to Student
	@OneToMany(mappedBy="fach")
	private List<WrittenExam> benotung;

	public Subject() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getEcts() {
		return this.ects;
	}

	public void setEcts(Integer ects) {
		this.ects = ects;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WrittenExam> getBenotung() {
		return this.benotung;
	}

	public void setBenotung(List<WrittenExam> benotung) {
		this.benotung = benotung;
	}
	
	public WrittenExam addBenotung(WrittenExam benotung) {
		getBenotung().add(benotung);
		benotung.setFach(this);

		return benotung;
	}

	public WrittenExam removeBenotung(WrittenExam benotung) {
		getBenotung().remove(benotung);
		benotung.setFach(null);

		return benotung;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", ects=" + ects + ", name=" + name + "]";
	}
	

}