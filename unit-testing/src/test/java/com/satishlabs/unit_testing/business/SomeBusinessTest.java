package com.satishlabs.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int[] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
}
