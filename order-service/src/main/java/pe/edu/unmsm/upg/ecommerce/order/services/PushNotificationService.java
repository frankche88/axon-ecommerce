package pe.edu.unmsm.upg.ecommerce.order.services;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.upg.ecommerce.order.application.message.firebase.FirebaseCloudMessagingService;
import pe.edu.unmsm.upg.ecommerce.order.application.message.firebase.PushNotificationRequest;

@Service
public class PushNotificationService {
	
	private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
    private FirebaseCloudMessagingService fcmService;

    public PushNotificationService(FirebaseCloudMessagingService fcmService) {
        this.fcmService = fcmService;
    }

    public void sendPushNotification(PushNotificationRequest request) {
        try {
            fcmService.sendMessage(getOrderReadyPayload(), request);
        } catch (InterruptedException | ExecutionException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(getOrderReadyPayload(), request);
        } catch (InterruptedException | ExecutionException e) {
            logger.error(e.getMessage());
        }
    }


    private Map<String, String> getOrderReadyPayload() {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("body", "Your order is ready");
        pushData.put("title", "Hey!!");
        pushData.put("click_action", "FLUTTER_NOTIFICATION_CLICK");
        return pushData;
    }



}
