package com.satishlabs.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.satishlabs.unit_testing.data.SomeDataService;


public class SomeBusinessMockTest {
	SomeBusinessImpl businessImpl = new SomeBusinessImpl();
	SomeDataService dataServiceMock =  mock(SomeDataService.class);
	
	@Before(value = "")
	public void before() {
		businessImpl.setSomeDataService(dataServiceMock);
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		//dataServiceMock retriveAllData new int[] {1,2,3}
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
				
		businessImpl.setSomeDataService(dataServiceMock);
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_basic_empty() {
		//dataServiceMock retriveAllData new int[] {}
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
		businessImpl.setSomeDataService(dataServiceMock);
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		//dataServiceMock retriveAllData new int[] {5}	
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {5});
		businessImpl.setSomeDataService(dataServiceMock);
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
