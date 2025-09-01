package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsEmojisEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsEmojisEdit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmojisEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsEmojisEditBinding> {
    public static final WidgetServerSettingsEmojisEdit2 INSTANCE = new WidgetServerSettingsEmojisEdit2();

    public WidgetServerSettingsEmojisEdit2() {
        super(1, WidgetServerSettingsEmojisEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojisEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmojisEditBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_emojis_edit_alias;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_emojis_edit_alias);
        if (textInputLayout != null) {
            i = R.id.server_settings_emojis_edit_alias_save;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_emojis_edit_alias_save);
            if (floatingActionButton != null) {
                return new WidgetServerSettingsEmojisEditBinding((CoordinatorLayout) view, textInputLayout, floatingActionButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
