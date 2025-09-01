package b.i.a.c.s2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import b.i.a.c.DeviceInfo2;
import b.i.a.c.Format2;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.Player;
import b.i.a.c.Player2;
import b.i.a.c.Player3;
import b.i.a.c.Timeline;
import b.i.a.c.TracksInfo;
import b.i.a.c.a3.LoadEventInfo;
import b.i.a.c.a3.MediaLoadData;
import b.i.a.c.a3.MediaPeriodId;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.MediaSourceEventListener;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.HandlerWrapper;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.g3.VideoSize;
import b.i.a.c.s2.AnalyticsListener;
import b.i.a.c.t2.AudioRendererEventListener;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import b.i.a.c.v2.DecoderReuseEvaluation;
import b.i.a.c.w2.DrmSessionEventListener;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableMap2;
import b.i.b.b.RegularImmutableList;
import b.i.b.b.RegularImmutableMap;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: AnalyticsCollector.java */
/* renamed from: b.i.a.c.s2.g1, reason: use source file name */
/* loaded from: classes3.dex */
public class AnalyticsCollector implements Player2.e, AudioRendererEventListener2, VideoRendererEventListener2, MediaSourceEventListener, BandwidthMeter.a, DrmSessionEventListener {
    public final Clock4 j;
    public final Timeline.b k;
    public final Timeline.c l;
    public final a m;
    public final SparseArray<AnalyticsListener.a> n;
    public ListenerSet<AnalyticsListener> o;
    public Player2 p;
    public HandlerWrapper q;
    public boolean r;

    /* compiled from: AnalyticsCollector.java */
    /* renamed from: b.i.a.c.s2.g1$a */
    public static final class a {
        public final Timeline.b a;

        /* renamed from: b, reason: collision with root package name */
        public ImmutableList2<MediaSource2.a> f1081b;
        public ImmutableMap2<MediaSource2.a, Timeline> c;

        @Nullable
        public MediaSource2.a d;
        public MediaSource2.a e;
        public MediaSource2.a f;

        public a(Timeline.b bVar) {
            this.a = bVar;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            this.f1081b = RegularImmutableList.l;
            this.c = RegularImmutableMap.m;
        }

        @Nullable
        public static MediaSource2.a b(Player2 player2, ImmutableList2<MediaSource2.a> immutableList2, @Nullable MediaSource2.a aVar, Timeline.b bVar) {
            Timeline timelineK = player2.K();
            int iM = player2.m();
            Object objM = timelineK.q() ? null : timelineK.m(iM);
            int iB = (player2.f() || timelineK.q()) ? -1 : timelineK.f(iM, bVar).b(Util2.B(player2.T()) - bVar.n);
            for (int i = 0; i < immutableList2.size(); i++) {
                MediaSource2.a aVar2 = immutableList2.get(i);
                if (c(aVar2, objM, player2.f(), player2.B(), player2.q(), iB)) {
                    return aVar2;
                }
            }
            if (immutableList2.isEmpty() && aVar != null) {
                if (c(aVar, objM, player2.f(), player2.B(), player2.q(), iB)) {
                    return aVar;
                }
            }
            return null;
        }

        public static boolean c(MediaSource2.a aVar, @Nullable Object obj, boolean z2, int i, int i2, int i3) {
            if (aVar.a.equals(obj)) {
                return (z2 && aVar.f835b == i && aVar.c == i2) || (!z2 && aVar.f835b == -1 && aVar.e == i3);
            }
            return false;
        }

        public final void a(ImmutableMap2.a<MediaSource2.a, Timeline> aVar, @Nullable MediaSource2.a aVar2, Timeline timeline) {
            if (aVar2 == null) {
                return;
            }
            if (timeline.b(aVar2.a) != -1) {
                aVar.c(aVar2, timeline);
                return;
            }
            Timeline timeline2 = this.c.get(aVar2);
            if (timeline2 != null) {
                aVar.c(aVar2, timeline2);
            }
        }

        public final void d(Timeline timeline) {
            ImmutableMap2.a<MediaSource2.a, Timeline> aVar = new ImmutableMap2.a<>(4);
            if (this.f1081b.isEmpty()) {
                a(aVar, this.e, timeline);
                if (!b.i.a.f.e.o.f.V(this.f, this.e)) {
                    a(aVar, this.f, timeline);
                }
                if (!b.i.a.f.e.o.f.V(this.d, this.e) && !b.i.a.f.e.o.f.V(this.d, this.f)) {
                    a(aVar, this.d, timeline);
                }
            } else {
                for (int i = 0; i < this.f1081b.size(); i++) {
                    a(aVar, this.f1081b.get(i), timeline);
                }
                if (!this.f1081b.contains(this.d)) {
                    a(aVar, this.d, timeline);
                }
            }
            this.c = aVar.a();
        }
    }

