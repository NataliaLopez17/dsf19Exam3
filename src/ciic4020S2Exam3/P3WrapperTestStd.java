package ciic4020S2Exam3;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class P3WrapperTestStd {
	
	P3Wrapper.BinarySearchTree<Integer, Integer> T1;
	P3Wrapper.BinarySearchTree<Integer, Integer> T2;

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
	
	public static void print(ArrayList<P3Wrapper.KeyValuePair<Integer, Integer>> L, PrintStream P) {
		P.print("[ ");
			
		for (P3Wrapper.KeyValuePair<Integer, Integer> o: L) {
			P.print(o.getValue() + " ");
		}
		
		P.println("]");
		
	}
	@Before
	public void setUp() throws Exception {
		T1 = new P3Wrapper.BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T1.put(50, 50);
		T1.put(10, 10);
		T1.put(56, 56);
		T1.put(2, 2);
		T1.put(23, 23);
		T1.put(70, 70);
		T1.put(0, 0);
		T1.put(61, 61);
		
		T2 = new P3Wrapper.BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T2.put(20, 20);

	}

	@Test
	public void test1() {
		System.err.println("**Test 1 tree T1: \n");
		this.T1.print(System.err);
		
		ArrayList<P3Wrapper.KeyValuePair<Integer, Integer>> L = T1.inRangeValues(20, 51);
		System.err.println("*Test 1 T1.inRangeValues(20, 51): \n");
		print(L, System.err);
		assertEquals("Fails inRangeValues(20, 51) on T1. Expected value: [50 23]", true, 
				L.get(0).getValue() == 50 && L.get(1).getValue() == 23);
		System.err.println("\n**Passes Test1 \n");

	}

	@Test
	public void test2() {
		System.err.println("**Test 2 tree T2: \n");
		this.T2.print(System.err);
		
		ArrayList<P3Wrapper.KeyValuePair<Integer, Integer>> L = T2.inRangeValues(0, 25);
		System.err.println("*Test 2 T2.inRangeValues(0, 25): \n");
		print(L, System.err);
		assertEquals("Fails inRangeValues(0, 25) on T2. Expected value: [0 2 10 23]", true, L.get(0).getValue() == 20);
		System.err.println("\n**Passes Test2 \n");

	}


}