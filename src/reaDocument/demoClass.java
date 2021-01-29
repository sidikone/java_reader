package reaDocument;

//import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//import java.util.Collections;

public class demoClass {

	public static void main(String[] args)
							throws Exception{
		
		
		readCsv myCsv2 = new readCsv("mon_fichier_3.csv", true);
		
		System.out.println(myCsv2.getData().getSecond().get("Col_7"));
		System.out.println("\n");
		
		display disp = new display(myCsv2);
		disp.show();
		
		System.out.println("\n".repeat(1));
		disp.head(3);
		
		System.out.println("\n".repeat(1));
		disp.tail(1);
		
		
		writeCsv mycsv = new writeCsv("mon_fichier_15.csv");
		mycsv.get_data(myCsv2);
		mycsv.save_data();
	}

}
