package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.GuildEventPromptListViewBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildEventPromptListView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u000f\u0010\u0016J=\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildEventPromptListView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/guildscheduledevent/GuildEventPromptListView$ScheduledEventData;", "scheduledEventData", "Lkotlin/Function0;", "", "onCreateEventClick", "onStartStageClick", "configure", "(Lcom/discord/widgets/guildscheduledevent/GuildEventPromptListView$ScheduledEventData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/GuildEventPromptListViewBinding;", "binding", "Lcom/discord/databinding/GuildEventPromptListViewBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ScheduledEventData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildEventPromptListView extends LinearLayout {
    private final GuildEventPromptListViewBinding binding;

    /* compiled from: GuildEventPromptListView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildEventPromptListView$ScheduledEventData;", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lkotlin/Function0;", "", "component2", "()Lkotlin/jvm/functions/Function0;", "guildScheduledEvent", "onScheduledEventClick", "copy", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lkotlin/jvm/functions/Function0;)Lcom/discord/widgets/guildscheduledevent/GuildEventPromptListView$ScheduledEventData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function0;", "getOnScheduledEventClick", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "<init>", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ScheduledEventData {
        private final GuildScheduledEvent guildScheduledEvent;
        private final Function0<Unit> onScheduledEventClick;

        public ScheduledEventData(GuildScheduledEvent guildScheduledEvent, Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            Intrinsics3.checkNotNullParameter(function0, "onScheduledEventClick");
            this.guildScheduledEvent = guildScheduledEvent;
            this.onScheduledEventClick = function0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScheduledEventData copy$default(ScheduledEventData scheduledEventData, GuildScheduledEvent guildScheduledEvent, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                guildScheduledEvent = scheduledEventData.guildScheduledEvent;
            }
            if ((i & 2) != 0) {
                function0 = scheduledEventData.onScheduledEventClick;
            }
            return scheduledEventData.copy(guildScheduledEvent, function0);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final Function0<Unit> component2() {
            return this.onScheduledEventClick;
        }

        public final ScheduledEventData copy(GuildScheduledEvent guildScheduledEvent, Function0<Unit> onScheduledEventClick) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            Intrinsics3.checkNotNullParameter(onScheduledEventClick, "onScheduledEventClick");
            return new ScheduledEventData(guildScheduledEvent, onScheduledEventClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduledEventData)) {
                return false;
            }
            ScheduledEventData scheduledEventData = (ScheduledEventData) other;
            return Intrinsics3.areEqual(this.guildScheduledEvent, scheduledEventData.guildScheduledEvent) && Intrinsics3.areEqual(this.onScheduledEventClick, scheduledEventData.onScheduledEventClick);
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final Function0<Unit> getOnScheduledEventClick() {
            return this.onScheduledEventClick;
        }

        public int hashCode() {
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.onScheduledEventClick;
            return iHashCode + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ScheduledEventData(guildScheduledEvent=");
            sbU.append(this.guildScheduledEvent);
            sbU.append(", onScheduledEventClick=");
            sbU.append(this.onScheduledEventClick);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(GuildEventPromptListView guildEventPromptListView, ScheduledEventData scheduledEventData, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            scheduledEventData = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        guildEventPromptListView.configure(scheduledEventData, function0, function02);
    }

    public final void configure(ScheduledEventData scheduledEventData, Function0<Unit> onCreateEventClick, Function0<Unit> onStartStageClick) {
        GuildEventPromptView guildEventPromptView = this.binding.d;
        guildEventPromptView.setVisibility(onStartStageClick != null ? 0 : 8);
        String string = guildEventPromptView.getContext().getString(R.string.stage_channel_start_title);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…tage_channel_start_title)");
        String string2 = guildEventPromptView.getContext().getString(R.string.stage_channel_start_subtitle);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_channel_start_subtitle)");
        guildEventPromptView.configure(R.drawable.ic_channel_stage_24dp, R.color.status_green_600, string, string2);
        guildEventPromptView.setOnClickListener(new GuildEventPromptListView2(onStartStageClick));
        GuildEventPromptView guildEventPromptView2 = this.binding.f2116b;
        guildEventPromptView2.setVisibility(onCreateEventClick != null ? 0 : 8);
        String string3 = guildEventPromptView2.getContext().getString(R.string.schedule_event);
        Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.string.schedule_event)");
        String string4 = guildEventPromptView2.getContext().getString(R.string.schedule_event_description);
        Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.stri…hedule_event_description)");
        guildEventPromptView2.configure(R.drawable.ic_event_20dp, R.color.brand_new_500, string3, string4);
        guildEventPromptView2.setOnClickListener(new GuildEventPromptListView3(onCreateEventClick));
        GuildEventPromptView guildEventPromptView3 = this.binding.c;
        guildEventPromptView3.setVisibility(scheduledEventData != null ? 0 : 8);
        if (scheduledEventData != null) {
            GuildScheduledEvent guildScheduledEvent = scheduledEventData.getGuildScheduledEvent();
            String name = guildScheduledEvent.getName();
            Context context = guildEventPromptView3.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            guildEventPromptView3.configure(R.drawable.ic_event_20dp, R.color.status_green_600, name, GuildScheduledEventUtilities5.getEventStartingTimeString(guildScheduledEvent, context));
            guildEventPromptView3.setOnClickListener(new GuildEventPromptListView4(scheduledEventData));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }
}
