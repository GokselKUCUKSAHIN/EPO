package Test.DP;

import Test.DP.Core.UnitTest_Agent;
import Test.DP.Core.UnitTest_Func;
import Test.DP.Core.UnitTest_Optimizer;
import Test.DP.Math.UnitTest_Math;
import Test.DP.Optimizer.UnitTest_EPO;
import Test.DP.Utils.UnitTest_JNum;

public class TestMain
{

  public static void main(String[] args)
  {
    System.out.println(Math.exp(123));
    // Core
    // UnitTest_Agent.doTest();
    // UnitTest_Func.doTest();
    // UnitTest_Optimizer.doTest();

    // Math
    // UnitTest_Math.doTest();

    // Utils
    UnitTest_JNum.doTest();

    // Optimizers
    // UnitTest_EPO.doTest();
  }
}