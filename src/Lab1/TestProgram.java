package Lab1;

public class TestProgram {
	
	public static void main (String [] args){
		Uppg1 uppg1 = new Uppg1(15);
		System.out.println(uppg1);
		uppg1.addFirst("9");
		uppg1.addFirst("4");
		uppg1.addFirst("3");
		System.out.println("*" + uppg1 +  " # bör vara 9 i först");
	}

}
