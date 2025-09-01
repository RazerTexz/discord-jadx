package com.discord.views.user;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewUserSummaryItemBinding;
import com.discord.R;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.CoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: UserSummaryView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/discord/views/user/UserSummaryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "onFinishInflate", "()V", "", "Lcom/discord/models/guild/UserGuildMember;", "members", "", "withFullAvatarAtEnd", "a", "(Ljava/util/List;Z)V", "", "k", "I", "avatarSizePx", "l", "overlapAmountPx", "m", "Ljava/util/List;", "n", "maxAvatars", "Lcom/discord/views/CutoutView$a$c;", "j", "Lcom/discord/views/CutoutView$a$c;", "cutoutStyle", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UserSummaryView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final CutoutView.a.c cutoutStyle;

    /* renamed from: k, reason: from kotlin metadata */
    public int avatarSizePx;

    /* renamed from: l, reason: from kotlin metadata */
    public int overlapAmountPx;

    /* renamed from: m, reason: from kotlin metadata */
    public List<UserGuildMember> members;

    /* renamed from: n, reason: from kotlin metadata */
    public int maxAvatars;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.cutoutStyle = new CutoutView.a.c(0);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.avatarSizePx = (int) (16 * resources.getDisplayMetrics().density);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        this.overlapAmountPx = (int) (4 * resources2.getDisplayMetrics().density);
        this.members = Collections2.emptyList();
        this.maxAvatars = 3;
        int[] iArr = R.a.UserSummaryView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.UserSummaryView");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.avatarSizePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, this.avatarSizePx);
        this.overlapAmountPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.overlapAmountPx);
        this.maxAvatars = typedArrayObtainStyledAttributes.getInt(2, this.maxAvatars);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void b(UserSummaryView userSummaryView, List list, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        userSummaryView.a(list, z2);
    }

    public final void a(List<UserGuildMember> members, boolean withFullAvatarAtEnd) {
        int id2;
        Intrinsics3.checkNotNullParameter(members, "members");
        if (!Intrinsics3.areEqual(members, this.members)) {
            this.members = members;
            int iCoerceAtMost = _Ranges.coerceAtMost(members.size(), this.maxAvatars);
            while (getChildCount() > iCoerceAtMost) {
                removeViewAt(getChildCount() - 1);
            }
            while (true) {
                id2 = 0;
                if (getChildCount() >= iCoerceAtMost) {
                    break;
                }
                int childCount = getChildCount();
                ViewUserSummaryItemBinding viewUserSummaryItemBindingA = ViewUserSummaryItemBinding.a(LayoutInflater.from(getContext()).inflate(R.layout.view_user_summary_item, (ViewGroup) this, false));
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingA, "ViewUserSummaryItemBindi…ext), this, false\n      )");
                CutoutView cutoutView = viewUserSummaryItemBindingA.a;
                cutoutView.setId(childCount + 10);
                int i = this.avatarSizePx;
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i, i);
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                layoutParams.setMarginStart(childCount != 0 ? this.avatarSizePx - this.overlapAmountPx : 0);
                if (childCount != 0) {
                    id2 = cutoutView.getId() - 1;
                }
                layoutParams.startToStart = id2;
                cutoutView.setLayoutParams(layoutParams);
                Intrinsics3.checkNotNullExpressionValue(cutoutView, "ViewUserSummaryItemBindi…      }\n        }\n      }");
                addView(cutoutView, cutoutView.getLayoutParams());
            }
            int i2 = iCoerceAtMost - 1;
            while (id2 < iCoerceAtMost) {
                ViewUserSummaryItemBinding viewUserSummaryItemBindingA2 = ViewUserSummaryItemBinding.a(getChildAt(id2));
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingA2, "ViewUserSummaryItemBinding.bind(getChildAt(i))");
                viewUserSummaryItemBindingA2.a.setStyle((id2 == i2 && withFullAvatarAtEnd) ? CutoutView.a.d.a : this.cutoutStyle);
                int mediaProxySize = IconUtils.getMediaProxySize(this.avatarSizePx);
                UserGuildMember userGuildMember = this.members.get(id2);
                String forGuildMemberOrUser$default = IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(mediaProxySize), false, 8, null);
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingA2.f113b, "cutout.avatar");
                if (!Intrinsics3.areEqual(forGuildMemberOrUser$default, r5.getTag())) {
                    SimpleDraweeView simpleDraweeView = viewUserSummaryItemBindingA2.f113b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "cutout.avatar");
                    simpleDraweeView.setTag(forGuildMemberOrUser$default);
                    SimpleDraweeView simpleDraweeView2 = viewUserSummaryItemBindingA2.f113b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "cutout.avatar");
                    IconUtils.setIcon$default(simpleDraweeView2, forGuildMemberOrUser$default, R.dimen.avatar_size_reply, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                }
                id2++;
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            a(Collections2.listOf((Object[]) new UserGuildMember[]{new UserGuildMember(new CoreUser(0L, "mreynolds", null, null, false, false, 0, null, 0, 0, null, null, 4092, null), null, 2, null), new UserGuildMember(new CoreUser(1L, "itskaylee", null, null, false, false, 0, null, 0, 0, null, null, 4092, null), null, 2, null)}), true);
        }
    }
}
