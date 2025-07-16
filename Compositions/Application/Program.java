package Application;

import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

import Entities.Hotel;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		

		
		System.out.println("Digite a quantidade de hospedes: ");
		
		int N = sc.nextInt();
		sc.nextLine();
		Hotel hotel = new Hotel(10, N);
		
		for(int i=0; i<N; i++) {
			System.out.println("Informe o nome do hospede: ");
			String name = sc.nextLine();
			
			System.out.println("Informe o email do hospede: ");
			String email = sc.nextLine();
			
			
			hotel.registerGuest(name, email, i);
			
			UUID guestId = hotel.informGuestId(i);
			
			System.out.println("Qual quarto irao hospedar?");
			hotel.informEmptyRooms();
			
			int room = sc.nextInt();
			
			hotel.checkIn(room, guestId);
			
			sc.nextLine();
		}
		
			hotel.informRooms();
	}

}
