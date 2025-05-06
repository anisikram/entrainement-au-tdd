package io.github.gabbloquet.tddtraining.Thermometer;

public record Thermometer(int[] temperatures) {
  public Thermometer {
    checkThreshold(temperatures);
  }

  public int getClosestTemperatureToZero() {
    if (temperatures.length == 0) {
      return 0;
    }
    int temperateClosestToZero = temperatures[0];
    for (int temperature : temperatures) {
      int distance = Math.abs(temperature);
      if(Math.abs(temperateClosestToZero) > distance && temperateClosestToZero != distance) {
        temperateClosestToZero = temperature;
      }
    }
    return temperateClosestToZero;
  }


  private static void checkThreshold(int[] temperatures) {
    if (temperatures == null || temperatures.length > 10000){
      throw new IllegalArgumentException("Thermometer cannot have more than 10000 temperatures");
    }
  }
}
