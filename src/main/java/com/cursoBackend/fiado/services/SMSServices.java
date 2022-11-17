package com.cursoBackend.fiado.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSServices {

	@Value("${twilio.sid}")
	private String twilioSid;
	
	@Value("${twilio.key}")
	private String twilioToken;
	
	@Value("${twilio.phone.from}")
	private String twilioFrom;
	
	@Value("${twilio.phone.to}")
	private String twilioTo;
	
	public String sendSms() {
		
		String sid = twilioSid;
		String tokenTwilio = twilioToken;
		PhoneNumber phoneFrom = new PhoneNumber("3029244429");
		PhoneNumber phoneTo = new PhoneNumber(twilioTo);
		
	    Twilio.init(sid,tokenTwilio);

        Message.creator(phoneTo,phoneFrom, "Rafael não esqueça de suas compras fiadas!! ;)").create();
        
        return "Mensagem enviada com Sucesso";

	}
	
}
