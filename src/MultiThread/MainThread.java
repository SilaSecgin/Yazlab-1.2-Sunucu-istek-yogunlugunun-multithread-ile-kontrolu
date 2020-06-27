package MultiThread;

public class MainThread implements Runnable {
	Controller control = new Controller();
	int istekKabul = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<10000; i++) {
			
			istekKabul = control.get100();
			
			/// MAÝNTHREAD HER 200 MÝLÝSANÝYE DE BÝR ÝSTEÐE GERÝ DÖNÜÞ YAPIYOR
			try {
				control.mainThread.yield();
				control.mainThread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int istekDonus = control.get50();
			
			control.mainCapacity = (istekKabul-istekDonus)+control.mainCapacity;
			if(control.mainCapacity <0){ control.mainCapacity =0;}
			control.mainCapacityControl(control.mainCapacity);
			i = control.mainCapacity;
			
			/// MAÝNTHREAD HER 500 MÝLÝSANÝYE DE BÝR ÝSTEK KABUL EDÝYOR
			try {
				control.mainThread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
