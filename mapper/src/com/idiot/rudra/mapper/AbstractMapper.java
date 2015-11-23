package com.idiot.rudra.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapper<S, D> implements IMapper<S, D> {

	public AbstractMapper() {
		addMyChild();
	}
	
	public void addMyChild() {
		// should be implemented by child if it has children
	}

	private List<IMapper<S, D>> childList = new ArrayList<>();
	
	public void addChild(IMapper<S, D> mapper){
		childList.add(mapper);
	}
		
	
	@Override
	public D map(S s, D d) {
		mapInternal(s, d);
		
		mapChild(s, d);
		
		return d;
	}

	private void mapChild(S s, D d) {
		for(IMapper<S, D> mapper : childList){
			mapper.map(s, d);
		}
		
	}

	public abstract void mapInternal(S s, D d);
		
	}

