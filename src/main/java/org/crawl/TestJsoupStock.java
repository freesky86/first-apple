package org.crawl;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestJsoupStock {

	/**
	 * 
	 * @param url 访问路径
	 * @return
	 */
	public Document getDocument(String url) {
		try {
			// 5000是设置连接超时时间，单位ms
			return Jsoup.connect(url).timeout(5000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
//		String shanghai = "https://www.banban.cn/gupiao/list_sh.html";
//		System.out.println("上证所有股票代码及名称");
//		printStock(shanghai);  // 1600
		
		String shenzhen = "https://www.banban.cn/gupiao/list_sz.html";
		System.out.println("深证所有股票代码及名称"); // 1468
		printStock(shenzhen);
		
//		String chuangyeban = "https://www.banban.cn/gupiao/list_cyb.html";
//		System.out.println("创业板所有股票代码及名称");  // 928
//		printStock(chuangyeban);
		
		
	}
	
	public static void printStock(String url) {
		TestJsoupStock t = new TestJsoupStock();
		Document doc = t.getDocument(url);
		// 获取目标HTML代码
		Elements elements1 = doc.select("[class=u-postcontent cz]");
		// 今天
		Elements elements2 = elements1.select("a");
		for (int i = 0; i < elements2.size(); i++) {
			String stock = elements2.get(i).text();
			System.out.println((i+1) + " : " + stock + "-" + stock.substring(stock.length()-7, stock.length()-1));
		}
		
		
	}
}