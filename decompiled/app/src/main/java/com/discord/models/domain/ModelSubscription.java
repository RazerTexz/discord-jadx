package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelSubscription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001:\u0006]^_`abB\u008b\u0001\u0012\u0006\u00104\u001a\u00020 \u0012\u0006\u00105\u001a\u00020 \u0012\b\u00106\u001a\u0004\u0018\u00010 \u0012\u0006\u00107\u001a\u00020 \u0012\u0006\u00108\u001a\u00020 \u0012\b\u00109\u001a\u0004\u0018\u00010 \u0012\b\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010;\u001a\u0004\u0018\u00010 \u0012\b\u0010<\u001a\u0004\u0018\u00010 \u0012\b\u0010=\u001a\u0004\u0018\u00010,\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u0002000/\u0012\b\u0010?\u001a\u0004\u0018\u00010 \u0012\u0006\u0010@\u001a\u00020\u0002\u0012\u0006\u0010A\u001a\u00020\u0002¢\u0006\u0004\b[\u0010\\J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0011J\r\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u000f2\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0015j\u0002`\u00190\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u000f2\n\u0010\u001d\u001a\u00060\u0015j\u0002`\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020 HÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0012\u0010$\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b$\u0010\"J\u0010\u0010%\u001a\u00020 HÆ\u0003¢\u0006\u0004\b%\u0010\"J\u0010\u0010&\u001a\u00020 HÆ\u0003¢\u0006\u0004\b&\u0010\"J\u0012\u0010'\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b'\u0010\"J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b*\u0010\"J\u0012\u0010+\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b+\u0010\"J\u0012\u0010-\u001a\u0004\u0018\u00010,HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002000/HÆ\u0003¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b3\u0010\"J°\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u00104\u001a\u00020 2\b\b\u0002\u00105\u001a\u00020 2\n\b\u0002\u00106\u001a\u0004\u0018\u00010 2\b\b\u0002\u00107\u001a\u00020 2\b\b\u0002\u00108\u001a\u00020 2\n\b\u0002\u00109\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010,2\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u0002000/2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010@\u001a\u00020\u00022\b\b\u0002\u0010A\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020 HÖ\u0001¢\u0006\u0004\bD\u0010\"J\u0010\u0010E\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bE\u0010\u0004J\u001a\u0010H\u001a\u00020\u000f2\b\u0010G\u001a\u0004\u0018\u00010FHÖ\u0003¢\u0006\u0004\bH\u0010IR\u0019\u00108\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010J\u001a\u0004\bK\u0010\"R\u001b\u0010?\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010J\u001a\u0004\bL\u0010\"R\u001b\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010M\u001a\u0004\bN\u0010)R\u001b\u0010;\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010J\u001a\u0004\bO\u0010\"R\u0019\u00104\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010J\u001a\u0004\bP\u0010\"R\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010QR\u0019\u00105\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010J\u001a\u0004\bR\u0010\"R\u001b\u0010<\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010J\u001a\u0004\bS\u0010\"R\"\u0010>\u001a\b\u0012\u0004\u0012\u0002000/8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010T\u001a\u0004\bU\u00102R\u001b\u00106\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010J\u001a\u0004\bV\u0010\"R\u001b\u0010=\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010W\u001a\u0004\bX\u0010.R\u001b\u00109\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010J\u001a\u0004\bY\u0010\"R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010QR\u0019\u00107\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010J\u001a\u0004\bZ\u0010\"¨\u0006c"}, d2 = {"Lcom/discord/models/domain/ModelSubscription;", "Lcom/discord/models/domain/HasSubscriptionItems;", "", "component13", "()I", "component14", "Lcom/discord/models/domain/premium/SubscriptionPlanType;", "getPlanType", "()Lcom/discord/models/domain/premium/SubscriptionPlanType;", "Lcom/discord/models/domain/ModelSubscription$Status;", "getStatus", "()Lcom/discord/models/domain/ModelSubscription$Status;", "Lcom/discord/models/domain/ModelSubscription$Type;", "getType", "()Lcom/discord/models/domain/ModelSubscription$Type;", "", "isAppleSubscription", "()Z", "isGoogleSubscription", "isMobileManaged", "isNonePlan", "", "getAccountHoldEstimatedExpirationTimestamp", "()J", "", "Lcom/discord/primitives/PlanId;", "planIds", "hasAnyOfPlans", "(Ljava/util/Set;)Z", "planId", "hasPlan", "(J)Z", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "()Ljava/lang/Integer;", "component8", "component9", "Lcom/discord/models/domain/ModelSubscription$SubscriptionRenewalMutations;", "component10", "()Lcom/discord/models/domain/ModelSubscription$SubscriptionRenewalMutations;", "", "Lcom/discord/models/domain/ModelSubscription$SubscriptionItem;", "component11", "()Ljava/util/List;", "component12", ModelAuditLogEntry.CHANGE_KEY_ID, "createdAt", "canceledAt", "currentPeriodStart", "currentPeriodEnd", "paymentSourceId", "paymentGateway", "trialId", "trialEndsAt", "renewalMutations", "items", "paymentGatewayPlanId", "status", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/discord/models/domain/ModelSubscription$SubscriptionRenewalMutations;Ljava/util/List;Ljava/lang/String;II)Lcom/discord/models/domain/ModelSubscription;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCurrentPeriodEnd", "getPaymentGatewayPlanId", "Ljava/lang/Integer;", "getPaymentGateway", "getTrialId", "getId", "I", "getCreatedAt", "getTrialEndsAt", "Ljava/util/List;", "getItems", "getCanceledAt", "Lcom/discord/models/domain/ModelSubscription$SubscriptionRenewalMutations;", "getRenewalMutations", "getPaymentSourceId", "getCurrentPeriodStart", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/discord/models/domain/ModelSubscription$SubscriptionRenewalMutations;Ljava/util/List;Ljava/lang/String;II)V", "PaymentGateway", "Status", "SubscriptionAdditionalPlan", "SubscriptionItem", "SubscriptionRenewalMutations", "Type", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelSubscription extends ModelSubscription2 {
    private final String canceledAt;
    private final String createdAt;
    private final String currentPeriodEnd;
    private final String currentPeriodStart;
    private final String id;
    private final List<SubscriptionItem> items;
    private final Integer paymentGateway;
    private final String paymentGatewayPlanId;
    private final String paymentSourceId;
    private final SubscriptionRenewalMutations renewalMutations;
    private final int status;
    private final String trialEndsAt;
    private final String trialId;
    private final int type;

    /* compiled from: ModelSubscription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0019\b\u0002\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\b\u0010\tR!\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$PaymentGateway;", "", "", "Lcom/discord/primitives/PaymentGatewayId;", "intRepresentation", "Ljava/lang/Integer;", "getIntRepresentation", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "Companion", "STRIPE", "BRAINTREE", "APPLE", "GOOGLE", "UNKNOWN", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public enum PaymentGateway {
        STRIPE(1),
        BRAINTREE(2),
        APPLE(3),
        GOOGLE(4),
        UNKNOWN(null);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer intRepresentation;

        /* compiled from: ModelSubscription.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$PaymentGateway$Companion;", "", "", "Lcom/discord/primitives/PaymentGatewayId;", "paymentGatewayInt", "Lcom/discord/models/domain/ModelSubscription$PaymentGateway;", "from", "(Ljava/lang/Integer;)Lcom/discord/models/domain/ModelSubscription$PaymentGateway;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final PaymentGateway from(Integer paymentGatewayInt) {
                PaymentGateway paymentGateway;
                PaymentGateway[] paymentGatewayArrValues = PaymentGateway.values();
                int i = 0;
                while (true) {
                    if (i >= 5) {
                        paymentGateway = null;
                        break;
                    }
                    paymentGateway = paymentGatewayArrValues[i];
                    if (Intrinsics3.areEqual(paymentGateway.getIntRepresentation(), paymentGatewayInt)) {
                        break;
                    }
                    i++;
                }
                return paymentGateway != null ? paymentGateway : PaymentGateway.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        PaymentGateway(Integer num) {
            this.intRepresentation = num;
        }

        public final Integer getIntRepresentation() {
            return this.intRepresentation;
        }
    }

    /* compiled from: ModelSubscription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$Status;", "", "", "isCanceled", "()Z", "isAccountHold", "", "intRepresentation", "I", "getIntRepresentation", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "UNPAID", "ACTIVE", "PAST_DUE", "CANCELED", "ENDED", "ACCOUNT_HOLD", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public enum Status {
        UNPAID(0),
        ACTIVE(1),
        PAST_DUE(2),
        CANCELED(3),
        ENDED(4),
        ACCOUNT_HOLD(6);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int intRepresentation;

        /* compiled from: ModelSubscription.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$Status$Companion;", "", "", "statusInt", "Lcom/discord/models/domain/ModelSubscription$Status;", "from", "(I)Lcom/discord/models/domain/ModelSubscription$Status;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Status from(int statusInt) {
                Status status;
                Status[] statusArrValues = Status.values();
                int i = 0;
                while (true) {
                    if (i >= 6) {
                        status = null;
                        break;
                    }
                    status = statusArrValues[i];
                    if (status.getIntRepresentation() == statusInt) {
                        break;
                    }
                    i++;
                }
                if (status != null) {
                    return status;
                }
                throw new IllegalArgumentException(outline.q("unsupported subscription status: ", statusInt));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        Status(int i) {
            this.intRepresentation = i;
        }

        public final int getIntRepresentation() {
            return this.intRepresentation;
        }

        public final boolean isAccountHold() {
            return this == ACCOUNT_HOLD;
        }

        public final boolean isCanceled() {
            return this == CANCELED;
        }
    }

    /* compiled from: ModelSubscription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$SubscriptionAdditionalPlan;", "", "", "Lcom/discord/primitives/PlanId;", "component1", "()J", "", "component2", "()I", "planId", "quantity", "copy", "(JI)Lcom/discord/models/domain/ModelSubscription$SubscriptionAdditionalPlan;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getPlanId", "I", "getQuantity", "<init>", "(JI)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SubscriptionAdditionalPlan {
        private final long planId;
        private final int quantity;

        public SubscriptionAdditionalPlan(long j, int i) {
            this.planId = j;
            this.quantity = i;
        }

        public static /* synthetic */ SubscriptionAdditionalPlan copy$default(SubscriptionAdditionalPlan subscriptionAdditionalPlan, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = subscriptionAdditionalPlan.planId;
            }
            if ((i2 & 2) != 0) {
                i = subscriptionAdditionalPlan.quantity;
            }
            return subscriptionAdditionalPlan.copy(j, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPlanId() {
            return this.planId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        public final SubscriptionAdditionalPlan copy(long planId, int quantity) {
            return new SubscriptionAdditionalPlan(planId, quantity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionAdditionalPlan)) {
                return false;
            }
            SubscriptionAdditionalPlan subscriptionAdditionalPlan = (SubscriptionAdditionalPlan) other;
            return this.planId == subscriptionAdditionalPlan.planId && this.quantity == subscriptionAdditionalPlan.quantity;
        }

        public final long getPlanId() {
            return this.planId;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public int hashCode() {
            long j = this.planId;
            return (((int) (j ^ (j >>> 32))) * 31) + this.quantity;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SubscriptionAdditionalPlan(planId=");
            sbU.append(this.planId);
            sbU.append(", quantity=");
            return outline.B(sbU, this.quantity, ")");
        }
    }

    /* compiled from: ModelSubscription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00052\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\tJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$SubscriptionItem;", "", "", "component1", "()J", "Lcom/discord/primitives/PlanId;", "component2", "", "component3", "()I", ModelAuditLogEntry.CHANGE_KEY_ID, "planId", "quantity", "copy", "(JJI)Lcom/discord/models/domain/ModelSubscription$SubscriptionItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getPlanId", "getId", "I", "getQuantity", "<init>", "(JJI)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SubscriptionItem {
        private final long id;
        private final long planId;
        private final int quantity;

        public SubscriptionItem(long j, long j2, int i) {
            this.id = j;
            this.planId = j2;
            this.quantity = i;
        }

        public static /* synthetic */ SubscriptionItem copy$default(SubscriptionItem subscriptionItem, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = subscriptionItem.id;
            }
            long j3 = j;
            if ((i2 & 2) != 0) {
                j2 = subscriptionItem.planId;
            }
            long j4 = j2;
            if ((i2 & 4) != 0) {
                i = subscriptionItem.quantity;
            }
            return subscriptionItem.copy(j3, j4, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final long getPlanId() {
            return this.planId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        public final SubscriptionItem copy(long id2, long planId, int quantity) {
            return new SubscriptionItem(id2, planId, quantity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionItem)) {
                return false;
            }
            SubscriptionItem subscriptionItem = (SubscriptionItem) other;
            return this.id == subscriptionItem.id && this.planId == subscriptionItem.planId && this.quantity == subscriptionItem.quantity;
        }

        public final long getId() {
            return this.id;
        }

        public final long getPlanId() {
            return this.planId;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.planId;
            return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.quantity;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SubscriptionItem(id=");
            sbU.append(this.id);
            sbU.append(", planId=");
            sbU.append(this.planId);
            sbU.append(", quantity=");
            return outline.B(sbU, this.quantity, ")");
        }
    }

    /* compiled from: ModelSubscription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$SubscriptionRenewalMutations;", "Lcom/discord/models/domain/HasSubscriptionItems;", "", "Lcom/discord/models/domain/ModelSubscription$SubscriptionItem;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "items", "paymentGatewayPlanId", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/discord/models/domain/ModelSubscription$SubscriptionRenewalMutations;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPaymentGatewayPlanId", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SubscriptionRenewalMutations extends ModelSubscription2 {
        private final List<SubscriptionItem> items;
        private final String paymentGatewayPlanId;

        public SubscriptionRenewalMutations(List<SubscriptionItem> list, String str) {
            Intrinsics3.checkNotNullParameter(list, "items");
            this.items = list;
            this.paymentGatewayPlanId = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubscriptionRenewalMutations copy$default(SubscriptionRenewalMutations subscriptionRenewalMutations, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = subscriptionRenewalMutations.getItems();
            }
            if ((i & 2) != 0) {
                str = subscriptionRenewalMutations.paymentGatewayPlanId;
            }
            return subscriptionRenewalMutations.copy(list, str);
        }

        public final List<SubscriptionItem> component1() {
            return getItems();
        }

        /* renamed from: component2, reason: from getter */
        public final String getPaymentGatewayPlanId() {
            return this.paymentGatewayPlanId;
        }

        public final SubscriptionRenewalMutations copy(List<SubscriptionItem> items, String paymentGatewayPlanId) {
            Intrinsics3.checkNotNullParameter(items, "items");
            return new SubscriptionRenewalMutations(items, paymentGatewayPlanId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionRenewalMutations)) {
                return false;
            }
            SubscriptionRenewalMutations subscriptionRenewalMutations = (SubscriptionRenewalMutations) other;
            return Intrinsics3.areEqual(getItems(), subscriptionRenewalMutations.getItems()) && Intrinsics3.areEqual(this.paymentGatewayPlanId, subscriptionRenewalMutations.paymentGatewayPlanId);
        }

        @Override // com.discord.models.domain.ModelSubscription2
        public List<SubscriptionItem> getItems() {
            return this.items;
        }

        public final String getPaymentGatewayPlanId() {
            return this.paymentGatewayPlanId;
        }

        public int hashCode() {
            List<SubscriptionItem> items = getItems();
            int iHashCode = (items != null ? items.hashCode() : 0) * 31;
            String str = this.paymentGatewayPlanId;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SubscriptionRenewalMutations(items=");
            sbU.append(getItems());
            sbU.append(", paymentGatewayPlanId=");
            return outline.J(sbU, this.paymentGatewayPlanId, ")");
        }
    }

    /* compiled from: ModelSubscription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "PREMIUM", "GUILD", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        PREMIUM,
        GUILD;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: ModelSubscription.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelSubscription$Type$Companion;", "", "", "typeInt", "Lcom/discord/models/domain/ModelSubscription$Type;", "from", "(I)Lcom/discord/models/domain/ModelSubscription$Type;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Type from(int typeInt) {
                if (typeInt == 1) {
                    return Type.PREMIUM;
                }
                if (typeInt == 2) {
                    return Type.GUILD;
                }
                throw new IllegalArgumentException(outline.q("unsupported subscription type: ", typeInt));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public ModelSubscription(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, SubscriptionRenewalMutations subscriptionRenewalMutations, List<SubscriptionItem> list, String str9, int i, int i2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, "createdAt");
        Intrinsics3.checkNotNullParameter(str4, "currentPeriodStart");
        Intrinsics3.checkNotNullParameter(str5, "currentPeriodEnd");
        Intrinsics3.checkNotNullParameter(list, "items");
        this.id = str;
        this.createdAt = str2;
        this.canceledAt = str3;
        this.currentPeriodStart = str4;
        this.currentPeriodEnd = str5;
        this.paymentSourceId = str6;
        this.paymentGateway = num;
        this.trialId = str7;
        this.trialEndsAt = str8;
        this.renewalMutations = subscriptionRenewalMutations;
        this.items = list;
        this.paymentGatewayPlanId = str9;
        this.status = i;
        this.type = i2;
    }

    /* renamed from: component13, reason: from getter */
    private final int getStatus() {
        return this.status;
    }

    /* renamed from: component14, reason: from getter */
    private final int getType() {
        return this.type;
    }

    public static /* synthetic */ ModelSubscription copy$default(ModelSubscription modelSubscription, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, SubscriptionRenewalMutations subscriptionRenewalMutations, List list, String str9, int i, int i2, int i3, Object obj) {
        return modelSubscription.copy((i3 & 1) != 0 ? modelSubscription.id : str, (i3 & 2) != 0 ? modelSubscription.createdAt : str2, (i3 & 4) != 0 ? modelSubscription.canceledAt : str3, (i3 & 8) != 0 ? modelSubscription.currentPeriodStart : str4, (i3 & 16) != 0 ? modelSubscription.currentPeriodEnd : str5, (i3 & 32) != 0 ? modelSubscription.paymentSourceId : str6, (i3 & 64) != 0 ? modelSubscription.paymentGateway : num, (i3 & 128) != 0 ? modelSubscription.trialId : str7, (i3 & 256) != 0 ? modelSubscription.trialEndsAt : str8, (i3 & 512) != 0 ? modelSubscription.renewalMutations : subscriptionRenewalMutations, (i3 & 1024) != 0 ? modelSubscription.getItems() : list, (i3 & 2048) != 0 ? modelSubscription.paymentGatewayPlanId : str9, (i3 & 4096) != 0 ? modelSubscription.status : i, (i3 & 8192) != 0 ? modelSubscription.type : i2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final SubscriptionRenewalMutations getRenewalMutations() {
        return this.renewalMutations;
    }

    public final List<SubscriptionItem> component11() {
        return getItems();
    }

    /* renamed from: component12, reason: from getter */
    public final String getPaymentGatewayPlanId() {
        return this.paymentGatewayPlanId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCanceledAt() {
        return this.canceledAt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCurrentPeriodStart() {
        return this.currentPeriodStart;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCurrentPeriodEnd() {
        return this.currentPeriodEnd;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPaymentSourceId() {
        return this.paymentSourceId;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getPaymentGateway() {
        return this.paymentGateway;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTrialId() {
        return this.trialId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTrialEndsAt() {
        return this.trialEndsAt;
    }

    public final ModelSubscription copy(String id2, String createdAt, String canceledAt, String currentPeriodStart, String currentPeriodEnd, String paymentSourceId, Integer paymentGateway, String trialId, String trialEndsAt, SubscriptionRenewalMutations renewalMutations, List<SubscriptionItem> items, String paymentGatewayPlanId, int status, int type) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics3.checkNotNullParameter(currentPeriodStart, "currentPeriodStart");
        Intrinsics3.checkNotNullParameter(currentPeriodEnd, "currentPeriodEnd");
        Intrinsics3.checkNotNullParameter(items, "items");
        return new ModelSubscription(id2, createdAt, canceledAt, currentPeriodStart, currentPeriodEnd, paymentSourceId, paymentGateway, trialId, trialEndsAt, renewalMutations, items, paymentGatewayPlanId, status, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSubscription)) {
            return false;
        }
        ModelSubscription modelSubscription = (ModelSubscription) other;
        return Intrinsics3.areEqual(this.id, modelSubscription.id) && Intrinsics3.areEqual(this.createdAt, modelSubscription.createdAt) && Intrinsics3.areEqual(this.canceledAt, modelSubscription.canceledAt) && Intrinsics3.areEqual(this.currentPeriodStart, modelSubscription.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, modelSubscription.currentPeriodEnd) && Intrinsics3.areEqual(this.paymentSourceId, modelSubscription.paymentSourceId) && Intrinsics3.areEqual(this.paymentGateway, modelSubscription.paymentGateway) && Intrinsics3.areEqual(this.trialId, modelSubscription.trialId) && Intrinsics3.areEqual(this.trialEndsAt, modelSubscription.trialEndsAt) && Intrinsics3.areEqual(this.renewalMutations, modelSubscription.renewalMutations) && Intrinsics3.areEqual(getItems(), modelSubscription.getItems()) && Intrinsics3.areEqual(this.paymentGatewayPlanId, modelSubscription.paymentGatewayPlanId) && this.status == modelSubscription.status && this.type == modelSubscription.type;
    }

    public final long getAccountHoldEstimatedExpirationTimestamp() {
        return TimeUtils.addDaysToDate(this.currentPeriodEnd, 30);
    }

    public final String getCanceledAt() {
        return this.canceledAt;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getCurrentPeriodEnd() {
        return this.currentPeriodEnd;
    }

    public final String getCurrentPeriodStart() {
        return this.currentPeriodStart;
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.discord.models.domain.ModelSubscription2
    public List<SubscriptionItem> getItems() {
        return this.items;
    }

    public final Integer getPaymentGateway() {
        return this.paymentGateway;
    }

    public final String getPaymentGatewayPlanId() {
        return this.paymentGatewayPlanId;
    }

    public final String getPaymentSourceId() {
        return this.paymentSourceId;
    }

    public final SubscriptionPlanType getPlanType() {
        return SubscriptionPlanType.INSTANCE.from(getPremiumBasePlanId());
    }

    public final SubscriptionRenewalMutations getRenewalMutations() {
        return this.renewalMutations;
    }

    public final Status getStatus() {
        return Status.INSTANCE.from(this.status);
    }

    public final String getTrialEndsAt() {
        return this.trialEndsAt;
    }

    public final String getTrialId() {
        return this.trialId;
    }

    public final Type getType() {
        return Type.INSTANCE.from(this.type);
    }

    public final boolean hasAnyOfPlans(Set<Long> planIds) {
        Intrinsics3.checkNotNullParameter(planIds, "planIds");
        List<SubscriptionItem> items = getItems();
        if ((items instanceof Collection) && items.isEmpty()) {
            return false;
        }
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            if (planIds.contains(Long.valueOf(((SubscriptionItem) it.next()).getPlanId()))) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasPlan(long planId) {
        List<SubscriptionItem> items = getItems();
        if (!(items instanceof Collection) || !items.isEmpty()) {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                if (((SubscriptionItem) it.next()).getPlanId() == planId) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.createdAt;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.canceledAt;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.currentPeriodStart;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.currentPeriodEnd;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.paymentSourceId;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num = this.paymentGateway;
        int iHashCode7 = (iHashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        String str7 = this.trialId;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.trialEndsAt;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        SubscriptionRenewalMutations subscriptionRenewalMutations = this.renewalMutations;
        int iHashCode10 = (iHashCode9 + (subscriptionRenewalMutations != null ? subscriptionRenewalMutations.hashCode() : 0)) * 31;
        List<SubscriptionItem> items = getItems();
        int iHashCode11 = (iHashCode10 + (items != null ? items.hashCode() : 0)) * 31;
        String str9 = this.paymentGatewayPlanId;
        return ((((iHashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.status) * 31) + this.type;
    }

    public final boolean isAppleSubscription() {
        return PaymentGateway.INSTANCE.from(this.paymentGateway) == PaymentGateway.APPLE;
    }

    public final boolean isGoogleSubscription() {
        return PaymentGateway.INSTANCE.from(this.paymentGateway) == PaymentGateway.GOOGLE;
    }

    public final boolean isMobileManaged() {
        return isAppleSubscription() || isGoogleSubscription();
    }

    public final boolean isNonePlan() {
        return getPlanType() == SubscriptionPlanType.NONE_MONTH || getPlanType() == SubscriptionPlanType.NONE_YEAR || getPlanType() == SubscriptionPlanType.NONE_3_MONTH || getPlanType() == SubscriptionPlanType.NONE_6_MONTH;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSubscription(id=");
        sbU.append(this.id);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", canceledAt=");
        sbU.append(this.canceledAt);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        sbU.append(this.currentPeriodEnd);
        sbU.append(", paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", trialId=");
        sbU.append(this.trialId);
        sbU.append(", trialEndsAt=");
        sbU.append(this.trialEndsAt);
        sbU.append(", renewalMutations=");
        sbU.append(this.renewalMutations);
        sbU.append(", items=");
        sbU.append(getItems());
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", type=");
        return outline.B(sbU, this.type, ")");
    }
}
