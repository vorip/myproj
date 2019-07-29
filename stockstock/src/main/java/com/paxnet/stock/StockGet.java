package com.paxnet.stock;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

public class StockGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url;
	Document html;
	Elements links;
	Elements nums;
	String[] numsArr;
	String numsStr;
	String[] linkArr;
	String linkStr;
	String link;
	String company;
	StockDTO dto;
	String pPrice;
	String yesterdayToday;
	String upDown;
	String windowPrice;
	String totalPrice;
	String amount;
	String foreigner;
	String volume;
	String per;
	String roe;
	String toron;
	
	
	@Autowired
	StockDAO dao;
	
    public StockGet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(int page=1;page<32;page++) {
			try {
				//반복문으로 cospi url 31페이지 반복
				url = "https://finance.naver.com/sise/sise_market_sum.nhn?sosok=0&page="+page;
				//html변수에 전체 페이지 담아오기
				html = Jsoup.connect(url).get();
				//link 변수에 각각 상장회사별 정보가 들어있는 링크 담아오기
				links = html.getElementsByClass("tltle");
				//nums 변수에 숫자정보 담아오기
				nums = html.getElementsByClass("number");
				//nums자르기
				numsArr = nums.toString().split("<td class=\"number\">");
				for(int i=0;i<numsArr.length;i++) {
					numsStr += numsArr[i];
				}
				numsArr = numsStr.split("</td>");
				
				//link자르기
				linkArr = links.toString().split("<a href=\"");
				for(int i=0;i<linkArr.length;i++) {
					linkStr += linkArr[i];
				}
				linkArr = linkStr.split("\" class=\"tltle\">");
				linkStr = null;
				for(int i=0;i<linkArr.length;i++) {
					linkStr+=linkArr[i];
				}
				linkArr = linkStr.split("</a>");
				for(int i=0;i<linkArr.length;i++) {
					dto = new StockDTO();
					link = linkArr[i].substring(0, 27);
					company = linkArr[i].substring(27);
					dto.setLink(link);
					dto.setCompany(company);
					for(int j=0;j<numsArr.length/10;j++) {
						pPrice = numsArr[j*10];
						yesterdayToday = numsArr[j*10+1];
						upDown = numsArr[j*10+2];
						windowPrice = numsArr[j*10+3];
						totalPrice = numsArr[j*10+4];
						amount = numsArr[j*10+5];
						foreigner = numsArr[j*10+6];
						volume = numsArr[j*10+7];
						per = numsArr[j*10+8];
						roe = numsArr[j*10+9];
						
						dto.setpPrice(pPrice);
						dto.setYesterdayToday(yesterdayToday);
						dto.setUpDown(upDown);
						dto.setWindowPrice(windowPrice);
						dto.setTotalPrice(totalPrice);
						dto.setAmount(amount);
						dto.setForeigner(foreigner);
						dto.setVolume(volume);
						dto.setPer(per);
						dto.setRoe(roe);
						dto.setToron(toron);
						dto.setTrade(false);
						
						dao.insert(dto);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
