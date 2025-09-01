package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.gateway.GatewaySocket;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ConnectionTimeStats.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002DEB\u000f\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J)\u0010#\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0018j\u0002`!2\u000e\u0010\u001b\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\"¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b'\u0010+J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b'\u0010.J\u0015\u0010'\u001a\u00020\u00042\u0006\u00100\u001a\u00020/¢\u0006\u0004\b'\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001e\u00105\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00104R\u0016\u00108\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00104R\u0016\u00109\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010:\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00104R\u0016\u0010;\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00104R\u0016\u0010<\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00104R\u0016\u0010=\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00104R\u0016\u0010>\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00104R\u0016\u0010?\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00104¨\u0006F"}, d2 = {"Lcom/discord/stores/ConnectionTimeStats;", "", "Lcom/discord/stores/ConnectionTimeStats$StatType;", "statType", "", "sendAnalyticsEvent", "(Lcom/discord/stores/ConnectionTimeStats$StatType;)V", "", "onlyCallStats", "clear", "(Z)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "handleVoiceStateUpdate", "(Lcom/discord/api/voice/state/VoiceState;)V", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "handleStreamWatch", "(Ljava/lang/String;)V", "", "userId", "", "streamId", "audioSsrc", "videoSsrc", "rtxSsrc", "handleVideoStreamUpdate", "(JLjava/lang/Integer;III)V", "Lcom/discord/primitives/UserId;", "Lcom/discord/primitives/StreamId;", "handleApplicationStreamUpdate", "(JLjava/lang/Integer;)V", "Lcom/discord/gateway/GatewaySocket;", "socket", "addListener", "(Lcom/discord/gateway/GatewaySocket;)V", "Lcom/discord/stores/StoreRtcConnection;", "rtcConnection", "(Lcom/discord/stores/StoreRtcConnection;)V", "Lcom/discord/stores/StoreStreamRtcConnection;", "streamRtcConnection", "(Lcom/discord/stores/StoreStreamRtcConnection;)V", "Lcom/discord/stores/StoreMediaEngine;", "storeMediaEngine", "(Lcom/discord/stores/StoreMediaEngine;)V", "Lcom/discord/stores/ConnectionTimeStats$Stat;", "videoFirstFrame", "Lcom/discord/stores/ConnectionTimeStats$Stat;", "myUserId", "Ljava/lang/Long;", "connectionStreamFirstFrame", "voiceConnection", "connectionVideoFirstFrame", "streamRequested", "gatewayHello", "streamFirstFrame", "gatewayConnection", "mediaEngineConnection", "streamConnection", "Lcom/discord/utilities/time/Clock;", "clock", "<init>", "(Lcom/discord/utilities/time/Clock;)V", "Stat", "StatType", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ConnectionTimeStats {
    private final Stat connectionStreamFirstFrame;
    private final Stat connectionVideoFirstFrame;
    private final Stat gatewayConnection;
    private final Stat gatewayHello;
    private final Stat mediaEngineConnection;
    private Long myUserId;
    private final Stat streamConnection;
    private final Stat streamFirstFrame;
    private final Stat streamRequested;
    private final Stat videoFirstFrame;
    private final Stat voiceConnection;

    /* compiled from: ConnectionTimeStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/ConnectionTimeStats$Stat;", "", "", "ignoreSubsequentCalls", "", "start", "(Z)V", "end", "", "Lcom/discord/utilities/time/ClockMilliseconds;", "elapsed", "()Ljava/lang/Long;", "clear", "()V", "Lcom/discord/stores/ConnectionTimeStats$StatType;", "type", "Lcom/discord/stores/ConnectionTimeStats$StatType;", "Lcom/discord/stores/ConnectionTimeStats;", "owner", "Lcom/discord/stores/ConnectionTimeStats;", "startTime", "Ljava/lang/Long;", "endTime", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/stores/ConnectionTimeStats;Lcom/discord/stores/ConnectionTimeStats$StatType;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Stat {
        private final Clock clock;
        private Long endTime;
        private final ConnectionTimeStats owner;
        private Long startTime;
        private final StatType type;

        public Stat(Clock clock, ConnectionTimeStats connectionTimeStats, StatType statType) {
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(connectionTimeStats, "owner");
            Intrinsics3.checkNotNullParameter(statType, "type");
            this.clock = clock;
            this.owner = connectionTimeStats;
            this.type = statType;
        }

        public static /* synthetic */ void end$default(Stat stat, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            stat.end(z2);
        }

        public static /* synthetic */ void start$default(Stat stat, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            stat.start(z2);
        }

        public final void clear() {
            this.startTime = null;
            this.endTime = null;
        }

        public final Long elapsed() {
            Long l = this.startTime;
            Long l2 = this.endTime;
            if (l == null || l2 == null) {
                return null;
            }
            return Long.valueOf(l2.longValue() - l.longValue());
        }

        public final void end(boolean ignoreSubsequentCalls) {
            if (this.endTime != null) {
                if (ignoreSubsequentCalls) {
                    return;
                }
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("ConnectionTimeStats: \"");
                sbU.append(this.type);
                sbU.append("\" attempting to end while endTime is set!");
                Logger.w$default(appLog, sbU.toString(), null, 2, null);
                return;
            }
            Long l = this.startTime;
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            if (l == null) {
                AppLog appLog2 = AppLog.g;
                StringBuilder sbU2 = outline.U("ConnectionTimeStats: \"");
                sbU2.append(this.type);
                sbU2.append("\" ended without starting!");
                Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
                return;
            }
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (jLongValue < 0) {
                AppLog appLog3 = AppLog.g;
                StringBuilder sbU3 = outline.U("ConnectionTimeStats: \"");
                sbU3.append(this.type);
                sbU3.append("\" has a negative time!");
                sbU3.append(_Collections.joinToString$default(Maps6.mapOf(Tuples.to(this.type.toString(), "type"), Tuples.to(String.valueOf(jLongValue), "elapsedMs"), Tuples.to(String.valueOf(l.longValue()), "start"), Tuples.to(String.valueOf(jCurrentTimeMillis), "end")).entrySet(), "\n\t", null, null, 0, null, null, 62, null));
                Logger.w$default(appLog3, sbU3.toString(), null, 2, null);
                return;
            }
            this.endTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbU4 = outline.U("ConnectionTimeStats: \"");
            sbU4.append(this.type);
            sbU4.append("\" took ");
            sbU4.append(jLongValue);
            sbU4.append(" ms (");
            sbU4.append(l);
            sbU4.append(" to ");
            sbU4.append(jCurrentTimeMillis);
            sbU4.append(')');
            AppLog.i(sbU4.toString());
            ConnectionTimeStats.access$sendAnalyticsEvent(this.owner, this.type);
        }

        public final void start(boolean ignoreSubsequentCalls) {
            if (this.startTime != null) {
                if (ignoreSubsequentCalls) {
                    return;
                }
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("ConnectionTimeStats: \"");
                sbU.append(this.type);
                sbU.append("\" attempting to re-start without reset!");
                Logger.w$default(appLog, sbU.toString(), null, 2, null);
                return;
            }
            if (this.endTime != null) {
                AppLog appLog2 = AppLog.g;
                StringBuilder sbU2 = outline.U("ConnectionTimeStats: \"");
                sbU2.append(this.type);
                sbU2.append("\" attempting to re-start while endTime is set!");
                Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
                return;
            }
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            this.startTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbU3 = outline.U("ConnectionTimeStats: \"");
            sbU3.append(this.type);
            sbU3.append("\" started @ ");
            sbU3.append(jCurrentTimeMillis);
            AppLog.i(sbU3.toString());
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/stores/ConnectionTimeStats$StatType;", "", "<init>", "(Ljava/lang/String;I)V", "GatewayConnection", "GatewayHello", "VoiceConnection", "StreamRequested", "StreamConnection", "MediaEngineConnection", "StreamFirstFrame", "VideoFirstFrame", "ConnectionStreamFirstFrame", "ConnectionVideoFirstFrame", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum StatType {
        GatewayConnection,
        GatewayHello,
        VoiceConnection,
        StreamRequested,
        StreamConnection,
        MediaEngineConnection,
        StreamFirstFrame,
        VideoFirstFrame,
        ConnectionStreamFirstFrame,
        ConnectionVideoFirstFrame
    }

    /* compiled from: ConnectionTimeStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/discord/stores/ConnectionTimeStats$addListener$1", "Lcom/discord/gateway/GatewaySocket$DefaultListener;", "Lcom/discord/gateway/GatewaySocket;", "gatewaySocket", "", "onConnecting", "(Lcom/discord/gateway/GatewaySocket;)V", "onConnected", "onHello", "onDisconnected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends GatewaySocket.DefaultListener {
        public AnonymousClass1() {
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onConnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.end$default(ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onConnecting(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.start$default(ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onDisconnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this).clear();
            ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this).clear();
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onHello(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.end$default(ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/stores/ConnectionTimeStats$addListener$2", "Lcom/discord/stores/StoreRtcConnection$DefaultListener;", "", "onConnecting", "()V", "onConnected", "", "Lcom/discord/primitives/SSRC;", "ssrc", "onFirstFrameReceived", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends StoreRtcConnection.DefaultListener {
        public AnonymousClass2() {
        }

        @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
        public void onConnected() {
            Stat.end$default(ConnectionTimeStats.access$getVoiceConnection$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
        public void onConnecting() {
            Stat.start$default(ConnectionTimeStats.access$getVoiceConnection$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getConnectionVideoFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getConnectionStreamFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
            Stat.end$default(ConnectionTimeStats.access$getVideoFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
            Stat.end$default(ConnectionTimeStats.access$getConnectionVideoFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/stores/ConnectionTimeStats$addListener$3", "Lcom/discord/stores/StoreStreamRtcConnection$DefaultListener;", "", "onConnecting", "()V", "onConnected", "", "Lcom/discord/primitives/SSRC;", "ssrc", "onFirstFrameReceived", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends StoreStreamRtcConnection.DefaultListener {
        public AnonymousClass3() {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnected() {
            Stat.end$default(ConnectionTimeStats.access$getStreamConnection$p(ConnectionTimeStats.this), false, 1, null);
            ConnectionTimeStats.access$getStreamFirstFrame$p(ConnectionTimeStats.this).start(true);
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnecting() {
            Stat.end$default(ConnectionTimeStats.access$getStreamRequested$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getStreamConnection$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
            Stat.end$default(ConnectionTimeStats.access$getStreamFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
            Stat.end$default(ConnectionTimeStats.access$getConnectionStreamFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/discord/stores/ConnectionTimeStats$addListener$4", "Lcom/discord/stores/StoreMediaEngine$DefaultListener;", "", "onConnecting", "()V", "onConnected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$4, reason: invalid class name */
    public static final class AnonymousClass4 extends StoreMediaEngine.DefaultListener {
        public AnonymousClass4() {
        }

        @Override // com.discord.stores.StoreMediaEngine.DefaultListener, com.discord.stores.StoreMediaEngine.Listener
        public void onConnected() {
            ConnectionTimeStats.access$getMediaEngineConnection$p(ConnectionTimeStats.this).end(true);
        }

        @Override // com.discord.stores.StoreMediaEngine.DefaultListener, com.discord.stores.StoreMediaEngine.Listener
        public void onConnecting() {
            Stat.start$default(ConnectionTimeStats.access$getMediaEngineConnection$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    public ConnectionTimeStats(Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        StatType statType = StatType.VideoFirstFrame;
        if (!Intrinsics3.areEqual(statType.toString(), "VideoFirstFrame")) {
            Logger.e$default(AppLog.g, "ConnectionTimeStats.StatType has been renamed!", null, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_NAME, statType.toString())), 2, null);
        }
        this.gatewayConnection = new Stat(clock, this, StatType.GatewayConnection);
        this.gatewayHello = new Stat(clock, this, StatType.GatewayHello);
        this.voiceConnection = new Stat(clock, this, StatType.VoiceConnection);
        this.streamRequested = new Stat(clock, this, StatType.StreamRequested);
        this.streamConnection = new Stat(clock, this, StatType.StreamConnection);
        this.streamFirstFrame = new Stat(clock, this, StatType.StreamFirstFrame);
        this.videoFirstFrame = new Stat(clock, this, statType);
        this.mediaEngineConnection = new Stat(clock, this, StatType.MediaEngineConnection);
        this.connectionVideoFirstFrame = new Stat(clock, this, StatType.ConnectionVideoFirstFrame);
        this.connectionStreamFirstFrame = new Stat(clock, this, StatType.ConnectionStreamFirstFrame);
    }

    public static final /* synthetic */ Stat access$getConnectionStreamFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.connectionStreamFirstFrame;
    }

    public static final /* synthetic */ Stat access$getConnectionVideoFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.connectionVideoFirstFrame;
    }

    public static final /* synthetic */ Stat access$getGatewayConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.gatewayConnection;
    }

    public static final /* synthetic */ Stat access$getGatewayHello$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.gatewayHello;
    }

    public static final /* synthetic */ Stat access$getMediaEngineConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.mediaEngineConnection;
    }

    public static final /* synthetic */ Stat access$getStreamConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamConnection;
    }

    public static final /* synthetic */ Stat access$getStreamFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamFirstFrame;
    }

    public static final /* synthetic */ Stat access$getStreamRequested$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamRequested;
    }

    public static final /* synthetic */ Stat access$getVideoFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.videoFirstFrame;
    }

    public static final /* synthetic */ Stat access$getVoiceConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.voiceConnection;
    }

    public static final /* synthetic */ void access$sendAnalyticsEvent(ConnectionTimeStats connectionTimeStats, StatType statType) {
        connectionTimeStats.sendAnalyticsEvent(statType);
    }

    private final void clear(boolean onlyCallStats) {
        if (!onlyCallStats) {
            this.gatewayConnection.clear();
            this.gatewayHello.clear();
        }
        this.voiceConnection.clear();
        this.streamRequested.clear();
        this.streamConnection.clear();
        this.streamFirstFrame.clear();
        this.videoFirstFrame.clear();
        this.mediaEngineConnection.clear();
        this.connectionVideoFirstFrame.clear();
        this.connectionStreamFirstFrame.clear();
    }

    public static /* synthetic */ void clear$default(ConnectionTimeStats connectionTimeStats, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        connectionTimeStats.clear(z2);
    }

    private final void sendAnalyticsEvent(StatType statType) {
        AnalyticsTracker.INSTANCE.videoEventTimes(statType.toString(), this.gatewayConnection.elapsed(), this.gatewayHello.elapsed(), this.voiceConnection.elapsed(), this.streamRequested.elapsed(), this.streamConnection.elapsed(), this.streamFirstFrame.elapsed(), this.videoFirstFrame.elapsed(), this.mediaEngineConnection.elapsed(), this.connectionVideoFirstFrame.elapsed(), this.connectionStreamFirstFrame.elapsed());
    }

    public final void addListener(GatewaySocket socket) {
        Intrinsics3.checkNotNullParameter(socket, "socket");
        socket.getListeners().add(new AnonymousClass1());
    }

    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.streamFirstFrame.start(true);
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        clear$default(this, false, 1, null);
        this.myUserId = Long.valueOf(payload.getMe().getId());
    }

    public final void handleStreamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Stat.start$default(this.streamRequested, false, 1, null);
    }

    public final void handleVideoStreamUpdate(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        if (videoSsrc != 0) {
            this.videoFirstFrame.start(true);
        }
    }

    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        long userId = voiceState.getUserId();
        Long l = this.myUserId;
        if (l != null && userId == l.longValue() && voiceState.getChannelId() == null) {
            clear(true);
        }
    }

    public final void addListener(StoreRtcConnection rtcConnection) {
        Intrinsics3.checkNotNullParameter(rtcConnection, "rtcConnection");
        rtcConnection.getListeners().add(new AnonymousClass2());
    }

    public final void addListener(StoreStreamRtcConnection streamRtcConnection) {
        Intrinsics3.checkNotNullParameter(streamRtcConnection, "streamRtcConnection");
        streamRtcConnection.getListeners().add(new AnonymousClass3());
    }

    public final void addListener(StoreMediaEngine storeMediaEngine) {
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        storeMediaEngine.getListeners().add(new AnonymousClass4());
    }
}
