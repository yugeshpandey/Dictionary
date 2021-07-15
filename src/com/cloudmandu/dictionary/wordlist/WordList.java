package com.cloudmandu.dictionary.wordlist;

import java.util.HashMap;
import java.util.Map;

import com.cloudmandu.dictionary.constant.Constant;

public class WordList {
	
	private Map<String, String> wordList = new HashMap<>();
	
	public void loadWordList() {
		wordList.put(Constant.PRIVATE, Constant.PRIVATE_DEFINITION);
		wordList.put(Constant.PUBLIC, Constant.PUBLIC_DEFINITION);
		wordList.put(Constant.ABSTRACT, Constant.ABSTRACT_DEFINITION);
		wordList.put(Constant.INHERITANCE, Constant.INHERITANCE_DEFINITION);
		wordList.put(Constant.ENCAPSULATION, Constant.ENCAPSULATION_DEFINITION);
		
	}
	
	public Map<String, String> getWordList() {
		return wordList;
	}
	
	public void addToWordList(String word, String definition) {
		wordList.put(word, definition);
	}
	
	public void removeFromWordList(String word) {
		wordList.remove(word);
	}

}
