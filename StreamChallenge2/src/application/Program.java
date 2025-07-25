package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\employees.csv"))) {
			
			List<Employee> list = new ArrayList<>();
			
			String line = br.readLine();
			
			while(line !=null) {
				String[] fields = line.split(",");
				
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			System.out.println("Enter Salary");
			double salaryMin = sc.nextDouble();
			
			System.out.printf("Email of people whose salary is more than %.2f", salaryMin);
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> names = list.stream()
					.filter(p->p.getSalary()>salaryMin)
					.map(p -> p.getName())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);
						
			double sum = list.stream()
					.map(p-> p.getSalary())
					.reduce(0.0, (x,y) -> x+y);
			
			System.out.println("Sum of salary of people whose name starts with 'M':" + sum);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
