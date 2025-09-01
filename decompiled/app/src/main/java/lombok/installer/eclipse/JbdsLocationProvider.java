package lombok.installer.eclipse;

import java.util.Collections;

/* loaded from: discord:lombok/installer/eclipse/JbdsLocationProvider.SCL.lombok */
public class JbdsLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor JBDS = new StandardProductDescriptor("JBoss Developer Studio", "jbdevstudio", "studio", JbdsLocationProvider.class.getResource("jbds.png"), Collections.emptySet());

    public JbdsLocationProvider() {
        super(JBDS);
    }
}
