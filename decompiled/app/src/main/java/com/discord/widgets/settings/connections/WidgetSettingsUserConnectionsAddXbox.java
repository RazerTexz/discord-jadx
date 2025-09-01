package com.discord.widgets.settings.connections;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.models.domain.ModelConnectionState;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJG\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAddXbox;", "Lcom/discord/app/AppFragment;", "", "showPinError", "()V", "trackXboxLinkStep", "Lcom/discord/utilities/error/Error;", "error", "trackXboxLinkFailed", "(Lcom/discord/utilities/error/Error;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "", "verificationCode", "Lcom/discord/utilities/platform/Platform;", "platform", "Lcom/discord/utilities/dimmer/DimmerView;", "dimmer", "Lcom/discord/app/AppComponent;", "appComponent", "Landroid/app/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lrx/functions/Action1;", "errorHandler", "submitPinCode", "(Ljava/lang/String;Lcom/discord/utilities/platform/Platform;Lcom/discord/utilities/dimmer/DimmerView;Lcom/discord/app/AppComponent;Landroid/app/Activity;Lrx/functions/Action1;)V", "Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsUserConnectionsAddXbox.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAddXbox$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsUserConnectionsAddXbox.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreUserConnections userConnections = StoreStream.INSTANCE.getUserConnections();
            String platformId = Platform.XBOX.getPlatformId();
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            userConnections.authorizeConnection(platformId, context, Traits.Location.Page.USER_SETTINGS);
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "verificationCode", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {

        /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "error", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<Error> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Error error) {
                call2(error);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Error error) {
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox = WidgetSettingsUserConnectionsAddXbox.this;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                WidgetSettingsUserConnectionsAddXbox.access$trackXboxLinkFailed(widgetSettingsUserConnectionsAddXbox, error);
                if (error.getType() == Error.Type.DISCORD_REQUEST_ERROR) {
                    error.setShowErrorToasts(false);
                    WidgetSettingsUserConnectionsAddXbox.access$showPinError(WidgetSettingsUserConnectionsAddXbox.this);
                }
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "verificationCode");
            if (str.length() == 6) {
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox = WidgetSettingsUserConnectionsAddXbox.this;
                Platform platform = Platform.XBOX;
                DimmerView dimmerView = WidgetSettingsUserConnectionsAddXbox.access$getBinding$p(widgetSettingsUserConnectionsAddXbox).d;
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox2 = WidgetSettingsUserConnectionsAddXbox.this;
                widgetSettingsUserConnectionsAddXbox.submitPinCode(str, platform, dimmerView, widgetSettingsUserConnectionsAddXbox2, widgetSettingsUserConnectionsAddXbox2.getActivity(), new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/domain/ModelConnectionState;", "kotlin.jvm.PlatformType", "state", "Lrx/Observable;", "Ljava/lang/Void;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelConnectionState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$submitPinCode$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ModelConnectionState, Observable<? extends Void>> {
        public final /* synthetic */ Platform $platform;

        public AnonymousClass1(Platform platform) {
            this.$platform = platform;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Void> call(ModelConnectionState modelConnectionState) {
            return call2(modelConnectionState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Void> call2(ModelConnectionState modelConnectionState) {
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(modelConnectionState, "state");
            analyticsTracker.accountLinkStep("PIN code entry", "PIN success", modelConnectionState.getState(), this.$platform.getPlatformId());
            RestAPI api = RestAPI.INSTANCE.getApi();
            String platformId = this.$platform.getPlatformId();
            String code = modelConnectionState.getCode();
            String state = modelConnectionState.getState();
            Boolean bool = Boolean.TRUE;
            return api.submitConnectionState(platformId, new RestAPIParams.ConnectionState(code, state, bool, bool));
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$submitPinCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Activity activity) {
            super(1);
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            Activity activity = this.$activity;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WidgetSettingsUserConnectionsAddXbox() {
        super(R.layout.widget_connections_add_xbox);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsUserConnectionsAddXbox2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetConnectionsAddXboxBinding access$getBinding$p(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox) {
        return widgetSettingsUserConnectionsAddXbox.getBinding();
    }

    public static final /* synthetic */ void access$showPinError(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox) {
        widgetSettingsUserConnectionsAddXbox.showPinError();
    }

    public static final /* synthetic */ void access$trackXboxLinkFailed(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox, Error error) {
        widgetSettingsUserConnectionsAddXbox.trackXboxLinkFailed(error);
    }

    private final WidgetConnectionsAddXboxBinding getBinding() {
        return (WidgetConnectionsAddXboxBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void showPinError() {
        AppToast.g(getContext(), R.string.connection_invalid_pin, 0, null, 12);
        getBinding().f2354b.b();
    }

    private final void trackXboxLinkFailed(Error error) {
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        String bodyText = error.getBodyText();
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        analyticsTracker.accountLinkFailed(bodyText, Integer.valueOf(response.getCode()), "pin", "PIN code entry", Platform.XBOX.getPlatformId());
    }

    private final void trackXboxLinkStep() {
        AnalyticsTracker.accountLinkStep$default(AnalyticsTracker.INSTANCE, "mobile connections", "PIN code entry", null, Platform.XBOX.getPlatformId(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.connections);
        trackXboxLinkStep();
        getBinding().c.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().f2354b.setOnCodeEntered(new AnonymousClass2());
    }

    public final void submitPinCode(String verificationCode, Platform platform, DimmerView dimmer, AppComponent appComponent, Activity activity, Action1<Error> errorHandler) {
        Intrinsics3.checkNotNullParameter(verificationCode, "verificationCode");
        Intrinsics3.checkNotNullParameter(platform, "platform");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(errorHandler, "errorHandler");
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getConnectionState(platform.getPlatformId(), verificationCode), false, 1, null).A(new AnonymousClass1(platform));
        Intrinsics3.checkNotNullExpressionValue(observableA, "RestAPI\n        .api\n   …              )\n        }");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(observableA, appComponent, null, 2, null), dimmer, 0L, 2, null).k(o.a.g(activity, new AnonymousClass2(activity), errorHandler));
    }
}
