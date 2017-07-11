public class Averager {
// Поля Private для хранения текущего состояния.
private int n = 0;
private double sum = 0.0, sumOfSquares = 0.0;
/**
* Этот метод учитывает новое введенное значение.
**/
public void addDatum(double x) {
n++;
sum += x;
sumOfSquares += x * x;
}
/** Этот метод возвращает среднее всех чисел, переданных addDatum() */
public double getAverage() { return sum / n; }
/** Этот метод возвращает стандартное отклонение */
public double getStandardDeviation() {
return Math.sqrt(((sumOfSquares-sum*sum/n)/n));
}
/** Этот метод возвращает количество чисел, переданных addDatum() */
public double getNum() { return n; }
/** Этот метод возвращает сумму всех чисел, переданных addDatum() */
public double getSum() { return sum; }
public double getSumOfSquares() { return sumOfSquares; }
/** Этот метод «сбрасывает» объект Averager, чтобы начать считать
«с чистого листа» */
public void reset() { n = 0; sum = 0.0; sumOfSquares = 0.0; }
/**
* Этот вложенный класс является простой тестовой программой, помогающей
* убедиться, что наши коды работают правильно.
**/
public static class Test {
public static void main(String args[]) {
Averager a = new Averager();
for(int i = 1; i <= 100; i++) a.addDatum(i);
System.out.println("Среднее: " + a.getAverage());
System.out.println("Стандартное отклонение: " +
a.getStandardDeviation());
System.out.println("N: " + a.getNum());
System.out.println("Сумма: " + a.getSum());
System.out.println("Сумма квадратов: " + a.getSumOfSquares());
}
}
}
