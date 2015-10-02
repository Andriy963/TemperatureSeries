package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
     public static final double EPSILON = 0.0000001;
     private final double avgTemp;
     private final double devTemp;
     private final double minTemp;
     private final double maxTemp;
     
     public TempSummaryStatistics() {
          this.avgTemp = 0;
          this.devTemp = 0;
          this.minTemp = 0;
          this.maxTemp = 0;
     }
     
     public TempSummaryStatistics(double avg, double dev, 
     double min, double max) {
          this.avgTemp = avg;
          this.devTemp = dev;
          this.minTemp = min;
          this.maxTemp = max;
     }
     
     @Override
     public boolean equals(Object equal) {
          if (equal == null || this == null) {
			  return false;
		  }
          TempSummaryStatistics eq = (TempSummaryStatistics) equal;
          if (Math.abs(this.avgTemp - eq.avgTemp) > EPSILON) {
               return false;
          }
          if (Math.abs(this.devTemp - eq.devTemp) > EPSILON) {
               return false;
          }
          if (Math.abs(this.minTemp - eq.minTemp) > EPSILON) {
               return false;
          }
          if (Math.abs(this.maxTemp - eq.maxTemp) > EPSILON) {
               return false;
          }
          return true;
     }
     
     public int hashCode() {
          assert false : "hashCode not designed";
          return 42;
  }
}

