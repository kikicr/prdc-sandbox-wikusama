package com.anabatic.sandbox.service.impl;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.sandbox.dao.SectionDao;
import com.anabatic.sandbox.service.SectionManager;
import com.anabatic.sandbox.model.Section;
@Service
public class SectionManagerImpl extends GenericManagerImpl<Section,Integer> implements SectionManager {
	private SectionDao sectionDao;
	@Autowired
	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
		this.dao=sectionDao;
	}
	@Override
	public Section save(Section object) {
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
	
		return super.save(object);
	}
}
