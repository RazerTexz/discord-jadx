package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.annotation.DrawableRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B%\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0013\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R:\u0010$\u001a&\u0012\f\u0012\n #*\u0004\u0018\u00010\u00040\u0004 #*\u0012\u0012\f\u0012\n #*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u00060"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;", "Lrx/Observable;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/models/domain/emoji/Emoji;", "emoji", "", "updateEmoji", "(Lcom/discord/models/domain/emoji/Emoji;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "channelName", "", "channelIconResId", "updateChannel", "(JLjava/lang/String;Ljava/lang/Integer;)V", ModelAuditLogEntry.CHANGE_KEY_NAME, "updateName", "(Ljava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "updateDescription", "viewState", "updateViewState", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;)V", "submitResult", "()V", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "benefitType", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "tierName", "Ljava/lang/String;", "getTierName", "()Ljava/lang/String;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "benefit", "<init>", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;Ljava/lang/String;Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;)V", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitViewModel extends AppViewModel<ViewState> {
    private final GuildRoleSubscriptionBenefitType benefitType;
    private final PublishSubject<Event> eventSubject;
    private final String tierName;

    /* compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event;", "", "<init>", "()V", "SendResult", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "component1", "()Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "benefit", "copy", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "getBenefit", "<init>", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SendResult extends Event {
            private final Benefit benefit;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendResult(Benefit benefit) {
                super(null);
                Intrinsics3.checkNotNullParameter(benefit, "benefit");
                this.benefit = benefit;
            }

            public static /* synthetic */ SendResult copy$default(SendResult sendResult, Benefit benefit, int i, Object obj) {
                if ((i & 1) != 0) {
                    benefit = sendResult.benefit;
                }
                return sendResult.copy(benefit);
            }

            /* renamed from: component1, reason: from getter */
            public final Benefit getBenefit() {
                return this.benefit;
            }

            public final SendResult copy(Benefit benefit) {
                Intrinsics3.checkNotNullParameter(benefit, "benefit");
                return new SendResult(benefit);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SendResult) && Intrinsics3.areEqual(this.benefit, ((SendResult) other).benefit);
                }
                return true;
            }

            public final Benefit getBenefit() {
                return this.benefit;
            }

            public int hashCode() {
                Benefit benefit = this.benefit;
                if (benefit != null) {
                    return benefit.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SendResult(benefit=");
                sbU.append(this.benefit);
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

    /* compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0018\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jh\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\u0007R!\u0010\u001a\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b)\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u000bR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b,\u0010\u0007R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010\u000e¨\u00061"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/lang/Integer;", "Lcom/discord/models/domain/emoji/Emoji;", "component5", "()Lcom/discord/models/domain/emoji/Emoji;", "component6", "", "Lcom/discord/primitives/ChannelId;", "component7", "()Ljava/lang/Long;", "canSubmitResult", ModelAuditLogEntry.CHANGE_KEY_NAME, "tierName", "leadingNameIconResId", "emoji", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "channelId", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTierName", "Ljava/lang/Long;", "getChannelId", "Z", "getCanSubmitResult", "getName", "Ljava/lang/Integer;", "getLeadingNameIconResId", "getDescription", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean canSubmitResult;
        private final Long channelId;
        private final String description;
        private final Emoji emoji;
        private final Integer leadingNameIconResId;
        private final String name;
        private final String tierName;

        public ViewState() {
            this(false, null, null, null, null, null, null, Opcodes.LAND, null);
        }

        public ViewState(boolean z2, String str, String str2, @DrawableRes Integer num, Emoji emoji, String str3, Long l) {
            this.canSubmitResult = z2;
            this.name = str;
            this.tierName = str2;
            this.leadingNameIconResId = num;
            this.emoji = emoji;
            this.description = str3;
            this.channelId = l;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, String str, String str2, Integer num, Emoji emoji, String str3, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.canSubmitResult;
            }
            if ((i & 2) != 0) {
                str = viewState.name;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = viewState.tierName;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                num = viewState.leadingNameIconResId;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                emoji = viewState.emoji;
            }
            Emoji emoji2 = emoji;
            if ((i & 32) != 0) {
                str3 = viewState.description;
            }
            String str6 = str3;
            if ((i & 64) != 0) {
                l = viewState.channelId;
            }
            return viewState.copy(z2, str4, str5, num2, emoji2, str6, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCanSubmitResult() {
            return this.canSubmitResult;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getLeadingNameIconResId() {
            return this.leadingNameIconResId;
        }

        /* renamed from: component5, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* renamed from: component6, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component7, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        public final ViewState copy(boolean canSubmitResult, String name, String tierName, @DrawableRes Integer leadingNameIconResId, Emoji emoji, String description, Long channelId) {
            return new ViewState(canSubmitResult, name, tierName, leadingNameIconResId, emoji, description, channelId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.canSubmitResult == viewState.canSubmitResult && Intrinsics3.areEqual(this.name, viewState.name) && Intrinsics3.areEqual(this.tierName, viewState.tierName) && Intrinsics3.areEqual(this.leadingNameIconResId, viewState.leadingNameIconResId) && Intrinsics3.areEqual(this.emoji, viewState.emoji) && Intrinsics3.areEqual(this.description, viewState.description) && Intrinsics3.areEqual(this.channelId, viewState.channelId);
        }

        public final boolean getCanSubmitResult() {
            return this.canSubmitResult;
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final Integer getLeadingNameIconResId() {
            return this.leadingNameIconResId;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTierName() {
            return this.tierName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        public int hashCode() {
            boolean z2 = this.canSubmitResult;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            String str = this.name;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.tierName;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.leadingNameIconResId;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            Emoji emoji = this.emoji;
            int iHashCode4 = (iHashCode3 + (emoji != null ? emoji.hashCode() : 0)) * 31;
            String str3 = this.description;
            int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Long l = this.channelId;
            return iHashCode5 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(canSubmitResult=");
            sbU.append(this.canSubmitResult);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", tierName=");
            sbU.append(this.tierName);
            sbU.append(", leadingNameIconResId=");
            sbU.append(this.leadingNameIconResId);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", channelId=");
            return outline.G(sbU, this.channelId, ")");
        }

        public /* synthetic */ ViewState(boolean z2, String str, String str2, Integer num, Emoji emoji, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : emoji, (i & 32) != 0 ? null : str3, (i & 64) == 0 ? l : null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = GuildRoleSubscriptionBenefitType.CHANNEL;
            iArr[guildRoleSubscriptionBenefitType.ordinal()] = 1;
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType2 = GuildRoleSubscriptionBenefitType.INTANGIBLE;
            iArr[guildRoleSubscriptionBenefitType2.ordinal()] = 2;
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildRoleSubscriptionBenefitType.ordinal()] = 1;
            iArr2[guildRoleSubscriptionBenefitType2.ordinal()] = 2;
        }
    }

    public /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildRoleSubscriptionBenefitType, str, (i & 4) != 0 ? null : benefit);
    }

    public final String getTierName() {
        return this.tierName;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void submitResult() {
        Benefit channelBenefit;
        Benefit benefit;
        ViewState viewStateRequireViewState = requireViewState();
        int iOrdinal = this.benefitType.ordinal();
        if (iOrdinal == 1) {
            String name = viewStateRequireViewState.getName();
            if (name == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Emoji emoji = viewStateRequireViewState.getEmoji();
            if (emoji == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String description = viewStateRequireViewState.getDescription();
            Integer leadingNameIconResId = viewStateRequireViewState.getLeadingNameIconResId();
            Long channelId = viewStateRequireViewState.getChannelId();
            if (channelId == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            channelBenefit = new Benefit.ChannelBenefit(name, emoji, description, leadingNameIconResId, channelId.longValue());
        } else {
            if (iOrdinal != 2) {
                benefit = null;
                if (benefit == null) {
                    PublishSubject<Event> publishSubject = this.eventSubject;
                    publishSubject.k.onNext(new Event.SendResult(benefit));
                    return;
                }
                return;
            }
            String name2 = viewStateRequireViewState.getName();
            if (name2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Emoji emoji2 = viewStateRequireViewState.getEmoji();
            if (emoji2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            channelBenefit = new Benefit.IntangibleBenefit(name2, emoji2, viewStateRequireViewState.getDescription());
        }
        benefit = channelBenefit;
        if (benefit == null) {
        }
    }

    public final void updateChannel(long channelId, String channelName, Integer channelIconResId) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        updateViewState2(ViewState.copy$default(requireViewState(), false, channelName, null, channelIconResId, null, null, Long.valueOf(channelId), 53, null));
    }

    public final void updateDescription(String description) {
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        updateViewState2(ViewState.copy$default(requireViewState(), false, null, null, null, null, description, null, 95, null));
    }

    public final void updateEmoji(Emoji emoji) {
        updateViewState2(ViewState.copy$default(requireViewState(), false, null, null, null, emoji, null, null, 111, null));
    }

    public final void updateName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        updateViewState2(ViewState.copy$default(requireViewState(), false, name, null, null, null, null, null, Opcodes.LUSHR, null));
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ void updateViewState(ViewState viewState) {
        updateViewState2(viewState);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionTierBenefitViewModel(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "benefitType");
        boolean z2 = benefit != null;
        String name = benefit != null ? benefit.getName() : null;
        boolean z3 = benefit instanceof Benefit.ChannelBenefit;
        Benefit.ChannelBenefit channelBenefit = (Benefit.ChannelBenefit) (!z3 ? null : benefit);
        Long lValueOf = channelBenefit != null ? Long.valueOf(channelBenefit.getChannelId()) : null;
        Benefit.ChannelBenefit channelBenefit2 = (Benefit.ChannelBenefit) (!z3 ? null : benefit);
        super(new ViewState(z2, name, str, channelBenefit2 != null ? channelBenefit2.getChannelIconResId() : null, benefit != null ? benefit.getEmoji() : null, benefit != null ? benefit.getDescription() : null, lValueOf));
        this.benefitType = guildRoleSubscriptionBenefitType;
        this.tierName = str;
        this.eventSubject = PublishSubject.k0();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* renamed from: updateViewState, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateViewState2(ViewState viewState) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        int iOrdinal = this.benefitType.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                String name = viewState.getName();
                if (!(name == null || StringsJVM.isBlank(name)) && viewState.getEmoji() != null) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            String name2 = viewState.getName();
            if ((name2 == null || StringsJVM.isBlank(name2)) || viewState.getEmoji() == null || viewState.getChannelId() == null) {
                z2 = false;
            }
        }
        super.updateViewState((GuildRoleSubscriptionTierBenefitViewModel) ViewState.copy$default(viewState, z2, null, null, null, null, null, null, 126, null));
    }
}
