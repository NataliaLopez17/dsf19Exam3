package ciic4020S2Exam3;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class P4WrapperTestStd {
	
	ArrayList<Integer> L1 ;
	

	//// 
	/// Integer Comparator
	public static class IntegerComparator implements Comparator<Integer> {
		
		public IntegerComparator() {
			
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
		
	}

	@Before
	public void setUp() throws Exception {
		L1 = new ArrayList<Integer>();
		L1.add(20);
		L1.add(39);
		L1.add(2);
		L1.add(90);
		
	}

	public static void print(ArrayList<Integer> L, PrintStream P) {
		P.print("[ ");
			
		for (Integer o: L) {
			P.print(o+ " ");
		}
		
		P.println("]");
		
	}

	
	@Test
	public void test1() {
		System.err.println("**Test 1 List L1: \n");
		print(L1, System.err);
		
		ArrayList<Integer> L = P4Wrapper.findNLargestValues(L1, 2);
		System.err.println("*Test 1 findNLargestValues(L1, 2): \n");
		print(L, System.err);
		assertEquals("Fails findNLargestValues(L1, 2) on L1. Expected value: [90 39]", true, 
				L.get(0) == 90 && L.get(1) == 39);
		System.err.println("\n**Passes Test1 \n");

	}

	@Test
	public void test2() {
		L1.add(-1);
		L1.add(100);
		L1.add(45);
		System.err.println("**Test 2 List L1: \n");
		print(L1, System.err);
		
		ArrayList<Integer> L = P4Wrapper.findNLargestValues(L1, 3);
		System.err.println("*Test 2 findNLargestValues(L1, 3): \n");
		print(L, System.err);
		assertEquals("Fails findNLargestValues(L1, 3) on L1. Expected value: [100 90 45]", true, 
				L.get(0) == 100 && L.get(1) == 90 && L.get(2) == 45);
		System.err.println("\n**Passes Test2 \n");

	}

}