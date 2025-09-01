package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import j0.l.a.OnSubscribeRefCount3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreSlowMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J+\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\b2\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0013J+\u0010\u0016\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\nR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cRF\u0010\u001f\u001a2\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001dj\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 RB\u0010\"\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`!0\u001dj\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`!`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 RÔ\u0003\u0010%\u001a¿\u0003\u0012×\u0001\u0012Ô\u0001\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`! $*j\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u00010\u001dj4\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u0001`\u001e0\u001dj2\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!`\u001e $*Þ\u0001\u0012×\u0001\u0012Ô\u0001\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`! $*j\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u00010\u001dj4\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u0001`\u001e0\u001dj2\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!`\u001e\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&RÔ\u0003\u0010'\u001a¿\u0003\u0012×\u0001\u0012Ô\u0001\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`! $*j\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u00010\u001dj4\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u0001`\u001e0\u001dj2\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!`\u001e $*Þ\u0001\u0012×\u0001\u0012Ô\u0001\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`! $*j\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u00010\u001dj4\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!\u0018\u0001`\u001e0\u001dj2\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\u0002j\u0004\u0018\u0001`!0\u0002j\u0002`!`\u001e\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010&RB\u0010(\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`!0\u001dj\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`!`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010 RF\u0010)\u001a2\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001dj\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010 ¨\u0006."}, d2 = {"Lcom/discord/stores/StoreSlowMode;", "Lcom/discord/stores/Store;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "cooldownMs", "Lcom/discord/stores/StoreSlowMode$Type;", "type", "", "onCooldownInternal", "(JJLcom/discord/stores/StoreSlowMode$Type;)V", "Lrx/Observable;", "", "getChannelCooldownObservable", "(JLcom/discord/stores/StoreSlowMode$Type;)Lrx/Observable;", "removeChannelCooldownObservable", "observeCooldownSecs", "(Ljava/lang/Long;Lcom/discord/stores/StoreSlowMode$Type;)Lrx/Observable;", "onMessageSent", "(J)V", "parentChannelId", "onThreadCreated", "onCooldown", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "channelThreadCreateCooldownObservables", "Ljava/util/HashMap;", "Lcom/discord/primitives/Timestamp;", "messageSendNextSendTimes", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "messageSendNextSendTimesSubject", "Lrx/subjects/BehaviorSubject;", "threadCreateNextSendTimesSubject", "threadCreateNextSendTimes", "channelMessageSendCooldownObservables", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreStream;)V", "Companion", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreSlowMode extends Store {

    @Deprecated
    private static final long COOLDOWN_BUFFER_MS = 1000;
    private static final Companion Companion = new Companion(null);
    private final HashMap<Long, Observable<Integer>> channelMessageSendCooldownObservables;
    private final HashMap<Long, Observable<Integer>> channelThreadCreateCooldownObservables;
    private final Clock clock;
    private final HashMap<Long, Long> messageSendNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> messageSendNextSendTimesSubject;
    private final StoreStream stream;
    private final HashMap<Long, Long> threadCreateNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> threadCreateNextSendTimesSubject;

    /* compiled from: StoreSlowMode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreSlowMode$Companion;", "", "", "COOLDOWN_BUFFER_MS", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreSlowMode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreSlowMode$Type;", "", "<init>", "()V", "MessageSend", "ThreadCreate", "Lcom/discord/stores/StoreSlowMode$Type$MessageSend;", "Lcom/discord/stores/StoreSlowMode$Type$ThreadCreate;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Type {

        /* compiled from: StoreSlowMode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreSlowMode$Type$MessageSend;", "Lcom/discord/stores/StoreSlowMode$Type;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class MessageSend extends Type {
            public static final MessageSend INSTANCE = new MessageSend();

            private MessageSend() {
                super(null);
            }
        }

        /* compiled from: StoreSlowMode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreSlowMode$Type$ThreadCreate;", "Lcom/discord/stores/StoreSlowMode$Type;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ThreadCreate extends Type {
            public static final ThreadCreate INSTANCE = new ThreadCreate();

            private ThreadCreate() {
                super(null);
            }
        }

        private Type() {
        }

        public /* synthetic */ Type(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StoreSlowMode(Clock clock, StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        HashMap<Long, Long> map = new HashMap<>();
        this.messageSendNextSendTimes = map;
        this.messageSendNextSendTimesSubject = BehaviorSubject.l0(new HashMap(map));
        HashMap<Long, Long> map2 = new HashMap<>();
        this.threadCreateNextSendTimes = map2;
        this.threadCreateNextSendTimesSubject = BehaviorSubject.l0(new HashMap(map2));
        this.channelMessageSendCooldownObservables = new HashMap<>();
        this.channelThreadCreateCooldownObservables = new HashMap<>();
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.clock;
    }

    public static final /* synthetic */ BehaviorSubject access$getMessageSendNextSendTimesSubject$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.messageSendNextSendTimesSubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getThreadCreateNextSendTimesSubject$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.threadCreateNextSendTimesSubject;
    }

    public static final /* synthetic */ Observable access$removeChannelCooldownObservable(StoreSlowMode storeSlowMode, long j, Type type) {
        return storeSlowMode.removeChannelCooldownObservable(j, type);
    }

    private final synchronized Observable<Integer> getChannelCooldownObservable(long channelId, Type type) {
        Type.MessageSend messageSend = Type.MessageSend.INSTANCE;
        Observable<Integer> observable = Intrinsics3.areEqual(type, messageSend) ? this.channelMessageSendCooldownObservables.get(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.get(Long.valueOf(channelId));
        if (observable != null) {
            return observable;
        }
        Observable<Integer> observableH0 = Observable.h0(new OnSubscribeRefCount3(this.stream.getPermissions().observePermissionsForChannel(channelId).G(new StoreSlowMode2(type)).r().Y(new StoreSlowMode3(this, type, channelId)).G(StoreSlowMode4.INSTANCE).w(new StoreSlowMode5(this, channelId, type)).N(1)));
        if (Intrinsics3.areEqual(type, messageSend)) {
            HashMap<Long, Observable<Integer>> map = this.channelMessageSendCooldownObservables;
            Long lValueOf = Long.valueOf(channelId);
            Intrinsics3.checkNotNullExpressionValue(observableH0, "newObservable");
            map.put(lValueOf, observableH0);
        } else {
            HashMap<Long, Observable<Integer>> map2 = this.channelThreadCreateCooldownObservables;
            Long lValueOf2 = Long.valueOf(channelId);
            Intrinsics3.checkNotNullExpressionValue(observableH0, "newObservable");
            map2.put(lValueOf2, observableH0);
        }
        return observableH0;
    }

    @Store3
    private final void onCooldownInternal(long channelId, long cooldownMs, Type type) {
        if (Intrinsics3.areEqual(type, Type.MessageSend.INSTANCE)) {
            this.messageSendNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.messageSendNextSendTimesSubject.onNext(new HashMap<>(this.messageSendNextSendTimes));
        } else {
            this.threadCreateNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.threadCreateNextSendTimesSubject.onNext(new HashMap<>(this.threadCreateNextSendTimes));
        }
    }

    private final synchronized Observable<Integer> removeChannelCooldownObservable(long channelId, Type type) {
        return Intrinsics3.areEqual(type, Type.MessageSend.INSTANCE) ? this.channelMessageSendCooldownObservables.remove(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.remove(Long.valueOf(channelId));
    }

    public final Observable<Integer> observeCooldownSecs(Long channelId, Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        if (channelId != null) {
            return getChannelCooldownObservable(channelId.longValue(), type);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(0);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(0)");
        return scalarSynchronousObservable;
    }

    @Store3
    public final void onCooldown(long channelId, long cooldownMs, Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        onCooldownInternal(channelId, cooldownMs + 1000, type);
    }

    @Store3
    public final void onMessageSent(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(channelId, rateLimitPerUser * 1000, Type.MessageSend.INSTANCE);
        }
    }

    @Store3
    public final void onThreadCreated(long parentChannelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(parentChannelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(parentChannelId, rateLimitPerUser * 1000, Type.ThreadCreate.INSTANCE);
        }
    }
}
