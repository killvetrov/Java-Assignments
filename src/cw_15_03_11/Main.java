package cw_15_03_11;

import cw_15_03_11_nasled.*;
import cw_15_03_11_pract1.*;

public class Main {
	
	public static void main(String[] args) {
		
		Line myLine1 = new Line(8);
		myLine1.draw();
		
		System.out.println("Длина линии = " + myLine1.calcPerimeter());
		System.out.println();
		
		Square mySq = new Square(5);
		mySq.draw();
		System.out.println("Периметр = " + mySq.calcPerimeter());
		System.out.println("Площадь = " + mySq.calcArea());
		System.out.println();
		
		Rectangle myRect = new Rectangle(20, 8);
		myRect.draw();
		System.out.println("Периметр = " + myRect.calcPerimeter());
		System.out.println("Площадь = " + myRect.calcArea());
		System.out.println();
		
		Circle myCircle = new Circle(19);		
		myCircle.draw(true);
		System.out.println("Длина окружности = " + myCircle.calcLength());
		System.out.println("Площадь окружности = " + myCircle.calcArea());
		
//		Phone myNokia = new Phone("Nokia 3110", "+380 913-33-33");
//		Phone mySiemens = new Phone("Siemens A30", "+380 113-55-55");
//		Smartphone myLumia = new Smartphone("Nokia Lumia 920", "+380 222-33-33", true);
//		Smartphone myChineseSmart = new Smartphone("Chinese Replica", "+380 992-73-73", false);
//		Smartphone myNexus4 = new Smartphone("Nexus 4", "+380 212-27-59", true);
//		
//		mySiemens.call("102");
//		myChineseSmart.playGames();
//		myNexus4.playGames();
		
	}

}
