package com.discord.widgets.media;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.discord.R;
import com.discord.databinding.WidgetMediaBinding;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetMediaBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetMediaBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.media.WidgetMedia$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia5 extends FunctionReferenceImpl implements Function1<View, WidgetMediaBinding> {
    public static final WidgetMedia5 INSTANCE = new WidgetMedia5();

    public WidgetMedia5() {
        super(1, WidgetMediaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMediaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMediaBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMediaBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
        if (appBarLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.media_image;
            ZoomableDraweeView zoomableDraweeView = (ZoomableDraweeView) view.findViewById(R.id.media_image);
            if (zoomableDraweeView != null) {
                i = R.id.media_loading_indicator;
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.media_loading_indicator);
                if (progressBar != null) {
                    i = R.id.media_player_control_view;
                    PlayerControlView playerControlView = (PlayerControlView) view.findViewById(R.id.media_player_control_view);
                    if (playerControlView != null) {
                        i = R.id.media_player_view;
                        PlayerView playerView = (PlayerView) view.findViewById(R.id.media_player_view);
                        if (playerView != null) {
                            return new WidgetMediaBinding(frameLayout, appBarLayout, frameLayout, zoomableDraweeView, progressBar, playerControlView, playerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
