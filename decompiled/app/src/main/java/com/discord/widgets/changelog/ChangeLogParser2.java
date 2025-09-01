package com.discord.widgets.changelog;

import android.content.Context;
import com.discord.R;
import com.discord.utilities.textprocessing.node.UrlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: ChangeLogParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R0\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"com/discord/widgets/changelog/ChangeLogParser$parse$renderContext$1", "Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", "Lkotlin/Function3;", "Landroid/content/Context;", "", "", "getOnClickUrl", "()Lkotlin/jvm/functions/Function3;", "onClickUrl", "Lkotlin/Function1;", "onLongPressUrl", "Lkotlin/jvm/functions/Function1;", "getOnLongPressUrl", "()Lkotlin/jvm/functions/Function1;", "", "linkColorAttrResId", "I", "getLinkColorAttrResId", "()I", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.changelog.ChangeLogParser$parse$renderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChangeLogParser2 implements UrlNode.RenderContext {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Function3 $onClickListener;
    private final Context context;
    private final int linkColorAttrResId = R.attr.colorTextLink;
    private final Function1<String, Unit> onLongPressUrl = new ChangeLogParser3(this);

    public ChangeLogParser2(Function3 function3, Context context) {
        this.$onClickListener = function3;
        this.$context = context;
        this.context = context;
    }

    @Override // com.discord.utilities.textprocessing.node.BasicRenderContext, com.discord.utilities.textprocessing.node.UserMentionNode.RenderContext, com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public int getLinkColorAttrResId() {
        return this.linkColorAttrResId;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public Function3<Context, String, String, Unit> getOnClickUrl() {
        return this.$onClickListener;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public Function1<String, Unit> getOnLongPressUrl() {
        return this.onLongPressUrl;
    }
}
