package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.LayoutFullscreenCallPreviewEmptyBinding;
import com.discord.R;
import com.discord.databinding.WidgetCallPreviewFullscreenBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCallPreviewFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetCallPreviewFullscreen2 extends FunctionReferenceImpl implements Function1<View, WidgetCallPreviewFullscreenBinding> {
    public static final WidgetCallPreviewFullscreen2 INSTANCE = new WidgetCallPreviewFullscreen2();

    public WidgetCallPreviewFullscreen2() {
        super(1, WidgetCallPreviewFullscreenBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCallPreviewFullscreenBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.action_bar_toolbar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
            if (appBarLayout != null) {
                i = R.id.call_fullscreen_body;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.call_fullscreen_body);
                if (constraintLayout != null) {
                    i = R.id.call_fullscreen_mentions;
                    TextView textView = (TextView) view.findViewById(R.id.call_fullscreen_mentions);
                    if (textView != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        i = R.id.call_preview_join_buttons;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.call_preview_join_buttons);
                        if (constraintLayout3 != null) {
                            i = R.id.call_preview_join_muted;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.call_preview_join_muted);
                            if (materialButton != null) {
                                i = R.id.call_preview_join_voice;
                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.call_preview_join_voice);
                                if (materialButton2 != null) {
                                    i = R.id.call_preview_nsfw;
                                    ViewStub viewStub = (ViewStub) view.findViewById(R.id.call_preview_nsfw);
                                    if (viewStub != null) {
                                        i = R.id.call_preview_voice_sheet_recycler;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.call_preview_voice_sheet_recycler);
                                        if (recyclerView != null) {
                                            i = R.id.empty;
                                            View viewFindViewById = view.findViewById(R.id.empty);
                                            if (viewFindViewById != null) {
                                                int i2 = R.id.fullscreen_call_preview_empty_image;
                                                ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.fullscreen_call_preview_empty_image);
                                                if (imageView != null) {
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) viewFindViewById;
                                                    i2 = R.id.fullscreen_call_preview_header;
                                                    TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.fullscreen_call_preview_header);
                                                    if (textView2 != null) {
                                                        i2 = R.id.fullscreen_call_preview_subtitle;
                                                        TextView textView3 = (TextView) viewFindViewById.findViewById(R.id.fullscreen_call_preview_subtitle);
                                                        if (textView3 != null) {
                                                            return new WidgetCallPreviewFullscreenBinding(constraintLayout2, toolbar, appBarLayout, constraintLayout, textView, constraintLayout2, constraintLayout3, materialButton, materialButton2, viewStub, recyclerView, new LayoutFullscreenCallPreviewEmptyBinding(constraintLayout4, imageView, constraintLayout4, textView2, textView3));
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
