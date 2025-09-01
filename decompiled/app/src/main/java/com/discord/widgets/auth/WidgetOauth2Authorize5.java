package com.discord.widgets.auth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetOauth2Authorize.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/ViewGroup;", "parent", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuthPermissionViewHolder;", "invoke", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuthPermissionViewHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOauth2Authorize5 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetOauth2Authorize.OAuthPermissionViewHolder> {
    public static final WidgetOauth2Authorize5 INSTANCE = new WidgetOauth2Authorize5();

    public WidgetOauth2Authorize5() {
        super(2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetOauth2Authorize.OAuthPermissionViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R.layout.oauth_token_permission_detailed_list_item, viewGroup, false);
        int i = R.id.oauth_token_permission_detailed_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.oauth_token_permission_detailed_icon);
        if (imageView != null) {
            i = R.id.oauth_token_permission_detailed_name;
            TextView textView = (TextView) viewInflate.findViewById(R.id.oauth_token_permission_detailed_name);
            if (textView != null) {
                OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding = new OauthTokenPermissionDetailedListItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(oauthTokenPermissionDetailedListItemBinding, "OauthTokenPermissionDeta…tInflater, parent, false)");
                return new WidgetOauth2Authorize.OAuthPermissionViewHolder(oauthTokenPermissionDetailedListItemBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetOauth2Authorize.OAuthPermissionViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }
}
