package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.ChannelUtils;
import com.discord.panels.OverlappingPanelsLayout;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: LeftPanelManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/home/LeftPanelManager;", "", "Lrx/Observable;", "Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "observeLockState", "()Lrx/Observable;", "Lcom/discord/stores/StoreGuildSelected;", "storeGuildSelected", "Lcom/discord/stores/StoreGuildSelected;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannelsSelected;", "<init>", "(Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreGuildSelected;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LeftPanelManager {
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreGuildSelected storeGuildSelected;

    /* compiled from: LeftPanelManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0001*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0018\u0010\u0005\u001a\u0014 \u0001*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "resolvedSelectedChannel", "", "Lcom/discord/primitives/GuildId;", "selectedGuildId", "Lcom/discord/panels/OverlappingPanelsLayout$LockState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Ljava/lang/Long;)Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.LeftPanelManager$observeLockState$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<StoreChannelsSelected.ResolvedSelectedChannel, Long, OverlappingPanelsLayout.LockState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ OverlappingPanelsLayout.LockState call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Long l) {
            return call2(resolvedSelectedChannel, l);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final OverlappingPanelsLayout.LockState call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Long l) {
            long id2 = resolvedSelectedChannel.getId();
            boolean z2 = false;
            boolean z3 = (id2 == 0 || id2 == -1) ? false : true;
            boolean z4 = l == null || l.longValue() != 0;
            boolean z5 = !z3;
            if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
                    StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
                    if (channel.getPeekParent() != null || ChannelUtils.J(channel.getChannel())) {
                        z2 = true;
                    }
                }
            }
            return (z4 && z2) ? OverlappingPanelsLayout.LockState.CLOSE : (z4 || !z5) ? OverlappingPanelsLayout.LockState.UNLOCKED : OverlappingPanelsLayout.LockState.OPEN;
        }
    }

    public LeftPanelManager() {
        this(null, null, 3, null);
    }

    public LeftPanelManager(StoreChannelsSelected storeChannelsSelected, StoreGuildSelected storeGuildSelected) {
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeGuildSelected = storeGuildSelected;
    }

    public final Observable<OverlappingPanelsLayout.LockState> observeLockState() {
        Observable<OverlappingPanelsLayout.LockState> observableR = Observable.j(this.storeChannelsSelected.observeResolvedSelectedChannel(), this.storeGuildSelected.observeSelectedGuildId(), AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ LeftPanelManager(StoreChannelsSelected storeChannelsSelected, StoreGuildSelected storeGuildSelected, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 2) != 0 ? StoreStream.INSTANCE.getGuildSelected() : storeGuildSelected);
    }
}
