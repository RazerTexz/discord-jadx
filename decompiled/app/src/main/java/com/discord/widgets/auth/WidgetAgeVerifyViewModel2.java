package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetAgeVerifyViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0000 \u0003*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "currChannel", "Lrx/Observable;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel2<T, R> implements Func1<Channel, Observable<? extends Channel>> {
    public static final WidgetAgeVerifyViewModel2 INSTANCE = new WidgetAgeVerifyViewModel2();

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Channel> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Channel call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Channel call2(Channel channel) {
            if (channel == null || channel.getNsfw()) {
                return null;
            }
            return channel;
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Channel channel) {
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        return lValueOf == null ? new ScalarSynchronousObservable(null) : ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(lValueOf.longValue()), 0L, false, 3, null).G(AnonymousClass1.INSTANCE);
    }
}
