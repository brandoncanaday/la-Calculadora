package cs1302.calc;

/**
 * This class provides methods to perform basic math operations, using only iterative implementations.
 * @author Jeffrey Nguyen
 */
public class IterativeMath implements Math {

    public int add(int lhs, int rhs) {
        while (rhs > 0) {
            lhs = inc(lhs);
            rhs = dec(rhs);
        } // while
        return lhs;
    } // add

    public int sub(int lhs, int rhs) {
    	if (rhs > lhs) return 0; 
    	while (rhs > 0) { 
    		lhs = dec(lhs); 
    		rhs = dec(rhs);   
    	} // while 
    	return lhs; 
    } // sub
 
    public int mul(int lhs, int rhs) {
    	int product = lhs;
    	if (lhs==0 || rhs==0) return 0;
    	while(rhs > 1) {
    		product = add(product, lhs);
    		rhs = dec(rhs);
    	} // while
    	return product;
    } // mul
 
    public int div(int lhs, int rhs) throws ArithmeticException {
    	int quotient = 0;
    	if(rhs == 0) throw new ArithmeticException();
	   	if (lhs < rhs) return 0;
    	while(lhs >= rhs) {
    		lhs = sub(lhs, rhs);
    		quotient = inc(quotient);
    	} // while
    	return quotient;
    } // div

    public int fac(int n) {
    	int factorial = 1; 
    	while(n > 0) {  
    		factorial = mul(factorial, n); 
    		n = dec(n);  
    	} // while 
    	return factorial; 
    } // fac

    public int pow(int lhs, int rhs) {
        int power = 1;
        while(rhs > 0) {
        	power = mul(power, lhs);
        	rhs = dec(rhs);
        } // while
        return power;
    } // pow

} // IterativeMath
