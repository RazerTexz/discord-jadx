package com.discord.widgets.guilds.profile;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetChangeGuildIdentityBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.premium.ShinyButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChangeGuildIdentity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeGuildIdentity5 extends FunctionReferenceImpl implements Function1<View, WidgetChangeGuildIdentityBinding> {
    public static final WidgetChangeGuildIdentity5 INSTANCE = new WidgetChangeGuildIdentity5();

    public WidgetChangeGuildIdentity5() {
        super(1, WidgetChangeGuildIdentityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChangeGuildIdentityBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChangeGuildIdentityBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.avatar_header;
        TextView textView = (TextView) view.findViewById(R.id.avatar_header);
        if (textView != null) {
            i = R.id.banner_edit;
            CardView cardView = (CardView) view.findViewById(R.id.banner_edit);
            if (cardView != null) {
                i = R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                if (dimmerView != null) {
                    i = R.id.get_premium_button;
                    ShinyButton shinyButton = (ShinyButton) view.findViewById(R.id.get_premium_button);
                    if (shinyButton != null) {
                        i = R.id.guild_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guild_avatar);
                        if (simpleDraweeView != null) {
                            i = R.id.guild_avatar_card;
                            CardView cardView2 = (CardView) view.findViewById(R.id.guild_avatar_card);
                            if (cardView2 != null) {
                                i = R.id.guild_avatar_container;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.guild_avatar_container);
                                if (relativeLayout != null) {
                                    i = R.id.nickname_editor_card;
                                    CardView cardView3 = (CardView) view.findViewById(R.id.nickname_editor_card);
                                    if (cardView3 != null) {
                                        i = R.id.save_fab;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.save_fab);
                                        if (floatingActionButton != null) {
                                            i = R.id.set_nickname_text;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.set_nickname_text);
                                            if (textInputLayout != null) {
                                                i = R.id.upsell_section;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.upsell_section);
                                                if (linearLayout != null) {
                                                    return new WidgetChangeGuildIdentityBinding((CoordinatorLayout) view, textView, cardView, dimmerView, shinyButton, simpleDraweeView, cardView2, relativeLayout, cardView3, floatingActionButton, textInputLayout, linearLayout);
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
