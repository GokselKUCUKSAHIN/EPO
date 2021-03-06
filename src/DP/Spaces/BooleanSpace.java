package DP.Spaces;

import DP.Core.Agent;
import DP.Core.Space;
import DP.Math.Random;
import DP.Utils.JNum;

public class BooleanSpace extends Space
{

  public BooleanSpace(int n_Agents, int n_Variables, int n_Dimensions, int n_Iterations)
  {
    super(n_Agents, n_Variables, n_Dimensions, n_Iterations);
    // Build with initial Lower and Upper Boundaries
    this.Build(JNum.zeros(getN_Variables()), JNum.ones(getN_Variables()));
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
        agent.getPositions()[i] = Random.generateBinaryRandomNumber(agent.getN_Dimensions());
      }
    }
  }
}
