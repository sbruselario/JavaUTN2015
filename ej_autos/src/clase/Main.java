package clase;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Auto a = new Remis();
		a.setMarca("Ford");
		((Remis)a).setLocalidad("Santa Fe");
		
		
		/*Remis a = new Remis();
		a.setMarca("Ford");
		a.setLocalidad("Santa Fe");*/
		
		System.out.println(a);

		System.out.println(a.esParticular());
		
		
		
		
	}

}
