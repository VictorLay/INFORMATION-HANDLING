package by.epam.interpreter;

public class DemoStart {

  public static void main(String[] args) {
    //
    String str = "15<<11501";


    String[] operands = str.split("<<");
    System.out.println(operands[0]);
    System.out.println(operands[1]);


    Expression exp1 = new TerminalExpression(operands[0]);
    Expression exp2 = new TerminalExpression(operands[1]);

    Expression leftShift = new LeftShift(exp1, exp2);

    System.out.println(leftShift.interpret());
    System.out.println(15<<11501);
//    System.out.println(15<<11501<<12);
  }

}
