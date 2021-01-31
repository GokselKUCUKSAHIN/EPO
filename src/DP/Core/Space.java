package DP.Core;

import DP.Exceptions.EmptyArrayException;
import DP.Exceptions.NonPositiveSizeException;
import DP.Exceptions.SizeMismatchException;
import DP.Utils.JNum;

import java.util.ArrayList;

public abstract class Space
{

  private int n_Agents;
  private int n_Variables;
  private int n_Dimensions;
  private int n_Iterations;
  //
  private double[] lb;
  private double[] ub;
  //
  private boolean built;
  //
  private Agent bestAgent;
  //
  private ArrayList<? extends Agent> agents; // Agent of Child of Agent

  public Space()
  {
    this(1, 1, 1, 10);
  }

  public Space(int n_Agents, int n_Variables, int n_Dimensions, int n_Iterations)
  {
    this.setN_Agents(n_Agents);
    this.setN_Variables(n_Variables);
    this.setN_Dimensions(n_Dimensions);
    this.setN_Iterations(n_Iterations);
    //
    setBuilt(false);
    setBestAgent(new Agent());
  }

  public int getN_Agents()
  {
    return n_Agents;
  }

  public void setN_Agents(int n_Agents)
  {
    if (n_Agents > 0)
    {
      this.n_Agents = n_Agents;
    } else
    {
      throw new NonPositiveSizeException("`n_Agents` should be > 0");
    }
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
    } else
    {
      throw new NonPositiveSizeException("`n_Variables` should be > 0");
    }
  }

  public int getN_Dimensions()
  {
    return n_Dimensions;
  }

  public void setN_Dimensions(int n_Dimensions)
  {
    if (n_Dimensions > 0)
    {
      this.n_Dimensions = n_Dimensions;
    } else
    {
      throw new NonPositiveSizeException("`n_Dimensions` should be > 0");
    }
  }

  public int getN_Iterations()
  {
    return n_Iterations;
  }

  public void setN_Iterations(int n_Iterations)
  {
    if (n_Iterations > 0)
    {
      this.n_Iterations = n_Iterations;
    } else
    {
      throw new NonPositiveSizeException("`n_Iterations` should be > 0");
    }
  }

  public ArrayList<? extends Agent> getAgents()
  {
    return this.agents;
  }

  public void setAgents(ArrayList<? extends Agent> agents)
  {
    if (agents != null)
    {
      if (agents.size() > 0)
      {
        this.agents = agents;
      } else
      {
        throw new EmptyArrayException("`agents` List is empty!");
      }
    } else
    {
      throw new NullPointerException("`agents` List is null!");
    }
  }

  public Agent getBestAgent()
  {
    return bestAgent;
  }

  public void setBestAgent(Agent bestAgent)
  {
    if (bestAgent != null)
    {
      this.bestAgent = bestAgent;
    } else
    {
      throw new NullPointerException("`bestAgent` Object is null!");
    }
  }

  public double[] getLb()
  {
    return lb;
  }

  public void setLb(double... lb)
  {
    if (lb.length == getN_Variables())
    {
      this.lb = lb;
    } else
    {
      throw new SizeMismatchException("`lb` should be the same size as `n_variables`");
    }
  }

  public double[] getUb()
  {
    return ub;
  }

  public void setUb(double... ub)
  {
    if (ub.length == getN_Variables())
    {
      this.ub = ub;
    } else
    {
      throw new SizeMismatchException("`ub` should be the same size as `n_variables`");
    }
  }

  public boolean isBuilt()
  {
    return built;
  }

  public void setBuilt(boolean built)
  {
    this.built = built;
  }

  public void Build(double[] lb, double[] ub)
  {
    setLb(lb);
    setUb(ub);
    createAgents();
    setBuilt(true);
    /*
    System.out.printf("Agents: %d | Size: (%d, %d) | Iterations: %d |\n Lower Bound: %s | Upper Bound: %s | Built: %s.\n",
        getN_Agents(), getN_Variables(), getN_Dimensions(),
        getN_Iterations(), JNum.printArray(getLb()), JNum.printArray(getUb()),
        isBuilt()); // TODO Change it with LOG
     */
  }

  public void createAgents()
  {
    ArrayList<Agent> agentList = new ArrayList<>();
    for (int i = 0; i < getN_Agents(); i++)
    {
      agentList.add(new Agent(getN_Variables(), getN_Dimensions()));
    }
    setAgents(agentList);
  }

  public abstract void initializeAgents();

  public void clipLimits()
  {
    for (Agent agent : getAgents())
    {
      agent.clipLimits();
    }
  }
}