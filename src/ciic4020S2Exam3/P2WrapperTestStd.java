package ciic4020S2Exam3;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class P2WrapperTestStd {
	P2Wrapper.SimpleBinaryTreeImp<String> T1;
	P2Wrapper.SimpleBinaryTreeImp<String> T2;
	P2Wrapper.SimpleBinaryTreeImp<String> T3;
	P2Wrapper.SimpleBinaryTreeImp<String> T4;
	P2Wrapper.SimpleBinaryTreeImp<String> T5;
	P2Wrapper.SimpleBinaryTreeImp<String> T6;
	P2Wrapper.SimpleBinaryTreeImp<String> T7;


	@Before
	public void setUp() throws Exception {
		this.T1 = new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Joe"));
		this.T2 = new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Ned"), T1, null);
		this.T3 = new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Jim"), T1, 
				new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Ned")));
		
		
		this.T4 = new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Jim"), T1, 
				new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Joe")));
	
		
		this.T7 = new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Pol"));
		
	

		this.T5 = new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Al"), T4,  T4);
		this.T6 = new P2Wrapper.SimpleBinaryTreeImp<String>(new P2Wrapper.BinaryTreeNode<String>("Ken"), T4,  T3);
	}

	@Test
	public void test1() {
		System.err.println("**Test 1 tree T1: \n");
		this.T1.print(System.err);

		assertEquals("Fails isSymmetric on T1. Expected value: true", true, T1.isSymmetric());
		System.err.println("\n**Passes Test1 \n");
	}
	
	@Test
	public void test2() {
		System.err.println("**Test 2 tree T2: \n");
		this.T2.print(System.err);

		assertEquals("Fails isSymmetric on T2. Expected value: false", false, T2.isSymmetric());
		System.err.println("\n**Passes Test2 \n");
	}


}