package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.ViewPremiumGuildProgressBarBinding;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerBoostStatusBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildBoost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerBoostStatusBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerBoostStatusBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoost2 extends FunctionReferenceImpl implements Function1<View, WidgetServerBoostStatusBinding> {
    public static final WidgetGuildBoost2 INSTANCE = new WidgetGuildBoost2();

    public WidgetGuildBoost2() {
        super(1, WidgetServerBoostStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerBoostStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerBoostStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerBoostStatusBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.boost_status_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.boost_status_flipper);
        if (appViewFlipper != null) {
            i = R.id.boost_status_learn_more;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.boost_status_learn_more);
            if (linkifiedTextView != null) {
                i = R.id.boost_status_num_boosts;
                TextView textView = (TextView) view.findViewById(R.id.boost_status_num_boosts);
                if (textView != null) {
                    i = R.id.boost_status_premium_marketing;
                    GuildBoostMarketingView guildBoostMarketingView = (GuildBoostMarketingView) view.findViewById(R.id.boost_status_premium_marketing);
                    if (guildBoostMarketingView != null) {
                        i = R.id.boost_status_premium_upsell;
                        GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView = (GuildBoostSubscriptionUpsellView) view.findViewById(R.id.boost_status_premium_upsell);
                        if (guildBoostSubscriptionUpsellView != null) {
                            i = R.id.boost_status_protip;
                            LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R.id.boost_status_protip);
                            if (linkifiedTextView2 != null) {
                                i = R.id.boost_status_retry;
                                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.boost_status_retry);
                                if (materialButton != null) {
                                    i = R.id.boost_status_subscribe_button;
                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.boost_status_subscribe_button);
                                    if (materialButton2 != null) {
                                        i = R.id.boost_status_subscribe_button2;
                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.boost_status_subscribe_button2);
                                        if (materialButton3 != null) {
                                            i = R.id.boost_status_viewpager;
                                            SimplePager simplePager = (SimplePager) view.findViewById(R.id.boost_status_viewpager);
                                            if (simplePager != null) {
                                                i = R.id.progress;
                                                View viewFindViewById = view.findViewById(R.id.progress);
                                                if (viewFindViewById != null) {
                                                    int i2 = R.id.boost_bar_progress_bar;
                                                    ProgressBar progressBar = (ProgressBar) viewFindViewById.findViewById(R.id.boost_bar_progress_bar);
                                                    if (progressBar != null) {
                                                        i2 = R.id.boost_bar_tier_0_container;
                                                        FrameLayout frameLayout = (FrameLayout) viewFindViewById.findViewById(R.id.boost_bar_tier_0_container);
                                                        if (frameLayout != null) {
                                                            i2 = R.id.boost_bar_tier_0_iv;
                                                            ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.boost_bar_tier_0_iv);
                                                            if (imageView != null) {
                                                                i2 = R.id.boost_bar_tier_1_container;
                                                                LinearLayout linearLayout = (LinearLayout) viewFindViewById.findViewById(R.id.boost_bar_tier_1_container);
                                                                if (linearLayout != null) {
                                                                    i2 = R.id.boost_bar_tier_1_iv;
                                                                    ImageView imageView2 = (ImageView) viewFindViewById.findViewById(R.id.boost_bar_tier_1_iv);
                                                                    if (imageView2 != null) {
                                                                        i2 = R.id.boost_bar_tier_1_tv;
                                                                        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.boost_bar_tier_1_tv);
                                                                        if (textView2 != null) {
                                                                            i2 = R.id.boost_bar_tier_2_container;
                                                                            LinearLayout linearLayout2 = (LinearLayout) viewFindViewById.findViewById(R.id.boost_bar_tier_2_container);
                                                                            if (linearLayout2 != null) {
                                                                                i2 = R.id.boost_bar_tier_2_iv;
                                                                                ImageView imageView3 = (ImageView) viewFindViewById.findViewById(R.id.boost_bar_tier_2_iv);
                                                                                if (imageView3 != null) {
                                                                                    i2 = R.id.boost_bar_tier_2_tv;
                                                                                    TextView textView3 = (TextView) viewFindViewById.findViewById(R.id.boost_bar_tier_2_tv);
                                                                                    if (textView3 != null) {
                                                                                        i2 = R.id.boost_bar_tier_3_container;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) viewFindViewById.findViewById(R.id.boost_bar_tier_3_container);
                                                                                        if (linearLayout3 != null) {
                                                                                            i2 = R.id.boost_bar_tier_3_iv;
                                                                                            ImageView imageView4 = (ImageView) viewFindViewById.findViewById(R.id.boost_bar_tier_3_iv);
                                                                                            if (imageView4 != null) {
                                                                                                i2 = R.id.boost_bar_tier_3_tv;
                                                                                                TextView textView4 = (TextView) viewFindViewById.findViewById(R.id.boost_bar_tier_3_tv);
                                                                                                if (textView4 != null) {
                                                                                                    return new WidgetServerBoostStatusBinding((CoordinatorLayout) view, appViewFlipper, linkifiedTextView, textView, guildBoostMarketingView, guildBoostSubscriptionUpsellView, linkifiedTextView2, materialButton, materialButton2, materialButton3, simplePager, new ViewPremiumGuildProgressBarBinding((ConstraintLayout) viewFindViewById, progressBar, frameLayout, imageView, linearLayout, imageView2, textView2, linearLayout2, imageView3, textView3, linearLayout3, imageView4, textView4));
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
                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
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
