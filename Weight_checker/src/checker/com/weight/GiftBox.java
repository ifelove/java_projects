package checker.com.weight;

import java.util.ArrayList;

public class GiftBox {

	private ArrayList<Biscuit> biscuitSet;
	private ArrayList<Chocolate> chocolateSet;
	private double weight;
	
	public GiftBox(double[] biscuitWeight,double[] chocolateWeight,String[] chocolateFlavour) {
		biscuitSet=new ArrayList<Biscuit>();
		chocolateSet=new ArrayList<Chocolate>();
		for(int i=0;i<biscuitWeight.length;i++) {
			
			Biscuit pack=new Biscuit(biscuitWeight[i]);
			biscuitSet.add(pack);
		
		weight+=pack.getWeight();
		}
for(int i=0;i<chocolateWeight.length;i++) {
			
			Chocolate pack=new Chocolate(chocolateWeight[i], chocolateFlavour[i]);
			chocolateSet.add(pack);
		
		weight+=pack.getWeight();
		}


}
	public int getNumBiscuit() {
		return biscuitSet.size();
	}
	
	public int getNumChocolate() {
		return chocolateSet.size();
	}
public double getWeight() {
	return weight;
	
	
	
}
public void showEachBiscuitWeight() {
	
	for(Biscuit biscuit :biscuitSet) {
		System.out.println(biscuit.getWeight()+"");
		
	}
}

public void showEachChocolateWeight() {
	
	for(Chocolate chocolate : chocolateSet) {
		System.out.println(chocolate.getWeight()+"");
		
	}
}

public void showEachChocolateFlavour() {
	
	for(Chocolate chocolate : chocolateSet) {
		System.out.println(chocolate.getFlavour()+"");
		
	}
}


}
