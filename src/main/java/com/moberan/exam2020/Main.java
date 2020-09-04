package com.moberan.exam2020;

import com.moberan.exam2020.lib.TestLibrary;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	private static final long WAIT_TIME = 3000L;

	public static void main(String[] args) {
		String result = tasks();
		System.out.println(result);
	}

	private static String tasks(){
		TestLibrary lib = new TestLibrary();

		// keyword : java future
		CompletableFuture<String> futureTask = new CompletableFuture<>();
		lib.firstTask(futureTask::complete);

		String first = null;
		try {
			first = futureTask.get(WAIT_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		return lib.secondTask(first);
	}
}
