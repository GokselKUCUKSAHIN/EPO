package DP.Spaces;

import DP.Core.Agent;
import DP.Core.Space;
import DP.Math.Random;

public class SearchSpace extends Space
{

  public SearchSpace(int n_Agents, int n_Variables, int n_Dimensions, int n_Iterations, double[] lowerBound, double[] upperBound)
  {
    super(n_Agents, n_Variables, n_Dimensions, n_Iterations);
    double[] tLB = lowerBound;
    double[] tUB = upperBound;
    if (lowerBound.length < 1)
    {
      tLB = new double[]{0};
    }
    if (upperBound.length < 1)
    {
      tUB = new double[]{1};
    }
    this.Build(tLB, tUB);
    this.initializeAgents();
  }

  @Override
  public void initializeAgents()
  {
    for (Agent agent : getAgents())
    {
      agent.setLb(getLb());
      agent.setUb(getUb());
      for (int i = 0; i < getN_Variables(); i++)
      {
        double lb = agent.getLb()[i];
        double ub = agent.getUb()[i];
        agent.getPositions()[i] = Random.generateUniformRandomNumbers(lb, ub, agent.getN_Dimensions());
      }
    }
  }
}