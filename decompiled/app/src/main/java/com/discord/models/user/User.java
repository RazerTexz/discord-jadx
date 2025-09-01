package com.discord.models.user;

import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: User.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0015\u001a\u00060\u0011j\u0002`\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u0016\u0010\u001b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0016\u0010\u001d\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0016\u0010\u001e\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0004R\u0016\u0010\"\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/discord/models/user/User;", "Ljava/io/Serializable;", "", "isSystemUser", "()Z", "", "getFlags", "()I", "flags", "getPublicFlags", "publicFlags", "", "getAvatar", "()Ljava/lang/String;", "avatar", "getBio", "bio", "", "Lcom/discord/primitives/UserId;", "getId", "()J", ModelAuditLogEntry.CHANGE_KEY_ID, "getBannerColor", "bannerColor", "getBanner", "banner", "getDiscriminator", "discriminator", "getUsername", "username", "isBot", "Lcom/discord/api/premium/PremiumTier;", "getPremiumTier", "()Lcom/discord/api/premium/PremiumTier;", "premiumTier", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public interface User extends Serializable {
    String getAvatar();

    String getBanner();

    String getBannerColor();

    String getBio();

    int getDiscriminator();

    int getFlags();

    long getId();

    PremiumTier getPremiumTier();

    int getPublicFlags();

    String getUsername();

    boolean isBot();

    boolean isSystemUser();
}
