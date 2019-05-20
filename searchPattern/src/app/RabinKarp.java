package app;

public class RabinKarp {
	private String text;
	private String pattern;
	private int patternLength;
	private int textLength;
	private final int d = 128;
	private final int q = 27077;
	
	public RabinKarp(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.textLength = text.length();
		this.patternLength = pattern.length();
	}
	public void searchRK() {
		int h,i,j,p,t;
		h=1;
		for (i=0 ; i < patternLength-1; i++ )
			h = (h*d)%q;
		p = 0;
		t = 0;
		for (i=0; i < patternLength; i++) {
			p = (d*p + pattern.charAt(i))%q;
			t = (d*t + text.charAt(i))%q;
		}
		for (i =0; i<= textLength-patternLength  ; i++) {
			if (p == t) {
				for (j=0;j<patternLength;j++) {
					if (text.charAt(i+j) != pattern.charAt(j))
						break;
				}
				if (j == patternLength)
					System.out.println(i+1);
			}
			if (i< textLength-patternLength) {
				 t = (d * (t - text.charAt(i) * h) + text.charAt(i + patternLength)) %q;
	                if (t < 0) 
	                    t = (t + q); 
		}
			}
			
	}
}
