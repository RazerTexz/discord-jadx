package com.discord.api.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ActivityTimestamps.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0015\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/discord/api/activity/ActivityTimestamps;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "number", "", "a", "(Ljava/lang/String;)J", "end", "Ljava/lang/String;", "start", "c", "()J", "startMs", "b", "endMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ActivityTimestamps {
    private final String end;
    private final String start;

    public ActivityTimestamps(String str, String str2) {
        this.start = str;
        this.end = str2;
    }

    public final long a(String number) throws NumberFormatException {
        if (number == null || number.length() == 0) {
            return 0L;
        }
        try {
            long j = Long.parseLong(number);
            if (number.length() < 13) {
                j *= 1000;
            }
            return j;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long b() {
        return a(this.end);
    }

    public final long c() {
        return a(this.start);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityTimestamps)) {
            return false;
        }
        ActivityTimestamps activityTimestamps = (ActivityTimestamps) other;
        return Intrinsics3.areEqual(this.start, activityTimestamps.start) && Intrinsics3.areEqual(this.end, activityTimestamps.end);
    }

    public int hashCode() {
        String str = this.start;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.end;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActivityTimestamps(start=");
        sbU.append(this.start);
        sbU.append(", end=");
        return outline.J(sbU, this.end, ")");
    }
}
