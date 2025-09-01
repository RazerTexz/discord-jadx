package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSlowMode;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorTakeWhile;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: StoreSlowMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "shouldOverrideCooldown", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreSlowMode3<T, R> implements Func1<Boolean, Observable<? extends Long>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode.Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    /* compiled from: StoreSlowMode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00042Ù\u0001\u0010\u0006\u001aÔ\u0001\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00040\u0001j\u0002`\u0004 \u0003*j\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00040\u0001j\u0002`\u0004\u0018\u00010\u0000j4\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00040\u0001j\u0002`\u0004\u0018\u0001`\u00050\u0000j2\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00040\u0001j\u0002`\u0004`\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/util/HashMap;", "", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "Lcom/discord/primitives/Timestamp;", "Lkotlin/collections/HashMap;", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/HashMap;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<HashMap<Long, Long>, Long> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(HashMap<Long, Long> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(HashMap<Long, Long> map) {
            return map.get(Long.valueOf(StoreSlowMode3.this.$channelId));
        }
    }

    /* compiled from: StoreSlowMode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u0000 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/Timestamp;", "nextSendTimeForChannel", "Lrx/Observable;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Long, Observable<? extends Long>> {

        /* compiled from: StoreSlowMode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0005\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "ticks", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Long, Long> {
            public final /* synthetic */ Long $nextSendTimeForChannel;
            public final /* synthetic */ long $now;

            public AnonymousClass1(Long l, long j) {
                this.$nextSendTimeForChannel = l;
                this.$now = j;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Long call(Long l) {
                return call2(l);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Long l) {
                return Long.valueOf(this.$nextSendTimeForChannel.longValue() - (this.$now + (l.longValue() * 1000)));
            }
        }

        /* compiled from: StoreSlowMode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01712<T, R> implements Func1<Long, Boolean> {
            public static final C01712 INSTANCE = new C01712();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Long l) {
                return call2(l);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Long l) {
                return Boolean.valueOf(l.longValue() >= 0);
            }
        }

        public AnonymousClass2() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(Long l) {
            long jCurrentTimeMillis = StoreSlowMode.access$getClock$p(StoreSlowMode3.this.this$0).currentTimeMillis();
            if (l == null || l.longValue() <= jCurrentTimeMillis) {
                return new ScalarSynchronousObservable(0L);
            }
            Observable<R> observableG = Observable.E(0L, 1L, TimeUnit.SECONDS).G(new AnonymousClass1(l, jCurrentTimeMillis));
            return Observable.h0(new OnSubscribeLift(observableG.j, new OperatorTakeWhile(C01712.INSTANCE)));
        }
    }

    public StoreSlowMode3(StoreSlowMode storeSlowMode, StoreSlowMode.Type type, long j) {
        this.this$0 = storeSlowMode;
        this.$type = type;
        this.$channelId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "shouldOverrideCooldown");
        if (bool.booleanValue()) {
            return new ScalarSynchronousObservable(0L);
        }
        return (Intrinsics3.areEqual(this.$type, StoreSlowMode.Type.MessageSend.INSTANCE) ? StoreSlowMode.access$getMessageSendNextSendTimesSubject$p(this.this$0) : StoreSlowMode.access$getThreadCreateNextSendTimesSubject$p(this.this$0)).G(new AnonymousClass1()).Y(new AnonymousClass2());
    }
}
