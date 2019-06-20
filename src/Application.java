import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Application {

  public static void main(String[] args) {
    IntStream stream = pseudoRandomStream(14);
    stream.limit(20).forEach(System.out::print);
    System.out.println();
    System.out.println(integrate(x -> 1, 0, 10));
    System.out.println();
  }

  public static IntStream pseudoRandomStream(int seed) {
    return IntStream.iterate(seed, x -> (x * x) % 10000 / 10);
  }

  public static double integrate(DoubleUnaryOperator f, double a, double b) {
    double result = 0;
    double h = 10E-6;
    double n = ((b - a) / h);
    for (int i = 0; i < n; i++) {
      result += f.applyAsDouble(a + h * i);
    }
    result *= h;
    return result;
  }
  public static <T, U> Function<T, U> ternaryOperator(
          Predicate<? super T> condition,
          Function<? super T, ? extends U> ifTrue,
          Function<? super T, ? extends U> ifFalse) {
    return t -> (condition.test(t)) ? ifTrue.apply(t) : ifFalse.apply(t);
  }
}
