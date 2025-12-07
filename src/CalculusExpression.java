public enum CalculusExpression {
    Atomic(0),
    Addition(1),
    Subtraction(2);

    private final int type;

    CalculusExpression(int type) {
        this.type = type;
    }
}
