package com.vorxsoft.ieye.logservice.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @Author boundlesswu
 * @Description
 * @Date 2018-03-08 8:43
 **/
public class ConfigReadUtils {
  private InputStream cfgFile;
  private final String cfgFileName = "Config.xml";
  //private final String cfgFileName = "test.xml";
  private String hostip;
  private int emsPort;
  private int logPort;
  private int blgPort;
  private int PORT;
  private String serviceName;
  private int ttl = 30;
  private String dbIp;
  private String dbPort;
  private String databaseName;
  private String dbname = "postgresql";
  private String dbAddress;
  private String dbUser;
  private String dbPasswd;
  private String driverClassName = "org.postgresql.Driver";
  private String registerCenterName = "etcd";
  private String registerCenterAddress;
  private String redisName;
  private String alarmBellUrl;
  private int alarmBellPort;
  private String alarmBellIp;
  private int activemqPort;
  private String redisIP;
  private int redisPort;
  private String activemqName;
  private String activemqIp;
  private String emailProtocol;
  private String emailServer;
  private String emailDomain;
  private String emailPort;
  private String emailUserName;
  private String emailPassword;
  private String aliyunSmsProduct;
  private String aliyunSmsDomain;
  private String aliyunSmsAccessKeyId;
  private String aliyunSmsAccessKeySecret;
  private String aliyunSmsTemplateCode;
  private String aliyunSmsSignName;

  public ConfigReadUtils() {
  }

  public InputStream getCfgFile() {
    return cfgFile;
  }

  public void setCfgFile(InputStream cfgFile) {
    this.cfgFile = cfgFile;
  }

  public String getCfgFileName() {
    return cfgFileName;
  }

  public String getHostip() {
    return hostip;
  }

  public void setHostip(String hostip) {
    this.hostip = hostip;
  }

  public int getEmsPort() {
    return emsPort;
  }

  public void setEmsPort(int emsPort) {
    this.emsPort = emsPort;
  }

  public int getLogPort() {
    return logPort;
  }

  public void setLogPort(int logPort) {
    this.logPort = logPort;
  }

  public int getBlgPort() {
    return blgPort;
  }

  public void setBlgPort(int blgPort) {
    this.blgPort = blgPort;
  }

  public int getPORT() {
    return PORT;
  }

  public void setPORT(int PORT) {
    this.PORT = PORT;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public int getTtl() {
    return ttl;
  }

  public void setTtl(int ttl) {
    this.ttl = ttl;
  }

  public String getDbIp() {
    return dbIp;
  }

  public void setDbIp(String dbIp) {
    this.dbIp = dbIp;
  }

  public String getDbPort() {
    return dbPort;
  }

  public void setDbPort(String dbPort) {
    this.dbPort = dbPort;
  }

  public String getDatabaseName() {
    return databaseName;
  }

  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }

  public String getDbname() {
    return dbname;
  }

  public void setDbname(String dbname) {
    this.dbname = dbname;
  }

  public String getDbAddress() {
    return dbAddress;
  }

  public void setDbAddress(String dbAddress) {
    this.dbAddress = dbAddress;
  }

  public String getDbUser() {
    return dbUser;
  }

  public void setDbUser(String dbUser) {
    this.dbUser = dbUser;
  }

  public String getDbPasswd() {
    return dbPasswd;
  }

  public void setDbPasswd(String dbPasswd) {
    this.dbPasswd = dbPasswd;
  }

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public String getRegisterCenterName() {
    return registerCenterName;
  }

  public void setRegisterCenterName(String registerCenterName) {
    this.registerCenterName = registerCenterName;
  }

  public String getRegisterCenterAddress() {
    return registerCenterAddress;
  }

  public void setRegisterCenterAddress(String registerCenterAddress) {
    this.registerCenterAddress = registerCenterAddress;
  }

  public String getRedisName() {
    return redisName;
  }

  public void setRedisName(String redisName) {
    this.redisName = redisName;
  }

  public String getAlarmBellUrl() {
    return alarmBellUrl;
  }

  public void setAlarmBellUrl(String alarmBellUrl) {
    this.alarmBellUrl = alarmBellUrl;
  }

