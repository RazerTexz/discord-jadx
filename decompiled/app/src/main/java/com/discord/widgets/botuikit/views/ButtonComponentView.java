package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.discord.R;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.databinding.WidgetChatListBotUiButtonComponentBinding;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ButtonComponentView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00011B!\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/B\u0019\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b.\u00100J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'¨\u00062"}, d2 = {"Lcom/discord/widgets/botuikit/views/ButtonComponentView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/discord/widgets/botuikit/views/ComponentView;", "Lcom/discord/models/botuikit/ButtonMessageComponent;", "Landroid/widget/TextView;", "label", "messageComponent", "", "configureLabelPadding", "(Landroid/widget/TextView;Lcom/discord/models/botuikit/ButtonMessageComponent;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "emojiView", "Lcom/discord/api/botuikit/ComponentEmoji;", "emoji", "", "isLoading", "emojiAnimationsEnabled", "configureEmoji", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/discord/api/botuikit/ComponentEmoji;ZZ)V", "Landroid/widget/ImageView;", "icon", "showIcon", "configureLinkIcon", "(Landroid/widget/ImageView;Z)V", "component", "Lcom/discord/widgets/botuikit/ComponentProvider;", "componentProvider", "Lcom/discord/widgets/botuikit/views/ComponentActionListener;", "componentActionListener", "configure", "(Lcom/discord/models/botuikit/ButtonMessageComponent;Lcom/discord/widgets/botuikit/ComponentProvider;Lcom/discord/widgets/botuikit/views/ComponentActionListener;)V", "Landroid/widget/Button;", "button", "Lcom/discord/api/botuikit/ButtonStyle;", "style", "configureStyle", "(Landroid/widget/Button;Lcom/discord/api/botuikit/ButtonStyle;)V", "Lcom/discord/api/botuikit/ComponentType;", "type", "()Lcom/discord/api/botuikit/ComponentType;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ButtonComponentView extends ConstraintLayout implements ComponentView<ButtonMessageComponent> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ButtonComponentView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/botuikit/views/ButtonComponentView$Companion;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "root", "Lcom/discord/widgets/botuikit/views/ButtonComponentView;", "inflateComponent", "(Landroid/content/Context;Landroid/view/ViewGroup;)Lcom/discord/widgets/botuikit/views/ButtonComponentView;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ButtonComponentView inflateComponent(Context context, ViewGroup root) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(root, "root");
            WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_button_component, root, false));
            Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…om(context), root, false)");
            ButtonComponentView buttonComponentView = widgetChatListBotUiButtonComponentBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(buttonComponentView, "WidgetChatListBotUiButto…ntext), root, false).root");
            return buttonComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonComponent2.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[ButtonComponent2.UNKNOWN.ordinal()] = 1;
            iArr[ButtonComponent2.PRIMARY.ordinal()] = 2;
            iArr[ButtonComponent2.SECONDARY.ordinal()] = 3;
            iArr[ButtonComponent2.LINK.ordinal()] = 4;
            iArr[ButtonComponent2.DANGER.ordinal()] = 5;
            iArr[ButtonComponent2.SUCCESS.ordinal()] = 6;
        }
    }

    /* compiled from: ButtonComponentView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.views.ButtonComponentView$configure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetChatListBotUiButtonComponentBinding $binding;
        public final /* synthetic */ ButtonMessageComponent $component;
        public final /* synthetic */ ComponentView2 $componentActionListener;

        public AnonymousClass1(ButtonMessageComponent buttonMessageComponent, WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBinding, ComponentView2 componentView2) {
            this.$component = buttonMessageComponent;
            this.$binding = widgetChatListBotUiButtonComponentBinding;
            this.$componentActionListener = componentView2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$component.getUrl() == null) {
                if (this.$component.getCustomId() != null) {
                    this.$componentActionListener.onButtonComponentClick(this.$component.getIndex(), this.$component.getCustomId());
                }
            } else {
                MaterialButton materialButton = this.$binding.f2344b;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.button");
                Context context = materialButton.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.button.context");
                UriHandler.handleOrUntrusted$default(context, this.$component.getUrl(), null, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    private final void configureEmoji(SimpleDraweeView emojiView, ComponentEmoji emoji, boolean isLoading, boolean emojiAnimationsEnabled) {
        if (emoji == null || !isLoading) {
            ComponentViewUtils.INSTANCE.setEmojiOrHide(emojiView, emoji, emojiAnimationsEnabled);
        } else {
            emojiView.setVisibility(4);
        }
    }

    private final void configureLabelPadding(TextView label, ButtonMessageComponent messageComponent) {
        if (messageComponent.getLabel() == null) {
            label.setPadding(0, 0, (ButtonComponentView2.hasEmoji(messageComponent) && ButtonComponentView2.hasIcon(messageComponent)) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        } else {
            label.setPadding(ButtonComponentView2.hasEmoji(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0, ButtonComponentView2.hasIcon(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        }
    }

    private final void configureLinkIcon(ImageView icon, boolean showIcon) {
        icon.setVisibility(showIcon ? 0 : 8);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentView2 componentView2) {
        configure((ButtonMessageComponent) messageComponent, componentProvider, componentView2);
    }

    public final void configureStyle(Button button, ButtonComponent2 style) {
        Intrinsics3.checkNotNullParameter(button, "button");
        Intrinsics3.checkNotNullParameter(style, "style");
        int iOrdinal = style.ordinal();
        int i = R.color.uikit_btn_bg_color_selector_secondary;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                i = R.color.uikit_btn_bg_color_selector_brand;
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    i = R.color.uikit_btn_bg_color_selector_green;
                } else if (iOrdinal == 4) {
                    i = R.color.uikit_btn_bg_color_selector_red;
                } else if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        Resources resources = getResources();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        ViewCompat.setBackgroundTintList(button, ResourcesCompat.getColorStateList(resources, i, context.getTheme()));
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public Component6 type() {
        return Component6.BUTTON;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(ButtonMessageComponent component, ComponentProvider componentProvider, ComponentView2 componentActionListener) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics3.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(this);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…mponentBinding.bind(this)");
        MaterialButton materialButton = widgetChatListBotUiButtonComponentBindingA.f2344b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.button");
        configureStyle(materialButton, component.getStyle());
        SimpleDraweeView simpleDraweeView = widgetChatListBotUiButtonComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.emoji");
        configureEmoji(simpleDraweeView, component.getEmoji(), component.getStateInteraction() instanceof ActionInteractionComponentState.Loading, component.getEmojiAnimationsEnabled());
        AppCompatImageView appCompatImageView = widgetChatListBotUiButtonComponentBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.linkIcon");
        configureLinkIcon(appCompatImageView, component.getStyle() == ButtonComponent2.LINK);
        MaterialTextView materialTextView = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.label");
        configureLabelPadding(materialTextView, component);
        MaterialTextView materialTextView2 = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.label");
        ViewExtensions.setEnabledAlpha(materialTextView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.5f);
        SimpleDraweeView simpleDraweeView2 = widgetChatListBotUiButtonComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.emoji");
        ViewExtensions.setEnabledAlpha$default(simpleDraweeView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        AppCompatImageView appCompatImageView2 = widgetChatListBotUiButtonComponentBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.linkIcon");
        ViewExtensions.setEnabledAlpha$default(appCompatImageView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        MaterialButton materialButton2 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.button");
        materialButton2.setEnabled(!(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled));
        MaterialTextView materialTextView3 = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.label");
        materialTextView3.setText(component.getLabel());
        MaterialTextView materialTextView4 = widgetChatListBotUiButtonComponentBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView4, "binding.label");
        materialTextView4.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 4 : 0);
        widgetChatListBotUiButtonComponentBindingA.f2344b.setOnClickListener(new AnonymousClass1(component, widgetChatListBotUiButtonComponentBindingA, componentActionListener));
        TypingDots typingDots = widgetChatListBotUiButtonComponentBindingA.f;
        Intrinsics3.checkNotNullExpressionValue(typingDots, "binding.loadingDots");
        typingDots.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 0 : 8);
        if (component.getStateInteraction() instanceof ActionInteractionComponentState.Loading) {
            widgetChatListBotUiButtonComponentBindingA.f.a(false);
            MaterialButton materialButton3 = widgetChatListBotUiButtonComponentBindingA.f2344b;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.button");
            materialButton3.setClickable(false);
            return;
        }
        widgetChatListBotUiButtonComponentBindingA.f.c();
        MaterialButton materialButton4 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.button");
        materialButton4.setClickable(true);
    }
}
