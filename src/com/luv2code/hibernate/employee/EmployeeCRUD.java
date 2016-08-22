package com.luv2code.hibernate.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeCRUD {
	
	SessionFactory factory = new Configuration()
							 .configure("hibernate.cfg.xml")
							 .addAnnotatedClass(Employee.class)
							 .buildSessionFactory();
	
	public void createEmployee(Employee employee){
		
		Session session = factory.getCurrentSession();
		
		try{		
		session.beginTransaction();		
		session.save(employee);		
		session.getTransaction().commit();
		}
		finally{
			session.close();
		}		
	}
	
	public void updateEmployee(int id, String company){
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			employee.setCompany(company);
			session.update(employee);
			session.getTransaction().commit();
		}
		finally{
			session.close();
		}
	}
	 
	public void deleteEmployee(int id){
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			session.delete(employee);
			session.getTransaction().commit();
		}
		finally{
			session.close();
		}
	}
	
	public Employee findEmployeeById(int id){
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			Employee employee = (Employee) session.createQuery("from Employee s where s.id=" + id).getSingleResult();
			session.getTransaction().commit();
			return employee;
		}
		finally{
			session.close();
		}
	}
	
public List<Employee> findEmployeeByCompany(String company){
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			List<Employee> employee = session.createQuery("from Employee s where s.company=" + "\'" + company+ "'").getResultList();
			session.getTransaction().commit();
			return employee;
		}
		finally{
			session.close();
		}
	}
}
