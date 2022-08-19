package javax.jmdns;

/**
 * @author yangzj
 * @date 2021/8/12
 */
public abstract class DefaultIpStack {
  public static IpStack value = IpStack.Dual;

  static {
    boolean preferIPv4Stack = Boolean.parseBoolean(System.getProperty("java.net.preferIPv4Stack", "false"));
    boolean preferIPv6Stack = Boolean.parseBoolean(System.getProperty("java.net.preferIPv6Addresses", "false"));
    if (preferIPv6Stack && !preferIPv4Stack) {
      value = IpStack.IPv6;
    } else if (preferIPv4Stack && !preferIPv6Stack) {
      value = IpStack.IPv4;
    } else {
      value = IpStack.Dual;
    }
  }
}
