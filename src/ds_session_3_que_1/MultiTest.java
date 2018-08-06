package ds_session_3_que_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiTest {

	@Test
	public void test() {
		MultivariatePoly multivarPoly = new MultivariatePoly();
		
		int coeff1 = 2;
		int variable1[][] = {
				{1, 2},
				{2, 3},
				{3, 4}
		};
		multivarPoly.add(coeff1, variable1);
		multivarPoly.printPolyList();
		
		int coeff2 = -4;
		int variable2[][] = {
				{5, 3},
				{6, 1},
				{10, 4}
		};
		multivarPoly.add(coeff2, variable2);
		multivarPoly.printPolyList();
		
		int variable3[][] = new int[0][0];
		multivarPoly.add(3, variable3);
		multivarPoly.printPolyList();
		
	}

}
