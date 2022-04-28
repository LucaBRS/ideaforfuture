package model;


import java.io.IOException;






public class YourPositionCard extends SectorCard {
	
	//method to declare the current position
	@Override
	public String actionCard(String position) throws IOException {
		
		
		return "NOISE IN SECTOR "+position+"\n";
		
	}

}
