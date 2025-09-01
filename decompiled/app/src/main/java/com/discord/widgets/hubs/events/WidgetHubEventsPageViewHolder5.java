package com.discord.widgets.hubs.events;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.WidgetHubEventsHeaderBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsPageHeaderViewHolder;", "Lcom/discord/widgets/hubs/events/WidgetHubEventsPageViewHolder;", "", "bind", "()V", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "listener", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "getListener", "()Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "Lcom/discord/databinding/WidgetHubEventsHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetHubEventsHeaderBinding;", "getBinding", "()Lcom/discord/databinding/WidgetHubEventsHeaderBinding;", "<init>", "(Lcom/discord/databinding/WidgetHubEventsHeaderBinding;Lcom/discord/widgets/hubs/events/HubEventsEventListener;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPageHeaderViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder5 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsHeaderBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder5(WidgetHubEventsHeaderBinding widgetHubEventsHeaderBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventsHeaderBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        ConstraintLayout constraintLayout = widgetHubEventsHeaderBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.binding = widgetHubEventsHeaderBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind() {
        this.binding.f2476b.setOnClickListener(new WidgetHubEventsPageViewHolder6(this));
    }

    public final WidgetHubEventsHeaderBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
