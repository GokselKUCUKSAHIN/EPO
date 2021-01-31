package Test.DP.Optimizer;

import DP.Core.Attribute;
import DP.Optimizers.EPO;

public class UnitTest_EPO
{

  private static void test_create_instance()
  {
    EPO epo = new EPO();
    if (!epo.getName().equals("Not Specified")) throw new AssertionError();

    EPO epo1 = new EPO("Custom Name");
    if (!epo1.getName().equals("Custom Name")) throw new AssertionError();

    EPO epo2 = new EPO("I like Penguins", new Attribute("size", 123), new Attribute("h", 1030522874));
    if (!epo2.getName().equals("I like Penguins")) throw new AssertionError();
    if (epo2.getAttr("size") != 123) throw new AssertionError();
    if (epo2.getAttr("h") != 1030522874) throw new AssertionError();
  }

  private static void test_hyperparameters()
  {
    EPO myEPO = new EPO("Penguins are Cute");

    if (!myEPO.getName().equals("Penguins are Cute")) throw new AssertionError();
    if (myEPO.getAttrCount() != 2) throw new AssertionError();
  }

  private static void test_get_set_hyperparameters()
  {
    EPO myEPO = new EPO("HyperBeast");
    myEPO.setHyperparams(new Attribute("diameter", 2.15));
    if (myEPO.getAttrCount() != 3) throw new AssertionError();

    if (myEPO.getAttr("diameter") != 2.15) throw new AssertionError();

    myEPO.setAttr("area", 3.1415);
    if (myEPO.getAttrCount() != 4) throw new AssertionError();

    myEPO.setAttr("diameter", 5.56);
    if (myEPO.getAttr("diameter") != 5.56) throw new AssertionError();
    if (myEPO.getAttrCount() != 4) throw new AssertionError();

    myEPO.setAttr("", -1);
    if (myEPO.getAttrCount() != 4) throw new AssertionError();
  }

  public static void doTest()
  {
    System.out.println("Starting EPO Unit Test...");
    test_create_instance();
    test_hyperparameters();
    test_get_set_hyperparameters();
    System.out.println("EPO Unit Test is Succesful.\n");
  }
}
