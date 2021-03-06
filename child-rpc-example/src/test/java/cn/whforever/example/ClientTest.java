package cn.whforever.example;

import cn.whforever.core.config.ClientConfig;
import cn.whforever.core.protocol.netty.client.NettyClientAbstract;
import cn.whforever.core.proxy.ClientProxy;
import cn.whforever.core.serialize.AbstractSerializer;
import cn.whforever.example.service.HelloService;

/**
 * @author wuhf
 * @Date 2018/9/1 18:31
 **/
public class ClientTest {

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setHost("127.0.0.1")
                .setPort(5201)
                .setTimeoutMillis(100000)
                .setSerializer(AbstractSerializer.SerializeEnum.HESSIAN.serializer);
        ClientProxy clientProxy = new ClientProxy(clientConfig,new NettyClientAbstract(),HelloService.class);
        for (int i = 0; i < 10; i++) {
            HelloService helloService = (HelloService) clientProxy.refer();
            System.out.println(helloService.sayHi());
        }
    }
}
