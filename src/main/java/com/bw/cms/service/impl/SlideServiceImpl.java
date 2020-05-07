package com.bw.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.cms.dao.SlideMapper;
import com.bw.cms.domain.Slide;
import com.bw.cms.service.SlideService;

@Service
public class SlideServiceImpl implements SlideService {

	@Resource
	private SlideMapper slideMapper;
	@Override
	public List<Slide> selects() {
		return slideMapper.selects();
	}

}
