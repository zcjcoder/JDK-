import service.HelloService;
import service.HelloServiceNo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        HelloService helloService=new HelloService();
        
        ClassLoader classLoader=helloService.getClass().getClassLoader();

        Class[] interfaces = helloService.getClass().getInterfaces();

        InvocationHandler logHandler=new LogHandler(helloService);

        HelloServiceNo proxy= (HelloServiceNo) Proxy.newProxyInstance(classLoader,interfaces,logHandler);
        proxy.say();

    }
}
