package model;

import exceptionGame.HumanWin;

public class BoatSector extends MapSector {

	/* 
	 * this method will terminate the gameplay if an human will reach this sector
	 */
	@Override
	public SectorCard actionSector() throws HumanWin {
		throw new HumanWin();
		
		
	}

}
