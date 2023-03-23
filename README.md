# GameShare77
#### Plugins for Ant Media Server 
To use this plugin, you will need to package it as a JAR file and deploy it to the Ant Media Server plugins directory. Then, you can enable the plugin in the Ant Media Server dashboard.

Once the plugin is enabled, you can use a WebSocket client to connect to the Ant Media Server WebSocket endpoint (ws://<server-ip>:5080/WebRTCAppEE/websocket) and start sending text messages. The plugin will broadcast the messages to all other connected clients.

For audio sharing, you will need to implement additional functionality in the onMessage method to handle audio streams. You can use a third-party library such as WebRTC to handle real-time audio streaming.



