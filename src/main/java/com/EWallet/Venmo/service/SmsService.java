package com.EWallet.Venmo.service;
import com.EWallet.Venmo.controller.AccountController;
import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Value("${Account_SID}")
    String Account_SID;
    @Value("${Auth_Token}")
    String Auth_Token;

    private final static Logger logger = LoggerFactory.getLogger(SmsService.class);


    @PostConstruct
    public void init() {
        Twilio.init(Account_SID, Auth_Token);
        logger.info("Twilio initialized with account SID: {}", Account_SID);
    }

    public void sendSms(String toPhoneNumber, String message) {
        try {

            Message.creator(
                    new PhoneNumber(toPhoneNumber),
                    new PhoneNumber("+19472215612"),
                    message
            ).create();

            logger.info("SMS sent successfully to {}", toPhoneNumber);
        } catch (TwilioException e) {
            logger.error("Failed to send SMS to {}: {}", toPhoneNumber, e.getMessage());
            throw new RuntimeException("Failed to send SMS notification", e);
        }
    }
}
