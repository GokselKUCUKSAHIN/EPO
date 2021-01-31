package Test.DP.Utils;

import DP.Math.Random;
import DP.Utils.JNum;

public class UnitTest_JNum
{

  // TEST ARRAYS
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

  private static final double[][] rowMat = new double[][]
      {
          {1, 2, 3, 4, 5}
      };

  private static final double[][] colMat = new double[][]
      {
          {5},
          {1},
          {2},
          {3},
          {4},
      };

  private static final double[][] testModeOne = new double[][]
      {
          {1, 6, 9, 1, 7},
          {9, 6, 3, 4, 4},
          {1, 3, 2, 4, 3},
          {2, 5, 3, 7, 7},
          {3, 6, 4, 3, 4},
          {5, 9, 3, 8, 5},
          {6, 7, 9, 7, 3},
          {8, 3, 4, 7, 2},
          {5, 6, 3, 1, 1},
      };

  private static final double[][] testModeTwo = new double[][]
      {
          {3, 2, 3, 4, 5, 6, 7, 5, 9},
          {8, 5, 6, 7, 8, 9, 1, 2, 5},
          {5, 2, 3, 4, 2, 6, 7, 8, 3},
          {1, 2, 3, 4, 1, 9, 9, 8, 1},
          {3, 4, 5, 6, 7, 6, 7, 8, 9},
      };


  private static void test_array_equals()
  {
    if (!JNum.isEquals(charlie, delta)) throw new AssertionError();
    if (JNum.isEquals(echo, delta)) throw new AssertionError();
  }

