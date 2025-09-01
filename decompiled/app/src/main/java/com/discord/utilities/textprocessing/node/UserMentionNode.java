package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.UserMentionNode.RenderContext;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserMentionNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\u001d\u001eB\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\b\u0002\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\u00060\u0015j\u0002`\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/textprocessing/node/UserMentionNode;", "Lcom/discord/utilities/textprocessing/node/UserMentionNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "renderUserMention", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/UserMentionNode$RenderContext;)V", "render", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/textprocessing/node/UserMentionNode$Type;", "type", "Lcom/discord/utilities/textprocessing/node/UserMentionNode$Type;", "getType", "()Lcom/discord/utilities/textprocessing/node/UserMentionNode$Type;", "", "Lcom/discord/primitives/UserId;", "userId", "J", "getUserId", "()J", "<init>", "(Lcom/discord/utilities/textprocessing/node/UserMentionNode$Type;J)V", "RenderContext", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UserMentionNode<T extends RenderContext> extends Node<T> {
    private final Type type;
    private final long userId;

    /* compiled from: UserMentionNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR(\u0010\u0014\u001a\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/textprocessing/node/UserMentionNode$RenderContext;", "", "", "Lcom/discord/primitives/UserId;", "getMyId", "()J", "myId", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "", "getUserNames", "()Ljava/util/Map;", "userNames", "Lkotlin/Function1;", "", "getUserMentionOnClick", "()Lkotlin/jvm/functions/Function1;", "userMentionOnClick", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface RenderContext {
        Context getContext();

        long getMyId();

        Function1<Long, Unit> getUserMentionOnClick();

        Map<Long, String> getUserNames();
    }

    /* compiled from: UserMentionNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/textprocessing/node/UserMentionNode$Type;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "HERE", "EVERYONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        USER,
        HERE,
        EVERYONE
    }

    /* compiled from: UserMentionNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/textprocessing/node/UserMentionNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.node.UserMentionNode$renderUserMention$1, reason: invalid class name */
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
            this.$onClick.invoke(Long.valueOf(UserMentionNode.this.getUserId()));
        }
    }

    public /* synthetic */ UserMentionNode(Type type, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, (i & 2) != 0 ? -1L : j);
    }

    private final void renderUserMention(SpannableStringBuilder builder, T renderContext) {
        String str;
        Map<Long, String> userNames = renderContext.getUserNames();
        Context context = renderContext.getContext();
        int length = builder.length();
        boolean zContainsKey = userNames != null ? userNames.containsKey(Long.valueOf(this.userId)) : false;
        StringBuilder sbU = outline.U("@");
        if (userNames == null || (str = userNames.get(Long.valueOf(this.userId))) == null) {
            str = "invalid-user";
        }
        sbU.append(str);
        String string = sbU.toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StyleSpan(1));
        arrayList.add(new BackgroundColorSpan(ColorCompat.getThemedColor(context, R.attr.theme_chat_mention_background)));
        Function1<Long, Unit> userMentionOnClick = renderContext.getUserMentionOnClick();
        if (!zContainsKey || userMentionOnClick == null) {
            arrayList.add(new ForegroundColorSpan(ColorCompat.getThemedColor(context, R.attr.theme_chat_mention_foreground)));
        } else {
            arrayList.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, R.attr.theme_chat_mention_foreground)), false, null, new AnonymousClass1(userMentionOnClick), 4, null));
        }
        builder.append((CharSequence) string);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.setSpan((CharacterStyle) it.next(), length, builder.length(), 33);
        }
    }

    public boolean equals(Object other) {
        return (other instanceof UserMentionNode) && ((UserMentionNode) other).userId == this.userId;
    }

    public final Type getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMentionNode(Type type, long j) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(type, "type");
        this.type = type;
        this.userId = j;
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        if (this.type == Type.USER) {
            renderUserMention(builder, renderContext);
            return;
        }
        List listListOf = Collections2.listOf(new StyleSpan(1), new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_mention_background)), new ForegroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_mention_foreground)));
        int length = builder.length();
        builder.append((CharSequence) (this.type == Type.HERE ? "@here" : "@everyone"));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
