package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;





/**
 * @author Luca Barsottini
 *Class for the physics map . It create the map only whit the coordinates  ...
 */
public class PhysicsMaps {
	
	private FileReader fMap=new FileReader("src/main/java/model/GalileiMap.txt");
	private BufferedReader rMap= new BufferedReader(fMap);
	private String mappa= new String();
    public	PhysicsMaps()throws IOException{ for (int i=0;i<28;i++)
		mappa= mappa+rMap.readLine()+"\n";
			}
    public void galileiMap() throws IOException{
    	System.out.println("*********************************************************@@@**********************************************************\n");	
    System.out.println(mappa);
    	System.out.println("*********************************************************@@@**********************************************************");	
    	
    }


    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Stamp the map ...
     */
   /* public void stamp3(){
    			
				for(int i=0;i<14;i++)
		System.out.print(""
				
				
		+ " "+k.givePosition(i,0)+"      "+k.givePosition(i,2)+"      "+k.givePosition(i,4)+"      "+k.givePosition(i,6)+"      "+k.givePosition(i,8)+"      "+k.givePosition(i,10)+"      "+k.givePosition(i,12)+"      "+k.givePosition(i,14)+"      "+k.givePosition(i,16)+"      "+k.givePosition(i,18)+"      "+k.givePosition(i,20)+"      "+k.givePosition(i,22)+"\n"


		+ "      "+k.givePosition(i,1)+"      "+k.givePosition(i,3)+"      "+k.givePosition(i,5)+"      "+k.givePosition(i,7)+"      "+k.givePosition(i,9)+"      "+k.givePosition(i,11)+"      "+k.givePosition(i,13)+"      "+k.givePosition(i,15)+"      "+k.givePosition(i,17)+"      "+k.givePosition(i,19)+"      "+k.givePosition(i,21)+"\n");
		

		
		
		
		
    }*/
} 
