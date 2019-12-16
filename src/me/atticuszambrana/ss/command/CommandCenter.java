package me.atticuszambrana.ss.command;

import java.util.ArrayList;
import java.util.List;

import me.atticuszambrana.ss.command.impl.FindCommand;
import me.atticuszambrana.ss.command.impl.TestCommand;

public class CommandCenter {
	private static List<Command> commands = new ArrayList<Command>();
	
	public static void register() {
		commands.add(new TestCommand());
		commands.add(new FindCommand());
	}
	
	public static List<Command> getCommands() {
		return commands;
	}
}
