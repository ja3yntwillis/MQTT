package Publisher;

import static java.nio.charset.StandardCharsets.UTF_8;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

import Client.Client;
import Subscriber.Subscriber;

public class Publisher {
	public static void publishMessages(String topic,String message,Mqtt5BlockingClient client)
	{
		client.publishWith()
        .topic(topic)
        .payload(UTF_8.encode(message))
        .send();
	}
	
}
