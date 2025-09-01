package com.discord.models.domain.emoji;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelEmojiGuild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJf\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\nR\u0019\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b(\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b)\u0010\nR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b,\u0010\nR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010\rR\u0019\u0010\u001a\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b/\u0010\nR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b1\u0010\u0007¨\u00064"}, d2 = {"Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "", "component4", "()Ljava/util/List;", "component5", "Lcom/discord/api/user/User;", "component6", "()Lcom/discord/api/user/User;", "component7", "component8", ModelAuditLogEntry.CHANGE_KEY_ID, ModelAuditLogEntry.CHANGE_KEY_NAME, "managed", "roles", "requiredColons", "user", "animated", ModelAuditLogEntry.CHANGE_KEY_AVAILABLE, "copy", "(JLjava/lang/String;ZLjava/util/List;ZLcom/discord/api/user/User;ZZ)Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getManaged", "Lcom/discord/api/user/User;", "getUser", "getAvailable", "J", "getId", "getRequiredColons", "Ljava/util/List;", "getRoles", "getAnimated", "Ljava/lang/String;", "getName", "<init>", "(JLjava/lang/String;ZLjava/util/List;ZLcom/discord/api/user/User;ZZ)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelEmojiGuild {
    private final boolean animated;
    private final boolean available;
    private final long id;
    private final boolean managed;
    private final String name;
    private final boolean requiredColons;
    private final List<Long> roles;
    private final User user;

    public ModelEmojiGuild(long j, String str, boolean z2, List<Long> list, boolean z3, User user, boolean z4, boolean z5) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "roles");
        Intrinsics3.checkNotNullParameter(user, "user");
        this.id = j;
        this.name = str;
        this.managed = z2;
        this.roles = list;
        this.requiredColons = z3;
        this.user = user;
        this.animated = z4;
        this.available = z5;
    }

    public static /* synthetic */ ModelEmojiGuild copy$default(ModelEmojiGuild modelEmojiGuild, long j, String str, boolean z2, List list, boolean z3, User user, boolean z4, boolean z5, int i, Object obj) {
        return modelEmojiGuild.copy((i & 1) != 0 ? modelEmojiGuild.id : j, (i & 2) != 0 ? modelEmojiGuild.name : str, (i & 4) != 0 ? modelEmojiGuild.managed : z2, (i & 8) != 0 ? modelEmojiGuild.roles : list, (i & 16) != 0 ? modelEmojiGuild.requiredColons : z3, (i & 32) != 0 ? modelEmojiGuild.user : user, (i & 64) != 0 ? modelEmojiGuild.animated : z4, (i & 128) != 0 ? modelEmojiGuild.available : z5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    public final List<Long> component4() {
        return this.roles;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRequiredColons() {
        return this.requiredColons;
    }

    /* renamed from: component6, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAvailable() {
        return this.available;
    }

    public final ModelEmojiGuild copy(long id2, String name, boolean managed, List<Long> roles, boolean requiredColons, User user, boolean animated, boolean available) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(user, "user");
        return new ModelEmojiGuild(id2, name, managed, roles, requiredColons, user, animated, available);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelEmojiGuild)) {
            return false;
        }
        ModelEmojiGuild modelEmojiGuild = (ModelEmojiGuild) other;
        return this.id == modelEmojiGuild.id && Intrinsics3.areEqual(this.name, modelEmojiGuild.name) && this.managed == modelEmojiGuild.managed && Intrinsics3.areEqual(this.roles, modelEmojiGuild.roles) && this.requiredColons == modelEmojiGuild.requiredColons && Intrinsics3.areEqual(this.user, modelEmojiGuild.user) && this.animated == modelEmojiGuild.animated && this.available == modelEmojiGuild.available;
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getManaged() {
        return this.managed;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getRequiredColons() {
        return this.requiredColons;
    }

    public final List<Long> getRoles() {
        return this.roles;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.managed;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (i3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z3 = this.requiredColons;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode2 + i4) * 31;
        User user = this.user;
        int iHashCode3 = (i5 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z4 = this.animated;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (iHashCode3 + i6) * 31;
        boolean z5 = this.available;
        return i7 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelEmojiGuild(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", requiredColons=");
        sbU.append(this.requiredColons);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", animated=");
        sbU.append(this.animated);
        sbU.append(", available=");
        return outline.O(sbU, this.available, ")");
    }
}
