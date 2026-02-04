 package com.meve.util;

 /**
  * Interface para el ordenamiento de una lista.
  * @author Meve Soluciones, SA
  *
  */
public interface Ordenable {

	public int compareTo(Ordenable obj, String field, boolean ascOrder)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException;

}
