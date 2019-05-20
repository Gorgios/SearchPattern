package app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	public static String getStringFromFile(String file) throws IOException {
		InputStream is = new FileInputStream(file); 
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder(); 
		while(line != null){ 
			sb.append(line).append("\n");
			line = buf.readLine();
		}
		String str = sb.toString();
		buf.close();
		str = str.replaceAll("[\r\n]+", "");
		return str;
		}
	public static void main(String[] args) throws IOException {
		long timeStart;
		long timeEnd;
		long time;
		String text = getStringFromFile("tekst.txt");
		String pattern = getStringFromFile("wzorzec.txt");
		System.out.println("NAIWNY: ");
		Naive nv = new Naive (text,pattern);
		timeStart = System.nanoTime();
		nv.searchNaive();
	    timeEnd = System.nanoTime();
	    time = timeEnd - timeStart;

	    System.out.println("Czas trwania: " + time +" nanosekund");
		System.out.println("RabinKarp: ");
		RabinKarp rk = new RabinKarp(text,pattern);
		timeStart = System.nanoTime();
		rk.searchRK();
	    timeEnd = System.nanoTime();
	    time = timeEnd - timeStart;
	    System.out.println("Czas trwania: " + time +" nanosekund");
		
	    System.out.println("KMP: ");
	    KMP kmp = new KMP(text,pattern);
		timeStart = System.nanoTime();
		kmp.searchKMP();
	    timeEnd = System.nanoTime();
	    time = timeEnd - timeStart;

	    System.out.println("Czas trwania: " + time +" nanosekund");

		}
}
