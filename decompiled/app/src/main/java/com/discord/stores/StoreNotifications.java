package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import b.a.e.Backgrounded4;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppActivity;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.notice.NoticePopupChannel;
import d0.Result3;
import d0.Tuples;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.functions.Func2;
import s.a.Dispatchers;

/* compiled from: StoreNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010=\u001a\u00020<¢\u0006\u0004\bC\u0010DJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010\u001eJ\u0015\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001b¢\u0006\u0004\b$\u0010\u001eJ\u001f\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b)\u0010\u0014J\u0017\u0010+\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010\u0006J\u001b\u0010/\u001a\u00020\u00042\n\u0010.\u001a\u00060,j\u0002`-H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00042\u0006\u0010\t\u001a\u000201H\u0007¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0004¢\u0006\u0004\b4\u0010\u000fR\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u00108R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00108R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00160@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lcom/discord/stores/StoreNotifications;", "Lcom/discord/stores/Store;", "", "pushToken", "", "handleRegistrationToken", "(Ljava/lang/String;)V", "handleRegistrationTokenPersisted", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/api/channel/Channel;", "channel", "displayPopup", "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;)V", "tryTokenPersist", "()V", "configureNotificationClient", "Landroid/app/Application;", "application", "configureContextSetter", "(Landroid/app/Application;)V", "Lrx/Observable;", "Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "getSettings", "()Lrx/Observable;", "getPushToken", "()Ljava/lang/String;", "", "notificationsVibrateDisabled", "setNotificationsVibrateDisabled", "(Z)V", "notificationLightDisabled", "setNotificationLightDisabled", "notificationSoundDisabled", "setNotificationSoundDisabled", "enabled", "setEnabled", "isEnabledInApp", "logToggle", "setEnabledInApp", "(ZZ)V", "init", "authToken", "handleAuthToken", "", "Lcom/discord/primitives/ChannelId;", "channelId", "handleChannelSelected", "(J)V", "Lcom/discord/api/message/Message;", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "handlePreLogout", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "pushTokenPersisted", "Lcom/discord/utilities/persister/Persister;", "notificationSettings", "Lcom/discord/utilities/persister/Persister;", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreStream;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNotifications extends Store {
    private static final long INAPP_MESSAGE_WINDOW_MS = 10000;
    private String authToken;
    private final Clock clock;
    private Context context;
    private final Persister<NotificationClient.SettingsV2> notificationSettings;
    private String pushToken;
    private String pushTokenPersisted;
    private final StoreStream stream;

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/discord/stores/StoreNotifications$configureContextSetter$1", "Lcom/discord/utilities/rx/ActivityLifecycleCallbacks;", "Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", "onActivityCreatedOrResumed", "(Lcom/discord/app/AppActivity;)V", "onActivityDestroyed", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$configureContextSetter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityCreatedOrResumed(AppActivity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityCreatedOrResumed(activity);
            StoreNotifications.access$setContext$p(StoreNotifications.this, activity);
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityDestroyed(AppActivity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityDestroyed(activity);
            StoreNotifications.access$setContext$p(StoreNotifications.this, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass1(StoreNotifications storeNotifications) {
            super(1, storeNotifications, StoreNotifications.class, "handleRegistrationToken", "handleRegistrationToken(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreNotifications.access$handleRegistrationToken((StoreNotifications) this.receiver, str);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001aB\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00030\u0003 \u0001* \u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "kotlin.jvm.PlatformType", "settings", "", "isBackgrounded", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;Ljava/lang/Boolean;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<NotificationClient.SettingsV2, Boolean, Tuples2<? extends NotificationClient.SettingsV2, ? extends Boolean>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends NotificationClient.SettingsV2, ? extends Boolean> call(NotificationClient.SettingsV2 settingsV2, Boolean bool) {
            return call2(settingsV2, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<NotificationClient.SettingsV2, Boolean> call2(NotificationClient.SettingsV2 settingsV2, Boolean bool) {
            return Tuples.to(settingsV2, bool);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052F\u0010\u0004\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "kotlin.jvm.PlatformType", "", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Tuples2<? extends NotificationClient.SettingsV2, ? extends Boolean>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends NotificationClient.SettingsV2, ? extends Boolean> tuples2) {
            invoke2((Tuples2<NotificationClient.SettingsV2, Boolean>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<NotificationClient.SettingsV2, Boolean> tuples2) {
            NotificationClient.SettingsV2 settingsV2Component1 = tuples2.component1();
            Boolean boolComponent2 = tuples2.component2();
            NotificationClient notificationClient = NotificationClient.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(settingsV2Component1, "settings");
            Intrinsics3.checkNotNullExpressionValue(boolComponent2, "isBackgrounded");
            notificationClient.updateSettings$app_productionGoogleRelease(settingsV2Component1, boolComponent2.booleanValue());
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$displayPopup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, Message message) {
            super(1);
            this.$channel = channel;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intent intentSelectChannel = IntentUtils.RouteBuilders.selectChannel(this.$channel.getId(), this.$channel.getGuildId(), Long.valueOf(this.$message.getId()));
            intentSelectChannel.putExtra("com.discord.intent.ORIGIN_SOURCE", "com.discord.intent.ORIGIN_NOTIF_INAPP");
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            intentUtils.consumeExternalRoutingIntent(intentSelectChannel, context);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @DebugMetadata(c = "com.discord.stores.StoreNotifications$handleChannelSelected$1", f = "StoreNotifications.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$handleChannelSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ long $channelId;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Continuation continuation) {
            super(2, continuation);
            this.$channelId = j;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$channelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            NotificationClient.clear$default(NotificationClient.INSTANCE, this.$channelId, null, false, 6, null);
            return Unit.a;
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "it", "invoke", "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;)Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$setEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$enabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            Intrinsics3.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, this.$enabled, false, false, false, false, false, null, null, null, 510, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "it", "invoke", "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;)Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$setNotificationLightDisabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationLightDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$notificationLightDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            Intrinsics3.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, this.$notificationLightDisabled, false, false, null, null, null, 503, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "it", "invoke", "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;)Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$setNotificationSoundDisabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationSoundDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$notificationSoundDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            Intrinsics3.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, false, this.$notificationSoundDisabled, false, null, null, null, 495, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "it", "invoke", "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;)Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$setNotificationsVibrateDisabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationsVibrateDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$notificationsVibrateDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            Intrinsics3.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, false, false, this.$notificationsVibrateDisabled, null, null, null, 479, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotifications$tryTokenPersist$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreNotifications storeNotifications = StoreNotifications.this;
            StoreNotifications.access$handleRegistrationTokenPersisted(storeNotifications, StoreNotifications.access$getPushToken$p(storeNotifications));
        }
    }

    public StoreNotifications(Clock clock, StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.notificationSettings = new Persister<>("STORE_NOTIFICATIONS_SETTINGS_V2", new NotificationClient.SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    }

    public static final /* synthetic */ Context access$getContext$p(StoreNotifications storeNotifications) {
        return storeNotifications.context;
    }

    public static final /* synthetic */ String access$getPushToken$p(StoreNotifications storeNotifications) {
        return storeNotifications.pushToken;
    }

    public static final /* synthetic */ void access$handleRegistrationToken(StoreNotifications storeNotifications, String str) {
        storeNotifications.handleRegistrationToken(str);
    }

    public static final /* synthetic */ void access$handleRegistrationTokenPersisted(StoreNotifications storeNotifications, String str) {
        storeNotifications.handleRegistrationTokenPersisted(str);
    }

    public static final /* synthetic */ void access$setContext$p(StoreNotifications storeNotifications, Context context) {
        storeNotifications.context = context;
    }

    public static final /* synthetic */ void access$setPushToken$p(StoreNotifications storeNotifications, String str) {
        storeNotifications.pushToken = str;
    }

    private final void configureContextSetter(Application application) {
        application.registerActivityLifecycleCallbacks(new AnonymousClass1());
    }

    private final void configureNotificationClient() {
        NotificationClient.INSTANCE.setRegistrationIdReceived(new AnonymousClass1(this));
        Observable<NotificationClient.SettingsV2> settings = getSettings();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableJ = Observable.j(Observable.h(settings, companion.getAuthentication().getAuthedToken$app_productionGoogleRelease(), companion.getUserSettingsSystem().observeSettings(false), ObservableExtensionsKt.leadingEdgeThrottle(companion.getPermissions().observePermissionsForAllChannels(), 1L, TimeUnit.SECONDS).G(StoreNotifications2.INSTANCE), StoreNotifications3.INSTANCE).r(), Backgrounded4.d.a(), AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb… isBackgrounded\n        }");
        Observable observableR = ObservableExtensionsKt.computationBuffered(observableJ).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, (Context) null, "nsClient", (Function1) null, AnonymousClass3.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final void displayPopup(Message message, Channel channel) {
        Context context;
        if ((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH + 10000 <= this.clock.currentTimeMillis() || (context = this.context) == null) {
            return;
        }
        NoticePopupChannel noticePopupChannel = NoticePopupChannel.INSTANCE;
        StringBuilder sbU = outline.U("{InAppNotif}#");
        sbU.append(message.getChannelId());
        noticePopupChannel.enqueue(context, sbU.toString(), message, new AnonymousClass1(channel, message));
    }

    private final synchronized void handleRegistrationToken(String pushToken) {
        this.pushToken = pushToken;
        tryTokenPersist();
    }

    private final synchronized void handleRegistrationTokenPersisted(String pushToken) {
        this.pushTokenPersisted = pushToken;
    }

    public static /* synthetic */ void setEnabledInApp$default(StoreNotifications storeNotifications, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z3 = true;
        }
        storeNotifications.setEnabledInApp(z2, z3);
    }

    private final void tryTokenPersist() {
        String str = this.authToken;
        if (str == null) {
            this.pushTokenPersisted = null;
        }
        if (str == null || Intrinsics3.areEqual(this.pushToken, this.pushTokenPersisted)) {
            return;
        }
        ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userCreateDevice(new RestAPIParams.UserDevices(this.pushToken)), false, 1, null)).k(o.a.g(null, new AnonymousClass1(), null));
    }

    public final synchronized String getPushToken() {
        return this.pushToken;
    }

    public final Observable<NotificationClient.SettingsV2> getSettings() {
        return ObservableExtensionsKt.computationBuffered(this.notificationSettings.getObservable());
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authToken = authToken;
        tryTokenPersist();
    }

    @Store3
    public final void handleChannelSelected(long channelId) {
        f.H0(f.c(Dispatchers.a), null, null, new AnonymousClass1(channelId, null), 3, null);
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(message, "message");
        if (this.notificationSettings.get().isEnabledInApp() && this.stream.getPresences().getLocalPresence().getStatus() != ClientStatus.DND) {
            Map<Long, Integer> relationships = this.stream.getUserRelationships().getRelationships();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : relationships.entrySet()) {
                if (entry.getValue().intValue() == 2) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (message.getChannelId() == this.stream.getChannelsSelected().getId()) {
                return;
            }
            Map<Long, Map<Long, Channel>> channelsByGuildInternal$app_productionGoogleRelease = this.stream.getChannels().getChannelsByGuildInternal$app_productionGoogleRelease();
            Long guildId = message.getGuildId();
            Map<Long, Channel> map = channelsByGuildInternal$app_productionGoogleRelease.get(Long.valueOf(guildId != null ? guildId.longValue() : 0L));
            Channel channel2 = this.stream.getChannels().getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(message.getChannelId()));
            if (channel2 != null) {
                channel = channel2;
            } else if (map != null) {
                channel2 = map.get(Long.valueOf(message.getChannelId()));
                channel = channel2;
            } else {
                channel = null;
            }
            if (channel != null) {
                if (NotificationTextUtils.INSTANCE.shouldNotifyInAppPopup(this.stream.getUsers().getMe(), message, channel, linkedHashMap, map != null ? map.get(Long.valueOf(channel.getParentId())) : null, (Guild) outline.c(channel, this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease()), this.stream.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease(), this.stream.getGuildSettings().getGuildSettingsInternal$app_productionGoogleRelease(), this.stream.getThreadsJoined().getAllJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getVoiceChannelSelected().getSelectedVoiceChannelId(), (Long) outline.d(channel, this.stream.getPermissions().getPermissionsByChannel()))) {
                    displayPopup(new Message(message), channel);
                }
            }
        }
    }

    public final void handlePreLogout() {
        Persister.set$default(this.notificationSettings, new NotificationClient.SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null), false, 2, null);
    }

    public final void init(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        super.init((Context) application);
        configureContextSetter(application);
        configureNotificationClient();
    }

    public final void setEnabled(boolean enabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(enabled));
        AnalyticsTracker.INSTANCE.updateNotifications(enabled);
    }

    public final void setEnabledInApp(boolean isEnabledInApp, boolean logToggle) {
        NotificationClient.SettingsV2 andSet = this.notificationSettings.getAndSet(true, new StoreNotifications4(isEnabledInApp));
        if (!logToggle || andSet.isEnabledInApp() == isEnabledInApp) {
            return;
        }
        AnalyticsTracker.INSTANCE.updateNotificationsInApp(isEnabledInApp);
    }

    public final void setNotificationLightDisabled(boolean notificationLightDisabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(notificationLightDisabled));
    }

    public final void setNotificationSoundDisabled(boolean notificationSoundDisabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(notificationSoundDisabled));
    }

    public final void setNotificationsVibrateDisabled(boolean notificationsVibrateDisabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(notificationsVibrateDisabled));
    }
}
