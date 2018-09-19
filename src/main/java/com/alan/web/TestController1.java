package com.alan.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

@Controller
@RequestMapping("/test")
public class TestController1 {
	public static final Logger logger = LoggerFactory.getLogger(TestController1.class);
     
    /**使用RocketMq的生产者*/
    @Autowired
    private DefaultMQProducer defaultMQProducer;


	
	public void test() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		String msg = "demo msg test";
        logger.info("开始发送消息："+msg);
        Message sendMsg = new Message("DemoTopic","DemoTag",msg.getBytes());
        //默认3秒超时
        SendResult send = defaultMQProducer.send(sendMsg);
        logger.info("消息发送响应信息："+send.toString());
	}

}
