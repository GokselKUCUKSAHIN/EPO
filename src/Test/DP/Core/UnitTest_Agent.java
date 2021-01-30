package Test.DP.Core;

import DP.Core.Agent;
import DP.Exceptions.NonPositiveSizeException;
import DP.Utils.JNum;

public class UnitTest_Agent
{

  private static void testClipping()
  {
    Agent my_Agent = new Agent(3, 2);
    my_Agent.setPositions(new double[][]{{20, 690}, {-10, 50}, {5, 500}});
    my_Agent.setUb(20, 42, 250);
    my_Agent.setLb(5, 12, 19); // check this later.
    System.out.println(JNum.print2DArray(my_Agent.getPositions()));
    my_Agent.clipLimits();
    System.out.println(JNum.print2DArray(my_Agent.getPositions()));
  }

  //  private static void

  private static void test_agent_n_variables()
  {
    Agent myAgent = new Agent(5, 4);
    if (myAgent.getN_Variables() != 5) throw new AssertionError();
  }

  private static void test_agent_n_variables_setter()
  {
    Agent myAgent;
    try
    {
      myAgent = new Agent(0, 4);
    }
    catch (NonPositiveSizeException ex)
    {
      myAgent = new Agent(5, 4);
    }
    if (myAgent.getN_Variables() != 5) throw new AssertionError();
    try
    {
      myAgent = new Agent(5, 0);
    }
    catch (NonPositiveSizeException ex)
    {
      myAgent = new Agent(5, 4);
    }
    if (myAgent.getN_Dimensions() != 4) throw new AssertionError();

  }

  public static void doTest()
  {
    System.out.println("Starting Agent Unit Test...");
    test_agent_n_variables();
    test_agent_n_variables_setter();
    System.out.println("Agent Unit Test is Succesful.\n");
  }
}