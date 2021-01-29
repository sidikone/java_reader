package reaDocument;

import java.io.*;
import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class readCsv {
	
	private String fileName;
	private String colNames;
	
	protected boolean needIndx;
	
	protected Pair_data result_out = new Pair_data();
	protected Map <String, Vector <Integer>> result_rang = new HashMap<String, Vector <Integer>>();
	protected Tripl_data result_out_2 = new Tripl_data();
	
	protected int colSiz;
	protected int linSiz;
	
	protected String delimeter = ",";
	protected Vector <String> colNames_vect = new Vector <String>();
	/**
	 * 
	 */
	public readCsv() {
		// Default Constructor
		System.out.println("\n Object created, to process your data, you need : ");
		System.out.println(" ---------------------------------------------- ");
		System.out.println(" 1. Open file with <open function>");
		System.out.println(" 2. Load file with <loadData function>");
		System.out.println(" 3. Return data to your own variable with <getData function>");
		
	}
	
	
	public readCsv(String fname) throws Exception {
		
		initialisation(fname);
		load_data();
		info();
	}
	
	
	public readCsv(String fname, boolean indx) throws Exception {
		
		initialisation(fname);
		load_data();
		
		this.needIndx = indx;
		
		if (indx) {
			add_indx_numbr();
		}
		info();
		
//		System.out.println(result_out_2.getFirst());
//		System.out.println(result_out_2.getSecond());
//		if (indx) {
//			result_rang.clear();
//			result_out.clear();
//		}
		
	}
	
	protected void add_indx_numbr() {
		
		Vector <Integer> index = new Vector<Integer>();
        List<Integer> range = IntStream.rangeClosed(1, linSiz).boxed().collect(Collectors.toList());
		index.addAll(range);
		colNames_vect.add("indx");
		this.result_rang.put("indx", index);
		
		Tripl_data dataIndx = new Tripl_data(result_out, result_rang);
		
		result_out_2.addFirst(dataIndx.getFirst());
		result_out_2.addSecond(dataIndx.getSecond());
		result_out_2.addThird(dataIndx.getThird());

	}
	
	
	public void open(String fname) throws Exception {
		
		initialisation (fname);
	}
	
	
	protected void initialisation (String fname) throws Exception {
		fileName = fname;
		get_columns(fname);
		columns_stl();
		
	}
	
	
	protected void get_columns(String fname) throws Exception {
		
		File fin = new File(fname);		
		BufferedReader br_fin = new BufferedReader(new FileReader(fin));
		colNames = br_fin.readLine();
		br_fin.close();
	}
	
	
	protected void columns_stl() {
		
		StringTokenizer string2stream = new StringTokenizer(colNames, delimeter);
		
		while (string2stream.hasMoreTokens()) {
			colNames_vect.add(string2stream.nextToken());			
		}	
	}
	
	public Vector<String> columns(){
		return colNames_vect;
	}
	
	
	public void col_names_displ () {
		
		for (String col:colNames_vect) {
			
			System.out.print(col);
			System.out.print("  ");
		}
		System.out.println();
	}
	
	
	protected Vector <String> string2vect(String unitString){
		
		Vector <String> vect_str =  new Vector<String>();
		StringTokenizer string2stream = new StringTokenizer(unitString, delimeter);
		
		while (string2stream.hasMoreTokens()) {
			vect_str.add(string2stream.nextToken());			
		}
		
		return vect_str;
	}
	
	
	
	public void load_data() throws Exception {
		
		File fin = new File(fileName);
		BufferedReader br_fin = new BufferedReader(new FileReader(fin));
		Vector <String> index_vect = new Vector <String>();
		
		int col_siz = colNames_vect.size();
		--col_siz;
		
		Vector <Vector <Float>> data_values = new Vector<Vector <Float>> ();
		
		
		// Local col_names variables used to create a map of vector
		Vector <String> local_col_nams = new Vector<String>();
		local_col_nams.addAll(0, colNames_vect);
		
		
		Map <String, Vector <String>> result_index = new HashMap<String, Vector <String>>();
		Map <String, Vector<Float>> result_data= new HashMap<String, Vector <Float>>();
		
		for (int idx = 0; idx<col_siz; idx++) {
			data_values.add(new Vector <Float>());
		}
				
		
		br_fin.readLine(); // Read the first without use it
		String myText;
		int col_count = 0;
		
		while ((myText = br_fin.readLine()) != null) {
			
			// Saving the index into a vector
			index_vect.add(string2vect(myText).firstElement());
			
			col_count = 0;
			for (String value:string2vect(myText)) {
				
				if (!value.equals(string2vect(myText).firstElement())) {
					data_values.elementAt(col_count).add(Float.parseFloat(value));
					++col_count;
				}
			}
		}
		
		br_fin.close();
		
		result_index.put(colNames_vect.get(0), index_vect);
		local_col_nams.remove(0);		// Remove the first element of local col_vect
		
		for (int id =0; id<local_col_nams.size(); id++) {
			result_data.put(local_col_nams.get(id), data_values.elementAt(id));
		}
		result_out.addFirst(result_index);
		result_out.addSecond(result_data);
		
		shapDetermination();
	}
	
	
	public Pair_data getData() {
		
		return result_out;
	}
	
	
	public Tripl_data getDataTrp() {
		
		return result_out_2;
	}
	
	
	protected void shapDetermination() {
		
		colSiz = colNames_vect.size();
		linSiz = result_out.getFirst().get(colNames_vect.get(0)).size();
	}
	
	
	public void info() {
		
		shapDetermination();
		System.out.println("\n File info");
		System.out.println(" ---------");
		
		System.out.print(" * file name : ");
		System.out.println(fileName);
		
		System.out.print(" * file shape (lines x cols) = (");
		System.out.print(linSiz);
		System.out.print(" x ");	
		System.out.print(colSiz);
		System.out.println(")");
		
		System.out.print(" * columns names : ");
		col_names_displ ();
		System.out.println();

	}
	
	
}
