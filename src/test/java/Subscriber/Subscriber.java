package Subscriber;

import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

import Client.Client;

public class Subscriber {
	
		
	public static void SubscribeToTopic(String topic,Mqtt5BlockingClient client) {
		client.subscribeWith()
        .topicFilter(topic)
        .send();
	}
	}

