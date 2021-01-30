package DP.Optimizers;

import DP.Core.Attribute;
import DP.Core.Func;
import DP.Core.Optimizer;
import DP.Core.Space;

import java.util.HashMap;

public class EPO extends Optimizer
{

  public EPO()
  {
    this("Not Specified");
  }

  public EPO(String name)
  {
    this(name, null);
  }

  public EPO(String name, Attribute... hyperparams)
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
