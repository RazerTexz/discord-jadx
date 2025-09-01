package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.ViewAppcommandsOptionheadingListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SelectedApplicationCommandAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/input/applicationcommands/SelectedAppCommandSectionHeadingAdapterItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter;", "Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandItem;)V", "Lcom/discord/databinding/ViewAppcommandsOptionheadingListitemBinding;", "binding", "Lcom/discord/databinding/ViewAppcommandsOptionheadingListitemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandSectionHeadingAdapterItem, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter4 extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandAdapter8> {
    private final ViewAppcommandsOptionheadingListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter4(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(R.layout.view_appcommands_optionheading_listitem, selectedApplicationCommandAdapter);
        Intrinsics3.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.appcommands_optionheading_title;
        TextView textView = (TextView) view.findViewById(R.id.appcommands_optionheading_title);
        if (textView != null) {
            i = R.id.divider;
            View viewFindViewById = view.findViewById(R.id.divider);
            if (viewFindViewById != null) {
                ViewAppcommandsOptionheadingListitemBinding viewAppcommandsOptionheadingListitemBinding = new ViewAppcommandsOptionheadingListitemBinding((ConstraintLayout) view, textView, viewFindViewById);
                Intrinsics3.checkNotNullExpressionValue(viewAppcommandsOptionheadingListitemBinding, "ViewAppcommandsOptionhea…temBinding.bind(itemView)");
                this.binding = viewAppcommandsOptionheadingListitemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SelectedApplicationCommandAdapter8 selectedApplicationCommandAdapter8) {
        onConfigure2(i, selectedApplicationCommandAdapter8);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SelectedApplicationCommandAdapter8 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        TextView textView = this.binding.f2171b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.appcommandsOptionheadingTitle");
        textView.setText(data.getHeading());
    }
}
