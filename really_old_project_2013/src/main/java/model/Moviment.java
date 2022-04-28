package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Luca Barsottini
 *Class for the general controll movimnet and implementation of arrayList to know the near sector from one specific sector
 */
public class Moviment  {
	
	//message
	
	private FileReader fNearSector=new FileReader("src/main/java/model/FileSettoreConfinantiAlienEscape.txt");
	private BufferedReader rNearSector= new BufferedReader(fNearSector);
	private String string = new String();// string to save string file
	private String vertex=new String();
	private String nearVertex =new String();
	//ArrayList<String> array;
	private HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
	
		// constructor for the method that will create the graph for the map 
		// the sector are the vertex and we will connect each vertex to other one
	public Moviment()throws IOException{
		int index=0;
			// there are like 322 line of file where we put the interested vertex on the left and the 
			//all near vertex of the interested one
		for(int i=0;i<281;i++){
				//read line, one by one, of the file and put that in "string"
			string=rNearSector.readLine();
				// this read the first 3 character of the file and it will put it in vertex 
			vertex=""+string.charAt(index)+string.charAt(index+1)+string.charAt(index+2);
				//array=new ArrayList<String>();
			map.put(vertex,new ArrayList<String>());
			index+=6;	// increment of the index to read after the other "sector"
			
			for (;index<string.length()-2;index++){// this cycle will read the other sector and put it in the value of the my HashMap
				                                // also it will stop at the end 
				
				nearVertex=""+string.charAt(index)+string.charAt(index+1)+string.charAt(index+2);
				
				map.get(vertex).add(nearVertex);// put the nearVertex  in the ArrayList to create the connection...
				index+=3;
				
			}
			map.get(vertex).add("NULL");// the last connection will be to NULL for future controls
			index=0;
		}
			
	}
	
	
	/**
	 * @param startPosition is the start position of the human
	 * @return retur all sector near the start sector of the human
	 */
	public String humanMoviment (String startPosition){
		int index=0;
		String allNearSectorHuman=new String();
		
		while(map.get(startPosition).get(index)!="NULL"){
			allNearSectorHuman=map.get(startPosition).get(index)+" "+allNearSectorHuman;
			index++;
		}
		
		return allNearSectorHuman;
	}
	
	
	/**
	 * @param startPosition
	 * @return it will return all the near position plus the near position of the near position
	 */
	public String alienMoviment(String startPosition){
		int index1=0;
		int index2=0;
		String saveNext= new String();
		String allNearSectorAlien=new String();
		// in this cycle i will take all the near sector from the sartPositin
		while (map.get(startPosition).get(index1)!="NULL"){
			saveNext=map.get(startPosition).get(index1);
			// this is the fondamental point for the alien : in this cycle i will take the near sector of the 
			//near sector and i will save it on the String allNearSectorAlien...
			while (map.get(saveNext).get(index2)!="NULL"){
				allNearSectorAlien=map.get(saveNext).get(index2)+" "+allNearSectorAlien;
				index2++;
			}
			index2=0;// because i need to re iterator my ArrayList
			allNearSectorAlien=allNearSectorAlien+" "+saveNext;
			index1++;
		}
		return allNearSectorAlien;
	}
	}
	


