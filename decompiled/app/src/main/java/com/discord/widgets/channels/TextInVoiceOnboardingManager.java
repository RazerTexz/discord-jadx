package com.discord.widgets.channels;

import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: TextInVoiceOnboardingManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u0010J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/channels/TextInVoiceOnboardingManager;", "", "", "Lcom/discord/primitives/UserId;", "userId", "", "isTooYoung", "(J)Z", "hasUserSeenTextInVoiceOnboarding", "()Z", "Lcom/discord/primitives/GuildId;", "guildId", "shouldShowTextInVoiceOnboarding", "(JLjava/lang/Long;)Z", "", "markSeen", "()V", "Lkotlin/Function0;", "onCtaClicked", "show", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TextInVoiceOnboardingManager {
    private final Clock clock = ClockFactory.get();

    private final boolean hasUserSeenTextInVoiceOnboarding() {
        return StoreStream.INSTANCE.getNotices().hasSeen("NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED");
    }

    private final boolean isTooYoung(long userId) {
        return this.clock.currentTimeMillis() < ((userId >>> 22) + SnowflakeUtils.DISCORD_EPOCH) + 604800000;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final void markSeen() {
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), "NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED", 0L, 2, null);
    }

    public final boolean shouldShowTextInVoiceOnboarding(long userId, Long guildId) {
        return (guildId == null || !TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guildId) || hasUserSeenTextInVoiceOnboarding() || isTooYoung(userId)) ? false : true;
    }

    public final void show(Function0<Unit> onCtaClicked) {
        Intrinsics3.checkNotNullParameter(onCtaClicked, "onCtaClicked");
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED", null, 0L, 0, true, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetCallFullscreen.class)), 0L, false, 0L, new TextInVoiceOnboardingManager2(onCtaClicked), 454, null));
    }
}
