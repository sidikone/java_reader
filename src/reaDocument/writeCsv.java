package reaDocument;

import java.io.*;
import java.util.*;

public class writeCsv {
	
	private String filName;
	protected Vector<String> colNames;
	protected Pair_data data2save;
	protected Tripl_data data2save_2;
	
	protected boolean needIndx;
	protected String delimeter = ",";

	/**
	 * 
	 */
	public writeCsv() {
	}

	/**
	 * 
	 */
	public writeCsv(String fname) {
		
		this.filName = fname;
	}
	
	
	public void open(String fname) {
		
		this.filName = fname;
	}
	
	
	public void get_data(readCsv obj_in) {
		
		this.colNames = obj_in.colNames_vect;
		
		if (obj_in.needIndx) {
			this.needIndx = obj_in.needIndx;
			this.data2save_2 = obj_in.getDataTrp();
		}
		else {
			this.data2save = obj_in.getData();	
		}	
	}
	
	
	protected String string_fusing(Vector<String> colNs, Pair_data myData, int idx) throws IOException {
		
		String unit_str = new String ();
		
		for(String value:colNs) {
			
			if (value == "indx") {continue;}
			
			if (value == colNs.firstElement()) {
				
				unit_str = myData.getFirst().get(value).elementAt(idx);
//				System.out.println(myData.getFirst().get(value).elementAt(idx));
			}
			
			else {
				unit_str +=  delimeter+myData.getSecond().get(value).elementAt(idx);
//				System.out.println(myData.getSecond().get(value).elementAt(idx));
			}
		}
		
		
		return unit_str;
	}
	
	
	protected String string_fusing_2(Vector<String> colNs, Tripl_data myData, int idx) throws IOException {
		
		String unit_str = new String();
				
		Pair_data myData2 = new Pair_data(myData.getFirst(), myData.getSecond());
		unit_str = string_fusing(colNs, myData2, idx);
		
		unit_str += delimeter+myData.getThird().get("indx").elementAt(idx);
		
		return unit_str;
	}
	
	
	public void save_data() throws Exception {
		
		File fout = new File(this.filName);
		BufferedWriter br_out = new BufferedWriter(new FileWriter(fout));
		int linSiz;
		
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
		
		br_out.write(unit_writ);
		br_out.newLine();
		
		for (int idx=0; idx<linSiz; idx++) {
			
			if (this.needIndx) {
				unit_writ = string_fusing_2(colNames, data2save_2, idx);
			}
			
			else {
				unit_writ = string_fusing(colNames, data2save, idx);
			}
			
			
			br_out.write(unit_writ);
			br_out.newLine();
			}
				
//		Iterator col_nams_it = colNames.iterator();		
//		while(col_nams_it.hasNext()) {
//			System.out.println(col_nams_it.next());
//		}
		br_out.close();
	}
	
}
