package DP.Spaces;

import DP.Core.Agent;
import DP.Core.Space;
import DP.Exceptions.NonPositiveSizeException;

public class GridSpace extends Space
{

  private double step;

  public GridSpace()
  {
    this(1, 0.1);
  }

  public GridSpace(int n_Variables, double step)
  {
    this(n_Variables, step, new double[]{0}, new double[]{1});
  }

  public GridSpace(int n_Variables, double step, double[] lowerBound, double[] upperBound)
  {

  }

  public int setUpGrid(double step, double[] lowerBound, double[] upperBound)
  {
    setStep(step);
    createGrid(getStep(), lowerBound, upperBound);
    return 0; // TODO FIX LATER
  }

  public double getStep()
  {
    return this.step;
  }

  public void setStep(double step)
  {
    if (step > 0)
    {
      this.step = step;
    } else
    {
      throw new NonPositiveSizeException("`step` should be greater than 0");
    }
  }

  private void createGrid(double step, double[] lowerBound, double[] upperBound)
  {
      // TODO IMPLEMENT HERE
  }

  @Override
  public void initializeAgents()
  {
    // TODO IMPLEMENT HERE
  }
}
