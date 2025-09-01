package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.d.o;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelCall;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.voice.call.WidgetCallFailed;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreCalls.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b?\u0010@J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000f\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00040\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00112\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u0012\u0010\u0013JC\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010!\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0014\b\u0002\u0010 \u001a\u000e\u0012\b\u0012\u00060\tj\u0002`\u001f\u0018\u00010\u001e¢\u0006\u0004\b!\u0010\"J/\u0010#\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0014\b\u0002\u0010 \u001a\u000e\u0012\b\u0012\u00060\tj\u0002`\u001f\u0018\u00010\u001e¢\u0006\u0004\b#\u0010\"J\r\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\bJ\u0015\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0006J\u0019\u0010)\u001a\u00020\u00042\n\u0010(\u001a\u00060\tj\u0002`'¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\u001f¢\u0006\u0004\b+\u0010*J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\r¢\u0006\u0004\b/\u0010-R\u001a\u00100\u001a\u00060\tj\u0002`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R>\u00104\u001a*\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r02j\u0014\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r`38\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R×\u0001\u0010<\u001aÂ\u0001\u0012^\u0012\\\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r ;*.\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u000102j\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`302j\u0014\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r`3\u0012^\u0012\\\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r ;*.\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u000102j\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`302j\u0014\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\r`30:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010>\u001a\u00060\tj\u0002`'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00101¨\u0006A"}, d2 = {"Lcom/discord/stores/StoreCalls;", "", "", "updated", "", "callSubjectUpdate", "(Z)V", "callConnect", "()V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lkotlin/Function1;", "Lcom/discord/models/domain/ModelCall;", "onFoundCall", "findCall", "(JLkotlin/jvm/functions/Function1;)V", "Lrx/Observable;", "get", "(J)Lrx/Observable;", "Lcom/discord/app/AppComponent;", "appComponent", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "onError", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/app/AppComponent;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JLkotlin/jvm/functions/Function0;)V", "", "Lcom/discord/primitives/UserId;", "recipients", "ring", "(JLjava/util/List;)V", "stopRinging", "handleConnectionOpen", "connectionReady", "handleConnectionReady", "Lcom/discord/primitives/GuildId;", "guildId", "handleGuildSelect", "(J)V", "handleChannelSelect", "handleCallCreateOrUpdate", "(Lcom/discord/models/domain/ModelCall;)V", "callDelete", "handleCallDelete", "selectedChannelId", "J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "calls", "Ljava/util/HashMap;", "Z", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "callsSubject", "Lrx/subjects/SerializedSubject;", "selectedGuildId", "<init>", "(Lcom/discord/stores/StoreStream;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreCalls {
    private final HashMap<Long, ModelCall> calls;
    private final SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> callsSubject;
    private boolean connectionReady;
    private long selectedChannelId;
    private long selectedGuildId;
    private final StoreStream stream;

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "ring", "", "invoke", "(Z)V", "doCall"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$call$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreCalls.access$getStream$p(StoreCalls.this).getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            if (z2) {
                StoreCalls.ring$default(StoreCalls.this, this.$channelId, null, 2, null);
            }
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "", "invoke", "(J)V", "doCallIfCallable"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$call$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass1 $doCall$1;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onError;

        /* compiled from: StoreCalls.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/RelationshipType;", "relationshipType", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreCalls$call$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Integer, Observable<? extends Boolean>> {

            /* compiled from: StoreCalls.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelCall$Ringable;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelCall$Ringable;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreCalls$call$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00951<T, R> implements Func1<ModelCall.Ringable, Boolean> {
                public static final C00951 INSTANCE = new C00951();

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Boolean call(ModelCall.Ringable ringable) {
                    return call2(ringable);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Boolean call2(ModelCall.Ringable ringable) {
                    Intrinsics3.checkNotNullExpressionValue(ringable, "it");
                    return Boolean.valueOf(ringable.isRingable());
                }
            }

            public AnonymousClass1() {
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
                return call2(num);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Boolean> call2(Integer num) {
                return (num != null && num.intValue() == 1) ? new ScalarSynchronousObservable(Boolean.TRUE) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().call(AnonymousClass2.this.$channelId), false, 1, null).G(C00951.INSTANCE);
            }
        }

        /* compiled from: StoreCalls.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isRingable", "", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreCalls$call$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00962 extends Lambda implements Function1<Boolean, Unit> {
            public C00962() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AnonymousClass1 anonymousClass1 = AnonymousClass2.this.$doCall$1;
                Intrinsics3.checkNotNullExpressionValue(bool, "isRingable");
                anonymousClass1.invoke(bool.booleanValue());
            }
        }

        /* compiled from: StoreCalls.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreCalls$call$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ long $userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(long j) {
                super(1);
                this.$userId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Function0 function0 = AnonymousClass2.this.$onError;
                if (function0 != null) {
                }
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 50013) {
                    error.setShowErrorToasts(false);
                    WidgetCallFailed.INSTANCE.show(AnonymousClass2.this.$fragmentManager, this.$userId);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, AppComponent appComponent, Context context, AnonymousClass1 anonymousClass1, Function0 function0, FragmentManager fragmentManager) {
            super(1);
            this.$channelId = j;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$doCall$1 = anonymousClass1;
            this.$onError = function0;
            this.$fragmentManager = fragmentManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            Observable<R> observableA = StoreStream.INSTANCE.getUserRelationships().observe(j).A(new AnonymousClass1());
            Intrinsics3.checkNotNullExpressionValue(observableA, "StoreStream\n          .g…            }\n          }");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), this.$appComponent, null, 2, null);
            Context context = this.$context;
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, StoreCalls.this.getClass(), context, (Function1) null, new AnonymousClass3(j), (Function0) null, (Function0) null, new C00962(), 52, (Object) null);
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$call$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Channel, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            return channel != null;
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001av\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012,\u0012*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u0002 \u0006*:\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012,\u0012*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u0002\u0018\u00010\b0\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/api/voice/state/VoiceState;", "kotlin.jvm.PlatformType", "voiceStates", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;Ljava/util/Map;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$call$4, reason: invalid class name */
    public static final class AnonymousClass4<T1, T2, R> implements Func2<Channel, Map<Long, ? extends VoiceState>, Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>>> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>> call(Channel channel, Map<Long, ? extends VoiceState> map) {
            return call2(channel, (Map<Long, VoiceState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<Channel, Map<Long, VoiceState>> call2(Channel channel, Map<Long, VoiceState> map) {
            return new Tuples2<>(channel, map);
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2z\u0010\u0007\u001av\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012,\u0012*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u0002 \u0006*:\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012,\u0012*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/api/voice/state/VoiceState;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$call$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>>, Unit> {
        public final /* synthetic */ AnonymousClass1 $doCall$1;
        public final /* synthetic */ AnonymousClass2 $doCallIfCallable$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(AnonymousClass2 anonymousClass2, AnonymousClass1 anonymousClass1) {
            super(1);
            this.$doCallIfCallable$2 = anonymousClass2;
            this.$doCall$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>> tuples2) {
            invoke2((Tuples2<Channel, ? extends Map<Long, VoiceState>>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<Channel, ? extends Map<Long, VoiceState>> tuples2) {
            Channel channelComponent1 = tuples2.component1();
            Map<Long, VoiceState> mapComponent2 = tuples2.component2();
            User userA = channelComponent1 != null ? ChannelUtils.a(channelComponent1) : null;
            if (userA != null) {
                this.$doCallIfCallable$2.invoke(userA.getId());
            } else if (channelComponent1 != null) {
                this.$doCall$1.invoke(mapComponent2.isEmpty());
            }
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelCall;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelCall;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$findCall$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelCall, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelCall modelCall) {
            return Boolean.valueOf(invoke2(modelCall));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelCall modelCall) {
            return modelCall != null;
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\u0004\u0018\u00010\u00032`\u0010\u0006\u001a\\\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0005*.\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0000j\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00040\u0000j\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/util/HashMap;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/models/domain/ModelCall;", "Lkotlin/collections/HashMap;", "kotlin.jvm.PlatformType", "calls", NotificationCompat.CATEGORY_CALL, "(Ljava/util/HashMap;)Lcom/discord/models/domain/ModelCall;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$get$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<HashMap<Long, ModelCall>, ModelCall> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ModelCall call(HashMap<Long, ModelCall> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelCall call2(HashMap<Long, ModelCall> map) {
            return map.get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelCall;", NotificationCompat.CATEGORY_CALL, "", "invoke", "(Lcom/discord/models/domain/ModelCall;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$ring$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelCall, Unit> {
        public final /* synthetic */ List $recipients;

        /* compiled from: StoreCalls.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreCalls$ring$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00971 extends Lambda implements Function1<Void, Unit> {
            public static final C00971 INSTANCE = new C00971();

            public C00971() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(1);
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall != null) {
                ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApi().ring(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), StoreCalls.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C00971.INSTANCE, 62, (Object) null);
            }
        }
    }

    /* compiled from: StoreCalls.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelCall;", NotificationCompat.CATEGORY_CALL, "", "invoke", "(Lcom/discord/models/domain/ModelCall;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCalls$stopRinging$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelCall, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ List $recipients;

        /* compiled from: StoreCalls.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreCalls$stopRinging$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00981 extends Lambda implements Function1<Void, Unit> {
            public static final C00981 INSTANCE = new C00981();

            public C00981() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, List list) {
            super(1);
            this.$channelId = j;
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall == null) {
                StoreCalls.access$getStream$p(StoreCalls.this).getCallsIncoming().removeIncomingCall(this.$channelId);
            } else {
                ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApi().stopRinging(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), StoreCalls.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C00981.INSTANCE, 62, (Object) null);
            }
        }
    }

    public StoreCalls(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.calls = new HashMap<>();
        this.callsSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreCalls storeCalls) {
        return storeCalls.stream;
    }

    public static /* synthetic */ void call$default(StoreCalls storeCalls, AppComponent appComponent, Context context, FragmentManager fragmentManager, long j, Function0 function0, int i, Object obj) {
        if ((i & 16) != 0) {
            function0 = null;
        }
        storeCalls.call(appComponent, context, fragmentManager, j, function0);
    }

    private final void callConnect() {
        if (this.connectionReady && this.selectedGuildId == 0) {
            long j = this.selectedChannelId;
            if (j <= 0 || this.calls.containsKey(Long.valueOf(j))) {
                return;
            }
            this.calls.put(Long.valueOf(this.selectedChannelId), null);
            this.stream.getGatewaySocket().callConnect(this.selectedChannelId);
        }
    }

    private final void callSubjectUpdate(boolean updated) {
        if (updated) {
            SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> serializedSubject = this.callsSubject;
            serializedSubject.k.onNext(new HashMap<>(this.calls));
        }
    }

    public static /* synthetic */ void callSubjectUpdate$default(StoreCalls storeCalls, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeCalls.callSubjectUpdate(z2);
    }

    private final void findCall(long channelId, Function1<? super ModelCall, Unit> onFoundCall) {
        Observable<R> observableK = get(channelId).k(o.c(AnonymousClass1.INSTANCE, null, 3L, TimeUnit.SECONDS));
        Intrinsics3.checkNotNullExpressionValue(observableK, "get(channelId)\n        .…l?, 3, TimeUnit.SECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableK, 0L, false, 3, null), StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, onFoundCall, 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ring$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.ring(j, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void stopRinging$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.stopRinging(j, list);
    }

    public final void call(AppComponent appComponent, Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onError) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channelId);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(channelId, appComponent, context, anonymousClass1, onError, fragmentManager);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableZ = Observable.j0(companion.getChannels().observeChannel(channelId).k(o.c(AnonymousClass3.INSTANCE, null, 5000L, TimeUnit.MILLISECONDS)), companion.getVoiceStates().observeForPrivateChannels(channelId), AnonymousClass4.INSTANCE).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable\n        .zip(…tates) }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(anonymousClass2, anonymousClass1), 62, (Object) null);
    }

    public final Observable<ModelCall> get(long channelId) {
        Observable<R> observableG = this.callsSubject.G(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "callsSubject\n          .…lls -> calls[channelId] }");
        Observable<ModelCall> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "callsSubject\n          .…  .distinctUntilChanged()");
        return observableR;
    }

    public final void handleCallCreateOrUpdate(ModelCall call) {
        Intrinsics3.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        boolean z2 = true;
        if (!Intrinsics3.areEqual(call, this.calls.get(Long.valueOf(channelId)))) {
            this.calls.put(Long.valueOf(channelId), call);
        } else {
            z2 = false;
        }
        callSubjectUpdate(z2);
    }

    public final void handleCallDelete(ModelCall callDelete) {
        Intrinsics3.checkNotNullParameter(callDelete, "callDelete");
        long channelId = callDelete.getChannelId();
        if (this.calls.containsKey(Long.valueOf(channelId))) {
            this.calls.put(Long.valueOf(channelId), null);
            callSubjectUpdate$default(this, false, 1, null);
        }
    }

    public final void handleChannelSelect(long channelId) {
        this.selectedChannelId = channelId;
        callConnect();
    }

    public final void handleConnectionOpen() {
        this.calls.clear();
        callSubjectUpdate$default(this, false, 1, null);
        callConnect();
    }

    public final void handleConnectionReady(boolean connectionReady) {
        this.connectionReady = connectionReady;
        callConnect();
    }

    public final void handleGuildSelect(long guildId) {
        this.selectedGuildId = guildId;
        callConnect();
    }

    public final void ring(long channelId, List<Long> recipients) {
        findCall(channelId, new AnonymousClass1(recipients));
    }

    public final void stopRinging(long channelId, List<Long> recipients) {
        findCall(channelId, new AnonymousClass1(channelId, recipients));
    }
}
