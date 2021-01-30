package Test.DP.Math;

import DP.Math.Random;
import DP.Utils.JNum;

public class UnitTest_Math
{

  private static void test_unified_random_numbers()
  {
    double[] rands = Random.generateUniformRandomNumbers(5, 5.5, 10);
    // System.out.println(JNum.printArray(rands));
  }

  public static void doTest()
  {
    test_unified_random_numbers();
  }
}
