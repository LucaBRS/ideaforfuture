
package model;
import java.util.HashMap;
import java.io.*;

/**
 * @author Luca Barsottini
 *Class for the creation of the map whit the use of the HashMap and the graph for the connection to every near sector 
 */
public class MapCreation {
	public static MapCreation instance=null;//SINGLETON
	private HashMap <String,MapSector> map= new HashMap<String,MapSector>();
	//REad from file the type of sector : the first line of the file are the dangerous sector
	// the second are the safe sector,the  third are the boat , forth alien , and the last one the human
	//i think this can be usefull...
	private FileReader fSector= new FileReader("src/main/java/model/TipologieSettori.txt");
	private BufferedReader readerFileSector=new BufferedReader(fSector);
	
	
	private String strSector=new String();
	private MapSector grey,white/*,alien,human*/,boat;
	
	public static MapCreation getIstance() throws IOException{
		if (instance==null)
			instance=new MapCreation();
		return instance;
		
		
	}
	
	
	/**
	 * @throws IOException
	 * this will create the hashmap for the the game
	 */
	public MapCreation() throws IOException{
		//initialization of the object to the interest class
		grey=new DangerousSector();
		white=new SafeSector();
		/*alien=new AlienSector();
		human=new HumanSector();*/
		boat=new BoatSector();
		//start of the for cycle to read from file line x line
		for(int i =1;i<4;i++){
			strSector=readerFileSector.readLine();
			for (int index =0;index<strSector.length();index++){
				String cell=new String();
				//insert the hashMap with key in the cell and the value the class DangerousSector
				if (i==1){
					cell=""+strSector.charAt(index)+strSector.charAt(index+1)+strSector.charAt(index+2);
					index+=3;
					map.put(cell,grey);
				}
				//insert the hashMap with key in the cell and the value the class SafeSector
				
				if (i==2){
					cell=""+strSector.charAt(index)+strSector.charAt(index+1)+strSector.charAt(index+2);
					index+=3;
					map.put(cell,white);
				}
				//insert the hashMap with key in the cell and the value the class BoatSector

				if (i==3){
					cell=""+strSector.charAt(index)+strSector.charAt(index+1)+strSector.charAt(index+2);
					index+=3;
					map.put(cell,boat);
				}
				
			}
		}
	}
	//getSector take the current sector and pass it to 'actionSector' that it will verify if it is dangerous or safe
	public MapSector getSector(String key) throws IOException{
return map.get(key);
	}
	
		
	
	
	

}
