package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ChannelMembersListViewHolderJoinLeaveThread.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListViewHolderJoinLeaveThread;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function0;", "", "onClicked", "", "isThreadJoined", "bind", "(Lkotlin/jvm/functions/Function0;Z)V", "Lcom/discord/databinding/WidgetChannelMembersListItemAddOrLeaveBinding;", "binding", "Lcom/discord/databinding/WidgetChannelMembersListItemAddOrLeaveBinding;", "<init>", "(Lcom/discord/databinding/WidgetChannelMembersListItemAddOrLeaveBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderJoinLeaveThread extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* compiled from: ChannelMembersListViewHolderJoinLeaveThread.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderJoinLeaveThread$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onClicked.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderJoinLeaveThread(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(Function0<Unit> onClicked, boolean isThreadJoined) {
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        LinearLayout linearLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        Context context = linearLayout.getContext();
        this.binding.a.setOnClickListener(new AnonymousClass1(onClicked));
        if (isThreadJoined) {
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
            textView.setText(context.getString(R.string.leave_thread));
            ImageView imageView = this.binding.f2258b;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_exit_to_app, 0, 2, (Object) null));
            ImageView imageView2 = this.binding.f2258b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemAddOrLeave");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, R.attr.colorTextDanger)));
            return;
        }
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelMembersListItemAddOrLeaveTitle");
        textView2.setText(context.getString(R.string.join_thread));
        ImageView imageView3 = this.binding.f2258b;
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        imageView3.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_person_add, 0, 2, (Object) null));
        ImageView imageView4 = this.binding.f2258b;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.channelMembersListItemAddOrLeave");
        imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, R.attr.colorInteractiveNormal)));
    }
}
