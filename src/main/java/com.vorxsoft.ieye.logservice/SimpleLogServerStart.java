package com.vorxsoft.ieye.logservice;

import com.coreos.jetcd.Watch;
import com.vorxsoft.ieye.logservice.util.ConfigReadUtils;
import com.vorxsoft.ieye.microservice.MicroService;
import com.vorxsoft.ieye.microservice.MicroServiceImpl;
import com.vorxsoft.ieye.microservice.WatchCallerInterface;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleLogServerStart implements WatchCallerInterface {
  @Override
  public void WatchCaller(Watch.Watcher watch) {
    System.out.println("watcher response  " + watch.listen());
  }

  private static int PORT = 8888;
  private Server server;
  private static String hostip;
  private static int ttl = 10;
  private static String dbname;
  private static String dbAddress;
  private static String serviceName = "server_log";
  private static String registerCenterName;
  private static String registerCenterAddress = "http://192.168.20.251:2379";
  //final String cfgFile = "logservice/target/classes/log_service.xml";
  private final String cfgFileName = "log_service.xml";
  private InputStream cfgFile;

  public void getConfigPath() throws FileNotFoundException {
    String tmp = String.valueOf(this.getClass().getClassLoader().getResource(cfgFileName));
    System.out.println("tmp:" + tmp);
    if (tmp.startsWith("jar"))
      cfgFile = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + cfgFileName));
    else
      cfgFile = this.getClass().getClassLoader().getResourceAsStream(cfgFileName);
  }

  public void cfgInit() throws FileNotFoundException {
    ConfigReadUtils configReadUtils = new ConfigReadUtils();
    configReadUtils.cfgInit();
    hostip = configReadUtils.getHostip();
    PORT = configReadUtils.getLogPort();
    ttl = configReadUtils.getTtl();
    registerCenterAddress = configReadUtils.getRegisterCenterAddress();
  }

  private void start() throws Exception {
    server = NettyServerBuilder.forPort(PORT).addService(new SimpleLogServer().bindService()).build();
    server.start();

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        SimpleLogServerStart.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    try {
      server.awaitTermination(2, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    final SimpleLogServerStart simpleServerStart = new SimpleLogServerStart();
    SimpleLogServer.getLogger().entry();
    simpleServerStart.cfgInit();
    MicroService myservice = new MicroServiceImpl();
    myservice.init(registerCenterAddress, simpleServerStart);
    simpleServerStart.start();
    long ret = myservice.RegisteWithHB(serviceName, hostip, PORT, ttl);
    myservice.SetWatcher(serviceName, true);
    System.out.println("leasid is " + ret);
    TimeUnit.DAYS.sleep(365 * 2000);
    SimpleLogServer.getLogger().exit();
  }

}
