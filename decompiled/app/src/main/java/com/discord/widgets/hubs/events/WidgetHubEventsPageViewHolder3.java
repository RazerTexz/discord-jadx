package com.discord.widgets.hubs.events;

import android.widget.LinearLayout;
import com.discord.databinding.WidgetHubEventsFooterBinding;
import com.discord.stores.utilities.RestCallState4;
import com.discord.views.LoadingButton;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsPageFooterViewHolder;", "Lcom/discord/widgets/hubs/events/WidgetHubEventsPageViewHolder;", "Lcom/discord/widgets/hubs/events/HubEventsPage$Footer;", "footer", "", "bind", "(Lcom/discord/widgets/hubs/events/HubEventsPage$Footer;)V", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "listener", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "getListener", "()Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "Lcom/discord/databinding/WidgetHubEventsFooterBinding;", "binding", "Lcom/discord/databinding/WidgetHubEventsFooterBinding;", "getBinding", "()Lcom/discord/databinding/WidgetHubEventsFooterBinding;", "<init>", "(Lcom/discord/databinding/WidgetHubEventsFooterBinding;Lcom/discord/widgets/hubs/events/HubEventsEventListener;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPageFooterViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder3 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsFooterBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder3(WidgetHubEventsFooterBinding widgetHubEventsFooterBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventsFooterBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        LinearLayout linearLayout = widgetHubEventsFooterBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = widgetHubEventsFooterBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind(WidgetHubEventsPageAdapter2.Footer footer) {
        Intrinsics3.checkNotNullParameter(footer, "footer");
        LoadingButton loadingButton = this.binding.f2475b;
        loadingButton.setOnClickListener(new WidgetHubEventsPageViewHolder4(this, footer));
        loadingButton.setIsLoading(footer.getEventsAsync() instanceof RestCallState4);
    }

    public final WidgetHubEventsFooterBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