  public int getAlarmBellPort() {
    return alarmBellPort;
  }

  public void setAlarmBellPort(int alarmBellPort) {
    this.alarmBellPort = alarmBellPort;
  }

  public String getAlarmBellIp() {
    return alarmBellIp;
  }

  public void setAlarmBellIp(String alarmBellIp) {
    this.alarmBellIp = alarmBellIp;
  }

  public int getActivemqPort() {
    return activemqPort;
  }

  public void setActivemqPort(int activemqPort) {
    this.activemqPort = activemqPort;
  }

  public String getRedisIP() {
    return redisIP;
  }

  public void setRedisIP(String redisIP) {
    this.redisIP = redisIP;
  }

  public int getRedisPort() {
    return redisPort;
  }

  public void setRedisPort(int redisPort) {
    this.redisPort = redisPort;
  }

  public String getActivemqName() {
    return activemqName;
  }

  public void setActivemqName(String activemqName) {
    this.activemqName = activemqName;
  }

  public String getActivemqIp() {
    return activemqIp;
  }

  public void setActivemqIp(String activemqIp) {
    this.activemqIp = activemqIp;
  }

  public String getEmailProtocol() {
    return emailProtocol;
  }

  public void setEmailProtocol(String emailProtocol) {
    this.emailProtocol = emailProtocol;
  }

  public String getEmailServer() {
    return emailServer;
  }

  public void setEmailServer(String emailServer) {
    this.emailServer = emailServer;
  }

  public String getEmailDomain() {
    return emailDomain;
  }

  public void setEmailDomain(String emailDomain) {
    this.emailDomain = emailDomain;
  }

  public String getEmailPort() {
    return emailPort;
  }

  public void setEmailPort(String emailPort) {
    this.emailPort = emailPort;
  }

  public String getEmailUserName() {
    return emailUserName;
  }

  public void setEmailUserName(String emailUserName) {
    this.emailUserName = emailUserName;
  }

  public String getEmailPassword() {
    return emailPassword;
  }

  public void setEmailPassword(String emailPassword) {
    this.emailPassword = emailPassword;
  }

  public String getAliyunSmsProduct() {
    return aliyunSmsProduct;
  }

  public void setAliyunSmsProduct(String aliyunSmsProduct) {
    this.aliyunSmsProduct = aliyunSmsProduct;
  }

  public String getAliyunSmsDomain() {
    return aliyunSmsDomain;
  }

  public void setAliyunSmsDomain(String aliyunSmsDomain) {
    this.aliyunSmsDomain = aliyunSmsDomain;
  }

  public String getAliyunSmsAccessKeyId() {
    return aliyunSmsAccessKeyId;
  }

  public void setAliyunSmsAccessKeyId(String aliyunSmsAccessKeyId) {
    this.aliyunSmsAccessKeyId = aliyunSmsAccessKeyId;
  }

  public String getAliyunSmsAccessKeySecret() {
    return aliyunSmsAccessKeySecret;
  }

  public void setAliyunSmsAccessKeySecret(String aliyunSmsAccessKeySecret) {
    this.aliyunSmsAccessKeySecret = aliyunSmsAccessKeySecret;
  }

  public String getAliyunSmsTemplateCode() {
    return aliyunSmsTemplateCode;
  }

  public void setAliyunSmsTemplateCode(String aliyunSmsTemplateCode) {
    this.aliyunSmsTemplateCode = aliyunSmsTemplateCode;
  }

  public String getAliyunSmsSignName() {
    return aliyunSmsSignName;
  }

  public void setAliyunSmsSignName(String aliyunSmsSignName) {
    this.aliyunSmsSignName = aliyunSmsSignName;
  }

