package com.patrickhestad.project.insurancecompany.lib;

public class Validator {

	/**
	 * Method for validating that the national id is in correct format
	 * @param nationalId id to be validated
	 * @return Returns true if national id contains 11 numbers
	 */
	public boolean validateNationalId(String nationalId) {

		return nationalId.matches("[0-9]{11}");
	}

	/**
	 * Method for validating that multiple variables are not null
	 * @param args inputs
	 * @return if all variables are not null true is returned. If a null variable is found false is returned
	 */
	public boolean notNull(String... args) {
		for (String arg : args) {
			if (arg == null) {
				return false;
			}
		}
		return true;
	}
}
