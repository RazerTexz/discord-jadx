package com.discord.widgets.guilds;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildFolderSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildFolderSettings2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildFolderSettingsBinding> {
    public static final WidgetGuildFolderSettings2 INSTANCE = new WidgetGuildFolderSettings2();

    public WidgetGuildFolderSettings2() {
        super(1, WidgetGuildFolderSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildFolderSettingsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.edit_guild_folder_name;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_guild_folder_name);
        if (textInputLayout != null) {
            i = R.id.guild_folder_color_name;
            TextView textView = (TextView) view.findViewById(R.id.guild_folder_color_name);
            if (textView != null) {
                i = R.id.guild_folder_settings_color;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.guild_folder_settings_color);
                if (relativeLayout != null) {
                    i = R.id.guild_folder_settings_color_display;
                    View viewFindViewById = view.findViewById(R.id.guild_folder_settings_color_display);
                    if (viewFindViewById != null) {
                        i = R.id.guild_folder_settings_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.guild_folder_settings_save);
                        if (floatingActionButton != null) {
                            return new WidgetGuildFolderSettingsBinding((CoordinatorLayout) view, textInputLayout, textView, relativeLayout, viewFindViewById, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
