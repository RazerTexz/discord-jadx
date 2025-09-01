package com.discord.widgets.stage.sheet;

import com.discord.utilities.cache.SharedPreferencesProvider;
import kotlin.Metadata;

/* compiled from: WidgetStageAudienceNoticeManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageAudienceNoticeManager;", "", "", "hasUserSeenAudienceNotice", "()Z", "", "markUserSeenAudienceNotice", "()V", "", WidgetStageAudienceNoticeManager.STAGE_AUDIENCE_NOTICE_SHOWN_KEY, "Ljava/lang/String;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeManager {
    public static final WidgetStageAudienceNoticeManager INSTANCE = new WidgetStageAudienceNoticeManager();
    private static final String STAGE_AUDIENCE_NOTICE_SHOWN_KEY = "STAGE_AUDIENCE_NOTICE_SHOWN_KEY";

    private WidgetStageAudienceNoticeManager() {
    }

    public final boolean hasUserSeenAudienceNotice() {
        return SharedPreferencesProvider.INSTANCE.get().getBoolean(STAGE_AUDIENCE_NOTICE_SHOWN_KEY, false);
    }

    public final void markUserSeenAudienceNotice() {
        SharedPreferencesProvider.INSTANCE.get().edit().putBoolean(STAGE_AUDIENCE_NOTICE_SHOWN_KEY, true).apply();
    }
}
