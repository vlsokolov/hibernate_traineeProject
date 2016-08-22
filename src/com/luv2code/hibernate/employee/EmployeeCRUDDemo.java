package com.luv2code.hibernate.employee;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeCRUDDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Employee.class)
				 .buildSessionFactory();
		
		EmployeeCRUD testEmployee = new EmployeeCRUD();
		Employee myEmployee = new Employee("Donald", "Duck", "WaltDisney");
		
		List<Employee> findEmployee = testEmployee.findEmployeeByCompany("Marvel");
		
		for(Employee e: findEmployee){
			System.out.println(e);
		}
	}

}
