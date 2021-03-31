package privblock.gerald.ryan.mains;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ApacheHTTPMain {

	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://localhost:8080/CaseStudy/blockchain/");
		CloseableHttpResponse response1;
		try {
			response1 = httpclient.execute(httpGet);
			System.out.println(response1.getStatusLine());
//			System.out.println(response1.toString());
			HttpEntity entity1 = response1.getEntity();
			Scanner sc = new Scanner(entity1.getContent());
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
			System.out.println(entity1.getContent());

		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

	}

}
