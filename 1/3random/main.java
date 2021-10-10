/**
 * 03 - Dos números aleatorios y ordenarlos
 */

class Main {
  public static void main(String[] args) {
    double a, b;
    a = Math.random();
    b = Math.random();

    System.out.println("El primer numero es: " + Double.toString(a));
    System.out.println("El segundo numero es: " + Double.toString(b));

    System.out.println("El numero mayor es: " + Double.toString(a > b ? a : b ));
  }
}
