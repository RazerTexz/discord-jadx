package com.discord.widgets.servers.auditlog;

import android.view.View;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter2 implements View.OnClickListener {
    public final /* synthetic */ GuildMember $guildMember;
    public final /* synthetic */ User $user;
    public final /* synthetic */ WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder this$0;

    public WidgetServerSettingsAuditLogAdapter2(WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder auditLogEntryViewHolder, User user, GuildMember guildMember) {
        this.this$0 = auditLogEntryViewHolder;
        this.$user = user;
        this.$guildMember = guildMember;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$user != null) {
            Function2<Long, Long, Unit> onAuditLogAvatarClicked = WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getOnAuditLogAvatarClicked();
            Long lValueOf = Long.valueOf(this.$user.getId());
            GuildMember guildMember = this.$guildMember;
            onAuditLogAvatarClicked.invoke(lValueOf, guildMember != null ? Long.valueOf(guildMember.getGuildId()) : null);
        }
    }
}
