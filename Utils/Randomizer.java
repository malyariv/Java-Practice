public class Randomizer {
// Тщательно подобранные константы из книги «Numerical Recipes in C».
// Все поля, объявленные как «static final», являются константами.
   static final int m = 233280;
   static final int a = 9301;
   static final int c = 49297;
// Переменная состояния, сохраняемая каждым экземпляром Randomizer
   int seed = 1;
/**
* Конструктор для класса Randomizer(). Ему нужно передать
* произвольное начальное значение, «зерно» его псевдослучайности.
**/
   public Randomizer(int seed) { this.seed = seed; }
/**
* Этот метод вычисляет псевдослучайные числа в промежутке между 0 и 1
* с применением очень простого алгоритма. Методы Math.random()
* и java.util.Random вычисляют случайные числа гораздо лучше.
**/
   public float randomFloat() {
	seed = (seed * a + c) % m;
	return (float) Math.abs((float)seed/(float)m);
   }

   public int randomInt(int max) {
	return Math.round(max * randomFloat());
   }
/**
* Этот вложенный класс является простой тестовой программой: он печатает
* 10 случайных целых чисел. Обратите внимание на то, как объект Randomizer
* получает стартовое значение с применением текущего значения времени.
**/
   public static class Test {
	public static void main(String[] args) {
	   Randomizer r = new Randomizer((int)new java.util.Date().getTime());
	   for(int i = 0; i < 10; i++) System.out.println(r.randomInt(100));
	}
   }
}
