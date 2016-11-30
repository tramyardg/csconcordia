package smart_uls;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class SmartULS {

    private String ulsKey;
    private String ulsValue;

    public String getUlsKey() {
        return ulsKey;
    }

    public void setUlsKey(String ulsKey) {
        this.ulsKey = ulsKey;
    }

    public String getUlsValue() {
        return ulsValue;
    }

    public void setUlsValue(String ulsValue) {
        this.ulsValue = ulsValue;
    }

    public SmartULS() {
    }

    /**
     * @param v the value: 8 digits uls code
     * @param k the key generated independently
     */
    public SmartULS(String v, String k) {
        this.ulsValue = v;
        this.ulsKey = k;
    }

    @Override
    public String toString() {
        return "SmartULS{" + "ulsKey=" + ulsKey + ", ulsCode=" + ulsValue + '}';
    }

    public int hashCode() {
        return ulsKey.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof SmartULS) {
            SmartULS tempUls = (SmartULS) obj;

            // Compare the two ulsKeys. If the ulskKeys are
            // the same, then they are the same SmartULS.
            return ulsKey.equalsIgnoreCase(tempUls.ulsKey);
        } else {
            return false;
        }
    }

}
