package com.evernote.processor.contract;

import java.util.List;

public interface TextProcessor {
	public String sanitize(String text);
	public List<String> textProcessor(String text, int itemCount);
	public List<String> mostFrequentWords(int itemCount);
}
