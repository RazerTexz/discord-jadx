package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetStickerPickerBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStickerPicker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetStickerPickerBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetStickerPickerBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker2 extends FunctionReferenceImpl implements Function1<View, WidgetStickerPickerBinding> {
    public static final WidgetStickerPicker2 INSTANCE = new WidgetStickerPicker2();

    public WidgetStickerPicker2() {
        super(1, WidgetStickerPickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStickerPickerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStickerPickerBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStickerPickerBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.chat_input_sticker_picker_empty_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.chat_input_sticker_picker_empty_container);
        if (linearLayout != null) {
            i = R.id.chat_input_sticker_picker_empty_container_phase_1;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.chat_input_sticker_picker_empty_container_phase_1);
            if (linearLayout2 != null) {
                i = R.id.chat_input_sticker_picker_empty_image;
                ImageView imageView = (ImageView) view.findViewById(R.id.chat_input_sticker_picker_empty_image);
                if (imageView != null) {
                    i = R.id.chat_input_sticker_picker_empty_link;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.chat_input_sticker_picker_empty_link);
                    if (linkifiedTextView != null) {
                        i = R.id.chat_input_sticker_picker_empty_sticker_1;
                        StickerView stickerView = (StickerView) view.findViewById(R.id.chat_input_sticker_picker_empty_sticker_1);
                        if (stickerView != null) {
                            i = R.id.chat_input_sticker_picker_empty_sticker_2;
                            StickerView stickerView2 = (StickerView) view.findViewById(R.id.chat_input_sticker_picker_empty_sticker_2);
                            if (stickerView2 != null) {
                                i = R.id.chat_input_sticker_picker_empty_sticker_3;
                                StickerView stickerView3 = (StickerView) view.findViewById(R.id.chat_input_sticker_picker_empty_sticker_3);
                                if (stickerView3 != null) {
                                    i = R.id.chat_input_sticker_picker_empty_sticker_4;
                                    StickerView stickerView4 = (StickerView) view.findViewById(R.id.chat_input_sticker_picker_empty_sticker_4);
                                    if (stickerView4 != null) {
                                        i = R.id.chat_input_sticker_picker_empty_subscribe;
                                        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.chat_input_sticker_picker_empty_subscribe);
                                        if (loadingButton != null) {
                                            i = R.id.chat_input_sticker_picker_empty_subtitle;
                                            TextView textView = (TextView) view.findViewById(R.id.chat_input_sticker_picker_empty_subtitle);
                                            if (textView != null) {
                                                i = R.id.chat_input_sticker_picker_empty_subtitle_phase_1;
                                                TextView textView2 = (TextView) view.findViewById(R.id.chat_input_sticker_picker_empty_subtitle_phase_1);
                                                if (textView2 != null) {
                                                    i = R.id.chat_input_sticker_picker_empty_title;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.chat_input_sticker_picker_empty_title);
                                                    if (textView3 != null) {
                                                        i = R.id.chat_input_sticker_picker_empty_title_phase_1;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.chat_input_sticker_picker_empty_title_phase_1);
                                                        if (textView4 != null) {
                                                            i = R.id.chat_input_sticker_picker_recycler;
                                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.chat_input_sticker_picker_recycler);
                                                            if (recyclerView != null) {
                                                                i = R.id.chat_input_sticker_picker_view_flipper;
                                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.chat_input_sticker_picker_view_flipper);
                                                                if (appViewFlipper != null) {
                                                                    i = R.id.sticker_app_bar;
                                                                    AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.sticker_app_bar);
                                                                    if (appBarLayout != null) {
                                                                        i = R.id.sticker_picker_bottom_bar;
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.sticker_picker_bottom_bar);
                                                                        if (constraintLayout != null) {
                                                                            i = R.id.sticker_picker_bottom_bar_divider;
                                                                            View viewFindViewById = view.findViewById(R.id.sticker_picker_bottom_bar_divider);
                                                                            if (viewFindViewById != null) {
                                                                                i = R.id.sticker_picker_category_recycler;
                                                                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.sticker_picker_category_recycler);
                                                                                if (recyclerView2 != null) {
                                                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                                                                    i = R.id.sticker_search_input;
                                                                                    SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.sticker_search_input);
                                                                                    if (searchInputView != null) {
                                                                                        i = R.id.sticker_toolbar;
                                                                                        Toolbar toolbar = (Toolbar) view.findViewById(R.id.sticker_toolbar);
                                                                                        if (toolbar != null) {
                                                                                            return new WidgetStickerPickerBinding(coordinatorLayout, linearLayout, linearLayout2, imageView, linkifiedTextView, stickerView, stickerView2, stickerView3, stickerView4, loadingButton, textView, textView2, textView3, textView4, recyclerView, appViewFlipper, appBarLayout, constraintLayout, viewFindViewById, recyclerView2, coordinatorLayout, searchInputView, toolbar);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
