package com.ykm.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced //spring Cloud Ribbon 是基于Netflix Ribbon实现的一套客户端   负载均衡的工具 。使用该注解开启(默认是轮询)
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@Bean//自己选择使用什么方式访问服务
	public IRule getRandomRule(){
		return new RoundRobinRule();//轮询
//		return new RandomRule();//随机
//		return new AvailabilityFilteringRule();//会优先过滤访问故障、并发数量超过阀值的服务，对剩下的进行轮询
//		return new WeightedResponseTimeRule();//根据响应时间计算所有服务的权重，响应时间越快权重越大，被选中的概率越高。刚启动时，使用轮询，等统计足够后使用权重
//		return new RetryRule();//先按RoundRobinRule策略获取服务，如果获取服务失败则在指定时间内进行重试，获取可用的
//		return new BestAvailableRule();//会优先过滤由于多次访问故障而处于短路器跳闸状态的服务，燃火选者并发量较小的服务
//		return new ZoneAvoidanceRule();//默认规则，复合判断server所在区域的性能和server的可用性选者服务器
	}
	
}

//@Bean
//public UserService getRestUserService(){       ==     <bean id="userService" class="com.ykm.service.imp.UserServiceImp"></bean>
//	return new UserService();
//}

//applicationContext.xml = ConfigBean(@Configuration)