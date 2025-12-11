public abstract class Expression {
    public abstract double calculate();

    @Override
    public boolean equals(Object exp) {
        return (exp instanceof Expression) && ((Expression) exp).calculate() == this.calculate();
    }

    @Override
    public int hashCode() {
        // Get the outcome of the expression (double)
        double result = calculate();
        return (int) result;  // Truncates the decimal part and returns as hashCode
    }
}
