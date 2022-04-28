package model;

import java.io.*;


import exceptionGame.IncorrectPosition;

public class AnyPositionCard extends SectorCard {
    
	private FileReader fNearSector;
    private BufferedReader rNearSector;
    private String string=new String();
    private int index =0;
    private String vertex[]=new String[281];  
    private Boolean flag;
	
	
	@Override
	public String actionCard(String position) throws IOException,IncorrectPosition {	
		//method to declare a fake position, but it control if the sector on input is real.
		fNearSector =new FileReader("src/main/java/model/FileSettoreConfinantiAlienEscape.txt");
		rNearSector= new BufferedReader(fNearSector);
		flag=false;
	
		for(int i=0;i<281;i++){
			//read line, one by one, of the file and put that in "string"
		string=rNearSector.readLine();
			// this read the first 3 character of the file and it will put it in vertex 
		vertex[i]=""+string.charAt(index)+string.charAt(index+1)+string.charAt(index+2);
		//it return true if the position1 is present in the file, so if it is real.
		if(vertex[i].equals(position)==true){
			flag=true;
		}
		}
		//it return false if the position1 is not real
		if(flag==false){
			throw new IncorrectPosition();
			}
			
		return "NOISE IN SECTOR "+ position+"\n";
		}
}
	
	


