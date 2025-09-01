package com.discord.widgets.stage.sheet;

import a0.a.a.b;
import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetAdapter;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B#\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00060\bj\u0002`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lrx/Observable;", "storeStateObservable", "<init>", "(JLrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(StageAudienceBlockedBottomSheetViewModel stageAudienceBlockedBottomSheetViewModel) {
            super(1, stageAudienceBlockedBottomSheetViewModel, StageAudienceBlockedBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            StageAudienceBlockedBottomSheetViewModel.access$handleStoreState((StageAudienceBlockedBottomSheetViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreUserRelationships;", "userRelationshipsStore", "Lcom/discord/stores/StoreStageChannels;", "stageStore", "Lrx/Observable;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;", "observeStores", "(JLcom/discord/stores/StoreUserRelationships;Lcom/discord/stores/StoreStageChannels;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, StoreUserRelationships storeUserRelationships, StoreStageChannels storeStageChannels) {
            return companion.observeStores(j, storeUserRelationships, storeStageChannels);
        }

        private final Observable<StoreState> observeStores(long channelId, StoreUserRelationships userRelationshipsStore, StoreStageChannels stageStore) {
            Observable<StoreState> observableI = Observable.i(CallModel.INSTANCE.get(channelId), userRelationshipsStore.observeForType(2), stageStore.observeStageRolesByChannel(channelId), new StageAudienceBlockedBottomSheetViewModel2(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest… emptyMap()\n      )\n    }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BJ\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\t\u0012\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\n\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\n\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J[\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\t2\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\n\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R,\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\n\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0010R#\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\bR\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/widgets/voice/model/CallModel;", "component2", "()Lcom/discord/widgets/voice/model/CallModel;", "", "Lcom/discord/primitives/UserId;", "component3", "()Ljava/util/Set;", "", "Lcom/discord/widgets/stage/StageRoles;", "component4", "()Ljava/util/Map;", "channelId", "callModel", "blockedUsers", "stageRoles", "copy", "(JLcom/discord/widgets/voice/model/CallModel;Ljava/util/Set;Ljava/util/Map;)Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getStageRoles", "Ljava/util/Set;", "getBlockedUsers", "Lcom/discord/widgets/voice/model/CallModel;", "getCallModel", "J", "getChannelId", "<init>", "(JLcom/discord/widgets/voice/model/CallModel;Ljava/util/Set;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Set<Long> blockedUsers;
        private final CallModel callModel;
        private final long channelId;
        private final Map<Long, StageRoles> stageRoles;

        public StoreState(long j, CallModel callModel, Set<Long> set, Map<Long, StageRoles> map) {
            Intrinsics3.checkNotNullParameter(set, "blockedUsers");
            Intrinsics3.checkNotNullParameter(map, "stageRoles");
            this.channelId = j;
            this.callModel = callModel;
            this.blockedUsers = set;
            this.stageRoles = map;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, long j, CallModel callModel, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                j = storeState.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                callModel = storeState.callModel;
            }
            CallModel callModel2 = callModel;
            if ((i & 4) != 0) {
                set = storeState.blockedUsers;
            }
            Set set2 = set;
            if ((i & 8) != 0) {
                map = storeState.stageRoles;
            }
            return storeState.copy(j2, callModel2, set2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final Set<Long> component3() {
            return this.blockedUsers;
        }

        public final Map<Long, StageRoles> component4() {
            return this.stageRoles;
        }

        public final StoreState copy(long channelId, CallModel callModel, Set<Long> blockedUsers, Map<Long, StageRoles> stageRoles) {
            Intrinsics3.checkNotNullParameter(blockedUsers, "blockedUsers");
            Intrinsics3.checkNotNullParameter(stageRoles, "stageRoles");
            return new StoreState(channelId, callModel, blockedUsers, stageRoles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.channelId == storeState.channelId && Intrinsics3.areEqual(this.callModel, storeState.callModel) && Intrinsics3.areEqual(this.blockedUsers, storeState.blockedUsers) && Intrinsics3.areEqual(this.stageRoles, storeState.stageRoles);
        }

        public final Set<Long> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Map<Long, StageRoles> getStageRoles() {
            return this.stageRoles;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            CallModel callModel = this.callModel;
            int iHashCode = (iA + (callModel != null ? callModel.hashCode() : 0)) * 31;
            Set<Long> set = this.blockedUsers;
            int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, StageRoles> map = this.stageRoles;
            return iHashCode2 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channelId=");
            sbU.append(this.channelId);
            sbU.append(", callModel=");
            sbU.append(this.callModel);
            sbU.append(", blockedUsers=");
            sbU.append(this.blockedUsers);
            sbU.append(", stageRoles=");
            return outline.M(sbU, this.stageRoles, ")");
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Loaded", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "component2", "()Ljava/util/List;", "channel", "listItems", "copy", "(Lcom/discord/api/channel/Channel;Ljava/util/List;)Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getListItems", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final List<MGRecyclerDataPayload> listItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Channel channel, List<? extends MGRecyclerDataPayload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(list, "listItems");
                this.channel = channel;
                this.listItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    list = loaded.listItems;
                }
                return loaded.copy(channel, list);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final List<MGRecyclerDataPayload> component2() {
                return this.listItems;
            }

            public final Loaded copy(Channel channel, List<? extends MGRecyclerDataPayload> listItems) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(listItems, "listItems");
                return new Loaded(channel, listItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.channel, loaded.channel) && Intrinsics3.areEqual(this.listItems, loaded.listItems);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final List<MGRecyclerDataPayload> getListItems() {
                return this.listItems;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                List<MGRecyclerDataPayload> list = this.listItems;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", listItems=");
                return outline.L(sbU, this.listItems, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StageAudienceBlockedBottomSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStores(companion, j, companion2.getUserRelationships(), companion2.getStageChannels());
        }
        this(j, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StageAudienceBlockedBottomSheetViewModel stageAudienceBlockedBottomSheetViewModel, StoreState storeState) {
        stageAudienceBlockedBottomSheetViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        CallModel callModel = storeState.getCallModel();
        if (callModel != null) {
            Map<Long, StoreVoiceParticipants.VoiceUser> participants = callModel.getParticipants();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = participants.entrySet().iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, StoreVoiceParticipants.VoiceUser> next = it.next();
                long jLongValue = next.getKey().longValue();
                if (next.getValue().isConnected() && storeState.getBlockedUsers().contains(Long.valueOf(jLongValue))) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                long jLongValue2 = ((Number) entry.getKey()).longValue();
                StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) entry.getValue();
                StageRoles stageRoles = storeState.getStageRoles().get(Long.valueOf(jLongValue2));
                arrayList.add(new StageAudienceBlockedBottomSheetAdapter.ListItem.Participant(voiceUser, stageRoles != null && StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())));
            }
            Channel channel = callModel.getChannel();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new StageAudienceBlockedBottomSheetAdapter.ListItem.Header(arrayList.size()));
            arrayList2.addAll(arrayList);
            loaded = new ViewState.Loaded(channel, arrayList2);
        } else {
            loaded = ViewState.Invalid.INSTANCE;
        }
        updateViewState(loaded);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetViewModel(long j, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StageAudienceBlockedBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
