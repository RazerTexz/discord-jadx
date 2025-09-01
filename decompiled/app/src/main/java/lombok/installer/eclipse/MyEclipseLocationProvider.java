package lombok.installer.eclipse;

import java.util.Collections;

/* loaded from: discord:lombok/installer/eclipse/MyEclipseLocationProvider.SCL.lombok */
public class MyEclipseLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor MY_ECLIPSE = new StandardProductDescriptor("MyEclipse", "myeclipse", "myeclipse", MyEclipseLocationProvider.class.getResource("myeclipse.png"), Collections.emptySet());

    public MyEclipseLocationProvider() {
        super(MY_ECLIPSE);
    }
}
