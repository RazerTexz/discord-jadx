package lombok.patcher;

import java.util.Collection;

/* loaded from: discord:lombok/patcher/TargetMatcher.SCL.lombok */
public interface TargetMatcher {
    Collection<String> getAffectedClasses();

    boolean matches(String str, String str2, String str3);

    String describe();
}
