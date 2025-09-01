package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreMFA;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetEnableMFAViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0007J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0007J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001f¨\u0006#"}, d2 = {"Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel$ViewState;", "", "token", "", "handleMFASuccess", "(Ljava/lang/String;)V", "handleMFAFailure", "()V", "onCleared", "getTotpSecret", "()Ljava/lang/String;", "getPassword", "secret", "setTotpSecret", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "setPassword", "Landroid/content/Context;", "context", "mfaCode", "enableMFA", "(Landroid/content/Context;Ljava/lang/String;)V", "", "currentPage", "updateScreenIndex", "(I)V", "Lrx/subscriptions/CompositeSubscription;", "subs", "Lrx/subscriptions/CompositeSubscription;", "totpSecret", "Ljava/lang/String;", "encodedTotpSecret", "<init>", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEnableMFAViewModel extends AppViewModel<ViewState> {
    private String encodedTotpSecret;
    private String password;
    private CompositeSubscription subs;
    private String totpSecret;

    /* compiled from: WidgetEnableMFAViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\b\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel$ViewState;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/Integer;", "isLoading", "screenIndex", "copy", "(ZLjava/lang/Integer;)Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/Integer;", "getScreenIndex", "<init>", "(ZLjava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Integer screenIndex;

        public ViewState() {
            this(false, null, 3, null);
        }

        public ViewState(boolean z2, Integer num) {
            this.isLoading = z2;
            this.screenIndex = num;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isLoading;
            }
            if ((i & 2) != 0) {
                num = viewState.screenIndex;
            }
            return viewState.copy(z2, num);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getScreenIndex() {
            return this.screenIndex;
        }

        public final ViewState copy(boolean isLoading, Integer screenIndex) {
            return new ViewState(isLoading, screenIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics3.areEqual(this.screenIndex, viewState.screenIndex);
        }

        public final Integer getScreenIndex() {
            return this.screenIndex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.screenIndex;
            return i + (num != null ? num.hashCode() : 0);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isLoading=");
            sbU.append(this.isLoading);
            sbU.append(", screenIndex=");
            return outline.F(sbU, this.screenIndex, ")");
        }

        public /* synthetic */ ViewState(boolean z2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num);
        }
    }

    /* compiled from: WidgetEnableMFAViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/auth/mfa/EnableMfaResponse;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/api/auth/mfa/EnableMfaResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<EnableMfaResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EnableMfaResponse enableMfaResponse) {
            invoke2(enableMfaResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EnableMfaResponse enableMfaResponse) {
            WidgetEnableMFAViewModel.access$handleMFASuccess(WidgetEnableMFAViewModel.this, enableMfaResponse.getToken());
        }
    }

    /* compiled from: WidgetEnableMFAViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetEnableMFAViewModel.access$handleMFAFailure(WidgetEnableMFAViewModel.this);
        }
    }

    /* compiled from: WidgetEnableMFAViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetEnableMFAViewModel.access$getSubs$p(WidgetEnableMFAViewModel.this).a(subscription);
        }
    }

    public WidgetEnableMFAViewModel() {
        super(new ViewState(false, 0));
        this.subs = new CompositeSubscription();
    }

    public static final /* synthetic */ CompositeSubscription access$getSubs$p(WidgetEnableMFAViewModel widgetEnableMFAViewModel) {
        return widgetEnableMFAViewModel.subs;
    }

    public static final /* synthetic */ void access$handleMFAFailure(WidgetEnableMFAViewModel widgetEnableMFAViewModel) {
        widgetEnableMFAViewModel.handleMFAFailure();
    }

    public static final /* synthetic */ void access$handleMFASuccess(WidgetEnableMFAViewModel widgetEnableMFAViewModel, String str) {
        widgetEnableMFAViewModel.handleMFASuccess(str);
    }

    public static final /* synthetic */ void access$setSubs$p(WidgetEnableMFAViewModel widgetEnableMFAViewModel, CompositeSubscription compositeSubscription) {
        widgetEnableMFAViewModel.subs = compositeSubscription;
    }

    @MainThread
    private final void handleMFAFailure() {
        updateViewState(new ViewState(false, 2));
    }

    @MainThread
    private final void handleMFASuccess(String token) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getAuthentication().setAuthed(token);
        updateViewState(new ViewState(false, 3));
        companion.getMFA().updatePendingMFAState(StoreMFA.MFAActivationState.PENDING_ENABLED);
    }

    @MainThread
    public final void enableMFA(Context context, String mfaCode) {
        String str;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(mfaCode, "mfaCode");
        updateViewState(new ViewState(true, null));
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str2 = this.encodedTotpSecret;
        if (str2 == null || (str = this.password) == null) {
            return;
        }
        Observable<EnableMfaResponse> observableQ = api.enableMFA(new RestAPIParams.EnableMFA(mfaCode, str2, str)).q(2000L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableQ, "RestAPI\n        .api\n   …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableQ, false, 1, null), this, null, 2, null), WidgetEnableMFAViewModel.class, context, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 48, (Object) null);
    }

    @MainThread
    public final String getPassword() {
        return this.password;
    }

    @MainThread
    public final String getTotpSecret() {
        return this.totpSecret;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.subs.b();
    }

    @MainThread
    public final void setPassword(String password) {
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = password;
    }

    @MainThread
    public final void setTotpSecret(String secret) {
        Intrinsics3.checkNotNullParameter(secret, "secret");
        this.totpSecret = secret;
        AuthUtils authUtils = AuthUtils.INSTANCE;
        if (secret != null) {
            this.encodedTotpSecret = authUtils.encodeTotpSecret(secret);
        }
    }

    @MainThread
    public final void updateScreenIndex(int currentPage) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, Integer.valueOf(currentPage), 1, null));
        }
    }
}
