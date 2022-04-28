package gui;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class MappaInterfaccia extends JFrame{
	
	private JPanel panel=new JPanel();
	private JLabel sfondoMapAlien=new JLabel(new ImageIcon("src/main/java/gui/galilei.jpg"));
	private JLayeredPane layeredPane;
	private JButton uno=new JButton("Maremma maiala");

		public MappaInterfaccia(){
			layeredPane = new JLayeredPane();
			setContentPane(layeredPane);
			
			setSize(1200, 800);
			setTitle("Interface Map");
			
			panel.add(uno);
			
			setBounds(0, 0, 1200, 800);
			sfondoMapAlien.setBounds(0,0,1115, 946);
			panel.setBounds(100, 100, 100, 100);
			
			add(panel);
			add(sfondoMapAlien);
			
			layeredPane.setLayer(sfondoMapAlien,0);
			layeredPane.setLayer(panel, 10);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			
		}
		
		
	
	
	
	
}
