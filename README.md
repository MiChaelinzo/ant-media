# GameShare77
#### Plugins for Ant Media Server 
#### gameshare77.jar
To use this plugin, you will need to deploy it to the Ant Media Server plugins directory. Then, you can enable the plugin in the Ant Media Server dashboard.

Once the plugin is enabled, you can use a WebSocket client to connect to the Ant Media Server WebSocket endpoint (ws://<server-ip>:5080/WebRTCAppEE/websocket) and start sending text messages. The plugin will broadcast the messages to all other connected clients.

For audio sharing, you will need to implement additional functionality in the onMessage method to handle audio streams. You can use a third-party library such as WebRTC to handle real-time audio streaming.

 This code is an implementation of a WebSocket handler for the Ant Media Server. Specifically, it is a plugin that handles player communication. When a player connects to the Ant Media Server, this plugin adds the player's session to a set of active sessions. When a player disconnects, this plugin removes the player's session from the set of active sessions. When a player sends a message, this plugin broadcasts the message to all other active sessions.

To use this code, you need to add it as a plugin to your Ant Media Server configuration. You can do this by placing the compiled plugin JAR file in the plugins directory of your Ant Media Server installation. You also need to modify the server.xml configuration file to include the plugin configuration. You can refer to the Ant Media Server documentation for more details on how to configure plugins.

Once the plugin is configured and running, it will handle player communication for your Ant Media Server. Players will be able to send messages to each other using WebSocket connections. Additionally, if a player sends a message starting with "AUDIO:", this plugin will broadcast the audio data to all other active sessions.
 
 #### screensharing.java
  
  #### Description
The start method sets up the JavaFX application by creating an ImageView object to display the captured screen image. It also initializes the Ant Media Server WebRTC adaptor object with the server address, application name, and stream name.

The screenCaptureThread is a separate thread that uses the Robot class to capture the screen at regular intervals and convert the captured image to a JavaFX image. The webRTCMediaStream object is then used to add the video track to the WebRTC stream for broadcasting to viewers.

The setOnCloseRequest method is used to stop the screen capture thread and unregister the WebRTC listener when the application is closed.

To use this code with Ant Media Server, you can create a new plugin by implementing the IAntMediaPlugin interface and adding the necessary dependencies in your pom.xml file. Then you can use the WebRTCAdaptor object to establish a connection to your Ant Media Server instance and stream the captured screen to viewers.

#### Here are the step-by-step instructions to use the code above:

Install Ant Media Server (AMS) on your server or local machine.


Replace the following values in the code with your own values:

- 1.) Replace wss://localhost:5443/WebRTCAppEE/websocket with the URL of your AMS server's WebRTC endpoint (e.g., wss://yourdomain.com/WebRTCAppEE/websocket).
- 2.)Replace screen with a unique name for your screen share stream.
-3.) Update the Rectangle constructor to match the size of your screen that you want to capture.
- 4.) Implement the onJoined and onError methods to handle WebRTC client connections and errors, respectively.
Build and run your project.

- 5.) Open your web browser and navigate to your AMS server's WebRTC endpoint (e.g., https://yourdomain.com/WebRTCAppEE/index.html).

- 6.) On the webpage, enter the name of the screen share stream you created in step 4 and click the "Start" button.

- 7.) You should now see the screen capture from the machine running the code displayed in the browser.

- 8.) To stop the screen share, simply close the JavaFX application window.

That's it!





