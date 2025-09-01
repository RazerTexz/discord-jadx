package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.hubs.EmailVerification;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubEmailViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u000bR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u000fR\u001d\u0010(\u001a\u00020\u001b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R!\u0010\u0011\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\b¨\u0006-"}, d2 = {"Lcom/discord/widgets/hubs/HubEmailState;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/widgets/hubs/HubWaitlistResult;", "component3", "()Lcom/discord/widgets/hubs/HubWaitlistResult;", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/EmailVerification;", "component4", "()Lcom/discord/stores/utilities/RestCallState;", NotificationCompat.CATEGORY_EMAIL, "selectedGuildId", "waitlistResult", "verifyEmailAsync", "copy", "(Ljava/lang/String;Ljava/lang/Long;Lcom/discord/widgets/hubs/HubWaitlistResult;Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/HubEmailState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmail", "Lcom/discord/widgets/hubs/HubWaitlistResult;", "getWaitlistResult", "Lcom/discord/stores/utilities/RestCallState;", "getVerifyEmailAsync", "hasMultipleDomains$delegate", "Lkotlin/Lazy;", "getHasMultipleDomains", "()Z", "hasMultipleDomains", "Ljava/lang/Long;", "getSelectedGuildId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lcom/discord/widgets/hubs/HubWaitlistResult;Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubEmailState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubEmailViewModel4 {
    private final String email;

    /* renamed from: hasMultipleDomains$delegate, reason: from kotlin metadata */
    private final Lazy hasMultipleDomains;
    private final Long selectedGuildId;
    private final RestCallState<EmailVerification> verifyEmailAsync;
    private final WidgetHubWaitlist2 waitlistResult;

    public WidgetHubEmailViewModel4() {
        this(null, null, null, null, 15, null);
    }

    public WidgetHubEmailViewModel4(String str, Long l, WidgetHubWaitlist2 widgetHubWaitlist2, RestCallState<EmailVerification> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "verifyEmailAsync");
        this.email = str;
        this.selectedGuildId = l;
        this.waitlistResult = widgetHubWaitlist2;
        this.verifyEmailAsync = restCallState;
        this.hasMultipleDomains = LazyJVM.lazy(new WidgetHubEmailViewModel5(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubEmailViewModel4 copy$default(WidgetHubEmailViewModel4 widgetHubEmailViewModel4, String str, Long l, WidgetHubWaitlist2 widgetHubWaitlist2, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubEmailViewModel4.email;
        }
        if ((i & 2) != 0) {
            l = widgetHubEmailViewModel4.selectedGuildId;
        }
        if ((i & 4) != 0) {
            widgetHubWaitlist2 = widgetHubEmailViewModel4.waitlistResult;
        }
        if ((i & 8) != 0) {
            restCallState = widgetHubEmailViewModel4.verifyEmailAsync;
        }
        return widgetHubEmailViewModel4.copy(str, l, widgetHubWaitlist2, restCallState);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    /* renamed from: component3, reason: from getter */
    public final WidgetHubWaitlist2 getWaitlistResult() {
        return this.waitlistResult;
    }

    public final RestCallState<EmailVerification> component4() {
        return this.verifyEmailAsync;
    }

    public final WidgetHubEmailViewModel4 copy(String email, Long selectedGuildId, WidgetHubWaitlist2 waitlistResult, RestCallState<EmailVerification> verifyEmailAsync) {
        Intrinsics3.checkNotNullParameter(verifyEmailAsync, "verifyEmailAsync");
        return new WidgetHubEmailViewModel4(email, selectedGuildId, waitlistResult, verifyEmailAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEmailViewModel4)) {
            return false;
        }
        WidgetHubEmailViewModel4 widgetHubEmailViewModel4 = (WidgetHubEmailViewModel4) other;
        return Intrinsics3.areEqual(this.email, widgetHubEmailViewModel4.email) && Intrinsics3.areEqual(this.selectedGuildId, widgetHubEmailViewModel4.selectedGuildId) && Intrinsics3.areEqual(this.waitlistResult, widgetHubEmailViewModel4.waitlistResult) && Intrinsics3.areEqual(this.verifyEmailAsync, widgetHubEmailViewModel4.verifyEmailAsync);
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getHasMultipleDomains() {
        return ((Boolean) this.hasMultipleDomains.getValue()).booleanValue();
    }

    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<EmailVerification> getVerifyEmailAsync() {
        return this.verifyEmailAsync;
    }

    public final WidgetHubWaitlist2 getWaitlistResult() {
        return this.waitlistResult;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.selectedGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        WidgetHubWaitlist2 widgetHubWaitlist2 = this.waitlistResult;
        int iHashCode3 = (iHashCode2 + (widgetHubWaitlist2 != null ? widgetHubWaitlist2.hashCode() : 0)) * 31;
        RestCallState<EmailVerification> restCallState = this.verifyEmailAsync;
        return iHashCode3 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubEmailState(email=");
        sbU.append(this.email);
        sbU.append(", selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", waitlistResult=");
        sbU.append(this.waitlistResult);
        sbU.append(", verifyEmailAsync=");
        sbU.append(this.verifyEmailAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubEmailViewModel4(String str, Long l, WidgetHubWaitlist2 widgetHubWaitlist2, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : widgetHubWaitlist2, (i & 8) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
