package org.crawl;

/**
 * https://blog.csdn.net/sinat_35626559/article/details/78285007
 * @author freesky
 *
 */

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestJsoup {

	/**
	 * 
	 * @param url ����·��
	 * @return
	 */
	public Document getDocument(String url) {
		try {
			// 5000���������ӳ�ʱʱ�䣬��λms
			return Jsoup.connect(url).timeout(5000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		TestJsoup t = new TestJsoup();
		Document doc = t.getDocument("http://www.weather.com.cn/weather/101230101.shtml");
		// ��ȡĿ��HTML����
		Elements elements1 = doc.select("[class=t clearfix]");
		// ����
		Elements elements2 = elements1.select("[class=sky skyid lv1 on]");
		String today = elements2.get(0).text();
		System.out.println("���������� " + today);

		// ����
		Elements elements3 = elements1.select("h1");
		String number = elements3.get(0).text();
		System.out.println("���ڣ� " + number);

		// ����
		Elements elements4 = elements1.select("[class=wea]");
		String rain = elements4.get(0).text();
		System.out.println("������ " + rain);

		// ����¶�
		Elements elements5 = elements1.select("span");
		String highTemperature = elements5.get(0).text() + "��C";
		System.out.println("����£�" + highTemperature);

		// ����¶�
		Elements elements6 = elements1.select(".tem i");
		String lowTemperature = elements6.get(0).text();
		System.out.println("����£�" + lowTemperature);

		// ����
		Elements elements7 = elements1.select(".win i");
		String wind = elements7.get(2).text();
		System.out.println("������" + wind);
	}
}