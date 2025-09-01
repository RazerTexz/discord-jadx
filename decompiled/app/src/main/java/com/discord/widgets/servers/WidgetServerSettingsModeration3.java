package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsModeration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsModeration3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsModerationBinding> {
    public static final WidgetServerSettingsModeration3 INSTANCE = new WidgetServerSettingsModeration3();

    public WidgetServerSettingsModeration3() {
        super(1, WidgetServerSettingsModerationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsModerationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsModerationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_moderation_explicit_1;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_explicit_1);
        if (checkedSetting != null) {
            i = R.id.server_settings_moderation_explicit_2;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_explicit_2);
            if (checkedSetting2 != null) {
                i = R.id.server_settings_moderation_explicit_3;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_explicit_3);
                if (checkedSetting3 != null) {
                    i = R.id.server_settings_moderation_explicit_help;
                    TextView textView = (TextView) view.findViewById(R.id.server_settings_moderation_explicit_help);
                    if (textView != null) {
                        i = R.id.server_settings_moderation_verification_1;
                        CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_1);
                        if (checkedSetting4 != null) {
                            i = R.id.server_settings_moderation_verification_2;
                            CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_2);
                            if (checkedSetting5 != null) {
                                i = R.id.server_settings_moderation_verification_3;
                                CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_3);
                                if (checkedSetting6 != null) {
                                    i = R.id.server_settings_moderation_verification_4;
                                    CheckedSetting checkedSetting7 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_4);
                                    if (checkedSetting7 != null) {
                                        i = R.id.server_settings_moderation_verification_5;
                                        CheckedSetting checkedSetting8 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_5);
                                        if (checkedSetting8 != null) {
                                            i = R.id.server_settings_moderation_verification_help;
                                            TextView textView2 = (TextView) view.findViewById(R.id.server_settings_moderation_verification_help);
                                            if (textView2 != null) {
                                                return new WidgetServerSettingsModerationBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, checkedSetting3, textView, checkedSetting4, checkedSetting5, checkedSetting6, checkedSetting7, checkedSetting8, textView2);
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
