package me.atticuszambrana.ss.command;

public abstract class Command {
	private String name;
	
	public Command(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void execute();
}
