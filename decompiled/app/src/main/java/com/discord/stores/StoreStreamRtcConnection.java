package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.a.q.MediaSinkWantsManager5;
import b.a.q.w;
import b.d.b.a.outline;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream3;
import com.discord.models.domain.ModelApplicationStream7;
import com.discord.models.domain.ModelPayload;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.debug.DebugPrintable3;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreStreamRtcConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u0002:\n\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001Bi\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010~\u001a\u00020}\u0012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010e\u001a\u00020d\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u0012\n\b\u0002\u0010\u008d\u0001\u001a\u00030\u008c\u0001\u0012\n\b\u0002\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\n\b\u0002\u0010\u0087\u0001\u001a\u00030\u0086\u0001¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJg\u0010\u0019\u001a\u00020\u00182\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u000e\u0010\u000e\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\r2\n\u0010\u0010\u001a\u00060\nj\u0002`\u000f2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0014\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\nj\u0002`\u000b2\u000e\u0010\u0017\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0016H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u0019\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\"\u001a\u00020\u00032\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020 0\u001fH\u0003¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010&J#\u0010*\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00112\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010&J;\u0010/\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00112\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010-H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00032\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0003H\u0004¢\u0006\u0004\b9\u0010\u0005J\r\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\r\u0010>\u001a\u00020=¢\u0006\u0004\b>\u0010?J\u0013\u0010A\u001a\b\u0012\u0004\u0012\u00020:0@¢\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180@¢\u0006\u0004\bC\u0010BJ\u0015\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060@¢\u0006\u0004\bD\u0010BJ\u0017\u0010G\u001a\u00020\u00032\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\u00032\u0006\u0010J\u001a\u00020IH\u0007¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\u00032\u0006\u0010N\u001a\u00020MH\u0007¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0003H\u0007¢\u0006\u0004\bQ\u0010\u0005J\u0017\u0010T\u001a\u00020\u00032\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bT\u0010UJ\u0015\u0010W\u001a\u00020\u00032\u0006\u0010V\u001a\u00020:¢\u0006\u0004\bW\u0010XJ\u001d\u0010Z\u001a\u00020\u00032\u000e\u0010Y\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0004\bZ\u0010[R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\\R\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020^0]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001a\u0010h\u001a\u00060\nj\u0002`g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001e\u0010j\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001f\u0010s\u001a\b\u0012\u0004\u0012\u00020^0r8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010wR\u0016\u0010S\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010xR\u0016\u0010y\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u0010{R\u0016\u0010|\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010wR\u0016\u0010~\u001a\u00020}8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001¨\u0006\u0096\u0001"}, d2 = {"Lcom/discord/stores/StoreStreamRtcConnection;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/utilities/debug/DebugPrintable;", "", "handleMediaSessionIdReceived", "()V", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "quality", "handleQualityUpdate", "(Lcom/discord/rtcconnection/RtcConnection$Quality;)V", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/primitives/SessionId;", "sessionId", "rtcServerId", "senderId", "Lcom/discord/primitives/StreamKey;", "streamKey", "Lcom/discord/rtcconnection/RtcConnection;", "createRtcConnection", "(JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)Lcom/discord/rtcconnection/RtcConnection;", "destroyRtcConnection", "rtcConnection", "updateRtcConnection", "(Lcom/discord/rtcconnection/RtcConnection;)V", "", "", "properties", "handleVideoStreamEndedAnalyticsEvent", "(Ljava/util/Map;)V", "message", "recordBreadcrumb", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_MESSAGE, "", "e", "logi", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "logw", "", "metadata", "loge", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "Lcom/discord/utilities/networking/NetworkMonitor;", "networkMonitor", "init", "(Lcom/discord/utilities/networking/NetworkMonitor;)V", "Lcom/discord/utilities/debug/DebugPrintBuilder;", "dp", "debugPrint", "(Lcom/discord/utilities/debug/DebugPrintBuilder;)V", "finalize", "", "getStreamVolume", "()F", "Lcom/discord/stores/StoreStreamRtcConnection$State;", "getState", "()Lcom/discord/stores/StoreStreamRtcConnection$State;", "Lrx/Observable;", "observeStreamVolume", "()Lrx/Observable;", "observeRtcConnection", "observeConnectionQuality", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/models/domain/StreamCreateOrUpdate;", "streamCreate", "handleStreamCreate", "(Lcom/discord/models/domain/StreamCreateOrUpdate;)V", "Lcom/discord/models/domain/StreamServerUpdate;", "streamServerUpdate", "handleStreamServerUpdate", "(Lcom/discord/models/domain/StreamServerUpdate;)V", "handleStreamDelete", "Lcom/discord/rtcconnection/RtcConnection$State;", "state", "handleStreamRtcConnectionStateChange", "(Lcom/discord/rtcconnection/RtcConnection$State;)V", "volume", "updateStreamVolume", "(F)V", "focusedParticipant", "updateFocusedParticipant", "(Ljava/lang/Long;)V", "Lcom/discord/rtcconnection/RtcConnection;", "Lcom/discord/utilities/collections/ListenerCollectionSubject;", "Lcom/discord/stores/StoreStreamRtcConnection$Listener;", "listenerSubject", "Lcom/discord/utilities/collections/ListenerCollectionSubject;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreAnalytics;", "analyticsStore", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/utilities/debug/DebugPrintableId;", "debugDisplayId", "J", "streamOwner", "Ljava/lang/Long;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StoreMediaEngine;", "mediaEngineStore", "Lcom/discord/stores/StoreMediaEngine;", "Lcom/discord/utilities/collections/ListenerCollection;", "listeners", "Lcom/discord/utilities/collections/ListenerCollection;", "getListeners", "()Lcom/discord/utilities/collections/ListenerCollection;", "Ljava/lang/String;", "Lcom/discord/stores/StoreStreamRtcConnection$State;", "streamVolume", "F", "Lcom/discord/utilities/networking/NetworkMonitor;", "loggingTag", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/stores/StoreRtcConnection;", "storeRtcConnection", "Lcom/discord/stores/StoreRtcConnection;", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "Lcom/discord/utilities/debug/DebugPrintableCollection;", "dpc", "Lcom/discord/utilities/debug/DebugPrintableCollection;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/StoreMediaEngine;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreRtcConnection;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/logging/Logger;Lcom/discord/utilities/debug/DebugPrintableCollection;)V", "Companion", "DefaultListener", "Listener", "RtcConnectionListener", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStreamRtcConnection extends StoreV2 implements DebugPrintable {
    public static final float MAX_STREAM_VOLUME = 300.0f;
    private static int instanceCounter;
    private final StoreAnalytics analyticsStore;
    private final Clock clock;
    private final long debugDisplayId;
    private final Dispatcher dispatcher;
    private final DebugPrintable3 dpc;
    private final ListenerCollection2<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Logger logger;
    private final String loggingTag;
    private final StoreMediaEngine mediaEngineStore;
    private NetworkMonitor networkMonitor;
    private final ObservationDeck observationDeck;
    private RtcConnection rtcConnection;
    private String sessionId;
    private State state;
    private final StoreRtcConnection storeRtcConnection;
    private final StoreStream storeStream;
    private Long streamOwner;
    private float streamVolume;
    private final StoreUser userStore;

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00022\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/discord/stores/StoreStreamRtcConnection$DefaultListener;", "Lcom/discord/stores/StoreStreamRtcConnection$Listener;", "", "onConnecting", "()V", "onConnected", "onFirstFrameSent", "", "Lcom/discord/primitives/SSRC;", "ssrc", "onFirstFrameReceived", "(J)V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnected() {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnecting() {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onFirstFrameSent() {
        }
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/stores/StoreStreamRtcConnection$Listener;", "", "", "onConnecting", "()V", "onConnected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onConnected();

        void onConnecting();

        /* synthetic */ void onFirstFrameReceived(long j);

        /* synthetic */ void onFirstFrameSent();
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0019J\u001b\u0010%\u001a\u00020\u00042\n\u0010$\u001a\u00060\u0007j\u0002`#H\u0016¢\u0006\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/stores/StoreStreamRtcConnection$RtcConnectionListener;", "Lcom/discord/rtcconnection/RtcConnection$b;", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "stateChange", "", "onStateChange", "(Lcom/discord/rtcconnection/RtcConnection$StateChange;)V", "", "userId", "", "streamId", "audioSsrc", "videoSsrc", "rtxSsrc", "onVideoStream", "(JLjava/lang/Integer;III)V", "Lcom/discord/rtcconnection/VideoMetadata;", "metadata", "onVideoMetadata", "(Lcom/discord/rtcconnection/VideoMetadata;)V", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "quality", "onQualityUpdate", "(Lcom/discord/rtcconnection/RtcConnection$Quality;)V", "onMediaSessionIdReceived", "()V", "Lcom/discord/rtcconnection/RtcConnection$AnalyticsEvent;", "event", "", "", "", "properties", "onAnalyticsEvent", "(Lcom/discord/rtcconnection/RtcConnection$AnalyticsEvent;Ljava/util/Map;)V", "onFirstFrameSent", "Lcom/discord/primitives/SSRC;", "ssrc", "onFirstFrameReceived", "(J)V", "<init>", "(Lcom/discord/stores/StoreStreamRtcConnection;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class RtcConnectionListener extends RtcConnection.b {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                RtcConnection.AnalyticsEvent.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[RtcConnection.AnalyticsEvent.VIDEO_STREAM_ENDED.ordinal()] = 1;
                iArr[RtcConnection.AnalyticsEvent.MEDIA_SESSION_JOINED.ordinal()] = 2;
            }
        }

        public RtcConnectionListener() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onAnalyticsEvent(RtcConnection.AnalyticsEvent event, Map<String, Object> properties) {
            Intrinsics3.checkNotNullParameter(event, "event");
            Intrinsics3.checkNotNullParameter(properties, "properties");
            int iOrdinal = event.ordinal();
            if (iOrdinal == 3) {
                StoreStreamRtcConnection.access$getDispatcher$p(StoreStreamRtcConnection.this).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onAnalyticsEvent$1(this, properties));
            } else {
                if (iOrdinal != 4) {
                    return;
                }
                StoreStreamRtcConnection.access$getAnalyticsStore$p(StoreStreamRtcConnection.this).trackMediaSessionJoined(properties);
            }
        }

        @Override // com.discord.rtcconnection.RtcConnection.b
        public void onFirstFrameReceived(long ssrc) {
            StoreStreamRtcConnection.access$getListenerSubject$p(StoreStreamRtcConnection.this).notify(new StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameReceived$1(ssrc));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b
        public void onFirstFrameSent() {
            StoreStreamRtcConnection.access$getListenerSubject$p(StoreStreamRtcConnection.this).notify(StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1.INSTANCE);
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onMediaSessionIdReceived() {
            StoreStreamRtcConnection.access$getDispatcher$p(StoreStreamRtcConnection.this).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onMediaSessionIdReceived$1(this));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onQualityUpdate(RtcConnection.Quality quality) {
            Intrinsics3.checkNotNullParameter(quality, "quality");
            StoreStreamRtcConnection.access$getDispatcher$p(StoreStreamRtcConnection.this).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onQualityUpdate$1(this, quality));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onStateChange(RtcConnection.StateChange stateChange) {
            Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
            StoreStreamRtcConnection.access$recordBreadcrumb(StoreStreamRtcConnection.this, "store state change: " + stateChange);
            if (Intrinsics3.areEqual(stateChange.state, RtcConnection.State.f.a)) {
                StoreStreamRtcConnection.access$getListenerSubject$p(StoreStreamRtcConnection.this).notify(StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1.INSTANCE);
            }
            StoreStreamRtcConnection.access$getDispatcher$p(StoreStreamRtcConnection.this).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onStateChange$2(this, stateChange));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onVideoMetadata(VideoMetadata metadata) {
            Intrinsics3.checkNotNullParameter(metadata, "metadata");
            StoreStreamRtcConnection.access$getDispatcher$p(StoreStreamRtcConnection.this).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onVideoMetadata$1(this, metadata));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onVideoStream(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
            StoreStreamRtcConnection.access$getDispatcher$p(StoreStreamRtcConnection.this).schedule(new StoreStreamRtcConnection$RtcConnectionListener$onVideoStream$1(this, userId, streamId));
        }
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0007R!\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u000b¨\u0006'"}, d2 = {"Lcom/discord/stores/StoreStreamRtcConnection$State;", "", "Lcom/discord/rtcconnection/RtcConnection$State;", "component1", "()Lcom/discord/rtcconnection/RtcConnection$State;", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "component2", "()Lcom/discord/rtcconnection/RtcConnection$Quality;", "", "Lcom/discord/primitives/MediaSessionId;", "component3", "()Ljava/lang/String;", "Lcom/discord/rtcconnection/RtcConnection;", "component4", "()Lcom/discord/rtcconnection/RtcConnection;", "rtcConnectionState", "connectionQuality", "mediaSessionId", "rtcConnection", "copy", "(Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Quality;Ljava/lang/String;Lcom/discord/rtcconnection/RtcConnection;)Lcom/discord/stores/StoreStreamRtcConnection$State;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/rtcconnection/RtcConnection;", "getRtcConnection", "Lcom/discord/rtcconnection/RtcConnection$State;", "getRtcConnectionState", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "getConnectionQuality", "Ljava/lang/String;", "getMediaSessionId", "<init>", "(Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Quality;Ljava/lang/String;Lcom/discord/rtcconnection/RtcConnection;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final RtcConnection.Quality connectionQuality;
        private final String mediaSessionId;
        private final RtcConnection rtcConnection;
        private final RtcConnection.State rtcConnectionState;

        public State(RtcConnection.State state, RtcConnection.Quality quality, String str, RtcConnection rtcConnection) {
            Intrinsics3.checkNotNullParameter(state, "rtcConnectionState");
            this.rtcConnectionState = state;
            this.connectionQuality = quality;
            this.mediaSessionId = str;
            this.rtcConnection = rtcConnection;
        }

        public static /* synthetic */ State copy$default(State state, RtcConnection.State state2, RtcConnection.Quality quality, String str, RtcConnection rtcConnection, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.rtcConnectionState;
            }
            if ((i & 2) != 0) {
                quality = state.connectionQuality;
            }
            if ((i & 4) != 0) {
                str = state.mediaSessionId;
            }
            if ((i & 8) != 0) {
                rtcConnection = state.rtcConnection;
            }
            return state.copy(state2, quality, str, rtcConnection);
        }

        /* renamed from: component1, reason: from getter */
        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        /* renamed from: component2, reason: from getter */
        public final RtcConnection.Quality getConnectionQuality() {
            return this.connectionQuality;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* renamed from: component4, reason: from getter */
        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        public final State copy(RtcConnection.State rtcConnectionState, RtcConnection.Quality connectionQuality, String mediaSessionId, RtcConnection rtcConnection) {
            Intrinsics3.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
            return new State(rtcConnectionState, connectionQuality, mediaSessionId, rtcConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.rtcConnectionState, state.rtcConnectionState) && Intrinsics3.areEqual(this.connectionQuality, state.connectionQuality) && Intrinsics3.areEqual(this.mediaSessionId, state.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnection, state.rtcConnection);
        }

        public final RtcConnection.Quality getConnectionQuality() {
            return this.connectionQuality;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public int hashCode() {
            RtcConnection.State state = this.rtcConnectionState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            RtcConnection.Quality quality = this.connectionQuality;
            int iHashCode2 = (iHashCode + (quality != null ? quality.hashCode() : 0)) * 31;
            String str = this.mediaSessionId;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            RtcConnection rtcConnection = this.rtcConnection;
            return iHashCode3 + (rtcConnection != null ? rtcConnection.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(rtcConnectionState=");
            sbU.append(this.rtcConnectionState);
            sbU.append(", connectionQuality=");
            sbU.append(this.connectionQuality);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", rtcConnection=");
            sbU.append(this.rtcConnection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreStreamRtcConnection$Listener;", "it", "", "invoke", "(Lcom/discord/stores/StoreStreamRtcConnection$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStreamRtcConnection$createRtcConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnecting();
        }
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$Quality;", "invoke", "()Lcom/discord/rtcconnection/RtcConnection$Quality;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStreamRtcConnection$observeConnectionQuality$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<RtcConnection.Quality> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ RtcConnection.Quality invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RtcConnection.Quality invoke() {
            return StoreStreamRtcConnection.this.getState().getConnectionQuality();
        }
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection;", "invoke", "()Lcom/discord/rtcconnection/RtcConnection;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStreamRtcConnection$observeRtcConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<RtcConnection> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ RtcConnection invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RtcConnection invoke() {
            return StoreStreamRtcConnection.this.getState().getRtcConnection();
        }
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()F", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStreamRtcConnection$observeStreamVolume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Float> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Float invoke() {
            return Float.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final float invoke2() {
            return StoreStreamRtcConnection.this.getStreamVolume();
        }
    }

    /* compiled from: StoreStreamRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStreamRtcConnection$updateStreamVolume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ float $volume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f) {
            super(0);
            this.$volume = f;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStreamRtcConnection.access$setStreamVolume$p(StoreStreamRtcConnection.this, this.$volume);
            Long lAccess$getStreamOwner$p = StoreStreamRtcConnection.access$getStreamOwner$p(StoreStreamRtcConnection.this);
            if (lAccess$getStreamOwner$p != null) {
                long jLongValue = lAccess$getStreamOwner$p.longValue();
                RtcConnection rtcConnectionAccess$getRtcConnection$p = StoreStreamRtcConnection.access$getRtcConnection$p(StoreStreamRtcConnection.this);
                if (rtcConnectionAccess$getRtcConnection$p != null) {
                    rtcConnectionAccess$getRtcConnection$p.v(jLongValue, this.$volume);
                }
            }
            StoreStreamRtcConnection.this.markChanged();
        }
    }

    public /* synthetic */ StoreStreamRtcConnection(StoreMediaEngine storeMediaEngine, StoreUser storeUser, StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, Logger logger, DebugPrintable3 debugPrintable3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMediaEngine, storeUser, storeStream, dispatcher, clock, storeAnalytics, storeRtcConnection, (i & 128) != 0 ? ObservationDeck4.get() : observationDeck, (i & 256) != 0 ? AppLog.g : logger, (i & 512) != 0 ? SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease() : debugPrintable3);
    }

    public static final /* synthetic */ StoreAnalytics access$getAnalyticsStore$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.analyticsStore;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.dispatcher;
    }

    public static final /* synthetic */ ListenerCollection2 access$getListenerSubject$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.listenerSubject;
    }

    public static final /* synthetic */ RtcConnection access$getRtcConnection$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.rtcConnection;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.storeStream;
    }

    public static final /* synthetic */ Long access$getStreamOwner$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.streamOwner;
    }

    public static final /* synthetic */ float access$getStreamVolume$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.streamVolume;
    }

    public static final /* synthetic */ void access$handleMediaSessionIdReceived(StoreStreamRtcConnection storeStreamRtcConnection) {
        storeStreamRtcConnection.handleMediaSessionIdReceived();
    }

    public static final /* synthetic */ void access$handleQualityUpdate(StoreStreamRtcConnection storeStreamRtcConnection, RtcConnection.Quality quality) {
        storeStreamRtcConnection.handleQualityUpdate(quality);
    }

    public static final /* synthetic */ void access$handleVideoStreamEndedAnalyticsEvent(StoreStreamRtcConnection storeStreamRtcConnection, Map map) {
        storeStreamRtcConnection.handleVideoStreamEndedAnalyticsEvent(map);
    }

    public static final /* synthetic */ void access$recordBreadcrumb(StoreStreamRtcConnection storeStreamRtcConnection, String str) {
        storeStreamRtcConnection.recordBreadcrumb(str);
    }

    public static final /* synthetic */ void access$setRtcConnection$p(StoreStreamRtcConnection storeStreamRtcConnection, RtcConnection rtcConnection) {
        storeStreamRtcConnection.rtcConnection = rtcConnection;
    }

    public static final /* synthetic */ void access$setStreamOwner$p(StoreStreamRtcConnection storeStreamRtcConnection, Long l) {
        storeStreamRtcConnection.streamOwner = l;
    }

    public static final /* synthetic */ void access$setStreamVolume$p(StoreStreamRtcConnection storeStreamRtcConnection, float f) {
        storeStreamRtcConnection.streamVolume = f;
    }

    @Store3
    private final RtcConnection createRtcConnection(long userId, Long guildId, long channelId, String sessionId, String rtcServerId, long senderId, String streamKey) {
        destroyRtcConnection();
        RtcConnection.Metadata rtcConnectionMetadata = this.storeRtcConnection.getRtcConnectionMetadata();
        String str = null;
        Long l = rtcConnectionMetadata != null ? rtcConnectionMetadata.channelId : null;
        if (l != null && l.longValue() == channelId) {
            str = rtcConnectionMetadata.mediaSessionId;
        }
        String str2 = str;
        this.listenerSubject.notify(AnonymousClass1.INSTANCE);
        MediaEngine mediaEngine = this.mediaEngineStore.getMediaEngine();
        Logger logger = this.logger;
        Clock clock = this.clock;
        RtcConnection.d.b bVar = new RtcConnection.d.b(senderId);
        NetworkMonitor networkMonitor = this.networkMonitor;
        if (networkMonitor == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("networkMonitor");
        }
        RtcConnection rtcConnection = new RtcConnection(guildId, channelId, sessionId, true, rtcServerId, userId, mediaEngine, logger, clock, bVar, networkMonitor, null, null, str2, false, this.loggingTag, streamKey, 6144);
        rtcConnection.c(new RtcConnectionListener());
        return rtcConnection;
    }

    @Store3
    private final void destroyRtcConnection() {
        if (this.rtcConnection != null) {
            recordBreadcrumb("destroying stream rtc connection");
            updateRtcConnection(null);
            this.state = State.copy$default(this.state, null, null, null, null, 9, null);
            markChanged();
        }
    }

    @Store3
    private final void handleMediaSessionIdReceived() {
        RtcConnection rtcConnection = this.rtcConnection;
        this.state = State.copy$default(this.state, null, null, rtcConnection != null ? rtcConnection.mediaSessionId : null, null, 11, null);
        markChanged();
    }

    @Store3
    private final void handleQualityUpdate(RtcConnection.Quality quality) {
        this.state = State.copy$default(this.state, null, quality, null, null, 13, null);
        markChanged();
    }

    @Store3
    private final void handleVideoStreamEndedAnalyticsEvent(Map<String, Object> properties) {
        this.analyticsStore.trackVideoStreamEnded(properties);
    }

    private final void loge(String msg, Throwable e, Map<String, String> metadata) {
        this.logger.e(this.loggingTag, msg, e, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loge$default(StoreStreamRtcConnection storeStreamRtcConnection, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        storeStreamRtcConnection.loge(str, th, map);
    }

    private final void logi(String msg, Throwable e) {
        this.logger.i(this.loggingTag, msg, e);
    }

    public static /* synthetic */ void logi$default(StoreStreamRtcConnection storeStreamRtcConnection, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        storeStreamRtcConnection.logi(str, th);
    }

    private final void logw(String msg) {
        Logger.w$default(this.logger, this.loggingTag, msg, null, 4, null);
    }

    private final void recordBreadcrumb(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    @Store3
    private final void updateRtcConnection(RtcConnection rtcConnection) {
        RtcConnection rtcConnection2 = this.rtcConnection;
        if (rtcConnection2 != null) {
            rtcConnection2.e();
        }
        this.rtcConnection = rtcConnection;
        this.state = State.copy$default(this.state, null, null, null, rtcConnection, 7, null);
        markChanged();
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintable2 dp) {
        Intrinsics3.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue("sessionId", this.sessionId);
        dp.appendKeyValue("streamOwner", this.streamOwner);
        dp.appendKeyValue("streamVolume", Float.valueOf(this.streamVolume));
        dp.appendKeyValue("state", this.state);
        dp.appendKeyValue("rtcConnection", (DebugPrintable) this.rtcConnection);
    }

    public final void finalize() {
        this.dpc.remove(this.debugDisplayId);
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final State getState() {
        return this.state;
    }

    public final float getStreamVolume() {
        return this.streamVolume;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
    }

    @Store3
    public final void handleStreamCreate(ModelApplicationStream3 streamCreate) {
        Long lValueOf;
        Intrinsics3.checkNotNullParameter(streamCreate, "streamCreate");
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamCreate.getStreamKey());
        long id2 = this.userStore.getMe().getId();
        String str = this.sessionId;
        if (str != null) {
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null && rtcConnection.channelId == modelApplicationStreamDecodeStreamKey.getChannelId()) {
                RtcConnection rtcConnection2 = this.rtcConnection;
                if (Intrinsics3.areEqual(rtcConnection2 != null ? rtcConnection2.sessionId : null, str)) {
                    return;
                }
            }
            if (modelApplicationStreamDecodeStreamKey instanceof ModelApplicationStream.GuildStream) {
                lValueOf = Long.valueOf(((ModelApplicationStream.GuildStream) modelApplicationStreamDecodeStreamKey).getGuildId());
            } else {
                if (!(modelApplicationStreamDecodeStreamKey instanceof ModelApplicationStream.CallStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                lValueOf = null;
            }
            long channelId = modelApplicationStreamDecodeStreamKey.getChannelId();
            String rtcServerId = streamCreate.getRtcServerId();
            Intrinsics3.checkNotNull(rtcServerId);
            updateRtcConnection(createRtcConnection(id2, lValueOf, channelId, str, rtcServerId, modelApplicationStreamDecodeStreamKey.getOwnerId(), streamCreate.getStreamKey()));
            this.streamOwner = Long.valueOf(modelApplicationStreamDecodeStreamKey.getOwnerId());
        }
    }

    @Store3
    public final void handleStreamDelete() {
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            rtcConnection.t(null, null);
        }
        destroyRtcConnection();
        this.streamOwner = null;
    }

    @Store3
    public final void handleStreamRtcConnectionStateChange(RtcConnection.State state) {
        Long l;
        Intrinsics3.checkNotNullParameter(state, "state");
        if (Intrinsics3.areEqual(state, RtcConnection.State.f.a) && (l = this.streamOwner) != null) {
            long jLongValue = l.longValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.v(jLongValue, this.streamVolume);
            }
        }
        this.state = State.copy$default(this.state, state, null, null, null, 12, null);
        markChanged();
    }

    @Store3
    public final void handleStreamServerUpdate(ModelApplicationStream7 streamServerUpdate) {
        Intrinsics3.checkNotNullParameter(streamServerUpdate, "streamServerUpdate");
        Objects.requireNonNull(App.INSTANCE);
        SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = App.access$getIS_LOCAL$cp() ? null : SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
        StringBuilder sbU = outline.U("Voice stream update, connect to server w/ endpoint: ");
        sbU.append(streamServerUpdate.getEndpoint());
        recordBreadcrumb(sbU.toString());
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null) {
            loge$default(this, "handleStreamServerUpdate() rtcConnection is null.", null, null, 6, null);
        } else {
            rtcConnection.s(new w(rtcConnection, streamServerUpdate.getEndpoint(), streamServerUpdate.getToken(), sSLSocketFactoryCreateSocketFactory$default));
        }
    }

    public final void init(NetworkMonitor networkMonitor) {
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.networkMonitor = networkMonitor;
    }

    public final Observable<RtcConnection.Quality> observeConnectionQuality() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<RtcConnection> observeRtcConnection() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Float> observeStreamVolume() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void updateFocusedParticipant(Long focusedParticipant) {
        MediaSinkWantsManager mediaSinkWantsManager;
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager) == null) {
            return;
        }
        mediaSinkWantsManager.b(new MediaSinkWantsManager5(mediaSinkWantsManager, focusedParticipant));
    }

    public final void updateStreamVolume(float volume) {
        this.dispatcher.schedule(new AnonymousClass1(volume));
    }

    public StoreStreamRtcConnection(StoreMediaEngine storeMediaEngine, StoreUser storeUser, StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, Logger logger, DebugPrintable3 debugPrintable3) {
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        Intrinsics3.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(debugPrintable3, "dpc");
        this.mediaEngineStore = storeMediaEngine;
        this.userStore = storeUser;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.analyticsStore = storeAnalytics;
        this.storeRtcConnection = storeRtcConnection;
        this.observationDeck = observationDeck;
        this.logger = logger;
        this.dpc = debugPrintable3;
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        this.state = new State(new RtcConnection.State.d(false), null, null, this.rtcConnection);
        this.streamVolume = 300.0f;
        StringBuilder sbU = outline.U("StoreStreamRtcConnection ");
        int i = instanceCounter + 1;
        instanceCounter = i;
        sbU.append(i);
        String string = sbU.toString();
        this.loggingTag = string;
        this.debugDisplayId = debugPrintable3.add(this, string);
    }
}