  @Override
  public String toString() {
    return "CfgInit{" +
            "cfgFile=" + cfgFile +
            ", cfgFileName='" + cfgFileName + '\'' +
            ", hostip='" + hostip + '\'' +
            ", emsPort=" + emsPort +
            ", logPort=" + logPort +
            ", blgPort=" + blgPort +
            ", PORT=" + PORT +
            ", serviceName='" + serviceName + '\'' +
            ", ttl=" + ttl +
            ", dbIp='" + dbIp + '\'' +
            ", dbPort='" + dbPort + '\'' +
            ", databaseName='" + databaseName + '\'' +
            ", dbname='" + dbname + '\'' +
            ", dbAddress='" + dbAddress + '\'' +
            ", dbUser='" + dbUser + '\'' +
            ", dbPasswd='" + dbPasswd + '\'' +
            ", driverClassName='" + driverClassName + '\'' +
            ", registerCenterName='" + registerCenterName + '\'' +
            ", registerCenterAddress='" + registerCenterAddress + '\'' +
            ", redisName='" + redisName + '\'' +
            ", alarmBellUrl='" + alarmBellUrl + '\'' +
            ", alarmBellPort=" + alarmBellPort +
            ", alarmBellIp='" + alarmBellIp + '\'' +
            ", activemqPort=" + activemqPort +
            ", redisIP='" + redisIP + '\'' +
            ", redisPort=" + redisPort +
            ", activemqName='" + activemqName + '\'' +
            ", activemqIp='" + activemqIp + '\'' +
            ", emailProtocol='" + emailProtocol + '\'' +
            ", emailServer='" + emailServer + '\'' +
            ", emailDomain='" + emailDomain + '\'' +
            ", emailPort='" + emailPort + '\'' +
            ", emailUserName='" + emailUserName + '\'' +
            ", emailPassword='" + emailPassword + '\'' +
            ", aliyunSmsProduct='" + aliyunSmsProduct + '\'' +
            ", aliyunSmsDomain='" + aliyunSmsDomain + '\'' +
            ", aliyunSmsAccessKeyId='" + aliyunSmsAccessKeyId + '\'' +
            ", aliyunSmsAccessKeySecret='" + aliyunSmsAccessKeySecret + '\'' +
            ", aliyunSmsTemplateCode='" + aliyunSmsTemplateCode + '\'' +
            ", aliyunSmsSignName='" + aliyunSmsSignName + '\'' +
            '}';
  }

  public void getConfigPath() throws FileNotFoundException {
    String tmp = String.valueOf(this.getClass().getClassLoader().getResource(cfgFileName));
    System.out.println("tmp:" + tmp);
    if (tmp.startsWith("jar"))
      cfgFile = new FileInputStream(new File(".." + File.separator + cfgFileName));
    else
      cfgFile = this.getClass().getClassLoader().getResourceAsStream(cfgFileName);
  }

