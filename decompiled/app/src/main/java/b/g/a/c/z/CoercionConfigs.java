package b.g.a.c.z;

import java.io.Serializable;
import java.util.Map;

/* compiled from: CoercionConfigs.java */
/* renamed from: b.g.a.c.z.d, reason: use source file name */
/* loaded from: classes3.dex */
public class CoercionConfigs implements Serializable {
    private static final long serialVersionUID = 1;
    public CoercionAction _defaultAction;
    public final MutableCoercionConfig _defaultCoercions;
    public Map<Class<?>, MutableCoercionConfig> _perClassCoercions;
    public MutableCoercionConfig[] _perTypeCoercions;

    static {
        b.c.a.y.b.com$fasterxml$jackson$databind$type$LogicalType$s$values();
    }

    public CoercionConfigs() {
        CoercionAction coercionAction = CoercionAction.TryConvert;
        this._defaultCoercions = new MutableCoercionConfig();
        this._defaultAction = coercionAction;
        this._perTypeCoercions = null;
        this._perClassCoercions = null;
    }
}
