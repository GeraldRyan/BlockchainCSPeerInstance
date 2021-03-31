package privblock.gerald.ryan.mains;

import java.util.Collections;

import com.pubnub.api.PubNub;
import com.pubnub.api.PubNubException;

import pubsub.PubNubApp;
import pubsub.PubNubSubCallback;

/*
 * This is for playing around. Could be called Dev main
 */
public class PlayMain {

	public static void main(String[] args) {
		System.out.println("Begin");
		PubNub pn = PubNubApp.createConfiguredPubNubInstance();
		pn.addListener(new PubNubSubCallback());
		pn.subscribe().channels(Collections.singletonList("Ghostcoin")).execute();
		try {
			pn.publish().channel("Ghostcoin").message("THIS").sync();
		} catch (PubNubException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End");
	}

}
