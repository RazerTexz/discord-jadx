package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsGiftingBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.premium.GiftSelectView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGifting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsGiftingBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsGiftingBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGifting2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsGiftingBinding> {
    public static final WidgetSettingsGifting2 INSTANCE = new WidgetSettingsGifting2();

    public WidgetSettingsGifting2() {
        super(1, WidgetSettingsGiftingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsGiftingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsGiftingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsGiftingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.gift_select_premium_tier_1_month;
            GiftSelectView giftSelectView = (GiftSelectView) view.findViewById(R.id.gift_select_premium_tier_1_month);
            if (giftSelectView != null) {
                i = R.id.gift_select_premium_tier_1_year;
                GiftSelectView giftSelectView2 = (GiftSelectView) view.findViewById(R.id.gift_select_premium_tier_1_year);
                if (giftSelectView2 != null) {
                    i = R.id.gift_select_premium_tier_2_month;
                    GiftSelectView giftSelectView3 = (GiftSelectView) view.findViewById(R.id.gift_select_premium_tier_2_month);
                    if (giftSelectView3 != null) {
                        i = R.id.gift_select_premium_tier_2_year;
                        GiftSelectView giftSelectView4 = (GiftSelectView) view.findViewById(R.id.gift_select_premium_tier_2_year);
                        if (giftSelectView4 != null) {
                            i = R.id.premium_tier_1_gift_learn_more;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.premium_tier_1_gift_learn_more);
                            if (linkifiedTextView != null) {
                                i = R.id.premium_tier_2_gift_learn_more;
                                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R.id.premium_tier_2_gift_learn_more);
                                if (linkifiedTextView2 != null) {
                                    i = R.id.settings_gifting_flipper;
                                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.settings_gifting_flipper);
                                    if (appViewFlipper != null) {
                                        i = R.id.settings_gifting_gift_code_input_progress;
                                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.settings_gifting_gift_code_input_progress);
                                        if (progressBar != null) {
                                            i = R.id.settings_gifting_gift_code_input_wrap;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.settings_gifting_gift_code_input_wrap);
                                            if (textInputLayout != null) {
                                                i = R.id.settings_gifting_gifts_you_purchased_header;
                                                TextView textView = (TextView) view.findViewById(R.id.settings_gifting_gifts_you_purchased_header);
                                                if (textView != null) {
                                                    i = R.id.settings_gifting_gifts_you_purchased_recycler;
                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.settings_gifting_gifts_you_purchased_recycler);
                                                    if (recyclerView != null) {
                                                        i = R.id.settings_gifting_purchase_gift_section;
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.settings_gifting_purchase_gift_section);
                                                        if (linearLayout != null) {
                                                            i = R.id.settings_gifting_redeem_codes_header;
                                                            TextView textView2 = (TextView) view.findViewById(R.id.settings_gifting_redeem_codes_header);
                                                            if (textView2 != null) {
                                                                i = R.id.settings_gifting_retry;
                                                                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_gifting_retry);
                                                                if (materialButton != null) {
                                                                    i = R.id.settings_gifting_select_classic_gift_header;
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.settings_gifting_select_classic_gift_header);
                                                                    if (textView3 != null) {
                                                                        i = R.id.settings_gifting_select_gift_header;
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.settings_gifting_select_gift_header);
                                                                        if (textView4 != null) {
                                                                            i = R.id.settings_gifting_your_gifts_header;
                                                                            TextView textView5 = (TextView) view.findViewById(R.id.settings_gifting_your_gifts_header);
                                                                            if (textView5 != null) {
                                                                                i = R.id.settings_gifting_your_gifts_recycler;
                                                                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.settings_gifting_your_gifts_recycler);
                                                                                if (recyclerView2 != null) {
                                                                                    return new WidgetSettingsGiftingBinding((CoordinatorLayout) view, dimmerView, giftSelectView, giftSelectView2, giftSelectView3, giftSelectView4, linkifiedTextView, linkifiedTextView2, appViewFlipper, progressBar, textInputLayout, textView, recyclerView, linearLayout, textView2, materialButton, textView3, textView4, textView5, recyclerView2);
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
