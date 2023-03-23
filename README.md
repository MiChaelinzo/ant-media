# GameShare77
#### Plugins for Ant Media Server 
#### gameshare77.jar
To use this plugin, you will need to deploy it to the Ant Media Server plugins directory. Then, you can enable the plugin in the Ant Media Server dashboard.

Once the plugin is enabled, you can use a WebSocket client to connect to the Ant Media Server WebSocket endpoint (ws://<server-ip>:5080/WebRTCAppEE/websocket) and start sending text messages. The plugin will broadcast the messages to all other connected clients.

For audio sharing, you will need to implement additional functionality in the onMessage method to handle audio streams. You can use a third-party library such as WebRTC to handle real-time audio streaming.

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





