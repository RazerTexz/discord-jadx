package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import b.a.t.b.a.TextNode;
import com.discord.R;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.utilities.color.ColorCompat;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EditedMessageNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\bB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EditedMessageNode;", "RC", "Lcom/discord/simpleast/core/node/StyleNode;", "Landroid/text/style/CharacterStyle;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EditedMessageNode<RC> extends StyleNode<RC, CharacterStyle> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: EditedMessageNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EditedMessageNode$Companion;", "", "", "relativeSize", "Landroid/text/style/RelativeSizeSpan;", "getRelativeSizeSpan", "(F)Landroid/text/style/RelativeSizeSpan;", "Landroid/content/Context;", "context", "Landroid/text/style/ForegroundColorSpan;", "getForegroundColorSpan", "(Landroid/content/Context;)Landroid/text/style/ForegroundColorSpan;", "", "getEditedString", "(Landroid/content/Context;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ ForegroundColorSpan access$getForegroundColorSpan(Companion companion, Context context) {
            return companion.getForegroundColorSpan(context);
        }

        private final ForegroundColorSpan getForegroundColorSpan(Context context) {
            return new ForegroundColorSpan(ColorCompat.getThemedColor(context, R.attr.colorTextMuted));
        }

        private final RelativeSizeSpan getRelativeSizeSpan(float relativeSize) {
            return new RelativeSizeSpan(relativeSize);
        }

        public static /* synthetic */ RelativeSizeSpan getRelativeSizeSpan$default(Companion companion, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = 0.75f;
            }
            return companion.getRelativeSizeSpan(f);
        }

        public final String getEditedString(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            String string = context.getString(R.string.message_edited);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.message_edited)");
            return " (" + string + ')';
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EditedMessageNode(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        super(Collections2.listOf(Companion.getRelativeSizeSpan$default(companion, 0.0f, 1, null), Companion.access$getForegroundColorSpan(companion, context)));
        addChild(new TextNode(companion.getEditedString(context)));
    }
}
