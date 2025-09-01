package com.discord.stores;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.voice.state.VoiceState;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreVideoStreams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00012B\u0011\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b0\u00101J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u0019\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0007¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0018J\u001b\u0010\u001d\u001a\u00020\t2\n\u0010\u001c\u001a\u00060\u0002j\u0002`\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010$J#\u0010%\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0007¢\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R:\u0010,\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050*j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0005`+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R&\u0010.\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/discord/stores/StoreVideoStreams;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/stores/StoreVideoStreams$UserStreams;", "currentUserStreams", "(J)Lcom/discord/stores/StoreVideoStreams$UserStreams;", "userStreams", "", "setUserStreams", "(JLcom/discord/stores/StoreVideoStreams$UserStreams;)V", "Lrx/Observable;", "", "observeUserStreams", "()Lrx/Observable;", "", "Lcom/discord/primitives/StreamId;", "streamId", "handleVideoStreamUpdate", "(JLjava/lang/Integer;)V", "Lcom/discord/rtcconnection/VideoMetadata;", "metadata", "handleVideoMetadataUpdate", "(Lcom/discord/rtcconnection/VideoMetadata;)V", "handleApplicationStreamUpdate", "handleApplicationStreamVideoMetadataUpdate", "Lcom/discord/primitives/ChannelId;", "channelId", "handleVoiceChannelSelected", "(J)V", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "handleVoiceStateUpdates", "(Lcom/discord/api/voice/state/VoiceState;)V", "snapshotData", "()V", "findUserForApplicationStream", "(I)Ljava/lang/Long;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "userStreamsByUser", "Ljava/util/HashMap;", "userStreamsByUserSnapshot", "Ljava/util/Map;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;)V", "UserStreams", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreVideoStreams extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashMap<Long, UserStreams> userStreamsByUser;
    private Map<Long, UserStreams> userStreamsByUserSnapshot;

    /* compiled from: StoreVideoStreams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B;\u0012\u000e\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b#\u0010$J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJL\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR!\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b!\u0010\bR!\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\"\u0010\u0005¨\u0006&"}, d2 = {"Lcom/discord/stores/StoreVideoStreams$UserStreams;", "", "", "Lcom/discord/primitives/StreamId;", "component1", "()Ljava/lang/Integer;", "Lcom/discord/rtcconnection/VideoMetadata;", "component2", "()Lcom/discord/rtcconnection/VideoMetadata;", "component3", "component4", "callStreamId", "callStreamMetadata", "applicationStreamId", "applicationStreamMetadata", "copy", "(Ljava/lang/Integer;Lcom/discord/rtcconnection/VideoMetadata;Ljava/lang/Integer;Lcom/discord/rtcconnection/VideoMetadata;)Lcom/discord/stores/StoreVideoStreams$UserStreams;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "isEmpty", "Z", "()Z", "Ljava/lang/Integer;", "getApplicationStreamId", "Lcom/discord/rtcconnection/VideoMetadata;", "getApplicationStreamMetadata", "getCallStreamMetadata", "getCallStreamId", "<init>", "(Ljava/lang/Integer;Lcom/discord/rtcconnection/VideoMetadata;Ljava/lang/Integer;Lcom/discord/rtcconnection/VideoMetadata;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserStreams {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final UserStreams Empty = new UserStreams(null, null, null, null);
        private final Integer applicationStreamId;
        private final VideoMetadata applicationStreamMetadata;
        private final Integer callStreamId;
        private final VideoMetadata callStreamMetadata;
        private final boolean isEmpty = Intrinsics3.areEqual(this, Empty);

        /* compiled from: StoreVideoStreams.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreVideoStreams$UserStreams$Companion;", "", "Lcom/discord/stores/StoreVideoStreams$UserStreams;", "Empty", "Lcom/discord/stores/StoreVideoStreams$UserStreams;", "getEmpty", "()Lcom/discord/stores/StoreVideoStreams$UserStreams;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final UserStreams getEmpty() {
                return UserStreams.access$getEmpty$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UserStreams(Integer num, VideoMetadata videoMetadata, Integer num2, VideoMetadata videoMetadata2) {
            this.callStreamId = num;
            this.callStreamMetadata = videoMetadata;
            this.applicationStreamId = num2;
            this.applicationStreamMetadata = videoMetadata2;
        }

        public static final /* synthetic */ UserStreams access$getEmpty$cp() {
            return Empty;
        }

        public static /* synthetic */ UserStreams copy$default(UserStreams userStreams, Integer num, VideoMetadata videoMetadata, Integer num2, VideoMetadata videoMetadata2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = userStreams.callStreamId;
            }
            if ((i & 2) != 0) {
                videoMetadata = userStreams.callStreamMetadata;
            }
            if ((i & 4) != 0) {
                num2 = userStreams.applicationStreamId;
            }
            if ((i & 8) != 0) {
                videoMetadata2 = userStreams.applicationStreamMetadata;
            }
            return userStreams.copy(num, videoMetadata, num2, videoMetadata2);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getCallStreamId() {
            return this.callStreamId;
        }

        /* renamed from: component2, reason: from getter */
        public final VideoMetadata getCallStreamMetadata() {
            return this.callStreamMetadata;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getApplicationStreamId() {
            return this.applicationStreamId;
        }

        /* renamed from: component4, reason: from getter */
        public final VideoMetadata getApplicationStreamMetadata() {
            return this.applicationStreamMetadata;
        }

        public final UserStreams copy(Integer callStreamId, VideoMetadata callStreamMetadata, Integer applicationStreamId, VideoMetadata applicationStreamMetadata) {
            return new UserStreams(callStreamId, callStreamMetadata, applicationStreamId, applicationStreamMetadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserStreams)) {
                return false;
            }
            UserStreams userStreams = (UserStreams) other;
            return Intrinsics3.areEqual(this.callStreamId, userStreams.callStreamId) && Intrinsics3.areEqual(this.callStreamMetadata, userStreams.callStreamMetadata) && Intrinsics3.areEqual(this.applicationStreamId, userStreams.applicationStreamId) && Intrinsics3.areEqual(this.applicationStreamMetadata, userStreams.applicationStreamMetadata);
        }

        public final Integer getApplicationStreamId() {
            return this.applicationStreamId;
        }

        public final VideoMetadata getApplicationStreamMetadata() {
            return this.applicationStreamMetadata;
        }

        public final Integer getCallStreamId() {
            return this.callStreamId;
        }

        public final VideoMetadata getCallStreamMetadata() {
            return this.callStreamMetadata;
        }

        public int hashCode() {
            Integer num = this.callStreamId;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            VideoMetadata videoMetadata = this.callStreamMetadata;
            int iHashCode2 = (iHashCode + (videoMetadata != null ? videoMetadata.hashCode() : 0)) * 31;
            Integer num2 = this.applicationStreamId;
            int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
            VideoMetadata videoMetadata2 = this.applicationStreamMetadata;
            return iHashCode3 + (videoMetadata2 != null ? videoMetadata2.hashCode() : 0);
        }

        /* renamed from: isEmpty, reason: from getter */
        public final boolean getIsEmpty() {
            return this.isEmpty;
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserStreams(callStreamId=");
            sbU.append(this.callStreamId);
            sbU.append(", callStreamMetadata=");
            sbU.append(this.callStreamMetadata);
            sbU.append(", applicationStreamId=");
            sbU.append(this.applicationStreamId);
            sbU.append(", applicationStreamMetadata=");
            sbU.append(this.applicationStreamMetadata);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreVideoStreams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVideoStreams$UserStreams;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVideoStreams$observeUserStreams$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends UserStreams>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends UserStreams> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends UserStreams> invoke2() {
            return StoreVideoStreams.access$getUserStreamsByUserSnapshot$p(StoreVideoStreams.this);
        }
    }

    public StoreVideoStreams() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreVideoStreams(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getUserStreamsByUserSnapshot$p(StoreVideoStreams storeVideoStreams) {
        return storeVideoStreams.userStreamsByUserSnapshot;
    }

    public static final /* synthetic */ void access$setUserStreamsByUserSnapshot$p(StoreVideoStreams storeVideoStreams, Map map) {
        storeVideoStreams.userStreamsByUserSnapshot = map;
    }

    private final UserStreams currentUserStreams(long userId) {
        UserStreams userStreams = this.userStreamsByUser.get(Long.valueOf(userId));
        return userStreams != null ? userStreams : UserStreams.INSTANCE.getEmpty();
    }

    private final void setUserStreams(long userId, UserStreams userStreams) {
        if (userStreams.getIsEmpty()) {
            this.userStreamsByUser.remove(Long.valueOf(userId));
        } else {
            this.userStreamsByUser.put(Long.valueOf(userId), userStreams);
        }
        markChanged();
    }

    @Store3
    public final Long findUserForApplicationStream(int streamId) {
        for (Map.Entry<Long, UserStreams> entry : this.userStreamsByUser.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Integer applicationStreamId = entry.getValue().getApplicationStreamId();
            if (applicationStreamId != null && applicationStreamId.intValue() == streamId) {
                return Long.valueOf(jLongValue);
            }
        }
        return null;
    }

    @Store3
    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        setUserStreams(userId, UserStreams.copy$default(currentUserStreams(userId), null, null, streamId, null, 11, null));
    }

    @Store3
    public final void handleApplicationStreamVideoMetadataUpdate(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        setUserStreams(metadata.userID, UserStreams.copy$default(currentUserStreams(metadata.userID), null, null, null, metadata, 7, null));
    }

    @Store3
    public final void handleVideoMetadataUpdate(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        setUserStreams(metadata.userID, UserStreams.copy$default(currentUserStreams(metadata.userID), null, metadata, null, null, 13, null));
    }

    @Store3
    public final void handleVideoStreamUpdate(long userId, Integer streamId) {
        setUserStreams(userId, UserStreams.copy$default(currentUserStreams(userId), streamId, null, null, null, 14, null));
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        if (channelId == 0 && (!this.userStreamsByUser.isEmpty())) {
            this.userStreamsByUser.clear();
            markChanged();
        }
    }

    @Store3
    public final void handleVoiceStateUpdates(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (AnimatableValueParser.X0(voiceState)) {
            if (this.userStreamsByUser.remove(Long.valueOf(voiceState.getUserId())) != null) {
                markChanged();
            }
        }
    }

    public final Observable<Map<Long, UserStreams>> observeUserStreams() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.userStreamsByUserSnapshot = new HashMap(this.userStreamsByUser);
    }

    public StoreVideoStreams(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.userStreamsByUserSnapshot = Maps6.emptyMap();
        this.userStreamsByUser = new HashMap<>();
    }
}
