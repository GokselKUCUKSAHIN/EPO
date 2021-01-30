package Test.DP;

import Test.DP.Core.UnitTest_Agent;
import Test.DP.Core.UnitTest_Func;
import Test.DP.Core.UnitTest_Optimizer;
import Test.DP.Math.UnitTest_Math;

public class TestMain
{

  public static void main(String[] args)
  {
    // Core
    UnitTest_Agent.doTest();
    UnitTest_Func.doTest();
    UnitTest_Optimizer.doTest();
    UnitTest_Math.doTest();
  }
}