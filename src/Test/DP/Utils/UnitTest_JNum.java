package Test.DP.Utils;

import DP.Utils.JNum;

public class UnitTest_JNum
{

  private static final double[] alfa = new double[]{4, 3, 7, 2, 4, 6, 8, 2, 1, 7};

  private static final double[][] bravo = new double[][]
      {
          {1, 2, 3, 4},
          {5, 7, 2, 9},
          {7, 43, 5, 1}
      };

  private static final double[][] charlie = new double[][]
      {
          {12, 6, 10, 17},
          {10, 18, 17, 6},
          {11, 13, 5, 4}
      };

  private static final double[][] delta = new double[][]
      {
          {12, 6, 10, 17},
          {10, 18, 17, 6},
          {11, 13, 5, 4}
      };

  private static final double[][] echo = new double[][]
      {
          {5, 13, 13, 8},
          {9, 17, 6, 5},
          {25, 8, 23, 19},
          {11, 13, 5, 4},
      };

  private static final double[][] sumBD = new double[][]
      {
          {13, 8, 13, 21},
          {15, 25, 19, 15},
          {18, 56, 10, 5},
      };

  private static final double[][] subBD = new double[][]
      {
          {-11, -4, -7, -13},
          {-5, -11, -15, 3},
          {-4, 30, 0, -3},
      };

  private static final double[][] idiv = new double[][]
      {
          {-1.18181818181818190000, -2, -1.8571428571428572, -1.6153846153846154},
          {-3, -2.272727272727273, -1.2666666666666666, 5},
          {-4.5, 1.8666666666666667, Double.POSITIVE_INFINITY, -1.6666666666666667}
      };
  private static final double[][] imul = new double[][]
      {
          {13, 16, 39, 84},
          {75, 175, 38, 135},
          {126, 2408, 50, 5}
      };

  private static final double[][] absSubBD = new double[][]
      {
          {11, 4, 7, 13},
          {5, 11, 15, 3},
          {4, 30, 0, 3},
      };

  private static void test_array_equals()
  {
    if (!JNum.isEquals(charlie, delta)) throw new AssertionError();
    if (JNum.isEquals(echo, delta)) throw new AssertionError();
  }

  private static void test_array_sum()
  {
    double[][] sum = JNum.sum(bravo, delta);
    if (!JNum.isEquals(sum, sumBD)) throw new AssertionError();
  }

  private static void test_array_sub()
  {
    double[][] sub = JNum.sub(bravo, delta);
    if (!JNum.isEquals(sub, subBD)) throw new AssertionError();

    double[][] neutral = JNum.sum(sub, delta);
    if (!JNum.isEquals(neutral, bravo)) throw new AssertionError();
  }

  private static void test_array_div()
  {
    double[][] div = JNum.div(sumBD, subBD);
    // System.out.println(JNum.print2DArray(div));
    // System.out.println(JNum.print2DArray(idiv));
    if (!JNum.isEquals(idiv, div)) throw new AssertionError();
  }

  private static void test_fabs()
  {
    double[] negativeArr = JNum.fill(5, -2);
    //System.out.println(JNum.printArray(negativeArr));
    negativeArr = JNum.fabs(negativeArr);
    //System.out.println(JNum.printArray(negativeArr));
  }

  private static void test_array_mult()
  {
    double[][] mult = JNum.mult(sumBD, bravo);
    //System.out.println(JNum.print2DArray(mult));
    if (!JNum.isEquals(imul, mult)) throw new AssertionError();
  }

  private static void test_print_3d_array()
  {
    double[][][] my3d = JNum.ones(3, 4, 5);
    //System.out.println(JNum.print3DArray(my3d));
  }

  public static void doTest()
  {
    System.out.println("Starting JNum Unit Test...");
    test_array_equals();
    test_print_3d_array();
    test_fabs();
    test_array_sum();
    test_array_sub();
    test_array_div();
    test_array_mult();
    System.out.println("JNum Unit Test is Succesful.\n");
  }
}