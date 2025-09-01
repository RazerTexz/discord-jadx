package com.discord.models.domain;

import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NotificationSettingsModelUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/models/domain/NotificationSettingsModelUtils;", "", "", "muted", "Lcom/discord/models/domain/ModelMuteConfig;", "muteConfig", "Lcom/discord/utilities/time/Clock;", "clock", "isMuted", "(ZLcom/discord/models/domain/ModelMuteConfig;Lcom/discord/utilities/time/Clock;)Z", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class NotificationSettingsModelUtils {
    public static final NotificationSettingsModelUtils INSTANCE = new NotificationSettingsModelUtils();

    private NotificationSettingsModelUtils() {
    }

    public static final boolean isMuted(boolean muted, ModelMuteConfig muteConfig, Clock clock) {
        Long endTimeMs;
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return muted && !(muteConfig != null && (endTimeMs = muteConfig.getEndTimeMs()) != null && (endTimeMs.longValue() > clock.currentTimeMillis() ? 1 : (endTimeMs.longValue() == clock.currentTimeMillis() ? 0 : -1)) <= 0);
    }
}
