package com.evernote.processor.init;

import com.evernote.processor.impl.TextProcessorImpl;

public class TextProcessorMain {
	public static void main(String[] args) {
		TextProcessorImpl tp = new TextProcessorImpl();
		String text = "hello world% hello hello% world% enoug-h is hello% enough is there all hello";
		System.out.println(tp.textProcessor(text, 3).toString());
	}
}
