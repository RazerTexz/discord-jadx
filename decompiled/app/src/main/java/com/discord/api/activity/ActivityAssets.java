package com.discord.api.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ActivityAssets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/api/activity/ActivityAssets;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "smallImage", "Ljava/lang/String;", "c", "largeImage", "a", "largeText", "b", "smallText", "d", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ActivityAssets {
    private final String largeImage;
    private final String largeText;
    private final String smallImage;
    private final String smallText;

    public ActivityAssets(String str, String str2, String str3, String str4) {
        this.largeImage = str;
        this.largeText = str2;
        this.smallImage = str3;
        this.smallText = str4;
    }

    /* renamed from: a, reason: from getter */
    public final String getLargeImage() {
        return this.largeImage;
    }

    /* renamed from: b, reason: from getter */
    public final String getLargeText() {
        return this.largeText;
    }

    /* renamed from: c, reason: from getter */
    public final String getSmallImage() {
        return this.smallImage;
    }

    /* renamed from: d, reason: from getter */
    public final String getSmallText() {
        return this.smallText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityAssets)) {
            return false;
        }
        ActivityAssets activityAssets = (ActivityAssets) other;
        return Intrinsics3.areEqual(this.largeImage, activityAssets.largeImage) && Intrinsics3.areEqual(this.largeText, activityAssets.largeText) && Intrinsics3.areEqual(this.smallImage, activityAssets.smallImage) && Intrinsics3.areEqual(this.smallText, activityAssets.smallText);
    }

    public int hashCode() {
        String str = this.largeImage;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.largeText;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.smallImage;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.smallText;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActivityAssets(largeImage=");
        sbU.append(this.largeImage);
        sbU.append(", largeText=");
        sbU.append(this.largeText);
        sbU.append(", smallImage=");
        sbU.append(this.smallImage);
        sbU.append(", smallText=");
        return outline.J(sbU, this.smallText, ")");
    }
}
