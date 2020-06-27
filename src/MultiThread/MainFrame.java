package MultiThread;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	
    public static JPanel panel;
    public static JFrame frame; 
    
  
public static void main(String[] args) {
	// TODO Auto-generated method stub
	frame = new JFrame("Giris Ekrani");
	frame.setBounds(50, 50, 1300, 700);
	frame.setLocation(10, 10);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel = new JPanel();
	panel.setLayout(null);
	frame.setContentPane(panel);
	frame.setResizable(false);
	frame.setVisible(true);
       
    ControllerFrame controlFrame = new ControllerFrame();
    controlFrame.start();
    
    Controller control = new Controller();
	
	control.mainThread = new Thread(new MainThread());
	control.mainThread.start();
	control.mainThread.setPriority(10);
 	
	control.sub1Thread = new Thread(new Sub1Thread());
	control.sub1Thread.start();
	control.sub1Thread.setPriority(10);
 	
	control.sub2Thread = new Thread(new Sub2Thread());
	control.sub2Thread.start();
	control.sub2Thread.setPriority(10);
    
    
}
}