    public AnalyticsCollector(Clock4 clock4) {
        this.j = clock4;
        this.o = new ListenerSet<>(new CopyOnWriteArraySet(), Util2.o(), clock4, o0.a);
        Timeline.b bVar = new Timeline.b();
        this.k = bVar;
        this.l = new Timeline.c();
        this.m = new a(bVar);
        this.n = new SparseArray<>();
    }

    @Override // b.i.a.c.Player2.c
    public void A(MediaMetadata mediaMetadata) {
        AnalyticsListener.a aVarK0 = k0();
        r0 r0Var = new r0(aVarK0, mediaMetadata);
        this.n.put(14, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(14, r0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void B(String str) {
        AnalyticsListener.a aVarP0 = p0();
        t tVar = new t(aVarP0, str);
        this.n.put(PointerIconCompat.TYPE_ALL_SCROLL, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ALL_SCROLL, tVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void C(String str, long j, long j2) {
        AnalyticsListener.a aVarP0 = p0();
        l0 l0Var = new l0(aVarP0, str, j2, j);
        this.n.put(PointerIconCompat.TYPE_VERTICAL_TEXT, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_VERTICAL_TEXT, l0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void D(boolean z2) {
        AnalyticsListener.a aVarK0 = k0();
        g0 g0Var = new g0(aVarK0, z2);
        this.n.put(9, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(9, g0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void E(Player2 player2, Player2.d dVar) {
        Player.e(this, player2, dVar);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void F(int i, long j) {
        AnalyticsListener.a aVarO0 = o0();
        z zVar = new z(aVarO0, i, j);
        this.n.put(AudioAttributesCompat.FLAG_ALL, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(AudioAttributesCompat.FLAG_ALL, zVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void G(int i, boolean z2) {
        Player.d(this, i, z2);
    }

    @Override // b.i.a.c.Player2.c
    public final void H(boolean z2, int i) {
        AnalyticsListener.a aVarK0 = k0();
        j0 j0Var = new j0(aVarK0, z2, i);
        this.n.put(-1, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(-1, j0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void I(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.a aVarP0 = p0();
        i0 i0Var = new i0(aVarP0, format2, decoderReuseEvaluation);
        this.n.put(PointerIconCompat.TYPE_ALIAS, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ALIAS, i0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void J(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        t0 t0Var = new t0(aVarN0);
        this.n.put(1034, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1034, t0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void K(Object obj, long j) {
        AnalyticsListener.a aVarP0 = p0();
        f1 f1Var = new f1(aVarP0, obj, j);
        this.n.put(1027, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1027, f1Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void L(int i) {
        AnalyticsListener.a aVarK0 = k0();
        b0 b0Var = new b0(aVarK0, i);
        this.n.put(8, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(8, b0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void M(@Nullable MediaItem2 mediaItem2, int i) {
        AnalyticsListener.a aVarK0 = k0();
        q qVar = new q(aVarK0, mediaItem2, i);
        this.n.put(1, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1, qVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void N(Exception exc) {
        AnalyticsListener.a aVarP0 = p0();
        e0 e0Var = new e0(aVarP0, exc);
        this.n.put(PointerIconCompat.TYPE_ZOOM_IN, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ZOOM_IN, e0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public /* synthetic */ void O(Format2 format2) {
        VideoRendererEventListener.a(this, format2);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void P(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarP0 = p0();
        d0 d0Var = new d0(aVarP0, decoderCounters);
        this.n.put(PointerIconCompat.TYPE_GRAB, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_GRAB, d0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void Q(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.a aVarP0 = p0();
        y0 y0Var = new y0(aVarP0, format2, decoderReuseEvaluation);
        this.n.put(1022, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1022, y0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void R(long j) {
        AnalyticsListener.a aVarP0 = p0();
        n0 n0Var = new n0(aVarP0, j);
        this.n.put(PointerIconCompat.TYPE_COPY, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_COPY, n0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void S(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        e1 e1Var = new e1(aVarN0);
        this.n.put(1031, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1031, e1Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void T(Exception exc) {
        AnalyticsListener.a aVarP0 = p0();
        k kVar = new k(aVarP0, exc);
        this.n.put(1037, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1037, kVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public /* synthetic */ void U(Format2 format2) {
        AudioRendererEventListener.a(this, format2);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void V(Exception exc) {
        AnalyticsListener.a aVarP0 = p0();
        q0 q0Var = new q0(aVarP0, exc);
        this.n.put(1038, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1038, q0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void W(boolean z2, int i) {
        AnalyticsListener.a aVarK0 = k0();
        d1 d1Var = new d1(aVarK0, z2, i);
        this.n.put(5, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(5, d1Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        y yVar = new y(aVarN0, loadEventInfo, mediaLoadData);
        this.n.put(PointerIconCompat.TYPE_CONTEXT_MENU, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_CONTEXT_MENU, yVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.a aVarK0 = k0();
        i iVar = new i(aVarK0, trackGroupArray, trackSelectionArray);
        this.n.put(2, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(2, iVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void Z(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarO0 = o0();
        j jVar = new j(aVarO0, decoderCounters);
        this.n.put(InputDeviceCompat.SOURCE_GAMEPAD, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(InputDeviceCompat.SOURCE_GAMEPAD, jVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void a() {
        AnalyticsListener.a aVarK0 = k0();
        u uVar = new u(aVarK0);
        this.n.put(-1, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(-1, uVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public void a0(int i, int i2) {
        AnalyticsListener.a aVarP0 = p0();
        n nVar = new n(aVarP0, i, i2);
        this.n.put(1029, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1029, nVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void b(Metadata metadata) {
        AnalyticsListener.a aVarK0 = k0();
        v vVar = new v(aVarK0, metadata);
        this.n.put(PointerIconCompat.TYPE_CROSSHAIR, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_CROSSHAIR, vVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void b0(PlaybackParameters playbackParameters) {
        AnalyticsListener.a aVarK0 = k0();
        m mVar = new m(aVarK0, playbackParameters);
        this.n.put(12, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(12, mVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void c() {
        Player.r(this);
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void c0(int i, @Nullable MediaSource2.a aVar, int i2) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        p0 p0Var = new p0(aVarN0, i2);
        this.n.put(1030, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1030, p0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void d(boolean z2) {
        AnalyticsListener.a aVarP0 = p0();
        u0 u0Var = new u0(aVarP0, z2);
        this.n.put(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, u0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void d0(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        b bVar = new b(aVarN0);
        this.n.put(1035, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1035, bVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void e(List list) {
        Player.b(this, list);
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void e0(int i, long j, long j2) {
        AnalyticsListener.a aVarP0 = p0();
        c0 c0Var = new c0(aVarP0, i, j, j2);
        this.n.put(PointerIconCompat.TYPE_NO_DROP, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_NO_DROP, c0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void f(VideoSize videoSize) {
        AnalyticsListener.a aVarP0 = p0();
        m0 m0Var = new m0(aVarP0, videoSize);
        this.n.put(1028, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1028, m0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        Player.p(this, playbackException);
    }

    @Override // b.i.a.c.Player2.c
    public final void g(Player2.f fVar, Player2.f fVar2, int i) {
        if (i == 1) {
            this.r = false;
        }
        a aVar = this.m;
        Player2 player2 = this.p;
        Objects.requireNonNull(player2);
        aVar.d = a.b(player2, aVar.f1081b, aVar.e, aVar.a);
        AnalyticsListener.a aVarK0 = k0();
        r rVar = new r(aVarK0, i, fVar, fVar2);
        this.n.put(11, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(11, rVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        f0 f0Var = new f0(aVarN0, loadEventInfo, mediaLoadData, iOException, z2);
        this.n.put(PointerIconCompat.TYPE_HELP, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_HELP, f0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void h(int i) {
        AnalyticsListener.a aVarK0 = k0();
        b1 b1Var = new b1(aVarK0, i);
        this.n.put(6, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(6, b1Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void h0(long j, int i) {
        AnalyticsListener.a aVarO0 = o0();
        c1 c1Var = new c1(aVarO0, j, i);
        this.n.put(1026, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1026, c1Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void i(boolean z2) {
        Player3.d(this, z2);
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void i0(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        v0 v0Var = new v0(aVarN0);
        this.n.put(1033, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1033, v0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void j(int i) {
        Player3.l(this, i);
    }

    @Override // b.i.a.c.Player2.c
    public void j0(boolean z2) {
        AnalyticsListener.a aVarK0 = k0();
        z0 z0Var = new z0(aVarK0, z2);
        this.n.put(7, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(7, z0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void k(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarO0 = o0();
        w0 w0Var = new w0(aVarO0, decoderCounters);
        this.n.put(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, w0Var);
        listenerSet.a();
    }

    public final AnalyticsListener.a k0() {
        return m0(this.m.d);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void l(String str) {
        AnalyticsListener.a aVarP0 = p0();
        f fVar = new f(aVarP0, str);
        this.n.put(1024, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1024, fVar);
        listenerSet.a();
    }

    @RequiresNonNull({"player"})
    public final AnalyticsListener.a l0(Timeline timeline, int i, @Nullable MediaSource2.a aVar) {
        long jW;
        MediaSource2.a aVar2 = timeline.q() ? null : aVar;
        long jD = this.j.d();
        boolean z2 = false;
        boolean z3 = timeline.equals(this.p.K()) && i == this.p.C();
        long jA = 0;
        if (aVar2 != null && aVar2.a()) {
            if (z3 && this.p.B() == aVar2.f835b && this.p.q() == aVar2.c) {
                z2 = true;
            }
            if (z2) {
                jA = this.p.T();
            }
        } else {
            if (z3) {
                jW = this.p.w();
                return new AnalyticsListener.a(jD, timeline, i, aVar2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
            }
            if (!timeline.q()) {
                jA = timeline.o(i, this.l, 0L).a();
            }
        }
        jW = jA;
        return new AnalyticsListener.a(jD, timeline, i, aVar2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void m(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarP0 = p0();
        l lVar = new l(aVarP0, decoderCounters);
        this.n.put(PointerIconCompat.TYPE_TEXT, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_TEXT, lVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a m0(@Nullable MediaSource2.a aVar) {
        Objects.requireNonNull(this.p);
        Timeline timeline = aVar == null ? null : this.m.c.get(aVar);
        if (aVar != null && timeline != null) {
            return l0(timeline, timeline.h(aVar.a, this.k).l, aVar);
        }
        int iC = this.p.C();
        Timeline timelineK = this.p.K();
        if (!(iC < timelineK.p())) {
            timelineK = Timeline.j;
        }
        return l0(timelineK, iC, null);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void n(String str, long j, long j2) {
        AnalyticsListener.a aVarP0 = p0();
        d dVar = new d(aVarP0, str, j2, j);
        this.n.put(PointerIconCompat.TYPE_GRABBING, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_GRABBING, dVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a n0(int i, @Nullable MediaSource2.a aVar) {
        Objects.requireNonNull(this.p);
        if (aVar != null) {
            return this.m.c.get(aVar) != null ? m0(aVar) : l0(Timeline.j, i, aVar);
        }
        Timeline timelineK = this.p.K();
        if (!(i < timelineK.p())) {
            timelineK = Timeline.j;
        }
        return l0(timelineK, i, null);
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        g gVar = new g(aVarN0, mediaLoadData);
        this.n.put(PointerIconCompat.TYPE_WAIT, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_WAIT, gVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a o0() {
        return m0(this.m.e);
    }

    @Override // b.i.a.c.Player2.c
    public void p(TracksInfo tracksInfo) {
        AnalyticsListener.a aVarK0 = k0();
        w wVar = new w(aVarK0, tracksInfo);
        this.n.put(2, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(2, wVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a p0() {
        return m0(this.m.f);
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        h0 h0Var = new h0(aVarN0, loadEventInfo, mediaLoadData);
        this.n.put(PointerIconCompat.TYPE_HAND, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_HAND, h0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void r(boolean z2) {
        AnalyticsListener.a aVarK0 = k0();
        e eVar = new e(aVarK0, z2);
        this.n.put(3, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(3, eVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void s(PlaybackException playbackException) {
        MediaPeriodId mediaPeriodId;
        AnalyticsListener.a aVarM0 = (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : m0(new MediaSource2.a(mediaPeriodId));
        if (aVarM0 == null) {
            aVarM0 = k0();
        }
        b.i.a.c.s2.a aVar = new b.i.a.c.s2.a(aVarM0, playbackException);
        this.n.put(10, aVarM0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(10, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public void t(Player2.b bVar) {
        AnalyticsListener.a aVarK0 = k0();
        a0 a0Var = new a0(aVarK0, bVar);
        this.n.put(13, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(13, a0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void u(int i, @Nullable MediaSource2.a aVar, Exception exc) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        c cVar = new c(aVarN0, exc);
        this.n.put(1032, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1032, cVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void v(Timeline timeline, int i) {
        a aVar = this.m;
        Player2 player2 = this.p;
        Objects.requireNonNull(player2);
        aVar.d = a.b(player2, aVar.f1081b, aVar.e, aVar.a);
        aVar.d(player2.K());
        AnalyticsListener.a aVarK0 = k0();
        x xVar = new x(aVarK0, i);
        this.n.put(0, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(0, xVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void w(float f) {
        AnalyticsListener.a aVarP0 = p0();
        s sVar = new s(aVarP0, f);
        this.n.put(PointerIconCompat.TYPE_ZOOM_OUT, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ZOOM_OUT, sVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarN0 = n0(i, aVar);
        k0 k0Var = new k0(aVarN0, loadEventInfo, mediaLoadData);
        this.n.put(1000, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1000, k0Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void y(int i) {
        AnalyticsListener.a aVarK0 = k0();
        a1 a1Var = new a1(aVarK0, i);
        this.n.put(4, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(4, a1Var);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void z(DeviceInfo2 deviceInfo2) {
        Player.c(this, deviceInfo2);
    }
}
