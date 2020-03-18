package easy;

import java.time.Duration;
import java.time.Instant;

public class DefineIp {

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(defangIPaddr("192.168.100.48"));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");
    System.out.println(Duration.between(start, end).toMillis());

  }

  public static String defangIPaddr(String address) {
    return address.replace(".","[.]");
  }
}
