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
  }

  private static void test_agent_n_dimensions()
  {
    Agent myAgent = new Agent(5, 4);
    if (myAgent.getN_Dimensions() != 4) throw new AssertionError();
  }

  private static void test_agents_n_dimensions_setter()
  {
    Agent myAgent;
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

  private static void test_agent_position()
  {
    Agent myAgent = new Agent(5, 4);
    if (myAgent.getPositions().length != 5) throw new AssertionError(); // ROW
    if (myAgent.getPositions()[0].length != 4) throw new AssertionError(); // COLUMN
  }

  private static void test_agent_position_setter()
  {
    Agent myAgent = new Agent(2, 1);
    try
    {
      myAgent.setPositions(new double[][]{{50, 20}, {10, 25}});
    }
    catch (Exception ex)
    {
      myAgent.setPositions(new double[][]{{50}, {20}});
    }
    //System.out.println(JNum.print2DArray(myAgent.getPositions()));
    assert myAgent.getPositions()[0][0] == 50;
    assert myAgent.getPositions()[1][0] == 20;
  }

  public static void doTest()
  {
    System.out.println("Starting Agent Unit Test...");
    test_agent_n_variables();
    test_agent_n_variables_setter();
    test_agent_n_dimensions();
    test_agents_n_dimensions_setter();
    test_agent_position();
    test_agent_position_setter();
    System.out.println("Agent Unit Test is Succesful.\n");
  }
}