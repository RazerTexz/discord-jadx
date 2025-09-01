package s.a.a;

import b.d.b.a.outline;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scopes.kt */
/* renamed from: s.a.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class Scopes implements CoroutineScope {
    public final CoroutineContext j;

    public Scopes(CoroutineContext coroutineContext) {
        this.j = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CoroutineScope(coroutineContext=");
        sbU.append(this.j);
        sbU.append(')');
        return sbU.toString();
    }
}
