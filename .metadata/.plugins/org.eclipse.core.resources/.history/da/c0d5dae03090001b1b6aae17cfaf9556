package pubsub;

import java.util.Arrays;
import java.util.Collections;

import org.jetbrains.annotations.NotNull;

import com.google.gson.JsonElement;
import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.PubNubException;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.enums.PNStatusCategory;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.message_actions.PNMessageAction;
import com.pubnub.api.models.consumer.objects_api.channel.PNChannelMetadataResult;
import com.pubnub.api.models.consumer.objects_api.membership.PNMembershipResult;
import com.pubnub.api.models.consumer.objects_api.uuid.PNUUIDMetadataResult;
import com.pubnub.api.models.consumer.presence.PNSetStateResult;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;
import com.pubnub.api.models.consumer.pubsub.PNSignalResult;
import com.pubnub.api.models.consumer.pubsub.files.PNFileEventResult;
import com.pubnub.api.models.consumer.pubsub.message_actions.PNMessageActionResult;

/*
 * This is an important class made by me (Gerald). Can't call it pubnub because that's taken by pubnub itself. 
 * Use this class to create your pubnub instances.  
 * 
 * This class handles the publish/subscribe layer of the application, providing communication between the nodes of the blockchain network.
 */
public class PubNubApp {
	private static String publish_key = "pub-c-74f31a3f-e3da-4cbe-81a6-02e2ba8744bd";
	private static String subscribe_key = "sub-c-1e6d4f2c-9012-11eb-968e-467c259650fa";

	/*
	 * Not being used, may want to implement later
	 */
	public PubNubApp(PNConfiguration pnconfiguration) {
		this.publish_key = "pub-c-74f31a3f-e3da-4cbe-81a6-02e2ba8744bd";
		this.subscribe_key = "sub-c-1e6d4f2c-9012-11eb-968e-467c259650fa";
	}

	/*
	 * used experimentally
	 */
	public PubNubApp() {

	}

	public static PubNub createConfiguredPubNubInstance() {
		PNConfiguration pnConfiguration = new PNConfiguration();
		pnConfiguration.setSubscribeKey(subscribe_key);
		pnConfiguration.setPublishKey(publish_key);
		pnConfiguration.setUuid("sdfdvsdvsdv"); // unique UUID

		return new PubNub(pnConfiguration);

	}

	public static void publishMessageToChannel(Object message, String channel) throws PubNubException {
		PNConfiguration pnConfiguration = new PNConfiguration();
		pnConfiguration.setSubscribeKey(subscribe_key);
		pnConfiguration.setPublishKey(publish_key);
		pnConfiguration.setUuid("sdfdvsdvsdv"); // unique UUID

		PubNub pubnub = new PubNub(pnConfiguration);

		String TEST_CHANNEL = "TEST_CHANNEL";
		pubnub.addListener(new PubNubSubCallback());
		pubnub.subscribe().channels(Collections.singletonList(channel));
		pubnub.publish().channel(channel).message(message).sync();
	}

	public static void main(String[] args) throws PubNubException, InterruptedException {
		System.out.println("Running pubnub main");
		PNConfiguration pnConfiguration = new PNConfiguration();
		pnConfiguration.setSubscribeKey(subscribe_key);
		pnConfiguration.setPublishKey(publish_key);
		pnConfiguration.setUuid("sdfdvsdvsdv"); // unique UUID

		PubNub pubnub = new PubNub(pnConfiguration);

		final String TEST_CHANNEL = "TEST_CHANNEL LynyrdSkynder";

		pubnub.addListener(new PubNubSubCallback());

		pubnub.subscribe().channels(Collections.singletonList(TEST_CHANNEL)).execute();
		Thread.sleep(1000);

		pubnub.publish().channel(TEST_CHANNEL).message(new String("Test message led zeppelin")).sync();
		System.out.println("End run");
		//
//		pubnub.addListener(new SubscribeCallback() {
//		    @Override
//		    public void status(PubNub pubnub, PNStatus status) {
//		        if (status.getCategory() == PNStatusCategory.PNConnectedCategory){
//		            complexData data = new complexData();
//		            data.fieldA = "Awesome";
//		            data.fieldB = 10;
//		            pubnub.setPresenceState()
//		                .channels(Arrays.asList("awesomeChannel"))
//		                .channelGroups(Arrays.asList("awesomeChannelGroup"))
//		                .state(data).async(new PNCallback<PNSetStateResult>() {
//		                    @Override
//		                    public void onResponse(PNSetStateResult result, PNStatus status) {
//		                        // handle set state response
//		                    }
//		                });
//		        }
//		    }
//
//		    @Override
//		    public void message(PubNub pubnub, PNMessageResult message) {
//
//		    }
//
//		    @Override
//		    public void presence(PubNub pubnub, PNPresenceEventResult presence) {
//
//		    }
//		});
	}

}
