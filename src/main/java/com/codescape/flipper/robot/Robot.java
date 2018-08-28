package com.codescape.flipper.robot;

import com.codescape.flipper.sql.MariaDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Robot implements Runnable {
	private Roster roster;
	private MariaDB sql;
	
	public Robot(MariaDB sql) {
		this.setRoster(new Roster());
		this.setSQL(sql);
	}
	
	public void run() {
		this.initTraders();
	}
	
	// Initializing traders
	public void initTraders() {
		
	}
	
	public void loadTrader(String idOrName) throws SQLException {
		ResultSet result = this.sql.query("SELECT * FROM `traders` WHERE `TID` = '" + idOrName + "' OR `name` = '" + idOrName + "';");
		
		try {
			Trader trader = this.roster.get(idOrName);
		} catch (NoTraderException e) {
			
		}
		
		
	}
	
	public void setRoster(Roster roster) { this.roster = roster; }
	public void setSQL(MariaDB sql) { this.sql = sql; }
}
