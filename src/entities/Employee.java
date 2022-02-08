package entities;

public class Employee {
	// Atributos
	private Integer id;
	private String name;
	private Double salary;
	
	// Construtor
	public Employee(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// Métodos especiais
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	// Métodos públicos 
	public void increaseSalary(float percentage) {
		setSalary(salary += getSalary() * percentage / 100);
	}
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}
}
