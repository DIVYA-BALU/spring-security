package com.divya.jwtauthentication.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.divya.jwtauthentication.Model.Record;
import com.divya.jwtauthentication.Service.RecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('record_post')")
    public ResponseEntity<Record> saveRecord(@RequestBody Record record) {
        return ResponseEntity.ok(recordService.saveRecord(record));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('record_put')")
    public ResponseEntity<Record> updateRecord(@RequestBody Record record) {
        return ResponseEntity.ok(recordService.updateRecord(record));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('record_delete')")
    public ResponseEntity<String> deleteRecord(@RequestBody String id) {
        recordService.deleteRecord(id);
        return ResponseEntity.ok("Record deleted successfully");
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('record_get')")
    public ResponseEntity<List<Record>> getAllRecords() {
        return ResponseEntity.ok(recordService.getAllRecords());
    }
}
