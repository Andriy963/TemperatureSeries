package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    
	public double epsilon = 0.000001;
	
	@Test(expected = IllegalArgumentException.class)
	public void testAverageFailOnEmptyArray(){
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.average();
	}
	
	@Test
    public void testAverageArrayWithSingleElement() {
        double[] temperatureSeries = {1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test
    public void testAverageArrayWithTheSameElements() {
        double[] temperatureSeries = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test
    public void testAverageArrayWithPositiveElements() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.5;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
    @Test
    public void testAverageArrayWithFourElements() {
        double[] temperatureSeries = {1.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.5;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, epsilon);
    }
    
	@Test
    public void testAverageArrayWithTenElements() {
        double[] temperatureSeries = {11.4, -52.51, 31.0, 25.03, -96.2, 2.5, -12.4, 63.45, -3.235, 1.321};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -2.9644;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test
    public void testAverageCheckForEpsilonError() {
        double[] temperatureSeries = {1.40215, -5.32102, 4.00012};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.027083;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeviationFailOnEmptyArray(){
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.deviation();
	}
	
	@Test
    public void testDeviationArrayWithSingleElement() {
        double[] temperatureSeries = {1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test
    public void testDeviationArrayWithTheSameElements() {
        double[] temperatureSeries = {1.0, 1.0, 1.0, 1.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test
    public void testDeviationArrayWithPositiveElements() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.707825127659933;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test
    public void testDeviationArrayWithDifferentElements() {
        double[] temperatureSeries = {-10, 0, 10};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 8.164965809277;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, epsilon);
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testMinFailOnEmptyArray(){
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.min();
	}
	
	@Test
	public void testMinArrayWithSigleElement(){
		double[] temperatureSeries = {-51.2036};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -51.2036;
		double actualResult = seriesAnalysis.min();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testMinArrayWithPositiveElements(){
		double[] temperatureSeries = {51.2036, 23, 12.23, 5.024, 44};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 5.024;
		double actualResult = seriesAnalysis.min();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testMinArrayWithDifferentElements(){
		double[] temperatureSeries = {51.2036, -23, 12.23, 5.024, -44, 32.02, -44.0003, -20, 52, 1.235};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -44.0003;
		double actualResult = seriesAnalysis.min();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMaxFailOnEmptyArray(){
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.max();
	}
	
	@Test
	public void testMaxArrayWithSigleElement(){
		double[] temperatureSeries = {31.3916};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 31.3916;
		double actualResult = seriesAnalysis.max();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testMaxArrayWithPositiveElements(){
		double[] temperatureSeries = {31.3916, 123, 12.23, 5.24, 44.02};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 123;
		double actualResult = seriesAnalysis.max();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testMaxArrayWithDifferentElements(){
		double[] temperatureSeries = {51.2036, -23, 12.23, 5.024, -44, 32.02, -44.0003, -20, 52.1456, 1.235};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 52.1456;
		double actualResult = seriesAnalysis.max();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindTempClozestToZeroFailOnEmptyList(){
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempClosestToZero();
	}
	
	@Test
	public void testFindTempClozestToZeroArrayWithSingleElement(){
		double[] temperatureSeries = {3.25};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 3.25;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClozestToZeroArrayWithPositiveElements(){
		double[] temperatureSeries = {3.25, 2.1, 32, 6.02, 2.01};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 2.01;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClozestToZeroArrayWithNegativeElements(){
		double[] temperatureSeries = {-3.25, -3.1, -32, -5.03, -3.01};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -3.01;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClozestToZeroArrayWithDifferentElements(){
		double[] temperatureSeries = {-3.25, 3.1, -32, 5.03, -3.01, 3.002, 5.03, 6.214, -321.02};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 3.002;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClozestToZeroArrayWithZeroElement(){
		double[] temperatureSeries = {-3.25, 3.1, -32, 5.03, -3.01, 0.0, 5.03, 6.214, -321.02};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 0;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClozestToZeroArrayWithEqualAbsValueElementsPositiveValueFirst(){
		double[] temperatureSeries = {-3.25, 3.1, -32, 5.03, -3.01, 3.002, 5.03, -3.002, -321.02};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 3.002;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClozestToZeroArrayWithSeveralEqualAbsValueElements(){
		double[] temperatureSeries = {-3.25, 6.1, -32, 3.25, -3.401, -3.25, 5.03, -31.002, 3.25};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 3.25;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindTempClosestToValueFailOnEmptyList(){
		double[] temperatureSeries = {};
		double tempValue = 5;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempClosestToValue(tempValue);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithSingleElement(){
		double[] temperatureSeries = {3.25};
		double tempValue = 4;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 3.25;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithElementsGreaterThenTempValue(){
		double[] temperatureSeries = {3.25, 5.03, 6, 2.03, 5.23};
		double tempValue = 1.032;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 2.03;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithElementsLessThenTempValue(){
		double[] temperatureSeries = {3.25, 5.03, 6.034, 2.03, 5.23};
		double tempValue = 7.11;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 6.034;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithDiffeentElements(){
		double[] temperatureSeries = {3.25, -5.03, 6.034, 2.03, 5.23, 1.032, -0.24, -5.032};
		double tempValue = 7.11;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 6.034;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithEqualSubElementsLessElementFirst(){
		double[] temperatureSeries = {3.11, -2.035, 5.11, 6.034, 2.03, 5.23};
		double tempValue = 4.11;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 5.11;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithEqualSubElementsGreaterElementFirst(){
		double[] temperatureSeries = {5.93, 11.11, -5.4, 6.034, 5.03, 52.23, -2.034};
		double tempValue = 5.48;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 5.93;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithSeveralEqualSubElementsLessElementFirst(){
		double[] temperatureSeries = {-5.11, -2.035, -5.11, 6.034, 2.03, 5.23, -3.11};
		double tempValue = -4.11;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -3.11;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempClosestToValueArrayWithSeveralEqualSubElementsGreaterElementFirst(){
		double[] temperatureSeries = {-5.03, 11.11, 5.4, 6.034, -5.03, 52.23, -2.034, -5.93};
		double tempValue = -5.48;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -5.03;
		double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
		
		assertEquals(expResult, actualResult, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindTempsLessThenFailOnEmptyList(){
		double[] temperatureSeries = {};
		double tempValue = 5;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempsLessThen(tempValue);
	}
	
	@Test
	public void testFindTempsLessThenArrayWithSingleElement(){
		double[] temperatureSeries = {3.25};
		double tempValue = 4;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {3.25};
		double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);
		
		assertArrayEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempsLessThenArrayWithSeveralElement(){
		double[] temperatureSeries = {3.25, 5.03, 2.031, 23.01, -95.03, 4, 1.021};
		double tempValue = 4;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {3.25, 2.031, -95.03, 1.021};
		double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);
		
		assertArrayEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempsLessThenArrayWithElementsGreaterThenTempValue(){
		double[] temperatureSeries = {3.25, 5.03, 2.031, 23.01, 95.03, 4, 1.0421};
		double tempValue = 1.0325;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {};
		double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);
		
		assertArrayEquals(expResult, actualResult, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindTempsGreaterThenFailOnEmptyList(){
		double[] temperatureSeries = {};
		double tempValue = 5;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempsGreaterThen(tempValue);
	}
	
	@Test
	public void testFindTempsGreaterThenArrayWithSingleElement(){
		double[] temperatureSeries = {5.25};
		double tempValue = 4;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {5.25};
		double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);
		
		assertArrayEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempsGreaterThenArrayWithSeveralElement(){
		double[] temperatureSeries = {3.25, 5.03, 2.031, 23.01, -95.03, 4, 1.021, 2.51};
		double tempValue = 2.51;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {3.25, 5.03, 23.01, 4, 2.51};
		double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);
		
		assertArrayEquals(expResult, actualResult, epsilon);
	}
	
	@Test
	public void testFindTempsGreaterThenArrayWithElementsLessThenTempValue(){
		double[] temperatureSeries = {3.25, 5.03, 2.031, 23.01, 95.03, 4, 1.0421};
		double tempValue = 103.25;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {};
		double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);
		
		assertArrayEquals(expResult, actualResult, epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSummaryStatisticsFailOnEmptyList(){
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.summaryStatistics();
	}
	
	@Test
	public void testSummaryStatisticsArrayWithSingleElement(){
		double[] temperatureSeries = {-2.03};
		double avg = -2.03;
		double dev = 0;
		double min = -2.03;
		double max = -2.03;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		TempSummaryStatistics expResult = new TempSummaryStatistics(avg, dev, min, max);
		TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		
		assertEquals(expResult, actualResult);
	}
	
	@Test
	public void testSummaryStatisticsArrayWithTheSameElements(){
		double[] temperatureSeries = {-22.034, -22.034, -22.034, -22.034, -22.034, -22.034};
		double avg = -22.034;
		double dev = 0;
		double min = -22.034;
		double max = -22.034;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		TempSummaryStatistics expResult = new TempSummaryStatistics(avg, dev, min, max);
		TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		
		assertEquals(expResult, actualResult);
	}
	
	@Test
	public void testSummaryStatisticsArrayWithDifferentElements(){
		double[] temperatureSeries = {-22.034, 2.4, 3.025, 5.023, 20.12, -5.031};
		double avg = 0.58383333;
		double dev = 12.6076597275;
		double min = -22.034;
		double max = 20.12;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		TempSummaryStatistics expResult = new TempSummaryStatistics(avg, dev, min, max);
		TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		
		assertEquals(expResult, actualResult);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddTempsFailOnEmptyList(){
		double[] temperatureSeries = {2.03};
		double[] tempValue = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		
		seriesAnalysis.addTemps(tempValue);
	}
	
	@Test(expected = InputMismatchException.class)
	public void testAddTempsFailOnTemperatureLessThenMinimum(){
		double[] temperatureSeries = {5.25};
		double[] tempValue = {-3.02, 54.02, -273.025, 5};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		
		seriesAnalysis.addTemps(tempValue);
	}
	
	@Test
	public void testAddTempsArrayWithSingleElement(){
		double[] temperatureSeries = {5.25, -2.03, 21.01, 54.02, -32.012};
		double[] tempValue = {4};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		int expResult = 6;
		int actualResult = seriesAnalysis.addTemps(tempValue);
		
		assertEquals(expResult, actualResult);
	}
	
	@Test
	public void testAddTempsArrayWithManyElements(){
		double[] temperatureSeries = {5.25, -2.03, 21.01, 54.02, -32.012};
		double[] tempValue = {4, 6.03, -20.1, -56.023, 32.02};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		int expResult = 10;
		int actualResult = seriesAnalysis.addTemps(tempValue);
		
		assertEquals(expResult, actualResult);
	}
	
	@Test
	public void testAddTempsTempArrayWithQuantityOfElementsMoreThanInTemperatureArray(){
		double[] temperatureSeries = {5.25, -2.03, 21.01, 54.02, -32.012};
		double[] tempValue = {4, 6.03, -20.1, -56.023, 32.02, 0.24156, -24.03};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		int expResult = 12;
		int actualResult = seriesAnalysis.addTemps(tempValue);
		
		assertEquals(expResult, actualResult);
	}
	
}

