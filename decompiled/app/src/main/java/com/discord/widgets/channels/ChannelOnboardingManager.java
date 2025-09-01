package com.discord.widgets.channels;

import com.discord.utilities.cache.SharedPreferencesProvider;
import kotlin.Metadata;

/* compiled from: ChannelOnboardingManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/ChannelOnboardingManager;", "", "", "hasUserSeenChannelOnboarding", "()Z", "", "markSeenUserChannelOnboarding", "()V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelOnboardingManager {
    public final boolean hasUserSeenChannelOnboarding() {
        return SharedPreferencesProvider.INSTANCE.get().getBoolean("CACHE_KEY_CHANNEL_ONBOARDED", false);
    }

    public final void markSeenUserChannelOnboarding() {
        SharedPreferencesProvider.INSTANCE.get().edit().putBoolean("CACHE_KEY_CHANNEL_ONBOARDED", true).apply();
    }
}