  private static void test_fabs()
  {
    double[] negativeArr = JNum.fill(5, -2);
    //System.out.println(JNum.printArray(negativeArr));
    negativeArr = JNum.fabs(negativeArr);
    double[] control = JNum.fill(5, 2);
    if (!JNum.isEquals(negativeArr, control)) throw new AssertionError();
    //System.out.println(JNum.printArray(negativeArr));
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

  private static void test_array_div_mult()
  {
    double[] rand1 = Random.generateUniformRandomNumbers(20);
    double[] rand2 = Random.generateUniformRandomNumbers(20);
    double[] res = JNum.div(JNum.mult(rand1, rand2), rand2);
    //System.out.println(JNum.printArray(res));
    //System.out.println(JNum.printArray(rand1));
    if (!JNum.isEquals(rand1, res)) throw new AssertionError();
  }

  private static void test_compare()
  {
    boolean r1 = JNum.compareDouble(3, Double.POSITIVE_INFINITY);
    if (r1) throw new AssertionError();

    boolean r2 = JNum.compareDouble(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    if (r2) throw new AssertionError();

    boolean r3 = JNum.compareDouble(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    if (!r3) throw new AssertionError();

    boolean r4 = JNum.compareDouble(123, Double.NaN);
    if (r4) throw new AssertionError();

    boolean r5 = JNum.compareDouble(0, 0);
    if (!r5) throw new AssertionError();

    boolean r6 = JNum.compareDouble(Double.NaN, Double.NaN);
    if (!r6) throw new AssertionError();
  }

  // PRINT ARRAY

  private static void test_print_array()
  {
    double[] rand = Random.generateUniformRandomNumbers(10);
    // System.out.println(JNum.printArray(rand) + "\n");
  }

  private static void test_print_2d_array()
  {
    double[][] fill = JNum.fill(4, 5, Random.getUnifiedRandomNumber());
    // System.out.println(JNum.print2DArray(fill));_
  }

  private static void test_print_3d_array()
  {
    double[][][] my3d = JNum.ones(3, 4, 5);
    // System.out.println(JNum.print3DArray(my3d));
  }

  // MULT

  private static void test_array_mult_same()
  {
    double[][] multAff = JNum.mult(sumBD, bravo);
    if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_mult_modeZero()
  {
    double[][] multAff = JNum.mult(sumBD, bravo);
    if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_mult_modeOne()
  {
    double[][] multAff = JNum.mult(testModeOne, rowMat);
    //System.out.println("MODE 1");
    //System.out.println(JNum.print2DArray(multAff));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_mult_modeTwo()
  {
    double[][] multAff = JNum.mult(testModeTwo, colMat);
    //System.out.println("MULT MODE 2");
    //System.out.println(JNum.print2DArray(multAff));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_mult_modeThree()
  {
    double[][] multAff = JNum.mult(rowMat, testModeOne);
    //System.out.println("MODE 3");
    //System.out.println(JNum.print2DArray(multAff));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_mult_modeFour()
  {
    double[][] multAff = JNum.mult(colMat, testModeTwo);
    //System.out.println("MODE 4");
    //System.out.println(JNum.print2DArray(multAff));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_row_col_mult()
  {
    double[][] multAff = JNum.mult(rowMat, colMat);
    //System.out.println("ROW COL");
    //System.out.println(JNum.print2DArray(multAff));
  }

  private static void test_col_row_mult()
  {
    double[][] multAff = JNum.mult(colMat, rowMat);
    //System.out.println("COL ROW");
    //System.out.println(JNum.print2DArray(multAff));
  }

  private static void test_array_div_modeOne()
  {
    double[][] div = JNum.div(testModeOne, rowMat);
    //System.out.println("MODE 1");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_div_reverse_modeOne()
  {
    double[][] div = JNum.div(rowMat, testModeOne);
    //System.out.println("MODE 1 Reverse");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_div_modeTwo()
  {
    double[][] div = JNum.div(testModeTwo, colMat);
    //System.out.println("MODE 2");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_div_reverse_modeTwo()
  {
    double[][] div = JNum.div(colMat, testModeTwo);
    //System.out.println("MODE 2 Reverse");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_div_modeThree()
  {
    double[][] div = JNum.div(rowMat, testModeOne);
    //System.out.println("MODE 3");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_div_reverse_modeThree()
  {
    double[][] div = JNum.div(testModeOne, rowMat);
    //System.out.println("MODE 3 Reverse");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_div_modeFour()
  {
    double[][] div = JNum.div(colMat, testModeTwo);
    //System.out.println("MODE 4");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_array_div_reversed_modeFour()
  {
    double[][] div = JNum.div(testModeTwo, colMat);
    //System.out.println("MODE 4 Reverse");
    //System.out.println(JNum.print2DArray(div));
    //if (!JNum.isEquals(imul, multAff)) throw new AssertionError();
  }

  private static void test_row_col_div()
  {
    double[][] div = JNum.div(rowMat, colMat);
    //System.out.println("ROW COL");
    //System.out.println(JNum.print2DArray(div));
  }

  private static void test_col_row_div()
  {
    double[][] div = JNum.div(colMat, rowMat);
    //System.out.println("COL ROW");
    //System.out.println(JNum.print2DArray(div));
  }

  public static void doTest()
  {
    System.out.println("Starting JNum Unit Test...");
    test_print_array();
    test_print_2d_array();
    test_print_3d_array();
    test_array_equals();
    test_fabs();
    test_array_sum();
    test_array_sub();
    test_array_div();
    test_array_mult_same();
    test_array_mult_modeZero();
    test_array_mult_modeOne();
    test_array_mult_modeTwo();
    test_array_mult_modeThree();
    test_array_mult_modeFour();
    test_col_row_mult();
    test_row_col_mult();
    test_array_div_modeOne();
    test_array_div_reverse_modeOne();
    test_array_div_modeTwo();
    test_array_div_reverse_modeTwo();
    test_array_div_modeThree();
    test_array_div_reverse_modeThree();
    test_array_div_modeFour();
    test_array_div_reversed_modeFour();
    test_col_row_div();
    test_row_col_div();
    test_array_div_mult();
    test_compare();
    System.out.println("JNum Unit Test is Succesful.\n");
  }
}