package com.moberan.exam2020;

import com.moberan.exam2020.lib.TestLibrary;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) {
		String result = tasks();
		System.out.println(result);
	}

	private static String tasks(){
		TestLibrary lib = new TestLibrary();

		CompletableFuture<String> futureTask = new CompletableFuture<>();
		lib.firstTask(futureTask::complete);

		String first = null;
		try {
			first = futureTask.get(2, TimeUnit.SECONDS);
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
