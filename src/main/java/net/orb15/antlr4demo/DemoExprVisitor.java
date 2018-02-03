package net.orb15.antlr4demo;

public class DemoExprVisitor extends ExprBaseVisitor<Double>{

  @Override
  public Double visitProg(ExprParser.ProgContext ctx) {
    enter("prog");
    return this.visit(ctx.expr());
  }

  @Override
  public Double visitIntExpr(ExprParser.IntExprContext ctx) {
    enter("IntExpr");
    return Double.valueOf(ctx.getText());
  }

  @Override
  public Double visitOpExpr(ExprParser.OpExprContext ctx) {
    double left = visit(ctx.left);
    double right = visit(ctx.right);
    String op = ctx.op.getText();
    switch (op.charAt(0)) {
      case '*':
        return left * right;
      case '/':
        return left / right;
      case '+':
        return left + right;
      case '-':
        return left - right;
      default:
        throw new IllegalArgumentException("Unknown operator " + op);
    }
  }

  @Override
  public Double visitParenExpr(ExprParser.ParenExprContext ctx) {
    enter("ParenExpr");
    return this.visit(ctx.expr());
  }

  private void enter(String s)  {
    System.out.println("Entering: " + s);
  }
}

