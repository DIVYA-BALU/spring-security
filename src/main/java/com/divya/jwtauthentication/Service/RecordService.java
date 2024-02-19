package com.divya.jwtauthentication.Service;

import java.util.List;

import com.divya.jwtauthentication.Model.Record;

public interface RecordService {
    
    Record saveRecord(Record record);
    List<Record> getAllRecords();
    Record updateRecord(Record record);
    void deleteRecord(String id);
}
