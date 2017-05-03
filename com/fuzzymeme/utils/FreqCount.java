package com.fuzzymeme.utils;


public class FreqCount<T> {
	
	private int count = 0;
	private final T payload;
	
	public FreqCount(T payload){
		this.payload = payload;
	}
	
	public void incr(){
		count++;
	}

	public int getCount(){
		return count;
	}
	
	public T getPayload(){
		return payload;
	}

	@Override
	public String toString() {
		return "[count=" + count + ":" + payload + "]";
	}
	
	
}
