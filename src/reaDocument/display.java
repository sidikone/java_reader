package reaDocument;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class display extends writeCsv{
	
	public display(readCsv obj_in) {
		super();
		get_data(obj_in);
		this.delimeter = "\t";
	}
	
	
	public void show() throws IOException {
		
		
		int linSiz;
		int strlen;
		
		// data length
		if (this.needIndx) {

			linSiz = data2save_2.getFirst().get(colNames.get(0)).size();
		}
		
		else {
			linSiz = data2save.getFirst().get(colNames.get(0)).size();
		}
		
		String unit_writ=new String();
		boolean first_elt = false;
		for (String value:colNames) {
			
			if (!first_elt) {
				unit_writ = value;
				first_elt = true;
				}
			
			else {unit_writ += delimeter+value;}			
		}
		
		strlen = unit_writ.length();
		System.out.println(unit_writ);
		System.out.println("-".repeat(strlen + 2 * (colNames.size()-1)));
		
		for (int idx=0; idx<linSiz; idx++) {
			
			if (this.needIndx) {
				unit_writ = string_fusing_2(colNames, data2save_2, idx);
			}
			
			else {
				unit_writ = string_fusing(colNames, data2save, idx);
			}
			
			System.out.println(unit_writ);
			}
		System.out.println("-".repeat(strlen + 2 * (colNames.size()-1)));
	}
	
	
	public void head(int nb) throws IOException {
		
		int strlen;
		
		String unit_writ=new String();
		boolean first_elt = false;
		for (String value:colNames) {
			
			if (!first_elt) {
				unit_writ = value;
				first_elt = true;
				}
			
			else {unit_writ += delimeter+value;}			
		}
		
		strlen = unit_writ.length();
		System.out.println(unit_writ);
		System.out.println("-".repeat(strlen + 2 * (colNames.size()-1)));
		
		for (int idx=0; idx<nb; idx++) {
			
			if (this.needIndx) {
				unit_writ = string_fusing_2(colNames, data2save_2, idx);
			}
			
			else {
				unit_writ = string_fusing(colNames, data2save, idx);
			}
			
			System.out.println(unit_writ);
			}
		System.out.println("-".repeat(strlen + 2 * (colNames.size()-1)));
		
	}
	
	
	public void tail(int nb) throws IOException {
		
		
		int linSiz;
		int strlen;
		
		// data length
		if (this.needIndx) {

			linSiz = data2save_2.getFirst().get(colNames.get(0)).size();
		}
		
		else {
			linSiz = data2save.getFirst().get(colNames.get(0)).size();
		}
		
		String unit_writ=new String();
		boolean first_elt = false;
		for (String value:colNames) {
			
			if (!first_elt) {
				unit_writ = value;
				first_elt = true;
				}
			
			else {unit_writ += delimeter+value;}			
		}
		
		strlen = unit_writ.length();
		System.out.println(unit_writ);
		System.out.println("-".repeat(strlen + 2 * (colNames.size()-1)));
		
		for (int idx=linSiz-nb; idx<linSiz; idx++) {
			
			if (this.needIndx) {
				unit_writ = string_fusing_2(colNames, data2save_2, idx);
			}
			
			else {
				unit_writ = string_fusing(colNames, data2save, idx);
			}
			
			System.out.println(unit_writ);
			}
		System.out.println("-".repeat(strlen + 2 * (colNames.size()-1)));
	}
}
