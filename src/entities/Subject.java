package entities;

import java.util.Objects;

public class Subject {
	private int subjectID;
	private String subjectName;
	private float subjectCoefficient;
	
	
	public Subject(int subjectID, String subjectName, float subjectCoefficient) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.subjectCoefficient = subjectCoefficient;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(subjectID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return subjectID == other.subjectID;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public float getSubjectCoefficient() {
		return subjectCoefficient;
	}
	public void setSubjectCoefficient(float subjectCoefficient) {
		this.subjectCoefficient = subjectCoefficient;
	}
	
	
}
