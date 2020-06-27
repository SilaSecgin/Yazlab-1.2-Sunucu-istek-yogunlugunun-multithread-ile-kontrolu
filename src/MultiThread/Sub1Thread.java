package MultiThread;


public class Sub1Thread implements Runnable {
	Controller control = new Controller();
	int istekKabul = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5000; i++) {
			
			istekKabul = control.get50();
			control.mainCapacity = control.mainCapacity-istekKabul;
			if(control.mainCapacity < 0 ) control.mainCapacity =0;
			//control.mainCapacityControl(control.mainCapacity);
			
			/// SUB1 HER 300 MÝLÝSANÝYE DE BÝR ÝSTEÐE GERÝ DÖNÜÞ YAPIYOR
			try {
				control.sub1Thread.yield();
				control.sub1Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int istekDonus=control.get50();
			int tut = istekKabul-istekDonus;

			control.sub1Capacity = tut+control.sub1Capacity;
			if(control.sub1Capacity < 0) control.sub1Capacity=0;
			control.sub1CapacityControl(control.sub1Capacity);
				
				i=control.sub1Capacity;
			
			/// SUB1 HER 500 MÝLÝSANÝYE DE BÝR ÝSTEK KABUL EDÝYOR
			try {
				control.sub1Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
