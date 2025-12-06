public class AtomicExpression extends Expression {
    private double num;

    public AtomicExpression(double num) {
        this.num = num;
    }

    @Override
    public double calculate() {
        return num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
