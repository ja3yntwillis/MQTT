package runner;

import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

import Client.Client;
import Publisher.Publisher;
import Subscriber.Subscriber;

public class RunSubscriber {
	static Mqtt5BlockingClient client=Client.connectionCheck();
	public static void main(String atfs[])
	{
		Subscriber.SubscribeToTopic("mytopic/1",client);
		//Subscriber.SubscribeToTopic("mytopic/2",client);
		Subscriber.SubscribeToTopic("mytopic/3",client);
		client.toAsync().publishes(ALL, publish -> {
		    System.out.println("Received message: at "+DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()) +
		        publish.getTopic() + " -> " +
		        UTF_8.decode(publish.getPayload().get()));
		});
		
	}

}
