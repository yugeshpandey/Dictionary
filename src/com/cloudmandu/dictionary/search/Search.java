package com.cloudmandu.dictionary.search;

import java.util.Map;

import com.cloudmandu.dictionary.wordlist.WordList;

public class Search implements SearchIf{
	
	Map<String, String> wordList = WordList.getWordList();

	@Override
	public String searchWordByName(String name) {
		String response =  wordList.get(name);
		
		return response;
	}



}
