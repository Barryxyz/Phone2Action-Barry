package com.example.Phone2Action.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Phone2Action.domain.Subscriber;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscriber,String> {
}
