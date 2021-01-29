package reaDocument;

import java.util.*;

public class Pair_data {
	
	private Map<String, Vector<String>> first;  
	private Map<String, Vector<Float>> second;
	/**
	 * 
	 */
	public Pair_data() {
	}


	/**
	 * @param first
	 * @param second
	 */
	public Pair_data(Map<String, Vector<String>> first, Map<String, Vector<Float>> second) {
		this.first = first;
		this.second = second;
	}
	
	
	public Map<String, Vector<String>> getFirst() {
		return this.first;
	}
	
	
	public Map<String, Vector<Float>> getSecond(){
		return this.second;
	}
	
	
	public void addFirst(Map<String, Vector<String>> first) {
		this.first = first;
	}
	
	public void addSecond(Map<String, Vector<Float>> second) {
		this.second = second;
	}
	
	
	public void clear() {
		
		first.clear();
		second.clear();
	}
	
}
