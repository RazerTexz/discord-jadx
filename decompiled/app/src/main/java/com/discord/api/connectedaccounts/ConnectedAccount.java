package com.discord.api.connectedaccounts;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ConnectedAccount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010\u001b\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0004R\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000f¨\u0006'"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "showActivity", "Z", "f", "()Z", "", "Lcom/discord/api/connectedaccounts/ConnectedAccountIntegration;", "integrations", "Ljava/util/List;", "c", "()Ljava/util/List;", "type", "Ljava/lang/String;", "g", "revoked", "e", "friendSync", "a", ModelAuditLogEntry.CHANGE_KEY_ID, "b", "visibility", "I", "i", ModelAuditLogEntry.CHANGE_KEY_NAME, "d", "verified", "h", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ConnectedAccount {
    public static final int HIDDEN = 0;
    public static final int VISIBLE = 1;
    private final boolean friendSync;
    private final String id;
    private final List<ConnectedAccountIntegration> integrations;
    private final String name;
    private final boolean revoked;
    private final boolean showActivity;
    private final String type;
    private final boolean verified;
    private final int visibility;

    public ConnectedAccount() {
        outline.q0("", ModelAuditLogEntry.CHANGE_KEY_ID, "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "type");
        this.id = "";
        this.name = "";
        this.visibility = 0;
        this.friendSync = false;
        this.showActivity = false;
        this.revoked = false;
        this.verified = false;
        this.integrations = null;
        this.type = "";
    }

    /* renamed from: a, reason: from getter */
    public final boolean getFriendSync() {
        return this.friendSync;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<ConnectedAccountIntegration> c() {
        return this.integrations;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getRevoked() {
        return this.revoked;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedAccount)) {
            return false;
        }
        ConnectedAccount connectedAccount = (ConnectedAccount) other;
        return Intrinsics3.areEqual(this.id, connectedAccount.id) && Intrinsics3.areEqual(this.name, connectedAccount.name) && this.visibility == connectedAccount.visibility && this.friendSync == connectedAccount.friendSync && this.showActivity == connectedAccount.showActivity && this.revoked == connectedAccount.revoked && this.verified == connectedAccount.verified && Intrinsics3.areEqual(this.integrations, connectedAccount.integrations) && Intrinsics3.areEqual(this.type, connectedAccount.type);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getShowActivity() {
        return this.showActivity;
    }

    /* renamed from: g, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getVerified() {
        return this.verified;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.visibility) * 31;
        boolean z2 = this.friendSync;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.showActivity;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.revoked;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.verified;
        int i7 = (i6 + (z5 ? 1 : z5 ? 1 : 0)) * 31;
        List<ConnectedAccountIntegration> list = this.integrations;
        int iHashCode3 = (i7 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.type;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final int getVisibility() {
        return this.visibility;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ConnectedAccount(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", visibility=");
        sbU.append(this.visibility);
        sbU.append(", friendSync=");
        sbU.append(this.friendSync);
        sbU.append(", showActivity=");
        sbU.append(this.showActivity);
        sbU.append(", revoked=");
        sbU.append(this.revoked);
        sbU.append(", verified=");
        sbU.append(this.verified);
        sbU.append(", integrations=");
        sbU.append(this.integrations);
        sbU.append(", type=");
        return outline.J(sbU, this.type, ")");
    }
}
