package Entities;

import java.util.UUID;

public class GuestHotel {
	private UUID id;
	private String nome;
	private String email;
	
	public GuestHotel() {
		this.id = UUID.randomUUID();
	}
	
	public GuestHotel(String nome, String email) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.email = email;
	}
	
	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GuestHotel [id=" 
				+ this.id 
				+ ", nome: " 
				+ this.nome 
				+ ", email: " 
				+ this.email 
				+ "]";
	}
}
