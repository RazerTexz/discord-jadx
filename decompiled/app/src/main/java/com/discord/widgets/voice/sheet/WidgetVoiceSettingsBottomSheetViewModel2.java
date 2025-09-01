package com.discord.widgets.voice.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStageChannels;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel;", "callModel", "Lrx/Observable;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/voice/model/CallModel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel2<T, R> implements Func1<CallModel, Observable<? extends WidgetVoiceSettingsBottomSheetViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreStageChannels $stageChannelsStore;

    /* compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/stage/StageRoles;", "stageRoles", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/stage/StageRoles;)Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<StageRoles, WidgetVoiceSettingsBottomSheetViewModel.StoreState.Valid> {
        public final /* synthetic */ CallModel $callModel;

        public AnonymousClass1(CallModel callModel) {
            this.$callModel = callModel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel.StoreState.Valid call(StageRoles stageRoles) {
            return call2(stageRoles);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetVoiceSettingsBottomSheetViewModel.StoreState.Valid call2(StageRoles stageRoles) {
            return new WidgetVoiceSettingsBottomSheetViewModel.StoreState.Valid(this.$callModel, stageRoles, null);
        }
    }

    public WidgetVoiceSettingsBottomSheetViewModel2(StoreStageChannels storeStageChannels, long j) {
        this.$stageChannelsStore = storeStageChannels;
        this.$channelId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceSettingsBottomSheetViewModel.StoreState> call(CallModel callModel) {
        return call2(callModel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceSettingsBottomSheetViewModel.StoreState> call2(CallModel callModel) {
        return callModel == null ? new ScalarSynchronousObservable(WidgetVoiceSettingsBottomSheetViewModel.StoreState.Invalid.INSTANCE) : this.$stageChannelsStore.observeMyRoles(this.$channelId).G(new AnonymousClass1(callModel));
    }
}
