package com.ykm.myrule;

import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {

	public IRule getRile(){
		return new RandomRule();  //默认试轮询，自定义为随机
	}
}
