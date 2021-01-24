import Core.Attribute;
import Core.Optimizer;
import Exceptions.AttributeNotFoundException;

import java.util.HashMap;

public class Main
{

  public static void main(String[] args) throws AttributeNotFoundException
  {
    Optimizer op = new Optimizer("Test Algorithm");
    System.out.println(op.getName() + " Tring to test :)");
    op.setHyperparams(new Attribute("pi", 3.1415), new Attribute("number e", 2.718), new Attribute("Sin45", Math.sin(Math.PI / 4)));
    System.out.println("pi get test " + op.getAttr("pi"));
    System.out.println(op.getAttr("Sin45"));

    //System.out.println(op.getHyperparams().size());
  }
}