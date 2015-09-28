package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
	private final double devTemp;
	private final double minTemp;
	private final double maxTemp;
	
	public double epsilon = 0.000001;
	
	public TempSummaryStatistics(){
		this.avgTemp = 0;
		this.devTemp = 0;
		this.minTemp = 0;
		this.maxTemp = 0;
	}
	
	public TempSummaryStatistics(double avg, double dev, double min, double max){
		this.avgTemp = avg;
		this.devTemp = dev;
		this.minTemp = min;
		this.maxTemp = max;
	}
	
	@Override
	public boolean equals(Object equal){
		
		TempSummaryStatistics eq = (TempSummaryStatistics)equal;
		if(Math.abs(this.avgTemp - eq.avgTemp) > epsilon){
			return false;
		}
		if(Math.abs(this.devTemp - eq.devTemp) > epsilon){
			return false;
		}
		if(Math.abs(this.minTemp - eq.minTemp) > epsilon){
			return false;
		}
		if(Math.abs(this.minTemp - eq.minTemp) > epsilon){
			return false;
		}
		return true;
	}
}
