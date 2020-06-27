package MultiThread;

import java.util.Random;


public class Controller {
	public static Thread mainThread;
	public static Thread sub1Thread;
	public static Thread sub2Thread;
	public static int mainCapacity =0;
	public static int sub1Capacity =0;
	public static int sub2Capacity =0;
	public static Thread threadN[] = new Thread [100];
	public static int subNCapacity[] = new int[100];
	public static int counter =0;
	public static ControllerFrame controlFrame = new ControllerFrame();
	
	public static int get50 () {
		Random rnd = new Random();
		return rnd.nextInt(50);
	}
	public static int get100 () {
		Random rnd2 = new Random();
		return rnd2.nextInt(100);
	}
	public static int get300 () {
		Random rnd2 = new Random();
		return rnd2.nextInt(300);
	}
	public static int get500 () {
		Random rnd2 = new Random();
		return rnd2.nextInt(500);
	}
	public static void mainCapacityControl(int mainCap) {
		if(mainCap > 10000) {
			System.out.println("MainThread Capacity is Full ! ");
		}
		else {
			System.out.println("Main --> "+mainCap);
			controlFrame.jl_main_percent.setText("%"+String.valueOf(mainCalculate(mainCap)));
			controlFrame.progressBar.setValue(mainCalculate(mainCap));
		}
	}
	public static void sub1CapacityControl(int subCap) {
		if(childCalculate(subCap)>= 70) {
			subNCapacity[counter]= sub1ThreadDivide(subCap);
			controlFrame.progresBarCreate();
			subNCreate();
			
			
		}
		else {
			System.out.println("Child 1 -- > "+subCap);
			controlFrame.jl_child_percent.setText("%"+String.valueOf(childCalculate(subCap)));
			controlFrame.progressBar2.setValue(childCalculate(subCap));
		}
	}
	public static void sub2CapacityControl(int subCap2) {
		if(childCalculate(subCap2)>= 70) {
			subNCapacity[counter]= sub2ThreadDivide(subCap2);
			controlFrame.progresBarCreate();
			subNCreate();
		}
		else {
			System.out.println("Child 2 -- > "+subCap2);
			controlFrame.jl_child_percent2.setText("%"+String.valueOf(childCalculate(subCap2)));
			controlFrame.progressBar3.setValue(childCalculate(subCap2));
		}
	}
	public static int mainCalculate(int value) {
		int mainPercent = value*100/10000;
		return mainPercent;
	} 
	public static int childCalculate(int value) {
		int threadPercent = value*100/5000;
		return threadPercent;
	}
	private static int sub1ThreadDivide(int sub1) {
		sub1 = sub1/2;
		sub1Capacity = sub1;
		return sub1;
	}
	private static int sub2ThreadDivide(int sub2) {
		sub2 = sub2/2;
		sub2Capacity = sub2; 
		return sub2;
	}
	private static void subNCreate () {
		threadN[counter] =new Thread (new SubNThread()); 
		threadN[counter].start();
		counter++;
	}
	public static void subNCapacityControl(int subCapN, int n) {
		if(childCalculate(subCapN)>= 70) {
			subNCapacity[n]= sub2ThreadDivide(subCapN);
			controlFrame.progresBarCreate();
			subNCreate();
		}
		else {
			System.out.println("Child N "+counter +" -- > "+subCapN);
			controlFrame.jLabel2[n].setText("%"+String.valueOf(childCalculate(subCapN)));
			controlFrame.progressBarr[n].setValue(childCalculate(subCapN));
		}
	}
}
