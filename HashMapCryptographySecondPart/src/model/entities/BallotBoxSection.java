package model.entities;

import java.util.ArrayList;
import java.util.List;

public class BallotBoxSection {
	private Object sectionInformation;
	
	private List<Candidate> listInformation = new ArrayList<>();
	
	public BallotBoxSection(Object sectionInformation) {
		this.sectionInformation = sectionInformation;
	}

	public Object getSectionInformation() {
		return sectionInformation;
	}

	public void setSectionInformation(Object sectionInformation) {
		this.sectionInformation = sectionInformation;
	}

	public void addCandidate(Candidate c) {
		listInformation.add(c);
	}
}
