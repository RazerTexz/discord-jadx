package com.discord.models.user;

import a0.a.a.b;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.Phone;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MeUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 W2\u00020\u0001:\u0001WBË\u0001\u0012\n\u0010!\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010*\u001a\u00020\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\u000f\u0012\b\b\u0002\u0010.\u001a\u00020\u000f\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00100\u001a\u00020\u001c\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bR\u0010SB\u0011\b\u0016\u0012\u0006\u0010U\u001a\u00020T¢\u0006\u0004\bR\u0010VJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0011J\u0010\u0010\u001a\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0011J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b \u0010\bJÖ\u0001\u00103\u001a\u00020\u00002\f\b\u0002\u0010!\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\"\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00100\u001a\u00020\u001c2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b5\u0010\bJ\u0010\u00106\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b6\u0010\u0011J\u001a\u00109\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:R\u0019\u00100\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010;\u001a\u0004\b<\u0010\u001eR\u001c\u0010%\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010=\u001a\u0004\b%\u0010\rR \u0010!\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010>\u001a\u0004\b?\u0010\u0005R\u001c\u0010\"\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bA\u0010\bR\u0019\u0010B\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010\rR\u001e\u0010$\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bD\u0010\bR\u001c\u0010(\u001a\u00020\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010E\u001a\u0004\bF\u0010\u0014R\u001e\u0010#\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bG\u0010\bR\u001b\u0010)\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010@\u001a\u0004\bH\u0010\bR\u001c\u0010'\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010I\u001a\u0004\bJ\u0010\u0011R\u001e\u00101\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u0010@\u001a\u0004\bK\u0010\bR\u001b\u0010,\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010@\u001a\u0004\bL\u0010\bR\u001c\u0010&\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010=\u001a\u0004\b&\u0010\rR\u0019\u0010*\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010=\u001a\u0004\bM\u0010\rR\u001c\u0010-\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010I\u001a\u0004\bN\u0010\u0011R\u001c\u0010.\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010I\u001a\u0004\bO\u0010\u0011R\u001b\u0010/\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010@\u001a\u0004\bP\u0010\bR\u0019\u0010+\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010=\u001a\u0004\b+\u0010\rR\u001e\u00102\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u0010@\u001a\u0004\bQ\u0010\b¨\u0006X"}, d2 = {"Lcom/discord/models/user/MeUser;", "Lcom/discord/models/user/User;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()Z", "component6", "", "component7", "()I", "Lcom/discord/api/premium/PremiumTier;", "component8", "()Lcom/discord/api/premium/PremiumTier;", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "Lcom/discord/api/user/NsfwAllowance;", "component16", "()Lcom/discord/api/user/NsfwAllowance;", "component17", "component18", ModelAuditLogEntry.CHANGE_KEY_ID, "username", "avatar", "banner", "isBot", "isSystemUser", "discriminator", "premiumTier", NotificationCompat.CATEGORY_EMAIL, "mfaEnabled", "isVerified", "token", "flags", "publicFlags", "phoneNumber", "nsfwAllowance", "bio", "bannerColor", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILcom/discord/api/premium/PremiumTier;Ljava/lang/String;ZZLjava/lang/String;IILjava/lang/String;Lcom/discord/api/user/NsfwAllowance;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/user/MeUser;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/user/NsfwAllowance;", "getNsfwAllowance", "Z", "J", "getId", "Ljava/lang/String;", "getUsername", "hasBirthday", "getHasBirthday", "getBanner", "Lcom/discord/api/premium/PremiumTier;", "getPremiumTier", "getAvatar", "getEmail", "I", "getDiscriminator", "getBio", "getToken", "getMfaEnabled", "getFlags", "getPublicFlags", "getPhoneNumber", "getBannerColor", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILcom/discord/api/premium/PremiumTier;Ljava/lang/String;ZZLjava/lang/String;IILjava/lang/String;Lcom/discord/api/user/NsfwAllowance;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/api/user/User;", "user", "(Lcom/discord/api/user/User;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MeUser implements User {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatar;
    private final String banner;
    private final String bannerColor;
    private final String bio;
    private final int discriminator;
    private final String email;
    private final int flags;
    private final boolean hasBirthday;
    private final long id;
    private final boolean isBot;
    private final boolean isSystemUser;
    private final boolean isVerified;
    private final boolean mfaEnabled;
    private final NsfwAllowance nsfwAllowance;
    private final String phoneNumber;
    private final PremiumTier premiumTier;
    private final int publicFlags;
    private final String token;
    private final String username;

    /* compiled from: MeUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/models/user/MeUser$Companion;", "", "Lcom/discord/models/user/MeUser;", "oldUser", "Lcom/discord/api/user/User;", "newUser", "merge", "(Lcom/discord/models/user/MeUser;Lcom/discord/api/user/User;)Lcom/discord/models/user/MeUser;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0146  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0176  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final MeUser merge(MeUser oldUser, com.discord.api.user.User newUser) {
            String avatar;
            String banner;
            String phoneNumber;
            String str;
            NsfwAllowance nsfwAllowed;
            NullSerializable<String> nullSerializableD;
            String bio;
            String str2;
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
            String email = newUser.getEmail();
            if (email == null) {
                email = oldUser.getEmail();
            }
            Boolean mfaEnabled = newUser.getMfaEnabled();
            boolean zBooleanValue3 = mfaEnabled != null ? mfaEnabled.booleanValue() : oldUser.getMfaEnabled();
            Boolean verified = newUser.getVerified();
            boolean zBooleanValue4 = verified != null ? verified.booleanValue() : oldUser.isVerified();
            String token = newUser.getToken();
            if (token == null) {
                token = oldUser.getToken();
            }
            Integer flags = newUser.getFlags();
            int iIntValue2 = flags != null ? flags.intValue() : oldUser.getFlags();
            Integer publicFlags = newUser.getPublicFlags();
            int iIntValue3 = publicFlags != null ? publicFlags.intValue() : oldUser.getPublicFlags();
            Phone phone = newUser.getPhone();
            if (phone instanceof Phone.PhoneNumber) {
                Phone phone2 = newUser.getPhone();
                Objects.requireNonNull(phone2, "null cannot be cast to non-null type com.discord.api.user.Phone.PhoneNumber");
                phoneNumber = ((Phone.PhoneNumber) phone2).getNumber();
            } else {
                if (Intrinsics3.areEqual(phone, Phone.NoPhoneNumber.INSTANCE)) {
                    str = null;
                    nsfwAllowed = newUser.getNsfwAllowed();
                    if (nsfwAllowed == null) {
                        nsfwAllowed = oldUser.getNsfwAllowance();
                    }
                    NsfwAllowance nsfwAllowance = nsfwAllowed;
                    nullSerializableD = newUser.d();
                    if (!(nullSerializableD instanceof NullSerializable.b)) {
                        bio = (String) ((NullSerializable.b) nullSerializableD).a();
                    } else {
                        if (nullSerializableD instanceof NullSerializable.a) {
                            str2 = null;
                            nullSerializableC = newUser.c();
                            if (!(nullSerializableC instanceof NullSerializable.b) || (nullSerializableC instanceof NullSerializable.a)) {
                                strA = nullSerializableC.a();
                            } else {
                                if (nullSerializableC == null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                strA = oldUser.getBannerColor();
                            }
                            return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance, str2, strA);
                        }
                        if (nullSerializableD != null) {
                            throw new NoWhenBranchMatchedException();
                        }
                        bio = oldUser.getBio();
                    }
                    str2 = bio;
                    nullSerializableC = newUser.c();
                    if (!(nullSerializableC instanceof NullSerializable.b)) {
                        if (nullSerializableC == null) {
                        }
                    }
                    return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance, str2, strA);
                }
                if (phone != null) {
                    throw new NoWhenBranchMatchedException();
                }
                phoneNumber = oldUser.getPhoneNumber();
            }
            str = phoneNumber;
            nsfwAllowed = newUser.getNsfwAllowed();
            if (nsfwAllowed == null) {
            }
            NsfwAllowance nsfwAllowance2 = nsfwAllowed;
            nullSerializableD = newUser.d();
            if (!(nullSerializableD instanceof NullSerializable.b)) {
            }
            str2 = bio;
            nullSerializableC = newUser.c();
            if (!(nullSerializableC instanceof NullSerializable.b)) {
            }
            return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance2, str2, strA);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MeUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, String str4, boolean z4, boolean z5, String str5, int i2, int i3, String str6, NsfwAllowance nsfwAllowance, String str7, String str8) {
        Intrinsics3.checkNotNullParameter(str, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        Intrinsics3.checkNotNullParameter(nsfwAllowance, "nsfwAllowance");
        this.id = j;
        this.username = str;
        this.avatar = str2;
        this.banner = str3;
        this.isBot = z2;
        this.isSystemUser = z3;
        this.discriminator = i;
        this.premiumTier = premiumTier;
        this.email = str4;
        this.mfaEnabled = z4;
        this.isVerified = z5;
        this.token = str5;
        this.flags = i2;
        this.publicFlags = i3;
        this.phoneNumber = str6;
        this.nsfwAllowance = nsfwAllowance;
        this.bio = str7;
        this.bannerColor = str8;
        this.hasBirthday = nsfwAllowance != NsfwAllowance.UNKNOWN;
    }

    public static /* synthetic */ MeUser copy$default(MeUser meUser, long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, String str4, boolean z4, boolean z5, String str5, int i2, int i3, String str6, NsfwAllowance nsfwAllowance, String str7, String str8, int i4, Object obj) {
        return meUser.copy((i4 & 1) != 0 ? meUser.getId() : j, (i4 & 2) != 0 ? meUser.getUsername() : str, (i4 & 4) != 0 ? meUser.getAvatar() : str2, (i4 & 8) != 0 ? meUser.getBanner() : str3, (i4 & 16) != 0 ? meUser.getIsBot() : z2, (i4 & 32) != 0 ? meUser.getIsSystemUser() : z3, (i4 & 64) != 0 ? meUser.getDiscriminator() : i, (i4 & 128) != 0 ? meUser.getPremiumTier() : premiumTier, (i4 & 256) != 0 ? meUser.email : str4, (i4 & 512) != 0 ? meUser.mfaEnabled : z4, (i4 & 1024) != 0 ? meUser.isVerified : z5, (i4 & 2048) != 0 ? meUser.token : str5, (i4 & 4096) != 0 ? meUser.getFlags() : i2, (i4 & 8192) != 0 ? meUser.getPublicFlags() : i3, (i4 & 16384) != 0 ? meUser.phoneNumber : str6, (i4 & 32768) != 0 ? meUser.nsfwAllowance : nsfwAllowance, (i4 & 65536) != 0 ? meUser.getBio() : str7, (i4 & 131072) != 0 ? meUser.getBannerColor() : str8);
    }

    public final long component1() {
        return getId();
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getMfaEnabled() {
        return this.mfaEnabled;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsVerified() {
        return this.isVerified;
    }

    /* renamed from: component12, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final int component13() {
        return getFlags();
    }

    public final int component14() {
        return getPublicFlags();
    }

    /* renamed from: component15, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component16, reason: from getter */
    public final NsfwAllowance getNsfwAllowance() {
        return this.nsfwAllowance;
    }

    public final String component17() {
        return getBio();
    }

    public final String component18() {
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

    /* renamed from: component9, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final MeUser copy(long id2, String username, String avatar, String banner, boolean isBot, boolean isSystemUser, int discriminator, PremiumTier premiumTier, String email, boolean mfaEnabled, boolean isVerified, String token, int flags, int publicFlags, String phoneNumber, NsfwAllowance nsfwAllowance, String bio, String bannerColor) {
        Intrinsics3.checkNotNullParameter(username, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        Intrinsics3.checkNotNullParameter(nsfwAllowance, "nsfwAllowance");
        return new MeUser(id2, username, avatar, banner, isBot, isSystemUser, discriminator, premiumTier, email, mfaEnabled, isVerified, token, flags, publicFlags, phoneNumber, nsfwAllowance, bio, bannerColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeUser)) {
            return false;
        }
        MeUser meUser = (MeUser) other;
        return getId() == meUser.getId() && Intrinsics3.areEqual(getUsername(), meUser.getUsername()) && Intrinsics3.areEqual(getAvatar(), meUser.getAvatar()) && Intrinsics3.areEqual(getBanner(), meUser.getBanner()) && getIsBot() == meUser.getIsBot() && getIsSystemUser() == meUser.getIsSystemUser() && getDiscriminator() == meUser.getDiscriminator() && Intrinsics3.areEqual(getPremiumTier(), meUser.getPremiumTier()) && Intrinsics3.areEqual(this.email, meUser.email) && this.mfaEnabled == meUser.mfaEnabled && this.isVerified == meUser.isVerified && Intrinsics3.areEqual(this.token, meUser.token) && getFlags() == meUser.getFlags() && getPublicFlags() == meUser.getPublicFlags() && Intrinsics3.areEqual(this.phoneNumber, meUser.phoneNumber) && Intrinsics3.areEqual(this.nsfwAllowance, meUser.nsfwAllowance) && Intrinsics3.areEqual(getBio(), meUser.getBio()) && Intrinsics3.areEqual(getBannerColor(), meUser.getBannerColor());
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

    public final String getEmail() {
        return this.email;
    }

    @Override // com.discord.models.user.User
    public int getFlags() {
        return this.flags;
    }

    public final boolean getHasBirthday() {
        return this.hasBirthday;
    }

    @Override // com.discord.models.user.User
    public long getId() {
        return this.id;
    }

    public final boolean getMfaEnabled() {
        return this.mfaEnabled;
    }

    public final NsfwAllowance getNsfwAllowance() {
        return this.nsfwAllowance;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override // com.discord.models.user.User
    public PremiumTier getPremiumTier() {
        return this.premiumTier;
    }

    @Override // com.discord.models.user.User
    public int getPublicFlags() {
        return this.publicFlags;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // com.discord.models.user.User
    public String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        int i3 = isSystemUser;
        if (isSystemUser) {
            i3 = 1;
        }
        int discriminator = (getDiscriminator() + ((i2 + i3) * 31)) * 31;
        PremiumTier premiumTier = getPremiumTier();
        int iHashCode4 = (discriminator + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
        String str = this.email;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.mfaEnabled;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode5 + i4) * 31;
        boolean z3 = this.isVerified;
        int i6 = (i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        String str2 = this.token;
        int publicFlags = (getPublicFlags() + ((getFlags() + ((i6 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31)) * 31;
        String str3 = this.phoneNumber;
        int iHashCode6 = (publicFlags + (str3 != null ? str3.hashCode() : 0)) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowance;
        int iHashCode7 = (iHashCode6 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
        String bio = getBio();
        int iHashCode8 = (iHashCode7 + (bio != null ? bio.hashCode() : 0)) * 31;
        String bannerColor = getBannerColor();
        return iHashCode8 + (bannerColor != null ? bannerColor.hashCode() : 0);
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

    public final boolean isVerified() {
        return this.isVerified;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MeUser(id=");
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
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", mfaEnabled=");
        sbU.append(this.mfaEnabled);
        sbU.append(", isVerified=");
        sbU.append(this.isVerified);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", flags=");
        sbU.append(getFlags());
        sbU.append(", publicFlags=");
        sbU.append(getPublicFlags());
        sbU.append(", phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", nsfwAllowance=");
        sbU.append(this.nsfwAllowance);
        sbU.append(", bio=");
        sbU.append(getBio());
        sbU.append(", bannerColor=");
        sbU.append(getBannerColor());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ MeUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, String str4, boolean z4, boolean z5, String str5, int i2, int i3, String str6, NsfwAllowance nsfwAllowance, String str7, String str8, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? PremiumTier.NONE : premiumTier, (i4 & 256) != 0 ? null : str4, (i4 & 512) != 0 ? false : z4, (i4 & 1024) != 0 ? false : z5, (i4 & 2048) != 0 ? null : str5, (i4 & 4096) != 0 ? 0 : i2, (i4 & 8192) != 0 ? 0 : i3, (i4 & 16384) != 0 ? null : str6, (32768 & i4) != 0 ? NsfwAllowance.UNKNOWN : nsfwAllowance, (65536 & i4) != 0 ? null : str7, (i4 & 131072) != 0 ? null : str8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MeUser(com.discord.api.user.User user) {
        String number;
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
        String email = user.getEmail();
        Boolean mfaEnabled = user.getMfaEnabled();
        boolean zBooleanValue3 = mfaEnabled != null ? mfaEnabled.booleanValue() : false;
        Boolean verified = user.getVerified();
        boolean zBooleanValue4 = verified != null ? verified.booleanValue() : false;
        String token = user.getToken();
        Integer flags = user.getFlags();
        int iIntValue2 = flags != null ? flags.intValue() : 0;
        Integer publicFlags = user.getPublicFlags();
        int iIntValue3 = publicFlags != null ? publicFlags.intValue() : 0;
        Phone phone = user.getPhone();
        if (phone instanceof Phone.PhoneNumber) {
            Phone phone2 = user.getPhone();
            Objects.requireNonNull(phone2, "null cannot be cast to non-null type com.discord.api.user.Phone.PhoneNumber");
            number = ((Phone.PhoneNumber) phone2).getNumber();
        } else {
            if (!Intrinsics3.areEqual(phone, Phone.NoPhoneNumber.INSTANCE) && phone != null) {
                throw new NoWhenBranchMatchedException();
            }
            number = null;
        }
        NsfwAllowance nsfwAllowed = user.getNsfwAllowed();
        NsfwAllowance nsfwAllowance = nsfwAllowed == null ? NsfwAllowance.UNKNOWN : nsfwAllowed;
        NullSerializable<String> nullSerializableD = user.d();
        String strA3 = nullSerializableD != null ? nullSerializableD.a() : null;
        NullSerializable<String> nullSerializableC = user.c();
        this(id2, username, strA, strA2, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, number, nsfwAllowance, strA3, nullSerializableC != null ? nullSerializableC.a() : null);
    }
}
