package esay;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC1108 {
    public String defangIPaddr(String address) {
        if (address.length() == 0) return address;
        return address.replaceAll("\\.", "[.]");
    }
}
