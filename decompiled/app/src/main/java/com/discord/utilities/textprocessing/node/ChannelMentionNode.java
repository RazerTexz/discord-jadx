package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.ChannelMentionNode.RenderContext;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ChannelMentionNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0017B\u0013\u0012\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/textprocessing/node/ChannelMentionNode;", "Lcom/discord/utilities/textprocessing/node/ChannelMentionNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/ChannelMentionNode$RenderContext;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "<init>", "(J)V", "RenderContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMentionNode<T extends RenderContext> extends Node<T> {
    private final long channelId;

    /* compiled from: ChannelMentionNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R(\u0010\b\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\r\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/textprocessing/node/ChannelMentionNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "Lkotlin/Function1;", "", "Lcom/discord/primitives/ChannelId;", "", "getChannelMentionOnClick", "()Lkotlin/jvm/functions/Function1;", "channelMentionOnClick", "", "", "getChannelNames", "()Ljava/util/Map;", "channelNames", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface RenderContext extends BasicRenderContext {
        Function1<Long, Unit> getChannelMentionOnClick();

        Map<Long, String> getChannelNames();
    }

    /* compiled from: ChannelMentionNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/textprocessing/node/ChannelMentionNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.node.ChannelMentionNode$render$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$onClick.invoke(Long.valueOf(ChannelMentionNode.this.getChannelId()));
        }
    }

    public ChannelMentionNode(long j) {
        super(null, 1, null);
        this.channelId = j;
    }

    public boolean equals(Object other) {
        return (other instanceof ChannelMentionNode) && ((ChannelMentionNode) other).channelId == this.channelId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        String str;
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new StyleSpan(1));
        Map<Long, String> channelNames = renderContext.getChannelNames();
        if (channelNames == null || (str = channelNames.get(Long.valueOf(this.channelId))) == null) {
            str = "deleted-channel";
        }
        Function1<Long, Unit> channelMentionOnClick = renderContext.getChannelMentionOnClick();
        if (channelMentionOnClick != null) {
            arrayList.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, R.attr.theme_chat_mention_foreground)), false, null, new AnonymousClass1(channelMentionOnClick), 4, null));
        } else {
            arrayList.add(new ForegroundColorSpan(ColorCompat.getThemedColor(context, R.attr.theme_chat_mention_foreground)));
        }
        arrayList.add(new BackgroundColorSpan(ColorCompat.getThemedColor(context, R.attr.theme_chat_mention_background)));
        StringBuilder sb = new StringBuilder();
        Intrinsics3.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_GUILD");
        sb.append("#");
        sb.append(str);
        builder.append((CharSequence) sb.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.setSpan((CharacterStyle) it.next(), length, builder.length(), 33);
        }
    }
}
