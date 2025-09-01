package com.discord.api.user;

import b.d.b.a.outline;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PatchUserBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/discord/api/user/PatchUserBody;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/nullserializable/NullSerializable;", "banner", "Lcom/discord/nullserializable/NullSerializable;", "getBanner", "()Lcom/discord/nullserializable/NullSerializable;", "bio", "getBio", "bannerColor", "getBannerColor", "avatar", "getAvatar", "<init>", "(Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PatchUserBody {
    private final NullSerializable<String> avatar;
    private final NullSerializable<String> banner;
    private final NullSerializable<String> bannerColor;
    private final NullSerializable<String> bio;

    public PatchUserBody() {
        this.avatar = null;
        this.banner = null;
        this.bannerColor = null;
        this.bio = null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatchUserBody)) {
            return false;
        }
        PatchUserBody patchUserBody = (PatchUserBody) other;
        return Intrinsics3.areEqual(this.avatar, patchUserBody.avatar) && Intrinsics3.areEqual(this.banner, patchUserBody.banner) && Intrinsics3.areEqual(this.bannerColor, patchUserBody.bannerColor) && Intrinsics3.areEqual(this.bio, patchUserBody.bio);
    }

    public int hashCode() {
        NullSerializable<String> nullSerializable = this.avatar;
        int iHashCode = (nullSerializable != null ? nullSerializable.hashCode() : 0) * 31;
        NullSerializable<String> nullSerializable2 = this.banner;
        int iHashCode2 = (iHashCode + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable3 = this.bannerColor;
        int iHashCode3 = (iHashCode2 + (nullSerializable3 != null ? nullSerializable3.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable4 = this.bio;
        return iHashCode3 + (nullSerializable4 != null ? nullSerializable4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PatchUserBody(avatar=");
        sbU.append(this.avatar);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", bannerColor=");
        sbU.append(this.bannerColor);
        sbU.append(", bio=");
        sbU.append(this.bio);
        sbU.append(")");
        return sbU.toString();
    }

    public PatchUserBody(NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, NullSerializable<String> nullSerializable3, NullSerializable<String> nullSerializable4) {
        this.avatar = nullSerializable;
        this.banner = nullSerializable2;
        this.bannerColor = nullSerializable3;
        this.bio = nullSerializable4;
    }
}
