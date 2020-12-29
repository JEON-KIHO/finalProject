package com.example.mapper_oracle;

import java.util.HashMap;
import java.util.List;

import com.example.domain.Criteria;

public interface StudentMapper {
	public List<HashMap<String, Object>> list(Criteria cri);
}
