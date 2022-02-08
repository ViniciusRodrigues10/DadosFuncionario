package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		// Realizando o cadatro dos funcionários 
		for (int i = 0; i < n; i++) {
			System.out.println("\nEmplyoee #" + (i + 1) + ": ");
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			// Analizando se o Id já existe 
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
			
		}
		
		// Realizando aumento do funcionário
		System.out.print("\nEnter the employee id that will have salary increase : ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			float percentage = sc.nextFloat();
			emp.increaseSalary(percentage);
		}
		
		// Print dados dos funcionários 
		System.out.println("\nList of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();

	}
	
	// Função para analisar se o Id já existe 
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
