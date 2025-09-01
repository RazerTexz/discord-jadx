package com.discord.widgets.user;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetUserMentionsFilterBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$WidgetUserMentionFilter$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetUserMentionsFilterBinding> {
    public static final WidgetUserMentions$WidgetUserMentionFilter$binding$2 INSTANCE = new WidgetUserMentions$WidgetUserMentionFilter$binding$2();

    public WidgetUserMentions$WidgetUserMentionFilter$binding$2() {
        super(1, WidgetUserMentionsFilterBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserMentionsFilterBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.user_mentions_filter_include_everyone;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.user_mentions_filter_include_everyone);
        if (checkedSetting != null) {
            i = R.id.user_mentions_filter_include_roles;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.user_mentions_filter_include_roles);
            if (checkedSetting2 != null) {
                i = R.id.user_mentions_filter_this_server;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.user_mentions_filter_this_server);
                if (checkedSetting3 != null) {
                    return new WidgetUserMentionsFilterBinding((NestedScrollView) view, checkedSetting, checkedSetting2, checkedSetting3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserMentionsFilterBinding invoke(View view) {
        return invoke2(view);
    }
}
