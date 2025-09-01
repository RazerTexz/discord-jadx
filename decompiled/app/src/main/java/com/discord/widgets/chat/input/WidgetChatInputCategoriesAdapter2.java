package com.discord.widgets.chat.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;
import com.discord.R;
import com.discord.databinding.CommandCategoryItemBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatInputCategoriesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00060\tj\u0002`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010 R.\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/discord/widgets/chat/input/ChatInputApplicationsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/chat/input/ApplicationCategoryViewHolder;", "", "Lcom/discord/models/commands/Application;", "data", "", "setApplicationData", "(Ljava/util/List;)V", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "selectApplication", "(J)V", "", "getPositionOfApplication", "(J)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/chat/input/ApplicationCategoryViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onBindViewHolder", "(Lcom/discord/widgets/chat/input/ApplicationCategoryViewHolder;I)V", "getItemCount", "()I", "getItemId", "(I)J", "selectedApplication", "J", "Ljava/util/List;", "Lkotlin/Function1;", "onClickApplication", "Lkotlin/jvm/functions/Function1;", "getOnClickApplication", "()Lkotlin/jvm/functions/Function1;", "setOnClickApplication", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.ChatInputApplicationsAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatInputCategoriesAdapter2 extends RecyclerView.Adapter<WidgetChatInputCategoriesAdapter> {
    private List<Application> data = Collections2.emptyList();
    public Function1<? super Application, Unit> onClickApplication;
    private long selectedApplication;

    public WidgetChatInputCategoriesAdapter2() {
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.data.get(position).getId();
    }

    public final Function1<Application, Unit> getOnClickApplication() {
        Function1 function1 = this.onClickApplication;
        if (function1 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("onClickApplication");
        }
        return function1;
    }

    public final int getPositionOfApplication(long applicationId) {
        Iterator<Application> it = this.data.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getId() == applicationId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetChatInputCategoriesAdapter) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void selectApplication(long applicationId) {
        if (this.selectedApplication != applicationId) {
            this.selectedApplication = applicationId;
            notifyDataSetChanged();
        }
    }

    public final void setApplicationData(List<Application> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    public final void setOnClickApplication(Function1<? super Application, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickApplication = function1;
    }

    public void onBindViewHolder(WidgetChatInputCategoriesAdapter holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position), this.selectedApplication == this.data.get(position).getId());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetChatInputCategoriesAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.command_category_item, parent, false);
        int i = R.id.command_category_item_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.command_category_item_icon);
        if (simpleDraweeView != null) {
            i = R.id.overline;
            View viewFindViewById = viewInflate.findViewById(R.id.overline);
            if (viewFindViewById != null) {
                CommandCategoryItemBinding commandCategoryItemBinding = new CommandCategoryItemBinding((FrameLayout) viewInflate, simpleDraweeView, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById, viewFindViewById));
                Intrinsics3.checkNotNullExpressionValue(commandCategoryItemBinding, "CommandCategoryItemBindi…tInflater, parent, false)");
                Function1<? super Application, Unit> function1 = this.onClickApplication;
                if (function1 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("onClickApplication");
                }
                return new WidgetChatInputCategoriesAdapter(commandCategoryItemBinding, function1);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
