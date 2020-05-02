package ciic4020S2Exam3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OnlineWrapper3Tester {

	OnlineWrapper3.BinaryExpressionTree T_12;
	OnlineWrapper3.BinaryExpressionTree T_3;
	OnlineWrapper3.BinaryExpressionTree T0;
	OnlineWrapper3.BinaryExpressionTree T1;
	OnlineWrapper3.BinaryExpressionTree T10;
	OnlineWrapper3.BinaryExpressionTree T20;
	OnlineWrapper3.BinaryExpressionTree T5;

	
	@Before
	public void setUp() {
		T_12 = new OnlineWrapper3.BinaryExpressionTree(-12);
		T_3 = new OnlineWrapper3.BinaryExpressionTree(-3);
		T0 = new OnlineWrapper3.BinaryExpressionTree(0);
		T1 = new OnlineWrapper3.BinaryExpressionTree(1);
		T10 = new OnlineWrapper3.BinaryExpressionTree(10);
		T20 = new OnlineWrapper3.BinaryExpressionTree(20);
		T5 = new OnlineWrapper3.BinaryExpressionTree(5);
	}
	
	@Test
	public void toStringTest() {
		OnlineWrapper3.BinaryExpressionTree TSum 
		= new OnlineWrapper3.BinaryExpressionTree(OnlineWrapper3.ExpressionType.ADD,T0, T10);
		OnlineWrapper3.BinaryExpressionTree TSub 
		= new OnlineWrapper3.BinaryExpressionTree(OnlineWrapper3.ExpressionType.MINUS,T_12, T20);
		OnlineWrapper3.BinaryExpressionTree TMult 
		= new OnlineWrapper3.BinaryExpressionTree(OnlineWrapper3.ExpressionType.MULT,T_3, T20);
		OnlineWrapper3.BinaryExpressionTree TDiv
		= new OnlineWrapper3.BinaryExpressionTree(OnlineWrapper3.ExpressionType.DIV,T5, T_3);
		OnlineWrapper3.BinaryExpressionTree TNested1
		= new OnlineWrapper3.BinaryExpressionTree(OnlineWrapper3.ExpressionType.DIV,T_12, TSum);
		OnlineWrapper3.BinaryExpressionTree TNested2
		= new OnlineWrapper3.BinaryExpressionTree(OnlineWrapper3.ExpressionType.MULT, TSub, TSum);
		OnlineWrapper3.BinaryExpressionTree TNested3
		= new OnlineWrapper3.BinaryExpressionTree(OnlineWrapper3.ExpressionType.MINUS,TNested1, TNested2);
		
		assertEquals("Sum display Doesnt match", "(0.0 + 10.0)" , TSum.toString());
		assertEquals("Substraction display Doesnt match", "(-12.0 - 20.0)" , TSub.toString());
		assertEquals("Multiplication display Doesnt match", "(-3.0 * 20.0)" , TMult.toString());
		assertEquals("Division display Doesnt match", "(5.0 / -3.0)" , TDiv.toString());
		assertEquals("Nested Sum in Division display Doesnt match", "(-12.0 / (0.0 + 10.0))" , TNested1.toString());
		assertEquals("Nested Sum by Substract display Doesnt match", "((-12.0 - 20.0) * (0.0 + 10.0))" , TNested2.toString());
		assertEquals("Nested Multiple operation display Doesnt match", "((-12.0 / (0.0 + 10.0)) - ((-12.0 - 20.0) * (0.0 + 10.0)))" , TNested3.toString());
		
	}

}