package com.lambda;

import com.lambda.entity.Data;
import com.amazonaws.services.lambda.runtime.Context;

public class TestLambda {
	
//	public String status(String x) {
//		
//		int y = Integer.parseInt(x);
//		return "Responding......." + y*y ;
//	}

	public String status(Data obj, Context context) {
		
		return "Ok...... responding" + (obj.getX() + obj.getY());
	}
	
}
