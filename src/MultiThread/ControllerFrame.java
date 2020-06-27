package MultiThread;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class ControllerFrame {
	static int deneme=180,deneme2=150;
	public static JLabel jl_main, jl_main_percent, jl_child, jl_child_percent;
	public static JLabel jLabel[] = new JLabel[10];
	public static JLabel jLabel2[] = new JLabel[10];
    public static JLabel jl_child2, jl_child_percent2;
    public static JProgressBar progressBar,progressBar2,progressBar3;
    public static JProgressBar progressBarr[] = new JProgressBar[10];;
    public static MainFrame main = new MainFrame();
    public static Controller control = new Controller();
    
	public static void start() {
		
		jl_main = new JLabel("Main Thread");
	    jl_main.setForeground(Color.black);
	    jl_main.setBounds(65, 150, 125, 25);
	    
	    jl_main_percent = new JLabel("%0");
	    jl_main_percent.setForeground(Color.black);
	    jl_main_percent.setBounds(220, 180, 125, 25);
	        
	    progressBar = new JProgressBar();
		progressBar.setBounds(65, 180, 125, 25);
		progressBar.setValue(0);
		
		jl_child = new JLabel("Child Thread");
		jl_child.setForeground(Color.black);
		jl_child.setBounds(65, 210, 125, 25);
	    
		jl_child_percent = new JLabel("%0");
		jl_child_percent.setForeground(Color.black);
		jl_child_percent.setBounds(220, 240, 125, 25);
	        
	    progressBar2 = new JProgressBar();
		progressBar2.setBounds(65, 240, 125, 25);
		progressBar2.setValue(0);
		
		jl_child2 = new JLabel("Child Thread2");
		jl_child2.setForeground(Color.black);
		jl_child2.setBounds(65, 270, 125, 25);
	    
		jl_child_percent2 = new JLabel("%0");
		jl_child_percent2.setForeground(Color.black);
		jl_child_percent2.setBounds(220, 300, 125, 25);
	        
	    progressBar3 = new JProgressBar();
		progressBar3.setBounds(65, 300, 125, 25);
		progressBar3.setValue(0);
		
		main.panel.add(jl_main);
		main.panel.add(jl_main_percent);
		main.panel.add(progressBar);
	    
		main.panel.add(jl_child);
		main.panel.add(jl_child_percent);
		main.panel.add(progressBar2);
	    
		main.panel.add(jl_child2);
		main.panel.add(jl_child_percent2);
		main.panel.add(progressBar3);
	}
	
    public static void progresBarCreate() {
		
		jLabel[control.counter] = new JLabel("Child Thread "+(3+control.counter));
		jLabel[control.counter].setForeground(Color.black);
		jLabel[control.counter].setBounds(300, deneme2, 125, 25);
		
		jLabel2[control.counter] = new JLabel();
		jLabel2[control.counter].setForeground(Color.black);
		jLabel2[control.counter].setBounds(440, deneme, 125, 25);
		
		progressBarr[control.counter] = new JProgressBar();
		progressBarr[control.counter].setBounds(300, deneme, 125, 25);
		
		main.panel.add(progressBarr[control.counter]);
		main.panel.add(jLabel[control.counter]);
		main.panel.add(jLabel2[control.counter]);
		main.panel.repaint();
		
		deneme=deneme+60;
		deneme2 = deneme2+60;
	}
}
