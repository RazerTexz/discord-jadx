package b.i.c.r;

import android.content.Context;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;

/* compiled from: DefaultHeartBeatInfo.java */
/* renamed from: b.i.c.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class DefaultHeartBeatInfo2 implements ComponentFactory {
    public static final DefaultHeartBeatInfo2 a = new DefaultHeartBeatInfo2();

    @Override // b.i.c.l.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo3((Context) componentContainer.a(Context.class));
    }
}
