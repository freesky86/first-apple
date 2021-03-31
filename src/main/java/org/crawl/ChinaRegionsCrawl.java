package org.crawl;

/**
 * https://developer.51cto.com/art/202010/627897.htm
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONArray;

public class ChinaRegionsCrawl {
	// ��Ҫץȡ����ҳ��ַ
	private static final String URL = "http://www.mca.gov.cn//article/sj/xzqh/2020/202006/202008310601.shtml";

	public static void main(String[] args) throws IOException {
		List<ChinaRegionsInfo> regionsInfoList = new ArrayList<>();
		// ץȡ��ҳ��Ϣ
		Document document = Jsoup.connect(URL).get();
		// ��ȡ��ʵ��������
		Element element = document.getElementsByTag("tbody").get(0);
		String provinceCode = "";// ʡ������
		String cityCode = "";// �м�����
		if (Objects.nonNull(element)) {
			Elements trs = element.getElementsByTag("tr");
			for (int i = 3; i < trs.size(); i++) {
				Elements tds = trs.get(i).getElementsByTag("td");
				if (tds.size() < 3) {
					continue;
				}
				Element td1 = tds.get(1);// �����������
				Element td2 = tds.get(2);// ������������
				if (StringUtils.isNotEmpty(td1.text())) {
					if (td1.classNames().contains("xl7030796")) {
						if (td2.toString().contains("span")) {
							// �м�
							ChinaRegionsInfo chinaRegions = new ChinaRegionsInfo();
							chinaRegions.setCode(td1.text());
							chinaRegions.setName(td2.text());
							chinaRegions.setType(2);
							chinaRegions.setParentCode(provinceCode);
							regionsInfoList.add(chinaRegions);
							cityCode = td1.text();
						} else {
							// ʡ��
							ChinaRegionsInfo chinaRegions = new ChinaRegionsInfo();
							chinaRegions.setCode(td1.text());
							chinaRegions.setName(td2.text());
							chinaRegions.setType(1);
							chinaRegions.setParentCode("");
							regionsInfoList.add(chinaRegions);
							provinceCode = td1.text();
						}

					} else {
						// �������ؼ�
						ChinaRegionsInfo chinaRegions = new ChinaRegionsInfo();
						chinaRegions.setCode(td1.text());
						chinaRegions.setName(td2.text());
						chinaRegions.setType(3);
						chinaRegions.setParentCode(StringUtils.isNotEmpty(cityCode) ? cityCode : provinceCode);
						regionsInfoList.add(chinaRegions);
					}
				}
			}
		}
		// ��ӡ���
		System.out.println(JSONArray.toJSONString(regionsInfoList));
	}

}
