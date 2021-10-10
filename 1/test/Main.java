public class Main {
  public int suma(int a, int b){return a+b;}

  public int resta(int a, int b){return a-b;}

  public static void main(String[] args) {
    int a = Integer.parseInt(args[2]);
    int b = Integer.parseInt(args[1]);
    if(args[0] == "-sum") System.out.println(suma(a,b));
    if(args[0] == "-res") System.out.println(resta(a,b));
  }
}
