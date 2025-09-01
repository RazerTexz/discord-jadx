package lombok.patcher;

/* loaded from: discord:lombok/patcher/Version.SCL.lombok */
public class Version {
    private static final String VERSION = "0.40";

    private Version() {
    }

    public static void main(String[] args) {
        System.out.println(VERSION);
    }

    public static String getVersion() {
        return VERSION;
    }
}
