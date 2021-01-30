package Test.DP;

import Test.DP.Core.UnitTest_Agent;
import Test.DP.Core.UnitTest_Func;
import Test.DP.Core.UnitTest_Optimizer;

public class TestMain
{

  public static void main(String[] args)
  {
    // Core
    UnitTest_Agent.doTest();
    UnitTest_Func.doTest();
    UnitTest_Optimizer.doTest();

  }
}