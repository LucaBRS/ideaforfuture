package model;

import java.io.*;

import exceptionGame.IncorrectPosition;

/**
 * @author Luca Barsottini
 *this method will be extend be SilentCard, AnyPositionCard , YourPositionCard.
 */
public abstract class SectorCard {
	
	public abstract String actionCard(String position) throws IOException, IncorrectPosition;


	}

