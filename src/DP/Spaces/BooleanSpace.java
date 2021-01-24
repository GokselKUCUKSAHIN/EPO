package DP.Spaces;

import DP.Core.Agent;
import DP.Core.Space;
import DP.Utils.JNum;

public class BooleanSpace extends Space
{

  public BooleanSpace(int n_Agents, int n_Variables, int n_Dimensions, int n_Iterations)
  {
    super(n_Agents, n_Variables, n_Dimensions, n_Iterations);
    // Build with initial Lower and Upper Boundaries
    this.Build(JNum.zeros(getN_Variables()), JNum.ones(getN_Variables()));
  }

  @Override
  public void initializeAgents()
  {
    for(Agent agent : getAgents())
    {

    }
  }
}
