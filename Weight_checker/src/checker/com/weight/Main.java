package checker.com.weight;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<GiftBox> boxes=new  ArrayList<GiftBox>();
	
		double[] biscuitWeight1= {200.0,100.5};
		double[] chocolateWeight1= {200.0,100.5};
		String[] chocolateFlavour1= {"Orange","Banana"};
		boxes.add (new GiftBox(biscuitWeight1,chocolateWeight1,chocolateFlavour1));
		
		double[] biscuitWeight2= {200.0,100.5,750};
		double[] chocolateWeight2= {200.0,100.5,300.5};
		String[] chocolateFlavour2= {"Orange","Banana","Apple"};
		boxes.add (new GiftBox(biscuitWeight2,chocolateWeight2,chocolateFlavour2));
		
		for(GiftBox box : boxes) {
			if(box.getWeight()>1000.0)
			System.out.println( "The box with"+ box.getNumBiscuit()+"biscuits and "+ box.getNumChocolate() +"chocolate is overWeight" 
					);
			System.out.println("The biscuit weight are:");
			box.showEachBiscuitWeight();
			System.out.println("The chocolate weight are:");
			box.showEachChocolateWeight();
			System.out.println("The chocolate flavour are:");
			box.showEachChocolateFlavour();
			System.out.println();
		}
	}

}
