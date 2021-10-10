/**
 * 09 - Diagrama de pastel
 */
import java.util.Arrays;

class Main {
  public static void main(String[] args) {

    int i=0; // Iterator
    float sum = 0; // Sum of values
    float[] values = new float[args.length]; // Float values array

    // Convert String values to float values
    for(String val : args) {
      values[i] = (float) Float.parseFloat(val);
      sum += values[i++];
    }

    // Array of percentages
    float[] data = new float[values.length];

    i = 0; // Reset iterator

    // Calculate percentage
    for(float val : values) {
      data[i++] = val / sum;
    }

    new PieChart("Grafica de pastel", 500, 500, data);
  }
}
