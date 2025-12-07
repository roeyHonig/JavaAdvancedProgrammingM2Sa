public class AtomicExpression extends Expression {
    private double num;

    public AtomicExpression(double num) {
        this.num = num;
    }

    @Override
    public double calculate() {
        return Math.round(num * 10.0) / 10.0;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
