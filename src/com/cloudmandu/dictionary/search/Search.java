package com.cloudmandu.dictionary.search;

import java.util.Map;

import com.cloudmandu.dictionary.wordlist.WordList;

public class Search implements SearchIf{
	private WordList wordList;
	
	public Search(WordList wordList) {
		this.wordList = wordList;
	}
	
	@Override
	public String searchWordByName(String name) {
		Map<String, String> wordMap = wordList.getWordList();
		String response =  wordMap.get(name);
		
		return response;
	}



}
