package com.discord.widgets.voice.feedback.stream;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import d0.z.d.Intrinsics3;
import java.util.Random;
import kotlin.Metadata;
import org.objectweb.asm.Opcodes;

/* compiled from: StreamFeedbackSheetNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u000e\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00042\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0010\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u000e\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetNavigator;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "Lcom/discord/primitives/MediaSessionId;", "mediaSessionId", "", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;)V", "getNoticeName", "(Ljava/lang/String;)Ljava/lang/String;", "", "triggerRateDenominator", "enqueueNotice", "(Ljava/lang/String;Ljava/lang/String;I)V", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Ljava/util/Random;", "random", "Ljava/util/Random;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StreamFeedbackSheetNavigator {
    public static final StreamFeedbackSheetNavigator INSTANCE = new StreamFeedbackSheetNavigator();
    private static final Random random = new Random();
    private static final Clock clock = ClockFactory.get();

    private StreamFeedbackSheetNavigator() {
    }

    public static final /* synthetic */ Clock access$getClock$p(StreamFeedbackSheetNavigator streamFeedbackSheetNavigator) {
        return clock;
    }

    public static final /* synthetic */ void access$show(StreamFeedbackSheetNavigator streamFeedbackSheetNavigator, FragmentManager fragmentManager, String str, String str2) {
        streamFeedbackSheetNavigator.show(fragmentManager, str, str2);
    }

    private final String getNoticeName(String streamKey) {
        return outline.w("Stream feedback notice for streamKey: ", streamKey);
    }

    private final void show(FragmentManager fragmentManager, String streamKey, String mediaSessionId) {
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.INSTANCE.newInstance(WidgetFeedbackSheet.FeedbackType.STREAM);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        Intrinsics3.checkNotNull(arguments);
        arguments.putString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_STREAM_KEY, streamKey);
        arguments.putString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID, mediaSessionId);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(String streamKey, String mediaSessionId, int triggerRateDenominator) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        if (triggerRateDenominator < 1 || random.nextInt(triggerRateDenominator) != 0) {
            return;
        }
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String noticeName = getNoticeName(streamKey);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        notices.requestToShow(new StoreNotices.Notice(noticeName, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new StreamFeedbackSheetNavigator2(jCurrentTimeMillis, streamKey, mediaSessionId, notices, noticeName), Opcodes.GETSTATIC, null));
    }
}
