package com.vdab.retrying.api.controller;

import com.vdab.retrying.service.RetryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RetryController {
    final RetryService retryService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        log.info("test endpoint executed");

        retryService.retryTest();

        return new ResponseEntity<>("test 123", HttpStatus.OK);
    }

    @GetMapping(value = "/success")
    public ResponseEntity<String> success() {
        log.info("success endpoint executed");

        return new ResponseEntity<>("success 123", HttpStatus.OK);
    }
}
