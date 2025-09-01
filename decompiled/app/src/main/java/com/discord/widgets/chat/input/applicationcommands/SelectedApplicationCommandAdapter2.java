package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.ViewAppcommandsOptionparamListitemBinding;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SelectedApplicationCommandAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/input/applicationcommands/SelectedAppCommandOptionAdapterItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter;", "Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandItem;)V", "Lcom/discord/databinding/ViewAppcommandsOptionparamListitemBinding;", "binding", "Lcom/discord/databinding/ViewAppcommandsOptionparamListitemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandOptionAdapterItem, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter2 extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandAdapter8> {
    private final ViewAppcommandsOptionparamListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter2(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(R.layout.view_appcommands_optionparam_listitem, selectedApplicationCommandAdapter);
        Intrinsics3.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R.id.appcommands_optiontitle_title);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.appcommands_optiontitle_title)));
        }
        ViewAppcommandsOptionparamListitemBinding viewAppcommandsOptionparamListitemBinding = new ViewAppcommandsOptionparamListitemBinding((FrameLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(viewAppcommandsOptionparamListitemBinding, "ViewAppcommandsOptionpar…temBinding.bind(itemView)");
        this.binding = viewAppcommandsOptionparamListitemBinding;
    }

    public static final /* synthetic */ SelectedApplicationCommandAdapter access$getAdapter$p(SelectedApplicationCommandAdapter2 selectedApplicationCommandAdapter2) {
        return (SelectedApplicationCommandAdapter) selectedApplicationCommandAdapter2.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SelectedApplicationCommandAdapter8 selectedApplicationCommandAdapter8) {
        onConfigure2(i, selectedApplicationCommandAdapter8);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SelectedApplicationCommandAdapter8 data) {
        int themedColor;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        ApplicationCommandOption option = data.getOption();
        if (option != null) {
            TextView textView = this.binding.f2172b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.appcommandsOptiontitleTitle");
            textView.setText(option.getName());
            int i = data.getHighlighted() ? R.drawable.drawable_bg_command_param_highlight : R.drawable.drawable_bg_command_param_normal;
            if (data.getHighlighted()) {
                TextView textView2 = this.binding.f2172b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getThemedColor(textView2, R.attr.colorHeaderPrimary);
            } else if (data.getError()) {
                TextView textView3 = this.binding.f2172b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getColor(textView3, R.color.status_red_500);
            } else {
                TextView textView4 = this.binding.f2172b;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getThemedColor(textView4, R.attr.colorHeaderPrimary);
            }
            if (!data.getCompleted() || data.getHighlighted()) {
                TextView textView5 = this.binding.f2172b;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.appcommandsOptiontitleTitle");
                textView5.setAlpha(1.0f);
            } else {
                TextView textView6 = this.binding.f2172b;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.appcommandsOptiontitleTitle");
                textView6.setAlpha(0.5f);
            }
            this.binding.f2172b.setBackgroundResource(i);
            this.binding.f2172b.setTextColor(themedColor);
            this.itemView.setOnClickListener(new SelectedApplicationCommandAdapter3(option, this, data));
        }
    }
}
