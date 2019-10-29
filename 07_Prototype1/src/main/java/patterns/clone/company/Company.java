package patterns.clone.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company{
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Company(String name) {
		this.name = name;
	}

	public Company(Company c){
		this.name = c.name;
		this.employees = c.employees.stream().map(e -> e.clone()).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	public int getSize() {
		return employees.size();
	}
	
	public void addEmployee(Employee p) {
		this.employees.add(p);
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			Company c = (Company) o;
			return name.equals(c.name) && employees.equals(c.employees);
		} else {
			return false;
		}
	}

	@Override
	public Company clone() {
		// TODO Task 2&3: implement method clone

		return new Company(this);
	}
}
