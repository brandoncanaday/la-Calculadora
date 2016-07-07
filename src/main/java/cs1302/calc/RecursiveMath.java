package cs1302.calc;

/**
 * This class provides methods to perform basic math operations, using only recursive implementations.
 * @author Jeffrey Nguyen
 */
public class RecursiveMath implements Math {

    public int add(int lhs, int rhs) {
    	if (rhs == 0) return lhs; 
    	return add(inc(lhs), dec(rhs));
    } // add

    public int sub(int lhs, int rhs) {
    	if (rhs == 0) return lhs; 
    	if (rhs > lhs) return 0; 
    	return sub(dec(lhs), dec(rhs)); 
    } // sub

    public int mul(int lhs, int rhs) {
    	if (lhs==0 || rhs==0) return 0;
    	return add(lhs, mul(lhs, dec(rhs)));
    } // mul

    public int div(int lhs, int rhs) throws ArithmeticException {
    	if(rhs == 0) throw new ArithmeticException();
	   	if (lhs < rhs) return 0;
	   	return inc(div(sub(lhs, rhs), rhs));
    } // div

    public int fac(int n) {
    	if (n == 0) return 1; 
    	return n * fac(dec(n));
    } // fac								
    
    public int pow(int lhs, int rhs) {
        if(rhs==0) return 1;
    	return pow_acc(1, lhs, rhs);			//////////////
    } // pow						            //
    								    // accumulator helper methods allows pow() to be pure tail recursive
    public int pow_acc(int acc, int lhs, int rhs) {		    //
       	if(rhs == 0) return acc;	        	//////////////
       	return pow_acc(mul(acc, lhs), lhs, dec(rhs));
    } // pow_acc

} // RecursiveMath
