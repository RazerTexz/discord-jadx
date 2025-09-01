package com.discord.widgets.chat.input.expression;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.databinding.WidgetExpressionTrayBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetExpressionTray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetExpressionTrayBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetExpressionTrayBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetExpressionTray2 extends FunctionReferenceImpl implements Function1<View, WidgetExpressionTrayBinding> {
    public static final WidgetExpressionTray2 INSTANCE = new WidgetExpressionTray2();

    public WidgetExpressionTray2() {
        super(1, WidgetExpressionTrayBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetExpressionTrayBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetExpressionTrayBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetExpressionTrayBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.expression_tray_content_container;
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.expression_tray_content_container);
        if (frameLayout2 != null) {
            i = R.id.expression_tray_detail_page;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.expression_tray_detail_page);
            if (fragmentContainerView != null) {
                i = R.id.expression_tray_emoji_card;
                CardSegment cardSegment = (CardSegment) view.findViewById(R.id.expression_tray_emoji_card);
                if (cardSegment != null) {
                    i = R.id.expression_tray_emoji_picker_content;
                    FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.expression_tray_emoji_picker_content);
                    if (fragmentContainerView2 != null) {
                        i = R.id.expression_tray_gif_card;
                        CardSegment cardSegment2 = (CardSegment) view.findViewById(R.id.expression_tray_gif_card);
                        if (cardSegment2 != null) {
                            i = R.id.expression_tray_gif_picker_content;
                            FragmentContainerView fragmentContainerView3 = (FragmentContainerView) view.findViewById(R.id.expression_tray_gif_picker_content);
                            if (fragmentContainerView3 != null) {
                                i = R.id.expression_tray_landing_page;
                                ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = (ContentResizingCoordinatorLayout) view.findViewById(R.id.expression_tray_landing_page);
                                if (contentResizingCoordinatorLayout != null) {
                                    i = R.id.expression_tray_search_bar;
                                    RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view.findViewById(R.id.expression_tray_search_bar);
                                    if (roundedRelativeLayout != null) {
                                        i = R.id.expression_tray_search_button;
                                        TextView textView = (TextView) view.findViewById(R.id.expression_tray_search_button);
                                        if (textView != null) {
                                            i = R.id.expression_tray_search_icon;
                                            ImageView imageView = (ImageView) view.findViewById(R.id.expression_tray_search_icon);
                                            if (imageView != null) {
                                                i = R.id.expression_tray_segmented_control;
                                                SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(R.id.expression_tray_segmented_control);
                                                if (segmentedControlContainer != null) {
                                                    i = R.id.expression_tray_sticker_card;
                                                    CardSegment cardSegment3 = (CardSegment) view.findViewById(R.id.expression_tray_sticker_card);
                                                    if (cardSegment3 != null) {
                                                        i = R.id.expression_tray_sticker_picker_content;
                                                        FragmentContainerView fragmentContainerView4 = (FragmentContainerView) view.findViewById(R.id.expression_tray_sticker_picker_content);
                                                        if (fragmentContainerView4 != null) {
                                                            i = R.id.expression_tray_toolbar;
                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.expression_tray_toolbar);
                                                            if (collapsingToolbarLayout != null) {
                                                                i = R.id.expression_tray_toolbar_layout;
                                                                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.expression_tray_toolbar_layout);
                                                                if (appBarLayout != null) {
                                                                    return new WidgetExpressionTrayBinding((FrameLayout) view, frameLayout, frameLayout2, fragmentContainerView, cardSegment, fragmentContainerView2, cardSegment2, fragmentContainerView3, contentResizingCoordinatorLayout, roundedRelativeLayout, textView, imageView, segmentedControlContainer, cardSegment3, fragmentContainerView4, collapsingToolbarLayout, appBarLayout);
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
