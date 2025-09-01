package com.discord.widgets.botuikit;

import android.content.Context;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.ComponentView2;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ComponentProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/botuikit/ComponentProvider;", "", "Lcom/discord/widgets/botuikit/views/ComponentActionListener;", "listener", "Lcom/discord/models/botuikit/MessageComponent;", "component", "Lcom/discord/widgets/botuikit/views/ComponentView;", "componentView", "", "configureView", "(Lcom/discord/widgets/botuikit/views/ComponentActionListener;Lcom/discord/models/botuikit/MessageComponent;Lcom/discord/widgets/botuikit/views/ComponentView;)V", "Landroid/view/ViewGroup;", "root", "", "childIndex", "getConfiguredComponentView", "(Lcom/discord/widgets/botuikit/views/ComponentActionListener;Lcom/discord/models/botuikit/MessageComponent;Landroid/view/ViewGroup;I)Lcom/discord/widgets/botuikit/views/ComponentView;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ComponentProvider {
    private final Context context;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Component6.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[Component6.ACTION_ROW.ordinal()] = 1;
            iArr[Component6.BUTTON.ordinal()] = 2;
            iArr[Component6.SELECT.ordinal()] = 3;
            iArr[Component6.UNKNOWN.ordinal()] = 4;
        }
    }

    public ComponentProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final void configureView(ComponentView2 listener, MessageComponent component, ComponentView<?> componentView) {
        int iOrdinal = component.getType().ordinal();
        if (iOrdinal == 1) {
            Objects.requireNonNull(componentView, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.ActionRowComponentView");
            ((ActionRowComponentView) componentView).configure((ActionRowMessageComponent) component, this, listener);
        } else if (iOrdinal == 2) {
            Objects.requireNonNull(componentView, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.ButtonComponentView");
            ((ButtonComponentView) componentView).configure((ButtonMessageComponent) component, this, listener);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            Objects.requireNonNull(componentView, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.select.SelectComponentView");
            ((SelectComponentView) componentView).configure((SelectMessageComponent) component, this, listener);
        }
    }

    public final ComponentView<? extends MessageComponent> getConfiguredComponentView(ComponentView2 listener, MessageComponent component, ViewGroup root, int childIndex) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(root, "root");
        ComponentInflater componentInflaterFrom = ComponentInflater.INSTANCE.from(this.context);
        KeyEvent.Callback childAt = root.getChildAt(childIndex);
        if (childAt != null && (childAt instanceof ComponentView)) {
            ComponentView<? extends MessageComponent> componentView = (ComponentView) childAt;
            if (componentView.type() == component.getType()) {
                configureView(listener, component, componentView);
                return componentView;
            }
        }
        ComponentView<? extends MessageComponent> componentViewInflateComponent = componentInflaterFrom.inflateComponent(component.getType(), root);
        if (componentViewInflateComponent == null) {
            return null;
        }
        configureView(listener, component, componentViewInflateComponent);
        return componentViewInflateComponent;
    }

    public final Context getContext() {
        return this.context;
    }
}
