package ca.projectspring.com.model;

import java.util.Arrays;
import java.util.Random;

import lombok.*;


/*
 * This class creates a randomized number of letters
 * given the length
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class letters {
	private String[] randomLetters; //use lombok to get the letters
	
	public letters(int howMany) {
		
		randomLetters = new String[howMany];
	}
	
	public void generateRandom() {
		String allLetters= "abcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		for (int i=0; i<randomLetters.length;i++) {
			//generates random letter with upperbound till 26, hence from 0-25
			char c = allLetters.charAt(r.nextInt(allLetters.length()));
			
			randomLetters[i] = Character.toString(c);
			
		}
		System.out.println(Arrays.toString(randomLetters));
		
		
	}

}
