package com.discord.widgets.auth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetOauthAuthorizeBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetOauth2Authorize.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetOauth2Authorize6 extends FunctionReferenceImpl implements Function1<View, WidgetOauthAuthorizeBinding> {
    public static final WidgetOauth2Authorize6 INSTANCE = new WidgetOauth2Authorize6();

    public WidgetOauth2Authorize6() {
        super(1, WidgetOauthAuthorizeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetOauthAuthorizeBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetOauthAuthorizeBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.oauth_authorize_age_notice;
        TextView textView = (TextView) view.findViewById(R.id.oauth_authorize_age_notice);
        if (textView != null) {
            i = R.id.oauth_authorize_age_notice_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.oauth_authorize_age_notice_icon);
            if (imageView != null) {
                i = R.id.oauth_authorize_application_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.oauth_authorize_application_icon);
                if (simpleDraweeView != null) {
                    i = R.id.oauth_authorize_application_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.oauth_authorize_application_name);
                    if (textView2 != null) {
                        i = R.id.oauth_authorize_card;
                        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.oauth_authorize_card);
                        if (materialCardView != null) {
                            i = R.id.oauth_authorize_connect_label;
                            TextView textView3 = (TextView) view.findViewById(R.id.oauth_authorize_connect_label);
                            if (textView3 != null) {
                                i = R.id.oauth_authorize_content;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.oauth_authorize_content);
                                if (linearLayout != null) {
                                    i = R.id.oauth_authorize_deny;
                                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.oauth_authorize_deny);
                                    if (materialButton != null) {
                                        i = R.id.oauth_authorize_grant;
                                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.oauth_authorize_grant);
                                        if (materialButton2 != null) {
                                            i = R.id.oauth_authorize_loading;
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.oauth_authorize_loading);
                                            if (linearLayout2 != null) {
                                                i = R.id.oauth_authorize_loading_cancel;
                                                MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.oauth_authorize_loading_cancel);
                                                if (materialButton3 != null) {
                                                    i = R.id.oauth_authorize_logo;
                                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.oauth_authorize_logo);
                                                    if (imageView2 != null) {
                                                        i = R.id.oauth_authorize_not_supported;
                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.oauth_authorize_not_supported);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.oauth_authorize_permissions_label_tv;
                                                            TextView textView4 = (TextView) view.findViewById(R.id.oauth_authorize_permissions_label_tv);
                                                            if (textView4 != null) {
                                                                i = R.id.oauth_authorize_permissions_list;
                                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.oauth_authorize_permissions_list);
                                                                if (recyclerView != null) {
                                                                    i = R.id.oauth_authorize_security_notice;
                                                                    TextView textView5 = (TextView) view.findViewById(R.id.oauth_authorize_security_notice);
                                                                    if (textView5 != null) {
                                                                        i = R.id.oauth_authorize_security_notice_icon;
                                                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.oauth_authorize_security_notice_icon);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.oauth_authorize_unsupported_browser;
                                                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R.id.oauth_authorize_unsupported_browser);
                                                                            if (materialButton4 != null) {
                                                                                i = R.id.oauth_authorize_unsupported_cancel;
                                                                                MaterialButton materialButton5 = (MaterialButton) view.findViewById(R.id.oauth_authorize_unsupported_cancel);
                                                                                if (materialButton5 != null) {
                                                                                    i = R.id.oauth_authorize_user_icon;
                                                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.oauth_authorize_user_icon);
                                                                                    if (simpleDraweeView2 != null) {
                                                                                        return new WidgetOauthAuthorizeBinding((CoordinatorLayout) view, textView, imageView, simpleDraweeView, textView2, materialCardView, textView3, linearLayout, materialButton, materialButton2, linearLayout2, materialButton3, imageView2, linearLayout3, textView4, recyclerView, textView5, imageView3, materialButton4, materialButton5, simpleDraweeView2);
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
