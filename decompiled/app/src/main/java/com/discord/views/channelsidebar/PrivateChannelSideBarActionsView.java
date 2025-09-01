package com.discord.views.channelsidebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import b.a.i.PrivateChannelSideBarActionsViewBinding;
import com.discord.R;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import defpackage.d;
import kotlin.Metadata;

/* compiled from: PrivateChannelSideBarActionsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/discord/views/channelsidebar/PrivateChannelSideBarActionsView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "onCallClicked", "onVideoClicked", "onNotificationsClicked", "onSearchClicked", "", "channelIsMuted", "", "a", "(Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Z)V", "Lb/a/i/g1;", "j", "Lb/a/i/g1;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PrivateChannelSideBarActionsView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final PrivateChannelSideBarActionsViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateChannelSideBarActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.private_channel_side_bar_actions_view, this);
        int i = R.id.private_channel_sidebar_actions_call;
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.private_channel_sidebar_actions_call);
        if (materialButton != null) {
            i = R.id.private_channel_sidebar_actions_notifications;
            MaterialButton materialButton2 = (MaterialButton) findViewById(R.id.private_channel_sidebar_actions_notifications);
            if (materialButton2 != null) {
                i = R.id.private_channel_sidebar_actions_search;
                MaterialButton materialButton3 = (MaterialButton) findViewById(R.id.private_channel_sidebar_actions_search);
                if (materialButton3 != null) {
                    i = R.id.private_channel_sidebar_actions_video;
                    MaterialButton materialButton4 = (MaterialButton) findViewById(R.id.private_channel_sidebar_actions_video);
                    if (materialButton4 != null) {
                        PrivateChannelSideBarActionsViewBinding privateChannelSideBarActionsViewBinding = new PrivateChannelSideBarActionsViewBinding(this, materialButton, materialButton2, materialButton3, materialButton4);
                        Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsViewBinding, "PrivateChannelSideBarAct…ater.from(context), this)");
                        this.binding = privateChannelSideBarActionsViewBinding;
                        a(d.j, d.k, d.l, d.m, false);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(View.OnClickListener onCallClicked, View.OnClickListener onVideoClicked, View.OnClickListener onNotificationsClicked, View.OnClickListener onSearchClicked, boolean channelIsMuted) {
        Intrinsics3.checkNotNullParameter(onCallClicked, "onCallClicked");
        Intrinsics3.checkNotNullParameter(onVideoClicked, "onVideoClicked");
        Intrinsics3.checkNotNullParameter(onNotificationsClicked, "onNotificationsClicked");
        Intrinsics3.checkNotNullParameter(onSearchClicked, "onSearchClicked");
        int themedDrawableRes$default = channelIsMuted ? DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_sidebar_notifications_off_24dp, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_sidebar_notifications_on_24dp, 0, 2, (Object) null);
        this.binding.f118b.setOnClickListener(onCallClicked);
        this.binding.e.setOnClickListener(onVideoClicked);
        MaterialButton materialButton = this.binding.c;
        DrawableCompat.setCompoundDrawablesCompat(materialButton, (Drawable) null, ContextCompat.getDrawable(materialButton.getContext(), themedDrawableRes$default), (Drawable) null, (Drawable) null);
        materialButton.setOnClickListener(onNotificationsClicked);
        this.binding.d.setOnClickListener(onSearchClicked);
    }
}
