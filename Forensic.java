import java.util.*;


public class Forensic {
  
  /**
   * Compute the time in hours required for a body to cool down to temperature
   * degrees. Gaussian noise is added to simulate parameter uncertainty.
   * @param temperature The temperature of the body when found.
   * @return the time in hours required for the body to cool down to
   * temperature degrees.
   */
  public static double cooldown(double temperature) {
    // we need this object to generate Gaussian random variables
    // (remember to import java.util.Random)
    Random random = new Random();
    
    // the average body temperature of a (living) human
    double bodyTemperature = 37;
    
    // add noise to simulate that the body temperature of the victim at the
    // time of death is uncertain
    bodyTemperature += random.nextGaussian();
    
    // compute the time required for the body to cool down from
    // bodyTemperature to temperature using Newton's law of cooling.
    double cooldownTime = Math.log(bodyTemperature / temperature);
    cooldownTime *= 1 / bodyTemperature;
    
    // normalize this value such that cooling down from 37 to 32 degrees
    // takes 1 hour. we assume that we have measured this for the
    // environment that the body is found in. we add Gaussian noise to
    // simulate measurement uncertainty.
    cooldownTime *= 255 + random.nextGaussian();
    
    return cooldownTime;
  }
  
  public static void main(String args[]) {
    /*
     double[] timeList = new double[10];
     timeList = cooldownSamples(20, 10); //temp 20 degrees, 10 samples 
     
     System.out.print("[ ");
     for(int i=0; i<10; i++){
     System.out.print(timeList[i] + " ");
     }
     System.out.print("]");
     
     double[] array = {2.0088799960771184, 2.121420889236832, 1.9396865921089017,
     2.4044747294759574, 2.2430778650951178, 2.083040119880876,
     2.0595035785038114, 2.1782979876210806, 1.8812817807415378,
     2.232108837421659};
     double[] counts = countsFromArray(array, 10);
     
     System.out.println();
     String[][] array2d = array2dFromCounts(counts);
     printArray2d(array2d);
     */
    
    double[] array = cooldownSamples(27, 100000);
    double[] counts = countsFromArray(array, 20);
    String[][] array2d = array2dFromCounts(counts);
    printReport(array2d, minFromArray(array), maxFromArray(array));  
  }
  
  
  public static double[] cooldownSamples(int temperature, int numSamples) {
    double[] timeList = new double[numSamples];
    
    for(int i = 0; i < numSamples; i++){
      timeList[i] = cooldown(temperature);
    }
    return timeList;
  }
  
  public static double minFromArray(double[] array) {
    double min = array[0];
    for(int i = 0; i < array.length; i++){
      if(min > array[i]){
        min = array[i];
      } 
    }
    return min;
  }
  
  public static double maxFromArray(double[] array) {
    double max = array[0];
    for(int i = 0; i < array.length; i++){
      if(max < array[i]){
        max = array[i];
      } 
    }
    return max;
  }
  
  public static double[] countsFromArray(double[] array, int numRanges) {
    double[] counts = new double[numRanges];
    double max = maxFromArray(array);
    double min = minFromArray(array);
    double range = (max - min) / (numRanges - 1);
    
    for(int i = 0; i < array.length; i++){
      counts[(int) ((array[i] - min) / range)]++; //you're a wizard, array
    }
    return counts;
  }
  
  public static void printArray2d(String[][] array2d) {
    for(int i = 0; i < array2d.length; i++){
      for(int j = 0; j < array2d[i].length; j++){
        System.out.print(array2d[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static String[][] array2dFromCounts(double[] counts) {
    final int PRINT_WIDTH = 50;
    String[][] array2d = new String[counts.length][PRINT_WIDTH];
    
    for(int i = 0; i < counts.length; i++){
      for(int j = 0; j < PRINT_WIDTH; j++){
        array2d[i][j] = " ";
      }
    }
    
    for(int i = 0; i < counts.length; i++){
      double k = counts[i];
      
      double max = maxFromArray(counts);
      for(int j = 0; j < ((int) (k * PRINT_WIDTH / max)); j++){
        array2d[i][j] = "#";
      }
    }
    
    return array2d;
  }
  
  public static void printReport(String[][] array2d, double arrayMin, double arrayMax) {
    System.out.printf("Time since death probability distribution. \nEach line corresponds to %.2f seconds. \n==============================================\n",
                      (arrayMax-arrayMin)/(array2d.length-1));
    System.out.printf("%.2f hours", arrayMin);
    printArray2d(array2d);
    System.out.printf("%.2f hours \n==============================================\n", arrayMax);    
  }  
}
