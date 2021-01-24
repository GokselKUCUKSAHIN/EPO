package DP.Core;

import DP.Utils.JNum;

import java.util.ArrayList;

public class Space
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
    this.built = false;
    this.lb = JNum.zeros(n_Variables);
    this.ub = JNum.ones(n_Variables);
    this.bestAgent = new Agent();
    // Agent Array ?
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
      System.err.println("`n_Agents` should be > 0"); // TODO Throw Exception here!
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
      System.err.println("`n_Variables` should be > 0'"); // TODO Throw Exception here!
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
      System.err.println("`n_Dimensions` should be > 0"); // TODO Throw Exception here!
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
      System.err.println("`n_Iterations` should be > 0"); // TODO Throw Exception here!
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
        System.err.println("`agents` list is empty!"); // TODO Throw Exception here!
      }
    } else
    {
      System.err.println("`agents` List is null!"); // TODO Throw Exception here!
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
      System.err.println("`bestAgent` Object is null!"); // TODO Throw Exception here!
    }
  }
}
