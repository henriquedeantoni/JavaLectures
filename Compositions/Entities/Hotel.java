package Entities;

import java.util.UUID;

public class Hotel {
	private RoomHotel[] roomHotelList;
	private GuestHotel[] guestList;
	
	public Hotel(int quantityRooms, int quantityGuests) {
		this.roomHotelList = new RoomHotel[quantityRooms];
		this.guestList = new GuestHotel[quantityGuests];
		for(int i=0; i<quantityRooms; i++) {
			roomHotelList[i] = new RoomHotel(i);
		}
		for(int i=0; i<quantityGuests; i++) {
			guestList[i] = new GuestHotel();
		}
	}
	
	public void registerGuest(String name, String email, int indice) {
	
		if(indice<guestList.length) {
			guestList[indice].setNome(name);
			guestList[indice].setEmail(email);			
		}
	}
	
	public void checkIn(int room, UUID guestId) {
		this.roomHotelList[room].setGuestId(guestId);
		this.roomHotelList[room].changeRoomOcupation();
	}
	
	public UUID informGuestId(int indice) {
		return guestList[indice].getId();
	}

	public RoomHotel[] getRoomHotelList(int quantityRooms) {
		return roomHotelList = new RoomHotel[quantityRooms];
	}

	public RoomHotel[] getRoomHotelList() {
		return roomHotelList;
	}	
	
	public void informEmptyRooms() {
		System.out.println("Os quartos das numeracoes abaixo estao disponiveis: ");
		for(RoomHotel roomHotel : roomHotelList){
			if(!roomHotel.isRoomOcuped())
			{
				System.out.printf("[%d] ", roomHotel.getRoomNumber());
			}
		}
	}
	
	private static void informGuestInformation(GuestHotel[] guestList, UUID guestId) {
		//GuestHotel guestHotelInformation = null;
		for( GuestHotel guestHotel : guestList) {
			UUID id = guestHotel.getId();
			if(id.equals(guestId))
				System.out.println(guestHotel);
		}
	}
	
	public void informRooms() {
		System.out.println("Informando os quartos:  ");
		for(RoomHotel roomHotel : this.roomHotelList) {
			System.out.printf("[Quarto numero %d ]%n",roomHotel.getRoomNumber());
			UUID guestId = roomHotel.getGuestId();
			informGuestInformation(this.guestList, guestId);
		}
	}
}
