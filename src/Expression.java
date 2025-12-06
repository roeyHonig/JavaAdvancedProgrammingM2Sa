public abstract class Expression {
    public abstract double calculate();

    @Override
    public boolean equals(Object exp) {
        return (exp instanceof Expression) && ((Expression) exp).calculate() == this.calculate();
    }
}
