package app;


public class KMP {
	private String text;
	private String pattern;
	private int patternLength;
	private int textLength;
	public KMP(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.textLength = text.length();
		this.patternLength = pattern.length();
	}


	public void searchKMP() {
		int i,j;
		int t = 0;
		int postion[] = new int[patternLength + 1];
		postion[0]=0; postion[1]=0;
		for (j=2; j<=patternLength; j++){
		while ((t>0) && ( pattern.charAt(t) != pattern.charAt (j-1))) 
			t=postion[t];
		if (pattern.charAt(t)==pattern.charAt(j-1)) 
			t++;
		postion[j]=t;
		}
		i=1; j=0;
		while (i<=textLength-patternLength + 1){
		j=postion[j];
		while((j<patternLength)&&(pattern.charAt(j)==text.charAt(i+j-1))) 
			j++;
		if (j==patternLength) System.out.println(i);
		i = i + Math.max(1,j-postion[j]);
	}
	}
}
