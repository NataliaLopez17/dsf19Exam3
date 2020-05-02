package ciic4020S2Exam3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class P1WrapperTestStd {

	P1Wrapper.SimpleBinaryTreeImp<String> T1;
	P1Wrapper.SimpleBinaryTreeImp<String> T2;
	P1Wrapper.SimpleBinaryTreeImp<String> T3;
	P1Wrapper.SimpleBinaryTreeImp<String> T4;
	P1Wrapper.SimpleBinaryTreeImp<String> T5;
	P1Wrapper.SimpleBinaryTreeImp<String> T6;


	@Before
	public void setUp() throws Exception {
		this.T1 = new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Joe"));
		
		this.T2 = new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Ned"), T1, null);

		this.T3 = new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Jim"), T1, 
				new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Ned")));
		
		this.T4 = new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Kim"), T1,  T2);
		
		this.T6 = new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Ken"), T1, 
				new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Apu")));
	
		this.T5 = new P1Wrapper.SimpleBinaryTreeImp<String>(new P1Wrapper.BinaryTreeNode<String>("Al"), T2,  T4);

	}

	@Test
	public void test1() {
		
		System.err.println("**Test 1 tree T1: \n");
		this.T1.print(System.err);
		assertEquals("Fails oneChildCount on T1. Expected value: 0", 0, this.T1.oneChildCount());
		System.err.println("\n**Passes Test1 \n");
	}

	@Test
	public void test2() {
		
		System.err.println("**Test 2 tree T2: \n");
		this.T2.print(System.err);
		assertEquals("Fails oneChildCount on T2.Expected value: 1", 1, this.T2.oneChildCount());
		System.err.println("\n**Passed Test2 \n");
	}


}