package com.discord.widgets.settings.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEditProfileBannerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetEditProfileBannerSheet5 extends FunctionReferenceImpl implements Function1<View, WidgetEditProfileBannerSheetBinding> {
    public static final WidgetEditProfileBannerSheet5 INSTANCE = new WidgetEditProfileBannerSheet5();

    public WidgetEditProfileBannerSheet5() {
        super(1, WidgetEditProfileBannerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEditProfileBannerSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEditProfileBannerSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.banner_change_image_item_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.banner_change_image_item_container);
        if (linearLayout != null) {
            i = R.id.banner_change_image_item_description;
            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.banner_change_image_item_description);
            if (materialTextView != null) {
                i = R.id.banner_change_image_item_title;
                MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.banner_change_image_item_title);
                if (materialTextView2 != null) {
                    i = R.id.banner_color_item_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.banner_color_item_container);
                    if (constraintLayout != null) {
                        i = R.id.banner_color_item_description;
                        MaterialTextView materialTextView3 = (MaterialTextView) view.findViewById(R.id.banner_color_item_description);
                        if (materialTextView3 != null) {
                            i = R.id.banner_color_item_title;
                            MaterialTextView materialTextView4 = (MaterialTextView) view.findViewById(R.id.banner_color_item_title);
                            if (materialTextView4 != null) {
                                i = R.id.banner_color_preview;
                                ImageView imageView = (ImageView) view.findViewById(R.id.banner_color_preview);
                                if (imageView != null) {
                                    i = R.id.banner_remove_image_item;
                                    MaterialTextView materialTextView5 = (MaterialTextView) view.findViewById(R.id.banner_remove_image_item);
                                    if (materialTextView5 != null) {
                                        i = R.id.premium_upsell_button;
                                        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.premium_upsell_button);
                                        if (materialButton != null) {
                                            return new WidgetEditProfileBannerSheetBinding((LinearLayout) view, linearLayout, materialTextView, materialTextView2, constraintLayout, materialTextView3, materialTextView4, imageView, materialTextView5, materialButton);
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
