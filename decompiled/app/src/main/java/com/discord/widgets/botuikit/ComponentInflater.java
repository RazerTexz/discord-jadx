package com.discord.widgets.botuikit;

import android.content.Context;
import android.view.ViewGroup;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.MessageComponent;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComponentInflater.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/botuikit/ComponentInflater;", "", "Lcom/discord/api/botuikit/ComponentType;", "component", "Landroid/view/ViewGroup;", "root", "Lcom/discord/widgets/botuikit/views/ComponentView;", "Lcom/discord/models/botuikit/MessageComponent;", "inflateComponent", "(Lcom/discord/api/botuikit/ComponentType;Landroid/view/ViewGroup;)Lcom/discord/widgets/botuikit/views/ComponentView;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ComponentInflater {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    /* compiled from: ComponentInflater.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/botuikit/ComponentInflater$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/botuikit/ComponentInflater;", "from", "(Landroid/content/Context;)Lcom/discord/widgets/botuikit/ComponentInflater;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ComponentInflater from(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return new ComponentInflater(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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
            iArr[Component6.TEXT.ordinal()] = 4;
            iArr[Component6.UNKNOWN.ordinal()] = 5;
        }
    }

    public ComponentInflater(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ComponentView<? extends MessageComponent> inflateComponent(Component6 component, ViewGroup root) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(root, "root");
        int iOrdinal = component.ordinal();
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal == 1) {
            return ActionRowComponentView.INSTANCE.inflateComponent(this.context, root);
        }
        if (iOrdinal == 2) {
            return ButtonComponentView.INSTANCE.inflateComponent(this.context, root);
        }
        if (iOrdinal == 3) {
            return SelectComponentView.INSTANCE.inflateComponent(this.context, root);
        }
        if (iOrdinal == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
