package Test.DP.Math;

import DP.Math.Random;
import DP.Utils.JNum;

public class UnitTest_Math
{

  private static void test_unified_random_numbers()
  {
    double[] rands = Random.generateUniformRandomNumbers(-5.123, -5.122, 10);
    System.out.println(JNum.printArray(rands));

    double[][] myOnes = JNum.fill(3,5,420.69123123);
    System.out.printf(JNum.print2DArray(myOnes));
  }

  public static void doTest()
  {
    test_unified_random_numbers();
  }
}
