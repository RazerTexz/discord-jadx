package com.discord.widgets.voice.call;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.d.o;
import b.c.a.a0.AnimatableValueParser;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissions2;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: PrivateCallLaunchUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aA\u0010\u000e\u001a\u00020\r2\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "isVideo", "Lcom/discord/app/AppPermissionsRequests;", "appPermissionsRequests", "Landroid/content/Context;", "context", "Lcom/discord/app/AppComponent;", "appComponent", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "callAndLaunch", "(JZLcom/discord/app/AppPermissionsRequests;Landroid/content/Context;Lcom/discord/app/AppComponent;Landroidx/fragment/app/FragmentManager;)V", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class PrivateCallLaunchUtils {

    /* compiled from: PrivateCallLaunchUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "onPermissionsGranted"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $isVideo;
        public final /* synthetic */ WeakReference $weakContext;

        /* compiled from: PrivateCallLaunchUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$StateChange;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/rtcconnection/RtcConnection$StateChange;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03571<T, R> implements Func1<RtcConnection.StateChange, Boolean> {
            public static final C03571 INSTANCE = new C03571();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(RtcConnection.StateChange stateChange) {
                return Boolean.valueOf(stateChange.state == RtcConnection.State.f.a);
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(RtcConnection.StateChange stateChange) {
                return call2(stateChange);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<Channel, Long> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Channel channel) {
                return Long.valueOf(channel != null ? channel.getId() : -1L);
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Long call(Channel channel) {
                return call2(channel);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$StateChange;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "voiceChannelId", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/rtcconnection/RtcConnection$StateChange;Ljava/lang/Long;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T1, T2, R> implements Func2<RtcConnection.StateChange, Long, Long> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(RtcConnection.StateChange stateChange, Long l) {
                return l;
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Long call(RtcConnection.StateChange stateChange, Long l) {
                return call2(stateChange, l);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/Long;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends Lambda implements Function1<Long, Boolean> {
            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                return Boolean.valueOf(invoke2(l));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Long l) {
                return l != null && l.longValue() == AnonymousClass1.this.$channelId;
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "voiceChannelId", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$5, reason: invalid class name */
        public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
            public AnonymousClass5() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                Context context;
                if (l.longValue() <= 0 || (context = (Context) AnonymousClass1.this.$weakContext.get()) == null) {
                    return;
                }
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(context, "it");
                Intrinsics3.checkNotNullExpressionValue(l, "voiceChannelId");
                WidgetCallFullscreen.Companion.launch$default(companion, context, l.longValue(), false, null, null, 28, null);
                if (StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                    return;
                }
                WidgetNoticeNuxOverlay.INSTANCE.enqueue();
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "doCall"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6, reason: invalid class name */
        public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {

            /* compiled from: PrivateCallLaunchUtils.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1, reason: invalid class name and collision with other inner class name */
            public static final class C03581 extends Lambda implements Function0<Unit> {
                public static final C03581 INSTANCE = new C03581();

                public C03581() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStream.INSTANCE.getMediaEngine().selectVideoInputDevice(null);
                }
            }

            public AnonymousClass6() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreCalls calls = StoreStream.INSTANCE.getCalls();
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                calls.call(anonymousClass1.$appComponent, anonymousClass1.$context, anonymousClass1.$fragmentManager, anonymousClass1.$channelId, C03581.INSTANCE);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "deviceGUID", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$7, reason: invalid class name */
        public static final class AnonymousClass7 extends Lambda implements Function1<String, Unit> {
            public final /* synthetic */ AnonymousClass6 $doCall$6;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass7(AnonymousClass6 anonymousClass6) {
                super(1);
                this.$doCall$6 = anonymousClass6;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str != null) {
                    this.$doCall$6.invoke2();
                } else {
                    AppToast.g(AnonymousClass1.this.$context, R.string.no_video_devices, 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, WeakReference weakReference, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2) {
            super(0);
            this.$channelId = j;
            this.$weakContext = weakReference;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$isVideo = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableZ = Observable.j(companion.getRtcConnection().getConnectionState().y(C03571.INSTANCE), companion.getVoiceChannelSelected().observeSelectedChannel().G(AnonymousClass2.INSTANCE), AnonymousClass3.INSTANCE).k(o.c(new AnonymousClass4(), -1L, 250L, TimeUnit.MILLISECONDS)).Z(1);
            Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable\n        .comb…       )\n        .take(1)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableZ), WidgetCallFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 62, (Object) null);
            AnonymousClass6 anonymousClass6 = new AnonymousClass6();
            if (this.$isVideo) {
                companion.getMediaEngine().selectDefaultVideoDevice(new AnonymousClass7(anonymousClass6));
            } else {
                anonymousClass6.invoke2();
            }
        }
    }

    /* compiled from: PrivateCallLaunchUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnonymousClass1 anonymousClass1) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    /* compiled from: PrivateCallLaunchUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    public static final void callAndLaunch(long j, boolean z2, AppPermissions2 appPermissions2, Context context, AppComponent appComponent, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(appPermissions2, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(j, new WeakReference(context), appComponent, context, fragmentManager, z2);
        if (z2) {
            appPermissions2.requestVideoCallPermissions(new AnonymousClass2(anonymousClass1));
        } else {
            AnimatableValueParser.S1(appPermissions2, null, new AnonymousClass3(anonymousClass1), 1, null);
        }
    }
}
