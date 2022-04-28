package model;

import java.io.IOException;

import exceptionGame.HumanWin;

/**
 * @author Luca Barsottini
 *Creation of abstract MapSector
 */
//the abstract class actionSector take the current sector and pass it to DangeorusSector or SafeSector
abstract public class MapSector {
public abstract SectorCard actionSector() throws IOException, HumanWin;

}
