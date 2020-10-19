package com.example.Phone2Action.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Phone2Action.dao.SubscriptionRepository;
import com.example.Phone2Action.domain.IncomingMessage;
import com.example.Phone2Action.domain.Subscriber;
import com.example.Phone2Action.service.Messenger;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/subscribers")
public class SubscriptionController {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    private List<Subscriber> subscriberList;

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    @Autowired
    private Messenger messenger;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Subscriber> addSubscribers(@RequestBody Subscriber subscriber) {

        if (subscriber != null && subscriber.valid() && subscriber.validPhoneNumber()) {
        	subscriber.setPhoneNumber("+1" + subscriber.getPhoneNumber());
        	subscriber = subscriptionRepository.save(subscriber);
        	log.info("Saved Subscriber="+subscriber.toString());
        	return ResponseEntity.status(HttpStatus.CREATED).body(subscriber);
        	
        }
        else {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<Subscriber>> getSubscribers() {
    	subscriberList = subscriptionRepository.findAll();
         if (subscriberList.isEmpty())
             return ResponseEntity.status(HttpStatus.OK).build();
         
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriberList);
    }
    
    @RequestMapping (method = RequestMethod.DELETE)
    public ResponseEntity<List<Subscriber>> deleteSubscribers() {
        subscriptionRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();          
      }
    
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ResponseEntity<List<Subscriber>> messageSubscribers(@RequestBody IncomingMessage message) {
    	subscriberList = subscriptionRepository.findAll();
         if (subscriberList.isEmpty() || message == null )
        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         else {
        	 if(!messenger.messageSubscribers(message, subscriberList)) {
        		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	 }
        	 return ResponseEntity.status(HttpStatus.OK).body(subscriberList); 
         }
    }
}
