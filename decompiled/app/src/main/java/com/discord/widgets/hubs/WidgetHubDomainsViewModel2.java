package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubDomainsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/hubs/DomainsState;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/lang/Long;", "Lcom/discord/stores/utilities/RestCallState;", "component2", "()Lcom/discord/stores/utilities/RestCallState;", "selectedGuildId", "verifyEmailAsync", "copy", "(Ljava/lang/Long;Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/DomainsState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getSelectedGuildId", "Lcom/discord/stores/utilities/RestCallState;", "getVerifyEmailAsync", "<init>", "(Ljava/lang/Long;Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.DomainsState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubDomainsViewModel2 {
    private final Long selectedGuildId;
    private final RestCallState<Object> verifyEmailAsync;

    public WidgetHubDomainsViewModel2() {
        this(null, null, 3, null);
    }

    public WidgetHubDomainsViewModel2(Long l, RestCallState<? extends Object> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "verifyEmailAsync");
        this.selectedGuildId = l;
        this.verifyEmailAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubDomainsViewModel2 copy$default(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2, Long l, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widgetHubDomainsViewModel2.selectedGuildId;
        }
        if ((i & 2) != 0) {
            restCallState = widgetHubDomainsViewModel2.verifyEmailAsync;
        }
        return widgetHubDomainsViewModel2.copy(l, restCallState);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<Object> component2() {
        return this.verifyEmailAsync;
    }

    public final WidgetHubDomainsViewModel2 copy(Long selectedGuildId, RestCallState<? extends Object> verifyEmailAsync) {
        Intrinsics3.checkNotNullParameter(verifyEmailAsync, "verifyEmailAsync");
        return new WidgetHubDomainsViewModel2(selectedGuildId, verifyEmailAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDomainsViewModel2)) {
            return false;
        }
        WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2 = (WidgetHubDomainsViewModel2) other;
        return Intrinsics3.areEqual(this.selectedGuildId, widgetHubDomainsViewModel2.selectedGuildId) && Intrinsics3.areEqual(this.verifyEmailAsync, widgetHubDomainsViewModel2.verifyEmailAsync);
    }

    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<Object> getVerifyEmailAsync() {
        return this.verifyEmailAsync;
    }

    public int hashCode() {
        Long l = this.selectedGuildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        RestCallState<Object> restCallState = this.verifyEmailAsync;
        return iHashCode + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DomainsState(selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", verifyEmailAsync=");
        sbU.append(this.verifyEmailAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubDomainsViewModel2(Long l, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
