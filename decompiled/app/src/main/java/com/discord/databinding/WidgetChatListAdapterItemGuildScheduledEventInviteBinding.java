package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInviteBinding implements ViewBinding {

    @NonNull
    public final GuildScheduledEventItemView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildScheduledEventItemView f2322b;

    public WidgetChatListAdapterItemGuildScheduledEventInviteBinding(@NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull GuildScheduledEventItemView guildScheduledEventItemView2) {
        this.a = guildScheduledEventItemView;
        this.f2322b = guildScheduledEventItemView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
