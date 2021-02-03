package Test.DP;

import DP.Math.Random;
import DP.Optimizers.EPO_MAT;
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
        double[][] test = Random.generateUniformRandomNumbers(5,10);
        EPO_MAT.emperorPenguinOptimizer(test, "Test",9, 0,0,0,0,0);
        // Core
        //UnitTest_Agent.doTest();
        //UnitTest_Func.doTest();

        // Math
        //UnitTest_Math.doTest();

        // Utils
        //UnitTest_JNum.doTest();

        // Optimizers
        //UnitTest_EPO.doTest();
    }
}