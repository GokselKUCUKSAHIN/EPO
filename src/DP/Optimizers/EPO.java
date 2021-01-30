package DP.Optimizers;

import DP.Core.*;
import DP.Math.Random;

import java.util.ArrayList;
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
    if (hyperparams != null)
    {
      setHyperparams(hyperparams);
    }
    setAttr("f", 2);
    setAttr("l", 1.5);
    build(hyperparams);
  }

  public double getL()
  {
    return getAttr("l");
  }

  public void setL(double l)
  {
    setAttr("l", l);
  }

  public double getF()
  {
    return getAttr("f");
  }

  public void setF(double f)
  {
    setAttr("f", f);
  }

  @Override
  public void update(ArrayList<Agent> agents, Agent bestAgent, int iteration, int nIteration)
  {
    /*
    Method that wraps the Emperor Penguin Optimization over all agents and variables.
        Args:
            agents (ArrayList): List of agents.
            bestAgent (Agent): Global best agent.
            iteration (int): Current iteration.
            nIterations (int): Maximum number of iterations.
    */

    // Iterates through every agent
    for (Agent agent : agents)
    {
      // Generates a radius constant
      final double R = Random.getUnifiedRandomNumber();

      // Checks if radius is bigger or equal to 0.5
      final double T = R >= 0.5 ? 0 : 1;

      // Calculates the temperature profile (Eq. 7)
      final double T_p = T - nIteration / (double)(iteration - nIteration);

      // Calculates the polygon grid accuracy (Eq. 10)
      final double P_grid = 1; // TODO CONTINUE HERE
    }
  }

  @Override
  public void run(Space space, Func function, boolean storeBestOnly, Func preEvalution)
  {

  }
}
