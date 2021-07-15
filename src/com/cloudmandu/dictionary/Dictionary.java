package com.cloudmandu.dictionary;

import java.util.Map;

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
		
		Map<String, String> availableWords = WordList.getWordList();
		
		Printer printer = new Printer();
		printer.printMessage(Constant.WELCOME_MESSAGE);
		
		InputHelper inputHelper = new InputHelper();
		String userInput = inputHelper.getString();
		
		Search search = new Search();
		String response = Constant.WORD_NOT_FOUND_PROMPT;
		
		if(availableWords.containsKey(userInput)) {
			response = search.searchWordByName(userInput);
		} 
		
		printer.printMessage(response);
		
		printer.printMessage(Constant.OPTIONS_PROMPT);
		char selectedOption = inputHelper.getChar();
		
		if (selectedOption == 'a' || selectedOption == 'A') {
			
			printer.printMessage(Constant.INPUT_WORD_PROMPT);
			String userWord = inputHelper.getString();
			printer.printMessage(Constant.INPUT_DEFINITION_PROMPT);
			String userDefinition = inputHelper.getString();
			
			wordList.addToWordList(userWord, userDefinition);
			
		} else if (selectedOption == 'd' || selectedOption == 'D') {
			printer.printMessage(Constant.DELETE_WORD_PROMPT);
			String deleteWord = inputHelper.getString();
			
			if( availableWords.containsKey(deleteWord) ) {
				wordList.removeFromWordList(deleteWord);
			} else {
				printer.printMessage(Constant.WORD_NOT_FOUND_PROMPT);
			}
		}
		
	

	}

}
