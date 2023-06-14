package runner;

import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

import Client.Client;
import Publisher.Publisher;

public class PublishMessage {
	static Mqtt5BlockingClient client=Client.connectionCheck();
	public static void main(String args [])
	{
		Publisher.publishMessages("mytopic/1","joyeeta",client);
		Publisher.publishMessages("mytopic/2","jayanta",client);
		Publisher.publishMessages("mytopic/3","Piyali",client);
	}

}
