package b.i.d.q.y;

import java.lang.reflect.AccessibleObject;

/* compiled from: PreJava9ReflectionAccessor.java */
/* renamed from: b.i.d.q.y.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    @Override // b.i.d.q.y.ReflectionAccessor
    public void a(AccessibleObject accessibleObject) throws SecurityException {
        accessibleObject.setAccessible(true);
    }
}
