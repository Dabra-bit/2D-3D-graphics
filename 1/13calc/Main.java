public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("Calculadora", 600, 600);
        calculator.setVisible(true);
        Thread tCalc = new Thread(calculator);
    }    
}
