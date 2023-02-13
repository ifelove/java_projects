package callBackMethod;


 interface done{
	 String findword(String str);
 }


public class CallBack {

	
	//driver
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		done greetingStyle=(str)->str+ "Uncle";
		greetUser("Hello,",greetingStyle); 

	}
	
	// main function  containing other function
	
	public static void greetUser( String word, done callbackFunction) {
		
		String greetings= callbackFunction.findword(word);
		
	System.out.print(greetings);
		
		
	}

	

}
