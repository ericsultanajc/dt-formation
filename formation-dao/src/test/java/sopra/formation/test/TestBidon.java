package sopra.formation.test;

import sopra.formation.Application;

public class TestBidon {

	public static void main(String[] args) {
		Application singleton1 = Application.getInstance();
		
		Application singleton2 = Application.getInstance();
		
		System.out.println("singleton1="+singleton1);
		System.out.println("singleton2="+singleton2);

	}

}
