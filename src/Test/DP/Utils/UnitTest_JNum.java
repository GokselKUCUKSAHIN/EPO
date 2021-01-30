package Test.DP.Utils;

import DP.Utils.JNum;

public class UnitTest_JNum
{

  public static void doTest()
  {
    System.out.println("Starting JNum Unit Test...");
    test_print_3d_array();
    System.out.println("JNum Unit Test is Succesful.\n");
  }

  private static void test_print_3d_array()
  {
    double[][][] my3d = JNum.ones(3, 4, 5);
    //System.out.println(JNum.print3DArray(my3d));
  }
}