package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildInviteShareEmptySuggestionsBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShareEmptySuggestions2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildInviteShareEmptySuggestionsBinding> {
    public static final WidgetGuildInviteShareEmptySuggestions2 INSTANCE = new WidgetGuildInviteShareEmptySuggestions2();

    public WidgetGuildInviteShareEmptySuggestions2() {
        super(1, WidgetGuildInviteShareEmptySuggestionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareEmptySuggestionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteShareEmptySuggestionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.bottom_sheet_tint;
        View viewFindViewById = view.findViewById(R.id.bottom_sheet_tint);
        if (viewFindViewById != null) {
            i = R.id.guild_invite_empty_suggestions_invite_link;
            TextView textView = (TextView) view.findViewById(R.id.guild_invite_empty_suggestions_invite_link);
            if (textView != null) {
                i = R.id.guild_invite_empty_suggestions_invite_share_btn;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_invite_empty_suggestions_invite_share_btn);
                if (materialButton != null) {
                    i = R.id.guild_invite_empty_suggestions_settings_edit;
                    ImageButton imageButton = (ImageButton) view.findViewById(R.id.guild_invite_empty_suggestions_settings_edit);
                    if (imageButton != null) {
                        i = R.id.guild_invite_empty_suggestions_settings_invite_link_subtext;
                        TextView textView2 = (TextView) view.findViewById(R.id.guild_invite_empty_suggestions_settings_invite_link_subtext);
                        if (textView2 != null) {
                            i = R.id.invite_settings_bottom_sheet;
                            ViewInviteSettingsSheet viewInviteSettingsSheet = (ViewInviteSettingsSheet) view.findViewById(R.id.invite_settings_bottom_sheet);
                            if (viewInviteSettingsSheet != null) {
                                return new WidgetGuildInviteShareEmptySuggestionsBinding((CoordinatorLayout) view, viewFindViewById, textView, materialButton, imageButton, textView2, viewInviteSettingsSheet);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
