package Test.DP;

import DP.Utils.JNum;
import Test.DP.Core.UnitTest_Agent;
import Test.DP.Core.UnitTest_Func;
import Test.DP.Math.UnitTest_Math;
import Test.DP.Optimizer.UnitTest_EPO;
import Test.DP.Utils.UnitTest_JNum;

public class TestMain
{

    public static void main(String[] args)
    {
        // Core
        //UnitTest_Agent.doTest();
        //UnitTest_Func.doTest();

        // Math
        //UnitTest_Math.doTest();

        // Utils
        UnitTest_JNum.doTest();

        // Optimizers
        //UnitTest_EPO.doTest();
    }
}