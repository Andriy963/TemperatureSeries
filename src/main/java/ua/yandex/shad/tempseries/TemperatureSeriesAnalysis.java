package ua.yandex.shad.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
   public static final double MIN_TEMPERATURE = -273;
   public static final double EPSILON = 0.0000001;

   private double[] temperatures;
   private int quantityOfActualTemperatures;
   
    public TemperatureSeriesAnalysis() {
      temperatures = new double[]{};
      quantityOfActualTemperatures = 0;
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
      quantityOfActualTemperatures = temperatureSeries.length;
      temperatures = temperatureSeries;
    }
    
    public double average() {
      if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      double sumOfTemperatures = 0.0;
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         double val = temperatures[i];
         sumOfTemperatures += val;
      }
      double averageTemperature = 
      sumOfTemperatures/quantityOfActualTemperatures;
        return averageTemperature;
    }    
    
    public double deviation() {
      if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      double averageOfTemperatures = average();
      double sumOfSquares = 0;
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         double val = temperatures[i] - averageOfTemperatures;
         sumOfSquares = sumOfSquares + val*val;
      }
      double temperaturesDeviation = 
      Math.sqrt(sumOfSquares/quantityOfActualTemperatures);
      
        return temperaturesDeviation;
    }
    
    public double min() {
      if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      
      double minElement = temperatures[0];
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         double val = temperatures[i];
         if (val < minElement) {
            minElement = val;
         }
      }
        return minElement;
    }
     
    public double max() {
        if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      
      double maxElement = temperatures[0];
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         double val = temperatures[i];
         if (val > maxElement) {
            maxElement = val;
         }
      }
        return maxElement;
    }
    
    public double findTempClosestToZero() {
      if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      
      double closestToZeroElement = temperatures[0];
      double absOfClosestToZeroElement = closestToZeroElement;
      if (closestToZeroElement < 0) {
         absOfClosestToZeroElement = -closestToZeroElement;
      }
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         double val = temperatures[i];
         if (val >= 0 && val <= absOfClosestToZeroElement) {
            closestToZeroElement = val;
            absOfClosestToZeroElement = val;
         }
         else if (val < 0 && val > -absOfClosestToZeroElement) {
            closestToZeroElement = val;
            absOfClosestToZeroElement = -val;
         }
      }
        return closestToZeroElement;
    }
    
    public double findTempClosestToValue(double tempValue) {
      if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      double closestToValueElement = temperatures[0];
      double absSubOfValueAndClosestElement;
      if (closestToValueElement >= tempValue) {
         absSubOfValueAndClosestElement = 
         closestToValueElement-tempValue;
      }
      else {
         absSubOfValueAndClosestElement = 
         tempValue-closestToValueElement;
      }
      
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         double val = temperatures[i];
         if (val >= tempValue 
         && (val - tempValue) 
         < (absSubOfValueAndClosestElement - EPSILON)) {
            closestToValueElement = val;
            absSubOfValueAndClosestElement 
            = val - tempValue;
         }
         else if (val < tempValue 
         && (tempValue - val) 
         < (absSubOfValueAndClosestElement - EPSILON)) {
            closestToValueElement = val;
            absSubOfValueAndClosestElement 
            = tempValue - val;
         }
         else if (val >= tempValue 
         && (val - tempValue - absSubOfValueAndClosestElement) 
         < EPSILON) {
            closestToValueElement = val;
         }
      }
      
        return closestToValueElement;
}
    
    public double[] findTempsLessThen(double tempValue) {
      if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      int[] pointerOnGoodValues = 
      new int[quantityOfActualTemperatures];
      int quantityOfGoodValues = 0;
      
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         if (temperatures[i] < tempValue) {
            pointerOnGoodValues[i] = 1;
            quantityOfGoodValues++;
         }
      }
      double[] valuesLessThenTempValue = 
      new double[quantityOfGoodValues];
      int count = 0;
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         if (pointerOnGoodValues[i] == 1) {
            valuesLessThenTempValue[count] = temperatures[i];
            count++;
         }
      }
      
        return valuesLessThenTempValue;
    }
    
    public double[] findTempsGreaterThen(double tempValue) {
        if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      int[] pointerOnGoodValues = 
      new int[quantityOfActualTemperatures];
      int quantityOfGoodValues = 0;
      
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         if (temperatures[i] >= tempValue) {
            pointerOnGoodValues[i] = 1;
            quantityOfGoodValues++;
         }
      }
      double[] valuesGreaterThenTempValue = 
      new double[quantityOfGoodValues];
      int count = 0;
      for (int i = 0; i < quantityOfActualTemperatures; i++) {
         if (pointerOnGoodValues[i] == 1) {
            valuesGreaterThenTempValue[count] = 
            temperatures[i];
            count++;
         }
      }
      return valuesGreaterThenTempValue;
    }
    
    public TempSummaryStatistics summaryStatistics() {
        if (temperatures.length == 0) {
         throw new IllegalArgumentException();
      }
      double avgTemp = average();
      double devTemp = deviation();
      double minTemp = min();
      double maxTemp = max();
      
      TempSummaryStatistics summaryStatistic = 
      new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
      
      return summaryStatistic;
    }
    
    public int addTemps(double ... temps) {
      if (temps.length == 0) {
         throw new IllegalArgumentException();
      }
      for (double val : temps) {
         if (val < MIN_TEMPERATURE) {
            throw new InputMismatchException();
         }
      }
      int freeSize = temperatures.length-quantityOfActualTemperatures;
      if (freeSize >= temps.length) {
         int iter = quantityOfActualTemperatures + 1;
         for (double val : temps) {
            temperatures[iter] = val;
            iter++;
         }
      }
      else {
         int newLengthOfArray = temperatures.length*2;
         int sumLength = 
         quantityOfActualTemperatures + temps.length;
         while (newLengthOfArray < sumLength) {
            newLengthOfArray = newLengthOfArray*2;
         }
         double[] newTemperatureArray = 
         new double[newLengthOfArray];
         int iter = 0;
         for (double val : temperatures) {
            newTemperatureArray[iter] = val;
            iter++;
         }
         for (double val : temps) {
            newTemperatureArray[iter] = val;
            iter++;
         }
         this.temperatures = newTemperatureArray;
         quantityOfActualTemperatures = iter;
      }
        return quantityOfActualTemperatures;
    }
}
