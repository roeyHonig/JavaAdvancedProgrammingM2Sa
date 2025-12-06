public class SubtractionExpression extends CompoundExpression {
    public SubtractionExpression(Expression op1, Expression op2) {
        super(op1, op2);
    }

    @Override
    public double calculate() {
        return super.getOp1().calculate() - super.getOp2().calculate();
    }

    @Override
    public String toString() {
        return "" + getOp1().toString() + " " + "-" + " " + getOp2().toString();
    }
}