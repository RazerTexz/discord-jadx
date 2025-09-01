package com.discord.widgets.voice.sheet;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B7\u0012\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\tR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$ViewState;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;)V", "onToggleVoiceParticipantsHidden", "()V", "onToggleNoiseCancellation", "Lrx/Observable;", "storeObservable", "Lrx/Observable;", "getStoreObservable", "()Lrx/Observable;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "Lcom/discord/stores/StoreStageChannels;", "stageChannelsStore", "Lcom/discord/stores/StoreStageChannels;", "Lcom/discord/stores/StoreMediaSettings;", "mediaSettingsStore", "Lcom/discord/stores/StoreMediaSettings;", "<init>", "(JLcom/discord/stores/StoreStageChannels;Lrx/Observable;Lcom/discord/stores/StoreMediaSettings;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreMediaSettings mediaSettingsStore;
    private final StoreStageChannels stageChannelsStore;
    private final Observable<StoreState> storeObservable;

    /* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetVoiceSettingsBottomSheetViewModel.access$handleStoreState(WidgetVoiceSettingsBottomSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreStageChannels;", "stageChannelsStore", "Lrx/Observable;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreStageChannels;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreStageChannels storeStageChannels) {
            return companion.observeStoreState(j, storeStageChannels);
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreStageChannels stageChannelsStore) {
            Observable<StoreState> observableY = ObservableExtensionsKt.computationLatest(CallModel.INSTANCE.get(channelId)).r().Y(new WidgetVoiceSettingsBottomSheetViewModel2(stageChannelsStore, channelId));
            Intrinsics3.checkNotNullExpressionValue(observableY, "CallModel.get(channelId)…          }\n            }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001c\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;", "Lcom/discord/widgets/voice/model/CallModel;", "component1", "()Lcom/discord/widgets/voice/model/CallModel;", "Lcom/discord/widgets/stage/StageRoles;", "component2-twRsX-0", "()Lcom/discord/widgets/stage/StageRoles;", "component2", "callModel", "myStageRoles", "copy-FZvHQiQ", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/StageRoles;)Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/stage/StageRoles;", "getMyStageRoles-twRsX-0", "Lcom/discord/widgets/voice/model/CallModel;", "getCallModel", "<init>", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/StageRoles;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final StageRoles myStageRoles;

            public /* synthetic */ Valid(CallModel callModel, StageRoles stageRoles, DefaultConstructorMarker defaultConstructorMarker) {
                this(callModel, stageRoles);
            }

            /* renamed from: copy-FZvHQiQ$default, reason: not valid java name */
            public static /* synthetic */ Valid m73copyFZvHQiQ$default(Valid valid, CallModel callModel, StageRoles stageRoles, int i, Object obj) {
                if ((i & 1) != 0) {
                    callModel = valid.callModel;
                }
                if ((i & 2) != 0) {
                    stageRoles = valid.myStageRoles;
                }
                return valid.m75copyFZvHQiQ(callModel, stageRoles);
            }

            /* renamed from: component1, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* renamed from: component2-twRsX-0, reason: not valid java name and from getter */
            public final StageRoles getMyStageRoles() {
                return this.myStageRoles;
            }

            /* renamed from: copy-FZvHQiQ, reason: not valid java name */
            public final Valid m75copyFZvHQiQ(CallModel callModel, StageRoles myStageRoles) {
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                return new Valid(callModel, myStageRoles);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.callModel, valid.callModel) && Intrinsics3.areEqual(this.myStageRoles, valid.myStageRoles);
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* renamed from: getMyStageRoles-twRsX-0, reason: not valid java name */
            public final StageRoles m76getMyStageRolestwRsX0() {
                return this.myStageRoles;
            }

            public int hashCode() {
                CallModel callModel = this.callModel;
                int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
                StageRoles stageRoles = this.myStageRoles;
                return iHashCode + (stageRoles != null ? stageRoles.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(callModel=");
                sbU.append(this.callModel);
                sbU.append(", myStageRoles=");
                sbU.append(this.myStageRoles);
                sbU.append(")");
                return sbU.toString();
            }

            private Valid(CallModel callModel, StageRoles stageRoles) {
                super(null);
                this.callModel = callModel;
                this.myStageRoles = stageRoles;
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJb\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u0007R\u001c\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b&\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b*\u0010\u0007R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b-\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b.\u0010\u0007¨\u00061"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$ViewState;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheet$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "component3", "component4", "component5", "component6", "component7", "Lcom/discord/models/guild/Guild;", "component8", "()Lcom/discord/models/guild/Guild;", "channel", "showVoiceParticipants", "showVoiceParticipantsToggle", "showInviteItem", "noiseCancellationEnabled", "showStageSettings", "showReportItem", "guild", "copy", "(Lcom/discord/api/channel/Channel;ZZZZZZLcom/discord/models/guild/Guild;)Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowInviteItem", "getShowStageSettings", "getNoiseCancellationEnabled", "Lcom/discord/api/channel/Channel;", "getChannel", "getShowReportItem", "Lcom/discord/models/guild/Guild;", "getGuild", "getShowVoiceParticipants", "getShowVoiceParticipantsToggle", "<init>", "(Lcom/discord/api/channel/Channel;ZZZZZZLcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState implements WidgetVoiceSettingsBottomSheet.ViewState {
        private final Channel channel;
        private final Guild guild;
        private final boolean noiseCancellationEnabled;
        private final boolean showInviteItem;
        private final boolean showReportItem;
        private final boolean showStageSettings;
        private final boolean showVoiceParticipants;
        private final boolean showVoiceParticipantsToggle;

        public ViewState(Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Guild guild) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.showVoiceParticipants = z2;
            this.showVoiceParticipantsToggle = z3;
            this.showInviteItem = z4;
            this.noiseCancellationEnabled = z5;
            this.showStageSettings = z6;
            this.showReportItem = z7;
            this.guild = guild;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Guild guild, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.getChannel() : channel, (i & 2) != 0 ? viewState.getShowVoiceParticipants() : z2, (i & 4) != 0 ? viewState.getShowVoiceParticipantsToggle() : z3, (i & 8) != 0 ? viewState.getShowInviteItem() : z4, (i & 16) != 0 ? viewState.getNoiseCancellationEnabled() : z5, (i & 32) != 0 ? viewState.getShowStageSettings() : z6, (i & 64) != 0 ? viewState.getShowReportItem() : z7, (i & 128) != 0 ? viewState.getGuild() : guild);
        }

        public final Channel component1() {
            return getChannel();
        }

        public final boolean component2() {
            return getShowVoiceParticipants();
        }

        public final boolean component3() {
            return getShowVoiceParticipantsToggle();
        }

        public final boolean component4() {
            return getShowInviteItem();
        }

        public final boolean component5() {
            return getNoiseCancellationEnabled();
        }

        public final boolean component6() {
            return getShowStageSettings();
        }

        public final boolean component7() {
            return getShowReportItem();
        }

        public final Guild component8() {
            return getGuild();
        }

        public final ViewState copy(Channel channel, boolean showVoiceParticipants, boolean showVoiceParticipantsToggle, boolean showInviteItem, boolean noiseCancellationEnabled, boolean showStageSettings, boolean showReportItem, Guild guild) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ViewState(channel, showVoiceParticipants, showVoiceParticipantsToggle, showInviteItem, noiseCancellationEnabled, showStageSettings, showReportItem, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(getChannel(), viewState.getChannel()) && getShowVoiceParticipants() == viewState.getShowVoiceParticipants() && getShowVoiceParticipantsToggle() == viewState.getShowVoiceParticipantsToggle() && getShowInviteItem() == viewState.getShowInviteItem() && getNoiseCancellationEnabled() == viewState.getNoiseCancellationEnabled() && getShowStageSettings() == viewState.getShowStageSettings() && getShowReportItem() == viewState.getShowReportItem() && Intrinsics3.areEqual(getGuild(), viewState.getGuild());
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getNoiseCancellationEnabled() {
            return this.noiseCancellationEnabled;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowInviteItem() {
            return this.showInviteItem;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowReportItem() {
            return this.showReportItem;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowStageSettings() {
            return this.showStageSettings;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowVoiceParticipants() {
            return this.showVoiceParticipants;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowVoiceParticipantsToggle() {
            return this.showVoiceParticipantsToggle;
        }

        public int hashCode() {
            Channel channel = getChannel();
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean showVoiceParticipants = getShowVoiceParticipants();
            int i = showVoiceParticipants;
            if (showVoiceParticipants) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean showVoiceParticipantsToggle = getShowVoiceParticipantsToggle();
            int i3 = showVoiceParticipantsToggle;
            if (showVoiceParticipantsToggle) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean showInviteItem = getShowInviteItem();
            int i5 = showInviteItem;
            if (showInviteItem) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean noiseCancellationEnabled = getNoiseCancellationEnabled();
            int i7 = noiseCancellationEnabled;
            if (noiseCancellationEnabled) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean showStageSettings = getShowStageSettings();
            int i9 = showStageSettings;
            if (showStageSettings) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean showReportItem = getShowReportItem();
            int i11 = (i10 + (showReportItem ? 1 : showReportItem)) * 31;
            Guild guild = getGuild();
            return i11 + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(channel=");
            sbU.append(getChannel());
            sbU.append(", showVoiceParticipants=");
            sbU.append(getShowVoiceParticipants());
            sbU.append(", showVoiceParticipantsToggle=");
            sbU.append(getShowVoiceParticipantsToggle());
            sbU.append(", showInviteItem=");
            sbU.append(getShowInviteItem());
            sbU.append(", noiseCancellationEnabled=");
            sbU.append(getNoiseCancellationEnabled());
            sbU.append(", showStageSettings=");
            sbU.append(getShowStageSettings());
            sbU.append(", showReportItem=");
            sbU.append(getShowReportItem());
            sbU.append(", guild=");
            sbU.append(getGuild());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel(long j, StoreStageChannels storeStageChannels, Observable observable, StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreStageChannels stageChannels = (i & 2) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels;
        this(j, stageChannels, (i & 4) != 0 ? Companion.access$observeStoreState(INSTANCE, j, stageChannels) : observable, (i & 8) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetVoiceSettingsBottomSheetViewModel widgetVoiceSettingsBottomSheetViewModel, StoreState storeState) {
        widgetVoiceSettingsBottomSheetViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            boolean z2 = valid.getCallModel().getIsVideoCall() || valid.getCallModel().getActiveStream() != null;
            boolean zD = ChannelUtils.D(valid.getCallModel().getChannel());
            boolean z3 = valid.getCallModel().canInvite() && !zD;
            boolean zD2 = ChannelUtils.D(valid.getCallModel().getChannel());
            boolean z4 = valid.getCallModel().getVoiceSettings().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Cancellation;
            StageRoles stageRolesM76getMyStageRolestwRsX0 = valid.m76getMyStageRolestwRsX0();
            updateViewState(new ViewState(valid.getCallModel().getChannel(), !valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden(), z2, z3, z4, zD && (stageRolesM76getMyStageRolestwRsX0 != null && StageRoles.m32isModeratorimpl(stageRolesM76getMyStageRolestwRsX0.m35unboximpl())), zD2, valid.getCallModel().getGuild()));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Observable<StoreState> getStoreObservable() {
        return this.storeObservable;
    }

    public final void onToggleNoiseCancellation() {
        this.mediaSettingsStore.toggleNoiseCancellation();
    }

    public final void onToggleVoiceParticipantsHidden() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            this.mediaSettingsStore.updateVoiceParticipantsHidden(viewState.getShowVoiceParticipants());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheetViewModel(long j, StoreStageChannels storeStageChannels, Observable<StoreState> observable, StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.channelId = j;
        this.stageChannelsStore = storeStageChannels;
        this.storeObservable = observable;
        this.mediaSettingsStore = storeMediaSettings;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetVoiceSettingsBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
