package com.paxnet.stock;

public class StockDTO {
	private String link;
	private String company;
	private String pPrice;
	private String yesterdayToday;
	private String upDown;
	private String windowPrice;
	private String totalPrice;
	private String amount;
	private String foreigner;
	private String volume;
	private String per;
	private String roe;
	private String toron;
	private boolean isTrade;
	
	
	@Override
	public String toString() {
		return "StockDTO [company=" + company + ", pPrice=" + pPrice + ", yesterdayToday=" + yesterdayToday
				+ ", upDown=" + upDown + ", windowPrice=" + windowPrice + ", totalPrice=" + totalPrice + ", amount="
				+ amount + ", foreigner=" + foreigner + ", volume=" + volume + ", per=" + per + ", roe=" + roe
				+ ", toron=" + toron + ", isTrade=" + isTrade + "]";
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public boolean isTrade() {
		return isTrade;
	}
	public void setTrade(boolean isTrade) {
		this.isTrade = isTrade;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getYesterdayToday() {
		return yesterdayToday;
	}
	public void setYesterdayToday(String yesterdayToday) {
		this.yesterdayToday = yesterdayToday;
	}
	public String getUpDown() {
		return upDown;
	}
	public void setUpDown(String upDown) {
		this.upDown = upDown;
	}
	public String getWindowPrice() {
		return windowPrice;
	}
	public void setWindowPrice(String windowPrice) {
		this.windowPrice = windowPrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getForeigner() {
		return foreigner;
	}
	public void setForeigner(String foreigner) {
		this.foreigner = foreigner;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getRoe() {
		return roe;
	}
	public void setRoe(String roe) {
		this.roe = roe;
	}
	public String getToron() {
		return toron;
	}
	public void setToron(String toron) {
		this.toron = toron;
	}
	
	
	
}
