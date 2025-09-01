package com.discord.widgets.contact_sync;

import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ContactSyncFlowAnalytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/contact_sync/ContactSyncFlowAnalytics;", "", "", "toStep", "", "skip", "back", "", "additionalProps", "", "trackFlowStep", "(Ljava/lang/String;ZZLjava/util/Map;)V", "trackEnd", "(ZLjava/util/Map;)V", "", "Lcom/discord/utilities/time/ClockMilliseconds;", "lastStepTimestamp", "J", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "lastStep", "Ljava/lang/String;", "isOnboarding", "Z", "()Z", "<init>", "(ZLcom/discord/utilities/time/Clock;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ContactSyncFlowAnalytics {
    private static final String CONTACT_SYNC_FLOW_KEY = "Contact Sync";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private final boolean isOnboarding;
    private String lastStep;
    private long lastStepTimestamp;

    /* compiled from: ContactSyncFlowAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/contact_sync/ContactSyncFlowAnalytics$Companion;", "", "", "isOnboarding", "", "", "additionalProps", "", "trackStart", "(ZLjava/util/Map;)V", "CONTACT_SYNC_FLOW_KEY", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void trackStart$default(Companion companion, boolean z2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            companion.trackStart(z2, map);
        }

        public final void trackStart(boolean isOnboarding, Map<String, ? extends Object> additionalProps) {
            Map<String, ? extends Object> mutableMap = Maps6.toMutableMap(additionalProps != null ? additionalProps : Maps6.emptyMap());
            mutableMap.put("has_phone_number", Boolean.valueOf(StoreStream.INSTANCE.getUsers().getMeSnapshot().getPhoneNumber() != null));
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            analyticsTracker.relationshipSyncFlow(ContactSyncFlowAnalytics.CONTACT_SYNC_FLOW_KEY, "Flow Initialized", "Landing", 0, false, false, mutableMap);
            if (isOnboarding) {
                AnalyticsTracker.newUserOnboarding$default(analyticsTracker, ContactSyncFlowAnalytics.CONTACT_SYNC_FLOW_KEY, "Flow Initialized", "Landing", null, false, 24, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ContactSyncFlowAnalytics() {
        this(false, null, 3, null);
    }

    public ContactSyncFlowAnalytics(boolean z2, Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.isOnboarding = z2;
        this.clock = clock;
        this.lastStepTimestamp = clock.currentTimeMillis();
        this.lastStep = "Landing";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackEnd$default(ContactSyncFlowAnalytics contactSyncFlowAnalytics, boolean z2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        contactSyncFlowAnalytics.trackEnd(z2, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackFlowStep$default(ContactSyncFlowAnalytics contactSyncFlowAnalytics, String str, boolean z2, boolean z3, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        contactSyncFlowAnalytics.trackFlowStep(str, z2, z3, map);
    }

    public final Clock getClock() {
        return this.clock;
    }

    /* renamed from: isOnboarding, reason: from getter */
    public final boolean getIsOnboarding() {
        return this.isOnboarding;
    }

    public final void trackEnd(boolean skip, Map<String, ? extends Object> additionalProps) {
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.relationshipSyncFlow(CONTACT_SYNC_FLOW_KEY, this.lastStep, "Complete", (int) ((jCurrentTimeMillis - this.lastStepTimestamp) / 1000), skip, false, additionalProps);
        if (this.isOnboarding) {
            analyticsTracker.newUserOnboarding(CONTACT_SYNC_FLOW_KEY, this.lastStep, "Complete", Long.valueOf(this.lastStepTimestamp), skip);
        }
    }

    public final void trackFlowStep(String toStep, boolean skip, boolean back, Map<String, ? extends Object> additionalProps) {
        Intrinsics3.checkNotNullParameter(toStep, "toStep");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.relationshipSyncFlow(CONTACT_SYNC_FLOW_KEY, this.lastStep, toStep, (int) ((jCurrentTimeMillis - this.lastStepTimestamp) / 1000), skip, back, additionalProps);
        if (this.isOnboarding) {
            analyticsTracker.newUserOnboarding(CONTACT_SYNC_FLOW_KEY, this.lastStep, toStep, Long.valueOf(this.lastStepTimestamp), skip);
        }
        this.lastStepTimestamp = jCurrentTimeMillis;
        this.lastStep = toStep;
    }

    public /* synthetic */ ContactSyncFlowAnalytics(boolean z2, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? ClockFactory.get() : clock);
    }
}
