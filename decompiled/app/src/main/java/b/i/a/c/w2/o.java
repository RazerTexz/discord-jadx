package b.i.a.c.w2;

import android.media.MediaDrm;
import b.i.a.c.w2.ExoMediaDrm;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements MediaDrm.OnEventListener {
    public final /* synthetic */ FrameworkMediaDrm a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.b f1154b;

    public /* synthetic */ o(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.b bVar) {
        this.a = frameworkMediaDrm;
        this.f1154b = bVar;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        FrameworkMediaDrm frameworkMediaDrm = this.a;
        ExoMediaDrm.b bVar = this.f1154b;
        Objects.requireNonNull(frameworkMediaDrm);
        DefaultDrmSessionManager.c cVar = DefaultDrmSessionManager.this.f2931x;
        Objects.requireNonNull(cVar);
        cVar.obtainMessage(i, bArr).sendToTarget();
    }
}
