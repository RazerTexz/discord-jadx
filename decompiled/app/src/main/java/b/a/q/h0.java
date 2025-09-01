package b.a.q;

import b.a.q.MediaSinkWantsLadder3;
import b.a.q.n0.RtcControlSocket;
import b.a.q.o0.RtcStatsCollector4;
import b.a.q.o0.VideoQuality;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.StreamParameters2;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.MediaSinkWantsManager9;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.io.Payloads;
import com.discord.utilities.logging.Logger;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;

/* compiled from: RtcConnection.kt */
/* loaded from: classes.dex */
public final class h0 implements RtcControlSocket.d {
    public final /* synthetic */ RtcConnection a;

    public h0(RtcConnection rtcConnection) {
        this.a = rtcConnection;
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void a(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "audioCodec");
        Intrinsics3.checkNotNullParameter(str2, "videoCodec");
        MediaEngineConnection mediaEngineConnection = this.a.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.r(str, str2);
        }
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void b(boolean z2, Integer num, String str) {
        RtcConnection rtcConnection = this.a;
        Objects.requireNonNull(rtcConnection);
        rtcConnection.r("Disconnected from RTC server. wasFatal: " + z2 + " -- code: " + num + " -- reason: " + str);
        MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection2 != null) {
            mediaEngineConnection2.o(rtcConnection.mediaEngineConnectionListener);
        }
        Long l = rtcConnection.networkLossTime;
        boolean z3 = (num == null || num.intValue() != 1000) && !(((l != null ? rtcConnection.clock.currentTimeMillis() - l.longValue() : 0L) > 30000L ? 1 : ((l != null ? rtcConnection.clock.currentTimeMillis() - l.longValue() : 0L) == 30000L ? 0 : -1)) > 0);
        if (!(rtcConnection.connectionStateChange.state instanceof RtcConnection.State.d)) {
            rtcConnection.n(z3, str);
            RtcStatsCollector4 rtcStatsCollector4 = rtcConnection.rtcStatsCollector;
            if (rtcStatsCollector4 != null) {
                rtcStatsCollector4.a();
            }
            rtcConnection.rtcStatsCollector = null;
            rtcConnection.sentVideo = false;
        }
        rtcConnection.pingBadCount = 0;
        rtcConnection.connectCompletedTime = null;
        MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.b(new MediaSinkWantsManager2(mediaSinkWantsManager));
        }
        rtcConnection.u(new RtcConnection.State.d(z3));
        if (z3) {
            Logger.w$default(rtcConnection.logger, rtcConnection.loggingTag, "Disconnect was not clean! Reason: " + str + ", code: " + num + ". Reconnecting in " + (rtcConnection.reconnectBackoff.fail(new d0(rtcConnection)) / 1000) + " seconds.", null, 4, null);
        }
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void c(String str, List<Integer> list) {
        Intrinsics3.checkNotNullParameter(str, "mode");
        Intrinsics3.checkNotNullParameter(list, "secretKey");
        MediaEngineConnection mediaEngineConnection = this.a.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.t(str, _Collections.toIntArray(list));
        }
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void d(String str) {
        Intrinsics3.checkNotNullParameter(str, "mediaSessionId");
        RtcConnection rtcConnection = this.a;
        rtcConnection.mediaSessionId = str;
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.c) it.next()).onMediaSessionIdReceived();
        }
        rtcConnection.p(RtcConnection.AnalyticsEvent.MEDIA_SESSION_JOINED, new LinkedHashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014e  */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List] */
    @Override // b.a.q.n0.RtcControlSocket.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(long j, int i, int i2, List<Payloads.Stream> list) {
        VideoMetadata videoMetadata;
        Object next;
        ?? EmptyList;
        RtcConnection rtcConnection = this.a;
        VideoQuality videoQuality = rtcConnection.videoQuality;
        long j2 = i2;
        synchronized (videoQuality) {
            if (j2 != 0) {
                videoQuality.n.put(Long.valueOf(j2), Long.valueOf(videoQuality.q.currentTimeMillis()));
                Logger.i$default(videoQuality.p, "VideoQuality: handleVideoStreamUpdate(userId: " + j + ", videoSsrc: " + j2 + ')', null, 2, null);
            }
        }
        if (j != rtcConnection.userId) {
            if (rtcConnection.localMediaSinkWantsManager != null) {
                if (list != null) {
                    EmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        EmptyList.add(Payloads.Stream.copy$default((Payloads.Stream) it.next(), MediaStreamTrack.VIDEO_TRACK_KIND, null, null, null, null, null, null, Boolean.valueOf(i2 > 0), null, 382, null));
                    }
                } else {
                    EmptyList = Collections2.emptyList();
                }
                boolean zIsEmpty = EmptyList.isEmpty();
                List listListOf = EmptyList;
                if (zIsEmpty) {
                    listListOf = CollectionsJVM.listOf(new Payloads.Stream(MediaStreamTrack.VIDEO_TRACK_KIND, "100", null, 100, Integer.valueOf(i2), Integer.valueOf(i2 + 1), null, Boolean.valueOf(i2 > 0), null));
                }
                rtcConnection.localMediaSinkWantsManager.c(j, Long.valueOf(i));
                MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
                Objects.requireNonNull(mediaSinkWantsManager);
                Intrinsics3.checkNotNullParameter(listListOf, "ssrcs");
                mediaSinkWantsManager.b(new MediaSinkWantsManager7(mediaSinkWantsManager, listListOf, j));
                return;
            }
            if (list != null) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    Payloads.Stream stream = (Payloads.Stream) next;
                    Integer ssrc = stream.getSsrc();
                    if ((ssrc == null || ssrc.intValue() != i2 || stream.getMaxResolution() == null) ? false : true) {
                        break;
                    }
                }
                Payloads.Stream stream2 = (Payloads.Stream) next;
                if (stream2 != null) {
                    Payloads.Stream.MaxResolution maxResolution = stream2.getMaxResolution();
                    Intrinsics3.checkNotNull(maxResolution);
                    videoMetadata = new VideoMetadata(j, maxResolution.getWidth(), stream2.getMaxResolution().getHeight(), stream2.getMaxFrameRate(), stream2.getMaxResolution().getType());
                } else {
                    videoMetadata = null;
                }
            }
            rtcConnection.d(j, i, j2, videoMetadata);
        }
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void f(Map<String, Integer> map) {
        Integer num;
        Intrinsics3.checkNotNullParameter(map, "wants");
        RtcConnection rtcConnection = this.a;
        if (rtcConnection.localMediaSinkWantsManager != null) {
            long j = rtcConnection.videoSsrc;
            int iIntValue = (j == 0 || (num = map.get(String.valueOf(j))) == null) ? 0 : num.intValue();
            Integer num2 = map.get("any");
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue <= 0) {
                iIntValue = iIntValue2 > 0 ? iIntValue2 : 100;
            }
            MediaSinkWantsLadder3.c cVar = null;
            rtcConnection.logger.i(rtcConnection.loggingTag, "remote MediaSinkWants: " + map + ", decided on encode quality " + iIntValue, null);
            MediaSinkWantsManager9[] mediaSinkWantsManager9ArrValues = MediaSinkWantsManager9.values();
            for (int i = 10; i >= 0; i--) {
                MediaSinkWantsManager9 mediaSinkWantsManager9 = mediaSinkWantsManager9ArrValues[i];
                if (mediaSinkWantsManager9.getValue() <= iIntValue) {
                    MediaSinkWantsLadder3 mediaSinkWantsLadder3 = rtcConnection.localMediaSinkWantsManager.j;
                    MediaSinkWantsLadder5 mediaSinkWantsLadder5 = mediaSinkWantsLadder3.e;
                    Intrinsics3.checkNotNullParameter(mediaSinkWantsManager9, "wantValue");
                    List<MediaSinkWantsLadder3.c> list = mediaSinkWantsLadder3.d;
                    ListIterator<MediaSinkWantsLadder3.c> listIterator = list.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            break;
                        }
                        MediaSinkWantsLadder3.c cVarPrevious = listIterator.previous();
                        if (mediaSinkWantsManager9.compareTo(cVarPrevious.c) >= 0) {
                            cVar = cVarPrevious;
                            break;
                        }
                    }
                    MediaSinkWantsLadder3.c cVar2 = cVar;
                    if (cVar2 == null) {
                        cVar2 = (MediaSinkWantsLadder3.c) _Collections.first((List) mediaSinkWantsLadder3.d);
                    }
                    MediaSinkWantsLadder6 mediaSinkWantsLadder6 = cVar2.a;
                    int iMax = Math.max((int) (mediaSinkWantsLadder5.c.a * mediaSinkWantsLadder6.c), mediaSinkWantsLadder5.d);
                    int iMax2 = Math.max((int) (mediaSinkWantsLadder5.c.f255b * mediaSinkWantsLadder6.c), mediaSinkWantsLadder5.d);
                    MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                    if (mediaEngineConnection != null) {
                        mediaEngineConnection.m(new MediaEngineConnection.b(iMax, iMax2, mediaSinkWantsLadder6.a, mediaSinkWantsLadder6.f274b, mediaSinkWantsLadder6.d, mediaSinkWantsLadder6.e));
                        return;
                    }
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void g(long j) {
        RtcConnection rtcConnection = this.a;
        rtcConnection.pings.add(Long.valueOf(j));
        if (rtcConnection.pings.size() > 5) {
            MutableCollections.removeFirst(rtcConnection.pings);
        }
        if (j > 500) {
            rtcConnection.pingBadCount++;
        }
        double d = j;
        Objects.requireNonNull(RtcConnection.Quality.INSTANCE);
        RtcConnection.Quality quality = Double.isNaN(d) ? RtcConnection.Quality.UNKNOWN : d < ((double) 250) ? RtcConnection.Quality.FINE : d < ((double) 500) ? RtcConnection.Quality.AVERAGE : RtcConnection.Quality.BAD;
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.c) it.next()).onQualityUpdate(quality);
        }
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void h() {
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void i() {
        RtcConnection rtcConnection = this.a;
        rtcConnection.reconnectBackoff.cancel();
        rtcConnection.logger.recordBreadcrumb("Connected to RTC server.", rtcConnection.loggingTag);
        RtcControlSocket rtcControlSocket = rtcConnection.socket;
        if (rtcControlSocket == null) {
            RtcConnection.o(rtcConnection, "onSocketConnect() socket was null.", null, null, 6);
            return;
        }
        List listListOf = CollectionsJVM.listOf(new Payloads.Stream(MediaStreamTrack.VIDEO_TRACK_KIND, "100", null, 100, null, null, null, null, null));
        String str = rtcConnection.rtcServerId;
        long j = rtcConnection.userId;
        String str2 = rtcConnection.sessionId;
        boolean z2 = rtcConnection.isVideoEnabled;
        Intrinsics3.checkNotNullParameter(str, "serverId");
        Intrinsics3.checkNotNullParameter(str2, "sessionId");
        Intrinsics3.checkNotNullParameter(listListOf, "streams");
        rtcControlSocket.H.a();
        rtcControlSocket.t = str;
        rtcControlSocket.u = str2;
        rtcControlSocket.B = RtcControlSocket.c.IDENTIFYING;
        rtcControlSocket.n(0, new Payloads.Identify(str, j, str2, rtcControlSocket.E, z2, listListOf));
        rtcConnection.u(RtcConnection.State.a.a);
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void j(long j) {
        Map<String, Object> mapC;
        RtcConnection rtcConnection = this.a;
        if ((rtcConnection.rtcConnectionType instanceof RtcConnection.d.a) && (mapC = rtcConnection.videoQuality.c(String.valueOf(j))) != null) {
            rtcConnection.l(j, mapC);
        }
        MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.c(j, null);
        }
        MediaSinkWantsManager mediaSinkWantsManager2 = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager2 != null) {
            List listEmptyList = Collections2.emptyList();
            Intrinsics3.checkNotNullParameter(listEmptyList, "ssrcs");
            mediaSinkWantsManager2.b(new MediaSinkWantsManager7(mediaSinkWantsManager2, listEmptyList, j));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    @Override // b.a.q.n0.RtcControlSocket.d
    public void k(int i, int i2, String str, List<Payloads.Stream> list) {
        MediaEngineConnection.Type type;
        Intrinsics3.checkNotNullParameter(str, "ip");
        Intrinsics3.checkNotNullParameter(list, "streams");
        RtcConnection rtcConnection = this.a;
        Objects.requireNonNull(rtcConnection);
        rtcConnection.r("Discovered dedicated UDP server on port " + i);
        rtcConnection.u(RtcConnection.State.g.a);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Payloads.Stream stream = (Payloads.Stream) it.next();
            StreamParameters2 streamParameters2 = MediaStreamTrack.VIDEO_TRACK_KIND.equals(stream.getType()) ? StreamParameters2.Video : StreamParameters2.Audio;
            String rid = stream.getRid();
            if (rid == null) {
                rid = "";
            }
            String str2 = rid;
            Integer ssrc = stream.getSsrc();
            int iIntValue = ssrc != null ? ssrc.intValue() : 0;
            Integer rtxSsrc = stream.getRtxSsrc();
            int iIntValue2 = rtxSsrc != null ? rtxSsrc.intValue() : 0;
            Boolean active = stream.getActive();
            boolean zBooleanValue = active != null ? active.booleanValue() : false;
            Integer maxBitrate = stream.getMaxBitrate();
            int iIntValue3 = maxBitrate != null ? maxBitrate.intValue() : 0;
            Integer quality = stream.getQuality();
            arrayList.add(new StreamParameters(streamParameters2, str2, iIntValue, iIntValue2, zBooleanValue, iIntValue3, quality != null ? quality.intValue() : 100, 0));
        }
        boolean zIsEmpty = arrayList.isEmpty();
        ArrayList arrayListListOf = arrayList;
        if (zIsEmpty) {
            arrayListListOf = CollectionsJVM.listOf(new StreamParameters(StreamParameters2.Video, "100", i2 + 1, i2 + 2, false, 0, 100, 0));
        }
        MediaEngine mediaEngine = rtcConnection.mediaEngine;
        long j = rtcConnection.userId;
        MediaEngine.a aVar = new MediaEngine.a(i2, str, i, arrayListListOf);
        RtcConnection.d dVar = rtcConnection.rtcConnectionType;
        if (Intrinsics3.areEqual(dVar, RtcConnection.d.a.a)) {
            type = MediaEngineConnection.Type.DEFAULT;
        } else {
            if (!(dVar instanceof RtcConnection.d.b)) {
                throw new NoWhenBranchMatchedException();
            }
            type = MediaEngineConnection.Type.STREAM;
        }
        MediaEngineConnection mediaEngineConnectionG = mediaEngine.g(j, aVar, type, new e0(rtcConnection));
        if (mediaEngineConnectionG == null) {
            RtcConnection.o(rtcConnection, "onSocketHello(): connect() return null.", null, null, 6);
        } else {
            mediaEngineConnectionG.l(rtcConnection.mediaEngineConnectionListener);
            rtcConnection.mediaEngineConnection = mediaEngineConnectionG;
        }
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void onConnecting() {
        RtcConnection rtcConnection = this.a;
        rtcConnection.reconnectBackoff.cancel();
        StringBuilder sb = new StringBuilder();
        sb.append("Connecting to RTC server ");
        RtcControlSocket rtcControlSocket = rtcConnection.socket;
        sb.append(rtcControlSocket != null ? rtcControlSocket.D : null);
        rtcConnection.r(sb.toString());
        rtcConnection.u(RtcConnection.State.c.a);
    }

    @Override // b.a.q.n0.RtcControlSocket.d
    public void onSpeaking(long j, int i, boolean z2) {
        RtcConnection rtcConnection = this.a;
        if (j != rtcConnection.userId) {
            MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
            if (mediaEngineConnection != null) {
                mediaEngineConnection.s(j, i, null, rtcConnection.g(j), rtcConnection.h(j));
            }
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.c(j, Long.valueOf(i));
            }
            Iterator<T> it = rtcConnection.listeners.iterator();
            while (it.hasNext()) {
                ((RtcConnection.c) it.next()).onUserCreated(rtcConnection, j);
            }
        }
    }
}
