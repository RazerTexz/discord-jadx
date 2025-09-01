package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubWaitlistViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/hubs/HubWaitlistState;", "", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/WaitlistSignup;", "component1", "()Lcom/discord/stores/utilities/RestCallState;", "waitlistAsync", "copy", "(Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/HubWaitlistState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/utilities/RestCallState;", "getWaitlistAsync", "<init>", "(Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubWaitlistState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubWaitlistViewModel3 {
    private final RestCallState<WaitlistSignup> waitlistAsync;

    public WidgetHubWaitlistViewModel3() {
        this(null, 1, null);
    }

    public WidgetHubWaitlistViewModel3(RestCallState<WaitlistSignup> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "waitlistAsync");
        this.waitlistAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubWaitlistViewModel3 copy$default(WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = widgetHubWaitlistViewModel3.waitlistAsync;
        }
        return widgetHubWaitlistViewModel3.copy(restCallState);
    }

    public final RestCallState<WaitlistSignup> component1() {
        return this.waitlistAsync;
    }

    public final WidgetHubWaitlistViewModel3 copy(RestCallState<WaitlistSignup> waitlistAsync) {
        Intrinsics3.checkNotNullParameter(waitlistAsync, "waitlistAsync");
        return new WidgetHubWaitlistViewModel3(waitlistAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubWaitlistViewModel3) && Intrinsics3.areEqual(this.waitlistAsync, ((WidgetHubWaitlistViewModel3) other).waitlistAsync);
        }
        return true;
    }

    public final RestCallState<WaitlistSignup> getWaitlistAsync() {
        return this.waitlistAsync;
    }

    public int hashCode() {
        RestCallState<WaitlistSignup> restCallState = this.waitlistAsync;
        if (restCallState != null) {
            return restCallState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubWaitlistState(waitlistAsync=");
        sbU.append(this.waitlistAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubWaitlistViewModel3(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
