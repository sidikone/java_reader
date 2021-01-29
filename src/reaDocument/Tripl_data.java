package reaDocument;

import java.util.Map;
import java.util.Vector;

public class Tripl_data extends Pair_data{
	
	private Map<String, Vector<Integer>> third;
	
	
	public Tripl_data() {
		super();
	}
	
	
	public Tripl_data(Pair_data dataPair, Map<String, Vector<Integer>> third) {
		
		super(dataPair.getFirst(), dataPair.getSecond());
		this.third = third;
	}
	
	public Tripl_data(Map<String, Vector<String>> first, Map<String, Vector<Float>> second, Map<String, Vector<Integer>> third) {
		super(first, second);
		this.third = third;
	}
	
	
	public void addThird(Map<String, Vector<Integer>> third) {
		this.third = third;
	}
	
	
	public Map<String, Vector<Integer>> getThird(){
		return this.third;
	}
	
	
}
