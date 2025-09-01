package com.discord.widgets.settings.premium;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.premium.ClaimStatus;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: ClaimOutboundPromoViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00032\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0005R:\u0010\u0015\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\f0\f \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\f0\f\u0018\u00010\u00130\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;", "", "handleClaimStatus", "()V", "", "Lcom/discord/primitives/PromoId;", "promoId", "claimPromo", "(J)V", "Lrx/Observable;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "observeEvents", "()Lrx/Observable;", "copyClicked", "redeemClicked", "maybeLaterClicked", "failureCloseClicked", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreOutboundPromotions;", "storeOutboundPromotions", "Lcom/discord/stores/StoreOutboundPromotions;", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "claimStatus", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "<init>", "(Lcom/discord/widgets/settings/premium/ClaimStatus;Lcom/discord/stores/StoreOutboundPromotions;)V", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ClaimOutboundPromoViewModel extends AppViewModel<ViewState> {
    private ClaimStatus claimStatus;
    private final PublishSubject<Event> eventSubject;
    private final StoreOutboundPromotions storeOutboundPromotions;

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "", "<init>", "()V", "Claimed", "CopyCode", "Dismiss", "OpenRedemptionUrl", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$Claimed;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$CopyCode;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$Dismiss;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$Claimed;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "component1", "()Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "claimedStatus", "copy", "(Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;)Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$Claimed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "getClaimedStatus", "<init>", "(Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Claimed extends Event {
            private final ClaimStatus.Claimed claimedStatus;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Claimed(ClaimStatus.Claimed claimed) {
                super(null);
                Intrinsics3.checkNotNullParameter(claimed, "claimedStatus");
                this.claimedStatus = claimed;
            }

            public static /* synthetic */ Claimed copy$default(Claimed claimed, ClaimStatus.Claimed claimed2, int i, Object obj) {
                if ((i & 1) != 0) {
                    claimed2 = claimed.claimedStatus;
                }
                return claimed.copy(claimed2);
            }

            /* renamed from: component1, reason: from getter */
            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public final Claimed copy(ClaimStatus.Claimed claimedStatus) {
                Intrinsics3.checkNotNullParameter(claimedStatus, "claimedStatus");
                return new Claimed(claimedStatus);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Claimed) && Intrinsics3.areEqual(this.claimedStatus, ((Claimed) other).claimedStatus);
                }
                return true;
            }

            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public int hashCode() {
                ClaimStatus.Claimed claimed = this.claimedStatus;
                if (claimed != null) {
                    return claimed.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Claimed(claimedStatus=");
                sbU.append(this.claimedStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$CopyCode;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "", "component1", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_CODE, "copy", "(Ljava/lang/String;)Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$CopyCode;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CopyCode extends Event {
            private final String code;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyCode(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
                this.code = str;
            }

            public static /* synthetic */ CopyCode copy$default(CopyCode copyCode, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = copyCode.code;
                }
                return copyCode.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCode() {
                return this.code;
            }

            public final CopyCode copy(String code) {
                Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
                return new CopyCode(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CopyCode) && Intrinsics3.areEqual(this.code, ((CopyCode) other).code);
                }
                return true;
            }

            public final String getCode() {
                return this.code;
            }

            public int hashCode() {
                String str = this.code;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("CopyCode(code="), this.code, ")");
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$Dismiss;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "", "component1", "()Ljava/lang/String;", "url", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class OpenRedemptionUrl extends Event {
            private final String url;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenRedemptionUrl(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "url");
                this.url = str;
            }

            public static /* synthetic */ OpenRedemptionUrl copy$default(OpenRedemptionUrl openRedemptionUrl, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = openRedemptionUrl.url;
                }
                return openRedemptionUrl.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final OpenRedemptionUrl copy(String url) {
                Intrinsics3.checkNotNullParameter(url, "url");
                return new OpenRedemptionUrl(url);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof OpenRedemptionUrl) && Intrinsics3.areEqual(this.url, ((OpenRedemptionUrl) other).url);
                }
                return true;
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                String str = this.url;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("OpenRedemptionUrl(url="), this.url, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;", "", "<init>", "()V", "ClaimFailed", "ClaimInProgress", "Claimed", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState$ClaimInProgress;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState$Claimed;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState$ClaimFailed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState$ClaimFailed;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ClaimFailed extends ViewState {
            public static final ClaimFailed INSTANCE = new ClaimFailed();

            private ClaimFailed() {
                super(null);
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState$ClaimInProgress;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ClaimInProgress extends ViewState {
            public static final ClaimInProgress INSTANCE = new ClaimInProgress();

            private ClaimInProgress() {
                super(null);
            }
        }

        /* compiled from: ClaimOutboundPromoViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState$Claimed;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;", "Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "component1", "()Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "claimedStatus", "copy", "(Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;)Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState$Claimed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "getClaimedStatus", "<init>", "(Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Claimed extends ViewState {
            private final ClaimStatus.Claimed claimedStatus;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Claimed(ClaimStatus.Claimed claimed) {
                super(null);
                Intrinsics3.checkNotNullParameter(claimed, "claimedStatus");
                this.claimedStatus = claimed;
            }

            public static /* synthetic */ Claimed copy$default(Claimed claimed, ClaimStatus.Claimed claimed2, int i, Object obj) {
                if ((i & 1) != 0) {
                    claimed2 = claimed.claimedStatus;
                }
                return claimed.copy(claimed2);
            }

            /* renamed from: component1, reason: from getter */
            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public final Claimed copy(ClaimStatus.Claimed claimedStatus) {
                Intrinsics3.checkNotNullParameter(claimedStatus, "claimedStatus");
                return new Claimed(claimedStatus);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Claimed) && Intrinsics3.areEqual(this.claimedStatus, ((Claimed) other).claimedStatus);
                }
                return true;
            }

            public final ClaimStatus.Claimed getClaimedStatus() {
                return this.claimedStatus;
            }

            public int hashCode() {
                ClaimStatus.Claimed claimed = this.claimedStatus;
                if (claimed != null) {
                    return claimed.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Claimed(claimedStatus=");
                sbU.append(this.claimedStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/premium/ClaimedOutboundPromotion;", "claimedPromo", "", "invoke", "(Lcom/discord/api/premium/ClaimedOutboundPromotion;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel$claimPromo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ClaimedOutboundPromotion, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimedOutboundPromotion claimedOutboundPromotion) {
            invoke2(claimedOutboundPromotion);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimedOutboundPromotion claimedOutboundPromotion) {
            Intrinsics3.checkNotNullParameter(claimedOutboundPromotion, "claimedPromo");
            ClaimOutboundPromoViewModel claimOutboundPromoViewModel = ClaimOutboundPromoViewModel.this;
            ClaimStatus.Claimed claimed = new ClaimStatus.Claimed(claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getCode(), claimedOutboundPromotion.getPromotion().getOutboundRedemptionModalBody(), claimedOutboundPromotion.d(), claimedOutboundPromotion.c());
            ClaimOutboundPromoViewModel.access$updateViewState(ClaimOutboundPromoViewModel.this, new ViewState.Claimed(claimed));
            PublishSubject publishSubjectAccess$getEventSubject$p = ClaimOutboundPromoViewModel.access$getEventSubject$p(ClaimOutboundPromoViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.Claimed(claimed));
            ClaimOutboundPromoViewModel.access$setClaimStatus$p(claimOutboundPromoViewModel, claimed);
        }
    }

    /* compiled from: ClaimOutboundPromoViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel$claimPromo$2, reason: invalid class name */
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
            ClaimOutboundPromoViewModel.access$updateViewState(ClaimOutboundPromoViewModel.this, ViewState.ClaimFailed.INSTANCE);
        }
    }

    public /* synthetic */ ClaimOutboundPromoViewModel(ClaimStatus claimStatus, StoreOutboundPromotions storeOutboundPromotions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(claimStatus, (i & 2) != 0 ? StoreStream.INSTANCE.getOutboundPromotions() : storeOutboundPromotions);
    }

    public static final /* synthetic */ ClaimStatus access$getClaimStatus$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        return claimOutboundPromoViewModel.claimStatus;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        return claimOutboundPromoViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$setClaimStatus$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel, ClaimStatus claimStatus) {
        claimOutboundPromoViewModel.claimStatus = claimStatus;
    }

    public static final /* synthetic */ void access$updateViewState(ClaimOutboundPromoViewModel claimOutboundPromoViewModel, ViewState viewState) {
        claimOutboundPromoViewModel.updateViewState(viewState);
    }

    private final void claimPromo(long promoId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeOutboundPromotions.claimOutboundPromotion(promoId), false, 1, null), this, null, 2, null), ClaimOutboundPromoViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    private final void handleClaimStatus() {
        ClaimStatus claimStatus = this.claimStatus;
        if (claimStatus instanceof ClaimStatus.Claimed) {
            updateViewState(new ViewState.Claimed((ClaimStatus.Claimed) claimStatus));
        } else if (claimStatus instanceof ClaimStatus.Unclaimed) {
            claimPromo(((ClaimStatus.Unclaimed) claimStatus).getPromoId());
        }
    }

    @MainThread
    public final void copyClicked() {
        ClaimStatus claimStatus = this.claimStatus;
        if (!(claimStatus instanceof ClaimStatus.Claimed)) {
            claimStatus = null;
        }
        ClaimStatus.Claimed claimed = (ClaimStatus.Claimed) claimStatus;
        if (claimed != null) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new Event.CopyCode(claimed.getCode()));
        }
    }

    @MainThread
    public final void failureCloseClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    @MainThread
    public final void maybeLaterClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void redeemClicked() {
        ClaimStatus claimStatus = this.claimStatus;
        if (!(claimStatus instanceof ClaimStatus.Claimed)) {
            claimStatus = null;
        }
        ClaimStatus.Claimed claimed = (ClaimStatus.Claimed) claimStatus;
        if (claimed != null) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new Event.OpenRedemptionUrl(claimed.getLink()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel(ClaimStatus claimStatus, StoreOutboundPromotions storeOutboundPromotions) {
        super(ViewState.ClaimInProgress.INSTANCE);
        Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
        Intrinsics3.checkNotNullParameter(storeOutboundPromotions, "storeOutboundPromotions");
        this.claimStatus = claimStatus;
        this.storeOutboundPromotions = storeOutboundPromotions;
        this.eventSubject = PublishSubject.k0();
        handleClaimStatus();
    }
}
