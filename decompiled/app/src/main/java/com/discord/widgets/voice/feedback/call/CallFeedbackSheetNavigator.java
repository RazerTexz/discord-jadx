package com.discord.widgets.voice.feedback.call;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import d0.z.d.Intrinsics3;
import java.util.Random;
import kotlin.Metadata;
import org.objectweb.asm.Opcodes;

/* compiled from: CallFeedbackSheetNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJM\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\u000b\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u0014\u001a\u00020\r2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\u000b\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetNavigator;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/primitives/RtcConnectionId;", "rtcConnectionId", "Lcom/discord/primitives/MediaSessionId;", "mediaSessionId", "callDurationMs", "", "show", "(Landroidx/fragment/app/FragmentManager;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getNoticeName", "(Ljava/lang/String;)Ljava/lang/String;", "", "triggerRateDenominator", "enqueueNotice", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;I)V", "Ljava/util/Random;", "random", "Ljava/util/Random;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CallFeedbackSheetNavigator {
    public static final CallFeedbackSheetNavigator INSTANCE = new CallFeedbackSheetNavigator();
    private static final Random random = new Random();
    private static final Clock clock = ClockFactory.get();

    private CallFeedbackSheetNavigator() {
    }

    public static final /* synthetic */ Clock access$getClock$p(CallFeedbackSheetNavigator callFeedbackSheetNavigator) {
        return clock;
    }

    public static final /* synthetic */ void access$show(CallFeedbackSheetNavigator callFeedbackSheetNavigator, FragmentManager fragmentManager, long j, String str, String str2, Long l) {
        callFeedbackSheetNavigator.show(fragmentManager, j, str, str2, l);
    }

    private final String getNoticeName(String rtcConnectionId) {
        return outline.w("Call feedback notice for rtcConnectionId: ", rtcConnectionId);
    }

    private final void show(FragmentManager fragmentManager, long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs) {
        CallFeedbackSheetViewModel.Config config = new CallFeedbackSheetViewModel.Config(channelId, rtcConnectionId, mediaSessionId, callDurationMs);
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.INSTANCE.newInstance(WidgetFeedbackSheet.FeedbackType.CALL);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        Intrinsics3.checkNotNull(arguments);
        arguments.putParcelable(WidgetFeedbackSheet.ARG_CALL_FEEDBACK_CONFIG, config);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs, int triggerRateDenominator) {
        if (triggerRateDenominator < 1 || random.nextInt(triggerRateDenominator) != 0) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreNotices notices = companion.getNotices();
        String noticeName = getNoticeName(rtcConnectionId);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        companion.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new CallFeedbackSheetNavigator2(jCurrentTimeMillis, channelId, rtcConnectionId, mediaSessionId, callDurationMs, notices, noticeName), Opcodes.GETSTATIC, null));
    }
}
