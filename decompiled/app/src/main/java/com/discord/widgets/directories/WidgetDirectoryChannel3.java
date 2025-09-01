package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/directories/WidgetDirectoryChannel$configureUi$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel3 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    public WidgetDirectoryChannel3(Guild guild, WidgetDirectoryChannel widgetDirectoryChannel) {
        this.$guild = guild;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
        Context contextX = outline.x(view, "it", "it.context");
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetGuildInviteShare.Companion.launch$default(companion, contextX, childFragmentManager, this.$guild.getId(), null, false, null, null, "Guild Header", 120, null);
    }
}
