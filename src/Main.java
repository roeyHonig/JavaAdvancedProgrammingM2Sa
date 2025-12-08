import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int size = 100;
        ArrayList<Expression> listOfExpression = new ArrayList<Expression>();
        for (int i = 0; i < size; i++) {
            Expression exp = getRandomExpression(2);
            listOfExpression.add(exp);
        }
        // Create the map to store expressions by their calculated result (Expression as key)
        Map<Expression, List<Expression>> resultMap = new HashMap<>();
        // Fill the map with expressions grouped by their calculation result
        for (Expression exp : listOfExpression) {
            resultMap.computeIfAbsent(exp, k -> new ArrayList<>()).add(exp);
        }
        System.out.println("" + size + " Expression:");
        for (Expression e:listOfExpression
             ) {
            System.out.println("expression: " + e.toString());
            System.out.println("evaluates to: " + e.calculate());
            System.out.println("This expression calculation result matches the result of another expression: " + isResultMatchesOtherExpressionResult(e, resultMap));
            System.out.println();
        }
    }

    private static boolean isResultMatchesOtherExpressionResult(Expression exp, Map<Expression, List<Expression>> resultMap) {
        boolean isResultMatchesOtherExpressionResult = false;
        List<Expression> expressionsWithSameResult = resultMap.get(exp);
        int matchCount = 0;
        // Check for matches (check equals because expressions with different calculate result might still be mapped to the same key)
        for (Expression otherExp : expressionsWithSameResult) {
            if (!otherExp.equals(exp)) {
                continue; // Skip if not equal
            }
            matchCount++; // If the expression equals, increase the match count
        }
        // If more than one match is found, print the result
        if (matchCount > 1) {
            isResultMatchesOtherExpressionResult = true;
        }
        return isResultMatchesOtherExpressionResult;
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
        double randomDouble = randomNumbers.nextDouble() * 10;
        return Math.round(randomDouble * 10.0) / 10.0;
    }
}
