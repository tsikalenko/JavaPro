package com.gmail.tsikalenko.nikita;

import java.io.PrintWriter;

@SaveTo(file = "a.txt")
public class TextContainer {
	String s = "Hello World!";
	@Save
	public void save(String file) {
		try(PrintWriter pw = new PrintWriter(file)) {
			pw.println(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("File save!");
	}
}
