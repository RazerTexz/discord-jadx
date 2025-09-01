package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification2;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubAuthenticationlViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ<\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/hubs/HubAuthenticationState;", "", "", "component1", "()Ljava/lang/String;", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/EmailVerification;", "component2", "()Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/EmailVerificationCode;", "component3", NotificationCompat.CATEGORY_EMAIL, "resendEmailAsync", "authenticationAsync", "copy", "(Ljava/lang/String;Lcom/discord/stores/utilities/RestCallState;Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/HubAuthenticationState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/utilities/RestCallState;", "getAuthenticationAsync", "Ljava/lang/String;", "getEmail", "getResendEmailAsync", "<init>", "(Ljava/lang/String;Lcom/discord/stores/utilities/RestCallState;Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubAuthenticationState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubAuthenticationlViewModel3 {
    private final RestCallState<EmailVerification2> authenticationAsync;
    private final String email;
    private final RestCallState<EmailVerification> resendEmailAsync;

    public WidgetHubAuthenticationlViewModel3() {
        this(null, null, null, 7, null);
    }

    public WidgetHubAuthenticationlViewModel3(String str, RestCallState<EmailVerification> restCallState, RestCallState<EmailVerification2> restCallState2) {
        Intrinsics3.checkNotNullParameter(restCallState, "resendEmailAsync");
        Intrinsics3.checkNotNullParameter(restCallState2, "authenticationAsync");
        this.email = str;
        this.resendEmailAsync = restCallState;
        this.authenticationAsync = restCallState2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubAuthenticationlViewModel3 copy$default(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3, String str, RestCallState restCallState, RestCallState restCallState2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubAuthenticationlViewModel3.email;
        }
        if ((i & 2) != 0) {
            restCallState = widgetHubAuthenticationlViewModel3.resendEmailAsync;
        }
        if ((i & 4) != 0) {
            restCallState2 = widgetHubAuthenticationlViewModel3.authenticationAsync;
        }
        return widgetHubAuthenticationlViewModel3.copy(str, restCallState, restCallState2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final RestCallState<EmailVerification> component2() {
        return this.resendEmailAsync;
    }

    public final RestCallState<EmailVerification2> component3() {
        return this.authenticationAsync;
    }

    public final WidgetHubAuthenticationlViewModel3 copy(String email, RestCallState<EmailVerification> resendEmailAsync, RestCallState<EmailVerification2> authenticationAsync) {
        Intrinsics3.checkNotNullParameter(resendEmailAsync, "resendEmailAsync");
        Intrinsics3.checkNotNullParameter(authenticationAsync, "authenticationAsync");
        return new WidgetHubAuthenticationlViewModel3(email, resendEmailAsync, authenticationAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAuthenticationlViewModel3)) {
            return false;
        }
        WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3 = (WidgetHubAuthenticationlViewModel3) other;
        return Intrinsics3.areEqual(this.email, widgetHubAuthenticationlViewModel3.email) && Intrinsics3.areEqual(this.resendEmailAsync, widgetHubAuthenticationlViewModel3.resendEmailAsync) && Intrinsics3.areEqual(this.authenticationAsync, widgetHubAuthenticationlViewModel3.authenticationAsync);
    }

    public final RestCallState<EmailVerification2> getAuthenticationAsync() {
        return this.authenticationAsync;
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestCallState<EmailVerification> getResendEmailAsync() {
        return this.resendEmailAsync;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        RestCallState<EmailVerification> restCallState = this.resendEmailAsync;
        int iHashCode2 = (iHashCode + (restCallState != null ? restCallState.hashCode() : 0)) * 31;
        RestCallState<EmailVerification2> restCallState2 = this.authenticationAsync;
        return iHashCode2 + (restCallState2 != null ? restCallState2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubAuthenticationState(email=");
        sbU.append(this.email);
        sbU.append(", resendEmailAsync=");
        sbU.append(this.resendEmailAsync);
        sbU.append(", authenticationAsync=");
        sbU.append(this.authenticationAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubAuthenticationlViewModel3(String str, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? RestCallState2.INSTANCE : restCallState, (i & 4) != 0 ? RestCallState2.INSTANCE : restCallState2);
    }
}
