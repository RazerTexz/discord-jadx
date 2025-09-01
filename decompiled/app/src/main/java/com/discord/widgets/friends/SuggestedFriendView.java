package com.discord.widgets.friends;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.SuggestedFriendViewBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SuggestedFriendView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J-\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ\u001b\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/discord/widgets/friends/SuggestedFriendView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/discord/primitives/UserId;", "userId", "", "discriminator", "", "avatarUrl", "", "setAvatarUrl", "(JLjava/lang/Integer;Ljava/lang/String;)V", "username", "setUsername", "(Ljava/lang/String;)V", "publicName", "setPublicName", "Lkotlin/Function0;", "onDeclineClicked", "setOnDeclineClicked", "(Lkotlin/jvm/functions/Function0;)V", "onSendClicked", "setOnSendClicked", "Lcom/discord/databinding/SuggestedFriendViewBinding;", "binding", "Lcom/discord/databinding/SuggestedFriendViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SuggestedFriendView extends ConstraintLayout {
    private final SuggestedFriendViewBinding binding;

    /* compiled from: SuggestedFriendView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.SuggestedFriendView$setOnDeclineClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDeclineClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onDeclineClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDeclineClicked.invoke();
        }
    }

    /* compiled from: SuggestedFriendView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.SuggestedFriendView$setOnSendClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onSendClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onSendClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onSendClicked.invoke();
        }
    }

    public SuggestedFriendView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SuggestedFriendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SuggestedFriendView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setAvatarUrl(long userId, Integer discriminator, String avatarUrl) {
        Long lValueOf = Long.valueOf(userId);
        SimpleDraweeView simpleDraweeView = this.binding.f2156b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.suggestedFriendAvatar");
        String forUser = IconUtils.getForUser(lValueOf, avatarUrl, discriminator, false, Integer.valueOf(simpleDraweeView.getHeight()));
        SimpleDraweeView simpleDraweeView2 = this.binding.f2156b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.suggestedFriendAvatar");
        IconUtils.setIcon$default(simpleDraweeView2, forUser, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
    }

    public final void setOnDeclineClicked(Function0<Unit> onDeclineClicked) {
        Intrinsics3.checkNotNullParameter(onDeclineClicked, "onDeclineClicked");
        this.binding.c.setOnClickListener(new AnonymousClass1(onDeclineClicked));
    }

    public final void setOnSendClicked(Function0<Unit> onSendClicked) {
        Intrinsics3.checkNotNullParameter(onSendClicked, "onSendClicked");
        this.binding.e.setOnClickListener(new AnonymousClass1(onSendClicked));
    }

    public final void setPublicName(String publicName) {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.suggestedFriendPublicName");
        textView.setText(publicName);
    }

    public final void setUsername(String username) {
        Intrinsics3.checkNotNullParameter(username, "username");
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.suggestedFriendUsername");
        textView.setText(username);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestedFriendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.suggested_friend_view, this);
        int i2 = R.id.suggested_friend_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.suggested_friend_avatar);
        if (simpleDraweeView != null) {
            i2 = R.id.suggested_friend_decline;
            AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R.id.suggested_friend_decline);
            if (appCompatImageView != null) {
                i2 = R.id.suggested_friend_public_name;
                TextView textView = (TextView) findViewById(R.id.suggested_friend_public_name);
                if (textView != null) {
                    i2 = R.id.suggested_friend_send_request;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) findViewById(R.id.suggested_friend_send_request);
                    if (appCompatImageView2 != null) {
                        i2 = R.id.suggested_friend_username;
                        TextView textView2 = (TextView) findViewById(R.id.suggested_friend_username);
                        if (textView2 != null) {
                            SuggestedFriendViewBinding suggestedFriendViewBinding = new SuggestedFriendViewBinding(this, simpleDraweeView, appCompatImageView, textView, appCompatImageView2, textView2);
                            Intrinsics3.checkNotNullExpressionValue(suggestedFriendViewBinding, "SuggestedFriendViewBindi…ater.from(context), this)");
                            this.binding = suggestedFriendViewBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
