package com.discord.widgets.settings;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsLanguageBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsLanguage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsLanguageBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsLanguage2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsLanguageBinding> {
    public static final WidgetSettingsLanguage2 INSTANCE = new WidgetSettingsLanguage2();

    public WidgetSettingsLanguage2() {
        super(1, WidgetSettingsLanguageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsLanguageBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsLanguageBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_language_current;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.settings_language_current);
        if (relativeLayout != null) {
            i = R.id.settings_language_current_flag;
            ImageView imageView = (ImageView) view.findViewById(R.id.settings_language_current_flag);
            if (imageView != null) {
                i = R.id.settings_language_current_text;
                TextView textView = (TextView) view.findViewById(R.id.settings_language_current_text);
                if (textView != null) {
                    i = R.id.settings_language_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.settings_language_header);
                    if (textView2 != null) {
                        i = R.id.settings_language_sync_check;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_language_sync_check);
                        if (checkedSetting != null) {
                            i = R.id.settings_language_sync_header;
                            TextView textView3 = (TextView) view.findViewById(R.id.settings_language_sync_header);
                            if (textView3 != null) {
                                return new WidgetSettingsLanguageBinding((CoordinatorLayout) view, relativeLayout, imageView, textView, textView2, checkedSetting, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
