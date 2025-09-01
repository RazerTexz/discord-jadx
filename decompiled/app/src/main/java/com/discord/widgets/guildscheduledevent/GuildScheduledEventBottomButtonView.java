package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.GuildScheduledEventBottomButtonViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventBottomButtonView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016B!\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventBottomButtonView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/discord/widgets/guildscheduledevent/buttonconfiguration/ButtonConfiguration;", "buttonConfiguration", "", "configureStartEventButton", "(Lcom/discord/widgets/guildscheduledevent/buttonconfiguration/ButtonConfiguration;)V", "configureInterestedButton", "configureShareButton", "configure", "configureForDetails", "Lcom/discord/databinding/GuildScheduledEventBottomButtonViewBinding;", "binding", "Lcom/discord/databinding/GuildScheduledEventBottomButtonViewBinding;", "getBinding", "()Lcom/discord/databinding/GuildScheduledEventBottomButtonViewBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventBottomButtonView extends ConstraintLayout {
    private final GuildScheduledEventBottomButtonViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventBottomButtonView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildScheduledEventBottomButtonViewBinding guildScheduledEventBottomButtonViewBindingA = GuildScheduledEventBottomButtonViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventBottomButtonViewBindingA, "GuildScheduledEventBotto…rom(context), this, true)");
        this.binding = guildScheduledEventBottomButtonViewBindingA;
    }

    private final void configureInterestedButton(ButtonConfiguration buttonConfiguration) {
        ImageView imageView = this.binding.e;
        imageView.setVisibility(buttonConfiguration.getSecondaryButtonVisible() ? 0 : 8);
        imageView.setImageResource(buttonConfiguration.getSecondaryButtonBackground());
        imageView.setOnClickListener(buttonConfiguration.getSecondaryButtonOnClickListener());
        imageView.setEnabled(buttonConfiguration.getSecondaryButtonEnabled());
        TextView textView = this.binding.f;
        textView.setVisibility(buttonConfiguration.getSecondaryButtonVisible() ? 0 : 8);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, buttonConfiguration.getSecondaryButtonTextDrawableRes(), 0, 0, 0, 14, (Object) null);
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(buttonConfiguration.secondaryButtonTextColor(context));
        Context context2 = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        textView.setText(buttonConfiguration.secondaryButtonText(context2));
    }

    private final void configureShareButton(ButtonConfiguration buttonConfiguration) {
        ImageView imageView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "this");
        imageView.setVisibility(buttonConfiguration.getIsShareVisible() ? 0 : 8);
        imageView.setOnClickListener(buttonConfiguration.getShareButtonOnClickListener());
    }

    private final void configureStartEventButton(ButtonConfiguration buttonConfiguration) {
        TextView textView = this.binding.d;
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        ViewExtensions.setTextAndVisibilityBy(textView, buttonConfiguration.primaryButtonText(context));
        textView.setVisibility(buttonConfiguration.getPrimaryButtonVisible() ? 0 : 8);
        ImageView imageView = this.binding.c;
        imageView.setVisibility(buttonConfiguration.getPrimaryButtonVisible() ? 0 : 8);
        imageView.setOnClickListener(buttonConfiguration.getPrimaryButtonOnClickListener());
    }

    public final void configure(ButtonConfiguration buttonConfiguration) {
        Intrinsics3.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        configureStartEventButton(buttonConfiguration);
        configureInterestedButton(buttonConfiguration);
        configureShareButton(buttonConfiguration);
    }

    public final void configureForDetails(ButtonConfiguration buttonConfiguration) {
        Intrinsics3.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        configureStartEventButton(buttonConfiguration);
        if (buttonConfiguration.getPrimaryButtonVisible()) {
            ImageView imageView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.secondaryButton");
            imageView.setVisibility(8);
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.secondaryButtonText");
            textView.setVisibility(8);
        } else {
            configureInterestedButton(buttonConfiguration);
        }
        configureShareButton(buttonConfiguration);
        ImageView imageView2 = this.binding.f2118b;
        imageView2.setVisibility(buttonConfiguration.getExtrasButtonOnClickListener() != null && buttonConfiguration.getIsExtrasVisible() ? 0 : 8);
        imageView2.setOnClickListener(buttonConfiguration.getExtrasButtonOnClickListener());
    }

    public final GuildScheduledEventBottomButtonViewBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventBottomButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventBottomButtonViewBinding guildScheduledEventBottomButtonViewBindingA = GuildScheduledEventBottomButtonViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventBottomButtonViewBindingA, "GuildScheduledEventBotto…rom(context), this, true)");
        this.binding = guildScheduledEventBottomButtonViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventBottomButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventBottomButtonViewBinding guildScheduledEventBottomButtonViewBindingA = GuildScheduledEventBottomButtonViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventBottomButtonViewBindingA, "GuildScheduledEventBotto…rom(context), this, true)");
        this.binding = guildScheduledEventBottomButtonViewBindingA;
    }
}
