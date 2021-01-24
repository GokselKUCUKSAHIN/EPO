package DP.Optimizers;

import DP.Core.Optimizer;

public class EPO extends Optimizer
{
  public EPO(String name)
  {
    super(name);
  }

  @Override
  public void update()
  {
    System.out.println("UPDATE");
  }
}
