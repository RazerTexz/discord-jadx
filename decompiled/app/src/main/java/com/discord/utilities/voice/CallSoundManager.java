package com.discord.utilities.voice;

import android.content.Context;
import androidx.annotation.MainThread;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: CallSoundManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0004()*+B#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b&\u0010'J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010$\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00130#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/discord/utilities/voice/CallSoundManager;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/utilities/voice/CallSoundManager$StoreState;", "storeState", "", "handleStoreState", "(JLcom/discord/utilities/voice/CallSoundManager$StoreState;)V", "voiceChannelId", "subscribeToStoreState", "(J)V", "Lrx/Subscription;", "storeStateSubscription", "Lrx/Subscription;", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/app/AppComponent;", "Lcom/discord/primitives/UserId;", "activeStreamUserId", "Ljava/lang/Long;", "", "numConnectedParticipants", "I", "activeStreamViewerCount", "Lcom/discord/utilities/voice/CallSoundManager$IStoreStateGenerator;", "storeStateGenerator", "Lcom/discord/utilities/voice/CallSoundManager$IStoreStateGenerator;", "Lcom/discord/utilities/media/AppSoundManager;", "appSoundManager", "Lcom/discord/utilities/media/AppSoundManager;", "", "activeStreamKey", "Ljava/lang/String;", "", "streamingUserIds", "Ljava/util/List;", "<init>", "(Lcom/discord/app/AppComponent;Lcom/discord/utilities/media/AppSoundManager;Lcom/discord/utilities/voice/CallSoundManager$IStoreStateGenerator;)V", "Companion", "IStoreStateGenerator", "StoreState", "StoreStateGenerator", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CallSoundManager {
    private static final int JOIN_LEAVE_USER_LIMIT = 25;
    private String activeStreamKey;
    private Long activeStreamUserId;
    private int activeStreamViewerCount;
    private final AppComponent appComponent;
    private final AppSoundManager appSoundManager;
    private int numConnectedParticipants;
    private final IStoreStateGenerator storeStateGenerator;
    private Subscription storeStateSubscription;
    private List<Long> streamingUserIds;
    private Long voiceChannelId;

    /* compiled from: CallSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/utilities/voice/CallSoundManager$IStoreStateGenerator;", "", "", "Lcom/discord/primitives/ChannelId;", "voiceChannelId", "Lrx/Observable;", "Lcom/discord/utilities/voice/CallSoundManager$StoreState;", "observeStoreState", "(J)Lrx/Observable;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface IStoreStateGenerator {
        Observable<StoreState> observeStoreState(long voiceChannelId);
    }

    /* compiled from: CallSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u0002\u0012 \u0010\u001d\u001a\u001c\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u000f0\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b8\u00109J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J*\u0010\u0010\u001a\u001c\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u000f0\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0094\u0001\u0010!\u001a\u00020\u00002\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\b\b\u0002\u0010\u001b\u001a\u00020\b2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u00022\"\b\u0002\u0010\u001d\u001a\u001c\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u000f0\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R3\u0010\u001d\u001a\u001c\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u000f0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b/\u0010\nR\u0019\u0010\u001f\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b1\u0010\u0016R\u001b\u0010 \u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b \u00102\u001a\u0004\b3\u0010\u0019R)\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b4\u0010\u0007R)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b5\u0010\u0007R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u0013¨\u0006:"}, d2 = {"Lcom/discord/utilities/voice/CallSoundManager$StoreState;", "", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component1", "()Ljava/util/Map;", "Lcom/discord/rtcconnection/RtcConnection$State;", "component2", "()Lcom/discord/rtcconnection/RtcConnection$State;", "Lcom/discord/models/domain/ModelApplicationStream;", "component3", "", "Lcom/discord/primitives/StreamKey;", "", "component4", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "component5", "()Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "Lcom/discord/models/user/MeUser;", "component6", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/api/channel/Channel;", "component7", "()Lcom/discord/api/channel/Channel;", "voiceParticipants", "rtcConnectionState", "streamsByUser", "streamSpectators", "activeApplicationStream", "me", "selectedVoiceChannel", "copy", "(Ljava/util/Map;Lcom/discord/rtcconnection/RtcConnection$State;Ljava/util/Map;Ljava/util/Map;Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;)Lcom/discord/utilities/voice/CallSoundManager$StoreState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getStreamSpectators", "Lcom/discord/rtcconnection/RtcConnection$State;", "getRtcConnectionState", "Lcom/discord/models/user/MeUser;", "getMe", "Lcom/discord/api/channel/Channel;", "getSelectedVoiceChannel", "getVoiceParticipants", "getStreamsByUser", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "getActiveApplicationStream", "<init>", "(Ljava/util/Map;Lcom/discord/rtcconnection/RtcConnection$State;Ljava/util/Map;Ljava/util/Map;Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream;
        private final MeUser me;
        private final RtcConnection.State rtcConnectionState;
        private final Channel selectedVoiceChannel;
        private final Map<String, List<Long>> streamSpectators;
        private final Map<Long, ModelApplicationStream> streamsByUser;
        private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, StoreVoiceParticipants.VoiceUser> map, RtcConnection.State state, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
            Intrinsics3.checkNotNullParameter(map, "voiceParticipants");
            Intrinsics3.checkNotNullParameter(state, "rtcConnectionState");
            Intrinsics3.checkNotNullParameter(map2, "streamsByUser");
            Intrinsics3.checkNotNullParameter(map3, "streamSpectators");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.voiceParticipants = map;
            this.rtcConnectionState = state;
            this.streamsByUser = map2;
            this.streamSpectators = map3;
            this.activeApplicationStream = activeApplicationStream;
            this.me = meUser;
            this.selectedVoiceChannel = channel;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, RtcConnection.State state, Map map2, Map map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.voiceParticipants;
            }
            if ((i & 2) != 0) {
                state = storeState.rtcConnectionState;
            }
            RtcConnection.State state2 = state;
            if ((i & 4) != 0) {
                map2 = storeState.streamsByUser;
            }
            Map map4 = map2;
            if ((i & 8) != 0) {
                map3 = storeState.streamSpectators;
            }
            Map map5 = map3;
            if ((i & 16) != 0) {
                activeApplicationStream = storeState.activeApplicationStream;
            }
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream2 = activeApplicationStream;
            if ((i & 32) != 0) {
                meUser = storeState.me;
            }
            MeUser meUser2 = meUser;
            if ((i & 64) != 0) {
                channel = storeState.selectedVoiceChannel;
            }
            return storeState.copy(map, state2, map4, map5, activeApplicationStream2, meUser2, channel);
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
            return this.voiceParticipants;
        }

        /* renamed from: component2, reason: from getter */
        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final Map<Long, ModelApplicationStream> component3() {
            return this.streamsByUser;
        }

        public final Map<String, List<Long>> component4() {
            return this.streamSpectators;
        }

        /* renamed from: component5, reason: from getter */
        public final StoreApplicationStreaming.ActiveApplicationStream getActiveApplicationStream() {
            return this.activeApplicationStream;
        }

        /* renamed from: component6, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component7, reason: from getter */
        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final StoreState copy(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, RtcConnection.State rtcConnectionState, Map<Long, ? extends ModelApplicationStream> streamsByUser, Map<String, ? extends List<Long>> streamSpectators, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser me2, Channel selectedVoiceChannel) {
            Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            Intrinsics3.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
            Intrinsics3.checkNotNullParameter(streamsByUser, "streamsByUser");
            Intrinsics3.checkNotNullParameter(streamSpectators, "streamSpectators");
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new StoreState(voiceParticipants, rtcConnectionState, streamsByUser, streamSpectators, activeApplicationStream, me2, selectedVoiceChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.voiceParticipants, storeState.voiceParticipants) && Intrinsics3.areEqual(this.rtcConnectionState, storeState.rtcConnectionState) && Intrinsics3.areEqual(this.streamsByUser, storeState.streamsByUser) && Intrinsics3.areEqual(this.streamSpectators, storeState.streamSpectators) && Intrinsics3.areEqual(this.activeApplicationStream, storeState.activeApplicationStream) && Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.selectedVoiceChannel, storeState.selectedVoiceChannel);
        }

        public final StoreApplicationStreaming.ActiveApplicationStream getActiveApplicationStream() {
            return this.activeApplicationStream;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final Map<String, List<Long>> getStreamSpectators() {
            return this.streamSpectators;
        }

        public final Map<Long, ModelApplicationStream> getStreamsByUser() {
            return this.streamsByUser;
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        public int hashCode() {
            Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            RtcConnection.State state = this.rtcConnectionState;
            int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map2 = this.streamsByUser;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<String, List<Long>> map3 = this.streamSpectators;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
            int iHashCode5 = (iHashCode4 + (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode6 = (iHashCode5 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Channel channel = this.selectedVoiceChannel;
            return iHashCode6 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(voiceParticipants=");
            sbU.append(this.voiceParticipants);
            sbU.append(", rtcConnectionState=");
            sbU.append(this.rtcConnectionState);
            sbU.append(", streamsByUser=");
            sbU.append(this.streamsByUser);
            sbU.append(", streamSpectators=");
            sbU.append(this.streamSpectators);
            sbU.append(", activeApplicationStream=");
            sbU.append(this.activeApplicationStream);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", selectedVoiceChannel=");
            sbU.append(this.selectedVoiceChannel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: CallSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/voice/CallSoundManager$StoreStateGenerator;", "Lcom/discord/utilities/voice/CallSoundManager$IStoreStateGenerator;", "", "Lcom/discord/primitives/ChannelId;", "voiceChannelId", "Lrx/Observable;", "Lcom/discord/utilities/voice/CallSoundManager$StoreState;", "observeStoreState", "(J)Lrx/Observable;", "Lcom/discord/stores/StoreApplicationStreaming;", "storeApplicationStreaming", "Lcom/discord/stores/StoreApplicationStreaming;", "Lcom/discord/stores/StoreRtcConnection;", "storeRtcConnection", "Lcom/discord/stores/StoreRtcConnection;", "Lcom/discord/stores/StoreVoiceParticipants;", "storeVoiceParticipants", "Lcom/discord/stores/StoreVoiceParticipants;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "<init>", "(Lcom/discord/stores/StoreVoiceParticipants;Lcom/discord/stores/StoreRtcConnection;Lcom/discord/stores/StoreApplicationStreaming;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class StoreStateGenerator implements IStoreStateGenerator {
        private final StoreApplicationStreaming storeApplicationStreaming;
        private final StoreChannels storeChannels;
        private final StoreRtcConnection storeRtcConnection;
        private final StoreUser storeUser;
        private final StoreVoiceParticipants storeVoiceParticipants;

        public StoreStateGenerator() {
            this(null, null, null, null, null, 31, null);
        }

        public StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels) {
            Intrinsics3.checkNotNullParameter(storeVoiceParticipants, "storeVoiceParticipants");
            Intrinsics3.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
            Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
            this.storeVoiceParticipants = storeVoiceParticipants;
            this.storeRtcConnection = storeRtcConnection;
            this.storeApplicationStreaming = storeApplicationStreaming;
            this.storeUser = storeUser;
            this.storeChannels = storeChannels;
        }

        @Override // com.discord.utilities.voice.CallSoundManager.IStoreStateGenerator
        public Observable<StoreState> observeStoreState(long voiceChannelId) {
            Observable<StoreState> observableE = Observable.e(this.storeVoiceParticipants.get(voiceChannelId), this.storeRtcConnection.getConnectionState(), this.storeApplicationStreaming.observeStreamsByUser(), this.storeApplicationStreaming.observeStreamSpectators(), this.storeApplicationStreaming.observeActiveStream(), StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeChannel(voiceChannelId), CallSoundManager2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable.combineLatest…Channel\n        )\n      }");
            return observableE;
        }

        public /* synthetic */ StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants, (i & 2) != 0 ? StoreStream.INSTANCE.getRtcConnection() : storeRtcConnection, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
        }
    }

    /* compiled from: CallSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            CallSoundManager.access$setStoreStateSubscription$p(CallSoundManager.this, subscription);
        }
    }

    /* compiled from: CallSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CallSoundManager.access$getAppSoundManager$p(CallSoundManager.this).stop(AppSound.INSTANCE.getSOUND_CALL_CALLING());
        }
    }

    /* compiled from: CallSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/voice/CallSoundManager$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/utilities/voice/CallSoundManager$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<StoreState, Unit> {
        public final /* synthetic */ long $voiceChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$voiceChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            CallSoundManager callSoundManager = CallSoundManager.this;
            long j = this.$voiceChannelId;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            CallSoundManager.access$handleStoreState(callSoundManager, j, storeState);
        }
    }

    public CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, IStoreStateGenerator iStoreStateGenerator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(appSoundManager, "appSoundManager");
        Intrinsics3.checkNotNullParameter(iStoreStateGenerator, "storeStateGenerator");
        this.appComponent = appComponent;
        this.appSoundManager = appSoundManager;
        this.storeStateGenerator = iStoreStateGenerator;
        this.streamingUserIds = Collections2.emptyList();
    }

    public static final /* synthetic */ AppSoundManager access$getAppSoundManager$p(CallSoundManager callSoundManager) {
        return callSoundManager.appSoundManager;
    }

    public static final /* synthetic */ Subscription access$getStoreStateSubscription$p(CallSoundManager callSoundManager) {
        return callSoundManager.storeStateSubscription;
    }

    public static final /* synthetic */ void access$handleStoreState(CallSoundManager callSoundManager, long j, StoreState storeState) {
        callSoundManager.handleStoreState(j, storeState);
    }

    public static final /* synthetic */ void access$setStoreStateSubscription$p(CallSoundManager callSoundManager, Subscription subscription) {
        callSoundManager.storeStateSubscription = subscription;
    }

    @MainThread
    private final void handleStoreState(long channelId, StoreState storeState) {
        boolean z2;
        boolean z3;
        boolean z4;
        Channel selectedVoiceChannel;
        StoreApplicationStreaming.ActiveApplicationStream.State state;
        int size;
        Long l = this.voiceChannelId;
        List<Long> list = this.streamingUserIds;
        int i = this.activeStreamViewerCount;
        String str = this.activeStreamKey;
        Long l2 = this.activeStreamUserId;
        int i2 = this.numConnectedParticipants;
        this.voiceChannelId = Long.valueOf(channelId);
        Collection<ModelApplicationStream> collectionValues = storeState.getStreamsByUser().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ModelApplicationStream) next).getChannelId() == channelId) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((ModelApplicationStream) it2.next()).getOwnerId()));
        }
        this.streamingUserIds = arrayList2;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = storeState.getActiveApplicationStream();
        if (activeApplicationStream == null || (state = activeApplicationStream.getState()) == null || !state.isStreamActive()) {
            this.activeStreamKey = null;
            this.activeStreamUserId = null;
            this.activeStreamViewerCount = 0;
        } else {
            this.activeStreamKey = activeApplicationStream.getStream().getEncodedStreamKey();
            this.activeStreamUserId = Long.valueOf(activeApplicationStream.getStream().getOwnerId());
            List<Long> list2 = storeState.getStreamSpectators().get(this.activeStreamKey);
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : list2) {
                    if (((Number) obj).longValue() != storeState.getMe().getId()) {
                        arrayList3.add(obj);
                    }
                }
                size = arrayList3.size();
            } else {
                size = 0;
            }
            this.activeStreamViewerCount = size;
        }
        String str2 = this.activeStreamKey;
        boolean z5 = str2 != null && Intrinsics3.areEqual(str2, str);
        List<Long> list3 = this.streamingUserIds;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            z3 = false;
        } else {
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                if (!list.contains(Long.valueOf(((Number) it3.next()).longValue()))) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            z4 = false;
        } else {
            Iterator<T> it4 = list.iterator();
            while (it4.hasNext()) {
                long jLongValue = ((Number) it4.next()).longValue();
                if (!this.streamingUserIds.contains(Long.valueOf(jLongValue)) && (jLongValue == storeState.getMe().getId() || (l2 != null && jLongValue == l2.longValue()))) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        boolean z6 = z5 && i <= 25 && this.activeStreamViewerCount > i;
        if (z5 && i <= 25 && this.activeStreamViewerCount < i) {
            z2 = true;
        }
        if (Intrinsics3.areEqual(this.voiceChannelId, l)) {
            if (z3) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_STARTED());
            } else if (z4) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_ENDED());
            } else if (z6) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_USER_JOINED());
            } else if (z2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_USER_LEFT());
            }
        }
        Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = storeState.getVoiceParticipants();
        boolean zAreEqual = Intrinsics3.areEqual(storeState.getRtcConnectionState(), RtcConnection.State.f.a);
        Collection<StoreVoiceParticipants.VoiceUser> collectionValues2 = voiceParticipants.values();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : collectionValues2) {
            if (((StoreVoiceParticipants.VoiceUser) obj2).isConnected()) {
                arrayList4.add(obj2);
            }
        }
        this.numConnectedParticipants = arrayList4.size();
        Collection<StoreVoiceParticipants.VoiceUser> collectionValues3 = voiceParticipants.values();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : collectionValues3) {
            if (((StoreVoiceParticipants.VoiceUser) obj3).isRinging()) {
                arrayList5.add(obj3);
            }
        }
        int size2 = arrayList5.size();
        if (zAreEqual && (selectedVoiceChannel = storeState.getSelectedVoiceChannel()) != null && ChannelUtils.K(selectedVoiceChannel) && i2 <= 25) {
            int i3 = this.numConnectedParticipants;
            if (i3 > i2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_USER_JOINED());
            } else if (i3 < i2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_USER_LEFT());
            }
        }
        if (this.numConnectedParticipants < 2 && size2 > 0) {
            AppSoundManager appSoundManager = this.appSoundManager;
            AppSound.Companion companion = AppSound.INSTANCE;
            if (!appSoundManager.isPlaying(companion.getSOUND_CALL_CALLING()) && zAreEqual) {
                this.appSoundManager.play(companion.getSOUND_CALL_CALLING());
                return;
            }
        }
        if (!zAreEqual || size2 == 0 || this.numConnectedParticipants >= 2) {
            this.appSoundManager.stop(AppSound.INSTANCE.getSOUND_CALL_CALLING());
        }
    }

    public final void subscribeToStoreState(long voiceChannelId) {
        Subscription subscription = this.storeStateSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<StoreState> observableR = this.storeStateGenerator.observeStoreState(voiceChannelId).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateGenerator\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this.appComponent, null, 2, null), CallSoundManager.class, (Context) null, new AnonymousClass1(), (Function1) null, new AnonymousClass2(), (Function0) null, new AnonymousClass3(voiceChannelId), 42, (Object) null);
    }

    public /* synthetic */ CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, IStoreStateGenerator iStoreStateGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? AppSoundManager.Provider.INSTANCE.get() : appSoundManager, (i & 4) != 0 ? new StoreStateGenerator(null, null, null, null, null, 31, null) : iStoreStateGenerator);
    }
}
