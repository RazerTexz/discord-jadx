package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelSettingsAddMemberSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSettingsAddMemberSheetBinding> {
    public static final WidgetChannelSettingsAddMemberSheet2 INSTANCE = new WidgetChannelSettingsAddMemberSheet2();

    public WidgetChannelSettingsAddMemberSheet2() {
        super(1, WidgetChannelSettingsAddMemberSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsAddMemberSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_button;
        TextView textView = (TextView) view.findViewById(R.id.add_button);
        if (textView != null) {
            i = R.id.content;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.content);
            if (fragmentContainerView != null) {
                i = R.id.subtitle;
                TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                if (textView2 != null) {
                    i = R.id.title;
                    TextView textView3 = (TextView) view.findViewById(R.id.title);
                    if (textView3 != null) {
                        return new WidgetChannelSettingsAddMemberSheetBinding((LinearLayout) view, textView, fragmentContainerView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
