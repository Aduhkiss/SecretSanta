package me.atticuszambrana.ss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import me.atticuszambrana.ss.command.Command;
import me.atticuszambrana.ss.command.CommandCenter;

public class Start {
	
	private static boolean active;
	private static List<String> family = new ArrayList<String>();
	
	public static void main(String[] args) {
		active = true;
		
		// First we need to make a list of people lmao
		// (I moved the list declaration to the class level instead of method)
		
		// Then lets fill that list with people
		family.add("Atticus");
		family.add("Felicity");
		family.add("KC");
		family.add("Nef");
		family.add("Judy");
		
		// Then register the commands
		CommandCenter.register();
		
		// Then lets wait for a command from the user
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(active) {
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				System.out.println("Uhh.. Something bad happened! Report this to Atticus with the following information: ");
				System.out.println(e.getMessage());
				System.exit(1);
				//e.printStackTrace();
			}
			if(line == null) {
				break;
			}
			if(line.equalsIgnoreCase("/stop")) {
				System.out.println("Okay. Shutting down...");
				System.exit(0);
				return;
			}
			
			// This code will be what we are looking for
			System.out.println(">" + line);
			
			// Parse the given input, and separate the command name from the arguments
			//TODO: Add arguments
			boolean triggered = false;
			for(Command c : CommandCenter.getCommands()) {
				if(line.toLowerCase().startsWith(c.getName().toLowerCase())) {
					// Trigger this command
					triggered = true;
					c.execute();
				}
			}
			
			if(!triggered) {
				System.out.println("Command not found.");
			}
		}
	}
	
	public static List<String> getFamily() {
		return family;
	}
}
