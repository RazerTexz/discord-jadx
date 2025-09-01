package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ChannelMembersListViewHolderAdd.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListViewHolderAdd;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function0;", "", "onClicked", "", "title", "bind", "(Lkotlin/jvm/functions/Function0;I)V", "Lcom/discord/databinding/WidgetChannelMembersListItemAddOrLeaveBinding;", "binding", "Lcom/discord/databinding/WidgetChannelMembersListItemAddOrLeaveBinding;", "<init>", "(Lcom/discord/databinding/WidgetChannelMembersListItemAddOrLeaveBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderAdd extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* compiled from: ChannelMembersListViewHolderAdd.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderAdd$bind$1, reason: invalid class name */
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
    public ChannelMembersListViewHolderAdd(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(Function0<Unit> onClicked, @StringRes int title) {
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
        LinearLayout linearLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        textView.setText(linearLayout.getContext().getText(title));
        this.binding.f2258b.setImageResource(R.drawable.ic_add_person_16dp);
        this.binding.a.setOnClickListener(new AnonymousClass1(onClicked));
    }
}
