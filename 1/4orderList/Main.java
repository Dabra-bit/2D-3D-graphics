/**
 * 04 - Ordenar lista de números
 */
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int n = args.length;
    double[] nums = new double[n];

    // Conversión de string a double
    for(int i=0; i < n; i++) {
      nums[i] = Double.valueOf(args[i]);
    }

    // Sorteo de números
    Arrays.parallelSort(nums);

    // Mostrar datos en consola
    System.out.println("Los numeros ordenados son:");
    for(int i = 0; i < n; i++) {
      System.out.println(String.valueOf(nums[i]));
    }
  }
}
