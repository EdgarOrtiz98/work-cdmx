/*
 * TaskQueue.java
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

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TaskQueue {

        private static Log log = LogFactory.getLog(TaskQueue.class);
	private final List tasks = new LinkedList();
	private Worker[] workers;

	public TaskQueue(int workersCount) {
		if (workersCount < 1) {
			throw new IllegalArgumentException("Tiene que haber por lo menos 1 worker");
		}
		workers = new Worker[workersCount];
		for (int i = 0; i < workersCount; i++) {
			workers[i] = new Worker();
			workers[i].start();
		}
	}

	public synchronized void addTask(Runnable task) {
		if (task == null) {
			throw new NullPointerException("task es nula");
		}
		tasks.add(task);
		notify();
	}

	public synchronized Runnable getTask() {
		while (tasks.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				log.error("Excepcion inesperada: " + e);
			}
		}
		Runnable task = (Runnable) tasks.get(0);
		tasks.remove(0);
		return task;
	}

	private class Worker extends Thread {

		public void run() {
			while (true) {
				try {
					Runnable task = getTask();
					try {
						task.run();
					} catch (Throwable t) {
						log.error("Excepcion inesperada: " + t);
						t.printStackTrace();
					}
				} catch (Throwable t) {
					log.error("Excepcion inesperada: " + t);
					t.printStackTrace();
				}
			}
		}
	}

}