package com.discord.widgets.voice.fullscreen.stage;

import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: StageCallBottomSheetManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallBottomSheetManager;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/api/channel/Channel;", "channel", "", "configureBottomSheet", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/api/channel/Channel;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StageCallBottomSheetManager {
    public final boolean configureBottomSheet(FragmentManager fragmentManager, Channel channel) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Map map = (Map) outline.c(channel, companion.getVoiceStates().get());
        boolean z2 = false;
        if (map != null) {
            StageRoles stageRolesM15getMyRolesvisDeB4 = companion.getStageChannels().m15getMyRolesvisDeB4(channel.getId());
            long id2 = companion.getUsers().getMeSnapshot().getId();
            if (ChannelUtils.D(channel) && stageRolesM15getMyRolesvisDeB4 != null && map.containsKey(Long.valueOf(id2))) {
                if (StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) && companion.getStageInstances().getStageInstanceForChannel(channel.getId()) == null) {
                    z2 = true;
                }
                if (StageRoles.m30isAudienceimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
                    WidgetStageAudienceNoticeBottomSheet.INSTANCE.show(fragmentManager, channel.getId());
                } else if (z2) {
                    WidgetStageStartEventBottomSheet.Companion.show$default(WidgetStageStartEventBottomSheet.INSTANCE, fragmentManager, channel.getId(), null, 4, null);
                } else if (StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) && !StageRoles.m33isSpeakerimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
                    WidgetStageModeratorJoinBottomSheet.INSTANCE.show(fragmentManager, channel.getId());
                }
                return true;
            }
        }
        return false;
    }
}
