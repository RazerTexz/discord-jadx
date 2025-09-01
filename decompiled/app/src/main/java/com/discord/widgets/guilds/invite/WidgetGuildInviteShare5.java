package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildInviteShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildInviteShareBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShare5 extends FunctionReferenceImpl implements Function1<View, WidgetGuildInviteShareBinding> {
    public static final WidgetGuildInviteShare5 INSTANCE = new WidgetGuildInviteShare5();

    public WidgetGuildInviteShare5() {
        super(1, WidgetGuildInviteShareBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteShareBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.bottom_sheet_tint;
        View viewFindViewById = view.findViewById(R.id.bottom_sheet_tint);
        if (viewFindViewById != null) {
            i = R.id.guild_invite_empty_results;
            TextView textView = (TextView) view.findViewById(R.id.guild_invite_empty_results);
            if (textView != null) {
                i = R.id.guild_invite_link;
                TextView textView2 = (TextView) view.findViewById(R.id.guild_invite_link);
                if (textView2 != null) {
                    i = R.id.guild_invite_never_expire;
                    CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.guild_invite_never_expire);
                    if (checkedSetting != null) {
                        i = R.id.guild_invite_settings_edit;
                        ImageView imageView = (ImageView) view.findViewById(R.id.guild_invite_settings_edit);
                        if (imageView != null) {
                            i = R.id.guild_invite_share_btn;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_invite_share_btn);
                            if (materialButton != null) {
                                i = R.id.guild_invite_share_search;
                                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_invite_share_search);
                                if (textInputLayout != null) {
                                    i = R.id.guild_invite_suggestion_list;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_invite_suggestion_list);
                                    if (recyclerView != null) {
                                        i = R.id.guild_invite_suggestions_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.guild_invite_suggestions_flipper);
                                        if (appViewFlipper != null) {
                                            i = R.id.invite_settings_bottom_sheet;
                                            ViewInviteSettingsSheet viewInviteSettingsSheet = (ViewInviteSettingsSheet) view.findViewById(R.id.invite_settings_bottom_sheet);
                                            if (viewInviteSettingsSheet != null) {
                                                return new WidgetGuildInviteShareBinding((CoordinatorLayout) view, viewFindViewById, textView, textView2, checkedSetting, imageView, materialButton, textInputLayout, recyclerView, appViewFlipper, viewInviteSettingsSheet);
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
