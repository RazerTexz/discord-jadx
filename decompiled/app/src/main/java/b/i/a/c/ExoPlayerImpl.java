package b.i.a.c;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.ExoPlayer2;
import b.i.a.c.ExoPlayerImplInternal2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.Player2;
import b.i.a.c.PlayerMessage;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.MediaSourceFactory;
import b.i.a.c.a3.ShuffleOrder;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.DefaultTrackSelector;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.c3.TrackSelector;
import b.i.a.c.c3.TrackSelectorResult;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.HandlerWrapper;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.f3.SystemHandlerWrapper;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoSize;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.a.c.s2.AnalyticsListener;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ExoPlayerImpl.java */
/* renamed from: b.i.a.c.f1, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExoPlayerImpl extends BasePlayer {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f958b = 0;
    public int A;
    public ShuffleOrder B;
    public Player2.b C;
    public MediaMetadata D;
    public MediaMetadata E;
    public PlaybackInfo F;
    public int G;
    public long H;
    public final TrackSelectorResult c;
    public final Player2.b d;
    public final Renderer2[] e;
    public final TrackSelector f;
    public final HandlerWrapper g;
    public final ExoPlayerImplInternal2.e h;
    public final ExoPlayerImplInternal2 i;
    public final ListenerSet<Player2.c> j;
    public final CopyOnWriteArraySet<ExoPlayer2.a> k;
    public final Timeline.b l;
    public final List<a> m;
    public final boolean n;
    public final MediaSourceFactory o;

    @Nullable
    public final AnalyticsCollector p;
    public final Looper q;
    public final BandwidthMeter r;

    /* renamed from: s, reason: collision with root package name */
    public final long f959s;
    public final long t;
    public final Clock4 u;
    public int v;
    public boolean w;

    /* renamed from: x, reason: collision with root package name */
    public int f960x;

    /* renamed from: y, reason: collision with root package name */
    public int f961y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f962z;

    /* compiled from: ExoPlayerImpl.java */
    /* renamed from: b.i.a.c.f1$a */
    public static final class a implements MediaSourceInfoHolder {
        public final Object a;

        /* renamed from: b, reason: collision with root package name */
        public Timeline f963b;

        public a(Object obj, Timeline timeline) {
            this.a = obj;
            this.f963b = timeline;
        }

        @Override // b.i.a.c.MediaSourceInfoHolder
        public Timeline a() {
            return this.f963b;
        }

        @Override // b.i.a.c.MediaSourceInfoHolder
        public Object getUid() {
            return this.a;
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer2[] renderer2Arr, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, @Nullable AnalyticsCollector analyticsCollector, boolean z2, SeekParameters seekParameters, long j, long j2, LivePlaybackSpeedControl livePlaybackSpeedControl, long j3, boolean z3, Clock4 clock4, Looper looper, @Nullable Player2 player2, Player2.b bVar) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = Util2.e;
        StringBuilder sbS = outline.S(outline.b(str, outline.b(hexString, 30)), "Init ", hexString, " [", "ExoPlayerLib/2.16.0");
        sbS.append("] [");
        sbS.append(str);
        sbS.append("]");
        Log.i("ExoPlayerImpl", sbS.toString());
        AnimatableValueParser.D(renderer2Arr.length > 0);
        this.e = renderer2Arr;
        Objects.requireNonNull(trackSelector);
        this.f = trackSelector;
        this.o = mediaSourceFactory;
        this.r = bandwidthMeter;
        this.p = analyticsCollector;
        this.n = z2;
        this.f959s = j;
        this.t = j2;
        this.q = looper;
        this.u = clock4;
        this.v = 0;
        this.j = new ListenerSet<>(new CopyOnWriteArraySet(), looper, clock4, new u(player2));
        this.k = new CopyOnWriteArraySet<>();
        this.m = new ArrayList();
        this.B = new ShuffleOrder.a(0, new Random());
        this.c = new TrackSelectorResult(new RendererConfiguration[renderer2Arr.length], new ExoTrackSelection2[renderer2Arr.length], TracksInfo.j, null);
        this.l = new Timeline.b();
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 20, 30};
        for (int i = 0; i < 12; i++) {
            int i2 = iArr[i];
            AnimatableValueParser.D(!false);
            sparseBooleanArray.append(i2, true);
        }
        if (trackSelector instanceof DefaultTrackSelector) {
            AnimatableValueParser.D(!false);
            sparseBooleanArray.append(29, true);
        }
        FlagSet flagSet = bVar.k;
        for (int i3 = 0; i3 < flagSet.c(); i3++) {
            int iB = flagSet.b(i3);
            AnimatableValueParser.D(true);
            sparseBooleanArray.append(iB, true);
        }
        AnimatableValueParser.D(true);
        FlagSet flagSet2 = new FlagSet(sparseBooleanArray, null);
        this.d = new Player2.b(flagSet2, null);
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
        for (int i4 = 0; i4 < flagSet2.c(); i4++) {
            int iB2 = flagSet2.b(i4);
            AnimatableValueParser.D(true);
            sparseBooleanArray2.append(iB2, true);
        }
        AnimatableValueParser.D(true);
        sparseBooleanArray2.append(4, true);
        AnimatableValueParser.D(true);
        sparseBooleanArray2.append(10, true);
        AnimatableValueParser.D(true);
        this.C = new Player2.b(new FlagSet(sparseBooleanArray2, null), null);
        MediaMetadata mediaMetadata = MediaMetadata.j;
        this.D = mediaMetadata;
        this.E = mediaMetadata;
        this.G = -1;
        this.g = clock4.b(looper, null);
        w wVar = new w(this);
        this.h = wVar;
        this.F = PlaybackInfo.h(this.c);
        if (analyticsCollector != null) {
            AnimatableValueParser.D(analyticsCollector.p == null || analyticsCollector.m.f1081b.isEmpty());
            analyticsCollector.p = player2;
            analyticsCollector.q = analyticsCollector.j.b(looper, null);
            ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.o;
            analyticsCollector.o = new ListenerSet<>(listenerSet.d, looper, listenerSet.a, new b.i.a.c.s2.h(analyticsCollector, player2));
            d0(analyticsCollector);
            bandwidthMeter.f(new Handler(looper), analyticsCollector);
        }
        this.i = new ExoPlayerImplInternal2(renderer2Arr, trackSelector, this.c, loadControl, bandwidthMeter, this.v, this.w, analyticsCollector, seekParameters, livePlaybackSpeedControl, j3, z3, looper, clock4, wVar);
    }

    public static long j0(PlaybackInfo playbackInfo) {
        Timeline.c cVar = new Timeline.c();
        Timeline.b bVar = new Timeline.b();
        playbackInfo.f1146b.h(playbackInfo.c.a, bVar);
        long j = playbackInfo.d;
        return j == -9223372036854775807L ? playbackInfo.f1146b.n(bVar.l, cVar).f1045z : bVar.n + j;
    }

    public static boolean k0(PlaybackInfo playbackInfo) {
        return playbackInfo.f == 3 && playbackInfo.m && playbackInfo.n == 0;
    }

    @Override // b.i.a.c.Player2
    public List A() {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        return RegularImmutableList.l;
    }

    @Override // b.i.a.c.Player2
    public int B() {
        if (f()) {
            return this.F.c.f835b;
        }
        return -1;
    }

    @Override // b.i.a.c.Player2
    public int C() {
        int iH0 = h0();
        if (iH0 == -1) {
            return 0;
        }
        return iH0;
    }

    @Override // b.i.a.c.Player2
    public void E(int i) {
        if (this.v != i) {
            this.v = i;
            ((SystemHandlerWrapper.b) this.i.q.a(11, i, 0)).b();
            this.j.b(8, new k(i));
            r0();
            this.j.a();
        }
    }

    @Override // b.i.a.c.Player2
    public void F(@Nullable SurfaceView surfaceView) {
    }

    @Override // b.i.a.c.Player2
    public int G() {
        return this.F.n;
    }

    @Override // b.i.a.c.Player2
    public TracksInfo H() {
        return this.F.j.d;
    }

    @Override // b.i.a.c.Player2
    public int I() {
        return this.v;
    }

    @Override // b.i.a.c.Player2
    public long J() {
        if (f()) {
            PlaybackInfo playbackInfo = this.F;
            MediaSource2.a aVar = playbackInfo.c;
            playbackInfo.f1146b.h(aVar.a, this.l);
            return Util2.M(this.l.a(aVar.f835b, aVar.c));
        }
        Timeline timelineK = K();
        if (timelineK.q()) {
            return -9223372036854775807L;
        }
        return timelineK.n(C(), this.a).b();
    }

    @Override // b.i.a.c.Player2
    public Timeline K() {
        return this.F.f1146b;
    }

    @Override // b.i.a.c.Player2
    public Looper L() {
        return this.q;
    }

    @Override // b.i.a.c.Player2
    public boolean M() {
        return this.w;
    }

    @Override // b.i.a.c.Player2
    public long N() {
        if (this.F.f1146b.q()) {
            return this.H;
        }
        PlaybackInfo playbackInfo = this.F;
        if (playbackInfo.l.d != playbackInfo.c.d) {
            return playbackInfo.f1146b.n(C(), this.a).b();
        }
        long j = playbackInfo.r;
        if (this.F.l.a()) {
            PlaybackInfo playbackInfo2 = this.F;
            Timeline.b bVarH = playbackInfo2.f1146b.h(playbackInfo2.l.a, this.l);
            long jC = bVarH.c(this.F.l.f835b);
            j = jC == Long.MIN_VALUE ? bVarH.m : jC;
        }
        PlaybackInfo playbackInfo3 = this.F;
        return Util2.M(m0(playbackInfo3.f1146b, playbackInfo3.l, j));
    }

    @Override // b.i.a.c.Player2
    public void Q(@Nullable TextureView textureView) {
    }

    @Override // b.i.a.c.Player2
    public MediaMetadata S() {
        return this.D;
    }

    @Override // b.i.a.c.Player2
    public long T() {
        return Util2.M(g0(this.F));
    }

    @Override // b.i.a.c.Player2
    public long U() {
        return this.f959s;
    }

    @Override // b.i.a.c.Player2
    public void a() {
        PlaybackInfo playbackInfo = this.F;
        if (playbackInfo.f != 1) {
            return;
        }
        PlaybackInfo playbackInfoE = playbackInfo.e(null);
        PlaybackInfo playbackInfoF = playbackInfoE.f(playbackInfoE.f1146b.q() ? 4 : 2);
        this.f960x++;
        ((SystemHandlerWrapper.b) this.i.q.c(0)).b();
        s0(playbackInfoF, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // b.i.a.c.Player2
    public PlaybackParameters c() {
        return this.F.o;
    }

    public void d0(Player2.c cVar) {
        ListenerSet<Player2.c> listenerSet = this.j;
        if (listenerSet.g) {
            return;
        }
        Objects.requireNonNull(cVar);
        listenerSet.d.add(new ListenerSet.c<>(cVar));
    }

    public final MediaMetadata e0() {
        Timeline timelineK = K();
        MediaItem2 mediaItem2 = timelineK.q() ? null : timelineK.n(C(), this.a).p;
        if (mediaItem2 == null) {
            return this.E;
        }
        MediaMetadata.b bVarA = this.E.a();
        MediaMetadata mediaMetadata = mediaItem2.n;
        if (mediaMetadata != null) {
            CharSequence charSequence = mediaMetadata.l;
            if (charSequence != null) {
                bVarA.a = charSequence;
            }
            CharSequence charSequence2 = mediaMetadata.m;
            if (charSequence2 != null) {
                bVarA.f1050b = charSequence2;
            }
            CharSequence charSequence3 = mediaMetadata.n;
            if (charSequence3 != null) {
                bVarA.c = charSequence3;
            }
            CharSequence charSequence4 = mediaMetadata.o;
            if (charSequence4 != null) {
                bVarA.d = charSequence4;
            }
            CharSequence charSequence5 = mediaMetadata.p;
            if (charSequence5 != null) {
                bVarA.e = charSequence5;
            }
            CharSequence charSequence6 = mediaMetadata.q;
            if (charSequence6 != null) {
                bVarA.f = charSequence6;
            }
            CharSequence charSequence7 = mediaMetadata.r;
            if (charSequence7 != null) {
                bVarA.g = charSequence7;
            }
            Uri uri = mediaMetadata.f1046s;
            if (uri != null) {
                bVarA.h = uri;
            }
            Rating rating = mediaMetadata.t;
            if (rating != null) {
                bVarA.i = rating;
            }
            Rating rating2 = mediaMetadata.u;
            if (rating2 != null) {
                bVarA.j = rating2;
            }
            byte[] bArr = mediaMetadata.v;
            if (bArr != null) {
                Integer num = mediaMetadata.w;
                bVarA.k = (byte[]) bArr.clone();
                bVarA.l = num;
            }
            Uri uri2 = mediaMetadata.f1047x;
            if (uri2 != null) {
                bVarA.m = uri2;
            }
            Integer num2 = mediaMetadata.f1048y;
            if (num2 != null) {
                bVarA.n = num2;
            }
            Integer num3 = mediaMetadata.f1049z;
            if (num3 != null) {
                bVarA.o = num3;
            }
            Integer num4 = mediaMetadata.A;
            if (num4 != null) {
                bVarA.p = num4;
            }
            Boolean bool = mediaMetadata.B;
            if (bool != null) {
                bVarA.q = bool;
            }
            Integer num5 = mediaMetadata.C;
            if (num5 != null) {
                bVarA.r = num5;
            }
            Integer num6 = mediaMetadata.D;
            if (num6 != null) {
                bVarA.r = num6;
            }
            Integer num7 = mediaMetadata.E;
            if (num7 != null) {
                bVarA.f1051s = num7;
            }
            Integer num8 = mediaMetadata.F;
            if (num8 != null) {
                bVarA.t = num8;
            }
            Integer num9 = mediaMetadata.G;
            if (num9 != null) {
                bVarA.u = num9;
            }
            Integer num10 = mediaMetadata.H;
            if (num10 != null) {
                bVarA.v = num10;
            }
            Integer num11 = mediaMetadata.I;
            if (num11 != null) {
                bVarA.w = num11;
            }
            CharSequence charSequence8 = mediaMetadata.J;
            if (charSequence8 != null) {
                bVarA.f1052x = charSequence8;
            }
            CharSequence charSequence9 = mediaMetadata.K;
            if (charSequence9 != null) {
                bVarA.f1053y = charSequence9;
            }
            CharSequence charSequence10 = mediaMetadata.L;
            if (charSequence10 != null) {
                bVarA.f1054z = charSequence10;
            }
            Integer num12 = mediaMetadata.M;
            if (num12 != null) {
                bVarA.A = num12;
            }
            Integer num13 = mediaMetadata.N;
            if (num13 != null) {
                bVarA.B = num13;
            }
            CharSequence charSequence11 = mediaMetadata.O;
            if (charSequence11 != null) {
                bVarA.C = charSequence11;
            }
            CharSequence charSequence12 = mediaMetadata.P;
            if (charSequence12 != null) {
                bVarA.D = charSequence12;
            }
            Bundle bundle = mediaMetadata.Q;
            if (bundle != null) {
                bVarA.E = bundle;
            }
        }
        return bVarA.a();
    }

    @Override // b.i.a.c.Player2
    public boolean f() {
        return this.F.c.a();
    }

    public PlayerMessage f0(PlayerMessage.b bVar) {
        return new PlayerMessage(this.i, bVar, this.F.f1146b, C(), this.u, this.i.f1007s);
    }

    @Override // b.i.a.c.Player2
    public long g() {
        return Util2.M(this.F.f1147s);
    }

    public final long g0(PlaybackInfo playbackInfo) {
        return playbackInfo.f1146b.q() ? Util2.B(this.H) : playbackInfo.c.a() ? playbackInfo.t : m0(playbackInfo.f1146b, playbackInfo.c, playbackInfo.t);
    }

    @Override // b.i.a.c.Player2
    public void h(int i, long j) {
        Timeline timeline = this.F.f1146b;
        if (i < 0 || (!timeline.q() && i >= timeline.p())) {
            throw new IllegalSeekPositionException(timeline, i, j);
        }
        this.f960x++;
        if (f()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            ExoPlayerImplInternal2.d dVar = new ExoPlayerImplInternal2.d(this.F);
            dVar.a(1);
            ExoPlayerImpl exoPlayerImpl = ((w) this.h).a;
            exoPlayerImpl.g.b(new c0(exoPlayerImpl, dVar));
            return;
        }
        int i2 = this.F.f != 1 ? 2 : 1;
        int iC = C();
        PlaybackInfo playbackInfoL0 = l0(this.F.f(i2), timeline, i0(timeline, i, j));
        ((SystemHandlerWrapper.b) this.i.q.i(3, new ExoPlayerImplInternal2.g(timeline, i, Util2.B(j)))).b();
        s0(playbackInfoL0, 0, 1, true, true, 1, g0(playbackInfoL0), iC);
    }

    public final int h0() {
        if (this.F.f1146b.q()) {
            return this.G;
        }
        PlaybackInfo playbackInfo = this.F;
        return playbackInfo.f1146b.h(playbackInfo.c.a, this.l).l;
    }

    @Override // b.i.a.c.Player2
    public Player2.b i() {
        return this.C;
    }

    @Nullable
    public final Pair<Object, Long> i0(Timeline timeline, int i, long j) {
        if (timeline.q()) {
            this.G = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.H = j;
            return null;
        }
        if (i == -1 || i >= timeline.p()) {
            i = timeline.a(this.w);
            j = timeline.n(i, this.a).a();
        }
        return timeline.j(this.a, this.l, i, Util2.B(j));
    }

    @Override // b.i.a.c.Player2
    public boolean j() {
        return this.F.m;
    }

    @Override // b.i.a.c.Player2
    public void k(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            ((SystemHandlerWrapper.b) this.i.q.a(12, z2 ? 1 : 0, 0)).b();
            this.j.b(9, new n(z2));
            r0();
            this.j.a();
        }
    }

    @Override // b.i.a.c.Player2
    public long l() {
        return 3000L;
    }

    public final PlaybackInfo l0(PlaybackInfo playbackInfo, Timeline timeline, @Nullable Pair<Object, Long> pair) {
        MediaSource2.a aVar;
        TrackSelectorResult trackSelectorResult;
        List<Metadata> list;
        AnimatableValueParser.j(timeline.q() || pair != null);
        Timeline timeline2 = playbackInfo.f1146b;
        PlaybackInfo playbackInfoG = playbackInfo.g(timeline);
        if (timeline.q()) {
            MediaSource2.a aVar2 = PlaybackInfo.a;
            MediaSource2.a aVar3 = PlaybackInfo.a;
            long jB = Util2.B(this.H);
            TrackGroupArray trackGroupArray = TrackGroupArray.j;
            TrackSelectorResult trackSelectorResult2 = this.c;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            PlaybackInfo playbackInfoA = playbackInfoG.b(aVar3, jB, jB, jB, 0L, trackGroupArray, trackSelectorResult2, RegularImmutableList.l).a(aVar3);
            playbackInfoA.r = playbackInfoA.t;
            return playbackInfoA;
        }
        Object obj = playbackInfoG.c.a;
        int i = Util2.a;
        boolean z2 = !obj.equals(pair.first);
        MediaSource2.a aVar4 = z2 ? new MediaSource2.a(pair.first) : playbackInfoG.c;
        long jLongValue = ((Long) pair.second).longValue();
        long jB2 = Util2.B(w());
        if (!timeline2.q()) {
            jB2 -= timeline2.h(obj, this.l).n;
        }
        if (z2 || jLongValue < jB2) {
            AnimatableValueParser.D(!aVar4.a());
            TrackGroupArray trackGroupArray2 = z2 ? TrackGroupArray.j : playbackInfoG.i;
            if (z2) {
                aVar = aVar4;
                trackSelectorResult = this.c;
            } else {
                aVar = aVar4;
                trackSelectorResult = playbackInfoG.j;
            }
            TrackSelectorResult trackSelectorResult3 = trackSelectorResult;
            if (z2) {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator2 = ImmutableList2.k;
                list = RegularImmutableList.l;
            } else {
                list = playbackInfoG.k;
            }
            PlaybackInfo playbackInfoA2 = playbackInfoG.b(aVar, jLongValue, jLongValue, jLongValue, 0L, trackGroupArray2, trackSelectorResult3, list).a(aVar);
            playbackInfoA2.r = jLongValue;
            return playbackInfoA2;
        }
        if (jLongValue == jB2) {
            int iB = timeline.b(playbackInfoG.l.a);
            if (iB == -1 || timeline.f(iB, this.l).l != timeline.h(aVar4.a, this.l).l) {
                timeline.h(aVar4.a, this.l);
                long jA = aVar4.a() ? this.l.a(aVar4.f835b, aVar4.c) : this.l.m;
                playbackInfoG = playbackInfoG.b(aVar4, playbackInfoG.t, playbackInfoG.t, playbackInfoG.e, jA - playbackInfoG.t, playbackInfoG.i, playbackInfoG.j, playbackInfoG.k).a(aVar4);
                playbackInfoG.r = jA;
            }
        } else {
            AnimatableValueParser.D(!aVar4.a());
            long jMax = Math.max(0L, playbackInfoG.f1147s - (jLongValue - jB2));
            long j = playbackInfoG.r;
            if (playbackInfoG.l.equals(playbackInfoG.c)) {
                j = jLongValue + jMax;
            }
            playbackInfoG = playbackInfoG.b(aVar4, jLongValue, jLongValue, jLongValue, jMax, playbackInfoG.i, playbackInfoG.j, playbackInfoG.k);
            playbackInfoG.r = j;
        }
        return playbackInfoG;
    }

    @Override // b.i.a.c.Player2
    public int m() {
        if (this.F.f1146b.q()) {
            return 0;
        }
        PlaybackInfo playbackInfo = this.F;
        return playbackInfo.f1146b.b(playbackInfo.c.a);
    }

    public final long m0(Timeline timeline, MediaSource2.a aVar, long j) {
        timeline.h(aVar.a, this.l);
        return j + this.l.n;
    }

    @Override // b.i.a.c.Player2
    public void n(@Nullable TextureView textureView) {
    }

    public void n0() {
        String str;
        boolean z2;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str2 = Util2.e;
        HashSet<String> hashSet = ExoPlayerLibraryInfo.a;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = ExoPlayerLibraryInfo.f1016b;
        }
        StringBuilder sbS = outline.S(outline.b(str, outline.b(str2, outline.b(hexString, 36))), "Release ", hexString, " [", "ExoPlayerLib/2.16.0");
        outline.s0(sbS, "] [", str2, "] [", str);
        sbS.append("]");
        Log.i("ExoPlayerImpl", sbS.toString());
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = this.i;
        synchronized (exoPlayerImplInternal2) {
            if (exoPlayerImplInternal2.I || !exoPlayerImplInternal2.r.isAlive()) {
                z2 = true;
            } else {
                exoPlayerImplInternal2.q.f(7);
                long jD = exoPlayerImplInternal2.E;
                synchronized (exoPlayerImplInternal2) {
                    long jD2 = exoPlayerImplInternal2.f1010z.d() + jD;
                    boolean z3 = false;
                    while (!Boolean.valueOf(exoPlayerImplInternal2.I).booleanValue() && jD > 0) {
                        try {
                            exoPlayerImplInternal2.f1010z.c();
                            exoPlayerImplInternal2.wait(jD);
                        } catch (InterruptedException unused) {
                            z3 = true;
                        }
                        jD = jD2 - exoPlayerImplInternal2.f1010z.d();
                    }
                    if (z3) {
                        Thread.currentThread().interrupt();
                    }
                    z2 = exoPlayerImplInternal2.I;
                }
            }
        }
        if (!z2) {
            ListenerSet<Player2.c> listenerSet = this.j;
            listenerSet.b(10, b0.a);
            listenerSet.a();
        }
        this.j.c();
        this.g.j(null);
        AnalyticsCollector analyticsCollector = this.p;
        if (analyticsCollector != null) {
            this.r.d(analyticsCollector);
        }
        PlaybackInfo playbackInfoF = this.F.f(1);
        this.F = playbackInfoF;
        PlaybackInfo playbackInfoA = playbackInfoF.a(playbackInfoF.c);
        this.F = playbackInfoA;
        playbackInfoA.r = playbackInfoA.t;
        this.F.f1147s = 0L;
    }

    @Override // b.i.a.c.Player2
    public VideoSize o() {
        return VideoSize.j;
    }

    public void o0(Player2.c cVar) {
        ListenerSet<Player2.c> listenerSet = this.j;
        Iterator<ListenerSet.c<Player2.c>> it = listenerSet.d.iterator();
        while (it.hasNext()) {
            ListenerSet.c<Player2.c> next = it.next();
            if (next.a.equals(cVar)) {
                ListenerSet.b<Player2.c> bVar = listenerSet.c;
                next.d = true;
                if (next.c) {
                    bVar.a(next.a, next.f974b.b());
                }
                listenerSet.d.remove(next);
            }
        }
    }

    @Override // b.i.a.c.Player2
    public void p(Player2.e eVar) {
        o0(eVar);
    }

    public final void p0(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.m.remove(i3);
        }
        this.B = this.B.a(i, i2);
    }

    @Override // b.i.a.c.Player2
    public int q() {
        if (f()) {
            return this.F.c.c;
        }
        return -1;
    }

    public void q0(boolean z2, int i, int i2) {
        PlaybackInfo playbackInfo = this.F;
        if (playbackInfo.m == z2 && playbackInfo.n == i) {
            return;
        }
        this.f960x++;
        PlaybackInfo playbackInfoD = playbackInfo.d(z2, i);
        ((SystemHandlerWrapper.b) this.i.q.a(1, z2 ? 1 : 0, i)).b();
        s0(playbackInfoD, 0, i2, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // b.i.a.c.Player2
    public void r(@Nullable SurfaceView surfaceView) {
    }

    public final void r0() {
        Player2.b bVar = this.C;
        Player2.b bVar2 = this.d;
        Player2.b.a aVar = new Player2.b.a();
        aVar.a(bVar2);
        aVar.b(4, !f());
        aVar.b(5, a0() && !f());
        aVar.b(6, X() && !f());
        aVar.b(7, !K().q() && (X() || !Z() || a0()) && !f());
        aVar.b(8, W() && !f());
        aVar.b(9, !K().q() && (W() || (Z() && Y())) && !f());
        aVar.b(10, !f());
        aVar.b(11, a0() && !f());
        aVar.b(12, a0() && !f());
        Player2.b bVarC = aVar.c();
        this.C = bVarC;
        if (bVarC.equals(bVar)) {
            return;
        }
        this.j.b(13, new x(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s0(PlaybackInfo playbackInfo, int i, int i2, boolean z2, boolean z3, int i3, long j, int i4) {
        Pair pair;
        int i5;
        MediaItem2 mediaItem2;
        int i6;
        Object obj;
        MediaItem2 mediaItem22;
        Object obj2;
        int iB;
        long jJ0;
        long jJ02;
        Object obj3;
        MediaItem2 mediaItem23;
        Object obj4;
        int iB2;
        PlaybackInfo playbackInfo2 = this.F;
        this.F = playbackInfo;
        boolean z4 = !playbackInfo2.f1146b.equals(playbackInfo.f1146b);
        Timeline timeline = playbackInfo2.f1146b;
        Timeline timeline2 = playbackInfo.f1146b;
        if (timeline2.q() && timeline.q()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (timeline2.q() != timeline.q()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (timeline.n(timeline.h(playbackInfo2.c.a, this.l).l, this.a).n.equals(timeline2.n(timeline2.h(playbackInfo.c.a, this.l).l, this.a).n)) {
            pair = (z3 && i3 == 0 && playbackInfo2.c.d < playbackInfo.c.d) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z3 && i3 == 0) {
                i5 = 1;
            } else if (z3 && i3 == 1) {
                i5 = 2;
            } else {
                if (!z4) {
                    throw new IllegalStateException();
                }
                i5 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        int iIntValue = ((Integer) pair.second).intValue();
        MediaMetadata mediaMetadataE0 = this.D;
        if (zBooleanValue) {
            mediaItem2 = !playbackInfo.f1146b.q() ? playbackInfo.f1146b.n(playbackInfo.f1146b.h(playbackInfo.c.a, this.l).l, this.a).p : null;
            this.E = MediaMetadata.j;
        } else {
            mediaItem2 = null;
        }
        if (zBooleanValue || !playbackInfo2.k.equals(playbackInfo.k)) {
            MediaMetadata.b bVarA = this.E.a();
            List<Metadata> list = playbackInfo.k;
            for (int i7 = 0; i7 < list.size(); i7++) {
                Metadata metadata = list.get(i7);
                int i8 = 0;
                while (true) {
                    Metadata.Entry[] entryArr = metadata.j;
                    if (i8 < entryArr.length) {
                        entryArr[i8].n(bVarA);
                        i8++;
                    }
                }
            }
            this.E = bVarA.a();
            mediaMetadataE0 = e0();
        }
        boolean z5 = !mediaMetadataE0.equals(this.D);
        this.D = mediaMetadataE0;
        if (!playbackInfo2.f1146b.equals(playbackInfo.f1146b)) {
            this.j.b(0, new d0(playbackInfo, i));
        }
        if (z3) {
            Timeline.b bVar = new Timeline.b();
            if (playbackInfo2.f1146b.q()) {
                i6 = i4;
                obj = null;
                mediaItem22 = null;
                obj2 = null;
                iB = -1;
            } else {
                Object obj5 = playbackInfo2.c.a;
                playbackInfo2.f1146b.h(obj5, bVar);
                int i9 = bVar.l;
                obj2 = obj5;
                i6 = i9;
                iB = playbackInfo2.f1146b.b(obj5);
                obj = playbackInfo2.f1146b.n(i9, this.a).n;
                mediaItem22 = this.a.p;
            }
            if (i3 == 0) {
                jJ0 = bVar.n + bVar.m;
                if (playbackInfo2.c.a()) {
                    MediaSource2.a aVar = playbackInfo2.c;
                    jJ0 = bVar.a(aVar.f835b, aVar.c);
                    jJ02 = j0(playbackInfo2);
                    long jM = Util2.M(jJ0);
                    long jM2 = Util2.M(jJ02);
                    MediaSource2.a aVar2 = playbackInfo2.c;
                    Player2.f fVar = new Player2.f(obj, i6, mediaItem22, obj2, iB, jM, jM2, aVar2.f835b, aVar2.c);
                    int iC = C();
                    if (this.F.f1146b.q()) {
                        PlaybackInfo playbackInfo3 = this.F;
                        Object obj6 = playbackInfo3.c.a;
                        playbackInfo3.f1146b.h(obj6, this.l);
                        iB2 = this.F.f1146b.b(obj6);
                        obj4 = obj6;
                        obj3 = this.F.f1146b.n(iC, this.a).n;
                        mediaItem23 = this.a.p;
                    } else {
                        obj3 = null;
                        mediaItem23 = null;
                        obj4 = null;
                        iB2 = -1;
                    }
                    long jM3 = Util2.M(j);
                    long jM4 = !this.F.c.a() ? Util2.M(j0(this.F)) : jM3;
                    MediaSource2.a aVar3 = this.F.c;
                    this.j.b(11, new a0(i3, fVar, new Player2.f(obj3, iC, mediaItem23, obj4, iB2, jM3, jM4, aVar3.f835b, aVar3.c)));
                } else {
                    if (playbackInfo2.c.e != -1 && this.F.c.a()) {
                        jJ0 = j0(this.F);
                    }
                    jJ02 = jJ0;
                    long jM5 = Util2.M(jJ0);
                    long jM22 = Util2.M(jJ02);
                    MediaSource2.a aVar22 = playbackInfo2.c;
                    Player2.f fVar2 = new Player2.f(obj, i6, mediaItem22, obj2, iB, jM5, jM22, aVar22.f835b, aVar22.c);
                    int iC2 = C();
                    if (this.F.f1146b.q()) {
                    }
                    long jM32 = Util2.M(j);
                    if (!this.F.c.a()) {
                    }
                    MediaSource2.a aVar32 = this.F.c;
                    this.j.b(11, new a0(i3, fVar2, new Player2.f(obj3, iC2, mediaItem23, obj4, iB2, jM32, jM4, aVar32.f835b, aVar32.c)));
                }
            } else if (playbackInfo2.c.a()) {
                jJ0 = playbackInfo2.t;
                jJ02 = j0(playbackInfo2);
                long jM52 = Util2.M(jJ0);
                long jM222 = Util2.M(jJ02);
                MediaSource2.a aVar222 = playbackInfo2.c;
                Player2.f fVar22 = new Player2.f(obj, i6, mediaItem22, obj2, iB, jM52, jM222, aVar222.f835b, aVar222.c);
                int iC22 = C();
                if (this.F.f1146b.q()) {
                }
                long jM322 = Util2.M(j);
                if (!this.F.c.a()) {
                }
                MediaSource2.a aVar322 = this.F.c;
                this.j.b(11, new a0(i3, fVar22, new Player2.f(obj3, iC22, mediaItem23, obj4, iB2, jM322, jM4, aVar322.f835b, aVar322.c)));
            } else {
                jJ0 = bVar.n + playbackInfo2.t;
                jJ02 = jJ0;
                long jM522 = Util2.M(jJ0);
                long jM2222 = Util2.M(jJ02);
                MediaSource2.a aVar2222 = playbackInfo2.c;
                Player2.f fVar222 = new Player2.f(obj, i6, mediaItem22, obj2, iB, jM522, jM2222, aVar2222.f835b, aVar2222.c);
                int iC222 = C();
                if (this.F.f1146b.q()) {
                }
                long jM3222 = Util2.M(j);
                if (!this.F.c.a()) {
                }
                MediaSource2.a aVar3222 = this.F.c;
                this.j.b(11, new a0(i3, fVar222, new Player2.f(obj3, iC222, mediaItem23, obj4, iB2, jM3222, jM4, aVar3222.f835b, aVar3222.c)));
            }
        }
        if (zBooleanValue) {
            this.j.b(1, new z(mediaItem2, iIntValue));
        }
        if (playbackInfo2.g != playbackInfo.g) {
            this.j.b(10, new l(playbackInfo));
            if (playbackInfo.g != null) {
                this.j.b(10, new y(playbackInfo));
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo2.j;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.j;
        if (trackSelectorResult != trackSelectorResult2) {
            this.f.a(trackSelectorResult2.e);
            this.j.b(2, new q(playbackInfo, new TrackSelectionArray(playbackInfo.j.c)));
            this.j.b(2, new t(playbackInfo));
        }
        if (z5) {
            this.j.b(14, new p(this.D));
        }
        if (playbackInfo2.h != playbackInfo.h) {
            this.j.b(3, new o(playbackInfo));
        }
        if (playbackInfo2.f != playbackInfo.f || playbackInfo2.m != playbackInfo.m) {
            this.j.b(-1, new e0(playbackInfo));
        }
        if (playbackInfo2.f != playbackInfo.f) {
            this.j.b(4, new m(playbackInfo));
        }
        if (playbackInfo2.m != playbackInfo.m) {
            this.j.b(5, new s(playbackInfo, i2));
        }
        if (playbackInfo2.n != playbackInfo.n) {
            this.j.b(6, new r(playbackInfo));
        }
        if (k0(playbackInfo2) != k0(playbackInfo)) {
            this.j.b(7, new v(playbackInfo));
        }
        if (!playbackInfo2.o.equals(playbackInfo.o)) {
            this.j.b(12, new f0(playbackInfo));
        }
        if (z2) {
            this.j.b(-1, b.a);
        }
        r0();
        this.j.a();
        if (playbackInfo2.p != playbackInfo.p) {
            Iterator<ExoPlayer2.a> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().x(playbackInfo.p);
            }
        }
        if (playbackInfo2.q != playbackInfo.q) {
            Iterator<ExoPlayer2.a> it2 = this.k.iterator();
            while (it2.hasNext()) {
                it2.next().o(playbackInfo.q);
            }
        }
    }

    @Override // b.i.a.c.Player2
    @Nullable
    public PlaybackException t() {
        return this.F.g;
    }

    @Override // b.i.a.c.Player2
    public void u(boolean z2) {
        q0(z2, 0, 1);
    }

    @Override // b.i.a.c.Player2
    public long v() {
        return this.t;
    }

    @Override // b.i.a.c.Player2
    public long w() {
        if (!f()) {
            return T();
        }
        PlaybackInfo playbackInfo = this.F;
        playbackInfo.f1146b.h(playbackInfo.c.a, this.l);
        PlaybackInfo playbackInfo2 = this.F;
        return playbackInfo2.d == -9223372036854775807L ? playbackInfo2.f1146b.n(C(), this.a).a() : Util2.M(this.l.n) + Util2.M(this.F.d);
    }

    @Override // b.i.a.c.Player2
    public void x(Player2.e eVar) {
        d0(eVar);
    }

    @Override // b.i.a.c.Player2
    public int y() {
        return this.F.f;
    }
}
