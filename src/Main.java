import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Maman 12 section A");
        // create 2 calculus expressions
        Expression c1 = getRandomExpression(4);
        Expression c2 = getRandomExpression(4);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c1.calculate());
        System.out.println(c2.calculate());
        System.out.println(c1.equals(c2));
    }

    private static Expression getRandomExpression(int level) {
        double num = getRandomDouble();
        CalculusExpression typeOfExpression = getRandomTypesOfExpression();
        switch (typeOfExpression) {
            case Atomic:
                return new AtomicExpression(num);
            case Addition:
                if (level > 0) {
                    return new AdditionExpression(getRandomExpression(level - 1), getRandomExpression(level - 1));
                } else {
                    return new AtomicExpression(num);
                }
            default:
                if (level > 0) {
                    return new SubtractionExpression(getRandomExpression(level - 1), getRandomExpression(level - 1));
                } else {
                    return new AtomicExpression(num);
                }
        }
    }

    private static CalculusExpression getRandomTypesOfExpression() {
        SecureRandom randomNumbers = new SecureRandom();
        int i = randomNumbers.nextInt(3);
        if (i == 0) {
            return CalculusExpression.Atomic;
        } else if (i == 1) {
            return CalculusExpression.Addition;
        } else {
            return CalculusExpression.Subtraction;
        }
    }

    private static double getRandomDouble() {
        SecureRandom randomNumbers = new SecureRandom();
        double randomDouble = randomNumbers.nextDouble() * 100;
        return Math.round(randomDouble * 10.0) / 10.0;
    }
}
