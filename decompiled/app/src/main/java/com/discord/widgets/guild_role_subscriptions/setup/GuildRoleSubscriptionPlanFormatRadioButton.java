package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildRoleSubscriptionPlanFormatRadioButton.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001d\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001bB'\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001dJ\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanFormatRadioButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/Checkable;", "Landroid/util/AttributeSet;", "attrs", "", "initialize", "(Landroid/util/AttributeSet;)V", "", "formatType", "configureUI", "(I)V", "", "checked", "setChecked", "(Z)V", "isChecked", "()Z", "toggle", "()V", "Lcom/discord/databinding/ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding;", "binding", "Lcom/discord/databinding/ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanFormatRadioButton extends ConstraintLayout implements Checkable {
    private static final int ENTIRE_SERVER_FORMAT_TYPE = 0;
    private static final int SOME_CHANNELS_FORMAT_TYPE = 1;
    private final ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context) throws Resources.NotFoundException {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA;
        initialize$default(this, null, 1, null);
    }

    private final void configureUI(int formatType) {
        if (formatType == 0) {
            this.binding.d.setText(R.string.guild_role_subscription_format_all_channels_name);
            this.binding.c.setText(R.string.guild_role_subscription_format_all_channels_description);
            this.binding.e.setImageResource(R.drawable.ic_key_24dp);
        } else {
            if (formatType != 1) {
                return;
            }
            this.binding.d.setText(R.string.guild_role_subscription_format_some_channels_name);
            this.binding.c.setText(R.string.guild_role_subscription_format_some_channels_description);
            this.binding.e.setImageResource(R.drawable.ic_channel_text);
        }
    }

    private final void initialize(AttributeSet attrs) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_setup_default_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_guild_role_subscription_plan_format_radio_button));
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.a.GuildRoleSubscriptionPlanFormatRadioButton;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.GuildRoleSub…tionPlanFormatRadioButton");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        configureUI(typedArrayObtainStyledAttributes.getInt(0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void initialize$default(GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton, AttributeSet attributeSet, int i, Object obj) throws Resources.NotFoundException {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildRoleSubscriptionPlanFormatRadioButton.initialize(attributeSet);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        MaterialRadioButton materialRadioButton = this.binding.f2197b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionPlanFormatButton");
        return materialRadioButton.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        setSelected(checked);
        ImageView imageView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildRoleSubscriptionPlanFormatImage");
        imageView.setSelected(checked);
        MaterialRadioButton materialRadioButton = this.binding.f2197b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionPlanFormatButton");
        materialRadioButton.setChecked(checked);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isSelected());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
