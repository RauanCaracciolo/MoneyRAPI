package model.entity;

import java.util.Map;

public class FinancialRelatory {

	private double totalIncome;
	private double totalExpense;
	private double actualMoney;
	private Map<String, Double> categoryIncome;
	private Map<String, Double> categoryExpense;
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public double getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}
	public double getActualMoney() {
		return actualMoney;
	}
	public void setActualMoney(double actualMoney) {
		this.actualMoney = actualMoney;
	}
	public Map<String, Double> getCategoryIncome() {
		return categoryIncome;
	}
	public void setCategoryIncome(Map<String, Double> categoryIncome) {
		this.categoryIncome = categoryIncome;
	}
	public Map<String, Double> getCategoryExpense() {
		return categoryExpense;
	}
	public void setCategoryExpense(Map<String, Double> categoryExpense) {
		this.categoryExpense = categoryExpense;
	}
	
	
	
}
