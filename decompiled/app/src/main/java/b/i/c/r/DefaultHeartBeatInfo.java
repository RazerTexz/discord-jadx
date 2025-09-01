package b.i.c.r;

import android.content.Context;
import b.i.c.t.Provider2;

/* compiled from: DefaultHeartBeatInfo.java */
/* renamed from: b.i.c.r.a, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class DefaultHeartBeatInfo implements Provider2 {
    public final Context a;

    public DefaultHeartBeatInfo(Context context) {
        this.a = context;
    }

    @Override // b.i.c.t.Provider2
    public Object get() {
        HeartBeatInfoStorage heartBeatInfoStorage;
        Context context = this.a;
        synchronized (HeartBeatInfoStorage.class) {
            if (HeartBeatInfoStorage.a == null) {
                HeartBeatInfoStorage.a = new HeartBeatInfoStorage(context);
            }
            heartBeatInfoStorage = HeartBeatInfoStorage.a;
        }
        return heartBeatInfoStorage;
    }
}
