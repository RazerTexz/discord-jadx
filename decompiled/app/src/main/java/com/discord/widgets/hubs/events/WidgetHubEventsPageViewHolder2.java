package com.discord.widgets.hubs.events;

import android.content.res.Resources;
import android.view.View;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventViewHolder;", "Lcom/discord/widgets/hubs/events/WidgetHubEventsPageViewHolder;", "Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "eventData", "", "bind", "(Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;)V", "Lcom/discord/databinding/WidgetHubEventBinding;", "binding", "Lcom/discord/databinding/WidgetHubEventBinding;", "getBinding", "()Lcom/discord/databinding/WidgetHubEventBinding;", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "listener", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "getListener", "()Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "<init>", "(Lcom/discord/databinding/WidgetHubEventBinding;Lcom/discord/widgets/hubs/events/HubEventsEventListener;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder2 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass1(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onCardClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass2(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onSecondaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass3(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onPrimaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass4(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onShareClicked(this.$eventData);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder2(WidgetHubEventBinding widgetHubEventBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        GuildScheduledEventItemView guildScheduledEventItemView = widgetHubEventBinding.a;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.root");
        super(guildScheduledEventItemView, null);
        this.binding = widgetHubEventBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind(WidgetHubEventsViewModel2 eventData) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        this.binding.f2474b.configureInDirectoryEventList(eventData, new AnonymousClass1(eventData), new AnonymousClass2(eventData), new AnonymousClass3(eventData), new AnonymousClass4(eventData));
    }

    public final WidgetHubEventBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
