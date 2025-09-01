package com.discord.models.authentication;

import b.d.b.a.outline;
import com.discord.api.auth.RequiredAction;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AuthState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/discord/models/authentication/AuthState;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/api/auth/RequiredAction;", "component2", "()Ljava/util/Set;", "token", "requiredActions", "copy", "(Ljava/lang/String;Ljava/util/Set;)Lcom/discord/models/authentication/AuthState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "Ljava/util/Set;", "getRequiredActions", "<init>", "(Ljava/lang/String;Ljava/util/Set;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class AuthState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Set<RequiredAction> requiredActions;
    private final String token;

    /* compiled from: AuthState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/models/authentication/AuthState$Companion;", "", "", "token", "", "Lcom/discord/api/auth/RequiredAction;", "requiredActions", "Lcom/discord/models/authentication/AuthState;", "from", "(Ljava/lang/String;Ljava/util/Set;)Lcom/discord/models/authentication/AuthState;", "", "isUpdatePasswordRequired", "(Lcom/discord/models/authentication/AuthState;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final AuthState from(String token, Set<? extends RequiredAction> requiredActions) {
            Intrinsics3.checkNotNullParameter(requiredActions, "requiredActions");
            if (token != null) {
                return new AuthState(token, requiredActions);
            }
            return null;
        }

        public final boolean isUpdatePasswordRequired(AuthState authState) {
            Set<RequiredAction> requiredActions;
            if (authState == null || (requiredActions = authState.getRequiredActions()) == null) {
                return false;
            }
            return requiredActions.contains(RequiredAction.UPDATE_PASSWORD);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthState(String str, Set<? extends RequiredAction> set) {
        Intrinsics3.checkNotNullParameter(str, "token");
        Intrinsics3.checkNotNullParameter(set, "requiredActions");
        this.token = str;
        this.requiredActions = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthState copy$default(AuthState authState, String str, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authState.token;
        }
        if ((i & 2) != 0) {
            set = authState.requiredActions;
        }
        return authState.copy(str, set);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final Set<RequiredAction> component2() {
        return this.requiredActions;
    }

    public final AuthState copy(String token, Set<? extends RequiredAction> requiredActions) {
        Intrinsics3.checkNotNullParameter(token, "token");
        Intrinsics3.checkNotNullParameter(requiredActions, "requiredActions");
        return new AuthState(token, requiredActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthState)) {
            return false;
        }
        AuthState authState = (AuthState) other;
        return Intrinsics3.areEqual(this.token, authState.token) && Intrinsics3.areEqual(this.requiredActions, authState.requiredActions);
    }

    public final Set<RequiredAction> getRequiredActions() {
        return this.requiredActions;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Set<RequiredAction> set = this.requiredActions;
        return iHashCode + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AuthState(token=");
        sbU.append(this.token);
        sbU.append(", requiredActions=");
        return outline.N(sbU, this.requiredActions, ")");
    }
}
