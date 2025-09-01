package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChatStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "selectedChannelId", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatStatus3<T, R> implements Func1<Long, Observable<? extends Boolean>> {
    public static final WidgetChatStatus3 INSTANCE = new WidgetChatStatus3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Long l) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreMessageAck messageAck = companion.getMessageAck();
        Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
        Observable<StoreMessageAck.Ack> observableObserveForChannel = messageAck.observeForChannel(l.longValue());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.m(new ScalarSynchronousObservable(Boolean.FALSE), Observable.j(observableObserveForChannel.p(200L, timeUnit), companion.getMessagesMostRecent().observeRecentMessageIds(l.longValue()).p(200L, timeUnit).Z(1), WidgetChatStatus4.INSTANCE).b0(WidgetChatStatus5.INSTANCE));
    }
}
