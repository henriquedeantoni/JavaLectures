package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\products.csv"))) {
			
			List<Employee> list = new ArrayList<>();
			
			String line = br.readLine();
			
			while(line !=null) {
				String[] fields = line.split(",");
				
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

	}

}
