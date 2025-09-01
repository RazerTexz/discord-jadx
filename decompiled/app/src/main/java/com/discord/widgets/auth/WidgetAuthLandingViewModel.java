package com.discord.widgets.auth;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetAuthLandingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004*+,-BG\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b(\u0010)J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR:\u0010\u000e\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;", "Lrx/Observable;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;)V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreInstantInvites;", "storeInstantInvites", "Lcom/discord/stores/StoreInstantInvites;", "mostRecentStoreState", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", "", "smartLockCredentialRequestDisabled", "Z", "getSmartLockCredentialRequestDisabled", "()Z", "setSmartLockCredentialRequestDisabled", "(Z)V", "Lcom/discord/utilities/auth/GoogleSmartLockManager;", "googleSmartLockManager", "Lcom/discord/utilities/auth/GoogleSmartLockManager;", "getGoogleSmartLockManager", "()Lcom/discord/utilities/auth/GoogleSmartLockManager;", "Landroid/content/Context;", "context", "Lcom/discord/stores/StoreAuthentication;", "storeAuthentication", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "storeObservable", "<init>", "(Landroid/content/Context;Lcom/discord/stores/StoreAuthentication;Lcom/discord/stores/StoreAnalytics;Lrx/Observable;Lcom/discord/stores/StoreInstantInvites;Lcom/discord/utilities/auth/GoogleSmartLockManager;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final GoogleSmartLockManager googleSmartLockManager;
    private StoreState mostRecentStoreState;
    private boolean smartLockCredentialRequestDisabled;
    private final StoreInstantInvites storeInstantInvites;

    /* compiled from: WidgetAuthLandingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", "it", "", "invoke", "(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "it");
            WidgetAuthLandingViewModel.this.handleStoreState(storeState);
        }
    }

    /* compiled from: WidgetAuthLandingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "it", "", "invoke", "(Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GoogleSmartLockManager.SmartLockCredentials, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
            invoke2(smartLockCredentials);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
            Intrinsics3.checkNotNullParameter(smartLockCredentials, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetAuthLandingViewModel.access$getEventSubject$p(WidgetAuthLandingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.SmartLockLogin(smartLockCredentials));
        }
    }

    /* compiled from: WidgetAuthLandingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Companion;", "", "Lcom/discord/stores/StoreInviteSettings;", "storeInviteSettings", "Lcom/discord/stores/StoreGuildTemplates;", "storeGuildTemplates", "Lcom/discord/stores/StoreAuthentication;", "storeAuthentication", "Lrx/Observable;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreInviteSettings;Lcom/discord/stores/StoreGuildTemplates;Lcom/discord/stores/StoreAuthentication;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreInviteSettings storeInviteSettings, StoreGuildTemplates storeGuildTemplates, StoreAuthentication storeAuthentication) {
            return companion.observeStoreState(storeInviteSettings, storeGuildTemplates, storeAuthentication);
        }

        private final Observable<StoreState> observeStoreState(StoreInviteSettings storeInviteSettings, StoreGuildTemplates storeGuildTemplates, StoreAuthentication storeAuthentication) {
            Observable<StoreState> observableH = Observable.h(storeInviteSettings.getInviteCode(), storeInviteSettings.getInvite(), storeGuildTemplates.observeDynamicLinkGuildTemplateCode().Y(new WidgetAuthLandingViewModel2(storeGuildTemplates)), storeAuthentication.getAgeGateError(), WidgetAuthLandingViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…eError,\n        )\n      }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthLandingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;", "", "<init>", "()V", "SmartLockLogin", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event$SmartLockLogin;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetAuthLandingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event$SmartLockLogin;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;", "Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "component1", "()Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "smartLockCredentials", "copy", "(Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;)Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event$SmartLockLogin;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "getSmartLockCredentials", "<init>", "(Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SmartLockLogin extends Event {
            private final GoogleSmartLockManager.SmartLockCredentials smartLockCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SmartLockLogin(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
                super(null);
                Intrinsics3.checkNotNullParameter(smartLockCredentials, "smartLockCredentials");
                this.smartLockCredentials = smartLockCredentials;
            }

            public static /* synthetic */ SmartLockLogin copy$default(SmartLockLogin smartLockLogin, GoogleSmartLockManager.SmartLockCredentials smartLockCredentials, int i, Object obj) {
                if ((i & 1) != 0) {
                    smartLockCredentials = smartLockLogin.smartLockCredentials;
                }
                return smartLockLogin.copy(smartLockCredentials);
            }

            /* renamed from: component1, reason: from getter */
            public final GoogleSmartLockManager.SmartLockCredentials getSmartLockCredentials() {
                return this.smartLockCredentials;
            }

            public final SmartLockLogin copy(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
                Intrinsics3.checkNotNullParameter(smartLockCredentials, "smartLockCredentials");
                return new SmartLockLogin(smartLockCredentials);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SmartLockLogin) && Intrinsics3.areEqual(this.smartLockCredentials, ((SmartLockLogin) other).smartLockCredentials);
                }
                return true;
            }

            public final GoogleSmartLockManager.SmartLockCredentials getSmartLockCredentials() {
                return this.smartLockCredentials;
            }

            public int hashCode() {
                GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = this.smartLockCredentials;
                if (smartLockCredentials != null) {
                    return smartLockCredentials.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SmartLockLogin(smartLockCredentials=");
                sbU.append(this.smartLockCredentials);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthLandingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", "", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "component1", "()Lcom/discord/stores/StoreInviteSettings$InviteCode;", "Lcom/discord/models/domain/ModelInvite;", "component2", "()Lcom/discord/models/domain/ModelInvite;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "component3", "()Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "", "component4", "()Ljava/lang/String;", "inviteCode", "invite", "guildTemplateState", "ageGateError", "copy", "(Lcom/discord/stores/StoreInviteSettings$InviteCode;Lcom/discord/models/domain/ModelInvite;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;Ljava/lang/String;)Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAgeGateError", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "getGuildTemplateState", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "getInviteCode", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "<init>", "(Lcom/discord/stores/StoreInviteSettings$InviteCode;Lcom/discord/models/domain/ModelInvite;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final String ageGateError;
        private final StoreGuildTemplates.GuildTemplateState guildTemplateState;
        private final ModelInvite invite;
        private final StoreInviteSettings.InviteCode inviteCode;

        public StoreState(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
            Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplateState");
            this.inviteCode = inviteCode;
            this.invite = modelInvite;
            this.guildTemplateState = guildTemplateState;
            this.ageGateError = str;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inviteCode = storeState.inviteCode;
            }
            if ((i & 2) != 0) {
                modelInvite = storeState.invite;
            }
            if ((i & 4) != 0) {
                guildTemplateState = storeState.guildTemplateState;
            }
            if ((i & 8) != 0) {
                str = storeState.ageGateError;
            }
            return storeState.copy(inviteCode, modelInvite, guildTemplateState, str);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelInvite getInvite() {
            return this.invite;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreGuildTemplates.GuildTemplateState getGuildTemplateState() {
            return this.guildTemplateState;
        }

        /* renamed from: component4, reason: from getter */
        public final String getAgeGateError() {
            return this.ageGateError;
        }

        public final StoreState copy(StoreInviteSettings.InviteCode inviteCode, ModelInvite invite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String ageGateError) {
            Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplateState");
            return new StoreState(inviteCode, invite, guildTemplateState, ageGateError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.inviteCode, storeState.inviteCode) && Intrinsics3.areEqual(this.invite, storeState.invite) && Intrinsics3.areEqual(this.guildTemplateState, storeState.guildTemplateState) && Intrinsics3.areEqual(this.ageGateError, storeState.ageGateError);
        }

        public final String getAgeGateError() {
            return this.ageGateError;
        }

        public final StoreGuildTemplates.GuildTemplateState getGuildTemplateState() {
            return this.guildTemplateState;
        }

        public final ModelInvite getInvite() {
            return this.invite;
        }

        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        public int hashCode() {
            StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
            int iHashCode = (inviteCode != null ? inviteCode.hashCode() : 0) * 31;
            ModelInvite modelInvite = this.invite;
            int iHashCode2 = (iHashCode + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31;
            StoreGuildTemplates.GuildTemplateState guildTemplateState = this.guildTemplateState;
            int iHashCode3 = (iHashCode2 + (guildTemplateState != null ? guildTemplateState.hashCode() : 0)) * 31;
            String str = this.ageGateError;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", invite=");
            sbU.append(this.invite);
            sbU.append(", guildTemplateState=");
            sbU.append(this.guildTemplateState);
            sbU.append(", ageGateError=");
            return outline.J(sbU, this.ageGateError, ")");
        }
    }

    /* compiled from: WidgetAuthLandingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;", "", "", "ageGateError", "Ljava/lang/String;", "getAgeGateError", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Empty", "GuildTemplate", "Invite", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$Empty;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$Invite;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$GuildTemplate;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {
        private final String ageGateError;

        /* compiled from: WidgetAuthLandingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$Empty;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;", "", "component1", "()Ljava/lang/String;", "ageGateError", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$Empty;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAgeGateError", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Empty extends ViewState {
            private final String ageGateError;

            public Empty(String str) {
                super(str, null);
                this.ageGateError = str;
            }

            public static /* synthetic */ Empty copy$default(Empty empty, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = empty.getAgeGateError();
                }
                return empty.copy(str);
            }

            public final String component1() {
                return getAgeGateError();
            }

            public final Empty copy(String ageGateError) {
                return new Empty(ageGateError);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && Intrinsics3.areEqual(getAgeGateError(), ((Empty) other).getAgeGateError());
                }
                return true;
            }

            @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel.ViewState
            public String getAgeGateError() {
                return this.ageGateError;
            }

            public int hashCode() {
                String ageGateError = getAgeGateError();
                if (ageGateError != null) {
                    return ageGateError.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Empty(ageGateError=");
                sbU.append(getAgeGateError());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetAuthLandingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$GuildTemplate;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;", "Lcom/discord/models/domain/ModelGuildTemplate;", "component1", "()Lcom/discord/models/domain/ModelGuildTemplate;", "", "component2", "()Ljava/lang/String;", "guildTemplate", "ageGateError", "copy", "(Lcom/discord/models/domain/ModelGuildTemplate;Ljava/lang/String;)Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$GuildTemplate;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAgeGateError", "Lcom/discord/models/domain/ModelGuildTemplate;", "getGuildTemplate", "<init>", "(Lcom/discord/models/domain/ModelGuildTemplate;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GuildTemplate extends ViewState {
            private final String ageGateError;
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildTemplate(ModelGuildTemplate modelGuildTemplate, String str) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
                this.guildTemplate = modelGuildTemplate;
                this.ageGateError = str;
            }

            public static /* synthetic */ GuildTemplate copy$default(GuildTemplate guildTemplate, ModelGuildTemplate modelGuildTemplate, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildTemplate = guildTemplate.guildTemplate;
                }
                if ((i & 2) != 0) {
                    str = guildTemplate.getAgeGateError();
                }
                return guildTemplate.copy(modelGuildTemplate, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public final String component2() {
                return getAgeGateError();
            }

            public final GuildTemplate copy(ModelGuildTemplate guildTemplate, String ageGateError) {
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new GuildTemplate(guildTemplate, ageGateError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildTemplate)) {
                    return false;
                }
                GuildTemplate guildTemplate = (GuildTemplate) other;
                return Intrinsics3.areEqual(this.guildTemplate, guildTemplate.guildTemplate) && Intrinsics3.areEqual(getAgeGateError(), guildTemplate.getAgeGateError());
            }

            @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel.ViewState
            public String getAgeGateError() {
                return this.ageGateError;
            }

            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public int hashCode() {
                ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
                int iHashCode = (modelGuildTemplate != null ? modelGuildTemplate.hashCode() : 0) * 31;
                String ageGateError = getAgeGateError();
                return iHashCode + (ageGateError != null ? ageGateError.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("GuildTemplate(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(", ageGateError=");
                sbU.append(getAgeGateError());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetAuthLandingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$Invite;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "", "component2", "()Ljava/lang/String;", "invite", "ageGateError", "copy", "(Lcom/discord/models/domain/ModelInvite;Ljava/lang/String;)Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState$Invite;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAgeGateError", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "<init>", "(Lcom/discord/models/domain/ModelInvite;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Invite extends ViewState {
            private final String ageGateError;
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invite(ModelInvite modelInvite, String str) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
                this.ageGateError = str;
            }

            public static /* synthetic */ Invite copy$default(Invite invite, ModelInvite modelInvite, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = invite.invite;
                }
                if ((i & 2) != 0) {
                    str = invite.getAgeGateError();
                }
                return invite.copy(modelInvite, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final String component2() {
                return getAgeGateError();
            }

            public final Invite copy(ModelInvite invite, String ageGateError) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Invite(invite, ageGateError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invite)) {
                    return false;
                }
                Invite invite = (Invite) other;
                return Intrinsics3.areEqual(this.invite, invite.invite) && Intrinsics3.areEqual(getAgeGateError(), invite.getAgeGateError());
            }

            @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel.ViewState
            public String getAgeGateError() {
                return this.ageGateError;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
                String ageGateError = getAgeGateError();
                return iHashCode + (ageGateError != null ? ageGateError.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Invite(invite=");
                sbU.append(this.invite);
                sbU.append(", ageGateError=");
                sbU.append(getAgeGateError());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState(String str) {
            this.ageGateError = str;
        }

        public String getAgeGateError() {
            return this.ageGateError;
        }

        public /* synthetic */ ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetAuthLandingViewModel(Context context, StoreAuthentication storeAuthentication, StoreAnalytics storeAnalytics, Observable observable, StoreInstantInvites storeInstantInvites, GoogleSmartLockManager googleSmartLockManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreAuthentication authentication = (i & 2) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication;
        StoreAnalytics analytics = (i & 4) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, companion2.getInviteSettings(), companion2.getGuildTemplates(), companion2.getAuthentication());
        }
        this(context, authentication, analytics, observable, (i & 16) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites, (i & 32) != 0 ? new GoogleSmartLockManager(context, null, 2, null) : googleSmartLockManager);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetAuthLandingViewModel widgetAuthLandingViewModel) {
        return widgetAuthLandingViewModel.eventSubject;
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        return this.googleSmartLockManager;
    }

    public final boolean getSmartLockCredentialRequestDisabled() {
        return this.smartLockCredentialRequestDisabled;
    }

    @MainThread
    public final void handleStoreState(StoreState storeState) {
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        StoreInviteSettings.InviteCode inviteCode = storeState.getInviteCode();
        if ((!Intrinsics3.areEqual(this.mostRecentStoreState != null ? r1.getInviteCode() : null, inviteCode)) && inviteCode != null) {
            StoreInstantInvites.fetchInviteIfNotLoaded$default(this.storeInstantInvites, inviteCode.getInviteCode(), null, null, null, null, 30, null);
        }
        ModelInvite invite = storeState.getInvite();
        StoreGuildTemplates.GuildTemplateState guildTemplateState = storeState.getGuildTemplateState();
        String ageGateError = storeState.getAgeGateError();
        if (invite != null) {
            updateViewState(new ViewState.Invite(invite, ageGateError));
        } else if (guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Resolved) {
            updateViewState(new ViewState.GuildTemplate(((StoreGuildTemplates.GuildTemplateState.Resolved) guildTemplateState).getGuildTemplate(), ageGateError));
        } else {
            updateViewState(new ViewState.Empty(ageGateError));
        }
        this.mostRecentStoreState = storeState;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setSmartLockCredentialRequestDisabled(boolean z2) {
        this.smartLockCredentialRequestDisabled = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel(Context context, StoreAuthentication storeAuthentication, StoreAnalytics storeAnalytics, Observable<StoreState> observable, StoreInstantInvites storeInstantInvites, GoogleSmartLockManager googleSmartLockManager) {
        super(new ViewState.Empty(null));
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(storeAuthentication, "storeAuthentication");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        Intrinsics3.checkNotNullParameter(googleSmartLockManager, "googleSmartLockManager");
        this.storeInstantInvites = storeInstantInvites;
        this.googleSmartLockManager = googleSmartLockManager;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetAuthLandingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(googleSmartLockManager.getSmartLockRepo().getSmartLockLoginObservable(), this, null, 2, null), WidgetAuthLandingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        storeAuthentication.requestConsentRequired();
        storeAnalytics.appLandingViewed();
    }
}
