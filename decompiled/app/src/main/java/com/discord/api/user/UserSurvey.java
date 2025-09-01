package com.discord.api.user;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: UserSurvey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004R#\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u00190\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/api/user/UserSurvey;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guild_requirements", "Ljava/util/List;", "c", "()Ljava/util/List;", "guild_size", "d", "cta", "Ljava/lang/String;", "a", "key", "e", "", "Lcom/discord/api/permission/PermissionBit;", "guild_permissions", "b", "prompt", "f", "url", "g", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class UserSurvey {
    private final String cta;
    private final List<Long> guild_permissions;
    private final List<String> guild_requirements;
    private final List<Integer> guild_size;
    private final String key;
    private final String prompt;
    private final String url;

    /* renamed from: a, reason: from getter */
    public final String getCta() {
        return this.cta;
    }

    public final List<Long> b() {
        return this.guild_permissions;
    }

    public final List<String> c() {
        return this.guild_requirements;
    }

    public final List<Integer> d() {
        return this.guild_size;
    }

    /* renamed from: e, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSurvey)) {
            return false;
        }
        UserSurvey userSurvey = (UserSurvey) other;
        return Intrinsics3.areEqual(this.prompt, userSurvey.prompt) && Intrinsics3.areEqual(this.cta, userSurvey.cta) && Intrinsics3.areEqual(this.url, userSurvey.url) && Intrinsics3.areEqual(this.key, userSurvey.key) && Intrinsics3.areEqual(this.guild_requirements, userSurvey.guild_requirements) && Intrinsics3.areEqual(this.guild_size, userSurvey.guild_size) && Intrinsics3.areEqual(this.guild_permissions, userSurvey.guild_permissions);
    }

    /* renamed from: f, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.prompt;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cta;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.key;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<String> list = this.guild_requirements;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<Integer> list2 = this.guild_size;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.guild_permissions;
        return iHashCode6 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserSurvey(prompt=");
        sbU.append(this.prompt);
        sbU.append(", cta=");
        sbU.append(this.cta);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", key=");
        sbU.append(this.key);
        sbU.append(", guild_requirements=");
        sbU.append(this.guild_requirements);
        sbU.append(", guild_size=");
        sbU.append(this.guild_size);
        sbU.append(", guild_permissions=");
        return outline.L(sbU, this.guild_permissions, ")");
    }
}
