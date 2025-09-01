package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventDetailsExtrasBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding> {
    public static final WidgetGuildScheduledEventDetailsExtrasBottomSheet3 INSTANCE = new WidgetGuildScheduledEventDetailsExtrasBottomSheet3();

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet3() {
        super(1, WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.cancel_event;
        TextView textView = (TextView) view.findViewById(R.id.cancel_event);
        if (textView != null) {
            i = R.id.copy_id;
            TextView textView2 = (TextView) view.findViewById(R.id.copy_id);
            if (textView2 != null) {
                i = R.id.edit_event;
                TextView textView3 = (TextView) view.findViewById(R.id.edit_event);
                if (textView3 != null) {
                    i = R.id.end_event;
                    TextView textView4 = (TextView) view.findViewById(R.id.end_event);
                    if (textView4 != null) {
                        i = R.id.interested_toggle;
                        TextView textView5 = (TextView) view.findViewById(R.id.interested_toggle);
                        if (textView5 != null) {
                            i = R.id.report_event;
                            TextView textView6 = (TextView) view.findViewById(R.id.report_event);
                            if (textView6 != null) {
                                i = R.id.start_event;
                                TextView textView7 = (TextView) view.findViewById(R.id.start_event);
                                if (textView7 != null) {
                                    return new WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding((NestedScrollView) view, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
