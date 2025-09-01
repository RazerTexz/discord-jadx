package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a>\u0012\u0018\b\u0001\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004 \u0005*\u001e\u0012\u0018\b\u0001\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "query", "Lrx/Observable;", "", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuilds4<T, R> implements Func1<String, Observable<? extends Long>> {
    public static final StoreGuilds4 INSTANCE = new StoreGuilds4();

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "selectedGuildId", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Long> {
        public final /* synthetic */ String $query;

        public AnonymousClass1(String str) {
            this.$query = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Long l) {
            call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Long l) {
            StoreGatewayConnection gatewaySocket = StoreStream.INSTANCE.getGatewaySocket();
            Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
            StoreGatewayConnection.requestGuildMembers$default(gatewaySocket, l.longValue(), this.$query, null, null, 12, null);
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(String str) {
        return StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().u(new AnonymousClass1(str));
    }
}
