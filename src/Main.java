public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Maman 12 section A");
        // create 2 calculus expressions
        AdditionExpression c1 = new AdditionExpression(new SubtractionExpression(new AtomicExpression(5), new AtomicExpression(4)), new AtomicExpression(7)); // 5-4+7
        AdditionExpression c2 = new AdditionExpression(new AtomicExpression(4), new AtomicExpression(4)); // 4 + 4
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c1.calculate());
        System.out.println(c2.calculate());
        System.out.println(c1.equals(c2));
    }
}
