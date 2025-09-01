package com.discord.api.connectedaccounts;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ConnectedAccountIntegration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccountIntegration;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "Ljava/lang/String;", "d", "Lcom/discord/api/connectedaccounts/ConnectedIntegrationGuild;", "guild", "Lcom/discord/api/connectedaccounts/ConnectedIntegrationGuild;", "b", "()Lcom/discord/api/connectedaccounts/ConnectedIntegrationGuild;", "Lcom/discord/api/connectedaccounts/ConnectedIntegrationAccount;", "account", "Lcom/discord/api/connectedaccounts/ConnectedIntegrationAccount;", "a", "()Lcom/discord/api/connectedaccounts/ConnectedIntegrationAccount;", ModelAuditLogEntry.CHANGE_KEY_ID, "c", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ConnectedAccountIntegration {
    private final ConnectedIntegrationAccount account;
    private final ConnectedIntegrationGuild guild;
    private final String id;
    private final String type;

    /* renamed from: a, reason: from getter */
    public final ConnectedIntegrationAccount getAccount() {
        return this.account;
    }

    /* renamed from: b, reason: from getter */
    public final ConnectedIntegrationGuild getGuild() {
        return this.guild;
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedAccountIntegration)) {
            return false;
        }
        ConnectedAccountIntegration connectedAccountIntegration = (ConnectedAccountIntegration) other;
        return Intrinsics3.areEqual(this.id, connectedAccountIntegration.id) && Intrinsics3.areEqual(this.type, connectedAccountIntegration.type) && Intrinsics3.areEqual(this.account, connectedAccountIntegration.account) && Intrinsics3.areEqual(this.guild, connectedAccountIntegration.guild);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ConnectedIntegrationAccount connectedIntegrationAccount = this.account;
        int iHashCode3 = (iHashCode2 + (connectedIntegrationAccount != null ? connectedIntegrationAccount.hashCode() : 0)) * 31;
        ConnectedIntegrationGuild connectedIntegrationGuild = this.guild;
        return iHashCode3 + (connectedIntegrationGuild != null ? connectedIntegrationGuild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ConnectedAccountIntegration(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", account=");
        sbU.append(this.account);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
