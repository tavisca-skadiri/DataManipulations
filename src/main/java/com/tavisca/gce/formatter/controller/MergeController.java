package com.tavisca.gce.formatter.controller;

import com.tavisca.gce.formatter.model.mergemodel.MergedData;
import com.tavisca.gce.formatter.service.mergeservice.MergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MergeController {
    @Autowired
    private MergeService mergeService;

    @GetMapping(path = "/merged")
    public ResponseEntity<Object> getMergedData() {
        List<MergedData> list = mergeService.getMergedData();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/merged/json")
    public ResponseEntity<Object> getMergedJson() {
        List<MergedData> list = mergeService.getMergedData();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/merged/xml")
    public ResponseEntity<Object> getMergedXml() {
        List<MergedData> list = mergeService.getMergedData();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}