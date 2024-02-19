package com.divya.jwtauthentication.Service.Imp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.divya.jwtauthentication.Model.Record;
import com.divya.jwtauthentication.Repository.RecordRepository;
import com.divya.jwtauthentication.Service.RecordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecordServiceImp implements RecordService{

    private final RecordRepository recordRepository;

	@Override
	public Record saveRecord(Record record) {
        return recordRepository.save(record);
	}

	@Override
	public List<Record> getAllRecords() {
		return recordRepository.findAll();
	}

	@Override
	public Record updateRecord(Record record) {
        return recordRepository.save(record);
	}

	@Override
	public void deleteRecord(String id) {
        recordRepository.deleteById(id);
	}
    
}
