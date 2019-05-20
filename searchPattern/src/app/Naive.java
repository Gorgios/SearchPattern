package app;

public class Naive {
	private String text;
	private String pattern;
	private int patternLength;
	private int textLength;
	
	public Naive(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.textLength = text.length();
		this.patternLength = pattern.length();
	}
	
	public void searchNaive(){
		int j;
		for (int i = 0 ; i < textLength-patternLength ; i++) {
			for (j=0; j< patternLength  ; j++) 
				if (pattern.charAt(j) != text.charAt(j+i))
					break;
			if (j == patternLength)
			System.out.println(i+1);
		}
	}
}
