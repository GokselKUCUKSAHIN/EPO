package Core;

import Exceptions.AttributeNotFoundException;

import java.util.HashMap;

public class Optimizer
{

  private String name = "Not Specified";
  private HashMap<String, Double> hyperparams;
  private boolean built = false;

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

  public HashMap<String, Double> getHyperparams()
  {
    return this.hyperparams;
  }

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


  @Override
  public String toString()
  {
    return this.name;
  }
}