
/**
 * 05 - Generación de subcadenas
 */

class Main {
  public static void main(String[] args) {

    String string = ""; // String que vamos a usar
    int n = args.length; // Número de palabras a usar

    // Juntamos la palabra
    for(int i = 0; i < n; i++) {
      string += args[i] + " ";
    }

    string = string.trim(); // Retiramos espacio extra
    n = string.length(); // Guardamos la longitud de la cadena

    // Primera vuelta
    for(int i = 0, j = n; i < j ; j--) {
      System.out.println(string.substring(i, j));
    }

    // Segunda vuelta
    for(int i = n-1, j = n; i >= 0; i--) {
      System.out.println(string.substring(i, j));
    }
  }
}
