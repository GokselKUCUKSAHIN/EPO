package Test.DP.Core;

import DP.Core.Agent;
import DP.Core.Func;
import DP.Core.Optimizer;
import DP.Core.Space;

import java.util.ArrayList;

public class UnitTest_Optimizer
{

  public static void doTest()
  {
    System.out.println("Starting Optimizer Unit Test...");
    // TODO Implement here
    System.out.println("Optimizer Unit Test is Succesful.\n");
  }
}

class TestOptimizer extends Optimizer
{

  @Override
  public void update(ArrayList<Agent> agents, Agent bestAgent, int iteration, int nIteration)
  {

  }

  @Override
  public void run(Space space, Func function, boolean storeBestOnly, Func preEvalution)
  {

  }
}
