package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.annotation.AttrRes;
import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.textprocessing.node.UrlNode.RenderContext;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UrlNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0012B\u001b\u0012\u0006\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/textprocessing/node/UrlNode;", "Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;)V", "", "mask", "Ljava/lang/String;", "url", "getUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "RenderContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UrlNode<T extends RenderContext> extends Node<T> {
    private final String mask;
    private final String url;

    /* compiled from: UrlNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R0\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "Lkotlin/Function3;", "Landroid/content/Context;", "", "", "getOnClickUrl", "()Lkotlin/jvm/functions/Function3;", "onClickUrl", "Lkotlin/Function1;", "getOnLongPressUrl", "()Lkotlin/jvm/functions/Function1;", "onLongPressUrl", "", "getLinkColorAttrResId", "()I", "linkColorAttrResId", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface RenderContext extends BasicRenderContext {
        @AttrRes
        int getLinkColorAttrResId();

        Function3<Context, String, String, Unit> getOnClickUrl();

        Function1<String, Unit> getOnLongPressUrl();
    }

    public /* synthetic */ UrlNode(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public static final /* synthetic */ String access$getMask$p(UrlNode urlNode) {
        return urlNode.mask;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode(String str, String str2) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(str, "url");
        this.url = str;
        this.mask = str2;
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        try {
            String punyCodeASCIIUrl = StringUtils2.toPunyCodeASCIIUrl(this.url);
            Object clickableSpan = new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(renderContext.getContext(), renderContext.getLinkColorAttrResId())), false, new UrlNode2(renderContext, punyCodeASCIIUrl), new UrlNode3(this, renderContext, punyCodeASCIIUrl));
            int length = builder.length();
            String str = this.mask;
            if (str != null) {
                punyCodeASCIIUrl = str;
            }
            builder.append((CharSequence) punyCodeASCIIUrl);
            builder.setSpan(clickableSpan, length, builder.length(), 33);
        } catch (Exception unused) {
            builder.append(this.url);
        }
    }
}
