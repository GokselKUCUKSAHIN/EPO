package Test.DP.Core;

import DP.Core.Agent;
import DP.Utils.JNum;

public class UnitTest_Agent
{

  public static void testClipping()
  {
    Agent my_Agent = new Agent(3, 2);
    my_Agent.setPositions(new double[][]{{20, 690}, {-10, 50}, {5, 100}});
    my_Agent.setUb(new double[]{20, 42, 250});
    my_Agent.setLb(new double[]{5, 12, 19});
    System.out.println(JNum.print2DArray(my_Agent.getPositions()));
    my_Agent.clip_limits();
    System.out.println(JNum.print2DArray(my_Agent.getPositions()));
  }
}
