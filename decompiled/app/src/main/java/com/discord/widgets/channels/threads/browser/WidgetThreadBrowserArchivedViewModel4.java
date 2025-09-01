package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "kotlin.jvm.PlatformType", "viewMode", "Lrx/Observable;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$storeStateObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel4<T, R> implements Func1<WidgetThreadBrowserArchivedViewModel.ViewMode, Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState>> {
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel this$0;

    public WidgetThreadBrowserArchivedViewModel4(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        this.this$0 = widgetThreadBrowserArchivedViewModel;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        return call2(viewMode);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call2(WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        WidgetThreadBrowserArchivedViewModel.Companion companion = WidgetThreadBrowserArchivedViewModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(viewMode, "viewMode");
        return WidgetThreadBrowserArchivedViewModel.Companion.access$observeStoreState(companion, viewMode, WidgetThreadBrowserArchivedViewModel.access$getGuildId$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getChannelId$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreGuilds$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreChannels$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreUser$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreArchivedThreads$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStorePermissions$p(this.this$0));
    }
}
