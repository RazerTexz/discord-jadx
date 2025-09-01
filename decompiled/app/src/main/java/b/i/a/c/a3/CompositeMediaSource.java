package b.i.a.c.a3;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.a3.MaskingMediaSource;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.MediaSourceEventListener;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.f3.Util2;
import b.i.a.c.w2.DrmSessionEventListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: CompositeMediaSource.java */
/* renamed from: b.i.a.c.a3.o, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {
    public final HashMap<T, b<T>> g = new HashMap<>();

    @Nullable
    public Handler h;

    @Nullable
    public TransferListener i;

    /* compiled from: CompositeMediaSource.java */
    /* renamed from: b.i.a.c.a3.o$a */
    public final class a implements MediaSourceEventListener, DrmSessionEventListener {
        public final T j;
        public MediaSourceEventListener.a k;
        public DrmSessionEventListener.a l;

        public a(T t) {
            this.k = CompositeMediaSource.this.c.g(0, null, 0L);
            this.l = CompositeMediaSource.this.d.g(0, null);
            this.j = t;
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void J(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.b();
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void S(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.a();
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.d(loadEventInfo, b(mediaLoadData));
        }

        public final boolean a(int i, @Nullable MediaSource2.a aVar) {
            MediaSource2.a aVarB;
            if (aVar != null) {
                CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
                T t = this.j;
                MaskingMediaSource maskingMediaSource = (MaskingMediaSource) compositeMediaSource;
                Objects.requireNonNull(maskingMediaSource);
                Object obj = aVar.a;
                Object obj2 = maskingMediaSource.n.n;
                if (obj2 != null && obj2.equals(obj)) {
                    obj = MaskingMediaSource.a.l;
                }
                aVarB = aVar.b(obj);
            } else {
                aVarB = null;
            }
            Objects.requireNonNull(CompositeMediaSource.this);
            MediaSourceEventListener.a aVar2 = this.k;
            if (aVar2.a != i || !Util2.a(aVar2.f807b, aVarB)) {
                this.k = CompositeMediaSource.this.c.g(i, aVarB, 0L);
            }
            DrmSessionEventListener.a aVar3 = this.l;
            if (aVar3.a == i && Util2.a(aVar3.f1156b, aVarB)) {
                return true;
            }
            this.l = new DrmSessionEventListener.a(CompositeMediaSource.this.d.c, i, aVarB);
            return true;
        }

        public final MediaLoadData b(MediaLoadData mediaLoadData) {
            CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
            long j = mediaLoadData.f;
            Objects.requireNonNull(compositeMediaSource);
            CompositeMediaSource compositeMediaSource2 = CompositeMediaSource.this;
            long j2 = mediaLoadData.g;
            Objects.requireNonNull(compositeMediaSource2);
            return (j == mediaLoadData.f && j2 == mediaLoadData.g) ? mediaLoadData : new MediaLoadData(mediaLoadData.a, mediaLoadData.f834b, mediaLoadData.c, mediaLoadData.d, mediaLoadData.e, j, j2);
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void c0(int i, @Nullable MediaSource2.a aVar, int i2) {
            a(i, aVar);
            this.l.d(i2);
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void d0(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.f();
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            a(i, aVar);
            this.k.e(loadEventInfo, b(mediaLoadData), iOException, z2);
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void i0(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.c();
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.b(b(mediaLoadData));
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.c(loadEventInfo, b(mediaLoadData));
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void u(int i, @Nullable MediaSource2.a aVar, Exception exc) {
            a(i, aVar);
            this.l.e(exc);
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.f(loadEventInfo, b(mediaLoadData));
        }
    }

    /* compiled from: CompositeMediaSource.java */
    /* renamed from: b.i.a.c.a3.o$b */
    public static final class b<T> {
        public final MediaSource2 a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaSource2.b f831b;
        public final CompositeMediaSource<T>.a c;

        public b(MediaSource2 mediaSource2, MediaSource2.b bVar, CompositeMediaSource<T>.a aVar) {
            this.a = mediaSource2;
            this.f831b = bVar;
            this.c = aVar;
        }
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    @CallSuper
    public void o() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.d(bVar.f831b);
        }
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    @CallSuper
    public void p() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.m(bVar.f831b);
        }
    }

    public final void t(T t, MediaSource2 mediaSource2) {
        AnimatableValueParser.j(!this.g.containsKey(null));
        MediaSource2.b aVar = new b.i.a.c.a3.a(this, null);
        a aVar2 = new a(null);
        this.g.put(null, new b<>(mediaSource2, aVar, aVar2));
        Handler handler = this.h;
        Objects.requireNonNull(handler);
        mediaSource2.b(handler, aVar2);
        Handler handler2 = this.h;
        Objects.requireNonNull(handler2);
        mediaSource2.f(handler2, aVar2);
        mediaSource2.l(aVar, this.i);
        if (!this.f827b.isEmpty()) {
            return;
        }
        mediaSource2.d(aVar);
    }
}
