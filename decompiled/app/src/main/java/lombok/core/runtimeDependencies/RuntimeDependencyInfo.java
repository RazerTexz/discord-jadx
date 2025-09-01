package lombok.core.runtimeDependencies;

import java.util.List;

/* loaded from: discord:lombok/core/runtimeDependencies/RuntimeDependencyInfo.SCL.lombok */
public interface RuntimeDependencyInfo {
    List<String> getRuntimeDependentsDescriptions();

    List<String> getRuntimeDependencies();
}
