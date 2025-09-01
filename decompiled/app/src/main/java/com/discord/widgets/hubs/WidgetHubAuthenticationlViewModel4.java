package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerify;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubAuthenticationlViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u000e\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAuthenticationViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/hubs/HubAuthenticationState;", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "", "verifyCode", "(Ljava/lang/String;)V", "resendEmail", "()V", "", "multiDomainEnabled", "Z", NotificationCompat.CATEGORY_EMAIL, "Ljava/lang/String;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Ljava/lang/Long;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lcom/discord/utilities/rest/RestAPI;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAuthenticationlViewModel4 extends AppViewModel<WidgetHubAuthenticationlViewModel3> {
    private final String email;
    private final Long guildId;
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/hubs/EmailVerification;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/hubs/EmailVerification;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$1, reason: invalid class name */
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

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/EmailVerification;", "it", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$2, reason: invalid class name */
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
            WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4 = WidgetHubAuthenticationlViewModel4.this;
            WidgetHubAuthenticationlViewModel4.access$updateViewState(widgetHubAuthenticationlViewModel4, WidgetHubAuthenticationlViewModel3.copy$default(WidgetHubAuthenticationlViewModel4.access$requireViewState(widgetHubAuthenticationlViewModel4), null, restCallState, null, 5, null));
        }
    }

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/hubs/EmailVerificationCode;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/hubs/EmailVerificationCode;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<EmailVerification2, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(EmailVerification2 emailVerification2) {
            return invoke2(emailVerification2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(EmailVerification2 emailVerification2) {
            return new TrackNetworkActionHubEmailVerify();
        }
    }

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/EmailVerificationCode;", "response", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends EmailVerification2>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification2> restCallState) {
            invoke2((RestCallState<EmailVerification2>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification2> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "response");
            WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4 = WidgetHubAuthenticationlViewModel4.this;
            WidgetHubAuthenticationlViewModel4.access$updateViewState(widgetHubAuthenticationlViewModel4, WidgetHubAuthenticationlViewModel3.copy$default(WidgetHubAuthenticationlViewModel4.access$requireViewState(widgetHubAuthenticationlViewModel4), null, null, restCallState, 3, null));
        }
    }

    public /* synthetic */ WidgetHubAuthenticationlViewModel4(String str, Long l, RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ WidgetHubAuthenticationlViewModel3 access$requireViewState(WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4) {
        return widgetHubAuthenticationlViewModel4.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4, WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
        widgetHubAuthenticationlViewModel4.updateViewState(widgetHubAuthenticationlViewModel3);
    }

    public final void resendEmail() {
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(this.email, this.guildId, this.multiDomainEnabled, false, 8, null)), AnonymousClass1.INSTANCE), new AnonymousClass2());
    }

    public final void verifyCode(String code) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(this.restAPI.verifyEmailCode(new RestAPIParams.VerifyEmailCode(this.email, code, this.guildId)), AnonymousClass1.INSTANCE), new AnonymousClass2());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthenticationlViewModel4(String str, Long l, RestAPI restAPI, boolean z2) {
        super(new WidgetHubAuthenticationlViewModel3(null, null, null, 7, null));
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.guildId = l;
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
