package com.discord.widgets.voice.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetVoiceBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetVoiceBottomSheetViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel;", "callModel", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "", "kotlin.jvm.PlatformType", "textInVoiceEnabled", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/voice/model/CallModel;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<CallModel, Long, Boolean, WidgetVoiceBottomSheetViewModel.StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetVoiceBottomSheetViewModel.StoreState call(CallModel callModel, Long l, Boolean bool) {
            return call2(callModel, l, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetVoiceBottomSheetViewModel.StoreState call2(CallModel callModel, Long l, Boolean bool) {
            if (callModel != null) {
                if (Sets5.setOf((Object[]) new Integer[]{2, 13, 1, 3}).contains(Integer.valueOf(callModel.getChannel().getType()))) {
                    Boolean boolValueOf = Boolean.valueOf(callModel.getVoiceSettings().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Cancellation);
                    Intrinsics3.checkNotNullExpressionValue(bool, "textInVoiceEnabled");
                    return new WidgetVoiceBottomSheetViewModel.StoreState.Valid(callModel, boolValueOf, l, bool.booleanValue());
                }
            }
            return WidgetVoiceBottomSheetViewModel.StoreState.Invalid.INSTANCE;
        }
    }

    public WidgetVoiceBottomSheetViewModel2(long j, StorePermissions storePermissions) {
        this.$channelId = j;
        this.$permissionsStore = storePermissions;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceBottomSheetViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceBottomSheetViewModel.StoreState> call2(Channel channel) {
        return Observable.i(CallModel.INSTANCE.get(this.$channelId), this.$permissionsStore.observePermissionsForChannel(this.$channelId), TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), AnonymousClass1.INSTANCE);
    }
}
