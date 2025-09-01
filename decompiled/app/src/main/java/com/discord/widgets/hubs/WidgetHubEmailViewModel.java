package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.hubs.EmailVerification;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubEmailViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubEmailViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/hubs/HubEmailState;", "", NotificationCompat.CATEGORY_EMAIL, "", "submitEmail", "(Ljava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "()V", "Lcom/discord/widgets/hubs/HubWaitlistResult;", "waitlistResult", "setHubWaitlistResult", "(Lcom/discord/widgets/hubs/HubWaitlistResult;)V", "", "multiDomainEnabled", "Z", "getMultiDomainEnabled", "()Z", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "<init>", "(Lcom/discord/utilities/rest/RestAPI;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubEmailViewModel extends AppViewModel<WidgetHubEmailViewModel4> {
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubEmailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/hubs/EmailVerification;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/hubs/EmailVerification;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailViewModel$submitEmail$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<EmailVerification, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(EmailVerification emailVerification) {
            return invoke2(emailVerification);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(EmailVerification emailVerification) {
            return new TrackNetworkActionHubEmailVerifySend(emailVerification != null ? Boolean.valueOf(emailVerification.getHasMatchingGuild()) : null);
        }
    }

    /* compiled from: WidgetHubEmailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/EmailVerification;", "it", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailViewModel$submitEmail$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends EmailVerification>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
            invoke2((RestCallState<EmailVerification>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "it");
            WidgetHubEmailViewModel widgetHubEmailViewModel = WidgetHubEmailViewModel.this;
            WidgetHubEmailViewModel.access$updateViewState(widgetHubEmailViewModel, WidgetHubEmailViewModel4.copy$default(WidgetHubEmailViewModel.access$requireViewState(widgetHubEmailViewModel), null, null, null, restCallState, 7, null));
        }
    }

    public WidgetHubEmailViewModel() {
        this(null, false, 3, null);
    }

    public /* synthetic */ WidgetHubEmailViewModel(RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 2) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ WidgetHubEmailViewModel4 access$requireViewState(WidgetHubEmailViewModel widgetHubEmailViewModel) {
        return widgetHubEmailViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubEmailViewModel widgetHubEmailViewModel, WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
        widgetHubEmailViewModel.updateViewState(widgetHubEmailViewModel4);
    }

    public final boolean getMultiDomainEnabled() {
        return this.multiDomainEnabled;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void reset() {
        WidgetHubEmailViewModel4 viewState = getViewState();
        Intrinsics3.checkNotNull(viewState);
        updateViewState(WidgetHubEmailViewModel4.copy$default(viewState, null, null, null, RestCallState2.INSTANCE, 5, null));
    }

    public final void setHubWaitlistResult(WidgetHubWaitlist2 waitlistResult) {
        Intrinsics3.checkNotNullParameter(waitlistResult, "waitlistResult");
        WidgetHubEmailViewModel4 viewState = getViewState();
        Intrinsics3.checkNotNull(viewState);
        updateViewState(WidgetHubEmailViewModel4.copy$default(viewState, null, null, waitlistResult, null, 11, null));
    }

    public final void submitEmail(String email) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(ObservableExtensionsKt.ui$default(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(email, null, this.multiDomainEnabled, false, 10, null)), this, null, 2, null), AnonymousClass1.INSTANCE), new AnonymousClass2());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailViewModel(RestAPI restAPI, boolean z2) {
        super(new WidgetHubEmailViewModel4(null, null, null, null, 15, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
