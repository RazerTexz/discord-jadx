package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream3;
import com.discord.models.domain.ModelApplicationStream5;
import com.discord.models.domain.ModelPayload;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.logging.Logger;
import d0.g0.Indent;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreApplicationStreaming.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002wxB9\u0012\u0006\u0010r\u001a\u00020q\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010h\u001a\u00020g\u0012\b\b\u0002\u0010k\u001a\u00020j¢\u0006\u0004\bu\u0010vJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u0011\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\rH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\tH\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b\u001f\u0010 J#\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u001e0\u001d0!¢\u0006\u0004\b\"\u0010#J/\u0010&\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u001e0\u001d0!2\n\u0010%\u001a\u00060\u000ej\u0002`$¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0!2\n\u0010(\u001a\u00060\u000ej\u0002`\u000f¢\u0006\u0004\b)\u0010'J-\u0010*\u001a\"\u0012\u001e\u0012\u001c\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r0\u001d0!¢\u0006\u0004\b*\u0010#J\u0015\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130!¢\u0006\u0004\b+\u0010#J\u001b\u0010,\u001a\u00020\u000b2\n\u0010(\u001a\u00060\u000ej\u0002`\u000fH\u0007¢\u0006\u0004\b,\u0010-J9\u00101\u001a\u0004\u0018\u0001002\n\u0010(\u001a\u00060\u000ej\u0002`\u000f2\n\u0010/\u001a\u00060\u000ej\u0002`.2\u000e\u0010%\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`$H\u0007¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J%\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u0002072\f\b\u0002\u0010%\u001a\u00060\u000ej\u0002`$H\u0007¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\tH\u0007¢\u0006\u0004\b;\u0010\u0006J\u001b\u0010<\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\tH\u0007¢\u0006\u0004\b<\u0010\u0006J\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=H\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020=H\u0007¢\u0006\u0004\bB\u0010@J\u0017\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bE\u0010FJ\u001b\u0010G\u001a\u00020\u00042\n\u0010/\u001a\u00060\u000ej\u0002`.H\u0007¢\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\tH\u0007¢\u0006\u0004\bI\u0010\u0006J\u000f\u0010J\u001a\u00020\u0004H\u0017¢\u0006\u0004\bJ\u0010\bJ#\u0010L\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\t2\b\b\u0002\u0010K\u001a\u00020\u000b¢\u0006\u0004\bL\u0010MJ5\u0010O\u001a\u00020\u00042\n\u0010/\u001a\u00060\u000ej\u0002`.2\u000e\u0010%\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`$2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\t¢\u0006\u0004\bQ\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0015\u0010RR0\u0010S\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR&\u0010X\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010TR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R:\u0010b\u001a&\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u001e0`j\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u001e`a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oRN\u0010p\u001a:\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r0`j\u001c\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r`a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010cR\u0016\u0010r\u001a\u00020q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010L\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010t¨\u0006y"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming;", "Lcom/discord/stores/StoreV2;", "", "message", "", "addBreadCrumb", "(Ljava/lang/String;)V", "dumpBreadcrumbs", "()V", "Lcom/discord/primitives/StreamKey;", "streamKey", "", "paused", "", "", "Lcom/discord/primitives/UserId;", "viewerIds", "handleStreamCreateOrUpdate", "(Ljava/lang/String;ZLjava/util/List;)V", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "activeApplicationStream", "isScreenSharing", "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;)Z", "stopStreamInternal", "updateActiveApplicationStream", "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;)V", "getActiveApplicationStreamKeyInternal$app_productionGoogleRelease", "()Ljava/lang/String;", "getActiveApplicationStreamKeyInternal", "", "Lcom/discord/models/domain/ModelApplicationStream;", "getStreamsByUser", "()Ljava/util/Map;", "Lrx/Observable;", "observeStreamsByUser", "()Lrx/Observable;", "Lcom/discord/primitives/GuildId;", "guildId", "observeStreamsForGuild", "(J)Lrx/Observable;", "userId", "observeStreamsForUser", "observeStreamSpectators", "observeActiveStream", "isUserStreaming", "(J)Z", "Lcom/discord/primitives/ChannelId;", "channelId", "", "getMaxViewersForStream", "(JJLjava/lang/Long;)Ljava/lang/Integer;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "handleVoiceStateUpdate", "(Lcom/discord/api/voice/state/VoiceState;J)V", "handleStreamWatch", "handleStreamCreateRequest", "Lcom/discord/models/domain/StreamCreateOrUpdate;", "streamCreate", "handleStreamCreate", "(Lcom/discord/models/domain/StreamCreateOrUpdate;)V", "streamUpdate", "handleStreamUpdate", "Lcom/discord/models/domain/StreamDelete;", "streamDelete", "handleStreamDelete", "(Lcom/discord/models/domain/StreamDelete;)V", "handleVoiceChannelSelected", "(J)V", "handleStreamTargeted", "snapshotData", "force", "targetStream", "(Ljava/lang/String;Z)V", "preferredRegion", "createStream", "(JLjava/lang/Long;Ljava/lang/String;)V", "stopStream", "()Z", "streamSpectatorsSnapshot", "Ljava/util/Map;", "Lkotlin/collections/ArrayDeque;", "breadCrumbs", "Lkotlin/collections/ArrayDeque;", "streamsByUserSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "streamsByUser", "Ljava/util/HashMap;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StoreRtcConnection;", "rtcConnectionStore", "Lcom/discord/stores/StoreRtcConnection;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreApplicationStreaming$StreamViewerTracker;", "streamViewerTracker", "Lcom/discord/stores/StoreApplicationStreaming$StreamViewerTracker;", "streamSpectators", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/models/domain/ModelApplicationStream;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreRtcConnection;Lcom/discord/stores/updates/ObservationDeck;)V", "ActiveApplicationStream", "StreamViewerTracker", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreApplicationStreaming extends StoreV2 {
    private ActiveApplicationStream activeApplicationStream;
    private final ArrayDeque<String> breadCrumbs;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreRtcConnection rtcConnectionStore;
    private final StoreStream storeStream;
    private final HashMap<String, List<Long>> streamSpectators;
    private Map<String, ? extends List<Long>> streamSpectatorsSnapshot;
    private final StreamViewerTracker streamViewerTracker;
    private final HashMap<Long, ModelApplicationStream> streamsByUser;
    private Map<Long, ? extends ModelApplicationStream> streamsByUserSnapshot;
    private ModelApplicationStream targetStream;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;", "component1", "()Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;", "Lcom/discord/models/domain/ModelApplicationStream;", "component2", "()Lcom/discord/models/domain/ModelApplicationStream;", "state", "stream", "copy", "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;Lcom/discord/models/domain/ModelApplicationStream;)Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;", "getState", "Lcom/discord/models/domain/ModelApplicationStream;", "getStream", "<init>", "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;Lcom/discord/models/domain/ModelApplicationStream;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ActiveApplicationStream {
        private final State state;
        private final ModelApplicationStream stream;

        /* compiled from: StoreApplicationStreaming.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;", "", "", "isStreamActive", "()Z", "<init>", "(Ljava/lang/String;I)V", "Companion", "CONNECTING", "ACTIVE", "RECONNECTING", "ENDED", "PAUSED", "DENIED_FULL", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum State {
            CONNECTING,
            ACTIVE,
            RECONNECTING,
            ENDED,
            PAUSED,
            DENIED_FULL;


            @Deprecated
            private static final List<State> ACTIVE_STATES;
            private static final Companion Companion;

            /* compiled from: StoreApplicationStreaming.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State$Companion;", "", "", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;", "ACTIVE_STATES", "Ljava/util/List;", "getACTIVE_STATES", "()Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public final List<State> getACTIVE_STATES() {
                    return State.access$getACTIVE_STATES$cp();
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            static {
                State state = CONNECTING;
                State state2 = ACTIVE;
                State state3 = RECONNECTING;
                State state4 = PAUSED;
                Companion = new Companion(null);
                ACTIVE_STATES = Collections2.listOf((Object[]) new State[]{state, state2, state3, state4});
            }

            public static final /* synthetic */ List access$getACTIVE_STATES$cp() {
                return ACTIVE_STATES;
            }

            public final boolean isStreamActive() {
                return ACTIVE_STATES.contains(this);
            }
        }

        public ActiveApplicationStream(State state, ModelApplicationStream modelApplicationStream) {
            Intrinsics3.checkNotNullParameter(state, "state");
            Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
            this.state = state;
            this.stream = modelApplicationStream;
        }

        public static /* synthetic */ ActiveApplicationStream copy$default(ActiveApplicationStream activeApplicationStream, State state, ModelApplicationStream modelApplicationStream, int i, Object obj) {
            if ((i & 1) != 0) {
                state = activeApplicationStream.state;
            }
            if ((i & 2) != 0) {
                modelApplicationStream = activeApplicationStream.stream;
            }
            return activeApplicationStream.copy(state, modelApplicationStream);
        }

        /* renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public final ActiveApplicationStream copy(State state, ModelApplicationStream stream) {
            Intrinsics3.checkNotNullParameter(state, "state");
            Intrinsics3.checkNotNullParameter(stream, "stream");
            return new ActiveApplicationStream(state, stream);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveApplicationStream)) {
                return false;
            }
            ActiveApplicationStream activeApplicationStream = (ActiveApplicationStream) other;
            return Intrinsics3.areEqual(this.state, activeApplicationStream.state) && Intrinsics3.areEqual(this.stream, activeApplicationStream.stream);
        }

        public final State getState() {
            return this.state;
        }

        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public int hashCode() {
            State state = this.state;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            ModelApplicationStream modelApplicationStream = this.stream;
            return iHashCode + (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ActiveApplicationStream(state=");
            sbU.append(this.state);
            sbU.append(", stream=");
            sbU.append(this.stream);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\rJ!\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming$StreamViewerTracker;", "", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "", "viewerCount", "", "onStreamUpdated", "(Ljava/lang/String;I)V", "getMaxViewers", "(Ljava/lang/String;)Ljava/lang/Integer;", "clear", "()V", "remove", "(Ljava/lang/String;)V", "", "maxViewersByStream", "Ljava/util/Map;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class StreamViewerTracker {
        private final Map<String, Integer> maxViewersByStream = new HashMap();

        public final void clear() {
            this.maxViewersByStream.clear();
        }

        public final Integer getMaxViewers(String streamKey) {
            Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
            return this.maxViewersByStream.get(streamKey);
        }

        public final void onStreamUpdated(String streamKey, int viewerCount) {
            Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
            Integer num = this.maxViewersByStream.get(streamKey);
            this.maxViewersByStream.put(streamKey, Integer.valueOf(Math.max(num != null ? num.intValue() : 0, viewerCount)));
        }

        public final void remove(String streamKey) {
            Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
            this.maxViewersByStream.remove(streamKey);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$createStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Long l, String str) {
            super(0);
            this.$channelId = j;
            this.$guildId = l;
            this.$preferredRegion = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActiveApplicationStream.State state;
            ActiveApplicationStream.State state2;
            ModelApplicationStream stream;
            RtcConnection rtcConnection$app_productionGoogleRelease = StoreApplicationStreaming.access$getRtcConnectionStore$p(StoreApplicationStreaming.this).getRtcConnection();
            if (rtcConnection$app_productionGoogleRelease == null || rtcConnection$app_productionGoogleRelease.channelId != this.$channelId || (!Intrinsics3.areEqual(rtcConnection$app_productionGoogleRelease.guildId, this.$guildId))) {
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("\n                Failed to start stream.\n                rtcConnection == null: ");
                sbU.append(rtcConnection$app_productionGoogleRelease == null);
                sbU.append("\n                rtcConnection.channelId != channelId: ");
                sbU.append(rtcConnection$app_productionGoogleRelease == null || rtcConnection$app_productionGoogleRelease.channelId != this.$channelId);
                sbU.append("\n                rtcConnection.guildId != guildId: ");
                sbU.append(!Intrinsics3.areEqual(rtcConnection$app_productionGoogleRelease != null ? rtcConnection$app_productionGoogleRelease.guildId : null, this.$guildId));
                sbU.append("\n              ");
                Logger.e$default(appLog, "Failed to start stream.", new IllegalStateException(Indent.trimIndent(sbU.toString())), null, 4, null);
                return;
            }
            long id2 = StoreApplicationStreaming.access$getUserStore$p(StoreApplicationStreaming.this).getMeSnapshot().getId();
            ModelApplicationStream guildStream = this.$guildId != null ? new ModelApplicationStream.GuildStream(this.$guildId.longValue(), this.$channelId, id2) : new ModelApplicationStream.CallStream(this.$channelId, id2);
            ActiveApplicationStream activeApplicationStreamAccess$getActiveApplicationStream$p = StoreApplicationStreaming.access$getActiveApplicationStream$p(StoreApplicationStreaming.this);
            if (activeApplicationStreamAccess$getActiveApplicationStream$p != null && (stream = activeApplicationStreamAccess$getActiveApplicationStream$p.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            if ((encodedStreamKey == guildStream.getEncodedStreamKey()) && activeApplicationStreamAccess$getActiveApplicationStream$p != null && (state2 = activeApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state2.isStreamActive()) {
                z = true;
            }
            if (z) {
                return;
            }
            if (activeApplicationStreamAccess$getActiveApplicationStream$p != null && (state = activeApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state.isStreamActive()) {
                StoreApplicationStreaming.access$stopStreamInternal(StoreApplicationStreaming.this, activeApplicationStreamAccess$getActiveApplicationStream$p.getStream().getEncodedStreamKey());
            }
            StoreApplicationStreaming.access$getStoreStream$p(StoreApplicationStreaming.this).streamCreate(guildStream.getEncodedStreamKey(), this.$preferredRegion);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "invoke", "()Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeActiveStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ActiveApplicationStream> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ActiveApplicationStream invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ActiveApplicationStream invoke() {
            return StoreApplicationStreaming.access$getActiveApplicationStream$p(StoreApplicationStreaming.this);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001c\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/StreamKey;", "", "", "Lcom/discord/primitives/UserId;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamSpectators$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends List<? extends Long>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends Long>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends List<? extends Long>> invoke2() {
            return StoreApplicationStreaming.access$getStreamSpectatorsSnapshot$p(StoreApplicationStreaming.this);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/domain/ModelApplicationStream;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsByUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ModelApplicationStream>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelApplicationStream> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ModelApplicationStream> invoke2() {
            return StoreApplicationStreaming.this.getStreamsByUser();
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/domain/ModelApplicationStream;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ModelApplicationStream>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelApplicationStream> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ModelApplicationStream> invoke2() {
            Map mapAccess$getStreamsByUserSnapshot$p = StoreApplicationStreaming.access$getStreamsByUserSnapshot$p(StoreApplicationStreaming.this);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapAccess$getStreamsByUserSnapshot$p.entrySet()) {
                ModelApplicationStream modelApplicationStream = (ModelApplicationStream) entry.getValue();
                if ((modelApplicationStream instanceof ModelApplicationStream.GuildStream) && ((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId() == this.$guildId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/domain/ModelApplicationStream;", "invoke", "()Lcom/discord/models/domain/ModelApplicationStream;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsForUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ModelApplicationStream> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ModelApplicationStream invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelApplicationStream invoke() {
            return (ModelApplicationStream) StoreApplicationStreaming.access$getStreamsByUserSnapshot$p(StoreApplicationStreaming.this).get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$stopStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreaming.access$stopStreamInternal(StoreApplicationStreaming.this, this.$streamKey);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreaming$targetStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $force;
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, boolean z2) {
            super(0);
            this.$streamKey = str;
            this.$force = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActiveApplicationStream.State state;
            ModelApplicationStream stream;
            ActiveApplicationStream activeApplicationStreamAccess$getActiveApplicationStream$p = StoreApplicationStreaming.access$getActiveApplicationStream$p(StoreApplicationStreaming.this);
            boolean z2 = Intrinsics3.areEqual((activeApplicationStreamAccess$getActiveApplicationStream$p == null || (stream = activeApplicationStreamAccess$getActiveApplicationStream$p.getStream()) == null) ? null : stream.getEncodedStreamKey(), this.$streamKey) && activeApplicationStreamAccess$getActiveApplicationStream$p.getState().isStreamActive();
            if (this.$force || !z2) {
                if (activeApplicationStreamAccess$getActiveApplicationStream$p != null && (state = activeApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state.isStreamActive()) {
                    StoreApplicationStreaming.access$stopStreamInternal(StoreApplicationStreaming.this, activeApplicationStreamAccess$getActiveApplicationStream$p.getStream().getEncodedStreamKey());
                }
                StoreApplicationStreaming.access$getStoreStream$p(StoreApplicationStreaming.this).handleStreamTargeted(this.$streamKey);
            }
        }
    }

    public /* synthetic */ StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeUser, storeVoiceChannelSelected, storeRtcConnection, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ ActiveApplicationStream access$getActiveApplicationStream$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.activeApplicationStream;
    }

    public static final /* synthetic */ StoreRtcConnection access$getRtcConnectionStore$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.rtcConnectionStore;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.storeStream;
    }

    public static final /* synthetic */ Map access$getStreamSpectatorsSnapshot$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.streamSpectatorsSnapshot;
    }

    public static final /* synthetic */ Map access$getStreamsByUserSnapshot$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.streamsByUserSnapshot;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.userStore;
    }

    public static final /* synthetic */ void access$setActiveApplicationStream$p(StoreApplicationStreaming storeApplicationStreaming, ActiveApplicationStream activeApplicationStream) {
        storeApplicationStreaming.activeApplicationStream = activeApplicationStream;
    }

    public static final /* synthetic */ void access$setStreamSpectatorsSnapshot$p(StoreApplicationStreaming storeApplicationStreaming, Map map) {
        storeApplicationStreaming.streamSpectatorsSnapshot = map;
    }

    public static final /* synthetic */ void access$setStreamsByUserSnapshot$p(StoreApplicationStreaming storeApplicationStreaming, Map map) {
        storeApplicationStreaming.streamsByUserSnapshot = map;
    }

    public static final /* synthetic */ void access$stopStreamInternal(StoreApplicationStreaming storeApplicationStreaming, String str) {
        storeApplicationStreaming.stopStreamInternal(str);
    }

    private final synchronized void addBreadCrumb(String message) {
        this.breadCrumbs.addLast(message + ", on thread: " + Thread.currentThread());
        ArrayDeque<String> arrayDeque = this.breadCrumbs;
        if (arrayDeque.size() > 50) {
            arrayDeque.removeFirst();
        }
    }

    public static /* synthetic */ void createStream$default(StoreApplicationStreaming storeApplicationStreaming, long j, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        storeApplicationStreaming.createStream(j, l, str);
    }

    private final synchronized void dumpBreadcrumbs() {
        Iterator<String> it = this.breadCrumbs.iterator();
        while (it.hasNext()) {
            AppLog.g.recordBreadcrumb(it.next(), "StoreApplicationStreaming");
        }
    }

    @Store3
    private final void handleStreamCreateOrUpdate(String streamKey, boolean paused, List<Long> viewerIds) {
        updateActiveApplicationStream(new ActiveApplicationStream(paused ? ActiveApplicationStream.State.PAUSED : ActiveApplicationStream.State.ACTIVE, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        this.streamSpectators.put(streamKey, viewerIds);
        this.streamViewerTracker.onStreamUpdated(streamKey, viewerIds.size());
        markChanged();
    }

    public static /* synthetic */ void handleVoiceStateUpdate$default(StoreApplicationStreaming storeApplicationStreaming, VoiceState voiceState, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = voiceState.getGuildId();
        }
        storeApplicationStreaming.handleVoiceStateUpdate(voiceState, j);
    }

    private final void stopStreamInternal(String streamKey) {
        this.storeStream.handleStreamDelete(new ModelApplicationStream5(streamKey, ModelApplicationStream5.Reason.USER_REQUESTED, false), true);
    }

    public static /* synthetic */ void targetStream$default(StoreApplicationStreaming storeApplicationStreaming, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeApplicationStreaming.targetStream(str, z2);
    }

    @Store3
    private final void updateActiveApplicationStream(ActiveApplicationStream activeApplicationStream) {
        boolean zIsScreenSharing = isScreenSharing(this.activeApplicationStream);
        boolean zIsScreenSharing2 = isScreenSharing(activeApplicationStream);
        if (zIsScreenSharing != zIsScreenSharing2) {
            this.storeStream.handleIsScreenSharingChanged(zIsScreenSharing2);
        }
        this.activeApplicationStream = activeApplicationStream;
    }

    public final void createStream(long channelId, Long guildId, String preferredRegion) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, guildId, preferredRegion));
    }

    @Store3
    public final String getActiveApplicationStreamKeyInternal$app_productionGoogleRelease() {
        ModelApplicationStream stream;
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null) {
            return null;
        }
        return stream.getEncodedStreamKey();
    }

    @Store3
    public final Integer getMaxViewersForStream(long userId, long channelId, Long guildId) {
        return this.streamViewerTracker.getMaxViewers((guildId != null ? new ModelApplicationStream.GuildStream(guildId.longValue(), channelId, userId) : new ModelApplicationStream.CallStream(channelId, userId)).getEncodedStreamKey());
    }

    public final Map<Long, ModelApplicationStream> getStreamsByUser() {
        return this.streamsByUserSnapshot;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        addBreadCrumb("Connection open, clearing streams by user.");
        this.streamsByUser.clear();
        this.streamViewerTracker.clear();
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream != null && activeApplicationStream.getState() != ActiveApplicationStream.State.ENDED) {
            targetStream(activeApplicationStream.getStream().getEncodedStreamKey(), true);
        }
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<VoiceState> listR = guild.R();
            if (listR != null) {
                Iterator<T> it = listR.iterator();
                while (it.hasNext()) {
                    handleVoiceStateUpdate((VoiceState) it.next(), guild.getId());
                }
            }
        }
        markChanged();
    }

    @Store3
    public final void handleStreamCreate(ModelApplicationStream3 streamCreate) {
        Intrinsics3.checkNotNullParameter(streamCreate, "streamCreate");
        this.streamViewerTracker.remove(streamCreate.getStreamKey());
        handleStreamCreateOrUpdate(streamCreate.getStreamKey(), streamCreate.getPaused(), streamCreate.getViewerIds());
    }

    @Store3
    public final void handleStreamCreateRequest(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.CONNECTING, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        markChanged();
    }

    @Store3
    public final void handleStreamDelete(ModelApplicationStream5 streamDelete) {
        ModelApplicationStream stream;
        ActiveApplicationStream activeApplicationStream;
        Intrinsics3.checkNotNullParameter(streamDelete, "streamDelete");
        this.streamSpectators.remove(streamDelete.getStreamKey());
        if (streamDelete.getReason() == ModelApplicationStream5.Reason.STREAM_FULL) {
            updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.DENIED_FULL, ModelApplicationStream.INSTANCE.decodeStreamKey(streamDelete.getStreamKey())));
            markChanged();
            return;
        }
        ActiveApplicationStream activeApplicationStream2 = this.activeApplicationStream;
        if (activeApplicationStream2 == null || (stream = activeApplicationStream2.getStream()) == null) {
            stream = this.targetStream;
        }
        ActiveApplicationStream activeApplicationStreamCopy$default = null;
        if (Intrinsics3.areEqual(stream != null ? stream.getEncodedStreamKey() : null, streamDelete.getStreamKey())) {
            if (streamDelete.getUnavailable()) {
                ActiveApplicationStream activeApplicationStream3 = this.activeApplicationStream;
                if (activeApplicationStream3 != null) {
                    activeApplicationStreamCopy$default = ActiveApplicationStream.copy$default(activeApplicationStream3, ActiveApplicationStream.State.RECONNECTING, null, 2, null);
                }
            } else if (streamDelete.getReason() != ModelApplicationStream5.Reason.USER_REQUESTED && (activeApplicationStream = this.activeApplicationStream) != null) {
                activeApplicationStreamCopy$default = ActiveApplicationStream.copy$default(activeApplicationStream, ActiveApplicationStream.State.ENDED, null, 2, null);
            }
            updateActiveApplicationStream(activeApplicationStreamCopy$default);
            markChanged();
        }
    }

    @Store3
    public final void handleStreamTargeted(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey);
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (Intrinsics3.areEqual(modelApplicationStreamDecodeStreamKey, activeApplicationStream != null ? activeApplicationStream.getStream() : null) && activeApplicationStream.getState().isStreamActive()) {
            return;
        }
        if (this.voiceChannelSelectedStore.getSelectedVoiceChannelId() != modelApplicationStreamDecodeStreamKey.getChannelId()) {
            this.targetStream = modelApplicationStreamDecodeStreamKey;
        } else {
            this.storeStream.streamWatch(modelApplicationStreamDecodeStreamKey.getEncodedStreamKey());
            this.targetStream = null;
        }
    }

    @Store3
    public final void handleStreamUpdate(ModelApplicationStream3 streamUpdate) {
        Intrinsics3.checkNotNullParameter(streamUpdate, "streamUpdate");
        handleStreamCreateOrUpdate(streamUpdate.getStreamKey(), streamUpdate.getPaused(), streamUpdate.getViewerIds());
    }

    @Store3
    public final void handleStreamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.CONNECTING, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        markChanged();
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        ModelApplicationStream stream;
        ModelApplicationStream modelApplicationStream = this.targetStream;
        if (modelApplicationStream != null && channelId == modelApplicationStream.getChannelId()) {
            StoreStream storeStream = this.storeStream;
            ModelApplicationStream modelApplicationStream2 = this.targetStream;
            Intrinsics3.checkNotNull(modelApplicationStream2);
            storeStream.streamWatch(modelApplicationStream2.getEncodedStreamKey());
            this.targetStream = null;
            return;
        }
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null || stream.getChannelId() != channelId) {
            updateActiveApplicationStream(null);
            this.targetStream = null;
            markChanged();
        }
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState, long guildId) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        addBreadCrumb("Handling a voice state update for " + voiceState.getUserId());
        Long channelId = voiceState.getChannelId();
        long userId = voiceState.getUserId();
        boolean selfStream = voiceState.getSelfStream();
        boolean z2 = guildId != 0;
        boolean z3 = (channelId == null || channelId.longValue() == 0) ? false : true;
        if (selfStream && z2 && z3) {
            HashMap<Long, ModelApplicationStream> map = this.streamsByUser;
            Long lValueOf = Long.valueOf(userId);
            Intrinsics3.checkNotNull(channelId);
            map.put(lValueOf, new ModelApplicationStream.GuildStream(guildId, channelId.longValue(), userId));
            markChanged();
        } else if (selfStream && z3) {
            HashMap<Long, ModelApplicationStream> map2 = this.streamsByUser;
            Long lValueOf2 = Long.valueOf(userId);
            Intrinsics3.checkNotNull(channelId);
            map2.put(lValueOf2, new ModelApplicationStream.CallStream(channelId.longValue(), userId));
            markChanged();
        } else if (this.streamsByUser.containsKey(Long.valueOf(userId))) {
            this.streamsByUser.remove(Long.valueOf(userId));
            markChanged();
        }
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream != null && userId == this.userStore.getMe().getId()) {
            long channelId2 = activeApplicationStream.getStream().getChannelId();
            Long channelId3 = voiceState.getChannelId();
            if (channelId3 == null || channelId2 != channelId3.longValue()) {
                updateActiveApplicationStream(null);
                markChanged();
            }
        }
        ModelApplicationStream modelApplicationStream = this.streamsByUser.get(Long.valueOf(userId));
        if (selfStream && modelApplicationStream != null && activeApplicationStream != null && Intrinsics3.areEqual(modelApplicationStream.getEncodedStreamKey(), activeApplicationStream.getStream().getEncodedStreamKey()) && activeApplicationStream.getState() == ActiveApplicationStream.State.ENDED) {
            handleStreamTargeted(modelApplicationStream.getEncodedStreamKey());
        }
    }

    @Store3
    public final boolean isScreenSharing() {
        return isScreenSharing(this.activeApplicationStream);
    }

    @Store3
    public final boolean isUserStreaming(long userId) {
        addBreadCrumb("Asking if " + userId + " is streaming");
        return this.streamsByUser.containsKey(Long.valueOf(userId));
    }

    public final Observable<ActiveApplicationStream> observeActiveStream() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<String, List<Long>>> observeStreamSpectators() {
        Observable<Map<String, List<Long>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsByUser() {
        Observable<Map<Long, ModelApplicationStream>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsForGuild(long guildId) {
        Observable<Map<Long, ModelApplicationStream>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ModelApplicationStream> observeStreamsForUser(long userId) {
        Observable<ModelApplicationStream> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(userId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() throws Exception {
        super.snapshotData();
        StringBuilder sbU = outline.U("Snapshotting 'streamsByUser' of size, ");
        sbU.append(this.streamsByUser.size());
        addBreadCrumb(sbU.toString());
        try {
            this.streamsByUserSnapshot = new HashMap(this.streamsByUser);
            this.streamSpectatorsSnapshot = new HashMap(this.streamSpectators);
        } catch (Exception e) {
            dumpBreadcrumbs();
            throw e;
        }
    }

    public final void stopStream(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new AnonymousClass1(streamKey));
    }

    public final void targetStream(String streamKey, boolean force) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new AnonymousClass1(streamKey, force));
    }

    public StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeRtcConnection, "rtcConnectionStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.rtcConnectionStore = storeRtcConnection;
        this.observationDeck = observationDeck;
        this.breadCrumbs = new ArrayDeque<>();
        this.streamsByUser = new HashMap<>();
        this.streamsByUserSnapshot = Maps6.emptyMap();
        this.streamSpectators = new HashMap<>();
        this.streamSpectatorsSnapshot = Maps6.emptyMap();
        this.streamViewerTracker = new StreamViewerTracker();
        addBreadCrumb("Initializing the store.");
    }

    private final boolean isScreenSharing(ActiveApplicationStream activeApplicationStream) {
        return activeApplicationStream != null && activeApplicationStream.getStream().getOwnerId() == this.userStore.getMe().getId();
    }
}
