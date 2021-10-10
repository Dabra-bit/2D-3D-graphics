/**
 * 06 - Hex2IP
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
  public static void main(String[] args) {
    // Regex for Hex and IP values
    Pattern hex = Pattern.compile("[0-9A-Fa-f]{8}");
    Pattern ip = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$");
    Matcher matcher;

    // Result of regex operation
    boolean regexResult;

    // Data
    String type = args[0];
    String value = args[1];

    // Valor convertido
    String converted;

    if(type.equalsIgnoreCase("-hex")) { // ===============================

      // Hexadecimal a IP
      matcher = hex.matcher(value);
      regexResult = matcher.matches();

      if(!regexResult) {
        System.out.println("Error");
        return;
      }

      value = value.toLowerCase();
      Hex2IPConverter converter = new Hex2IPConverter(value);
      converted = converter.Hex2IP();

    } else if(type.equalsIgnoreCase("-ip")) { // =========================

      // IP a Hexadecimal
      matcher = ip.matcher(value);
      regexResult = matcher.matches();

      if(!regexResult) {
        System.out.println("Error");
        return;
      }

      Hex2IPConverter converter = new Hex2IPConverter(value);
      converted = converter.IP2Hex();

    } else { // ==========================================================

      // No identificado
      System.out.println("Error");
      return;

    }

    // Mostramos resultado
    System.out.println(converted);
  }
}

class Hex2IPConverter {
  private String value;

  Hex2IPConverter() {
    this.value = "";
  } // Default constructor

  Hex2IPConverter(String value) { // Overloaded constructor
    this.value = value;
  }

  public String Hex2IP( ) {
    String result = "";

    // Convierte de hexadecimal a decimal de byte en byte
    for(int i = 0; i < 8; i += 2) {
      result += String.valueOf(hex2Dec(this.value.charAt(i))*16 + hex2Dec(this.value.charAt(i+1))) + ".";
    }

    // Se quita el "." que se agrega al final
    result = result.substring(0, result.length() - 1);

    return result;
  }

  public String IP2Hex( ) {
    String result = "";
    String[] bytesStr = this.value.split("\\.");; // Bytes en String
    int[] bytes = new int[4]; // Bytes en int

    // Sacamos los valores enteros de la ip
    for(int i=0; i < 4; i++) {
      bytes[i] = Integer.parseInt(bytesStr[i]);
    }

    // Convertimos cada valor entero a su equivalente en hexadecimal
    for(int bytee:bytes) {
      result += (bytee < 16 ? "0" : "") + dec2Hex(bytee);
    }

    return result;
  }

  private int hex2Dec(char hex) {
    // Se obtiene el valor en ascii con el char y se le resta el equivalente
    // en ascii para obtener el valor decimal del hexadecimal
    // 0 dec = 48 ascii
    // a dec = 97 ascii
    return hex - (Character.isDigit(hex) ? 48 : 87);
  }

  private String dec2Hex(int dec) {
    // Si ya no se puede divir se regresa el residuo en equivalente dec a hex
    if(dec / 16 == 0) return dec2HexStr(dec % 16);

    // Se hace recursión para obtener los dos valores correspondientes a la ip
    // en hexadecimal
    return dec2Hex(dec / 16) + dec2HexStr(dec % 16);
  }

  private String dec2HexStr(int dec) {
    // Se convierte del valor numérico al valor en ascii correspondiente a la
    // letra en mayúscula
    // 0 dec = 48 ascii
    // A dec = 65 ascii
    char c = (char) (dec + (dec <= 9 ? 48 : 55));

    return Character.toString(c);
  }
}
