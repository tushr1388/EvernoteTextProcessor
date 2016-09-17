package com.evernote.processor.tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.evernote.processor.contract.TextProcessor;
import com.evernote.processor.impl.TextProcessorImpl;

public class TextProcessorTest {
	@Test
	public void testEmptyString() {
		TextProcessor textProc = new TextProcessorImpl();
		String text = "";
		int itemCount = 2;
		assertEquals("Input text String is empty", 0, textProc.textProcessor(text, itemCount).size());
	}

	@Test
	public void testNullString() {
		TextProcessor textProc = new TextProcessorImpl();
		String text = null;
		int itemCount = 2;
		assertEquals("Input text String is null", 0, textProc.textProcessor(text, itemCount).size());
	}

	@Test
	public void testZeroItemCount() {
		TextProcessor textProc = new TextProcessorImpl();
		String text = "hello world hello world  helloworld";
		int itemCount = 0;
		assertEquals("Item Count is zero", 0, textProc.textProcessor(text, itemCount).size());
	}

	@Test
	public void testNegativeItemCount() {
		TextProcessor textProc = new TextProcessorImpl();
		String text = "hello world hello world  helloworld";
		int itemCount = -2;
		assertEquals("Item Count is negative", 0, textProc.textProcessor(text, itemCount).size());
	}

	@Test
	public void testSuccess() {
		TextProcessor textProc = new TextProcessorImpl();
		String text = "hello world hello world helloworld";
		int itemCount = 2;
		List<String> actual = textProc.textProcessor(text, itemCount);
		List<String> expected = new ArrayList<String>();
		expected.add("hello");
		expected.add("world");
		for (int i = 0; i < expected.size(); i++) {
			System.out.println("Expected :" + expected.get(i) + " , Actual : " + actual.get(i));
			assertEquals("Fields are equal", expected.get(i), actual.get(i));
		}
	}

	@Test
	public void testAlphaNumNonAlphaNumericStringSuccess() {
		TextProcessor textProc = new TextProcessorImpl();
		String text = "- - - - - hell-o world hell%o world9 helloworld";
		int itemCount = 2;
		List<String> actual = textProc.textProcessor(text, itemCount);
		System.out.println(actual.toString());
		List<String> expected = new ArrayList<String>();
		expected.add("hello");
		expected.add("world");
		for (int i = 0; i < expected.size(); i++) {
			System.out.println("Expected :" + expected.get(i) + " , Actual : " + actual.get(i));
			assertEquals("Fields are equal", expected.get(i), actual.get(i));
		}
	}
}