  public void cfgInit() throws FileNotFoundException {
    // 解析books.xml文件
    // 创建SAXReader的对象reader
    getConfigPath();
    SAXReader reader = new SAXReader();
    try {
      System.out.println("cfg file is:" + cfgFile);
      // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
      //Document document = reader.read(new File(cfgFile));
      Document document = reader.read(cfgFile);

      Element rootElt = document.getRootElement(); // 获取根节点
      System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
      Iterator dbIter = rootElt.elementIterator("database"); //获取根节点下的子节点database
      Iterator redisIter = rootElt.elementIterator("redis");//获取根节点下的子节点redis
      Iterator activeMqIter = rootElt.elementIterator("activemq");//获取根节点下的子节点activemq
      Iterator microServiceIter = rootElt.elementIterator("MicroService");//获取根节点下的子节点MicroService
      Iterator serverIter = rootElt.elementIterator("server");//获取根节点下的子节点server

      //遍历db节点
      while (dbIter.hasNext()) {
        Element tableItem = (Element) dbIter.next();
        dbIp = tableItem.elementTextTrim("dbip"); // 拿到database下的字节点dbip的值
        dbPort = tableItem.elementTextTrim("dbport");
        databaseName = tableItem.elementTextTrim("dbname");
        dbUser = tableItem.elementTextTrim("dbusername");
        dbPasswd = tableItem.elementTextTrim("dbpassword");
        dbAddress = dbIp + ":" + dbPort + "/" + databaseName;
      }

      //遍历redis节点
      while (redisIter.hasNext()) {
        Element tableItem = (Element) redisIter.next();
        redisName = tableItem.elementTextTrim("name"); // 拿到redis下的字节点name的值
        redisIP = tableItem.elementTextTrim("ip");
        redisPort = Integer.parseInt(tableItem.elementTextTrim("port"));
      }

      //遍历activemq节点
      while (activeMqIter.hasNext()) {
        Element tableItem = (Element) activeMqIter.next();
        activemqName = tableItem.elementTextTrim("name"); // 拿到activemq下的字节点name的值
        activemqIp = tableItem.elementTextTrim("ip");
        activemqPort = Integer.parseInt(tableItem.elementTextTrim("port"));
      }

      //遍历Microservice节点
      while (microServiceIter.hasNext()) {
        Element tableItem = (Element) microServiceIter.next();
        String ip = tableItem.elementTextTrim("ip");
        int port = Integer.parseInt(tableItem.elementTextTrim("port"));
        registerCenterAddress = "http://" + ip + ":" + port;
      }

      // 遍历server节点
      while (serverIter.hasNext()) {
        Element recordEless = (Element) serverIter.next();
        ttl = Integer.parseInt(recordEless.elementTextTrim("grpcttl"));
        Iterator localIter = recordEless.elementIterator("local"); // 获取子节点server下的子节点local
        Iterator emsIter = recordEless.elementIterator("ems");
        Iterator blgIter = recordEless.elementIterator("blg");
        Iterator logIter = recordEless.elementIterator("log");
        //遍历local节点
        while (localIter.hasNext()) {
          Element tableItem = (Element) localIter.next();
          hostip = tableItem.elementTextTrim("ip");
        }
        //遍历ems节点
        while (emsIter.hasNext()) {
          Element tableItem = (Element) emsIter.next();
          emsPort = Integer.parseInt(tableItem.elementText("localport")); // 获取子节点ems下的子节点localport的值
          Element itemEle = tableItem;
          Iterator alarmBellIter = itemEle.elementIterator("alarmBell");
          while (alarmBellIter.hasNext()) {
            tableItem = (Element) alarmBellIter.next();
            alarmBellIp = tableItem.elementTextTrim("ip"); // 拿到alarmBell下的字节点ip的值
            alarmBellPort = Integer.parseInt(tableItem.elementTextTrim("port"));
            alarmBellUrl = tableItem.elementTextTrim("url");
          }
        }

        while (blgIter.hasNext()) {
          Element tableItem = (Element) blgIter.next();
          blgPort = Integer.parseInt(tableItem.elementText("localport")); // 获取子节点blg下的子节点localport的值
          Element itemEle = tableItem;
          Iterator aliyunSmsIter = itemEle.elementIterator("aliyunSms");
          Iterator emailIter = itemEle.elementIterator("email");
          while (aliyunSmsIter.hasNext()) {
            tableItem = (Element) aliyunSmsIter.next();
            aliyunSmsProduct = tableItem.elementTextTrim("product");
            aliyunSmsDomain = tableItem.elementTextTrim("domain");
            aliyunSmsAccessKeyId = tableItem.elementTextTrim("accessKeyId");
            aliyunSmsAccessKeySecret = tableItem.elementTextTrim("accessKeySecret");
            aliyunSmsTemplateCode = tableItem.elementTextTrim("templateCode");
            aliyunSmsSignName = tableItem.elementTextTrim("signName");
          }
          while (emailIter.hasNext()) {
            tableItem = (Element) emailIter.next();
            emailProtocol = tableItem.elementTextTrim("protocol");
            emailServer = tableItem.elementTextTrim("server");
            emailDomain = tableItem.elementTextTrim("domain");
            emailPort = tableItem.elementTextTrim("port");
            emailUserName = tableItem.elementTextTrim("userName");
            emailPassword = tableItem.elementTextTrim("password");
          }
        }
        while (logIter.hasNext()) {
          Element tableItem = (Element) logIter.next();
          logPort = Integer.parseInt(tableItem.elementText("localport")); // 获取子节点log下的子节点localport的值
        }
      }
    } catch (DocumentException e) {
      e.printStackTrace();
      //getLogger().error(e.getMessage(), e);
    }
  }

  public static void main(String args[]) {
    String fileName = "src/res/books.xml";
    try {
      ConfigReadUtils cfgInit = new ConfigReadUtils();
      cfgInit.cfgInit();
      System.out.println(cfgInit.toString());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


}
