package DP.Spaces;

import DP.Core.Agent;
import DP.Core.Space;
import DP.Math.Random;

public class SearchSpace extends Space
{


  public SearchSpace(int n_Agents, int n_Variables, int n_Iterations, double[] lowerBound, double[] upperBound)
  {
    super(n_Agents, n_Variables, 1, n_Iterations); // Dimension 1
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

  public SearchSpace(int n_Agents, int n_Variables, int n_Iterations)
  {
    this(n_Agents, n_Variables, n_Iterations, new double[]{0}, new double[]{1});
  }
  
  public SearchSpace()
  {
    this(1, 1, 10);
  }

  @Override
  public void initializeAgents()
  {
    // Init Best Agent
    this.getBestAgent().setLb(getLb());
    this.getBestAgent().setUb(getUb());
    this.getBestAgent().setFit(Double.POSITIVE_INFINITY);

    // Init other Agents
    for (Agent agent : getAgents())
    {
      agent.setLb(getLb());
      agent.setUb(getUb());
      agent.setFit(Double.POSITIVE_INFINITY);
      for (int i = 0; i < getN_Variables(); i++)
      {
        double lb = agent.getLb()[i];
        double ub = agent.getUb()[i];
        agent.getPositions()[i] = Random.generateUniformRandomNumbers(lb, ub, agent.getN_Dimensions());
      }
    }
  }
}