package Entities;

import java.util.UUID;

public class RoomHotel {
	private int roomNumber;
	private boolean roomOcuped;
	private UUID guestId; 
	
	public RoomHotel(int roomNumber) {
		this.roomNumber = roomNumber;
		this.roomOcuped = false;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public boolean isRoomOcuped() {
		return roomOcuped;
	}
	
	public void setGuestId(UUID guestId)
	{
		this.guestId = guestId;
	}
	
	public UUID getGuestId() {
		return guestId;
	}
	
	public void changeRoomOcupation()
	{
		this.roomOcuped = !roomOcuped;
	}

	@Override
	public String toString() {
		return "RoomHotel [Quarto: " 
				+ roomNumber 
				+ ", guestId: " 
				+ guestId 
				+ "]";
	}
}
