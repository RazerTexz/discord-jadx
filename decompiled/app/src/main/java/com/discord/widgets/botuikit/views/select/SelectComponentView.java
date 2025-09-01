package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.WidgetChatListBotUiSelectComponentBinding;
import b.a.i.WidgetChatListBotUiSelectComponentPillBinding;
import com.discord.R;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.ComponentView2;
import com.discord.widgets.botuikit.views.ComponentViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textview.MaterialTextView;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SelectComponentView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B!\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0017J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/discord/widgets/botuikit/views/ComponentView;", "Lcom/discord/models/botuikit/SelectMessageComponent;", "component", "Lcom/discord/widgets/botuikit/ComponentProvider;", "componentProvider", "Lcom/discord/widgets/botuikit/views/ComponentActionListener;", "componentActionListener", "", "configure", "(Lcom/discord/models/botuikit/SelectMessageComponent;Lcom/discord/widgets/botuikit/ComponentProvider;Lcom/discord/widgets/botuikit/views/ComponentActionListener;)V", "Lcom/discord/api/botuikit/ComponentType;", "type", "()Lcom/discord/api/botuikit/ComponentType;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SelectComponentView extends ConstraintLayout implements ComponentView<SelectMessageComponent> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: SelectComponentView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentView$Companion;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "root", "Lcom/discord/widgets/botuikit/views/select/SelectComponentView;", "inflateComponent", "(Landroid/content/Context;Landroid/view/ViewGroup;)Lcom/discord/widgets/botuikit/views/select/SelectComponentView;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final SelectComponentView inflateComponent(Context context, ViewGroup root) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(root, "root");
            WidgetChatListBotUiSelectComponentBinding widgetChatListBotUiSelectComponentBindingA = WidgetChatListBotUiSelectComponentBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_select_component, root, false));
            Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiSelectComponentBindingA, "WidgetChatListBotUiSelec…om(context), root, false)");
            SelectComponentView selectComponentView = widgetChatListBotUiSelectComponentBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(selectComponentView, "WidgetChatListBotUiSelec…ntext), root, false).root");
            return selectComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SelectComponentView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentView$configure$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ SelectMessageComponent $component;
        public final /* synthetic */ ComponentView2 $componentActionListener;
        public final /* synthetic */ String $placeholder;

        public AnonymousClass3(ComponentView2 componentView2, SelectMessageComponent selectMessageComponent, String str) {
            this.$componentActionListener = componentView2;
            this.$component = selectMessageComponent;
            this.$placeholder = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$componentActionListener.onSelectComponentClick(this.$component.getIndex(), this.$component.getCustomId(), this.$placeholder, this.$component.getOptions(), this.$component.getSelectedOptions(), this.$component.getMinValues(), this.$component.getMaxValues(), this.$component.getEmojiAnimationsEnabled());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentView2 componentView2) {
        configure((SelectMessageComponent) messageComponent, componentProvider, componentView2);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public Component6 type() {
        return Component6.SELECT;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(SelectMessageComponent component, ComponentProvider componentProvider, ComponentView2 componentActionListener) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics3.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiSelectComponentBinding widgetChatListBotUiSelectComponentBindingA = WidgetChatListBotUiSelectComponentBinding.a(this);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiSelectComponentBindingA, "WidgetChatListBotUiSelec…mponentBinding.bind(this)");
        String placeholder = component.getPlaceholder();
        if (placeholder == null) {
            placeholder = getResources().getString(R.string.message_select_component_default_placeholder);
            Intrinsics3.checkNotNullExpressionValue(placeholder, "resources.getString(R.st…nent_default_placeholder)");
        }
        if (!(!component.getSelectedOptions().isEmpty())) {
            MaterialTextView materialTextView = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.selectComponentSelectionText");
            materialTextView.setVisibility(0);
            FlexboxLayout flexboxLayout = widgetChatListBotUiSelectComponentBindingA.f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.selectComponentSelectionsRoot");
            flexboxLayout.setVisibility(8);
            widgetChatListBotUiSelectComponentBindingA.e.setTextColor(ColorCompat.getThemedColor(getContext(), R.attr.colorInteractiveNormal));
            MaterialTextView materialTextView2 = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.selectComponentSelectionText");
            materialTextView2.setText(placeholder);
        } else if (component.getMaxValues() == 1) {
            MaterialTextView materialTextView3 = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.selectComponentSelectionText");
            materialTextView3.setVisibility(0);
            FlexboxLayout flexboxLayout2 = widgetChatListBotUiSelectComponentBindingA.f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.selectComponentSelectionsRoot");
            flexboxLayout2.setVisibility(8);
            widgetChatListBotUiSelectComponentBindingA.e.setTextColor(ColorCompat.getThemedColor(getContext(), R.attr.colorTextNormal));
            SelectComponent2 selectComponent2 = (SelectComponent2) _Collections.firstOrNull((List) component.getSelectedOptions());
            if (selectComponent2 != null) {
                MaterialTextView materialTextView4 = widgetChatListBotUiSelectComponentBindingA.e;
                Intrinsics3.checkNotNullExpressionValue(materialTextView4, "binding.selectComponentSelectionText");
                materialTextView4.setText(selectComponent2.getLabel());
                ComponentViewUtils componentViewUtils = ComponentViewUtils.INSTANCE;
                SimpleDraweeView simpleDraweeView = widgetChatListBotUiSelectComponentBindingA.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.selectComponentSelectionIcon");
                componentViewUtils.setEmojiOrHide(simpleDraweeView, selectComponent2.getEmoji(), component.getEmojiAnimationsEnabled());
            }
        } else {
            FlexboxLayout flexboxLayout3 = widgetChatListBotUiSelectComponentBindingA.f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.selectComponentSelectionsRoot");
            MaterialTextView materialTextView5 = widgetChatListBotUiSelectComponentBindingA.e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView5, "binding.selectComponentSelectionText");
            materialTextView5.setVisibility(8);
            flexboxLayout3.setVisibility(0);
            flexboxLayout3.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            for (SelectComponent2 selectComponent22 : component.getSelectedOptions()) {
                View viewInflate = layoutInflaterFrom.inflate(R.layout.widget_chat_list_bot_ui_select_component_pill, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                MaterialTextView materialTextView6 = (MaterialTextView) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new WidgetChatListBotUiSelectComponentPillBinding(materialTextView6), "WidgetChatListBotUiSelec…Binding.inflate(inflater)");
                Intrinsics3.checkNotNullExpressionValue(materialTextView6, "WidgetChatListBotUiSelec…ng.inflate(inflater).root");
                materialTextView6.setText(selectComponent22.getLabel());
                flexboxLayout3.addView(materialTextView6);
            }
        }
        boolean z2 = !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled);
        boolean z3 = component.getStateInteraction() instanceof ActionInteractionComponentState.Loading;
        TypingDots typingDots = widgetChatListBotUiSelectComponentBindingA.c;
        if (z3) {
            typingDots.a(false);
        } else {
            typingDots.c();
        }
        TypingDots typingDots2 = widgetChatListBotUiSelectComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(typingDots2, "binding.selectComponentLoading");
        typingDots2.setVisibility(z3 ^ true ? 4 : 0);
        ImageView imageView = widgetChatListBotUiSelectComponentBindingA.f86b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.selectComponentChevron");
        imageView.setVisibility(z3 ? 4 : 0);
        SelectComponentView selectComponentView = widgetChatListBotUiSelectComponentBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(selectComponentView, "binding.root");
        ViewExtensions.setEnabledAlpha(selectComponentView, z2, 0.3f);
        widgetChatListBotUiSelectComponentBindingA.a.setOnClickListener(new AnonymousClass3(componentActionListener, component, placeholder));
        SelectComponentView selectComponentView2 = widgetChatListBotUiSelectComponentBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(selectComponentView2, "binding.root");
        selectComponentView2.setClickable(!z3 && z2);
    }
}
