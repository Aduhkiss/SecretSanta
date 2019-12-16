package me.atticuszambrana.ss.command.impl;

import me.atticuszambrana.ss.command.Command;

public class TestCommand extends Command {
	
	public TestCommand() {
		super("testlmao");
	}

	@Override
	public void execute() {
		System.out.println("It works!");
	}

}
