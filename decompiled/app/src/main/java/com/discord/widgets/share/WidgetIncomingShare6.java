package com.discord.widgets.share;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetIncomingShareBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.user.search.ViewGlobalSearchItem;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetIncomingShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetIncomingShareBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetIncomingShareBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetIncomingShare6 extends FunctionReferenceImpl implements Function1<View, WidgetIncomingShareBinding> {
    public static final WidgetIncomingShare6 INSTANCE = new WidgetIncomingShare6();

    public WidgetIncomingShare6() {
        super(1, WidgetIncomingShareBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetIncomingShareBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetIncomingShareBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetIncomingShareBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.external_share_activity_action_preview;
            ViewEmbedGameInvite viewEmbedGameInvite = (ViewEmbedGameInvite) view.findViewById(R.id.external_share_activity_action_preview);
            if (viewEmbedGameInvite != null) {
                i = R.id.external_share_comment;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.external_share_comment);
                if (textInputLayout != null) {
                    i = R.id.external_share_list;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.external_share_list);
                    if (recyclerView != null) {
                        i = R.id.external_share_list_wrap;
                        CardView cardView = (CardView) view.findViewById(R.id.external_share_list_wrap);
                        if (cardView != null) {
                            i = R.id.external_share_search;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.external_share_search);
                            if (textInputLayout2 != null) {
                                i = R.id.external_share_search_results;
                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.external_share_search_results);
                                if (recyclerView2 != null) {
                                    i = R.id.incoming_share_no_results_img;
                                    ImageView imageView = (ImageView) view.findViewById(R.id.incoming_share_no_results_img);
                                    if (imageView != null) {
                                        i = R.id.incoming_share_results_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.incoming_share_results_flipper);
                                        if (appViewFlipper != null) {
                                            i = R.id.scroll_view;
                                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
                                            if (nestedScrollView != null) {
                                                i = R.id.search_flipper;
                                                AppViewFlipper appViewFlipper2 = (AppViewFlipper) view.findViewById(R.id.search_flipper);
                                                if (appViewFlipper2 != null) {
                                                    i = R.id.widget_channel_search_item;
                                                    ViewGlobalSearchItem viewGlobalSearchItem = (ViewGlobalSearchItem) view.findViewById(R.id.widget_channel_search_item);
                                                    if (viewGlobalSearchItem != null) {
                                                        i = R.id.widget_channel_search_item_remove;
                                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.widget_channel_search_item_remove);
                                                        if (imageView2 != null) {
                                                            return new WidgetIncomingShareBinding((CoordinatorLayout) view, dimmerView, viewEmbedGameInvite, textInputLayout, recyclerView, cardView, textInputLayout2, recyclerView2, imageView, appViewFlipper, nestedScrollView, appViewFlipper2, viewGlobalSearchItem, imageView2);
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
