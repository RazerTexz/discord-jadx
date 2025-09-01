package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGuildScheduledEventListBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventListBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildScheduledEventListBottomSheetBinding> {
    public static final WidgetGuildScheduledEventListBottomSheet2 INSTANCE = new WidgetGuildScheduledEventListBottomSheet2();

    public WidgetGuildScheduledEventListBottomSheet2() {
        super(1, WidgetGuildScheduledEventListBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventListBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventListBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.create_event_button;
        TextView textView = (TextView) view.findViewById(R.id.create_event_button);
        if (textView != null) {
            i = R.id.guild_scheduled_event_list_empty_state;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.guild_scheduled_event_list_empty_state);
            if (constraintLayout != null) {
                i = R.id.guild_scheduled_event_list_empty_state_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.guild_scheduled_event_list_empty_state_icon);
                if (imageView != null) {
                    i = R.id.guild_scheduled_event_list_empty_state_subtitle;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_scheduled_event_list_empty_state_subtitle);
                    if (textView2 != null) {
                        i = R.id.guild_scheduled_event_list_empty_state_title;
                        TextView textView3 = (TextView) view.findViewById(R.id.guild_scheduled_event_list_empty_state_title);
                        if (textView3 != null) {
                            i = R.id.guild_scheduled_event_list_recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_scheduled_event_list_recycler_view);
                            if (recyclerView != null) {
                                i = R.id.guild_scheduled_event_list_toolbar_container;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.guild_scheduled_event_list_toolbar_container);
                                if (constraintLayout2 != null) {
                                    i = R.id.guild_scheduled_event_list_toolbar_title;
                                    TextView textView4 = (TextView) view.findViewById(R.id.guild_scheduled_event_list_toolbar_title);
                                    if (textView4 != null) {
                                        return new WidgetGuildScheduledEventListBottomSheetBinding((ConstraintLayout) view, textView, constraintLayout, imageView, textView2, textView3, recyclerView, constraintLayout2, textView4);
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
