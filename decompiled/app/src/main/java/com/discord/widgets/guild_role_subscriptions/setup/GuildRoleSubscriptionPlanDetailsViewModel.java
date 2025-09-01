package com.discord.widgets.guild_role_subscriptions.setup;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildRoleSubscriptionPlanDetailsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel$ViewState;", "", "coverImage", "", "updateCoverImage", "(Ljava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "updateDescription", "", "isFullServerGate", "updateFullServerGate", "(Z)V", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "subscriptionGroupListing", "fullServerGatingOverwrite", "setGroupPlanDetails", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/lang/Boolean;)V", "<init>", "()V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanDetailsViewModel extends AppViewModel<ViewState> {

    /* compiled from: GuildRoleSubscriptionPlanDetailsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJP\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR!\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\u0012\u0010\rR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel$ViewState;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ApplicationId;", "component2", "()Ljava/lang/Long;", "component3", "component4", "", "component5", "()Z", "coverImage", "applicationId", "coverImageAssetId", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "isFullServerGate", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Z)Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel$ViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getApplicationId", "Ljava/lang/String;", "getDescription", "getCoverImage", "Z", "getCoverImageAssetId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final Long applicationId;
        private final String coverImage;
        private final Long coverImageAssetId;
        private final String description;
        private final boolean isFullServerGate;

        public ViewState() {
            this(null, null, null, null, false, 31, null);
        }

        public ViewState(String str, Long l, Long l2, String str2, boolean z2) {
            this.coverImage = str;
            this.applicationId = l;
            this.coverImageAssetId = l2;
            this.description = str2;
            this.isFullServerGate = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, Long l, Long l2, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewState.coverImage;
            }
            if ((i & 2) != 0) {
                l = viewState.applicationId;
            }
            Long l3 = l;
            if ((i & 4) != 0) {
                l2 = viewState.coverImageAssetId;
            }
            Long l4 = l2;
            if ((i & 8) != 0) {
                str2 = viewState.description;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                z2 = viewState.isFullServerGate;
            }
            return viewState.copy(str, l3, l4, str3, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getCoverImageAssetId() {
            return this.coverImageAssetId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsFullServerGate() {
            return this.isFullServerGate;
        }

        public final ViewState copy(String coverImage, Long applicationId, Long coverImageAssetId, String description, boolean isFullServerGate) {
            return new ViewState(coverImage, applicationId, coverImageAssetId, description, isFullServerGate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.coverImage, viewState.coverImage) && Intrinsics3.areEqual(this.applicationId, viewState.applicationId) && Intrinsics3.areEqual(this.coverImageAssetId, viewState.coverImageAssetId) && Intrinsics3.areEqual(this.description, viewState.description) && this.isFullServerGate == viewState.isFullServerGate;
        }

        public final Long getApplicationId() {
            return this.applicationId;
        }

        public final String getCoverImage() {
            return this.coverImage;
        }

        public final Long getCoverImageAssetId() {
            return this.coverImageAssetId;
        }

        public final String getDescription() {
            return this.description;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.coverImage;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Long l = this.applicationId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.coverImageAssetId;
            int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str2 = this.description;
            int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.isFullServerGate;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode4 + i;
        }

        public final boolean isFullServerGate() {
            return this.isFullServerGate;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(coverImage=");
            sbU.append(this.coverImage);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", coverImageAssetId=");
            sbU.append(this.coverImageAssetId);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", isFullServerGate=");
            return outline.O(sbU, this.isFullServerGate, ")");
        }

        public /* synthetic */ ViewState(String str, Long l, Long l2, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) == 0 ? str2 : null, (i & 16) != 0 ? false : z2);
        }
    }

    public GuildRoleSubscriptionPlanDetailsViewModel() {
        super(new ViewState(null, null, null, null, false, 31, null));
    }

    public final void setGroupPlanDetails(GuildRoleSubscriptionGroupListing subscriptionGroupListing, Boolean fullServerGatingOverwrite) {
        Intrinsics3.checkNotNullParameter(subscriptionGroupListing, "subscriptionGroupListing");
        Long lValueOf = Long.valueOf(subscriptionGroupListing.getApplicationId());
        ImageAsset imageAsset = subscriptionGroupListing.getImageAsset();
        updateViewState(new ViewState(null, lValueOf, imageAsset != null ? Long.valueOf(imageAsset.getId()) : null, subscriptionGroupListing.getDescription(), fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : subscriptionGroupListing.getFullServerGate(), 1, null));
    }

    public final void updateCoverImage(String coverImage) {
        updateViewState(ViewState.copy$default(requireViewState(), coverImage, null, null, null, false, 30, null));
    }

    public final void updateDescription(String description) {
        updateViewState(ViewState.copy$default(requireViewState(), null, null, null, description, false, 23, null));
    }

    public final void updateFullServerGate(boolean isFullServerGate) {
        updateViewState(ViewState.copy$default(requireViewState(), null, null, null, null, isFullServerGate, 15, null));
    }
}
