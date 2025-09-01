package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccessibilityBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsAccessibility.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccessibility3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccessibilityBinding> {
    public static final WidgetSettingsAccessibility3 INSTANCE = new WidgetSettingsAccessibility3();

    public WidgetSettingsAccessibility3() {
        super(1, WidgetSettingsAccessibilityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccessibilityBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccessibilityBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_accessibility_allow_animate_emoji_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_accessibility_allow_animate_emoji_switch);
        if (checkedSetting != null) {
            i = R.id.settings_accessibility_allow_autoplay_gif_switch;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.settings_accessibility_allow_autoplay_gif_switch);
            if (checkedSetting2 != null) {
                i = R.id.settings_accessibility_images_header;
                TextView textView = (TextView) view.findViewById(R.id.settings_accessibility_images_header);
                if (textView != null) {
                    i = R.id.settings_accessibility_reduced_motion_description;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.settings_accessibility_reduced_motion_description);
                    if (linkifiedTextView != null) {
                        i = R.id.settings_accessibility_reduced_motion_header;
                        TextView textView2 = (TextView) view.findViewById(R.id.settings_accessibility_reduced_motion_header);
                        if (textView2 != null) {
                            i = R.id.settings_accessibility_reduced_motion_switch;
                            CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.settings_accessibility_reduced_motion_switch);
                            if (checkedSetting3 != null) {
                                i = R.id.settings_accessibility_stickers_container;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.settings_accessibility_stickers_container);
                                if (linearLayout != null) {
                                    i = R.id.settings_accessibility_stickers_header;
                                    TextView textView3 = (TextView) view.findViewById(R.id.settings_accessibility_stickers_header);
                                    if (textView3 != null) {
                                        i = R.id.settings_appearance_holy_light;
                                        View viewFindViewById = view.findViewById(R.id.settings_appearance_holy_light);
                                        if (viewFindViewById != null) {
                                            i = R.id.stickers_always_animate;
                                            CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.stickers_always_animate);
                                            if (checkedSetting4 != null) {
                                                i = R.id.stickers_animate_on_interaction;
                                                CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.stickers_animate_on_interaction);
                                                if (checkedSetting5 != null) {
                                                    i = R.id.stickers_never_animate;
                                                    CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.stickers_never_animate);
                                                    if (checkedSetting6 != null) {
                                                        return new WidgetSettingsAccessibilityBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, textView, linkifiedTextView, textView2, checkedSetting3, linearLayout, textView3, viewFindViewById, checkedSetting4, checkedSetting5, checkedSetting6);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
