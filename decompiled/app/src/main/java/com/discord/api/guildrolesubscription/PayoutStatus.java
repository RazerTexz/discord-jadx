package com.discord.api.guildrolesubscription;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PayoutStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/api/guildrolesubscription/PayoutStatus;", "", "", "apiValue", "I", "getApiValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "UNKNOWN", "OPEN", "PAID", "PENDING", "MANUAL", "CANCELED", "DEFERRED", "DEFERRED_INTERNAL", "PROCESSING", "ERROR", "REJECTED", "RISK_REVIEW", "SUBMITTED", "PENDING_FUNDS", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum PayoutStatus {
    UNKNOWN(0),
    OPEN(1),
    PAID(2),
    PENDING(3),
    MANUAL(4),
    CANCELED(5),
    DEFERRED(6),
    DEFERRED_INTERNAL(7),
    PROCESSING(8),
    ERROR(9),
    REJECTED(10),
    RISK_REVIEW(11),
    SUBMITTED(12),
    PENDING_FUNDS(13);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: PayoutStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/guildrolesubscription/PayoutStatus$Companion;", "", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    PayoutStatus(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
