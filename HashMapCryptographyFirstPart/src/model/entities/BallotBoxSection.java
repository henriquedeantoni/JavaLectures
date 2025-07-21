package model.entities;

public class BallotBoxSection {
	private Object sectionInformation;
	
	
	public BallotBoxSection(Object sectionInformation) {
		this.sectionInformation = sectionInformation;
	}

	public Object getSectionInformation() {
		return sectionInformation;
	}

	public void setSectionInformation(Object sectionInformation) {
		this.sectionInformation = sectionInformation;
	}
	
}
