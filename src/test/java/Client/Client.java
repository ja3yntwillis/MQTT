package Client;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

import Configuration.Config;

public class Client {
	static String host = Config.host;
	static  String username = Config.username;
	static String password = Config.password;

	public static Mqtt5BlockingClient connectionCheck()
	{
		// create an MQTT client
		Mqtt5BlockingClient client = MqttClient.builder()
				.useMqttVersion5()
				.serverHost(host)
				.serverPort(8883)
				.sslWithDefaultConfig()
				.buildBlocking();

		// connect to HiveMQ Cloud with TLS and username/pw
		client.connectWith()
		.simpleAuth()
		.username(username)
		.password(UTF_8.encode(password))
		.applySimpleAuth()
		.send();
		
		return client;

	}


}
