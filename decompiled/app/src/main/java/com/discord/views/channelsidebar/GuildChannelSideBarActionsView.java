package com.discord.views.channelsidebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import b.a.i.GuildChannelSideBarActionsViewBinding;
import b.a.y.k0.GuildChannelSideBarActionsView2;
import b.a.y.k0.GuildChannelSideBarActionsView3;
import com.discord.R;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import defpackage.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildChannelSideBarActionsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ£\u0001\u0010\u000f\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/discord/views/channelsidebar/GuildChannelSideBarActionsView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function1;", "Landroid/view/View;", "", "onSearchClicked", "onThreadBrowserClicked", "onNotificationsClicked", "onPinsClicked", "onSettingsClicked", "", "hasUnseenPins", "channelIsMuted", "disablePins", "showSearch", "a", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZZZ)V", "Lb/a/i/x;", "j", "Lb/a/i/x;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildChannelSideBarActionsView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final GuildChannelSideBarActionsViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChannelSideBarActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.guild_channel_side_bar_actions_view, this);
        int i = R.id.channel_sidebar_actions_notifications;
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.channel_sidebar_actions_notifications);
        if (materialButton != null) {
            i = R.id.channel_sidebar_actions_pins;
            MaterialButton materialButton2 = (MaterialButton) findViewById(R.id.channel_sidebar_actions_pins);
            if (materialButton2 != null) {
                i = R.id.channel_sidebar_actions_search_or_threads;
                MaterialButton materialButton3 = (MaterialButton) findViewById(R.id.channel_sidebar_actions_search_or_threads);
                if (materialButton3 != null) {
                    i = R.id.channel_sidebar_actions_settings;
                    MaterialButton materialButton4 = (MaterialButton) findViewById(R.id.channel_sidebar_actions_settings);
                    if (materialButton4 != null) {
                        GuildChannelSideBarActionsViewBinding guildChannelSideBarActionsViewBinding = new GuildChannelSideBarActionsViewBinding(this, materialButton, materialButton2, materialButton3, materialButton4);
                        Intrinsics3.checkNotNullExpressionValue(guildChannelSideBarActionsViewBinding, "GuildChannelSideBarActio…ater.from(context), this)");
                        this.binding = guildChannelSideBarActionsViewBinding;
                        a(o.j, o.k, o.l, o.m, o.n, false, false, false, true);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(Function1<? super View, Unit> onSearchClicked, Function1<? super View, Unit> onThreadBrowserClicked, Function1<? super View, Unit> onNotificationsClicked, Function1<? super View, Unit> onPinsClicked, Function1<? super View, Unit> onSettingsClicked, boolean hasUnseenPins, boolean channelIsMuted, boolean disablePins, boolean showSearch) {
        Intrinsics3.checkNotNullParameter(onSearchClicked, "onSearchClicked");
        Intrinsics3.checkNotNullParameter(onThreadBrowserClicked, "onThreadBrowserClicked");
        Intrinsics3.checkNotNullParameter(onNotificationsClicked, "onNotificationsClicked");
        Intrinsics3.checkNotNullParameter(onPinsClicked, "onPinsClicked");
        Intrinsics3.checkNotNullParameter(onSettingsClicked, "onSettingsClicked");
        int themedDrawableRes$default = hasUnseenPins ? DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_sidebar_pins_on_24dp, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_sidebar_pins_off_24dp, 0, 2, (Object) null);
        int themedDrawableRes$default2 = channelIsMuted ? DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_sidebar_notifications_off_24dp, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_sidebar_notifications_on_24dp, 0, 2, (Object) null);
        if (showSearch) {
            MaterialButton materialButton = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.channelSidebarActionsSearchOrThreads");
            DrawableCompat.setCompoundDrawablesCompat$default(materialButton, 0, R.drawable.ic_sidebar_search_24dp, 0, 0, 13, (Object) null);
            this.binding.d.setOnClickListener(new GuildChannelSideBarActionsView2(onSearchClicked));
            MaterialButton materialButton2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.channelSidebarActionsSearchOrThreads");
            materialButton2.setText(getContext().getString(R.string.search));
        } else {
            MaterialButton materialButton3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.channelSidebarActionsSearchOrThreads");
            DrawableCompat.setCompoundDrawablesCompat$default(materialButton3, 0, R.drawable.ic_thread, 0, 0, 13, (Object) null);
            this.binding.d.setOnClickListener(new GuildChannelSideBarActionsView2(onThreadBrowserClicked));
            MaterialButton materialButton4 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.channelSidebarActionsSearchOrThreads");
            materialButton4.setText(getContext().getString(R.string.threads));
        }
        this.binding.e.setOnClickListener(new GuildChannelSideBarActionsView2(onSettingsClicked));
        MaterialButton materialButton5 = this.binding.c;
        DrawableCompat.setCompoundDrawablesCompat(materialButton5, (Drawable) null, ContextCompat.getDrawable(materialButton5.getContext(), themedDrawableRes$default), (Drawable) null, (Drawable) null);
        materialButton5.setOnClickListener(new GuildChannelSideBarActionsView3(onPinsClicked));
        MaterialButton materialButton6 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.channelSidebarActionsPins");
        materialButton6.setEnabled(!disablePins);
        MaterialButton materialButton7 = this.binding.f226b;
        DrawableCompat.setCompoundDrawablesCompat(materialButton7, (Drawable) null, ContextCompat.getDrawable(materialButton7.getContext(), themedDrawableRes$default2), (Drawable) null, (Drawable) null);
        materialButton7.setOnClickListener(new GuildChannelSideBarActionsView3(onNotificationsClicked));
        materialButton7.setContentDescription(channelIsMuted ? materialButton7.getContext().getString(R.string.notifications_muted) : materialButton7.getContext().getString(R.string.notifications));
    }
}
