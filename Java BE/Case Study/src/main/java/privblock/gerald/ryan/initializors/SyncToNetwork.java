package privblock.gerald.ryan.initializors;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import exceptions.BlocksInChainInvalidException;
import exceptions.ChainTooShortException;
import exceptions.GenesisBlockInvalidException;
import privblock.gerald.ryan.entity.Block;

public class SyncToNetwork {

	public static ArrayList<Block> getNetworkChain() throws NoSuchAlgorithmException, ChainTooShortException,
			GenesisBlockInvalidException, BlocksInChainInvalidException {
		ArrayList<Block> chain;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://localhost:8080/CaseStudy/blockchain");
		CloseableHttpResponse response;
		String response_string = "";
		try {
			response = httpclient.execute(httpGet);
			HttpEntity entity1 = response.getEntity();
			Scanner sc = new Scanner(entity1.getContent());
			while (sc.hasNext()) {
				String next = sc.nextLine();
				response_string += next;
			}
			String jsonString = response_string.replaceAll("</?[^>]+>", "").trim();
//			System.out.println(jsonString);
			chain = new Gson().fromJson(jsonString, new TypeToken<List<Block>>() {
			}.getType());
			sc.close();
			return chain;
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Block> getNetworkChain(String networkURL) throws NoSuchAlgorithmException,
			ChainTooShortException, GenesisBlockInvalidException, BlocksInChainInvalidException {
		ArrayList<Block> chain;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(networkURL);
		CloseableHttpResponse response;
		String response_string = "";
		try {
			response = httpclient.execute(httpGet);
			HttpEntity entity1 = response.getEntity();
			Scanner sc = new Scanner(entity1.getContent());
			while (sc.hasNext()) {
				String next = sc.nextLine();
				response_string += next;
			}
			String jsonString = response_string.replaceAll("</?[^>]+>", "").trim();
//	System.out.println(jsonString);
			chain = new Gson().fromJson(jsonString, new TypeToken<List<Block>>() {
			}.getType());
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		}
		return chain;
	}
}
