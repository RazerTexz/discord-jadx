package com.discord.api.guildrolesubscription;

import androidx.core.os.EnvironmentCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PayoutGroupType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/api/guildrolesubscription/PayoutGroupType;", "", "", "apiValue", "Ljava/lang/String;", "getApiValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "UNKNOWN", "MARKETPLACE", "STAGE_EVENT_SKU", "SERVER_ROLE_SUBSCRIPTION", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum PayoutGroupType {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    MARKETPLACE("marketplace"),
    STAGE_EVENT_SKU("stage_event_sku"),
    SERVER_ROLE_SUBSCRIPTION("server_role_subscription");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String apiValue;

    /* compiled from: PayoutGroupType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/guildrolesubscription/PayoutGroupType$Companion;", "", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    PayoutGroupType(String str) {
        this.apiValue = str;
    }

    public final String getApiValue() {
        return this.apiValue;
    }
}
