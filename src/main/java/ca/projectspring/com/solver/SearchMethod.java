package ca.projectspring.com.solver;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchMethod implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1983188198083379160L;
	private boolean horizontal = false;
	private boolean vertical = false;
	private boolean diagonal = false;
	private String [] check;
	private ArrayList<ArrayList<String>> store;
	
	public SearchMethod(ArrayList<ArrayList<String>> a, String value) {
		 check = value.split("");
		store = a;
		System.out.print(check[0]);
		if (check.length>=a.size()) {
			searchHorizontal();
		    searchVertical();
		    searchDiagnol();
		}
		//else all false no need to check
		
		
	}
	private boolean confirm() {
		if (diagonal==true) {
			return true;
		}return false;
	}
    //check last item of last list
	//and first item of list
	private String searchDiagnol() {
		//FROM LEFT DIAGNAL
		int length = store.size();
		if (check[0].toString().equals(store.get(0).get(0))) {
			//check if matches all
			for (int i=0; i< store.size();i++) {
				if (check[i].equals(store.get(i).get(i))) {
					diagonal = true;

					
				}else {
					diagonal = false;
					break;
				}
			}
			
		}
		if (confirm()) {
			return null;
		}
		
		//LEFT DIAGONAL IN REVERSE
		//check the last item of array if in user provided a reverse
		if (check[0].toString().equals(store.get(length-1).get(length-1))) {
			System.out.println("here");
			for (int i=0; i<store.size();i++) {
				if (check[i].toString().equals(store.get((length-1)-i).get((length-1)-i))) {
					diagonal=true;
				}else {
					diagonal = false;
					break;
					
				}//System.out.println(diagonal);
			}
			
		}
		if (confirm()) {
			return null;
		}
		
		//RIGHT DIAGONAL start from last item on first list
		if (check[0].toString().equals(store.get(0).get(length-1))) {
			for (int i=0; i< store.size();i++) {
				if (check[i].equals(store.get(i).get((length-1)-i))) {
					diagonal = true;
				}else {
					diagonal = false;
					break;
				}
			}
			
		}
		
		if (confirm()) {
			return null;
		}
		
		//RIGHT DIAGONAL REVERSE
		if (check[0].toString().equals(store.get(length-1).get(0))) {
			for (int i=0; i<store.size();i++) {
				if (check[i].equals(store.get((length-1)-i).get(i))) {
					diagonal=true;
				}else {
					diagonal = false;
					break;
				}
			}
			
		}
		return null;
		
		
		
		
		
	}
	
    //just check only one row for similar letter
	//and bottom row
	private String searchVertical() {
		int length = store.size();
		//check first row
		  
		
		  for(int x=0; x<store.size();x++) {
			  //once find letter that matches then loop it downwards
			  if (check[0].toString().equals(store.get(0).get(x))) {
				  //loop vertically checking each array at index (x)
				  for (int i=0; i< store.size();i++) {
					  if (check[i].toString().equals(store.get(i).get(x))) {
						   vertical = true;
					  }else {
						  vertical = false;
						  break;
						 
					  }
				  }
			  }
		  }if (vertical == true) {
			  return null;
		  }
		  //try reverse 
		  for (int x=0; x<store.size();x++) {
			  if (check[0].toString().equals(store.get(length-1).get(x))) {
				  //then loop upwards
				 for(int i=0; i<store.size();i++) {
					 if (check[i].toString().equals(store.get((length-1)-i).get(x)) ) {
						 vertical=true;
					 }else { 
						 vertical=false;
						 break;
						
					 }
				 }
			  }
		  }
		  return null;
		  
		
	}
    
	//check row also front and back
	private String searchHorizontal() {
		int length = store.size();
		for(int x=0; x<store.size(); x++) {
			//check first item of each list
			if (check[0].toString().equals(store.get(x).get(0))) {
				

				//then loop inside it
				for (int i=0; i< store.size();i++) {
					if (check[i].toString().equals(store.get(x).get(i))) {
						horizontal=true;
					}else {
						horizontal=false;
						break;
						
					}
				}
				
			}
		}if (horizontal == true) {
			return null;
		}
		//check backwards
		for (int x=0 ;x<store.size();x++) {
			//check reverse
			if (check[0].toString().equals(store.get(x).get(length-1))) {
				//loop inside it
				for (int i=0; i<store.size();i++) {
					if (check[i].toString().equals(store.get(x).get((length-1)-i))) {
						
						horizontal=true;
					}else {
						horizontal=false;
						break;
						
					}		System.out.println(horizontal);

				}
			}
		}
		return null;
		
		
	}
	
	
	

}
