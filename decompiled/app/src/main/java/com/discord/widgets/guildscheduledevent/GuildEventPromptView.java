package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.GuildEventPromptViewBinding;
import com.discord.utilities.color.ColorCompat2;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildEventPromptView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0016J1\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildEventPromptView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "iconRes", "iconBackgroundColorRes", "", "title", "subtitle", "", "configure", "(IILjava/lang/CharSequence;Ljava/lang/CharSequence;)V", "Lcom/discord/databinding/GuildEventPromptViewBinding;", "binding", "Lcom/discord/databinding/GuildEventPromptViewBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildEventPromptView extends ConstraintLayout {
    private final GuildEventPromptViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingA = GuildEventPromptViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptViewBindingA, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingA;
    }

    public final void configure(@DrawableRes int iconRes, @ColorRes int iconBackgroundColorRes, CharSequence title, CharSequence subtitle) {
        Intrinsics3.checkNotNullParameter(title, "title");
        Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
        this.binding.f2117b.setImageResource(iconRes);
        ImageView imageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.iconBg");
        ColorCompat2.tintWithColorResource(imageView, iconBackgroundColorRes);
        MaterialTextView materialTextView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.title");
        materialTextView.setText(title);
        MaterialTextView materialTextView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.subtitle");
        materialTextView2.setText(subtitle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingA = GuildEventPromptViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptViewBindingA, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingA = GuildEventPromptViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptViewBindingA, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingA;
    }
}
