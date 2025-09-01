package com.discord.api.hubs;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WaitlistSignup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/discord/api/hubs/WaitlistSignup;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", NotificationCompat.CATEGORY_EMAIL, "Ljava/lang/String;", "getEmail", "school", "a", "emailDomain", "getEmailDomain", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class WaitlistSignup {
    private final String email;
    private final String emailDomain;
    private final String school;

    /* renamed from: a, reason: from getter */
    public final String getSchool() {
        return this.school;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WaitlistSignup)) {
            return false;
        }
        WaitlistSignup waitlistSignup = (WaitlistSignup) other;
        return Intrinsics3.areEqual(this.email, waitlistSignup.email) && Intrinsics3.areEqual(this.emailDomain, waitlistSignup.emailDomain) && Intrinsics3.areEqual(this.school, waitlistSignup.school);
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.emailDomain;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.school;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WaitlistSignup(email=");
        sbU.append(this.email);
        sbU.append(", emailDomain=");
        sbU.append(this.emailDomain);
        sbU.append(", school=");
        return outline.J(sbU, this.school, ")");
    }
}
