package javax.jmdns;

import java.net.InetAddress;

public class InetAddressAddException extends RuntimeException {
  private final InetAddress address;

  public InetAddressAddException(InetAddress address, Throwable cause) {
    super("InetAddress add fail:" + address.getHostAddress(), cause);
    this.address = address;
  }
}
