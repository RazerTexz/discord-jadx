package com.discord.utilities.textprocessing;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: TagsBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u0002\u0012\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\t0\u0002¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J\u001a\u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\t0\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0006JL\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\u0012\b\u0002\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u00022\u0012\b\u0002\u0010\r\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\t0\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R#\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0006R#\u0010\r\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001c\u0010\u0006R\u0019\u0010\u001d\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR#\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b \u0010\u0006¨\u0006#"}, d2 = {"Lcom/discord/utilities/textprocessing/Tags;", "", "", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/util/Set;", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/primitives/RoleId;", "component3", "users", "channels", "roles", "copy", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)Lcom/discord/utilities/textprocessing/Tags;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getChannels", "getRoles", "isEmpty", "Z", "()Z", "getUsers", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.Tags, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class TagsBuilder2 {
    private final Set<Long> channels;
    private final boolean isEmpty;
    private final Set<Long> roles;
    private final Set<Long> users;

    public TagsBuilder2(Set<Long> set, Set<Long> set2, Set<Long> set3) {
        Intrinsics3.checkNotNullParameter(set, "users");
        Intrinsics3.checkNotNullParameter(set2, "channels");
        Intrinsics3.checkNotNullParameter(set3, "roles");
        this.users = set;
        this.channels = set2;
        this.roles = set3;
        this.isEmpty = set.isEmpty() && set3.isEmpty() && set2.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagsBuilder2 copy$default(TagsBuilder2 tagsBuilder2, Set set, Set set2, Set set3, int i, Object obj) {
        if ((i & 1) != 0) {
            set = tagsBuilder2.users;
        }
        if ((i & 2) != 0) {
            set2 = tagsBuilder2.channels;
        }
        if ((i & 4) != 0) {
            set3 = tagsBuilder2.roles;
        }
        return tagsBuilder2.copy(set, set2, set3);
    }

    public final Set<Long> component1() {
        return this.users;
    }

    public final Set<Long> component2() {
        return this.channels;
    }

    public final Set<Long> component3() {
        return this.roles;
    }

    public final TagsBuilder2 copy(Set<Long> users, Set<Long> channels, Set<Long> roles) {
        Intrinsics3.checkNotNullParameter(users, "users");
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        return new TagsBuilder2(users, channels, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagsBuilder2)) {
            return false;
        }
        TagsBuilder2 tagsBuilder2 = (TagsBuilder2) other;
        return Intrinsics3.areEqual(this.users, tagsBuilder2.users) && Intrinsics3.areEqual(this.channels, tagsBuilder2.channels) && Intrinsics3.areEqual(this.roles, tagsBuilder2.roles);
    }

    public final Set<Long> getChannels() {
        return this.channels;
    }

    public final Set<Long> getRoles() {
        return this.roles;
    }

    public final Set<Long> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Set<Long> set = this.users;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Set<Long> set2 = this.channels;
        int iHashCode2 = (iHashCode + (set2 != null ? set2.hashCode() : 0)) * 31;
        Set<Long> set3 = this.roles;
        return iHashCode2 + (set3 != null ? set3.hashCode() : 0);
    }

    /* renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Tags(users=");
        sbU.append(this.users);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", roles=");
        return outline.N(sbU, this.roles, ")");
    }
}
