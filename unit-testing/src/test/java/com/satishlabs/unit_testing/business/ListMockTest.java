package com.satishlabs.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {
	List mock = Mockito.mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("test");
		assertEquals("test", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("test");
		assertEquals("test", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void verificationBasics() {
		String value1 = (String) mock.get(0);
		String value2 = (String) mock.get(1);
		
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(anyInt());
		verify(mock,atLeastOnce()).get(anyInt());
		verify(mock,atMost(2)).get(anyInt());
		verify(mock,never()).get(2);
	}
	
	@Test
	public void argumentsCapturing() {
		mock.add("Something");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("Something", captor.getValue());
	}
	
	@Test
	public void multipleArgumentsCapturing() {
		mock.add("Something1");
		mock.add("Something2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("Something1", allValues.get(0));
		assertEquals("Something2", allValues.get(1));
	}
	
	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());
		
		verify(arrayListSpy).add("Test4");
	}
}


