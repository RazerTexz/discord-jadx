package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: AppFlexInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "selectedChannel", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AppFlexInputViewModel2<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends AppFlexInputViewModel.StoreState>> {
    public static final AppFlexInputViewModel2 INSTANCE = new AppFlexInputViewModel2();

    /* compiled from: AppFlexInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\n \u0001*\u0004\u0018\u00010\f0\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000b\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/discord/panels/PanelState;", "kotlin.jvm.PlatformType", "leftPanelState", "rightPanelState", "", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/stores/StoreNotices$Notice;", "notice", "", "stickerSuggestionsEnabled", "expressionSuggestionsEnabled", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/panels/PanelState;Lcom/discord/panels/PanelState;Ljava/lang/Long;Lcom/discord/stores/StoreNotices$Notice;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<PanelState, PanelState, Long, StoreNotices.Notice, Boolean, Boolean, AppFlexInputViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

        public AnonymousClass1(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            this.$channel = channel;
            this.$selectedChannel = resolvedSelectedChannel;
        }

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ AppFlexInputViewModel.StoreState call(PanelState panelState, PanelState panelState2, Long l, StoreNotices.Notice notice, Boolean bool, Boolean bool2) {
            return call2(panelState, panelState2, l, notice, bool, bool2);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final AppFlexInputViewModel.StoreState call2(PanelState panelState, PanelState panelState2, Long l, StoreNotices.Notice notice, Boolean bool, Boolean bool2) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
            Intrinsics3.checkNotNullExpressionValue(panelState2, "rightPanelState");
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(bool, "stickerSuggestionsEnabled");
            if (bool.booleanValue()) {
                Intrinsics3.checkNotNullExpressionValue(bool2, "expressionSuggestionsEnabled");
                z2 = bool2.booleanValue();
            }
            return new AppFlexInputViewModel.StoreState(panelState, panelState2, channel, l, notice, z2, this.$selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft);
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends AppFlexInputViewModel.StoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends AppFlexInputViewModel.StoreState> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.f(companion.getNavigation().observeLeftPanelState(), companion.getNavigation().observeRightPanelState(), companion.getPermissions().observePermissionsForChannel(channelOrParent != null ? channelOrParent.getId() : 0L), companion.getNotices().getNotices(), companion.getUserSettings().observeIsStickerSuggestionsEnabled(), companion.getExpressionSuggestions().observeSuggestionsEnabled(), new AnonymousClass1(channelOrParent, resolvedSelectedChannel));
    }
}
