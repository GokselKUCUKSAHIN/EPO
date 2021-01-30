package DP.Optimizers;

import DP.Core.Func;
import DP.Core.Optimizer;
import DP.Core.Space;

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

  @Override
  public void run(Space space, Func function, boolean storeBestOnly, Func preEvalution)
  {

  }
}
