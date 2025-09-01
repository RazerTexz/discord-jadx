package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.i.MemberVerificationAvatarViewBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MemberVerificationAvatarView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/views/MemberVerificationAvatarView;", "Landroid/widget/FrameLayout;", "Lb/a/i/v0;", "j", "Lb/a/i/v0;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MemberVerificationAvatarView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final MemberVerificationAvatarViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.member_verification_avatar_view, this);
        int i = R.id.member_verification_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.member_verification_avatar);
        if (simpleDraweeView != null) {
            i = R.id.member_verification_text;
            TextView textView = (TextView) findViewById(R.id.member_verification_text);
            if (textView != null) {
                MemberVerificationAvatarViewBinding memberVerificationAvatarViewBinding = new MemberVerificationAvatarViewBinding(this, simpleDraweeView, textView);
                Intrinsics3.checkNotNullExpressionValue(memberVerificationAvatarViewBinding, "MemberVerificationAvatar…ater.from(context), this)");
                this.binding = memberVerificationAvatarViewBinding;
                setClipToOutline(true);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
