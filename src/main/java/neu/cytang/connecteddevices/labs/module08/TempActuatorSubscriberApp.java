package neu.cytang.connecteddevices.labs.module08;

import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import com.ubidots.ApiClient;
import com.ubidots.DataSource;
import com.ubidots.Variable;

import neu.ctang.connecteddevices.common.DataUtil;
import neu.ctang.connecteddevices.common.SensorData;
import neu.ctang.connecteddevices.labs.module06.MqttClientConnector;
//import neu.ctang.connecteddevices.labs.module06.MqttPubClientTestApp;

public class TempActuatorSubscriberApp {
	private static final Logger _Logger = Logger.getLogger(TempActuatorSubscriberApp.class.getName());
	private static TempActuatorSubscriberApp _App;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_App = new TempActuatorSubscriberApp();
		try {
			_App.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// params
	private MqttClientConnector _mqttClient;

	// constructors
	public TempActuatorSubscriberApp() {
		super();
	}

	// public methods
	public void start() throws MqttPersistenceException, MqttException, InterruptedException {

		//_mqttClient = new MqttClientConnector();
		_mqttClient = new MqttClientConnector("ssl://industrial.api.ubidots.com:8883","BBFF-B7HsNg1Sv3UESmoikX8oyyNxyx4jts","/Users/cytang/program/connected devices/ubidots_cert.pem");
		_mqttClient.connect();
		String topicName = "/v1.6/devices/tcydevice/tempactuator";
		
		_mqttClient.subscribeToTopic(topicName,1);

	}
}
