package com.discord.widgets.guild_delete_feedback;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import org.objectweb.asm.Opcodes;

/* compiled from: GuildDeleteFeedbackSheetNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guild_delete_feedback/GuildDeleteFeedbackSheetNavigator;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "show", "(Landroidx/fragment/app/FragmentManager;J)V", "enqueueNotice", "(J)V", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetNavigator {
    public static final GuildDeleteFeedbackSheetNavigator INSTANCE = new GuildDeleteFeedbackSheetNavigator();
    private static final Clock clock = ClockFactory.get();

    private GuildDeleteFeedbackSheetNavigator() {
    }

    public static final /* synthetic */ Clock access$getClock$p(GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator) {
        return clock;
    }

    public static final /* synthetic */ void access$show(GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator, FragmentManager fragmentManager, long j) {
        guildDeleteFeedbackSheetNavigator.show(fragmentManager, j);
    }

    private final void show(FragmentManager fragmentManager, long guildId) {
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.INSTANCE.newInstance(WidgetFeedbackSheet.FeedbackType.GUILD_DELETE);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        Intrinsics3.checkNotNull(arguments);
        arguments.putLong(WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID, guildId);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(long guildId) {
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String strT = outline.t("Delete Guild Feedback for ", guildId);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        notices.requestToShow(new StoreNotices.Notice(strT, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new GuildDeleteFeedbackSheetNavigator2(jCurrentTimeMillis, guildId, notices, strT), Opcodes.GETSTATIC, null));
    }
}
