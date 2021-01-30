package Test.DP.Core;

import DP.Core.Agent;
import DP.Exceptions.NonPositiveSizeException;
import DP.Exceptions.SizeMismatchException;
import DP.Utils.JNum;

public class UnitTest_Agent
{

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

  private static void test_agent_fit()
  {
    Agent myAgent = new Agent(5, 4);
    if (myAgent.getFit() != Double.POSITIVE_INFINITY) throw new AssertionError();
  }

  private static void test_agent_lb()
  {
    Agent myAgent = new Agent(5, 4);
    if (myAgent.getLb().length != 5) throw new AssertionError();
  }

  private static void test_agent_lb_setter()
  {
    Agent myAgent = new Agent(5, 4);
    try
    {
      myAgent.setLb(new double[]{1, 2, 3});
    }
    catch (SizeMismatchException ex)
    {
      myAgent.setLb(new double[]{1, 2, 3, 4, 5});
    }
  }

  private static void test_agent_ub()
  {
    Agent myAgent = new Agent(5, 4);
    if (myAgent.getUb().length != 5) throw new AssertionError();
  }

  private static void test_agent_ub_setter()
  {
    Agent myAgent = new Agent(5, 4);
    try
    {
      myAgent.setUb(new double[]{10, 9, 7});
    }
    catch (SizeMismatchException ex)
    {
      myAgent.setUb(new double[]{10, 9, 8, 7, 6});
    }
  }

  private static void test_agent_clip_limits()
  {
    Agent myAgent = new Agent(1,1);
    myAgent.setLb(10);
    myAgent.setUb(10);
    myAgent.clipLimits();
    if (myAgent.getPositions()[0][0] != 10) throw new AssertionError();
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
    test_agent_fit();
    test_agent_lb();
    test_agent_lb_setter();
    test_agent_ub();
    test_agent_ub_setter();
    test_agent_clip_limits();
    System.out.println("Agent Unit Test is Succesful.\n");
  }
}