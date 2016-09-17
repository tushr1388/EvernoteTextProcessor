package com.evernote.processor.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.evernote.processor.contract.TextProcessor;

public class TextProcessorImpl implements TextProcessor {
	private Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
	private static final String ALPHANUMERIC_REGEX = "[^A-Za-z0-9]";
	private static final String DELIMITER = " ";
	private int max = Integer.MIN_VALUE;

	public String sanitize(String str) {
		final String result = str == null ? null : str.replaceAll(ALPHANUMERIC_REGEX, "");
		if (result == null || result.length() < 1) {
			return null;
		}
		return result;
	}

	public List<String> textProcessor(String text, int itemCount) {
		List<String> result = new ArrayList<String>();

		// check if string is null or empty
		if (text == null || text.equals("")) {
			return result;
		}

		// check if itemCount <=0
		if (itemCount <= 0) {
			return result;
		}

		// Get all the words in lowercase
		String words[] = text.toLowerCase().split(DELIMITER);
		
		//iterate and create a map
		for (String word : words) {
			word = sanitize(word);
			if(word == null) {
				continue;
			}
			if (wordCount.containsKey(word)) {
				wordCount.put(word, wordCount.get(word) + 1);
			} else {
				wordCount.put(word, 1);
			}
			max = Math.max(max, wordCount.get(word));
		}
		System.out.println(wordCount.toString());
		return mostFrequentWords(itemCount);
	}

	public List<String> mostFrequentWords(int itemCount) {
		List<String> result = new ArrayList<String>();
		List<String>[] resultTemp = new List[max + 1];

		for (Entry<String, Integer> entry : wordCount.entrySet()) {
			if (resultTemp[entry.getValue()] != null) {
				resultTemp[entry.getValue()].add(entry.getKey());
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(entry.getKey());
				resultTemp[entry.getValue()] = temp;
			}
		}

		for (int i = resultTemp.length - 1; i >= 0; i--) {
			if (resultTemp[i] == null) {
				continue;
			}
			List<String> temp = resultTemp[i];
			int j = 0;
			while (itemCount != 0 && j < temp.size()) {
				result.add(temp.get(j));
				itemCount--;
				j++;
			}
			if (itemCount == 0) {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TextProcessorImpl tp = new TextProcessorImpl();
		String text = "hello world% hello hello% world% enoug-h is hello% enough is there all hello";
		System.out.println(tp.textProcessor(text, 3).toString());
	}
}