package com.cloudmandu.dictionary;

import java.util.Map;

import com.cloudmandu.dictionary.constant.Constant;
import com.cloudmandu.dictionary.inputHelper.InputHelper;
import com.cloudmandu.dictionary.printer.Printer;
import com.cloudmandu.dictionary.search.Search;
import com.cloudmandu.dictionary.wordlist.WordList;

public class Dictionary {

	public static void main(String[] args) {
		
		WordList wordList = new WordList();
		Printer printer = new Printer();
		InputHelper inputHelper = new InputHelper();
		Search search = new Search(wordList);
		
		wordList.loadWordList();
		Map<String, String> availableWords = wordList.getWordList();
		
		boolean continueAsking = true;
		while (continueAsking) {

			printer.printMessage(Constant.MAIN_PROMPT);

			String userInput = inputHelper.getString();

			if (userInput.equals("x") || userInput.equals("X")) {
				continueAsking = false;
			} else {
				String response = Constant.WORD_NOT_FOUND_PROMPT;

				if (availableWords.containsKey(userInput)) {
					response = search.searchWordByName(userInput);
				}

				printer.printMessage(response);
			}
			
		}

		printer.printMessage(Constant.OPTIONS_PROMPT);
		char selectedOption = inputHelper.getChar();
		
		//Add word
		if (selectedOption == 'a' || selectedOption == 'A') {

			printer.printMessage(Constant.INPUT_WORD_PROMPT);
			String userWord = inputHelper.getString();
			printer.printMessage(Constant.INPUT_DEFINITION_PROMPT);
			String userDefinition = inputHelper.getString();

			wordList.addToWordList(userWord, userDefinition);
			printer.printMessage(Constant.WORD_ADDED_MESSAGE);
			
		//Delete word	
		} else if (selectedOption == 'd' || selectedOption == 'D') {
			printer.printMessage(Constant.DELETE_WORD_PROMPT);
			String deleteWord = inputHelper.getString();

			if (availableWords.containsKey(deleteWord)) {
				wordList.removeFromWordList(deleteWord);
				printer.printMessage(Constant.WORD_DELETED_MESSAGE);
			} else {
				printer.printMessage(Constant.WORD_NOT_FOUND_PROMPT);
			}
		}

	}

}
