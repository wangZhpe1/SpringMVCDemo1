package com.wzp.binder;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class DateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=format.parse(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setValue(date);
	}
	
	@Override
	public String getAsText() {
		Date date=(Date) getValue();
		if(date==null){
			date=new Date();
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
