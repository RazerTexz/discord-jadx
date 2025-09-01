package com.discord.widgets.announcements;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelFollowSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelFollowSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelFollowSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelFollowSheetBinding> {
    public static final WidgetChannelFollowSheet2 INSTANCE = new WidgetChannelFollowSheet2();

    public WidgetChannelFollowSheet2() {
        super(1, WidgetChannelFollowSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelFollowSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelFollowSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_follow_channel_dropdown_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.channel_follow_channel_dropdown_icon);
        if (imageView != null) {
            i = R.id.channel_follow_channel_name;
            TextView textView = (TextView) view.findViewById(R.id.channel_follow_channel_name);
            if (textView != null) {
                i = R.id.channel_follow_error_text;
                TextView textView2 = (TextView) view.findViewById(R.id.channel_follow_error_text);
                if (textView2 != null) {
                    i = R.id.channel_follow_guild_dropdown_icon;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.channel_follow_guild_dropdown_icon);
                    if (imageView2 != null) {
                        i = R.id.channel_follow_guild_icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.channel_follow_guild_icon);
                        if (simpleDraweeView != null) {
                            i = R.id.channel_follow_select_channel;
                            MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.channel_follow_select_channel);
                            if (materialCardView != null) {
                                i = R.id.channel_follow_select_guild;
                                MaterialCardView materialCardView2 = (MaterialCardView) view.findViewById(R.id.channel_follow_select_guild);
                                if (materialCardView2 != null) {
                                    i = R.id.channel_follow_selected_channel_name;
                                    TextView textView3 = (TextView) view.findViewById(R.id.channel_follow_selected_channel_name);
                                    if (textView3 != null) {
                                        i = R.id.channel_follow_selected_guild_name;
                                        TextView textView4 = (TextView) view.findViewById(R.id.channel_follow_selected_guild_name);
                                        if (textView4 != null) {
                                            i = R.id.create_channel_follower_button;
                                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.create_channel_follower_button);
                                            if (materialButton != null) {
                                                i = R.id.follow_sheet_view_flipper;
                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.follow_sheet_view_flipper);
                                                if (appViewFlipper != null) {
                                                    return new WidgetChannelFollowSheetBinding((NestedScrollView) view, imageView, textView, textView2, imageView2, simpleDraweeView, materialCardView, materialCardView2, textView3, textView4, materialButton, appViewFlipper);
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
