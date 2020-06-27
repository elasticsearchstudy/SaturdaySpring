package com.study.seoul.comm.vo;

import java.util.List;

import lombok.Data;

@Data
public class DataGrid {

	private List<TargetVO> data;

	public List<TargetVO> getData() {
		return data;
	}

	public void setData(List<TargetVO> data) {
		this.data = data;
	}

}
