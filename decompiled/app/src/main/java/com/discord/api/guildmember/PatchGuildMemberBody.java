package com.discord.api.guildmember;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PatchGuildMemberBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/api/guildmember/PatchGuildMemberBody;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_NICK, "Ljava/lang/String;", "getNick", "Lcom/discord/nullserializable/NullSerializable;", "banner", "Lcom/discord/nullserializable/NullSerializable;", "getBanner", "()Lcom/discord/nullserializable/NullSerializable;", "avatar", "getAvatar", "bio", "getBio", "<init>", "(Ljava/lang/String;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PatchGuildMemberBody {
    private final NullSerializable<String> avatar;
    private final NullSerializable<String> banner;
    private final String bio;
    private final String nick;

    public PatchGuildMemberBody() {
        this(null, null, null, null, 15);
    }

    public PatchGuildMemberBody(String str, NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, String str2) {
        this.nick = str;
        this.avatar = nullSerializable;
        this.banner = nullSerializable2;
        this.bio = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatchGuildMemberBody)) {
            return false;
        }
        PatchGuildMemberBody patchGuildMemberBody = (PatchGuildMemberBody) other;
        return Intrinsics3.areEqual(this.nick, patchGuildMemberBody.nick) && Intrinsics3.areEqual(this.avatar, patchGuildMemberBody.avatar) && Intrinsics3.areEqual(this.banner, patchGuildMemberBody.banner) && Intrinsics3.areEqual(this.bio, patchGuildMemberBody.bio);
    }

    public int hashCode() {
        String str = this.nick;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        NullSerializable<String> nullSerializable = this.avatar;
        int iHashCode2 = (iHashCode + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable2 = this.banner;
        int iHashCode3 = (iHashCode2 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
        String str2 = this.bio;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PatchGuildMemberBody(nick=");
        sbU.append(this.nick);
        sbU.append(", avatar=");
        sbU.append(this.avatar);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", bio=");
        return outline.J(sbU, this.bio, ")");
    }

    public PatchGuildMemberBody(String str, NullSerializable nullSerializable, NullSerializable nullSerializable2, String str2, int i) {
        str = (i & 1) != 0 ? null : str;
        nullSerializable = (i & 2) != 0 ? null : nullSerializable;
        int i2 = i & 4;
        int i3 = i & 8;
        this.nick = str;
        this.avatar = nullSerializable;
        this.banner = null;
        this.bio = null;
    }
}
