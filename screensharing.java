import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;

import io.antmedia.webrtc.api.IWebRTCAdaptor;
import io.antmedia.webrtc.api.IWebRTCAdaptorListener;
import io.antmedia.webrtc.api.IWebRTCMediaStream;
import io.antmedia.webrtc.api.WebRTCAdaptor;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ScreenCaptureApp extends Application implements IWebRTCAdaptorListener {

    private IWebRTCAdaptor webRTCAdaptor;
    private IWebRTCMediaStream webRTCMediaStream;
    private ImageView imageView;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        imageView = new ImageView();
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        webRTCAdaptor = new WebRTCAdaptor(this);
        webRTCAdaptor.setWebRTCServerAddress("wss://localhost:5443/WebRTCAppEE/websocket");
        webRTCAdaptor.setApplicationName("WebRTCAppEE");
        webRTCAdaptor.setStreamName("screen");
      
        try {
        webRTCAdaptor.init();
        webRTCAdaptor.registerWebRTCAdaptorListener(this);
        }
// Start the screen capture task
Thread screenCaptureThread = new Thread(() -> {
    try {
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(0, 0, 800, 600);
        while (!Thread.currentThread().isInterrupted()) {
            BufferedImage image = robot.createScreenCapture(screenRect);
            javafx.scene.image.Image fxImage = SwingFXUtils.toFXImage(image, null);
            imageView.setImage(fxImage);
            webRTCMediaStream.addVideoTrack(fxImage, false);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
});
screenCaptureThread.start();

// Stop the screen capture task when the application is closed
primaryStage.setOnCloseRequest(event -> {
    screenCaptureThread.interrupt();
    webRTCAdaptor.unregisterWebRTCAdaptorListener(this);
    try {
        webRTCAdaptor.stop();
    } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
    }
});
