package Test.DP.Optimizer;

import DP.Core.Agent;
import DP.Core.Attribute;
import DP.Core.Func;
import DP.Math.Random;
import DP.Optimizers.EPO;
import DP.Spaces.SearchSpace;
import DP.Utils.JNum;
import Test.DP.Core.UnitTest_Func;

import java.util.function.Function;

public class UnitTest_EPO
{

  private static void test_create_instance()
  {
    EPO epo = new EPO();
    if (!epo.getName().equals("Not Specified")) throw new AssertionError();

    EPO epo1 = new EPO("Custom Name");
    if (!epo1.getName().equals("Custom Name")) throw new AssertionError();

    EPO epo2 = new EPO("I like Penguins", new Attribute("size", 123), new Attribute("h", 1030522874));
    if (!epo2.getName().equals("I like Penguins")) throw new AssertionError();
    if (epo2.getAttr("size") != 123) throw new AssertionError();
    if (epo2.getAttr("h") != 1030522874) throw new AssertionError();
  }

  private static void test_hyperparameters()
  {
    EPO myEPO = new EPO("Penguins are Cute");

    if (!myEPO.getName().equals("Penguins are Cute")) throw new AssertionError();
    if (myEPO.getAttrCount() != 2) throw new AssertionError();
  }

  private static void test_get_set_hyperparameters()
  {
    EPO myEPO = new EPO("HyperBeast");
    myEPO.setHyperparams(new Attribute("diameter", 2.15));
    if (myEPO.getAttrCount() != 3) throw new AssertionError();

    if (myEPO.getAttr("diameter") != 2.15) throw new AssertionError();

    myEPO.setAttr("area", 3.1415);
    if (myEPO.getAttrCount() != 4) throw new AssertionError();

    myEPO.setAttr("diameter", 5.56);
    if (myEPO.getAttr("diameter") != 5.56) throw new AssertionError();
    if (myEPO.getAttrCount() != 4) throw new AssertionError();

    myEPO.setAttr("", -1);
    if (myEPO.getAttrCount() != 4) throw new AssertionError();
  }

  public static double square(double[][] args)
  {
    double sum = 0;
    for (double[] row : args)
    {
      for (double num : row)
      {
        sum += Math.sqrt(num + 24);
      }
    }
    return sum;
  }


  public static double cubeplus5(double[][] args)
  {
    double sum = 0;
    for (double[] row : args)
    {
      for (double num : row)
      {
        sum += num * num * num + 5;
      }
    }
    return sum;
  }

  public static double benchmark(double[][] arg)
  {
    double sum = 0.0;
    for (int i = 0; i < arg.length; i++)
    {
      for (int j = 0; j < arg[0].length - 1; j++)
      {
        sum += 100 * Math.pow((arg[i][j + 1] - Math.pow(arg[i][j], 2)), 2) + Math.pow(arg[i][j] - 1, 2);
      }
    }
    return sum;
  }

  private static void test_epo_run()
  {
    Function<double[][], Double> square = UnitTest_EPO::benchmark;
    Func func = new Func(square);
    EPO myEPO = new EPO();
    SearchSpace mySpace = new SearchSpace(10, 2, 50,
        JNum.zeros(2), JNum.fill(2, 10));
    myEPO.run(mySpace, func, false);
    for (Agent agent : mySpace.getAgents())
    {
      System.out.println(agent.getFit());
      System.out.println(JNum.print2DArray(agent.getPositions()));
    }
    System.out.println("--BEST AGENT--");
    System.out.println(mySpace.getBestAgent().getFit() + "\n" + JNum.print2DArray(mySpace.getBestAgent().getPositions()));

    System.out.println(benchmark(mySpace.getBestAgent().getPositions()));

  }


  public static void doTest()
  {
    System.out.println("Starting EPO Unit Test...");
    test_create_instance();
    test_hyperparameters();
    test_get_set_hyperparameters();
    test_epo_run();
    System.out.println("EPO Unit Test is Succesful.\n");
  }
}
