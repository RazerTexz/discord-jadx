package com.discord.widgets.nux;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.NuxGuildTemplateTextViewHolderBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildTemplateViewHolders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateTextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/databinding/NuxGuildTemplateTextViewHolderBinding;", "binding", "Lcom/discord/databinding/NuxGuildTemplateTextViewHolderBinding;", "getBinding", "()Lcom/discord/databinding/NuxGuildTemplateTextViewHolderBinding;", "<init>", "(Lcom/discord/databinding/NuxGuildTemplateTextViewHolderBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.GuildTemplateTextViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildTemplateViewHolders2 extends RecyclerView.ViewHolder {
    private final NuxGuildTemplateTextViewHolderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateViewHolders2(NuxGuildTemplateTextViewHolderBinding nuxGuildTemplateTextViewHolderBinding) {
        super(nuxGuildTemplateTextViewHolderBinding.a);
        Intrinsics3.checkNotNullParameter(nuxGuildTemplateTextViewHolderBinding, "binding");
        this.binding = nuxGuildTemplateTextViewHolderBinding;
    }

    public final NuxGuildTemplateTextViewHolderBinding getBinding() {
        return this.binding;
    }
}
