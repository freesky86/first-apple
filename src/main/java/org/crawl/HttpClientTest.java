package org.crawl;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * https://www.cnblogs.com/sam-uncle/p/10908567.html
 * @author freesky
 *
 */

public class HttpClientTest {
	public static void main(String[] args) {
        //1.����httpclient���൱�ڸô�һ�������
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.����get�����൱�����������ַ������ ��ַ
        HttpGet request = new HttpGet("https://www.cnblogs.com/");
        try {
            //3.ִ��get�����൱���������ַ�����ûس���
            response = httpClient.execute(request);
            
            //4.�ж���Ӧ״̬Ϊ200�����д���
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.��ȡ��Ӧ����
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(html);
            } else {
                //�������״̬����200������404��ҳ�治���ڣ��ȣ��������������������
                System.out.println("����״̬����200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.�ر�
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }
}
