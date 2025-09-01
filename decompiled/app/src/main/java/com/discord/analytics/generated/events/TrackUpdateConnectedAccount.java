package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackUpdateConnectedAccount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R\u001b\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u001c\u0010+\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0005R\u001b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012¨\u00060"}, d2 = {"Lcom/discord/analytics/generated/events/TrackUpdateConnectedAccount;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "platformType", "Ljava/lang/CharSequence;", "getPlatformType", "()Ljava/lang/CharSequence;", "", "visibility", "Ljava/lang/Long;", "getVisibility", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "accountId", "getAccountId", "connected", "Ljava/lang/Boolean;", "getConnected", "()Ljava/lang/Boolean;", "partner", "getPartner", "accountName", "getAccountName", "friendSync", "getFriendSync", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "linkMethod", "getLinkMethod", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateConnectedAccount implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence accountId = null;
    private final CharSequence accountName = null;
    private final Boolean connected = null;
    private final CharSequence platformType = null;
    private final Long visibility = null;
    private final Boolean friendSync = null;
    private final Boolean partner = null;
    private final CharSequence linkMethod = null;
    private final transient String analyticsSchemaTypeName = "update_connected_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateConnectedAccount)) {
            return false;
        }
        TrackUpdateConnectedAccount trackUpdateConnectedAccount = (TrackUpdateConnectedAccount) other;
        return Intrinsics3.areEqual(this.accountId, trackUpdateConnectedAccount.accountId) && Intrinsics3.areEqual(this.accountName, trackUpdateConnectedAccount.accountName) && Intrinsics3.areEqual(this.connected, trackUpdateConnectedAccount.connected) && Intrinsics3.areEqual(this.platformType, trackUpdateConnectedAccount.platformType) && Intrinsics3.areEqual(this.visibility, trackUpdateConnectedAccount.visibility) && Intrinsics3.areEqual(this.friendSync, trackUpdateConnectedAccount.friendSync) && Intrinsics3.areEqual(this.partner, trackUpdateConnectedAccount.partner) && Intrinsics3.areEqual(this.linkMethod, trackUpdateConnectedAccount.linkMethod);
    }

    public int hashCode() {
        CharSequence charSequence = this.accountId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.accountName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.connected;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.platformType;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.visibility;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.friendSync;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.partner;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.linkMethod;
        return iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUpdateConnectedAccount(accountId=");
        sbU.append(this.accountId);
        sbU.append(", accountName=");
        sbU.append(this.accountName);
        sbU.append(", connected=");
        sbU.append(this.connected);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", visibility=");
        sbU.append(this.visibility);
        sbU.append(", friendSync=");
        sbU.append(this.friendSync);
        sbU.append(", partner=");
        sbU.append(this.partner);
        sbU.append(", linkMethod=");
        return outline.E(sbU, this.linkMethod, ")");
    }
}
