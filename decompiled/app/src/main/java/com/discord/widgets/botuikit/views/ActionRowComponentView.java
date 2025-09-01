package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewInteractionFailedLabelBinding;
import b.a.i.WidgetChatListBotUiActionRowComponentBinding;
import com.discord.R;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.MessageComponent4;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBotComponentRow2;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ActionRowComponentView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B!\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0017J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/botuikit/views/ActionRowComponentView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/botuikit/views/ComponentView;", "Lcom/discord/models/botuikit/ActionRowMessageComponent;", "component", "Lcom/discord/widgets/botuikit/ComponentProvider;", "componentProvider", "Lcom/discord/widgets/botuikit/views/ComponentActionListener;", "componentActionListener", "", "configure", "(Lcom/discord/models/botuikit/ActionRowMessageComponent;Lcom/discord/widgets/botuikit/ComponentProvider;Lcom/discord/widgets/botuikit/views/ComponentActionListener;)V", "Lcom/discord/api/botuikit/ComponentType;", "type", "()Lcom/discord/api/botuikit/ComponentType;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ActionRowComponentView extends LinearLayout implements ComponentView<ActionRowMessageComponent> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ActionRowComponentView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/botuikit/views/ActionRowComponentView$Companion;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "root", "Lcom/discord/widgets/botuikit/views/ActionRowComponentView;", "inflateComponent", "(Landroid/content/Context;Landroid/view/ViewGroup;)Lcom/discord/widgets/botuikit/views/ActionRowComponentView;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ActionRowComponentView inflateComponent(Context context, ViewGroup root) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(root, "root");
            WidgetChatListBotUiActionRowComponentBinding widgetChatListBotUiActionRowComponentBindingA = WidgetChatListBotUiActionRowComponentBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_action_row_component, root, false));
            Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiActionRowComponentBindingA, "WidgetChatListBotUiActio…om(context), root, false)");
            ActionRowComponentView actionRowComponentView = widgetChatListBotUiActionRowComponentBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(actionRowComponentView, "WidgetChatListBotUiActio…ntext), root, false).root");
            return actionRowComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentView2 componentView2) {
        configure((ActionRowMessageComponent) messageComponent, componentProvider, componentView2);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public Component6 type() {
        return Component6.ACTION_ROW;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(ActionRowMessageComponent component, ComponentProvider componentProvider, ComponentView2 componentActionListener) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics3.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiActionRowComponentBinding widgetChatListBotUiActionRowComponentBindingA = WidgetChatListBotUiActionRowComponentBinding.a(this);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiActionRowComponentBindingA, "WidgetChatListBotUiActio…mponentBinding.bind(this)");
        List<MessageComponent> components = component.getComponents();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(components, 10));
        int i = 0;
        for (Object obj : components) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(componentProvider.getConfiguredComponentView(componentActionListener, (MessageComponent) obj, this, i));
            i = i2;
        }
        FlexboxLayout flexboxLayout = widgetChatListBotUiActionRowComponentBindingA.f78b;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.actionRowComponentViewGroup");
        WidgetChatListAdapterItemBotComponentRow2.replaceViews(flexboxLayout, _Collections.filterNotNull(arrayList));
        ActionInteractionComponentState.Failed childError = MessageComponent4.INSTANCE.getChildError(component);
        ViewInteractionFailedLabelBinding viewInteractionFailedLabelBinding = widgetChatListBotUiActionRowComponentBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(viewInteractionFailedLabelBinding, "binding.actionRowComponentViewGroupErrorRow");
        ConstraintLayout constraintLayout = viewInteractionFailedLabelBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.actionRowComponentViewGroupErrorRow.root");
        constraintLayout.setVisibility(childError != null ? 0 : 8);
        if (childError != null) {
            String errorMessage = childError.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = getResources().getString(R.string.application_command_failed);
                Intrinsics3.checkNotNullExpressionValue(errorMessage, "resources.getString(R.st…plication_command_failed)");
            }
            TextView textView = widgetChatListBotUiActionRowComponentBindingA.c.f159b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.actionRowCompone…ractionFailedLabelMessage");
            textView.setText(errorMessage);
        }
    }
}
