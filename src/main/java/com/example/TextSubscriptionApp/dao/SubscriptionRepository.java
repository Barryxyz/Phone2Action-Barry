package com.example.TextSubscriptionApp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.TextSubscriptionApp.domain.Subscriber;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscriber,String> {
}
