import java.util.Scanner;

public class choice {
	/* 	when called upon has two parameters that set the amount of choices
	*	these two parameters set the minimum and maximum amount of responses available
	*	Some how I need to take in the users input, so that I can test to see if
	*	their choice is within the minimum and maximum values... 
	*	
	*/
	
	Scanner key = new Scanner(System.in);
	
	private int minV;
	private int maxV;
	private int response;
	
	public choice() {
		setminV(1);
		setmaxV(2);
	}
	public choice(int min, int max) {
		setminV(min);
		setmaxV(max);
	}
	
	public void setminV(int m) {
		minV = m;
	}
	public void setmaxV(int n) {
		maxV = n;
	}
	
	public int getminV() {
		return minV;
	}
	public int getmaxV() {
		return maxV;
	}
	
	
	public void setResponse(String s) throws NumberFormatException {
		boolean pizza = false;
		while(pizza == false) {
			try {
				s = "0"+s;
				int w = Integer.parseInt(s);
				if((w < minV)||(w > maxV)) {
					while ((w < minV)||(w > maxV)) {
						System.out.println("Not a valid response");
						System.out.print("Please try again: ");
						s = key.next();
						s = "0"+s;
						w = Integer.parseInt(s);
					}
					response = w;
					pizza = true;
				}
				if((w >= minV)&&(w <= maxV)) {
					response = w;
					pizza = true;
				}	
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter a intger: ");
				s = key.next();
				continue;
			}
		}
	}
		
	public int getResponse() {
		return response;
	}
	
} 