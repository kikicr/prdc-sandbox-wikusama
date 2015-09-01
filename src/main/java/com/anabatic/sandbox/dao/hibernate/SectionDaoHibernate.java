package com.anabatic.sandbox.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.anabatic.sandbox.dao.SectionDao;
import com.anabatic.sandbox.model.Section;
@Repository
public class SectionDaoHibernate extends GenericDaoHibernate<Section,Integer> implements SectionDao{

	public SectionDaoHibernate() {
		super(Section.class);
		// TODO Auto-generated constructor stub
	}

}
