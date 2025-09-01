package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.i.ViewUserListItemBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: UserListItemView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/views/UserListItemView;", "Landroid/widget/RelativeLayout;", "Lb/a/i/d4;", "k", "Lb/a/i/d4;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UserListItemView extends RelativeLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewUserListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_user_list_item, this);
        int i = R.id.user_list_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.user_list_item_avatar);
        if (simpleDraweeView != null) {
            i = R.id.user_list_item_name;
            TextView textView = (TextView) findViewById(R.id.user_list_item_name);
            if (textView != null) {
                i = R.id.user_list_item_name_secondary;
                TextView textView2 = (TextView) findViewById(R.id.user_list_item_name_secondary);
                if (textView2 != null) {
                    i = R.id.user_list_item_status;
                    StatusView statusView = (StatusView) findViewById(R.id.user_list_item_status);
                    if (statusView != null) {
                        ViewUserListItemBinding viewUserListItemBinding = new ViewUserListItemBinding(this, simpleDraweeView, textView, textView2, statusView);
                        Intrinsics3.checkNotNullExpressionValue(viewUserListItemBinding, "ViewUserListItemBinding.…ater.from(context), this)");
                        this.binding = viewUserListItemBinding;
                        setClickable(true);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
