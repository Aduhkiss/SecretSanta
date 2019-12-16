package me.atticuszambrana.ss.command.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.atticuszambrana.ss.Start;
import me.atticuszambrana.ss.command.Command;

public class FindCommand extends Command {
	
	public FindCommand() {
		super("find");
	}
	
	private List<String> alreadyMatched = new ArrayList<>();

	@Override
	public void execute() {
		
		Map<String, String> matches = new HashMap<String, String>();
		
		
		for(String member : Start.getFamily()) {
			String match = calculateMatch(member);
			matches.put(member, match);
		}
		
		// For each member, we want to write their result, to a text file with their name
		for(Map.Entry<String, String> ent : matches.entrySet()) {
			String person = ent.getKey();
			String theirMatch = ent.getValue();
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(person + ".txt"));
				writer.write(theirMatch);
				writer.close();
			} catch(IOException ex) {
				System.out.println("Oh no! Something bad happened!");
				ex.printStackTrace();
				System.exit(1);
			}
			
		}
		
		System.out.println("Done.");
	}
	
	private String calculateMatch(String in) {
		String possibleMatch = getRandomMember();
		if(in.equals(possibleMatch)) {
			return calculateMatch(in);
		}
		if(hasAlreadyMatched(possibleMatch)) {
			return calculateMatch(in);
		}
		alreadyMatched.add(possibleMatch);
		return possibleMatch;
	}
	
	private String getRandomMember() {
		Random r = new Random();
		int i = r.nextInt(Start.getFamily().size());
		return Start.getFamily().get(i);
	}
	
	private boolean hasAlreadyMatched(String s) {
		for(String a : alreadyMatched) {
			if(a.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

}
