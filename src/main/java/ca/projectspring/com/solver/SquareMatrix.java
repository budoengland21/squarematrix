package ca.projectspring.com.solver;

import java.io.Serializable;
import java.util.ArrayList;
import ca.projectspring.com.model.letters;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * This generates the square matrix with random 
 * letters from the letter class
 * @author moh
 *
 */
public class SquareMatrix implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1838016725861281629L;
	
	
	private String face = "😴";
	private String answer="";
//	private String toSearch="";
	private ArrayList<ArrayList<String>> size; // used store letters
	private int sqSize; //size of square
	private String status = "Awaiting"; //determines if success/failure
	private String[] extractData; //used to print out data
	public SquareMatrix(int sqSize) {
		this.sqSize = sqSize;
		this.extractData = new String[sqSize*sqSize];
		size = new ArrayList<ArrayList<String>>();
		//for rows
		for (int i=0; i< sqSize;i++) {
			letters create = new letters(sqSize);
			create.generateRandom();
			ArrayList<String> temp = new ArrayList<>();
			//for columns
			for(int j=0; j<sqSize; j++) {
				temp.add(create.getRandomLetters()[j]);
			}
			size.add(temp);
			
		}
		
	}
	
	
	
	
	/**
	 * used to obtain the list and removes the bracket
	 */
	public void extract() {
		for(int i=0; i<size.size();i++) {
			extractData[i] = size.get(i).toString().replace("[", "")
					.replace("]", "");
		
		}
		
	}
	
	/**
	 * This creates a search class which searches the 
	 * matrix and gives back a status
	 */
	public void search(String a) {
		SearchMethod s = new SearchMethod(size, a);
		//s.searchDiagnol();
		if (s.isHorizontal() || s.isVertical() || s.isDiagonal() ){
			status = "Success";
			face = "😃";
		}else {
			status = "Failure";
			face = "😔";
		}
		
	}
	
	

}
