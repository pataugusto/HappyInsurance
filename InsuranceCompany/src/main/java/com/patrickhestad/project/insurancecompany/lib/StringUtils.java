package com.patrickhestad.project.insurancecompany.lib;

public class StringUtils {


	/**
	 * Method for formatting string input
	 * @param input string to be formatted
	 * @return Returns a new string without whitespaces
	 */
	public String removeWhitespace(String input) {
		return input.replaceAll("\\s+","");
	}
}
