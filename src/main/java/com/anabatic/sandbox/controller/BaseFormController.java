package com.anabatic.sandbox.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

public class BaseFormController {
	
    @Autowired(required = false)
    Validator validator;
	
    private MessageSourceAccessor messages;
    
    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }
    
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        NumberFormat numberFormat =  NumberFormat.getNumberInstance(request.getLocale());
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);

        binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, numberFormat, true));
        binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, null, true));
        binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, null, true));
        binder.registerCustomEditor(byte[].class,  new ByteArrayMultipartFileEditor());

        SimpleDateFormat dateFormat = new SimpleDateFormat(getText("date.format", request.getLocale()));
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
        
    }
	
    public String getText(String msgKey, Locale locale) {
        return messages.getMessage(msgKey, locale);
    }
    
    
}
