package com.iyunr.pro.enums;

/**
 * 定义预约图书操作返回码的数据字典
 * 1预约成功		0	库存不足		-1重复预约	-2系统异常
 * @author Boyce Lee
 *
 */
public enum AppointStateEnum {
	SUCCESS(1, "预约成功"), NO_NUMBER(0, "库存不足"), REPEAT_APPOINT(-1, "重复预约"), INNER_ERROR(-2, "系统异常");
	
	private int state;
	private String stateInfo;
	
	private static AppointStateEnum stateOf(int index){
		for(AppointStateEnum state : AppointStateEnum.values()){
			if(state.getState() == index){
				return state;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(stateOf(0).getStateInfo());
	}
	
	private AppointStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	
	
}
