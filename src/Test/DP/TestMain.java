package Test.DP;

import Test.DP.Core.UnitTest_Agent;

public class TestMain
{

  public static void main(String[] args)
  {
    UnitTest_Agent.testClipping();
  }
}


  //Object num = new Agent();
  //System.out.println(num.getClass());

    /*
    Object something = new Integer(123);
    String theType = "java.lang.Number";

    Class<? extends Number> theClass = Class.forName(theType).asSubclass(Number.class);
    Number obj = theClass.cast(something);*/

    /*
    Space test = new BooleanSpace(1,2,3,4);
    Optimizer op = new EPO("Test Algorithm");
    System.out.println(op.getName() + " Tring to test :)");
    op.build(new Attribute("pi", 3.1415), new Attribute("number e", 2.718), new Attribute("Sin45", Math.sin(Math.PI / 4)));
    System.out.println("pi get test " + op.getAttr("pi"));
    System.out.println(op.getAttr("Sin45"));
    //
    Agent ag = new Agent(5, 3);
    for (int i = 0; i < ag.getPositions().length; i++)
    {
      for (int j = 0; j < ag.getPositions()[0].length; j++)
      {
        System.out.printf("%.2f  ", ag.getPositions()[i][j]);
      }
      System.out.println();
    }*/
