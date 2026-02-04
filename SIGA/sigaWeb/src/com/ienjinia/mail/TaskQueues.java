/*
 * TaskQueues.java
 *  
 * Copyright (C) Ienjinia, S.C. 2007. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of IENJINIA
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with  IENJINIA
 * or his authorized licensees.
 * 
 * MEVE SOLUCIONES MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT
 * THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. IENJINIA
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *  
 */

 package com.ienjinia.mail;

import java.util.HashMap;
import java.util.Map;

public class TaskQueues {

	private static final Map queues = new HashMap();

	public static synchronized TaskQueue getQueue(String name, int workers) {
		if (name == null) {
			throw new NullPointerException("name es nulo");
		}
		TaskQueue tq = (TaskQueue) queues.get(name);
		if (tq == null) {
			tq = new TaskQueue(workers);
			queues.put(name, tq);
		}
		return tq;
	}

}
