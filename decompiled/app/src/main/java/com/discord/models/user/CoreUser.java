package com.discord.models.user;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CoreUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0089\u0001\u0012\n\u0010\u0019\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u0012\b\b\u0002\u0010 \u001a\u00020\u0012\u0012\b\b\u0002\u0010!\u001a\u00020\u000f\u0012\b\b\u0002\u0010\"\u001a\u00020\u000f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b<\u0010=B\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b<\u0010@J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\bJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0094\u0001\u0010%\u001a\u00020\u00002\f\b\u0002\u0010\u0019\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b'\u0010\bJ\u0010\u0010(\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b(\u0010\u0011J\u001a\u0010+\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001c\u0010!\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b.\u0010\u0011R\u001c\u0010\u001a\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\bR \u0010\u0019\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0005R\u001c\u0010\u001f\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b3\u0010\u0011R\u001c\u0010\u001e\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b\u001e\u0010\rR\u001e\u0010$\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010/\u001a\u0004\b5\u0010\bR\u001c\u0010 \u001a\u00020\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u00106\u001a\u0004\b7\u0010\u0014R\u001e\u0010#\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b8\u0010\bR\u001c\u0010\u001d\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b\u001d\u0010\rR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b9\u0010\bR\u001c\u0010\"\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010-\u001a\u0004\b:\u0010\u0011R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b;\u0010\b¨\u0006B"}, d2 = {"Lcom/discord/models/user/CoreUser;", "Lcom/discord/models/user/User;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()Z", "component6", "", "component7", "()I", "Lcom/discord/api/premium/PremiumTier;", "component8", "()Lcom/discord/api/premium/PremiumTier;", "component9", "component10", "component11", "component12", ModelAuditLogEntry.CHANGE_KEY_ID, "username", "avatar", "banner", "isBot", "isSystemUser", "discriminator", "premiumTier", "flags", "publicFlags", "bio", "bannerColor", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILcom/discord/api/premium/PremiumTier;IILjava/lang/String;Ljava/lang/String;)Lcom/discord/models/user/CoreUser;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getFlags", "Ljava/lang/String;", "getUsername", "J", "getId", "getDiscriminator", "Z", "getBannerColor", "Lcom/discord/api/premium/PremiumTier;", "getPremiumTier", "getBio", "getBanner", "getPublicFlags", "getAvatar", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILcom/discord/api/premium/PremiumTier;IILjava/lang/String;Ljava/lang/String;)V", "Lcom/discord/api/user/User;", "user", "(Lcom/discord/api/user/User;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class CoreUser implements User {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatar;
    private final String banner;
    private final String bannerColor;
    private final String bio;
    private final int discriminator;
    private final int flags;
    private final long id;
    private final boolean isBot;
    private final boolean isSystemUser;
    private final PremiumTier premiumTier;
    private final int publicFlags;
    private final String username;

    /* compiled from: CoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/models/user/CoreUser$Companion;", "", "Lcom/discord/models/user/CoreUser;", "oldUser", "Lcom/discord/api/user/User;", "newUser", "merge", "(Lcom/discord/models/user/CoreUser;Lcom/discord/api/user/User;)Lcom/discord/models/user/CoreUser;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00fd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CoreUser merge(CoreUser oldUser, com.discord.api.user.User newUser) {
            String avatar;
            String banner;
            String bio;
            String str;
            NullSerializable<String> nullSerializableC;
            String strA;
            Intrinsics3.checkNotNullParameter(oldUser, "oldUser");
            Intrinsics3.checkNotNullParameter(newUser, "newUser");
            long id2 = newUser.getId();
            String username = newUser.getUsername();
            NullSerializable<String> nullSerializableA = newUser.a();
            if (nullSerializableA instanceof NullSerializable.b) {
                avatar = (String) ((NullSerializable.b) nullSerializableA).a();
            } else if (nullSerializableA instanceof NullSerializable.a) {
                avatar = null;
            } else {
                if (nullSerializableA != null) {
                    throw new NoWhenBranchMatchedException();
                }
                avatar = oldUser.getAvatar();
            }
            NullSerializable<String> nullSerializableB = newUser.b();
            if (nullSerializableB instanceof NullSerializable.b) {
                banner = (String) ((NullSerializable.b) nullSerializableB).a();
            } else if (nullSerializableB instanceof NullSerializable.a) {
                banner = null;
            } else {
                if (nullSerializableB != null) {
                    throw new NoWhenBranchMatchedException();
                }
                banner = oldUser.getBanner();
            }
            Boolean bot = newUser.getBot();
            boolean zBooleanValue = bot != null ? bot.booleanValue() : oldUser.getIsBot();
            Boolean system = newUser.getSystem();
            boolean zBooleanValue2 = system != null ? system.booleanValue() : oldUser.getIsSystemUser();
            Integer intOrNull = StringNumberConversions.toIntOrNull(newUser.getDiscriminator());
            int iIntValue = intOrNull != null ? intOrNull.intValue() : oldUser.getDiscriminator();
            PremiumTier premiumType = newUser.getPremiumType();
            if (premiumType == null) {
                premiumType = oldUser.getPremiumTier();
            }
            Integer flags = newUser.getFlags();
            int iIntValue2 = flags != null ? flags.intValue() : oldUser.getFlags();
            Integer publicFlags = newUser.getPublicFlags();
            int iIntValue3 = publicFlags != null ? publicFlags.intValue() : oldUser.getPublicFlags();
            NullSerializable<String> nullSerializableD = newUser.d();
            if (nullSerializableD instanceof NullSerializable.b) {
                bio = (String) ((NullSerializable.b) nullSerializableD).a();
            } else {
                if (nullSerializableD instanceof NullSerializable.a) {
                    str = null;
                    nullSerializableC = newUser.c();
                    if ((nullSerializableC instanceof NullSerializable.b) || (nullSerializableC instanceof NullSerializable.a)) {
                        strA = nullSerializableC.a();
                    } else {
                        if (nullSerializableC == null) {
                            throw new NoWhenBranchMatchedException();
                        }
                        strA = oldUser.getBannerColor();
                    }
                    return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strA);
                }
                if (nullSerializableD != null) {
                    throw new NoWhenBranchMatchedException();
                }
                bio = oldUser.getBio();
            }
            str = bio;
            nullSerializableC = newUser.c();
            if (nullSerializableC instanceof NullSerializable.b) {
                if (nullSerializableC == null) {
                }
            }
            return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strA);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoreUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5) {
        Intrinsics3.checkNotNullParameter(str, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        this.id = j;
        this.username = str;
        this.avatar = str2;
        this.banner = str3;
        this.isBot = z2;
        this.isSystemUser = z3;
        this.discriminator = i;
        this.premiumTier = premiumTier;
        this.flags = i2;
        this.publicFlags = i3;
        this.bio = str4;
        this.bannerColor = str5;
    }

    public static /* synthetic */ CoreUser copy$default(CoreUser coreUser, long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5, int i4, Object obj) {
        return coreUser.copy((i4 & 1) != 0 ? coreUser.getId() : j, (i4 & 2) != 0 ? coreUser.getUsername() : str, (i4 & 4) != 0 ? coreUser.getAvatar() : str2, (i4 & 8) != 0 ? coreUser.getBanner() : str3, (i4 & 16) != 0 ? coreUser.getIsBot() : z2, (i4 & 32) != 0 ? coreUser.getIsSystemUser() : z3, (i4 & 64) != 0 ? coreUser.getDiscriminator() : i, (i4 & 128) != 0 ? coreUser.getPremiumTier() : premiumTier, (i4 & 256) != 0 ? coreUser.getFlags() : i2, (i4 & 512) != 0 ? coreUser.getPublicFlags() : i3, (i4 & 1024) != 0 ? coreUser.getBio() : str4, (i4 & 2048) != 0 ? coreUser.getBannerColor() : str5);
    }

    public final long component1() {
        return getId();
    }

    public final int component10() {
        return getPublicFlags();
    }

    public final String component11() {
        return getBio();
    }

    public final String component12() {
        return getBannerColor();
    }

    public final String component2() {
        return getUsername();
    }

    public final String component3() {
        return getAvatar();
    }

    public final String component4() {
        return getBanner();
    }

    public final boolean component5() {
        return getIsBot();
    }

    public final boolean component6() {
        return getIsSystemUser();
    }

    public final int component7() {
        return getDiscriminator();
    }

    public final PremiumTier component8() {
        return getPremiumTier();
    }

    public final int component9() {
        return getFlags();
    }

    public final CoreUser copy(long id2, String username, String avatar, String banner, boolean isBot, boolean isSystemUser, int discriminator, PremiumTier premiumTier, int flags, int publicFlags, String bio, String bannerColor) {
        Intrinsics3.checkNotNullParameter(username, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        return new CoreUser(id2, username, avatar, banner, isBot, isSystemUser, discriminator, premiumTier, flags, publicFlags, bio, bannerColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoreUser)) {
            return false;
        }
        CoreUser coreUser = (CoreUser) other;
        return getId() == coreUser.getId() && Intrinsics3.areEqual(getUsername(), coreUser.getUsername()) && Intrinsics3.areEqual(getAvatar(), coreUser.getAvatar()) && Intrinsics3.areEqual(getBanner(), coreUser.getBanner()) && getIsBot() == coreUser.getIsBot() && getIsSystemUser() == coreUser.getIsSystemUser() && getDiscriminator() == coreUser.getDiscriminator() && Intrinsics3.areEqual(getPremiumTier(), coreUser.getPremiumTier()) && getFlags() == coreUser.getFlags() && getPublicFlags() == coreUser.getPublicFlags() && Intrinsics3.areEqual(getBio(), coreUser.getBio()) && Intrinsics3.areEqual(getBannerColor(), coreUser.getBannerColor());
    }

    @Override // com.discord.models.user.User
    public String getAvatar() {
        return this.avatar;
    }

    @Override // com.discord.models.user.User
    public String getBanner() {
        return this.banner;
    }

    @Override // com.discord.models.user.User
    public String getBannerColor() {
        return this.bannerColor;
    }

    @Override // com.discord.models.user.User
    public String getBio() {
        return this.bio;
    }

    @Override // com.discord.models.user.User
    public int getDiscriminator() {
        return this.discriminator;
    }

    @Override // com.discord.models.user.User
    public int getFlags() {
        return this.flags;
    }

    @Override // com.discord.models.user.User
    public long getId() {
        return this.id;
    }

    @Override // com.discord.models.user.User
    public PremiumTier getPremiumTier() {
        return this.premiumTier;
    }

    @Override // com.discord.models.user.User
    public int getPublicFlags() {
        return this.publicFlags;
    }

    @Override // com.discord.models.user.User
    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int iA = b.a(getId()) * 31;
        String username = getUsername();
        int iHashCode = (iA + (username != null ? username.hashCode() : 0)) * 31;
        String avatar = getAvatar();
        int iHashCode2 = (iHashCode + (avatar != null ? avatar.hashCode() : 0)) * 31;
        String banner = getBanner();
        int iHashCode3 = (iHashCode2 + (banner != null ? banner.hashCode() : 0)) * 31;
        boolean isBot = getIsBot();
        int i = isBot;
        if (isBot) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean isSystemUser = getIsSystemUser();
        int discriminator = (getDiscriminator() + ((i2 + (isSystemUser ? 1 : isSystemUser)) * 31)) * 31;
        PremiumTier premiumTier = getPremiumTier();
        int publicFlags = (getPublicFlags() + ((getFlags() + ((discriminator + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31)) * 31)) * 31;
        String bio = getBio();
        int iHashCode4 = (publicFlags + (bio != null ? bio.hashCode() : 0)) * 31;
        String bannerColor = getBannerColor();
        return iHashCode4 + (bannerColor != null ? bannerColor.hashCode() : 0);
    }

    @Override // com.discord.models.user.User
    /* renamed from: isBot, reason: from getter */
    public boolean getIsBot() {
        return this.isBot;
    }

    @Override // com.discord.models.user.User
    /* renamed from: isSystemUser, reason: from getter */
    public boolean getIsSystemUser() {
        return this.isSystemUser;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CoreUser(id=");
        sbU.append(getId());
        sbU.append(", username=");
        sbU.append(getUsername());
        sbU.append(", avatar=");
        sbU.append(getAvatar());
        sbU.append(", banner=");
        sbU.append(getBanner());
        sbU.append(", isBot=");
        sbU.append(getIsBot());
        sbU.append(", isSystemUser=");
        sbU.append(getIsSystemUser());
        sbU.append(", discriminator=");
        sbU.append(getDiscriminator());
        sbU.append(", premiumTier=");
        sbU.append(getPremiumTier());
        sbU.append(", flags=");
        sbU.append(getFlags());
        sbU.append(", publicFlags=");
        sbU.append(getPublicFlags());
        sbU.append(", bio=");
        sbU.append(getBio());
        sbU.append(", bannerColor=");
        sbU.append(getBannerColor());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ CoreUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? PremiumTier.NONE : premiumTier, (i4 & 256) != 0 ? 0 : i2, (i4 & 512) != 0 ? 0 : i3, (i4 & 1024) != 0 ? null : str4, (i4 & 2048) != 0 ? null : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CoreUser(com.discord.api.user.User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        long id2 = user.getId();
        String username = user.getUsername();
        NullSerializable<String> nullSerializableA = user.a();
        String strA = nullSerializableA != null ? nullSerializableA.a() : null;
        NullSerializable<String> nullSerializableB = user.b();
        String strA2 = nullSerializableB != null ? nullSerializableB.a() : null;
        Boolean bot = user.getBot();
        boolean zBooleanValue = bot != null ? bot.booleanValue() : false;
        Boolean system = user.getSystem();
        boolean zBooleanValue2 = system != null ? system.booleanValue() : false;
        Integer intOrNull = StringNumberConversions.toIntOrNull(user.getDiscriminator());
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 0;
        PremiumTier premiumType = user.getPremiumType();
        premiumType = premiumType == null ? PremiumTier.NONE : premiumType;
        Integer flags = user.getFlags();
        int iIntValue2 = flags != null ? flags.intValue() : 0;
        Integer publicFlags = user.getPublicFlags();
        int iIntValue3 = publicFlags != null ? publicFlags.intValue() : 0;
        NullSerializable<String> nullSerializableD = user.d();
        String strA3 = nullSerializableD != null ? nullSerializableD.a() : null;
        NullSerializable<String> nullSerializableC = user.c();
        this(id2, username, strA, strA2, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, strA3, nullSerializableC != null ? nullSerializableC.a() : null);
    }
}
