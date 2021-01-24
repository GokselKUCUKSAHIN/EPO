import Core.Agent;
import Core.Attribute;
import Core.Optimizer;
import Exceptions.AttributeNotFoundException;
import Utils.JNum;

import java.util.Arrays;
import java.util.HashMap;

public class Main
{

  public static void main(String[] args) throws AttributeNotFoundException
  {
    Optimizer op = new EPO("Test Algorithm");
    System.out.println(op.getName() + " Tring to test :)");
    op.build(new Attribute("pi", 3.1415), new Attribute("number e", 2.718), new Attribute("Sin45", Math.sin(Math.PI / 4)));
    System.out.println("pi get test " + op.getAttr("pi"));
    System.out.println(op.getAttr("Sin45"));
    //System.out.println(op.getHyperparams().size());

    Agent ag =new Agent(5,3);
    for (int i = 0; i < ag.positions.length; i++)
    {
      for (int j = 0; j < ag.positions[0].length; j++)
      {
        System.out.printf("%.2f  ", ag.positions[i][j]);
      }
      System.out.println();
    }
  }
}