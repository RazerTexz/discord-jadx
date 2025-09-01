package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003/01B'\u0012\n\u0010!\u001a\u00060\u001fj\u0002` \u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0010J)\u0010\u0016\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u00060\u001fj\u0002` 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010%\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u00030\u0003 $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u00030\u0003\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;", "event", "", "emitEvent", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;)V", "viewState", "", "computeCanProceedToNextStep", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;)Z", "Lrx/Observable;", "observeEvents", "()Lrx/Observable;", "goToNextStep", "()V", "goToPreviousStep", "", "coverImage", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "isFullServerGating", "onSubscriptionPlanUpdated", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "guildRoleSubscriptionTier", "onTierUpdated", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)V", "submit", "updateViewState", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "<init>", "(JLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;)V", "Companion", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanSetupViewModel extends AppViewModel<ViewState> {
    private static final int DETAILS_STEP = 1;
    private static final int FORMAT_TYPE_STEP = 0;
    private static final int TIER_CHANNEL_BENEFITS_STEP = 3;
    private static final int TIER_DESIGN_STEP = 5;
    private static final int TIER_DETAILS_STEP = 2;
    private static final int TIER_INTANGIBLE_BENEFITS_STEP = 4;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;", "", "<init>", "()V", "SubmitFailure", "SubmitSuccess", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure;", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SubmitFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ SubmitFailure copy$default(SubmitFailure submitFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = submitFailure.error;
                }
                return submitFailure.copy(error);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final SubmitFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new SubmitFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SubmitFailure) && Intrinsics3.areEqual(this.error, ((SubmitFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubmitFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class SubmitSuccess extends Event {
            public static final SubmitSuccess INSTANCE = new SubmitSuccess();

            private SubmitSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\\\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010\u0011R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b%\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b)\u0010\u000b¨\u0006,"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;", "", "", "component1", "()I", "", "component2", "()Z", "component3", "", "component4", "()Ljava/lang/String;", "component5", "component6", "()Ljava/lang/Boolean;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "component7", "()Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "currentStep", "isSubmitting", "canProceedToNextStep", "coverImage", "planDescription", "isFullServerGating", "guildRoleSubscriptionTier", "copy", "(IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "getGuildRoleSubscriptionTier", "Ljava/lang/String;", "getCoverImage", "getCanProceedToNextStep", "Ljava/lang/Boolean;", "I", "getCurrentStep", "getPlanDescription", "<init>", "(IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean canProceedToNextStep;
        private final String coverImage;
        private final int currentStep;
        private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        private final Boolean isFullServerGating;
        private final boolean isSubmitting;
        private final String planDescription;

        public ViewState() {
            this(0, false, false, null, null, null, null, Opcodes.LAND, null);
        }

        public ViewState(int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            this.currentStep = i;
            this.isSubmitting = z2;
            this.canProceedToNextStep = z3;
            this.coverImage = str;
            this.planDescription = str2;
            this.isFullServerGating = bool;
            this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = viewState.currentStep;
            }
            if ((i2 & 2) != 0) {
                z2 = viewState.isSubmitting;
            }
            boolean z4 = z2;
            if ((i2 & 4) != 0) {
                z3 = viewState.canProceedToNextStep;
            }
            boolean z5 = z3;
            if ((i2 & 8) != 0) {
                str = viewState.coverImage;
            }
            String str3 = str;
            if ((i2 & 16) != 0) {
                str2 = viewState.planDescription;
            }
            String str4 = str2;
            if ((i2 & 32) != 0) {
                bool = viewState.isFullServerGating;
            }
            Boolean bool2 = bool;
            if ((i2 & 64) != 0) {
                guildRoleSubscriptionTier = viewState.guildRoleSubscriptionTier;
            }
            return viewState.copy(i, z4, z5, str3, str4, bool2, guildRoleSubscriptionTier);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCurrentStep() {
            return this.currentStep;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanProceedToNextStep() {
            return this.canProceedToNextStep;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPlanDescription() {
            return this.planDescription;
        }

        /* renamed from: component6, reason: from getter */
        public final Boolean getIsFullServerGating() {
            return this.isFullServerGating;
        }

        /* renamed from: component7, reason: from getter */
        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public final ViewState copy(int currentStep, boolean isSubmitting, boolean canProceedToNextStep, String coverImage, String planDescription, Boolean isFullServerGating, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            return new ViewState(currentStep, isSubmitting, canProceedToNextStep, coverImage, planDescription, isFullServerGating, guildRoleSubscriptionTier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.currentStep == viewState.currentStep && this.isSubmitting == viewState.isSubmitting && this.canProceedToNextStep == viewState.canProceedToNextStep && Intrinsics3.areEqual(this.coverImage, viewState.coverImage) && Intrinsics3.areEqual(this.planDescription, viewState.planDescription) && Intrinsics3.areEqual(this.isFullServerGating, viewState.isFullServerGating) && Intrinsics3.areEqual(this.guildRoleSubscriptionTier, viewState.guildRoleSubscriptionTier);
        }

        public final boolean getCanProceedToNextStep() {
            return this.canProceedToNextStep;
        }

        public final String getCoverImage() {
            return this.coverImage;
        }

        public final int getCurrentStep() {
            return this.currentStep;
        }

        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public final String getPlanDescription() {
            return this.planDescription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = this.currentStep * 31;
            boolean z2 = this.isSubmitting;
            int i2 = z2;
            if (z2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.canProceedToNextStep;
            int i4 = (i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            String str = this.coverImage;
            int iHashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.planDescription;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.isFullServerGating;
            int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
            return iHashCode3 + (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0);
        }

        public final Boolean isFullServerGating() {
            return this.isFullServerGating;
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(currentStep=");
            sbU.append(this.currentStep);
            sbU.append(", isSubmitting=");
            sbU.append(this.isSubmitting);
            sbU.append(", canProceedToNextStep=");
            sbU.append(this.canProceedToNextStep);
            sbU.append(", coverImage=");
            sbU.append(this.coverImage);
            sbU.append(", planDescription=");
            sbU.append(this.planDescription);
            sbU.append(", isFullServerGating=");
            sbU.append(this.isFullServerGating);
            sbU.append(", guildRoleSubscriptionTier=");
            sbU.append(this.guildRoleSubscriptionTier);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? z3 : false, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2, (i2 & 32) == 0 ? bool : null, (i2 & 64) != 0 ? new GuildRoleSubscriptionTier(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : guildRoleSubscriptionTier);
        }
    }

    /* compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "it", "", "invoke", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel$submit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel = GuildRoleSubscriptionPlanSetupViewModel.this;
            guildRoleSubscriptionPlanSetupViewModel.updateViewState2(ViewState.copy$default(GuildRoleSubscriptionPlanSetupViewModel.access$requireViewState(guildRoleSubscriptionPlanSetupViewModel), 0, false, false, null, null, null, null, Opcodes.LUSHR, null));
            GuildRoleSubscriptionPlanSetupViewModel.access$emitEvent(GuildRoleSubscriptionPlanSetupViewModel.this, Event.SubmitSuccess.INSTANCE);
        }
    }

    /* compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel$submit$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "error");
            GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel = GuildRoleSubscriptionPlanSetupViewModel.this;
            guildRoleSubscriptionPlanSetupViewModel.updateViewState2(ViewState.copy$default(GuildRoleSubscriptionPlanSetupViewModel.access$requireViewState(guildRoleSubscriptionPlanSetupViewModel), 0, false, false, null, null, null, null, Opcodes.LUSHR, null));
            GuildRoleSubscriptionPlanSetupViewModel.access$emitEvent(GuildRoleSubscriptionPlanSetupViewModel.this, new Event.SubmitFailure(error));
        }
    }

    public /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions);
    }

    public static final /* synthetic */ void access$emitEvent(GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel, Event event) {
        guildRoleSubscriptionPlanSetupViewModel.emitEvent(event);
    }

    public static final /* synthetic */ ViewState access$requireViewState(GuildRoleSubscriptionPlanSetupViewModel guildRoleSubscriptionPlanSetupViewModel) {
        return guildRoleSubscriptionPlanSetupViewModel.requireViewState();
    }

    private final boolean computeCanProceedToNextStep(ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        int currentStep = viewState.getCurrentStep();
        if (currentStep != 0) {
            if (currentStep == 1) {
                String coverImage = viewState.getCoverImage();
                if (coverImage == null || StringsJVM.isBlank(coverImage)) {
                    return false;
                }
                String planDescription = viewState.getPlanDescription();
                if (planDescription == null || StringsJVM.isBlank(planDescription)) {
                    return false;
                }
            } else if (currentStep == 2) {
                String name = guildRoleSubscriptionTier.getName();
                if ((name == null || StringsJVM.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null) {
                    return false;
                }
                String image = guildRoleSubscriptionTier.getImage();
                if (image == null || StringsJVM.isBlank(image)) {
                    return false;
                }
            } else if (currentStep != 3 && currentStep != 4 && (currentStep != 5 || guildRoleSubscriptionTier.getMemberColor() == null)) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    public final void goToNextStep() {
        ViewState viewStateRequireViewState = requireViewState();
        updateViewState2(ViewState.copy$default(viewStateRequireViewState, viewStateRequireViewState.getCurrentStep() + 1, false, false, null, null, null, null, 126, null));
    }

    public final void goToPreviousStep() {
        updateViewState2(ViewState.copy$default(requireViewState(), r1.getCurrentStep() - 1, false, false, null, null, null, null, 126, null));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onSubscriptionPlanUpdated(String coverImage, String description, boolean isFullServerGating) {
        updateViewState2(ViewState.copy$default(requireViewState(), 0, false, false, coverImage, description, Boolean.valueOf(isFullServerGating), null, 71, null));
    }

    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState2(ViewState.copy$default(requireViewState(), 0, false, false, null, null, null, guildRoleSubscriptionTier, 63, null));
    }

    public final void submit() {
        ViewState viewStateRequireViewState = requireViewState();
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewStateRequireViewState.getGuildRoleSubscriptionTier();
        String name = guildRoleSubscriptionTier.getName();
        if ((name == null || StringsJVM.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null || guildRoleSubscriptionTier.getMemberColor() == null) {
            return;
        }
        updateViewState2(ViewState.copy$default(viewStateRequireViewState, 0, true, false, null, null, null, null, Opcodes.LUSHR, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionGroupListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, viewStateRequireViewState.getCoverImage(), viewStateRequireViewState.getPlanDescription(), viewStateRequireViewState.isFullServerGating(), guildRoleSubscriptionTier.getName(), guildRoleSubscriptionTier.getDescription(), guildRoleSubscriptionTier.getPriceTier().intValue(), guildRoleSubscriptionTier.getImage(), ColorCompat.INSTANCE.removeAlphaComponent(guildRoleSubscriptionTier.getMemberColor().intValue()), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(viewStateRequireViewState.isFullServerGating()), guildRoleSubscriptionTier.getChannelBenefits(), guildRoleSubscriptionTier.getIntangibleBenefits()), this, null, 2, null), GuildRoleSubscriptionPlanSetupViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ void updateViewState(ViewState viewState) {
        updateViewState2(viewState);
    }

    /* renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.updateViewState((GuildRoleSubscriptionPlanSetupViewModel) ViewState.copy$default(viewState, 0, false, computeCanProceedToNextStep(viewState), null, null, null, null, 123, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanSetupViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(new ViewState(0, false, false, null, null, null, null, Opcodes.LAND, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        this.guildId = j;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
    }
}
