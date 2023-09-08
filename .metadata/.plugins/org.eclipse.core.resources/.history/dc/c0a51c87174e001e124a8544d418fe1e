package org.generetion;

import java.time.LocalDateTime;
import java.util.UUID;

public class Movements {
	private String id;
	private LocalDateTime date;
	private String type;
	private double amount;

	Movements(String type, double amount) {
		this.id = UUID.randomUUID().toString();
		this.date = LocalDateTime.now();
		this.type = type;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
