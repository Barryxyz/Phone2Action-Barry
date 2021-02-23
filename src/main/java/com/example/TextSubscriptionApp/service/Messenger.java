package com.example.TextSubscriptionApp.service;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.TextSubscriptionApp.domain.IncomingMessage;
import com.example.TextSubscriptionApp.domain.Subscriber;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Repository
public class Messenger {
	@Value("${twil.id}")
    private String ACCOUNT_SID;
	@Value("${twil.auth}")
    private String AUTH_TOKEN;
	@Value("${twil.number}")
    private String twilNumber;
	@Value("${admin.username}")
    private String username;
	@Value("${admin.password}")
    private String password;
	
    public boolean messageSubscribers(IncomingMessage incomingMessage, List<Subscriber> subscribers) {
    	if(incomingMessage != null) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            for(int i = 0; i < subscribers.size(); i++) {
            	Subscriber subscriber = subscribers.get(i);
                Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(subscriber.getPhoneNumber()),
                        new com.twilio.type.PhoneNumber(twilNumber),
                        incomingMessage.getMessage())
                    .create();
            }
            return true;
        }
    	return false;
    
    }
}
