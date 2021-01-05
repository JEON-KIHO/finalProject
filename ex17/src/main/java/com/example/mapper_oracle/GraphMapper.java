package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

public interface GraphMapper {
	// 강좌별 평균 점수
	public List<HashMap<String, Object>> cavg();
	// 학생별 평균 점수
	public List<HashMap<String, Object>> savg();
	// 학과별 학생 점수
	public List<HashMap<String, Object>> dcount();
}
