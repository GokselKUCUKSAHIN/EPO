package DP.Core;

import DP.Utils.JNum;

import java.util.Arrays;

public class Agent
{

  private int n_Variables;
  private int n_Dimensions;
  private double[][] positions;
  private double fit;
  private double[] lb;
  private double[] ub;

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
    positions = JNum.zeros(n_Variables, n_Dimensions);
    fit = Double.POSITIVE_INFINITY;
    lb = JNum.zeros(n_Variables);
    ub = JNum.ones(n_Variables);
  }

  public int getN_Variables()
  {
    return n_Variables;
  }

  public void setN_Variables(int n_Variables)
  {
    if (n_Variables > 0)
    {
      this.n_Variables = n_Variables;
    }
    else
    {
      System.err.println("`n_Variables` should be > 0");
    }
  }

  public int getN_Dimensions()
  {
    return n_Dimensions;
  }

  public void setN_Dimensions(int n_Dimensions)
  {
    if(n_Dimensions > 0)
    {
      this.n_Dimensions = n_Dimensions;
    }
    else
    {
      System.err.println("`n_Dimensions` should be > 0");
    }
  }

  public double[][] getPositions()
  {
    return positions;
  }

  public void setPositions(double[][] positions)
  {
    this.positions = positions;
  }

  public double getFit()
  {
    return fit;
  }

  public void setFit(double fit)
  {
    this.fit = fit;
  }

  public double[] getLb()
  {
    return lb;
  }

  public void setLb(double...lb)
  {
    this.lb = lb;
  }

  public double[] getUb()
  {
    return ub;
  }

  public void setUb(double...ub)
  {
    this.ub = ub;
  }

  public void clip_limits()
  {
    for (int i = 0; i < positions.length; i++)
    {
      double[] row = positions[i];
      for (int j = 0; j < row.length; j++)
      {
        row[j] = (row[j] < lb[i] ? lb[i] : row[j]);
        row[j] = (row[j] > ub[i] ? ub[i] : row[j]);
      }
    }
  }
}
