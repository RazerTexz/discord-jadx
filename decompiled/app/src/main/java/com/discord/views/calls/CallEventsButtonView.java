package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import b.a.i.ViewCallEventsButtonBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: CallEventsButtonView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\n\u0010\r\u001a\u00060\tj\u0002`\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/discord/views/calls/CallEventsButtonView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "", "setContentColor", "(I)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "events", "a", "(Landroidx/fragment/app/FragmentManager;JJLjava/util/List;)V", "Lb/a/i/a2;", "j", "Lb/a/i/a2;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CallEventsButtonView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewCallEventsButtonBinding binding;

    /* compiled from: CallEventsButtonView.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FragmentManager j;
        public final /* synthetic */ long k;
        public final /* synthetic */ long l;

        public a(FragmentManager fragmentManager, long j, long j2) {
            this.j = fragmentManager;
            this.k = j;
            this.l = j2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventListBottomSheet.INSTANCE.show(this.j, this.k, Long.valueOf(this.l));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallEventsButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_call_events_button, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
        if (imageView != null) {
            i = R.id.text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.text);
            if (textView != null) {
                ViewCallEventsButtonBinding viewCallEventsButtonBinding = new ViewCallEventsButtonBinding((ConstraintLayout) viewInflate, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewCallEventsButtonBinding, "ViewCallEventsButtonBind…rom(context), this, true)");
                this.binding = viewCallEventsButtonBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void setContentColor(int color) {
        this.binding.c.setTextColor(color);
        ImageView imageView = this.binding.f75b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.icon");
        ColorCompat2.tintWithColor(imageView, color);
    }

    public final void a(FragmentManager fragmentManager, long guildId, long channelId, List<GuildScheduledEvent> events) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(events, "events");
        this.binding.a.setOnClickListener(new a(fragmentManager, guildId, channelId));
        boolean zHasLiveEvent = GuildScheduledEventUtilities5.hasLiveEvent(events);
        if (zHasLiveEvent) {
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.text");
            textView.setText(getContext().getString(R.string.live_event));
            setContentColor(ContextCompat.getColor(getContext(), R.color.status_green_560));
            return;
        }
        if (zHasLiveEvent) {
            return;
        }
        int size = events.size();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(context, R.plurals.guild_events_plural_number, size, Integer.valueOf(size));
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.text");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        textView2.setText(FormatUtils.h(context2, R.string.guild_events_plural, new Object[]{i18nPluralString}, null, 4));
        setContentColor(ContextCompat.getColor(getContext(), R.color.white));
    }
}
