package com.discord.widgets.settings.premium;

import android.content.Context;
import com.discord.R;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetOutboundPromoTerms.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R6\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/discord/widgets/settings/premium/WidgetOutboundPromoTerms$renderContext$1", "Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", "", "linkColorAttrResId", "I", "getLinkColorAttrResId", "()I", "Lkotlin/Function1;", "", "", "onLongPressUrl", "Lkotlin/jvm/functions/Function1;", "getOnLongPressUrl", "()Lkotlin/jvm/functions/Function1;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lkotlin/Function3;", "onClickUrl", "Lkotlin/jvm/functions/Function3;", "getOnClickUrl", "()Lkotlin/jvm/functions/Function3;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$renderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms3 implements UrlNode.RenderContext {
    private final Context context;
    private final int linkColorAttrResId;
    private final Function3<Context, String, String, Unit> onClickUrl = WidgetOutboundPromoTerms4.INSTANCE;
    private final Function1<String, Unit> onLongPressUrl;
    public final /* synthetic */ WidgetOutboundPromoTerms this$0;

    public WidgetOutboundPromoTerms3(WidgetOutboundPromoTerms widgetOutboundPromoTerms) {
        this.this$0 = widgetOutboundPromoTerms;
        Context contextRequireContext = widgetOutboundPromoTerms.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.context = contextRequireContext;
        this.linkColorAttrResId = R.attr.colorTextLink;
        this.onLongPressUrl = WidgetOutboundPromoTerms5.INSTANCE;
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
        return this.onClickUrl;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public Function1<String, Unit> getOnLongPressUrl() {
        return this.onLongPressUrl;
    }
}
