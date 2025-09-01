package com.discord.widgets.servers;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsVanityUrlBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsVanityUrl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsVanityUrl3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsVanityUrlBinding> {
    public static final WidgetServerSettingsVanityUrl3 INSTANCE = new WidgetServerSettingsVanityUrl3();

    public WidgetServerSettingsVanityUrl3() {
        super(1, WidgetServerSettingsVanityUrlBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsVanityUrlBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsVanityUrlBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_vanity_input;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_vanity_input);
        if (textInputLayout != null) {
            i = R.id.server_settings_vanity_url_current_url;
            TextView textView = (TextView) view.findViewById(R.id.server_settings_vanity_url_current_url);
            if (textView != null) {
                i = R.id.server_settings_vanity_url_error_text;
                TextView textView2 = (TextView) view.findViewById(R.id.server_settings_vanity_url_error_text);
                if (textView2 != null) {
                    i = R.id.server_settings_vanity_url_header;
                    TextView textView3 = (TextView) view.findViewById(R.id.server_settings_vanity_url_header);
                    if (textView3 != null) {
                        i = R.id.server_settings_vanity_url_input_container;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.server_settings_vanity_url_input_container);
                        if (relativeLayout != null) {
                            i = R.id.server_settings_vanity_url_loading_indicator;
                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.server_settings_vanity_url_loading_indicator);
                            if (progressBar != null) {
                                i = R.id.server_settings_vanity_url_prefix;
                                TextView textView4 = (TextView) view.findViewById(R.id.server_settings_vanity_url_prefix);
                                if (textView4 != null) {
                                    i = R.id.server_settings_vanity_url_remove;
                                    TextView textView5 = (TextView) view.findViewById(R.id.server_settings_vanity_url_remove);
                                    if (textView5 != null) {
                                        i = R.id.server_settings_vanity_url_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_vanity_url_save);
                                        if (floatingActionButton != null) {
                                            return new WidgetServerSettingsVanityUrlBinding((CoordinatorLayout) view, textInputLayout, textView, textView2, textView3, relativeLayout, progressBar, textView4, textView5, floatingActionButton);
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
