package com.discord.widgets.friends;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.EmptyFriendsStateViewBinding;
import com.discord.widgets.friends.WidgetFriendsAdd;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmptyFriendsStateView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0012B'\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0010\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/friends/EmptyFriendsStateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/util/AttributeSet;", "attrs", "", "initialize", "(Landroid/util/AttributeSet;)V", "", "addFriendSource", "updateView", "(Ljava/lang/String;)V", "Lcom/discord/databinding/EmptyFriendsStateViewBinding;", "binding", "Lcom/discord/databinding/EmptyFriendsStateViewBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmptyFriendsStateView extends ConstraintLayout {
    private final EmptyFriendsStateViewBinding binding;

    /* compiled from: EmptyFriendsStateView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.EmptyFriendsStateView$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $addFriendSource;

        public AnonymousClass1(String str) {
            this.$addFriendSource = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
            Context context = EmptyFriendsStateView.this.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            WidgetFriendsAdd.Companion.show$default(companion, context, null, this.$addFriendSource, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
    }

    public final void initialize(AttributeSet attrs) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.EmptyFriendsStateView);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.EmptyFriendsStateView)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, R.dimen.uikit_textsize_xlarge);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.c.setTextSize(0, getResources().getDimension(resourceId));
    }

    public final void updateView(String addFriendSource) {
        Intrinsics3.checkNotNullParameter(addFriendSource, "addFriendSource");
        this.binding.f2103b.setOnClickListener(new AnonymousClass1(addFriendSource));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
