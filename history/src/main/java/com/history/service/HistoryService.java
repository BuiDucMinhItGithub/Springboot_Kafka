package com.history.service;

import com.history.model.History;
import com.history.repo.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

  @Autowired
  HistoryRepo historyRepo;

  public String insert(History history){
    historyRepo.insert(history);
    return history.getId();
  }
}
