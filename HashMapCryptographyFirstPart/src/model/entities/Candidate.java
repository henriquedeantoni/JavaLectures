package model.entities;

public class Candidate {
	
	private String name;
	private int partyCode;
	private int quantityVotesPerSection;
	
	public Candidate(String name, int partyCode, int quantityVotesPerSection) {
		this.name = name;
		this.partyCode = partyCode;
		this.quantityVotesPerSection = quantityVotesPerSection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(int partyCode) {
		this.partyCode = partyCode;
	}
	
}
