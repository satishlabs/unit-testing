package com.satishlabs.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.satishlabs.unit_testing.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {
	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] { 1, 2, 3 };
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {
	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {};
	}
}

class SomeDataServiceEmptyOneElementStub implements SomeDataService {
	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {5};
	}
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new SomeDataServiceStub());
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_basic_empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new SomeDataServiceEmptyOneElementStub());
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
