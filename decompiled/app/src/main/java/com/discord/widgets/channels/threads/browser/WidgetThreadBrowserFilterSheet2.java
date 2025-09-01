package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetThreadBrowserFilterSheetBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetThreadBrowserFilterSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserFilterSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserFilterSheetBinding> {
    public static final WidgetThreadBrowserFilterSheet2 INSTANCE = new WidgetThreadBrowserFilterSheet2();

    public WidgetThreadBrowserFilterSheet2() {
        super(1, WidgetThreadBrowserFilterSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserFilterSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserFilterSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_profile_sheet_emojis_count;
        TextView textView = (TextView) view.findViewById(R.id.guild_profile_sheet_emojis_count);
        if (textView != null) {
            i = R.id.thread_browser_moderator_view;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.thread_browser_moderator_view);
            if (checkedSetting != null) {
                i = R.id.thread_browser_moderator_view_card;
                CardView cardView = (CardView) view.findViewById(R.id.thread_browser_moderator_view_card);
                if (cardView != null) {
                    i = R.id.thread_browser_visibility_private;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.thread_browser_visibility_private);
                    if (checkedSetting2 != null) {
                        i = R.id.thread_browser_visibility_public;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.thread_browser_visibility_public);
                        if (checkedSetting3 != null) {
                            return new WidgetThreadBrowserFilterSheetBinding((NestedScrollView) view, textView, checkedSetting, cardView, checkedSetting2, checkedSetting3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
