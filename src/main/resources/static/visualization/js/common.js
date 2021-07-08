//设置mqtt连接
var mqttConfigs = {
	clientId: 'xi-an' + Math.random(),
	// protocolVersion: 5,
	port: 9001,
	username: 'reeve',
	password: '02122633',
}

function getMqttClient(){
	return mqtt.connect('wss://www.reevey.cn/mqtt', mqttConfigs)
}