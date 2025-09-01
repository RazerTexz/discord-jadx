package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetPreviewGuildScheduledEventBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPreviewGuildScheduledEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPreviewGuildScheduledEvent4 extends FunctionReferenceImpl implements Function1<View, WidgetPreviewGuildScheduledEventBinding> {
    public static final WidgetPreviewGuildScheduledEvent4 INSTANCE = new WidgetPreviewGuildScheduledEvent4();

    public WidgetPreviewGuildScheduledEvent4() {
        super(1, WidgetPreviewGuildScheduledEventBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPreviewGuildScheduledEventBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPreviewGuildScheduledEventBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.back_button;
        ImageView imageView = (ImageView) view.findViewById(R.id.back_button);
        if (imageView != null) {
            i = R.id.close_button;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.close_button);
            if (imageView2 != null) {
                i = R.id.confirm_guild_scheduled_event_notify;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.confirm_guild_scheduled_event_notify);
                if (checkedSetting != null) {
                    i = R.id.confirm_guild_scheduled_event_preview;
                    GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view.findViewById(R.id.confirm_guild_scheduled_event_preview);
                    if (guildScheduledEventItemView != null) {
                        i = R.id.confirm_guild_scheduled_event_subtitle;
                        TextView textView = (TextView) view.findViewById(R.id.confirm_guild_scheduled_event_subtitle);
                        if (textView != null) {
                            i = R.id.confirm_guild_scheduled_event_title;
                            TextView textView2 = (TextView) view.findViewById(R.id.confirm_guild_scheduled_event_title);
                            if (textView2 != null) {
                                i = R.id.confirm_guild_scheduled_event_toolbar;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.confirm_guild_scheduled_event_toolbar);
                                if (constraintLayout != null) {
                                    i = R.id.create_event_subtitle;
                                    TextView textView3 = (TextView) view.findViewById(R.id.create_event_subtitle);
                                    if (textView3 != null) {
                                        i = R.id.guild_scheduled_event_settings_next_button;
                                        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_scheduled_event_settings_next_button);
                                        if (materialButton != null) {
                                            i = R.id.step_text;
                                            TextView textView4 = (TextView) view.findViewById(R.id.step_text);
                                            if (textView4 != null) {
                                                return new WidgetPreviewGuildScheduledEventBinding((ConstraintLayout) view, imageView, imageView2, checkedSetting, guildScheduledEventItemView, textView, textView2, constraintLayout, textView3, materialButton, textView4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
