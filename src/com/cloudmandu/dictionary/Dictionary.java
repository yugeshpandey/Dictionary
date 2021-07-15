package com.cloudmandu.dictionary;

import com.cloudmandu.dictionary.constant.Constant;
import com.cloudmandu.dictionary.inputHelper.InputHelper;
import com.cloudmandu.dictionary.printer.Printer;
import com.cloudmandu.dictionary.search.Search;
import com.cloudmandu.dictionary.wordlist.WordList;

public class Dictionary {

	public static void main(String[] args) {
		//take String input 'word'
		WordList wordList = new WordList();
		wordList.loadWordList();
		
		Printer printer = new Printer();
		printer.printMessage(Constant.WELCOME_MESSAGE);
		
		InputHelper inputHelper = new InputHelper();
		String userInput = inputHelper.getString();
		
		Search search = new Search();
		String response = search.searchWordByName(userInput);
		
		printer.printMessage(response);
		
	

	}

}
