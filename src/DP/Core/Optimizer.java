package DP.Core;

import DP.Exceptions.AttributeNotFoundException;

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
    this.setName(name);
    this.hyperparams = new HashMap<>();
  }

  public void setName(String name)
  {
    this.name = name;
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

  public double getAttr(String name) throws AttributeNotFoundException
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
    if (attributes.length > 0)
    {
      // if there is any attributes
      setHyperparams(attributes);
      // add them is Hyper Parameters
    }
    setBuilt(true);
    System.out.printf("Algorithm: %s | Hyperparameters: %s | \nBuilt: %s.\n",
        getName(), Attribute.getPairs(hyperparams), isBuilt());
  }


  @Override
  public String toString()
  {
    return this.name;
  }

  // ABSTRACT REGION
  public abstract void update();

  public void evaluate(Space space, Func func)
  {

  }
}