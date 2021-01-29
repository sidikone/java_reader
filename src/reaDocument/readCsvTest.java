package reaDocument;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.*;

class readCsvTest {
	
	
	@Before
	readCsv init () throws Exception{
		readCsv myCsv = new readCsv("mon_fichier_3.csv", true);
		return myCsv;
	}

	@Test
	void testDataShapeDetermination() throws Exception {
		
		readCsv myCsv2 = init();
		
		assertEquals(myCsv2.colSiz, 8);
		assertEquals(myCsv2.linSiz, 5);
	}

	@Test
	void testColumns() throws Exception {
		
		String [] mycol_ref = {"Col_1", "Col_2", "Col_3", "Col_4", "Col_5", "Col_6", "Col_7", "indx"};
		Vector <String> refCols = new Vector<String>(Arrays.asList(mycol_ref));
		
		Vector<String> myCols = new Vector <String>();
		readCsv myCsv2 = init();
		myCols = myCsv2.columns();
		
		assertEquals(myCols, refCols);
				
	}
//
//	@Test
//	void testCol_names_displ() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testString2vect() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLoad_data() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetData() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetDataTrp() {
//		fail("Not yet implemented");
//	}

}
