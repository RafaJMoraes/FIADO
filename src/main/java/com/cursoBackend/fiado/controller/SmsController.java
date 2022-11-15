package com.cursoBackend.fiado.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@RestController
public class SmsController {

        @GetMapping(value = "api/sendSMS")
        public ResponseEntity<String> sendSMS() {

                Twilio.init("AC4f6bfb551f92b7c182ac7540ca20b7cb","59ebde9fd414f9d2271028970a898374");

                Message.creator(new PhoneNumber("+5514981111111"),
                                new PhoneNumber("+13029244429"), "Hello from Twilio 📞").create();

                return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
        }
}
