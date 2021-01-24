package Core;

import Utils.JNum;

import java.util.Arrays;

public class Agent
{

  private int n_Variables;
  private int n_Dimensions;
  public double[][] positions;

  public Agent()
  {
    this(1, 1);
  }
  public Agent(int nv, int nd)
  {
    // n_Variables (int): Number of decision variables.
    // n_Dimensions (int): Number of dimensions.
    n_Variables = nv;
    n_Dimensions = nd;
    //positions = new double[n_Variables][n_Dimensions];
    positions = JNum.zeros(n_Variables,n_Dimensions);
  }
}
