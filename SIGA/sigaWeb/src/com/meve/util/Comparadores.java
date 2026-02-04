
package com.meve.util;

import java.util.Date;
/**
 * Clase con metodos para la comparacion de datos
 * @author Meve Soluciones, SA
 *
 */
public class Comparadores {

	public static int compare(String string1, String string2, boolean ascOrder) {
		if (ascOrder) {
			if (string1 == null || string2 == null) {
				return -1;
			}
			return string1.toUpperCase().compareTo(string2.toUpperCase());
		} else {
			if (string1 == null || string2 == null) {
				return 1;
			}
			return string2.toUpperCase().compareTo(string1.toUpperCase());
		}

	}

	public static int compare(Date date1, Date date2, boolean ascOrder) {
		if (ascOrder) {
			if (date1 == null || date2 == null) {
				return -1;
			}
			return date1.compareTo(date2);
		} else {
			if (date1 == null || date2 == null) {
				return 1;
			}
			return date2.compareTo(date1);
		}
	}

	public static int compare(int int1, int int2, boolean ascOrder) {
		if (int1 == int2) {
			return 0;
		}
		if (ascOrder) {
			if (int1 < int2) {
				return -1;
			} else if (int1 > int2) {
				return 1;
			}
		} else {
			if (int2 < int1) {
				return -1;
			} else if (int2 > int1) {
				return 1;
			}
		}
		return 0;
	}

	public static int compare(long long1, long long2, boolean ascOrder) {
		if (long1 == long2) {
			return 0;
		}
		if (ascOrder) {
			if (long1 < long2) {
				return -1;
			} else if (long1 > long2) {
				return 1;
			}
		} else {
			if (long2 < long1) {
				return -1;
			} else if (long2 > long1) {
				return 1;
			}
		}
		return 0;
	}

}
