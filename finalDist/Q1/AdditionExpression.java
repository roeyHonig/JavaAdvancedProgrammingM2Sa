public class AdditionExpression extends CompoundExpression {
    public AdditionExpression(Expression op1, Expression op2) {
        super(op1, op2);
    }

    @Override
    public double calculate() {
        return Math.round((super.getOp1().calculate() + super.getOp2().calculate()) * 10.0) / 10.0 ;
    }

    @Override
    public String toString() {
        return "(" + getOp1().toString() + " " + "+" + " " + getOp2().toString() + ")";
    }
}
