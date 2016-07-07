package cs1302.calc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertTrue;

/**
 * Tests for the <code>Math</code> interface. Subclasses should set
 * <code>impl</code> to a different implementation in their default
 * constructors.
 *
 * @author Michael E. Cotterell
 */
public class BasicMathTest {

    protected Math impl = new BasicMath();

    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Test
    public void testInc1() {
        try {
            assertTrue("inc(0) != 1", impl.inc(0) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testInc1

    @Test
    public void testInc2() {
      try {
          assertTrue("inc(1) != 2", impl.inc(1) == 2);
      } catch (UnsupportedOperationException e) {
          assertTrue("not implemented", false);
      } // try
    } // testInc2

    @Test
    public void testInc3() {
      try {
          assertTrue("inc(2) != 3", impl.inc(2) == 3);
      } catch (UnsupportedOperationException e) {
          assertTrue("not implemented", false);
      } // try
    } // testInc3

    @Test
    public void testDec1() {
        try {
            assertTrue("dec(0) != 0", impl.dec(0) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testDec1

    @Test
    public void testDec2() {
        try {
            assertTrue("dec(1) != 0", impl.dec(1) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testDec2

    @Test
    public void testDec3() {
        try {
            assertTrue("dec(2) != 1", impl.dec(2) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testDec3

    @Test
    public void testAdd1() {
        try {
            assertTrue("add(0, 0) != 0", impl.add(0, 0) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testAdd1

    @Test
    public void testAdd2() {
        try {
            assertTrue("add(4, 0) != 4", impl.add(4, 0) == 4);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testAdd2

    @Test
    public void testAdd3() {
        try {
            assertTrue("add(0, 4) != 4", impl.add(0, 4) == 4);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testAdd3

    @Test
    public void testAdd4() {
        try {
            assertTrue("add(4, 4) != 8", impl.add(4, 4) == 8);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testAdd4

    @Test
    public void testSub1() {
        try {
            assertTrue("sub(0, 0) != 0", impl.sub(0, 0) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testSub1

    @Test
    public void testSub2() {
        try {
            assertTrue("sub(4, 0) != 4", impl.sub(4, 0) == 4);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testSub2

    @Test
    public void testSub3() {
        try {
            assertTrue("sub(0, 4) != 0", impl.sub(0, 4) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testSub3

    @Test
    public void testSub4() {
        try {
            assertTrue("sub(4, 4) != 0", impl.sub(4, 4) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testSub4

    @Test
    public void testMul1() {
        try {
            assertTrue("mul(0, 0) != 0", impl.mul(0, 0) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testMul1

    @Test
    public void testMul2() {
        try {
            assertTrue("mul(2, 0) != 0", impl.mul(2, 0) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testMul2

    @Test
    public void testMul3() {
        try {
            assertTrue("mul(0, 2) != 0", impl.mul(0, 2) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testMul3

    @Test
    public void testMul4() {
        try {
            assertTrue("mul(2, 2) != 4", impl.mul(2, 2) == 4);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testMul4

    @Test(expected = ArithmeticException.class)
    public void testDivEx() {
        try {
            impl.div(0, 0);
        } catch (UnsupportedOperationException e) {
            throw new ArithmeticException("not implemented");
        } // try
    } // testDivEx

    @Test
    public void testDiv1() {
        try {
            assertTrue("div(4, 2) != 2", impl.div(4, 2) == 2);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testDiv1

    @Test
    public void testDiv2() {
        try {
            assertTrue("div(3, 2) != 1", impl.div(3, 2) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testDiv2

    @Test
    public void testDiv3() {
        try {
            assertTrue("div(0, 2) != 0", impl.div(0, 2) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testDiv3

    @Test
    public void testDiv4() {
        try {
            assertTrue("div(4, 5) != 0", impl.div(4, 5) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testDiv4

    @Test
    public void testFac1() {
        try {
            assertTrue("fac(0) != 0", impl.fac(0) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testFac1

    @Test
    public void testFac2() {
        try {
            assertTrue("fac(1) != 1", impl.fac(1) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testFac2

    @Test
    public void testFac3() {
        try {
            assertTrue("fac(2) != 2", impl.fac(2) == 2);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testFac3

    @Test
    public void testFac4() {
        try {
            assertTrue("fac(3) != 6", impl.fac(3) == 6);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testFac4

    @Test
    public void testPow1() {
        try {
            assertTrue("pow(2, 0) != 1",  impl.pow(2, 0) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testPow1

    @Test
    public void testPow2() {
        try {
            assertTrue("pow(2, 2) != 4",  impl.pow(2, 2) == 4);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testPow2

    @Test
    public void testPow3() {
        try {
            assertTrue("pow(2, 3) != 8",  impl.pow(2, 3) == 8);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testPow3

    @Test
    public void testPow4() {
        try {
            assertTrue("pow(2, 4) != 16", impl.pow(2, 4) == 16);
        } catch (UnsupportedOperationException e) {
            assertTrue("not implemented", false);
        } // try
    } // testPow4

    @Test
    public void testLshift1() {
        try {
            assertTrue("lshift(1, 0) != 1",  impl.lshift(1, 0) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testLshift1

    @Test
    public void testLshift2() {
        try {
            assertTrue("lshift(1, 1) != 2",  impl.lshift(1, 1) == 2);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testLshift2

    @Test
    public void testLshift3() {
        try {
            assertTrue("lshift(1, 2) != 4",  impl.lshift(1, 2) == 4);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testLshift3

    @Test
    public void testLshift4() {
        try {
            assertTrue("lshift(1, 3) != 8",  impl.lshift(1, 3) == 8);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testLshift4

    @Test
    public void testRshift1() {
        try {
            assertTrue("rshift(4, 0) != 4",  impl.rshift(4, 0) == 4);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testRshift1

    @Test
    public void testRshift2() {
        try {
            assertTrue("rshift(4, 1) != 2",  impl.rshift(4, 1) == 2);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testRshift2

    @Test
    public void testRshift3() {
        try {
            assertTrue("rshift(4, 2) != 1",  impl.rshift(4, 2) == 1);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testRshift3

    @Test
    public void testRshift4() {
        try {
            assertTrue("rshift(4, 3) != 0",  impl.rshift(4, 3) == 0);
        } catch (UnsupportedOperationException e) {
            assertTrue("dependent methods not implemented", false);
        } // try
    } // testRshift4

} // BasicMathTest
