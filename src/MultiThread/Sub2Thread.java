package MultiThread;

public class Sub2Thread implements Runnable {
	Controller control = new Controller();
	int tut =0;
	int istekKabul=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5000; i++) {
			
			istekKabul = control.get50();
			control.mainCapacity = control.mainCapacity - istekKabul;
			if(control.mainCapacity < 0) control.mainCapacity=0;
			//control.mainCapacityControl(control.mainCapacity);
			
			/// SUB1 HER 300 MÝLÝSANÝYE DE BÝR ÝSTEÐE GERÝ DÖNÜÞ YAPIYOR
			try {
				control.sub2Thread.yield();
				control.sub2Thread.sleep(300);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int istekDonus=control.get50();
			int tut = istekKabul-istekDonus;
			
			control.sub2Capacity = tut+control.sub2Capacity;
			if(control.sub2Capacity <0 )control.sub2Capacity =0;
			control.sub2CapacityControl(control.sub2Capacity);
			i = control.sub2Capacity;
			
			/// SUB1 HER 500 MÝLÝSANÝYE DE BÝR ÝSTEK KABUL EDÝYOR
			try {
				control.sub2Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

}
