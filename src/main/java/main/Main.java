package main;

import org.hibernate.Session;

import proyectohibernate.Habitaciones;
import proyectohibernate.HibernateUtil;
import proyectohibernate.Hoteles;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil.buildSessionFactory();
		App.main(args);
		
		
		
		
	}

}
