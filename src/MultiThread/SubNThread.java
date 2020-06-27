package MultiThread;


public class SubNThread implements Runnable {
	Controller control = new Controller();
	ControllerFrame controlFrame = new ControllerFrame();
	int istekKabul = 0;
	int tut = 0;
	int n = control.counter;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = control.subNCapacity[n]; i<5000;i++) {
			istekKabul = control.get50();
			control.subNCapacity[n]=control.subNCapacity[n]-istekKabul;
			if(control.subNCapacity[n]<0) { 
				control.threadN[n].stop();
			}
			//control.subNCapacityControl(control.subNCapacity[n], n);
			
			/// SUB1 HER 300 MÝLÝSANÝYE DE BÝR ÝSTEÐE GERÝ DÖNÜÞ YAPIYOR
			try {
				control.threadN[n].yield();
				control.threadN[n].sleep(300);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int istekDonus=control.get50();
			int tut = istekKabul-istekDonus;
			
			control.subNCapacity[n] = tut+control.subNCapacity[n];
			if(control.subNCapacity[n] <0 ) {
				control.subNCapacity[n] =0;
				controlFrame.jLabel[n].setVisible(false);
				controlFrame.jLabel2[n].setVisible(false);
				controlFrame.progressBarr[n].setVisible(false);
				control.threadN[n].stop();
			}
			control.subNCapacityControl(control.subNCapacity[n], n);
			
			i = control.subNCapacity[n];
		}
	}
	



}
