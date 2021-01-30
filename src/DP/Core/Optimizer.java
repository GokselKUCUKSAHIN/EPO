package DP.Core;

import DP.Exceptions.AttributeNotFoundException;
import DP.Exceptions.BuildException;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Optimizer
{

  private String name;
  private final HashMap<String, Double> hyperparams; // Custom Attribute Holder
  private boolean built = false;

  public Optimizer()
  {
    // For Inheritance
    this("Not Specified");
  }

  public Optimizer(String name)
  {
    setName(name);
    hyperparams = new HashMap<>();
  }

  public void setName(String name)
  {
    if (name.equals(""))
    {
      throw new BuildException("`Algorithm name` can not be Empty String");
    } else
    {
      this.name = name;
    }
  }

  public String getName()
  {
    return this.toString();
  }

  /*
  We don't need to Return Whole Hyperparameters i guess
  public HashMap<String, Double> getHyperparams()
  {
    return this.hyperparams;
  }
  */
  public void setHyperparams(Attribute... attribute)
  {
    // for every argument
    for (Attribute attr : attribute)
    {
      if (!attr.name.equals("") && !Double.isNaN(attr.value))
      {
        // Check name empty and value is Not a Number
        // if safe to add
        this.hyperparams.put(attr.name, attr.value);
      }
    }
  }

  public int getAttrCount()
  {
    return this.hyperparams.size();
  }

  public double getAttr(String name)
  {
    // Check key into HashMap if not
    //Object hold = this.hyperparams.get(name);
    //return (hold == null ? 0.0 / 0.0 : (double) hold);
    if (hyperparams.containsKey(name))
    {
      return hyperparams.get(name);
    } else
    {
      throw new AttributeNotFoundException(String.format("'%s' attribute not exist in %s", name, this.toString()));
    }
  }

  public void setAttr(String name, double value)
  {
    if (!name.equals(""))
    {
      hyperparams.put(name, value);
    }
  }

  public void setBuilt(boolean built)
  {
    this.built = built;
  }

  public boolean isBuilt()
  {
    return built;
  }

  public void build(Attribute... attributes)
  {
    if(attributes != null)
    {
      if (attributes.length > 0)
      {
        // if there is any attributes
        setHyperparams(attributes);
        // add them is Hyper Parameters
      }
    }
    setBuilt(true);
    System.out.printf("Algorithm: %s | Hyperparameters: %s | \nBuilt: %s.\n",
        getName(), Attribute.getPairs(hyperparams), isBuilt()); // TODO Change this to LOG
  }

  @Override
  public String toString()
  {
    return this.name;
  }

  public void evaluate(Space space, Func func)
  {
    for (Agent agent : space.getAgents())
    {
      agent.setFit(func.apply(agent.getPositions()));
      if (agent.getFit() < space.getBestAgent().getFit())
      {
        space.getBestAgent().setPositions(agent.getPositions());
        space.getBestAgent().setFit(agent.getFit());
      }
    }
  }

  // ABSTRACT REGION
  public abstract void update(ArrayList<Agent> agents, Agent bestAgent, int iteration, int nIteration);

  public abstract void run(Space space, Func function, boolean storeBestOnly, Func preEvalution);
}