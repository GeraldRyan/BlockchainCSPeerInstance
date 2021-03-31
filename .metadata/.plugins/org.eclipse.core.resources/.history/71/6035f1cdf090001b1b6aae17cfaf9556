package privblock.gerald.ryan.mains;

import java.util.Collections;

import com.pubnub.api.PubNub;
import com.pubnub.api.PubNubException;

import privblock.gerald.ryan.entity.Block;
import pubsub.PubNubApp;
import pubsub.PubNubSubCallback;

/*
 * This is for playing around. Could be called Dev main
 */
public class PlayMain {

	public static void main(String[] args) throws PubNubException, InterruptedException {
		System.out.println("Begin");
//		PubNub pn = PubNubApp.createConfiguredPubNubInstance();
//		pn.addListener(new PubNubSubCallback());
//		pn.subscribe().channels(Collections.singletonList("Ghostcoin")).execute();
//		try {
//			pn.publish().channel("Ghostcoin").message("THIS").sync();
//		} catch (PubNubException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		PubNubApp pubnub = new PubNubApp();
		Thread.sleep(1000);
		pubnub.publish("general", "World 0");
		System.out.println("End");
		pubnub.publish("Hello", "Won't see 1");
		Thread.sleep(1000);
		pubnub.subscribe("Hello");
		pubnub.publish("TEST_CHANNEL", "from test channel");
		pubnub.publish("BLOCK_CHANNEL", "from BLOCK channel");
		Thread.sleep(1000);
		Thread.sleep(1000);
		pubnub.publish("Hello", "Will see 2");
		Thread.sleep(1000);
		pubnub.unsubscribe("Hello");
		Thread.sleep(1000);
		pubnub.publish("Hello", "Won't see 3");
		pubnub.publish("general", new String[] { "Dance", "With", "Me" });
		pubnub.publish(pubnub.CHANNELS.get("BLOCK"), "I'm in the block");
		pubnub.publish(pubnub.CHANNELS.get("BLOCK"), Block.genesis_block());

	}

}
