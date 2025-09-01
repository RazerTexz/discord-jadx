package com.discord.models.domain.auth;

import b.d.b.a.outline;
import com.discord.api.auth.RequiredAction;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelLoginResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJP\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000b¨\u0006)"}, d2 = {"Lcom/discord/models/domain/auth/ModelLoginResult;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "Lcom/discord/models/domain/auth/ModelUserSettingsBootstrap;", "component4", "()Lcom/discord/models/domain/auth/ModelUserSettingsBootstrap;", "", "Lcom/discord/api/auth/RequiredAction;", "component5", "()Ljava/util/List;", WidgetSettingsAccountChangePassword.MFA_FIELD, "ticket", "token", "userSettings", "requiredActions", "copy", "(ZLjava/lang/String;Ljava/lang/String;Lcom/discord/models/domain/auth/ModelUserSettingsBootstrap;Ljava/util/List;)Lcom/discord/models/domain/auth/ModelLoginResult;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "Ljava/util/List;", "getRequiredActions", "Z", "getMfa", "getTicket", "Lcom/discord/models/domain/auth/ModelUserSettingsBootstrap;", "getUserSettings", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/discord/models/domain/auth/ModelUserSettingsBootstrap;Ljava/util/List;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelLoginResult {
    private final boolean mfa;
    private final List<RequiredAction> requiredActions;
    private final String ticket;
    private final String token;
    private final ModelLoginResult2 userSettings;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelLoginResult(boolean z2, String str, String str2, ModelLoginResult2 modelLoginResult2, List<? extends RequiredAction> list) {
        this.mfa = z2;
        this.ticket = str;
        this.token = str2;
        this.userSettings = modelLoginResult2;
        this.requiredActions = list;
    }

    public static /* synthetic */ ModelLoginResult copy$default(ModelLoginResult modelLoginResult, boolean z2, String str, String str2, ModelLoginResult2 modelLoginResult2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = modelLoginResult.mfa;
        }
        if ((i & 2) != 0) {
            str = modelLoginResult.ticket;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = modelLoginResult.token;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            modelLoginResult2 = modelLoginResult.userSettings;
        }
        ModelLoginResult2 modelLoginResult22 = modelLoginResult2;
        if ((i & 16) != 0) {
            list = modelLoginResult.requiredActions;
        }
        return modelLoginResult.copy(z2, str3, str4, modelLoginResult22, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getMfa() {
        return this.mfa;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelLoginResult2 getUserSettings() {
        return this.userSettings;
    }

    public final List<RequiredAction> component5() {
        return this.requiredActions;
    }

    public final ModelLoginResult copy(boolean mfa, String ticket, String token, ModelLoginResult2 userSettings, List<? extends RequiredAction> requiredActions) {
        return new ModelLoginResult(mfa, ticket, token, userSettings, requiredActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLoginResult)) {
            return false;
        }
        ModelLoginResult modelLoginResult = (ModelLoginResult) other;
        return this.mfa == modelLoginResult.mfa && Intrinsics3.areEqual(this.ticket, modelLoginResult.ticket) && Intrinsics3.areEqual(this.token, modelLoginResult.token) && Intrinsics3.areEqual(this.userSettings, modelLoginResult.userSettings) && Intrinsics3.areEqual(this.requiredActions, modelLoginResult.requiredActions);
    }

    public final boolean getMfa() {
        return this.mfa;
    }

    public final List<RequiredAction> getRequiredActions() {
        return this.requiredActions;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getToken() {
        return this.token;
    }

    public final ModelLoginResult2 getUserSettings() {
        return this.userSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z2 = this.mfa;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.ticket;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.token;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ModelLoginResult2 modelLoginResult2 = this.userSettings;
        int iHashCode3 = (iHashCode2 + (modelLoginResult2 != null ? modelLoginResult2.hashCode() : 0)) * 31;
        List<RequiredAction> list = this.requiredActions;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelLoginResult(mfa=");
        sbU.append(this.mfa);
        sbU.append(", ticket=");
        sbU.append(this.ticket);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", userSettings=");
        sbU.append(this.userSettings);
        sbU.append(", requiredActions=");
        return outline.L(sbU, this.requiredActions, ")");
    }

    public /* synthetic */ ModelLoginResult(boolean z2, String str, String str2, ModelLoginResult2 modelLoginResult2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, str, str2, modelLoginResult2, list);
    }
}
