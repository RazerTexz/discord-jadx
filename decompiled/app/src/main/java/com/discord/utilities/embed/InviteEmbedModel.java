package com.discord.utilities.embed;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreRequestedStageChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: InviteEmbedModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*Bc\u0012\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u0002\u0012\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u0002¢\u0006\u0004\b(\u0010)J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0002HÂ\u0003¢\u0006\u0004\b\n\u0010\u0007J \u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u0002HÂ\u0003¢\u0006\u0004\b\f\u0010\u0007J \u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u0002HÂ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017Jt\u0010\u001c\u001a\u00020\u00002\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00022\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u00022\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R&\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010'R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010'R&\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010'R&\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010'¨\u0006+"}, d2 = {"Lcom/discord/utilities/embed/InviteEmbedModel;", "", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component1", "()Ljava/util/Map;", "", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "component2", "Lcom/discord/api/stageinstance/StageInstance;", "component3", "Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "component4", "inviteKey", "Lcom/discord/models/domain/ModelInvite;", "getResolvedInvite", "(Ljava/lang/String;)Lcom/discord/models/domain/ModelInvite;", "inviteCode", "resolveInviteCodeForPublicStage", "eventId", "resolveInviteForGuildScheduledEvent", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/ModelInvite;", "channels", "invites", "stageInstances", "requestedInstances", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/embed/InviteEmbedModel;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class InviteEmbedModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Long, Channel> channels;
    private final Map<String, StoreInstantInvites.InviteState> invites;
    private final Map<Long, StoreRequestedStageChannels.StageInstanceState> requestedInstances;
    private final Map<Long, StageInstance> stageInstances;

    /* compiled from: InviteEmbedModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u008f\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u001e\b\u0002\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\u001e\b\u0002\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u000b0\u00030\u00022\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\r0\u00030\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/embed/InviteEmbedModel$Companion;", "", "Lrx/Observable;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channelsObservable", "", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "knownInvitesObservable", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstancesObservable", "Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "requestedStageInstances", "Lcom/discord/utilities/embed/InviteEmbedModel;", "observe", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable observe$default(Companion companion, Observable observable, Observable observable2, Observable observable3, Observable observable4, int i, Object obj) {
            if ((i & 1) != 0) {
                observable = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels();
            }
            if ((i & 2) != 0) {
                observable2 = StoreStream.INSTANCE.getInstantInvites().observeKnownInvites();
            }
            if ((i & 4) != 0) {
                observable3 = StoreStream.INSTANCE.getStageInstances().observeStageInstances();
            }
            if ((i & 8) != 0) {
                observable4 = StoreStream.INSTANCE.getRequestedStageChannels().observeRequestedStageChannels();
            }
            return companion.observe(observable, observable2, observable3, observable4);
        }

        public final Observable<InviteEmbedModel> observe(Observable<Map<Long, Channel>> channelsObservable, Observable<Map<String, StoreInstantInvites.InviteState>> knownInvitesObservable, Observable<Map<Long, StageInstance>> stageInstancesObservable, Observable<Map<Long, StoreRequestedStageChannels.StageInstanceState>> requestedStageInstances) {
            Intrinsics3.checkNotNullParameter(channelsObservable, "channelsObservable");
            Intrinsics3.checkNotNullParameter(knownInvitesObservable, "knownInvitesObservable");
            Intrinsics3.checkNotNullParameter(stageInstancesObservable, "stageInstancesObservable");
            Intrinsics3.checkNotNullParameter(requestedStageInstances, "requestedStageInstances");
            InviteEmbedModel2 inviteEmbedModel2 = InviteEmbedModel2.INSTANCE;
            Object inviteEmbedModel3 = inviteEmbedModel2;
            if (inviteEmbedModel2 != null) {
                inviteEmbedModel3 = new InviteEmbedModel3(inviteEmbedModel2);
            }
            Observable<InviteEmbedModel> observableH = Observable.h(channelsObservable, knownInvitesObservable, stageInstancesObservable, requestedStageInstances, (Func4) inviteEmbedModel3);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest… ::InviteEmbedModel\n    )");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InviteEmbedModel(Map<Long, Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, StageInstance> map3, Map<Long, StoreRequestedStageChannels.StageInstanceState> map4) {
        Intrinsics3.checkNotNullParameter(map, "channels");
        Intrinsics3.checkNotNullParameter(map2, "invites");
        Intrinsics3.checkNotNullParameter(map3, "stageInstances");
        Intrinsics3.checkNotNullParameter(map4, "requestedInstances");
        this.channels = map;
        this.invites = map2;
        this.stageInstances = map3;
        this.requestedInstances = map4;
    }

    private final Map<Long, Channel> component1() {
        return this.channels;
    }

    private final Map<String, StoreInstantInvites.InviteState> component2() {
        return this.invites;
    }

    private final Map<Long, StageInstance> component3() {
        return this.stageInstances;
    }

    private final Map<Long, StoreRequestedStageChannels.StageInstanceState> component4() {
        return this.requestedInstances;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InviteEmbedModel copy$default(InviteEmbedModel inviteEmbedModel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            map = inviteEmbedModel.channels;
        }
        if ((i & 2) != 0) {
            map2 = inviteEmbedModel.invites;
        }
        if ((i & 4) != 0) {
            map3 = inviteEmbedModel.stageInstances;
        }
        if ((i & 8) != 0) {
            map4 = inviteEmbedModel.requestedInstances;
        }
        return inviteEmbedModel.copy(map, map2, map3, map4);
    }

    public final InviteEmbedModel copy(Map<Long, Channel> channels, Map<String, ? extends StoreInstantInvites.InviteState> invites, Map<Long, StageInstance> stageInstances, Map<Long, StoreRequestedStageChannels.StageInstanceState> requestedInstances) {
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(invites, "invites");
        Intrinsics3.checkNotNullParameter(stageInstances, "stageInstances");
        Intrinsics3.checkNotNullParameter(requestedInstances, "requestedInstances");
        return new InviteEmbedModel(channels, invites, stageInstances, requestedInstances);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteEmbedModel)) {
            return false;
        }
        InviteEmbedModel inviteEmbedModel = (InviteEmbedModel) other;
        return Intrinsics3.areEqual(this.channels, inviteEmbedModel.channels) && Intrinsics3.areEqual(this.invites, inviteEmbedModel.invites) && Intrinsics3.areEqual(this.stageInstances, inviteEmbedModel.stageInstances) && Intrinsics3.areEqual(this.requestedInstances, inviteEmbedModel.requestedInstances);
    }

    public final ModelInvite getResolvedInvite(String inviteKey) {
        Intrinsics3.checkNotNullParameter(inviteKey, "inviteKey");
        StoreInstantInvites.InviteState inviteState = this.invites.get(inviteKey);
        if (!(inviteState instanceof StoreInstantInvites.InviteState.Resolved)) {
            inviteState = null;
        }
        StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState;
        if (resolved != null) {
            return resolved.getInvite();
        }
        return null;
    }

    public int hashCode() {
        Map<Long, Channel> map = this.channels;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, StoreInstantInvites.InviteState> map2 = this.invites;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, StageInstance> map3 = this.stageInstances;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, StoreRequestedStageChannels.StageInstanceState> map4 = this.requestedInstances;
        return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
    }

    public final ModelInvite resolveInviteCodeForPublicStage(String inviteCode) {
        RecommendedStageInstance stageInstance;
        StageInstance recommendedStageInstance;
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        ModelInvite resolvedInvite = getResolvedInvite(inviteCode);
        if (resolvedInvite != null) {
            Channel channel = resolvedInvite.getChannel();
            if (!(channel != null && ChannelUtils.D(channel))) {
                channel = null;
            }
            if (channel != null) {
                Intrinsics3.checkNotNullExpressionValue(channel, "invite.channel.takeIf { … == true } ?: return null");
                StageInstance stageInstance2 = (StageInstance) outline.d(channel, this.stageInstances);
                if (stageInstance2 != null && AnimatableValueParser.W0(stageInstance2)) {
                    return resolvedInvite;
                }
                if (((Channel) outline.d(channel, this.channels)) != null) {
                    return null;
                }
                StoreRequestedStageChannels.StageInstanceState stageInstanceState = (StoreRequestedStageChannels.StageInstanceState) outline.d(channel, this.requestedInstances);
                if (stageInstanceState != null && (stageInstance = stageInstanceState.getStageInstance()) != null && (recommendedStageInstance = stageInstance.getInstance()) != null && AnimatableValueParser.W0(recommendedStageInstance)) {
                    return resolvedInvite;
                }
                if (stageInstanceState == null || stageInstanceState.isError()) {
                    StoreStream.INSTANCE.getRequestedStageChannels().enqueueStageChannelFetch(channel.getId());
                }
            }
        }
        return null;
    }

    public final ModelInvite resolveInviteForGuildScheduledEvent(String inviteCode, String eventId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics3.checkNotNullParameter(eventId, "eventId");
        String inviteStoreKey = ModelInvite.getInviteStoreKey(inviteCode, SnowflakeUtils.INSTANCE.toSnowflake(eventId));
        Intrinsics3.checkNotNullExpressionValue(inviteStoreKey, "ModelInvite.getInviteSto…d.toSnowflake()\n        )");
        ModelInvite resolvedInvite = getResolvedInvite(inviteStoreKey);
        if ((resolvedInvite != null ? resolvedInvite.getGuildScheduledEvent() : null) != null) {
            return resolvedInvite;
        }
        return null;
    }

    public String toString() {
        StringBuilder sbU = outline.U("InviteEmbedModel(channels=");
        sbU.append(this.channels);
        sbU.append(", invites=");
        sbU.append(this.invites);
        sbU.append(", stageInstances=");
        sbU.append(this.stageInstances);
        sbU.append(", requestedInstances=");
        return outline.M(sbU, this.requestedInstances, ")");
    }
}
